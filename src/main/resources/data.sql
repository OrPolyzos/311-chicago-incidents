--Users
-- insert into chicago_service_requests.users (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, ROLE, USERNAME) VALUES ('administrator@gmail.com', 'John', 'Doe', 'a', 'ADMIN', 'a');
-- insert into chicago_service_requests.users (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD, ROLE, USERNAME) VALUES ('simpleuser@gmail.com', 'Jane', 'Doe', 's', 'USER', 's');
SELECT FROM chicago_service_requests.users;

-- Service Requests
-- Stored Procedures/Functions
-- Stored Function _ 1
CREATE OR REPLACE FUNCTION chicago_service_requests.get_total_requests_per_type_in_range
(in startDate timestamp without time zone,
in endDate timestamp without time zone)
returns table(r_sr_type varchar, r_sr_count int8)
AS $$
declare
	var_r record;
begin
	for var_r in (select sr_type, count(*) as sr_count
		from chicago_service_requests.service_requests
		where creation_date_time between startDate and endDate
		group by sr_type
		order by sr_count desc)
	loop
		r_sr_type := var_r.sr_type;
		r_sr_count := var_r.sr_count;
	return next;
	end loop;
END; $$
LANGUAGE plpgsql;

