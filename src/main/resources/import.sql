USE laterraza

-- ROLES
INSERT INTO laterraza.roles (date_created, date_updated, description) VALUES ('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'ADMINISTRATOR');
INSERT INTO laterraza.roles (date_created, date_updated, description) VALUES ('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'COMENSAL');
-- END ROLES                                                                            

-- PERSON
INSERT INTO laterraza.person (active, birth_name, date_created, date_of_birth, date_updated, dni, first_name, last_name, middle_name, phone, id_role) VALUES('A', 'IDAT', '2021-10-09 10:00:00', '2021-10-02', '2021-10-09 10:00:00', '77711234', 'IDAT', 'IDAT', 'IDAT', '123456789', 2);

-- END PERSON

-- USERS
--IDAT123
INSERT INTO laterraza.users (active, date_created, date_updated, email, id_person, id_rol, `_password`, username, id_role) VALUES('A', '2021-10-09 10:00:0', '2021-10-09 10:00:0', 'IDAT@GMAIL.COM', 1, 2, '$2a$10$CnsnJz9Dzv4/9fxfepPh1.oOCF9fVIHT1bDQiL/oh/jVt299nlBwq', 'IDATATE', 2);
-- END USERS

