INSERT INTO public.role (id, role) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, role) VALUES (DEFAULT, 'customer');


INSERT INTO public."user" (id, user_name, password, role_id) VALUES (DEFAULT, 'pavel', '123', 2);
INSERT INTO public."user" (id, user_name, password, role_id) VALUES (DEFAULT, 'kadi', '123', 2);
INSERT INTO public."user" (id, user_name, password, role_id) VALUES (DEFAULT, 'erlend', '123', 2);
INSERT INTO public."user" (id, user_name, password, role_id) VALUES (DEFAULT, 'rain', '123', 1);


INSERT INTO public.athlete (id, user_id, name) VALUES (DEFAULT, 1, 'marleen');
INSERT INTO public.athlete (id, user_id, name) VALUES (DEFAULT, 1, 'mia');
INSERT INTO public.athlete (id, user_id, name) VALUES (DEFAULT, 2, 'sander');
INSERT INTO public.athlete (id, user_id, name) VALUES (DEFAULT, 3, 'grete');