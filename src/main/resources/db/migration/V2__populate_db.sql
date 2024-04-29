INSERT INTO client (name) VALUES
                              ('John Doe'),
                              ('Alice Smith'),
                              ('Bob Johnson'),
                              ('Mary Williams'),
                              ('David Brown'),
                              ('Emily Jones'),
                              ('Michael Davis'),
                              ('Emma Wilson'),
                              ('Daniel Taylor'),
                              ('Olivia Miller');

-- Вставка даних про планети
INSERT INTO planet (id, name) VALUES
                                  ('MARS', 'Mars'),
                                  ('VEN', 'Venus'),
                                  ('EAR', 'Earth'),
                                  ('JUP', 'Jupiter'),
                                  ('SAT', 'Saturn');

-- Вставка даних про квитки
INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
                                                                 (1, 'MARS', 'VEN'),
                                                                 (2, 'EAR', 'MARS'),
                                                                 (3, 'VEN', 'MARS'),
                                                                 (4, 'JUP', 'MARS'),
                                                                 (5, 'MARS', 'SAT'),
                                                                 (6, 'VEN', 'SAT'),
                                                                 (7, 'JUP', 'VEN'),
                                                                 (8, 'MARS', 'JUP'),
                                                                 (9, 'EAR', 'JUP'),
                                                                 (10, 'SAT', 'MARS');