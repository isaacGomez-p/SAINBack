INSERT INTO public.role (name) VALUES ('ADMIN');
INSERT INTO public.role (name) VALUES ('CLIENTE');
INSERT INTO public.role (name) VALUES ('PROVEEDOR');

INSERT INTO public.questions( description, height, priority, section, status, type)
	VALUES ('Nombre', 1, 1, 0, 'S', 'text');
INSERT INTO public.questions( description, height, priority, section, status, type)
	VALUES ('Edad', 1, 1, 1, 'S', 'number');
INSERT INTO public.questions( description, height, priority, section, status, type)
    	VALUES ('Antecedentes', 1, 2, 1, 'S', 'text');
INSERT INTO public.questions( description, height, priority, section, status, type)
    	VALUES ('Referencia Familiar', 1, 2, 2, 'S', 'text');

INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Nombre'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Nombre'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Nombre'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Edad'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Edad'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Antecedentes'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Antecedentes'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Referencia Familiar'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Referencia Familiar'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));



INSERT INTO public.users(email, identification, lastname, name, password, role_id)
	VALUES ('admin@email.com', '123456789', 'Gomez', 'Armando', 'zFSnAAGxGMc1zGU29apWrQ==', (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.users(email, identification, lastname, name, password, role_id)
    VALUES ('cliente@email.com', '1234567890', 'Prieto', 'Carlos', 'zFSnAAGxGMc1zGU29apWrQ==', (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.users(email, identification, lastname, name, password, role_id)
    VALUES ('proveedor@email.com', '1234567891', 'Gonzales', 'Pedro', 'zFSnAAGxGMc1zGU29apWrQ==', (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.users(email, identification, lastname, name, password, role_id)
    VALUES ('proveedor1@email.com', '1234567892', 'Fernandez', 'Camila', 'zFSnAAGxGMc1zGU29apWrQ==', (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.users(email, identification, lastname, name, password, role_id)
    VALUES ('proveedor2@email.com', '1234567893', 'Rojas', 'Alejandro', 'zFSnAAGxGMc1zGU29apWrQ==', (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));