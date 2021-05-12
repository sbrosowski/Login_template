ALTER TABLE Login
    ADD deletedTimeStamp DATETIME,
    ADD lastModified     DATETIME NOT NULL;
