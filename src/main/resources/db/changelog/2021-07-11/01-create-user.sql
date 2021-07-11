--liquibase formatted sql
--changeset dmuszynski:1
CREATE TABLE USER
(
    id                     BIGINT       NOT NULL
        AUTO_INCREMENT PRIMARY KEY,
    email                  VARCHAR(50)  NOT NULL,
    username               VARCHAR(30)  NOT NULL,
    password               VARCHAR(60)  NOT NULL,
    is_enabled             BIT          NOT NULL,
    is_locked              BIT          NOT NULL,
    is_account_expired     BIT          NOT NULL,
    is_credentials_expired BIT          NOT NULL
);

ALTER TABLE USER
    ADD CONSTRAINT UNIQUE_USER_USERNAME_EMAIL UNIQUE (username, email)