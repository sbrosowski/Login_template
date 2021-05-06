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



CREATE TABLE SPRING_SESSION
(
    PRIMARY_ID            CHAR(36) NOT NULL,
    SESSION_ID            CHAR(36) NOT NULL,
    CREATION_TIME         BIGINT   NOT NULL,
    LAST_ACCESS_TIME      BIGINT   NOT NULL,
    MAX_INACTIVE_INTERVAL INT      NOT NULL,
    EXPIRY_TIME           BIGINT   NOT NULL,
    PRINCIPAL_NAME        VARCHAR(100),
    CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
) ENGINE = InnoDB
  ROW_FORMAT = DYNAMIC;

CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

CREATE TABLE SPRING_SESSION_ATTRIBUTES
(
    SESSION_PRIMARY_ID CHAR(36)     NOT NULL,
    ATTRIBUTE_NAME     VARCHAR(200) NOT NULL,
    ATTRIBUTE_BYTES    BLOB         NOT NULL,
    CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
    CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION (PRIMARY_ID) ON DELETE CASCADE
) ENGINE = InnoDB
  ROW_FORMAT = DYNAMIC;
