INSERT INTO public.role (id, role) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, role) VALUES (DEFAULT, 'coach');


INSERT INTO public."user" (id, role_id, user_name, password, is_active) VALUES (DEFAULT, 2, 'pavel', '123', true);
INSERT INTO public."user" (id, role_id, user_name, password, is_active) VALUES (DEFAULT, 2, 'erlend', '123', true);
INSERT INTO public."user" (id, role_id, user_name, password, is_active) VALUES (DEFAULT, 2, 'kadi', '123', true);
INSERT INTO public."user" (id, role_id, user_name, password, is_active) VALUES (DEFAULT, 1, 'rain', '123', true);


INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'erlend', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'mia', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'marleen', true);
INSERT INTO public.athlete (id, user_id, name, is_active) VALUES (DEFAULT, 1, 'toomas', true);


INSERT INTO public.split_length (id, meters, time_delay) VALUES (DEFAULT, 25, NULL);
INSERT INTO public.split_length (id, meters, time_delay) VALUES (DEFAULT, 50, NULL);
INSERT INTO public.split_length (id, meters, time_delay) VALUES (DEFAULT, 100, NULL);

INSERT INTO public.stroke (id, type) VALUES (DEFAULT, 'Freestyle');
INSERT INTO public.stroke (id, type) VALUES (DEFAULT, 'Backstroke');
INSERT INTO public.stroke (id, type) VALUES (DEFAULT, 'Breaststroke');
INSERT INTO public.stroke (id, type) VALUES (DEFAULT, 'Butterfly');
INSERT INTO public.stroke (id, type) VALUES (DEFAULT, 'Individual medley');