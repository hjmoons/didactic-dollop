-- src/main/resources/schema.sql
CREATE TABLE todo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    completed boolean default 0
);

CREATE TABLE member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) not null,
    password VARCHAR(255) not null,
    name VARCHAR(255),
    email VARCHAR(255)
)