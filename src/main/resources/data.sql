INSERT INTO role(id, name)
VALUES (1, "ROLE_ADMIN"),
       (2, "ROLE_USER"),
       (3, "ROLE_SUPERADMIN") ON DUPLICATE KEY
UPDATE id=id;
INSERT INTO user(id, username, email, password)
VALUES (1,
        "admin",
        "admin@admin.com",
        "$2a$10$2LMByWROFQAjXSUeJr.xceI5VBo3Sbd/iAVHPebecjams1XHPwb1G") ON DUPLICATE KEY
UPDATE
    password="$2a$12$LSkRmPh163oYgTAqWFzMXetWjsE81i7KCnkfkt9pam6sQ.EP5UbQC";
INSERT INTO user_roles(user_id, role_id)
VALUES (1, 1) ON DUPLICATE KEY
UPDATE user_id=user_id;