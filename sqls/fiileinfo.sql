CREATE TABLE fileinfo (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	userNo BIGINT,
    gid VARCHAR(45) NOT NULL,
    location VARCHAR(45),
    fileName VARCHAR(100) NOT NULL,
    extension VARCHAR(45),
    fileType VARCHAR(80),
    regDT DATETIME DEFAULT NOW()
);