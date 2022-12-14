CREATE USER 'sokrito'@'localhost' IDENTIFIED BY 'sokrito123';

GRANT ALL PRIVILEGES ON * . * TO 'sokrito'@'localhost';


ALTER USER 'sokrito'@'localhost' IDENTIFIED WITH mysql_native_password BY 'sokrito123';