INSERT INTO public.role (name) VALUES ('ADMIN');
INSERT INTO public.role (name) VALUES ('CLIENTE');
INSERT INTO public.role (name) VALUES ('PROVEEDOR');
--ANTECEDENTES
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
	VALUES ('Penales o Judiciales', 1, 1, 0, 'S', 'text','ABC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
	VALUES ('Disciplinarios', 1, 1, 0, 'S', 'text','ABC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
	VALUES ('Fiscales', 1, 1, 0, 'S', 'text','ABC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
	VALUES ('Tributarios', 1, 1, 0, 'S', 'text', 'ABC');

--LISTAS RESTRICTIVAS
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
        VALUES ('Lista Clinton', 1, 1, 1, 'S', 'number','ABC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
        VALUES ('Listas de la ONU', 1, 1, 1, 'S', 'number', 'ABC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
        VALUES ('Listas de Terroristas de Estados Unidos y de la Unión Europea', 1, 1, 1, 'S', 'number', 'ABC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
        VALUES ('Lista de Interpol', 1, 1, 1, 'S', 'number', 'ABC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
        VALUES ('Sanciones del Banco Mundial', 1, 1, 1, 'S', 'number', 'ABC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
        VALUES ('Lista de la Administración para el Control de Drogas', 1, 1, 1, 'S', 'number', 'ABC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
        VALUES ('Lista del FBI', 1, 1, 1, 'S', 'number', 'ABC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
        VALUES ('Contraloría General de la Nación', 1, 1, 1, 'S', 'number', 'ABC');

--REFERENCIACION LABORAL
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
    	VALUES ('Último Trabajo', 1, 2, 2, 'S', 'text', 'BC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
    	VALUES ('Penúltimo Trabajo', 1, 2, 2, 'S', 'text', 'BC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
    	VALUES ('Antepenúltimo Trabajo', 1, 2, 2, 'S', 'text', 'BC');

--REFERENCIACION ACADEMICA
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
    	VALUES ('Estudios Secundarios', 1, 3, 3, 'S', 'text','BC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
    	VALUES ('Estudios Profesionales', 1, 3, 3, 'S', 'text','BC');
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
    	VALUES ('Especializaciones', 1, 3, 3, 'S', 'text','BC');

--VISITA DOMICILIARIA VIRTUAL
INSERT INTO public.questions( description, height, priority, section, status, type, profiles)
    	VALUES ('Visita Domiciliaria Virtual', 1, 4, 4, 'S', 'text', 'C');

INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Penales o Judiciales'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Penales o Judiciales'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Penales o Judiciales'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Disciplinarios'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Disciplinarios'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Disciplinarios'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Fiscales'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Fiscales'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Fiscales'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Tributarios'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Tributarios'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Tributarios'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista Clinton'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista Clinton'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista Clinton'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Listas de la ONU'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Listas de la ONU'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Listas de la ONU'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Listas de Terroristas de Estados Unidos y de la Unión Europea'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Listas de Terroristas de Estados Unidos y de la Unión Europea'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Listas de Terroristas de Estados Unidos y de la Unión Europea'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista de Interpol'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista de Interpol'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista de Interpol'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Sanciones del Banco Mundial'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Sanciones del Banco Mundial'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Sanciones del Banco Mundial'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista de la Administración para el Control de Drogas'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista de la Administración para el Control de Drogas'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista de la Administración para el Control de Drogas'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista del FBI'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista del FBI'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Lista del FBI'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Contraloría General de la Nación'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Contraloría General de la Nación'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Contraloría General de la Nación'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Pasantía'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Pasantía'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Pasantía'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Sin Experiencia Laboral'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Sin Experiencia Laboral'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Sin Experiencia Laboral'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Último Trabajo'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Último Trabajo'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Último Trabajo'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Penúltimo Trabajo'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Penúltimo Trabajo'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Penúltimo Trabajo'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Antepenúltimo Trabajo'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Antepenúltimo Trabajo'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Antepenúltimo Trabajo'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Estudios Secundarios'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Estudios Secundarios'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Estudios Secundarios'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Estudios Profesionales'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Estudios Profesionales'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Estudios Profesionales'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Especializaciones'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Especializaciones'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Especializaciones'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Visita Domiciliaria Virtual'), (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Visita Domiciliaria Virtual'), (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.question_roles(question_id, role_id)	VALUES ((SELECT question_id FROM questions WHERE description = 'Visita Domiciliaria Virtual'), (SELECT role_id FROM role WHERE name = 'CLIENTE'));


INSERT INTO public.users(email, identification, lastname, name, password, role_id)
	VALUES ('admin@email.com', '123456789', 'Gomez', 'Armando', 'zFSnAAGxGMc1zGU29apWrQ==', (SELECT role_id FROM role WHERE name = 'ADMIN'));
INSERT INTO public.users(email, identification, lastname, name, password, role_id)
    VALUES ('cliente@email.com', '1234567890', 'Prieto', 'Carlos', 'zFSnAAGxGMc1zGU29apWrQ==', (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.users(email, identification, lastname, name, password, role_id)
    VALUES ('patorres@indracompany.com', '1234567811', 'Torres', 'Pilar', '6HF8WI8zzA0JAXDrHFEIeA==', (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.users(email, identification, lastname, name, password, role_id)
    VALUES ('contratacionrrhh@indracompany.com', '1234567812', 'Ramirez', 'Carolina', 'p5wcBvbJnCh5l174R9e+Ew==', (SELECT role_id FROM role WHERE name = 'CLIENTE'));
INSERT INTO public.users(email, identification, lastname, name, password, role_id)
    VALUES ('proveedor@email.com', '1234567891', 'Gonzales', 'Pedro', 'zFSnAAGxGMc1zGU29apWrQ==', (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.users(email, identification, lastname, name, password, role_id)
    VALUES ('jezzikamorales.psicologa@gmail.com', '1234567892', 'Morales', 'Jezzika', 'L5uaaOB2IFDwSlzjyGQmALqx7IygltRv', (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));
INSERT INTO public.users(email, identification, lastname, name, password, role_id)
    VALUES ('adminpruebas.eyedetect@protmark.com.co', '1234567893', 'Pruebas', 'AdminP', 'ciAsr8dM4p9oxh8EqTotwSUbtKmJT6AB', (SELECT role_id FROM role WHERE name = 'PROVEEDOR'));