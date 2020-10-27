DROP DATABASE IF EXISTS GuessTheNumDB;
CREATE DATABASE GuessTheNumDB;

USE GuessTheNumDB;

CREATE TABLE Game(
gameId INT PRIMARY KEY AUTO_INCREMENT,
answer CHAR(4) NOT NULL,
`status` BIT NOT NULL
);

-- INSERT INTO Game(answer, `status`) 
-- VALUES("1234",true);

 SELECT * from game;
--  SELECT * FROM rounds WHERE gameId = 1;

CREATE TABLE Rounds(
roundsId INT PRIMARY KEY AUTO_INCREMENT,
guess CHAR(4) NOT NULL,
`time` DATETIME NOT NULL,
result CHAR(7) NOT NULL,
gameId INT NOT NULL,
CONSTRAINT `fk_Rounds_Game` FOREIGN KEY(gameId)
	REFERENCES Game(gameId)
);
