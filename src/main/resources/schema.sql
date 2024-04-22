SET FOREIGN_KEY_CHECKS = 0;

-- auto_mechanic.auto definition

CREATE TABLE IF NOT EXISTS `auto`
(
    `id`               bigint NOT NULL AUTO_INCREMENT,
    `auto_description` varchar(255) DEFAULT NULL,
    `auto_model`       varchar(15)  DEFAULT NULL,
    `auto_type`        varchar(15)  DEFAULT NULL,
    `color`            varchar(15)  DEFAULT NULL,
    `license_plate`    varchar(255) DEFAULT NULL,
    `year`             varchar(255) DEFAULT NULL,
    `client_id`        bigint NOT NULL,
    `image_id`         varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_kxsjwvfpuqbyqb9tqqwcaiwyt` (`license_plate`),
    KEY `FKga5mfsrknusui61ki4a6oyh63` (`client_id`),
    KEY `FKtfeos30i8a5ywefs33vtdwppf` (`image_id`),
    CONSTRAINT `FKga5mfsrknusui61ki4a6oyh63` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
    CONSTRAINT `FKtfeos30i8a5ywefs33vtdwppf` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- auto_mechanic.booking definition

CREATE TABLE IF NOT EXISTS `booking`
(
    `id`        bigint NOT NULL AUTO_INCREMENT,
    `date`      datetime(6)  DEFAULT NULL,
    `due_date`  date         DEFAULT NULL,
    `refid`     varchar(255) DEFAULT NULL,
    `status`    int          DEFAULT NULL,
    `auto_id`   bigint       DEFAULT NULL,
    `client_id` bigint       DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_d4rbypuml1mhnhv7litnl1gev` (`refid`),
    KEY `FK1t7ymgnn57d7b0it777mvch0m` (`auto_id`),
    KEY `FKhs7eej4m2orrmr5cfbcrqs8yw` (`client_id`),
    CONSTRAINT `FK1t7ymgnn57d7b0it777mvch0m` FOREIGN KEY (`auto_id`) REFERENCES `auto` (`id`),
    CONSTRAINT `FKhs7eej4m2orrmr5cfbcrqs8yw` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- auto_mechanic.client definition

CREATE TABLE IF NOT EXISTS `client`
(
    `id`           bigint NOT NULL AUTO_INCREMENT,
    `address`      varchar(100) DEFAULT NULL,
    `email`        varchar(255) DEFAULT NULL,
    `first_name`   varchar(15)  DEFAULT NULL,
    `last_name`    varchar(15)  DEFAULT NULL,
    `phone_number` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_bfgjs3fem0hmjhvih80158x29` (`email`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- auto_mechanic.image definition

CREATE TABLE IF NOT EXISTS `image`
(
    `id`       varchar(255) NOT NULL,
    `location` varchar(255) DEFAULT NULL,
    `name`     varchar(255) DEFAULT NULL,
    `type`     varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- auto_mechanic.`repair` definition

CREATE TABLE IF NOT EXISTS `repair`
(
    `id`             bigint NOT NULL AUTO_INCREMENT,
    `repair_cost`    bigint       DEFAULT NULL,
    `repair_details` varchar(200) DEFAULT NULL,
    `repair_status`  int          DEFAULT NULL,
    `repair_type`    varchar(30)  DEFAULT NULL,
    `booking_id`     bigint NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK3awtu45r2almgahlymtivc4ix` (`booking_id`),
    CONSTRAINT `FK3awtu45r2almgahlymtivc4ix` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- auto_mechanic.`user` definition

CREATE TABLE IF NOT EXISTS `user`
(
    `id`       bigint NOT NULL AUTO_INCREMENT,
    `email`    varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `username` varchar(255) DEFAULT NULL,
    `image_id` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
    UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
    KEY `FK9hpx11qlu8cqhrkjn0yor93h` (`image_id`),
    CONSTRAINT `FK9hpx11qlu8cqhrkjn0yor93h` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- auto_mechanic.`role` definition

CREATE TABLE IF NOT EXISTS `role`
(
    `id`   bigint NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- auto_mechanic.user_roles definition

CREATE TABLE IF NOT EXISTS `user_roles`
(
    `user_id` bigint NOT NULL,
    `role_id` bigint NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`),
    CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;