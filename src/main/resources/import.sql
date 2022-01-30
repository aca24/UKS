INSERT INTO ROLES (name) VALUES ('ROLE_USER');

INSERT INTO USERS (username, password, first_name, last_name, role_id) VALUES ('maca', 'maca', 'maca', 'maca', 1);

INSERT INTO TASKS (id,user_id) VALUES (158,1);

INSERT INTO BRANCHES(id,name) VALUES (1,'branch1');

INSERT INTO PULL_REQUESTS(id, user_id, name, branch_id) VALUES (158,1, 'pull1',1);




