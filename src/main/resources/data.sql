INSERT INTO role(id, name) VALUES (1, "ROLE_ADMIN"), (2, "ROLE_USER"), (3, "ROLE_ANONYMOUS")
    ON DUPLICATE KEY UPDATE id=id;
INSERT INTO user(id, username, email, password) VALUES
    (
     1,
    "monkey",
    "monkey@monkeyDev.com",
    "$2a$10$.8gxUZK4aaQAcfvC5l3pWet8a5wBPMNvNLXYNPLSEizAa6PTaAZ6q"
    )
    ON DUPLICATE KEY
    UPDATE
        password="$2a$10$.8gxUZK4aaQAcfvC5l3pWet8a5wBPMNvNLXYNPLSEizAa6PTaAZ6q";
INSERT INTO user_roles(user_id, role_id) VALUES (1, 1) ON DUPLICATE KEY UPDATE user_id=user_id;