CREATE TABLE USERS (
    USERNAME VARCHAR(50),
    PASSWORD VARCHAR(50),
    ENABLED SMALLINT,
    PRIMARY KEY(USERNAME)
);

CREATE TABLE AUTHORITIES (
    USERNAME VARCHAR(50),
    AUTHORITY VARCHAR(50)
);