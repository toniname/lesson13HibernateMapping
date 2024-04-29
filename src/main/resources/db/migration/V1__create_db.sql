CREATE TABLE IF NOT EXISTS client (
                                      id SERIAL PRIMARY KEY,
                                      name VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS planet (
                                      id VARCHAR(10) PRIMARY KEY,
                                      name VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS ticket (
                                      id SERIAL PRIMARY KEY,
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      client_id BIGINT REFERENCES client(id),
                                      from_planet_id VARCHAR(10) REFERENCES planet(id),
                                      to_planet_id VARCHAR(10) REFERENCES planet(id)
);