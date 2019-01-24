USE test;
DROP TABLE IF EXISTS part;
CREATE TABLE part(
 id INT(11) NOT NULL AUTO_INCREMENT,
 PartName varchar(255),
 IsNecessary bit,
 Amount int,
 PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO part (PartName, IsNecessary, Amount) 
VALUES ("материнская плата", 1, 3),
 ("звуковая карта", 0, 2),
 ("процессор", 1, 2),
 ("подсветка корпуса", 0, 0),
 ("HDD диск", 0, 1),
 ("корпус", 1, 10),
 ("RAM", 1, 10),
 ("SSD диск", 1, 15),
 ("видеокарта", 0, 7),
 ("блок питания", 1, 4),
 ("кулер", 1, 16),
 ("оптический привод", 0, 3),
 ("термопаста", 1, 5),
 ("монитор", 1, 1),
 ("мышь", 0, 6),
 ("клавиатура", 0, 7),
 ("гарнитура", 0, 3),
 ("сканер", 0, 1),
 ("принтер", 0, 2),
 ("USB Flash drive", 0, 1),
 ("сетевая карта", 0, 2),
 ("док-станция для жесткого диска", 0, 1),
 ("коврик для мыши", 0, 10);
