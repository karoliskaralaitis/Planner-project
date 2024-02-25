INSERT INTO GOAL(GOAL_ID, NAME, DO_BY_DATE, COMMENT, DATE_OF_CREATION)
VALUES
    ('305de354-55f6-4f1b-b0ab-3142b1b49a90', 'Stop smoking', '2024-03-01', 'Quit smoking as fast as you can', DATE_TRUNC('minute', CURRENT_TIMESTAMP)),
    ('1ae2e31b-b8a4-4bc1-a78a-59cbca54c0a1', 'Read more books', '2025-01-01', 'Read 100 books before next year', DATE_TRUNC('minute', CURRENT_TIMESTAMP)),
    ('d3d18716-9cc7-41cc-b9f8-dbc4d58b0c2a', 'Drink more water', '2025-11-21', 'Drink at least 2l of water every day', DATE_TRUNC('minute', CURRENT_TIMESTAMP)),
    ('7c8ed4a2-4f68-4c9a-b76d-fad8bf2c58bf', 'Eat breakfast', '2025-06-11', 'Start eating breakfast', DATE_TRUNC('minute', CURRENT_TIMESTAMP)),
    ('f3e7b1b2-6d53-4e61-874b-ba3fc74b5d21', 'Stop scrolling', '2024-12-24', 'Stop scrolling garbage apps before Christmas', DATE_TRUNC('minute', CURRENT_TIMESTAMP));

INSERT INTO TASK(TASK_ID, TASK_NAME, TASK_FINISH_DATE, TASK_COMMENT, TASK_CREATION_DATE, GOAL_ID)
VALUES
    ('937f43b7-b723-4c7d-8b7c-52d0fe413bf7', 'Do not buy them', '2024-03-01', 'Do not buy any more cigarettes, so that you have nothing to smoke', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 1),
    ('04a32236-8bbf-4aaf-b8aa-2d8d11b5c712', 'Buy a book', '2024-01-01', 'Go to a book store and buy a book', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 2),
    ('d36c372a-5483-4c13-9534-1b1c43b6afab', 'Read it', '2024-12-31', 'Read the book that you just bought', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 2),
    ('c9c1885a-8ac6-4e02-a69f-7e1b37d2da8d', 'Get a nice flask', '2024-03-01', 'Get a flask to fill up with water', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 3),
    ('f2851a3a-3094-49a0-827c-4dfb846e4c0a', 'Fill it with water', '2024-04-20', 'Fill it with water making sure not to spill it', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 3),
    ('cc8d7a26-4c32-47e5-bcd5-70c5d21da6bf', 'Drink the water', '2024-05-18', 'Drink the water and do not spill it on the keyboard', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 3),
    ('a290d958-60f0-4c7a-8e94-8d86855c6f9a', 'Make sure the pagination works', '2024-05-18', 'And make sure to write GoalGoalId instead of GoalId...', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 3),
    ('5a9de084-8a5b-4875-8492-9b1a2906e33a', 'Just eat it', '2025-02-24', 'Just eat a sandwich in the morning', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 4),
    ('a7a5f5da-b5eb-4f45-84a7-0b9446bc144f', 'Delete apps', '2024-07-07', 'Delete all the garbage apps', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 5),
    ('2f83a0b7-7e54-46f1-b3f5-742c5272f2e9', 'Do not get new apps', '2024-11-01', 'Resist the urge to download a meme app', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 5),
    ('9a7f87fc-8e92-4a7e-b481-5466d2b01978', 'Enjoy', '2025-09-01', 'Enjoy all the time you saved', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 5);