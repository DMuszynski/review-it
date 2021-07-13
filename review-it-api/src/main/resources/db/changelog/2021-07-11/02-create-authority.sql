--liquibase formatted sql
--changeset dmuszynski:2
CREATE TABLE AUTHORITY
(
    id             BIGINT      NOT NULL
        AUTO_INCREMENT PRIMARY KEY,
    authority_type VARCHAR(15) NOT NULL
);

ALTER TABLE AUTHORITY
    ADD CONSTRAINT UNIQUE_AUTHORITY_AUTHORITY_TYPE UNIQUE (authority_type);