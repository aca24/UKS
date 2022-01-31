INSERT INTO ROLES (name) VALUES ('ROLE_USER');

INSERT INTO USERS (username, password, first_name, last_name, role_id) VALUES ('maca', 'maca', 'maca', 'maca', 1);

INSERT INTO TASKS (id,user_id) VALUES (158,1);
INSERT INTO TASKS (id,user_id) VALUES (159,1);

INSERT INTO BRANCHES(id,name) VALUES (1,'branch1');

INSERT INTO PULL_REQUESTS(id, user_id, name, branch_id) VALUES (158,1, 'pull1',1);

INSERT INTO ISSUES(id, user_id, date_created, description, title) VALUES (159,1, '2020-05-05','opis1', 'title1');

INSERT INTO ISSUES_PULL_REQUESTS(pull_request_id, issue_id) VALUES (158, 159);





