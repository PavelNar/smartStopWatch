INSERT INTO public.role (id, role) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, role) VALUES (DEFAULT, 'coach');

INSERT INTO public."user" (id, role_id, user_name, password, is_active) VALUES (DEFAULT, 2, 'Pavel', '123', true);
INSERT INTO public."user" (id, role_id, user_name, password, is_active) VALUES (DEFAULT, 2, 'Erlend', '123', true);
INSERT INTO public."user" (id, role_id, user_name, password, is_active) VALUES (DEFAULT, 2, 'Kadi', '123', true);
INSERT INTO public."user" (id, role_id, user_name, password, is_active) VALUES (DEFAULT, 1, 'Rain', '123', true);

INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Erlend', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Pavel', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Kadi', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Jaan', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Kristiina', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Indrek', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Maris', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Katri', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Liisi', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Aliis', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Johan-Paul', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Mai', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Eduard', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Kaur', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'SiimM', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Kaisa', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'SiimT', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'Tarvo', true);

INSERT INTO public.split_length (id, meters, time_delay) VALUES (DEFAULT, 25, NULL);
INSERT INTO public.split_length (id, meters, time_delay) VALUES (DEFAULT, 50, NULL);
INSERT INTO public.split_length (id, meters, time_delay) VALUES (DEFAULT, 100, NULL);

INSERT INTO public.stroke (id, type) VALUES (DEFAULT, 'Freestyle');
INSERT INTO public.stroke (id, type) VALUES (DEFAULT, 'Backstroke');
INSERT INTO public.stroke (id, type) VALUES (DEFAULT, 'Breaststroke');
INSERT INTO public.stroke (id, type) VALUES (DEFAULT, 'Butterfly');
INSERT INTO public.stroke (id, type) VALUES (DEFAULT, 'Individual medley');

