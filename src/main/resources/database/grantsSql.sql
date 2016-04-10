--the root user will have full access to this database
GRANT ALL ON dblibrary.* TO 'root'@'localhost';

--the lib_user will have only read rights
GRANT SELECT ON dblibrary.* TO 'lib_user'@'localhost';