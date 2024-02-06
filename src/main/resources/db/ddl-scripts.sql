DROP TABLE IF EXISTS GOAL;

CREATE TABLE GOAL (
    id int primary key auto_increment,
    goal_id UUID NOT NULL,
    name varchar(800),
    doByDate varchar(800),
    comment varchar(800)
);