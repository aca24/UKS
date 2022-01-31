INSERT INTO ROLES (name) VALUES ('ROLE_USER');
INSERT INTO ROLES (name) VALUES ('ROLE_ADMIN');

INSERT INTO USERS (username, password, first_name, last_name, role_id) VALUES ('maca', 'maca', 'maca', 'maca', 1);
INSERT INTO USERS (username, password, first_name, last_name, role_id) VALUES ('nestodrugo', 'nestodrugo', 'nestodrugo', 'nestodrugo', 1);

INSERT INTO MILESTONES (id, description, due_date, state, title) VALUES (1, 'nesto', '2021-07-03 00:00:00', 'MERGED','nesto');
INSERT INTO MILESTONES (id, description, due_date, state, title) VALUES (2, 'nestodrugo', '2021-11-03 00:00:00', 'CLOSED','nestodrugo');

INSERT INTO TASKS (id, user_id, milestone_id) VALUES (21, 1, 1);
INSERT INTO TASKS (id, user_id, milestone_id) VALUES (22, 1, 1);
INSERT INTO TASKS (id, user_id, milestone_id) VALUES (23, 1, 1);
INSERT INTO TASKS (id, user_id, milestone_id) VALUES (24, 1, 1);

INSERT INTO EVENTS (id, creation_time, task_id) VALUES (1, '2021-07-03 00:00:00', 21);
INSERT INTO EVENTS (id, creation_time, task_id) VALUES (2, '2021-11-03 11:11:11', 22);

INSERT INTO COMMENTS (id, creation_time, task_id, content) VALUES (1, '2021-07-03 00:00:00', 21, 'nesto');
INSERT INTO COMMENTS (id, creation_time, task_id, content) VALUES (2, '2021-11-03 11:11:11', 22, 'nestodrugo');

INSERT INTO LABEL_APPLICATIONS (id, creation_time, task_id) VALUES (1, '2021-07-03 00:00:00', 21);
INSERT INTO LABEL_APPLICATIONS (id, creation_time, task_id) VALUES (2, '2021-11-03 11:11:11', 22);

INSERT INTO STATE_CHANGES (id, creation_time, task_id, new_state) VALUES (11, '2021-05-18 01:12:09', 21, 'OPEN');
INSERT INTO STATE_CHANGES (id, creation_time, task_id, new_state) VALUES (12, '2021-11-11 15:10:19', 22, 'CLOSE');
