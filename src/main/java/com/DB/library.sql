CREATE table author(
	id int(255) PRIMARY KEY,
	name varchar(255)
)

CREATE TABLE user (
	id int(255) PRIMARY KEY,
	name varchar(255),
	membershipNumber int(255)
)

CREATE TABLE book(
	id int(255) PRIMARY KEY,
	title varchar(255),
	publicationDate date,
	status enum('available', 'unavailable', 'lost'),
	authorId int,
	borrowerId int,
	FOREIGN KEY (authorId) REFERENCES author(id),
	FOREIGN KEY (borrowerId) REFERENCES user(id)
)

CREATE TABLE borrows (
	id int(255),
	borrowerId int,
	bookId int,
	borrowDate datetime,
	FOREIGN KEY (bookId) REFERENCES book(id),
	FOREIGN KEY (borrowerId) REFERENCES user(id)
)

INSERT INTO author VALUES (1,'Mohamed Chokri') ;
INSERT INTO `user` VALUES (1, 'nadir', 11) ;
INSERT INTO book VALUES(1, 'pain nu', '1972-12-20', 'available', 1, null) ;