-- TODO MAYBE SPLIT INTO SEPARATE FILES
-- Stored Functions
--------------------
-- Stored Function #1
CREATE OR REPLACE FUNCTION chicago_service_requests.get_total_requests_per_type_in_range
  (in input_start_date timestamp without time zone,
   in input_end_date timestamp without time zone)
  returns table(out_sr_type varchar, out_sr_count int8)
AS $$
declare
  sr_record record;
begin
  for sr_record in (select sr_type, count(*) as sr_count
                    from chicago_service_requests.service_requests
                    where creation_date_time between input_start_date and input_end_date
                    group by sr_type
                    order by sr_count desc)
  loop
    out_sr_type := sr_record.sr_type;
    out_sr_count := sr_record.sr_count;
    return next;
  end loop;
END; $$
LANGUAGE plpgsql;

--drop
--drop function chicago_service_requests.get_total_requests_per_type_in_range(timestamp without time zone, timestamp without time zone);

--example
--select * from chicago_service_requests.get_total_requests_per_type_in_range('2011-01-02 00:00:00', now()::timestamp without time zone)

-- Stored Function #2
CREATE OR REPLACE FUNCTION chicago_service_requests.get_total_requests_per_day_for_type_in_range
  (in input_sr_type varchar,
   in input_start_date timestamp without time zone,
   in input_end_date timestamp without time zone)
  returns table(out_sr_day timestamp without time zone, out_sr_count int8)
AS $$
declare
  sr_record record;
begin
  for sr_record in (
                   select date_trunc('day', creation_date_time)::timestamp without time zone as sr_day, count(*) as sr_count
                   from chicago_service_requests.service_requests
                   where sr_type = input_sr_type and creation_date_time between input_start_date and input_end_date
                   group by sr_day)
  loop
    out_sr_day := sr_record.sr_day;
    out_sr_count := sr_record.sr_count;
    return next;
  end loop;
END; $$
LANGUAGE plpgsql;

--drop
--drop function chicago_service_requests.get_total_requests_per_day_for_type_in_range(varchar, timestamp without time zone, timestamp without time zone);

--example
--select * from chicago_service_requests.get_total_requests_per_day_for_type_in_range('Alley Light Out', '2011-01-02 00:00:00', now()::timestamp without time zone)

-- Stored Function #3
CREATE OR REPLACE FUNCTION chicago_service_requests.get_most_common_type_per_zip_code_for_day
  (in input_date timestamp without time zone)
  returns table(out_zip_code int8, out_sr_type varchar, out_sr_count int8)
AS $$
declare
  sr_record record;
begin
  for sr_record in (
                   select outer_table.zip_code, outer_table.sr_type, count(outer_table.sr_type) as occurences
                   from chicago_service_requests.service_requests as outer_table
                   where outer_table.creation_date_time = input_date
                   group by outer_table.sr_type, outer_table.zip_code, outer_table.creation_date_time
                   having outer_table.sr_type =
                          (select inner_table.sr_type
                           from chicago_service_requests.service_requests as inner_table
                           where inner_table.zip_code = outer_table.zip_code and inner_table.creation_date_time = outer_table.creation_date_time
                           group by inner_table.sr_type
                           order by count(*) desc limit 1)
                   )
  loop
    out_zip_code := sr_record.zip_code;
    out_sr_type := sr_record.sr_type;
    out_sr_count := sr_record.occurences;
    return next;
  end loop;
END; $$
LANGUAGE plpgsql;

--drop
--drop function chicago_service_requests.get_most_common_type_per_zip_code_for_day(timestamp without time zone)

--example
--select * from chicago_service_requests.get_most_common_type_per_zip_code_for_day('2011-01-02')

-- Stored function #4
CREATE OR REPLACE FUNCTION chicago_service_requests.get_avg_completion_time_per_type_in_range
  (in input_start_date timestamp without time zone, in input_end_date timestamp without time zone)
  returns table(out_sr_type varchar, out_sr_avg float8)
AS $$
declare
  sr_record record;
begin
  for sr_record in (
                   select sr_type, avg(extract(epoch from (completion_date_time::timestamp - creation_date_time::timestamp))) as sr_avg
                   from chicago_service_requests.service_requests
                   where completion_date_time notnull and creation_date_time between input_start_date and input_end_date
                   group by sr_type
                   )
  loop
    out_sr_type := sr_record.sr_type;
    out_sr_avg := sr_record.sr_avg;
    return next;
  end loop;
END; $$
LANGUAGE plpgsql;

--drop
--drop function chicago_service_requests.get_avg_completion_time_per_type_in_range(timestamp without time zone, timestamp without time zone)

--example
--select * from chicago_service_requests.get_avg_completion_time_per_type_in_range('2011-01-02', now()::timestamp without time zone)

-- Stored function #5
CREATE OR REPLACE FUNCTION chicago_service_requests.get_most_common_type_in_bounding_box_for_day
  (in input_min_x float8,
   in input_min_y float8,
   in input_max_x float8,
   in input_max_y float8,
   in input_date timestamp without time zone)
  returns table(out_sr_type varchar, out_sr_count int8)
AS $$
declare
  sr_record record;
begin
  for sr_record in (
                   select sr_type, count(*) as sr_count from chicago_service_requests.service_requests
                   where input_date = creation_date_time
                     and ST_Contains(ST_AsText(ST_Envelope(('POLYGON((' || input_min_x || ' ' || input_min_y || ', ' || input_min_x || ' ' || input_max_y || ', ' ||input_max_x || ' ' || input_max_y || ', ' || input_max_x || ' ' || input_min_y || ', ' || input_min_x || ' ' || input_min_y || '))'))), ST_MakePoint(longitude,latitude))
                   group by sr_type
                   order by sr_count desc
                   limit 1)
  loop
    out_sr_type := sr_record.sr_type;
    out_sr_count := sr_record.sr_count;
    return next;
  end loop;
END; $$
LANGUAGE plpgsql;

--drop
--drop function chicago_service_requests.get_most_common_type_in_bounding_box_for_day(float8, float8, float8, float8, timestamp without time zone)

--example
--select * from chicago_service_requests.get_most_common_type_in_bounding_box_for_day(35.910956, -90.655866, 45.925597, -85.659015, '2011-01-02')
