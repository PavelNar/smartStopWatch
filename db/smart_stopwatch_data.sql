INSERT INTO public.role (id, role) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, role) VALUES (DEFAULT, 'customer');


INSERT INTO public."user" (id, user_name, password, role_id) VALUES (DEFAULT, 'pavel', '123', 2);
INSERT INTO public."user" (id, user_name, password, role_id) VALUES (DEFAULT, 'kadi', '123', 2);
INSERT INTO public."user" (id, user_name, password, role_id) VALUES (DEFAULT, 'erlend', '123', 2);
