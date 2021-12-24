USE laterraza

-- ROLES
INSERT INTO laterraza.roles (date_created, date_updated, description) VALUES ('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'ADMINISTRATOR');
INSERT INTO laterraza.roles (date_created, date_updated, description) VALUES ('2021-10-09 10:00:00', '2021-10-09 10:00:00', 'COMENSAL');
-- END ROLES                                                                            

-- PERSON
INSERT INTO laterraza.person (active, birth_name, date_created, date_of_birth, date_updated, dni, first_name, last_name, middle_name, phone) VALUES('A', 'IDATATE', '2021-10-09 10:00:00', '2021-10-01', '2021-10-09 10:00:00', '12345678', 'IDATATE', 'IDATATE', 'IDATATE', '999111222');
-- END PERSON

-- USERS
INSERT INTO laterraza.users (active, date_created, date_updated, email, id_rol, `_password`, username, id_person, id_role) VALUES('A', '2021-10-09 10:00:00', '2021-10-09 10:00:00', 'IDATATE@GMAIL.COM', 1, '$2a$10$TXWlGGGuuyYEYQO.84403eGcYvWig/sbnkKXJT6O2XpmSyP7pkcF2', 'IDATATE', 1, 1);
-- END USERS

