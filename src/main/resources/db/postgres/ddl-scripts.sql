DROP TABLE IF EXISTS goal;

CREATE TABLE goal (
                      id SERIAL primary key,
                      goal_id UUID NOT NULL,
                      name VARCHAR(800),
                      do_by_date DATE,
                      comment VARCHAR(800),
                      date_of_creation TIMESTAMP
);