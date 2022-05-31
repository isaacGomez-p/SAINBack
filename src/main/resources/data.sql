INSERT INTO public.questions( description, height, priority, section, status, type)
	VALUES ('Nombre', 1, 1, 0, 'S', 'text');
INSERT INTO public.questions( description, height, priority, section, status, type)
    	VALUES ('Centro de costo', 1, 1, 0, 'S', 'text');
INSERT INTO public.questions( description, height, priority, section, status, type)
    	VALUES ('Unidad de negocio', 1, 1, 0, 'S', 'text');
INSERT INTO public.questions( description, height, priority, section, status, type)
	VALUES ('Edad', 1, 1, 1, 'S', 'number');
INSERT INTO public.questions( description, height, priority, section, status, type)
    	VALUES ('Antecedentes', 1, 2, 1, 'S', 'text');
INSERT INTO public.questions( description, height, priority, section, status, type)
    	VALUES ('Referencia Familiar', 1, 2, 2, 'S', 'text');

INSERT INTO public.users(email, identification, lastname, name, password, role)
	VALUES ('admin@email.com', '123456789', 'Gomez', 'Armando', 'zFSnAAGxGMc1zGU29apWrQ==', 1);
INSERT INTO public.users(email, identification, lastname, name, password, role)
    VALUES ('cliente@email.com', '1234567890', 'Prieto', 'Carlos', 'zFSnAAGxGMc1zGU29apWrQ==', 2);
INSERT INTO public.users(email, identification, lastname, name, password, role)
    VALUES ('proveedor@email.com', '1234567891', 'Gonzales', 'Pedro', 'zFSnAAGxGMc1zGU29apWrQ==', 3);
INSERT INTO public.users(email, identification, lastname, name, password, role)
    VALUES ('proveedor1@email.com', '1234567892', 'Fernandez', 'Camila', 'zFSnAAGxGMc1zGU29apWrQ==', 3);
INSERT INTO public.users(email, identification, lastname, name, password, role)
    VALUES ('proveedor2@email.com', '1234567893', 'Rojas', 'Alejandro', 'zFSnAAGxGMc1zGU29apWrQ==', 3);