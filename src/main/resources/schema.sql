-- src/main/resources/schema.sql
CREATE TABLE todo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    completed boolean default 0
);