-- INSERT INTO public.event (id, user_id, stroke_id, date_time, event_length, split_length_id, number_of_athletes, number_of_heats, number_of_lanes) VALUES (DEFAULT, 1, 1, date '2022-09-28' + time '03:00', 200, 2, 2, 2, 1);
-- INSERT INTO public.event (id, user_id, stroke_id, date_time, event_length, split_length_id, number_of_athletes, number_of_heats, number_of_lanes) VALUES (DEFAULT, 1, 1, date '2022-09-28' + time '03:01', 100, 2, 2, 2, 1);
-- INSERT INTO public.event (id, user_id, stroke_id, date_time, event_length, split_length_id, number_of_athletes, number_of_heats, number_of_lanes) VALUES (DEFAULT, 1, 1, date '2022-09-28' + time '03:02', 300, 2, 2, 2, 1);
-- INSERT INTO public.event (id, user_id, stroke_id, date_time, event_length, split_length_id, number_of_athletes, number_of_heats, number_of_lanes) VALUES (DEFAULT, 1, 1, date '2022-09-28' + time '03:03', 400, 2, 2, 2, 1);
-- INSERT INTO public.event (id, user_id, stroke_id, date_time, event_length, split_length_id, number_of_athletes, number_of_heats, number_of_lanes) VALUES (DEFAULT, 1, 1, date '2022-09-28' + time '03:04', 500, 2, 2, 2, 1);
-- INSERT INTO public.event (id, user_id, stroke_id, date_time, event_length, split_length_id, number_of_athletes, number_of_heats, number_of_lanes) VALUES (DEFAULT, 1, 1, date '2022-09-28' + time '03:05', 600, 2, 2, 2, 1);
--
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 1, 1, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 1, 2, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 2, 1, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 2, 2, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 3, 1, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 3, 2, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 4, 1, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 4, 2, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 5, 1, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 5, 2, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 6, 1, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
-- INSERT INTO public.heat (id, event_id, heat_number, start, "end", has_started, has_finished, is_active) VALUES (DEFAULT, 6, 2, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, true, true);
--
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 2, 2, 100, 1, 1, 1, 1, 1, 50, true);
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 2, 2, 100, 2, 2, 1, 1, 1, 50, true);
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 2, 2, 100, 1, 1, 1, 2, 1, 50, true);
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 2, 2, 100, 3, 2, 1, 2, 1, 50, true);
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 4, 4, 200, 1, 1, 1, 3, 2, 50, true);
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 4, 4, 200, 4, 2, 1, 3, 2, 50, true);
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 4, 4, 200, 2, 1, 1, 4, 1, 50, true);
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 4, 4, 200, 3, 2, 1, 4, 1, 50, true);
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 6, 6, 300, 2, 1, 1, 5, 3, 50, true);
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 6, 6, 300, 4, 2, 1, 5, 3, 50, true);
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 6, 6, 300, 3, 1, 1, 6, 3, 50, true);
-- INSERT INTO public.athlete_event (id, start_time, finish_time, last_split_time, split_counter, split_count_required, event_length, athlete_id, heat_number, lane_number, event_id, stroke_id, split_length, is_active) VALUES (DEFAULT, '2022-09-22 18:55:26.000000', '2022-09-22 18:55:32.000000', '2022-09-22 18:55:33.000000', 6, 6, 300, 4, 2, 1, 6, 3, 50, true);
--
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 1, 1, 1, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 1, 1, 1, 1);
--
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 2, 2, 1, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 2, 2, 1, 2);
--
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 1, 3, 2, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 1, 3, 2, 1);
--
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 3, 4, 2, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 3, 4, 2, 2);
--
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 1, 5, 3, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 1, 5, 3, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:42:00.000000', '2022-09-22 19:43:00.000000', true, 1, 5, 3, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:43:00.000000', '2022-09-22 19:44:00.000000', true, 1, 5, 3, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 4, 6, 3, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 4, 6, 3, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:42:00.000000', '2022-09-22 19:43:00.000000', true, 4, 6, 3, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:43:00.000000', '2022-09-22 19:44:00.000000', true, 4, 6, 3, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 2, 7, 4, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 2, 7, 4, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:42:00.000000', '2022-09-22 19:43:00.000000', true, 2, 7, 4, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:43:00.000000', '2022-09-22 19:44:00.000000', true, 2, 7, 4, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 3, 8, 4, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 3, 8, 4, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:42:00.000000', '2022-09-22 19:43:00.000000', true, 3, 8, 4, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:43:00.000000', '2022-09-22 19:44:00.000000', true, 3, 8, 4, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 2, 9, 5, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 2, 9, 5, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:42:00.000000', '2022-09-22 19:43:00.000000', true, 2, 9, 5, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:43:00.000000', '2022-09-22 19:44:00.000000', true, 2, 9, 5, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:44:00.000000', '2022-09-22 19:45:00.000000', true, 2, 9, 5, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:45:00.000000', '2022-09-22 19:46:00.000000', true, 2, 9, 5, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 4, 10, 5, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 4, 10, 5, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:42:00.000000', '2022-09-22 19:43:00.000000', true, 4, 10, 5, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:43:00.000000', '2022-09-22 19:44:00.000000', true, 4, 10, 5, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:44:00.000000', '2022-09-22 19:45:00.000000', true, 4, 10, 5, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:45:00.000000', '2022-09-22 19:46:00.000000', true, 4, 10, 5, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 3, 11, 6, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 3, 11, 6, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:42:00.000000', '2022-09-22 19:43:00.000000', true, 3, 11, 6, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:43:00.000000', '2022-09-22 19:44:00.000000', true, 3, 11, 6, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:44:00.000000', '2022-09-22 19:45:00.000000', true, 3, 11, 6, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:45:00.000000', '2022-09-22 19:46:00.000000', true, 3, 11, 6, 1);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:40:59.000000', '2022-09-22 19:41:00.000000', true, 4, 12, 6, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:41:00.000000', '2022-09-22 19:42:00.000000', true, 4, 12, 6, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:42:00.000000', '2022-09-22 19:43:00.000000', true, 4, 12, 6, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:43:00.000000', '2022-09-22 19:44:00.000000', true, 4, 12, 6, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:44:00.000000', '2022-09-22 19:45:00.000000', true, 4, 12, 6, 2);
-- INSERT INTO public.split (id, start, "end", is_active, athlete_id, athlete_event_id, event_id, heat_number) VALUES (DEFAULT, '2022-09-22 19:45:00.000000', '2022-09-22 19:46:00.000000', true, 4, 12, 6, 2);
--
