CREATE TABLE GOAL (
    id int primary key,
    goal_id UUID NOT NULL,
    name varchar(800),
    doByDate varchar(800),
    comment varchar(800)
);