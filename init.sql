DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255)
);

INSERT INTO users (user_id, username, email) VALUES (1, 'ekki', 'test@example.com');