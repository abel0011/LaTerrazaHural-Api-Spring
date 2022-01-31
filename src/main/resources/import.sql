USE laterraza

-- ROLES
INSERT INTO laterraza.roles (date_created, date_updated, description) VALUES ('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'ADMINISTRATOR');
INSERT INTO laterraza.roles (date_created, date_updated, description) VALUES ('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'COMENSAL');
-- END ROLES                                                                            

-- PERSON
INSERT INTO laterraza.person (active, birth_name, date_created, date_of_birth, date_updated, dni, first_name, last_name, middle_name, phone, id_role) VALUES('A', 'DRAPER', '2021-10-09 10:00:00', '2021-10-02', '2021-10-09 10:00:00', '77711234', 'JOHN', 'THOMAS', 'THOMAS', '123456789', 2);
-- INSERT INTO laterraza.person (active, birth_name, date_created, date_of_birth, date_updated, dni, first_name, last_name, middle_name, phone, id_role) VALUES ('A','PEREZ','2022-01-26 15:18:11.281000000','2021-12-11','2022-01-26 15:18:11.281000000','12345621','DANIELA','RUIZ','JENIFER','987654211',2)
-- END PERSON

-- USERS
--IDAT123 12345678
INSERT INTO laterraza.users (active, date_created, date_updated, email, id_person, id_rol, `_password`, username, id_role) VALUES('A', '2021-10-09 10:00:0', '2021-10-09 10:00:0', 'IDAT@GMAIL.COM', 1, 2, '$2a$10$tXcyXHwb9tHr8GvyJhWuOuQHMOkIP7.uoDMrS49CqrQtc8/pPIr/2', 'CAPITANCRUNCH', 2);
-- INSERT INTO laterraza.users (active, date_created, date_updated, email, id_person, id_rol, `_password`, username, id_role) VALUES('A','2022-01-26 15:19:09.962000000','2022-01-26 15:19:09.962000000','DANIELAZZ@GMAIL.COM',2,2,'$2a$10$.pXRy.f60PCMgEfIRb/1GeDHGZ8iO9vmuFyWZbRfWtdTyvcYj.IDi','DANIELA',NULL)
-- INSERT INTO laterraza.users (active, date_created, date_updated, email, id_person, id_rol, `_password`, username, id_role) VALUES('A', '2021-10-09 10:00:0', '2021-10-09 10:00:0', 'DNAIEL@GMAIL.COM', 2, 2, '$2a$10$CnsnJz9Dzv4/9fxfepPh1.oOCF9fVIHT1bDQiL/oh/jVt299nlBwq', 'DANIEL', 2);
-- INSERT INTO laterraza.users (active, date_created, date_updated, email, id_person, id_rol, `_password`, username, id_role) VALUES('A', '2021-10-09 10:00:0', '2021-10-09 10:00:0', 'YENI@GMAIL.COM', 3, 2, '$2a$10$CnsnJz9Dzv4/9fxfepPh1.oOCF9fVIHT1bDQiL/oh/jVt299nlBwq', 'YENI', 2);
-- END USERS


--MESAS
INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa con vista al mar', 5, 1, 'A');
INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa de reuniones', 5, 2, 'A');
INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa de celebraciones', 5, 3, 'A');
INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa Vip', 5, 4, 'A');
INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa de eventos', 2, 5, 'A');

INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa con vista al mar', 2, 5, 'A');
INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa de reuniones', 4, 6, 'A');
INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa de celebraciones', 3, 7, 'A');
INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa Vip', 2, 8, 'A');

INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa con vista al mar', 2, 9, 'A');
INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa de reuniones', 4, 10, 'A');
INSERT INTO laterraza.tables (date_created, date_updated, description, number_person, number_table, status) VALUES('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'Mesa de celebraciones', 3, 11, 'A');
I
I
--END MESAS