CREATE TABLE IF NOT EXISTS author (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    language VARCHAR(50),
    publication_date DATE,
    num_pages INT,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES author(id)
);
