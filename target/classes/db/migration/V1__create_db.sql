CREATE TABLE alarm (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    message VARCHAR(40),
    ip VARCHAR(40),
    alarm_group VARCHAR(40),
    impact VARCHAR(40),
    host_ID VARCHAR(40),
    reinstates VARCHAR(40),
    alarm_ID VARCHAR(40)
);
--INSERT INTO alarm_db("messaging", "10.1.4.89", "group S", "impacting", 0, 4, 1534);
--SELECT * FROM alarm_db;
