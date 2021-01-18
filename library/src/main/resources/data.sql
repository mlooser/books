INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) VALUES
('admin2', '{noop}aaa', 1),
('normal2', '{noop}nnn', 1);

INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES
('admin2', 'ADMIN'),
('admin2', 'USER'),
('normal2', 'USER');

