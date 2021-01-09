CREATE SCHEMA `pma` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;


create table ADDRESS
(
    ID           int          not null,
    street       varchar(250) not null,
    streetNumber int          not null,
    zipcode      int          not null,
    city         varchar(250) not null,
    primary key (ID)

);

CREATE INDEX ADDRESS_INDEX
    ON ADDRESS (ID);


create table Person
(
    ID          int          not null,
    firstName   varchar(250) not null,
    lastName    varchar(250) not null,
    salutation  varchar(50)  not null,
    AddressID   int          not null,
    title       varchar(50),
    dateOfBirth DATE         not null,
    entryDate   Date,
    phoneNumber varchar(20),
    mobile      varchar(20),
    email       varchar(30),

    primary key (ID),
    foreign key (AddressID) references ADDRESS (ID)

);

create index PERSON_INDEX ON PERSON (ID);

create table Login
(
    username varchar(255) not null, com
    .
    pma
    .
    password
    varchar
(
    255
) not null,
    loginTry int not Null,
    personID int not null,
    primary key (username),
    foreign key (personID) references Person (ID)

    );


create index LOGIN_INDEX on Login (username);
