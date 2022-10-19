INSERT INTO user(id, username, email, password, role) VALUES
    (
     1,
    "monkey",
    "monkey@monkeyDev.com",
    "$2a$10$.8gxUZK4aaQAcfvC5l3pWet8a5wBPMNvNLXYNPLSEizAa6PTaAZ6q",
    "ADMIN"
    )
    ON DUPLICATE KEY
    UPDATE
        password="$2a$10$.8gxUZK4aaQAcfvC5l3pWet8a5wBPMNvNLXYNPLSEizAa6PTaAZ6q",
        role="ADMIN";