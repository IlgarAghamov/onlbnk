create sequence cards_card_id_seq;
create table card
(
    card_id      bigint not null
        primary key,
    card_balance real,
    card_date    timestamp,
    card_number  varchar(255),
    card_secret  integer,
    card_type    varchar(255),
    user_id      bigint
        constraint fkl4gbym62l738id056y12rt6q6
            references "user"
);