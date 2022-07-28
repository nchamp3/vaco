CREATE TABLE blogs (
    id int,
    title varchar(255),
    contents varchar(255),
    timestamp TIMESTAMP ,
    categoryId varchar(255)
);

CREATE TABLE categories (
    id int,
    name varchar(255)
);