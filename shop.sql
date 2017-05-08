CREATE DATABASE `shop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `shop`;
CREATE TABLE `user`( /* 用户表 */
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(50),
`password` VARCHAR(50),
`name` VARCHAR(50),
`sex` VARCHAR(50),
`email` VARCHAR(255),
`address` VARCHAR(255),
`phoneNumber` VARCHAR(255),
`state` INT, /* 0未激活  1已经激活 */
`activCode` VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `classification`( /* 分类表 */
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(255),
`parentId` BIGINT,
CONSTRAINT `parentId_fk` FOREIGN KEY (`parentId`) REFERENCES `classification` (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `commodity`( /* 商品表 */
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(255),
`mallPrice` DOUBLE,/* 商城价格 */
`markPrice` DOUBLE,/* 市场价格 */
`description` VARCHAR(5000),
`seecount` int,/* 查看数量 */
`buycount` int,/* 购买数量 */
  `state` VARCHAR(50), /* 上架状态 */
  `inventory` INT, /* 库存数量 */
`classId` BIGINT,
CONSTRAINT `classId_fk` FOREIGN KEY (`classId`) REFERENCES `classification` (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `orders`( /* 订单表 */
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`createTime` DATE,
`price` DOUBLE,
`state` VARCHAR(50),
`address` VARCHAR(255),
`phoneNumber` VARCHAR(255),
`consignee` VARCHAR(255), /* 收货人 */
`userId` BIGINT,
CONSTRAINT `userId_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `order_commodity`( /* 订单项表 */
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`commodityId` BIGINT,
`orderId` BIGINT,
`number` INT,
`price` DOUBLE,
CONSTRAINT `commodityId_fk` FOREIGN KEY (`commodityId`) REFERENCES `commodity` (`id`),
CONSTRAINT `orderId_fk` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `adminuser`(
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(255),
`password` VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table `images`(
`id` bigint primary key AUTO_INCREMENT,
  `path` VARCHAR(255),
  `commodityId` BIGINT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `adminuser`(`username`,`password`) VALUES('admin','admin');

INSERT INTO `classification`(`name`) VALUES
('蔬菜'),('水果'),('肉类'),('蛋、奶及豆制品类'),('干果'),('谷薯杂粮'),('油'),('水、软饮'),('茶'),('商城卡'),('定制套餐'),('健康生活附属品');

INSERT INTO `classification`(`name`,`parentId`) VALUES
('无公害蔬菜',1),('特菜类',1),('有机蔬菜',1),('蔬菜套餐',1),
('国产',2),('进口',2),
('猪肉',3),('牛羊肉',3),('家禽',3),('鱼',3),('虾',3),('加工水产',3),('其他水产',3),
('蛋',4),('奶',4),('豆制品',4),
('干制坚果',5),('干制果实/果肉',5),('干制种仁',5),
('米类',6),('杂粮',6),('面粉',6),('薯类',6),('礼盒',6),('干货',6),
('茶油',7),('核桃油',7),('橄榄油',7),('芥花籽油',7),('玉米油',7),('花生油',7),('红花籽油',7),('葡萄籽油',7),('亚麻籽油',7),('葵花仁油',7),
('水',8),('软饮',8),
('绿茶',9),('红茶',9),('乌龙茶',9),('白茶',9),('黄茶',9),('保健茶',9),('黑茶',9),
('商城卡',10),
('1-2人套餐',11),('2-3人套餐',11),('4-6人套餐',11),('标准套餐',11),('乳母套餐',11),('营养师1对1服务',11),('儿童套餐',11),('高考套餐',11),('学生套餐',11),('护眼套餐',11),('世杯套餐',11),
('空气净化器',12),('薰衣草',12);

INSERT INTO `user`(`username`,`password`,`name`,`email`,`address`,`phoneNumber`,`state`,`activCode`) VALUES
('zhangsan','1234','张三','123456@qq.com','江西南昌','13833333333','1','cs35sf64sfd63'),
('lisi','1234','李四','654321@qq.com','江西新余','15589796452','0','gf8sd89fs0f9e');

INSERT INTO `commodity`(`name`,`mallPrice`,`markPrice`,`description`,`seecount`,`buycount`,`classId`) VALUES
('大冬瓜',4.78,5.00,'有机蔬菜',0,0,1),
('圆白菜',1.78,2.00,'有机蔬菜',0,0,1),
('甜玉米',4.48,4.71,'有机蔬菜',0,0,1),
('胡萝卜',1.58,1.93,'有机蔬菜',0,0,1),
('芹菜',2.18,2.50,'有机蔬菜',0,0,1),
('小西红柿',6.98,9.09,'有机蔬菜',0,0,1),
('白萝卜',3.98,4.53,'有机蔬菜',0,0,1),
('菠菜',3.48,4.11,'有机蔬菜',0,0,1),
('香菜',2.98,3.11,'有机蔬菜',0,0,1),
('白菜花',5.38,5.51,'有机蔬菜',0,0,1),
('韭菜',2.38,3.12,'有机蔬菜',0,0,1),
('土豆',2.48,3.41,'有机蔬菜',0,0,1),
('黄瓜',2.58,3.12,'有机蔬菜',0,0,1),
('西红柿',2.58,3.21,'有机蔬菜',0,0,1),
('大白菜',8.78,9.81,'有机蔬菜',0,0,1),
('紫甘蓝',5.98,6.24,'有机蔬菜',0,0,1),
('荷兰豆',9.28,10.80,'有机蔬菜',0,0,1),
('尖椒',2.48,2.93,'有机蔬菜',0,0,1),
('小香葱',2.98,3.25,'有机蔬菜',0,0,1),
('圆茄子',1.58,2.24,'有机蔬菜',0,0,1)
;

INSERT INTO `images`(`path`,`commodityId`) VALUES
('4a51167a-89d5-4710-aca2-7c76edc355b8-thumbnail.jpg',2),
('0ff130db-0a1b-4b8d-a918-ed9016317009-thumbnail.jpg',3),
('f5e39c37-94b2-462e-8e58-8bde3c5f1b8c-thumbnail.jpg',4),
('f37ba36a-181b-4161-a88f-f74c9adb485d-thumbnail.jpg',5),
('93b9e55f-cbae-4c3c-b2f7-2636c7369db7-thumbnail.jpg',6),
('51afeef5-f6cb-4936-abea-315cfca0edc0-thumbnail.jpg',7),
('059b5245-e3c8-43bf-80fe-700f0e4e68b8-thumbnail.jpg',8),
('750a9ce8-8c19-444d-b8cc-f3e7e786ec5d-thumbnail.jpg',9),
('bigPic372e7faa-3ad0-444d-a89b-a8e9f0d6e929.jpg',10),
('bigPica7e5d3dd-5984-4d0f-9851-35cc0987d9b9.jpg',11),
('bigPica5720219-ba48-460a-a084-24d5b314bd03.jpg',12),
('bigPicaa443d05-27b4-4964-958e-c81536f01d04.jpg',13),
('bigPicc1e3a29e-17f5-4d9f-a186-b2c5a0b39b88.jpg',14),
('bigPicd0459632-fe4e-4a5d-8373-1a67c9f43ec2.jpg',15),
('bigPice7c2e240-4147-4c11-b369-db3765ec3df9.jpg',16),
('54890cf9-91b0-40bc-9f68-51462e9c43a8.jpg',17),
('bigPic4ed6edbf-fb3e-49a7-be5e-361b2ce02961.jpg',18),
('bigPic5ab54f67-a479-48fe-a41d-7d34b57036a3.jpg',19),
('bigPic13867cc1-935a-4a3a-98f9-edf87ddb1c09.jpg',20),
('bigPicee0785e3-68e2-4e23-93ef-68904bc2a3c6.jpg',21)
;