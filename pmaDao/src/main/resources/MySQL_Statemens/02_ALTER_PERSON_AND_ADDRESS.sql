ALTER TABLE `pma`.`person`
    CHANGE COLUMN `ID` `ID`                   INT          NOT NULL,
    CHANGE COLUMN `phoneNumber` `phoneNumber` VARCHAR(40)  NULL DEFAULT NULL,
    CHANGE COLUMN `mobile` `mobile`           VARCHAR(40)  NULL DEFAULT NULL,
    CHANGE COLUMN `email` `email`             VARCHAR(255) NULL DEFAULT NULL;


ALTER TABLE `pma`.`address`
    CHANGE COLUMN `street` `street`             VARCHAR(250) NULL,
    CHANGE COLUMN `streetNumber` `streetNumber` INT          NULL default 0,
    CHANGE COLUMN `zipcode` `zipcode`           INT          NULL default 0,
    CHANGE COLUMN `city` `city`                 VARCHAR(250) NULL;


ALTER TABLE `pma`.`person`
    DROP FOREIGN KEY `person_ibfk_1`;
ALTER TABLE `pma`.`person`
    CHANGE COLUMN `AddressID` `addressID` INT NOT NULL;
ALTER TABLE `pma`.`person`
    ADD CONSTRAINT `person_ibfk_1`
        FOREIGN KEY (`addressID`)
            REFERENCES `pma`.`address` (`ID`);
