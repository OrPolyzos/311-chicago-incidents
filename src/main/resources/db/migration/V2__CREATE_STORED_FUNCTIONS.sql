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
                     and public.ST_Contains(public.ST_AsText(public.ST_Envelope(('POLYGON((' || input_min_x || ' ' || input_min_y || ', ' || input_min_x || ' ' || input_max_y || ', ' ||input_max_x || ' ' || input_max_y || ', ' || input_max_x || ' ' || input_min_y || ', ' || input_min_x || ' ' || input_min_y || '))'))), public.ST_MakePoint(longitude,latitude))
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

-- Stored Function #6
CREATE OR REPLACE FUNCTION chicago_service_requests.get_top_five_ssa_regards_to_total_number_of_requests_in_range
  (in input_start_date timestamp without time zone,
   in input_end_date timestamp without time zone)
  returns table(out_sr_ssa int8, out_sr_count int8)
AS $$
declare
  sr_record record;
begin
  for sr_record in (
                   select ssa, count(*) as ssa_count from chicago_service_requests.service_requests as t1,
                      (
                      select gc.service_request_id as service_request_id, gc.special_service_area_id as special_service_area_id, ssat.ssa as ssa from chicago_service_requests.garbage_carts as gc, chicago_service_requests.special_service_area as ssat
                      where gc.special_service_area_id = ssat.id
                      union all
                      select ab.service_request_id as service_request_id, ab.special_service_area_id as special_service_area_id, ssat.ssa as ssa from chicago_service_requests.abandoned_vehicle_requests as ab, chicago_service_requests.special_service_area as ssat
                      where ab.special_service_area_id = ssat.id
                      union all
                      select ab.service_request_id as service_request_id, ab.special_service_area_id as special_service_area_id, ssat.ssa as ssa from chicago_service_requests.rodent_baiting_requests as ab, chicago_service_requests.special_service_area as ssat
                      where ab.special_service_area_id = ssat.id
                      --union all
                      --select pt.service_request_id as service_request_id, pt.special_service_area_id as special_service_area_id, ssat.ssa as ssa from chicago_service_requests.pot_holes_requests as pt, chicago_service_requests.special_service_area as ssat
                      --where pt.special_service_area_id = ssat.id
                      --union all
                      --select td.service_request_id as service_request_id, td.special_service_area_id as special_service_area_id, ssat.ssa as ssa from chicago_service_requests.tree_derbis_requests as td, chicago_service_requests.special_service_area as ssat
                      --where td.special_service_area_id = ssat.id
                      --union all
                      --select gr.service_request_id as service_request_id, gr.special_service_area_id as special_service_area_id, ssat.ssa as ssa from chicago_service_requests.tree_derbis_requests as gr, chicago_service_requests.special_service_area as ssat
                      --where gr.special_service_area_id = ssat.id
                      ) as t2
                   where t1.service_request_id = t2.service_request_id
                     and t1.creation_date_time between input_start_date and input_end_date
                   group by ssa
                   order by ssa_count desc
                   limit 5
                   )
  loop
    out_sr_ssa := sr_record.ssa;
    out_sr_count := sr_record.ssa_count;
    return next;
  end loop;
END; $$
LANGUAGE plpgsql;

--drop
--drop function chicago_service_requests.get_top_five_ssa_regards_to_total_number_of_requests_in_range(timestamp without time zone, timestamp without time zone);

--example
--select * from chicago_service_requests.get_top_five_ssa_regards_to_total_number_of_requests_in_range('2011-01-02 00:00:00', now()::timestamp without time zone)


-- Stored function #7
CREATE OR REPLACE FUNCTION chicago_service_requests.get_licence_plates_involved_in_more_than_one_complaints()
  returns table(out_sr_type varchar, out_sr_count int8)
AS $$
declare
  sr_record record;
begin
  for sr_record in (
                   select licence_plate, count(*) as sr_count
                   from chicago_service_requests.abandoned_vehicle_requests
                   group by licence_plate
                   having count(*) > 1
                   )
  loop
    out_sr_type := sr_record.licence_plate;
    out_sr_count := sr_record.sr_count;
    return next;
  end loop;
END; $$
LANGUAGE plpgsql;

--drop
--drop function chicago_service_requests.get_licence_plates_involved_in_more_than_one_complaints()

--example
--select * from chicago_service_requests.get_licence_plates_involved_in_more_than_one_complaints()