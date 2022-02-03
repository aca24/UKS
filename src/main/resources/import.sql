INSERT INTO ROLES (name) VALUES ('ROLE_USER');
INSERT INTO ROLES (name) VALUES ('ROLE_ADMIN');



INSERT INTO USERS (username, password, first_name, last_name, role_id) VALUES ('asdf', '$2a$10$RVzuprKddsjdq6P8QWmqF.sCj2uYPIUlbFVB.b7tJ9RdFNOOBNoXO', 'nestodrugo', 'nestodrugo', 1);

INSERT INTO MILESTONES ( description, due_date, state, title) VALUES ( 'nesto', '2021-07-03 00:00:00', 'MERGED','nesto');
INSERT INTO MILESTONES (description, due_date, state, title) VALUES ('nestodrugo', '2021-11-03 00:00:00', 'CLOSED','nestodrugo');

INSERT INTO TASKS (id, user_id, milestone_id) VALUES (121, 1, 1);
INSERT INTO TASKS (id, user_id, milestone_id) VALUES (122, 1, 1);
INSERT INTO TASKS (id, user_id, milestone_id) VALUES (123, 1, 1);
INSERT INTO TASKS (id, user_id, milestone_id) VALUES (124, 1, 1);

INSERT INTO EVENTS (id, creation_time, task_id) VALUES (101, '2021-07-03 00:00:00', 121);
INSERT INTO EVENTS (id, creation_time, task_id) VALUES (102, '2021-11-03 11:11:11', 122);

INSERT INTO COMMENTS (id, creation_time, task_id, content) VALUES (1, '2021-07-03 00:00:00', 121, 'nesto');
INSERT INTO COMMENTS (id, creation_time, task_id, content) VALUES (2, '2021-11-03 11:11:11', 122, 'nestodrugo');

INSERT INTO LABEL_APPLICATIONS (id, creation_time, task_id) VALUES (71, '2021-07-03 00:00:00', 121);
INSERT INTO LABEL_APPLICATIONS (id, creation_time, task_id) VALUES (72, '2021-11-03 11:11:11', 121);

INSERT INTO LABELS (id, name, label_application_id) VALUES (140, 'nesto', 71);
INSERT INTO LABELS (id, name, label_application_id) VALUES (141, 'nestodrugo', 71);
INSERT INTO LABELS (id, name, label_application_id) VALUES (142, 'nestotrece', 72);

INSERT INTO STATE_CHANGES (id, creation_time, task_id, new_state) VALUES (111, '2021-05-18 01:12:09', 121, 'OPEN');
INSERT INTO STATE_CHANGES (id, creation_time, task_id, new_state) VALUES (112, '2021-11-11 15:10:19', 122, 'CLOSED');
INSERT INTO STATE_CHANGES (id, creation_time, task_id, new_state) VALUES (113, '2021-10-24 10:19:15', 123, 'MERGED');


INSERT INTO TASKS (id,user_id, milestone_id) VALUES (158,1, 2);
INSERT INTO TASKS (id,user_id, milestone_id) VALUES (159,1, 2);

INSERT INTO BRANCHES(id,name) VALUES (1,'branch1');

INSERT INTO PULL_REQUESTS(id, user_id, name, branch_id) VALUES (158,1, 'pull1',1);

INSERT INTO ISSUES(id, user_id, date_created, description, title) VALUES (159,1, '2020-05-05','opis1', 'title1');

INSERT INTO ISSUES_PULL_REQUESTS(pull_request_id, issue_id) VALUES (158, 159);

INSERT INTO GIT_REPOS(id,name) VALUES (123, 'gitRepo1');

INSERT INTO GIT_REPOS_BRANCHES(git_repo_id, branches_id) VALUES (123,1);

INSERT INTO PROJECTS(title,git_repo_id,leader_id) VALUES ('proj1',123,1);

INSERT INTO PROJECTS_MILESTONES (project_id, milestones_id) VALUES (1, 1);
INSERT INTO PROJECTS_MILESTONES (project_id, milestones_id) VALUES (1, 2);

INSERT INTO PROJECTS_LABELS (project_id, labels_id) VALUES (1,140);
INSERT INTO PROJECTS_LABELS (project_id, labels_id) VALUES (1,141);

INSERT INTO DEVELOPERS_PROJECTS (project_id, user_id) VALUES (1, 1);

INSERT INTO GIT_REPOS_PROJECTS(git_repo_id, projects_id) VALUES (123,1);
