INSERT INTO public.role (id, role)
VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, role)
VALUES (DEFAULT, 'customer');


INSERT INTO public."user" (id, user_name, password, role_id)
VALUES (DEFAULT, 'pavel', '123', 2, true);
INSERT INTO public."user" (id, user_name, password, role_id)
VALUES (DEFAULT, 'kadi', '123', 2, true);
INSERT INTO public."user" (id, user_name, password, role_id)
VALUES (DEFAULT, 'erlend', '123', 2, true);
INSERT INTO public."user" (id, user_name, password, role_id)
VALUES (DEFAULT, 'rain', '123', 1, true);


INSERT INTO public.athlete (id, user_id, name)
VALUES (DEFAULT, 1, 'marleen', true);
INSERT INTO public.athlete (id, user_id, name)
VALUES (DEFAULT, 1, 'mia', true);
INSERT INTO public.athlete (id, user_id, name)
VALUES (DEFAULT, 2, 'sander', true);
INSERT INTO public.athlete (id, user_id, name)
VALUES (DEFAULT, 3, 'grete', true);


INSERT INTO public.split_length (id, meters, time_delay)
VALUES (DEFAULT, 25, NULL);
INSERT INTO public.split_length (id, meters, time_delay)
VALUES (DEFAULT, 50, NULL);
INSERT INTO public.split_length (id, meters, time_delay)
VALUES (DEFAULT, 100, NULL);

INSERT INTO public.stroke (id, type)
VALUES (DEFAULT, 'Freestyle');
INSERT INTO public.stroke (id, type)
VALUES (DEFAULT, 'Backstroke');
INSERT INTO public.stroke (id, type)
VALUES (DEFAULT, 'Breaststroke');
INSERT INTO public.stroke (id, type)
VALUES (DEFAULT, 'Butterfly');
INSERT INTO public.stroke (id, type)
VALUES (DEFAULT, 'Individual medley');