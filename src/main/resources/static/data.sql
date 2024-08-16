CREATE TABLE user_tb (
    user_id SERIAL primary key ,
    user_name varchar(255) NOT NULL,
    gender VARCHAR (5) NOT NULL
);

ALTER TABLE todo
    ADD COLUMN user_id INTEGER;

ALTER TABLE todo
    ADD CONSTRAINT fk_user_id
        FOREIGN KEY (user_id) REFERENCES user_tb(user_id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;
