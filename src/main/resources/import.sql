INSERT INTO ROLES (name) VALUES ('ROLE_USER');
INSERT INTO ROLES (name) VALUES ('ROLE_ADMIN');



INSERT INTO USERS (username, password, first_name, last_name, role_id) VALUES ('nestodrugo', 'nestodrugo', 'nestodrugo', 'nestodrugo', 1);

INSERT INTO MILESTONES (id, description, due_date, state, title) VALUES (1, 'nesto', '2021-07-03', 'MERGED','nesto');
INSERT INTO MILESTONES (id, description, due_date, state, title) VALUES (2, 'nestodrugo', '2021-11-03', 'CLOSED','nestodrugo');

INSERT INTO TASKS (id, user_id, milestone_id) VALUES (12, 1, 1);
INSERT INTO TASKS (id, user_id, milestone_id) VALUES (22, 1, 1);
INSERT INTO TASKS (id, user_id, milestone_id) VALUES (32, 1, 1);

INSERT INTO EVENTS (id, creation_time, task_id) VALUES (1, '2021-07-03 00:00:00', 1);
INSERT INTO EVENTS (id, creation_time, task_id) VALUES (2, '2021-11-03 11:11:11', 2);

INSERT INTO COMMENTS (id, creation_time, task_id, content) VALUES (1, '2021-07-03 00:00:00', 1, 'nesto');
INSERT INTO COMMENTS (id, creation_time, task_id, content) VALUES (2, '2021-11-03 11:11:11', 2, 'nestodrugo');

INSERT INTO LABEL_APPLICATIONS (id, creation_time, task_id) VALUES (1, '2021-07-03 00:00:00', 1);
INSERT INTO LABEL_APPLICATIONS (id, creation_time, task_id) VALUES (2, '2021-11-03 11:11:11', 2);

INSERT INTO STATE_CHANGES (id, creation_time, task_id, new_state) VALUES (11, '2021-05-18 01:12:09', 1, 'OPEN');
INSERT INTO STATE_CHANGES (id, creation_time, task_id, new_state) VALUES (12, '2021-11-11 15:10:19', 2, 'CLOSE');
INSERT INTO STATE_CHANGES (id, creation_time, task_id, new_state) VALUES (13, '2021-10-24 10:19:15', 3, 'MERGED');


INSERT INTO TASKS (id,user_id) VALUES (158,1);
INSERT INTO TASKS (id,user_id) VALUES (159,1);

INSERT INTO BRANCHES(id,name) VALUES (1,'branch1');

INSERT INTO PULL_REQUESTS(id, user_id, name, branch_id) VALUES (158,1, 'pull1',1);

INSERT INTO ISSUES(id, user_id, date_created, description, title) VALUES (159,1, '2020-05-05','opis1', 'title1');

INSERT INTO ISSUES_PULL_REQUESTS(pull_request_id, issue_id) VALUES (158, 159);

INSERT INTO GIT_REPOS(id,name) VALUES (123, 'gitRepo1');

INSERT INTO GIT_REPOS_BRANCHES(git_repo_id, branches_id) VALUES (123,1);

INSERT INTO PROJECTS(id,title,git_repo_id,leader_id) VALUES (45,'proj1',123,1);

INSERT INTO GIT_REPOS_PROJECTS(git_repo_id, projects_id) VALUES (123,45);
