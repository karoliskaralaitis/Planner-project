INSERT INTO GOAL(GOAL_ID, NAME, DO_BY_DATE, COMMENT, DATE_OF_CREATION)
VALUES
    ('260f7043-d0bf-4d99-b143-6ee555685561', 'Stop smoking', '2024-03-01', 'Quit smoking as fast as you can', DATE_TRUNC('minute', CURRENT_TIMESTAMP)),
    ('260f7043-d0bf-4d99-b143-6ee555685562', 'Read more books', '2025-01-01', 'Read 100 books before next year', DATE_TRUNC('minute', CURRENT_TIMESTAMP)),
    ('260f7043-d0bf-4d99-b143-6ee555685563', 'Drink more water', '2025-11-21', 'Drink at least 2l of water every day', DATE_TRUNC('minute', CURRENT_TIMESTAMP)),
    ('260f7043-d0bf-4d99-b143-6ee555685564', 'Eat breakfast', '2025-06-11', 'Start eating breakfast', DATE_TRUNC('minute', CURRENT_TIMESTAMP)),
    ('260f7043-d0bf-4d99-b143-6ee555685565', 'Stop scrolling', '2024-12-24', 'Stop scrolling garbage apps before Christmas', DATE_TRUNC('minute', CURRENT_TIMESTAMP));

INSERT INTO TASK(TASK_ID, TASK_NAME, TASK_FINISH_DATE, TASK_COMMENT, TASK_CREATION_DATE, GOAL_ID)
VALUES
    ('360f7043-d0bf-4d99-b143-6ee555685501', 'Do not buy them', '2024-03-01', 'Do not buy any more cigarettes, so that you have nothing to smoke', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 1),
    ('460f7043-d0bf-4d99-b143-6ee555685502', 'Buy a book', '2024-01-01', 'Go to a book store and buy a book', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 2),
    ('560f7043-d0bf-4d99-b143-6ee555685503', 'Read it', '2024-12-31', 'Read the book that you just bought', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 2),
    ('660f7043-d0bf-4d99-b143-6ee555685504', 'Get a nice flask', '2024-03-01', 'Get a flask to fill up with water', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 3),
    ('760f7043-d0bf-4d99-b143-6ee555685505', 'Fill it with water', '2024-04-20', 'Fill it with water making sure not to spill it', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 3),
    ('860f7043-d0bf-4d99-b143-6ee555685506', 'Drink the water ', '2024-05-18', 'Drink the water and do not spill it on the keyboard', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 3),
    ('960f7043-d0bf-4d99-b143-6ee555685507', 'Just eat it', '2025-02-24', 'Just eat a sandwich in the morning', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 4),
    ('060f7043-d0bf-4d99-b143-6ee555685508', 'Delete apps', '2024-07-07', 'Delete all the garbage apps', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 5),
    ('160f7043-d0bf-4d99-b143-6ee555685509', 'Do not get new apps', '2024-11-01', 'Resist the urge to download a meme app', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 5),
    ('260f7043-d0bf-4d99-b143-6ee555685500', 'Enjoy', '2025-09-01', 'Enjoy all the time you saved', DATE_TRUNC('minute', CURRENT_TIMESTAMP), 5);