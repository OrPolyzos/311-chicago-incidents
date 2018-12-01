--Users
-- insert into chicago_service_requests.users (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, ROLE, USERNAME) VALUES ('administrator@gmail.com', 'John', 'Doe', 'a', 'ADMIN', 'a');
-- insert into chicago_service_requests.users (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, ROLE, USERNAME) VALUES ('simpleuser@gmail.com', 'Jane', 'Doe', 's', 'USER', 's');
SELECT FROM chicago_service_requests.users;

--TODO MOVE THESE STORED FUNCTIONS TO FLYWAY SCRIPTS BECAUSE AT THE MOMENT THEY ARE NOT TRIGGERED
--------------------
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
drop function chicago_service_requests.get_total_requests_per_type_in_range(timestamp without time zone, timestamp without time zone);

--example
select * from chicago_service_requests.get_total_requests_per_type_in_range('2011-01-02 00:00:00', now()::timestamp without time zone)

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
drop function chicago_service_requests.get_total_requests_per_day_for_type_in_range(varchar, timestamp without time zone, timestamp without time zone);

--example
select * from chicago_service_requests.get_total_requests_per_day_for_type_in_range('Alley Light Out', '2011-01-02 00:00:00', now()::timestamp without time zone)

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
			order by count(*) desc limit 1))
	loop
		out_zip_code := sr_record.zip_code;
		out_sr_type := sr_record.sr_type;
		out_sr_count := sr_record.occurences;
	return next;
	end loop;
END; $$
LANGUAGE plpgsql;

--drop
drop function chicago_service_requests.get_most_common_type_per_zip_code_for_day(timestamp without time zone)

--example
select * from chicago_service_requests.get_most_common_type_per_zip_code_for_day('2011-01-02')