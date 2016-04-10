DROP TABLE DBA_USERS;

CREATE TABLE DBA_USERS
(
   id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   user_id int NOT NULL,
   user_name varchar(100) NOT NULL,
   user_email varchar(100) NOT NULL,
   phone_number varchar(20) NOT NULL,
   registration varchar(30) NOT NULL,
   password varchar(30) NOT NULL,
   user_type varchar(10) NOT NULL, --STUDENT / TEACHER / ADMIN
   modify_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE UNIQUE INDEX DB_LIBRARY_01 ON DBA_USERS(id);
CREATE UNIQUE INDEX DB_LIBRARY_02 ON DBA_USERS (user_id);
CREATE UNIQUE INDEX DB_LIBRARY_03 ON DBA_USERS (user_email);
CREATE UNIQUE INDEX DB_LIBRARY_04 ON DBA_USERS (registration);

INSERT INTO DBA_USERS (user_id, user_name, user_email, phone_number, registration, password, user_type, modify_at)
VALUES (112233, 'Pisarciuc Ionut-Daniel', 'daniel.pisarciuc@info.uaic.ro', 0723195136, '3109014SL10273', 'ionutPass', 'STUDENT', now());

INSERT INTO DBA_USERS (user_id, user_name, user_email, phone_number, registration, password, user_type, modify_at)
VALUES (113344, 'Nita Mihai', 'mihai.nita@info.uaic.ro', 0456799521, '3109014LD100273', 'mihaiPass', 'ADMIN', now());

INSERT INTO DBA_USERS (user_id, user_name, user_email, phone_number, registration, password, user_type, modify_at)
VALUES (100344, 'Litu Roxana', 'roxana.litu@info.uaic.ro', 0454646565, '3109014AL1073', 'roxanaPass', 'ADMIN', now());

INSERT INTO DBA_USERS (user_id, user_name, user_email, phone_number, registration, password, user_type, modify_at)
VALUES (110044, 'Erhan Mirela', 'mirela.erhan@info.uaic.ro', 0764323411, '3109014TL100273', 'mirelaPass', 'TEACHER', now());
