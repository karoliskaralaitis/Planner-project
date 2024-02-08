DROP TABLE IF EXISTS GOAL;

CREATE TABLE GOAL (
    ID int primary key auto_increment,
    GOAL_ID UUID NOT NULL,
    NAME varchar(800),
    DO_BY_DATE date,
    COMMENT varchar(800),
    DATE_OF_CREATION datetime
);