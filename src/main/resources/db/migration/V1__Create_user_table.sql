create sequence user_user_id_seq;

create table "user"
(
    user_id       bigint not null
        primary key,
    user_login    varchar(255),
    user_password varchar(255)
);