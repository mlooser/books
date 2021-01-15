CREATE TABLE Author ( 
   id INT primary key auto_increment, 
   first_name VARCHAR(50) NOT NULL, 
   last_name VARCHAR(50) NOT NULL 
);

CREATE TABLE Book ( 
   id INT primary key auto_increment, 
   author_id INT NOT NULL,
   title VARCHAR(100) NOT NULL 
);