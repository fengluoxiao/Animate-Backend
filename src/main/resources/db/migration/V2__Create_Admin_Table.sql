CREATE TABLE adminTable (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(60) NOT NULL  -- BCrypt加密后的密码长度为60
); 