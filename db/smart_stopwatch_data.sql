INSERT INTO public."user" (id, user_name, password) VALUES (DEFAULT, 'kadi', '123');
INSERT INTO public."user" (id, user_name, password) VALUES (DEFAULT, 'erlend', '123');
INSERT INTO public."user" (id, user_name, password) VALUES (DEFAULT, 'pavel', '123');

INSERT INTO public.role (id, role) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, role) VALUES (DEFAULT, 'customer');

INSERT INTO public.user_role (id, role_id, user_id) VALUES (DEFAULT, 1, 1);
INSERT INTO public.user_role (id, role_id, user_id) VALUES (DEFAULT, 1, 2);
INSERT INTO public.user_role (id, role_id, user_id) VALUES (DEFAULT, 2, 3)