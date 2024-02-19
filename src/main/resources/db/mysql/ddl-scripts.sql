DROP TABLE IF EXISTS GOAL;

CREATE TABLE GOAL (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      goal_id VARCHAR(36) NOT NULL,
                      name VARCHAR(800),
                      do_by_date DATE,
                      comment VARCHAR(800),
                      date_of_creation TIMESTAMP
);