INSERT INTO ROLES (name) VALUES ('ROLE_USER');

INSERT INTO USERS (username, password, first_name, last_name, role_id) VALUES ('maca', 'maca', 'maca', 'maca', 1);
INSERT INTO USERS (username, password, first_name, last_name, role_id) VALUES ('nestodrugo', 'nestodrugo', 'nestodrugo', 'nestodrugo', 1);

INSERT INTO MILESTONES (id, description, due_date, state, title) VALUES (1, 'nesto', '2021-07-03', 'MERGED','nesto');
INSERT INTO MILESTONES (id, description, due_date, state, title) VALUES (2, 'nestodrugo', '2021-11-03', 'CLOSED','nestodrugo');

INSERT INTO TASKS (id, user_id, milestone_id) VALUES (1, 1, 1);
INSERT INTO TASKS (id, user_id, milestone_id) VALUES (2, 1, 1);
INSERT INTO TASKS (id, user_id, milestone_id) VALUES (3, 1, 1);

INSERT INTO EVENTS (id, creation_time, task_id) VALUES (1, '2021-07-03 00:00:00', 1);
INSERT INTO EVENTS (id, creation_time, task_id) VALUES (2, '2021-11-03 11:11:11', 2);

INSERT INTO COMMENTS (id, creation_time, task_id, content) VALUES (1, '2021-07-03 00:00:00', 1, 'nesto');
INSERT INTO COMMENTS (id, creation_time, task_id, content) VALUES (2, '2021-11-03 11:11:11', 2, 'nestodrugo');

INSERT INTO LABEL_APPLICATIONS (id, creation_time, task_id) VALUES (1, '2021-07-03 00:00:00', 1);
INSERT INTO LABEL_APPLICATIONS (id, creation_time, task_id) VALUES (2, '2021-11-03 11:11:11', 2);

INSERT INTO STATE_CHANGES (id, creation_time, task_id, new_state) VALUES (11, '2021-05-18 01:12:09', 1, 'OPEN');
INSERT INTO STATE_CHANGES (id, creation_time, task_id, new_state) VALUES (12, '2021-11-11 15:10:19', 2, 'CLOSE');
INSERT INTO STATE_CHANGES (id, creation_time, task_id, new_state) VALUES (13, '2021-10-24 10:19:15', 3, 'MERGED');
