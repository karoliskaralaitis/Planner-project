DROP TABLE IF EXISTS GOAL;

CREATE TABLE GOAL (
                      id int primary key auto_increment,
                      goal_id varchar(36) NOT NULL,
                      name VARCHAR(800),
                      do_by_date DATE,
                      comment VARCHAR(800),
                      date_of_creation TIMESTAMP
);