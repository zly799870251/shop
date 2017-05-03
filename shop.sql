CREATE DATABASE shop;
USE shop;
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
);
CREATE TABLE `classification`( /* 分类表 */
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(255),
`parentId` BIGINT,
CONSTRAINT `parentId_fk` FOREIGN KEY (`parentId`) REFERENCES `classification` (`id`)
);
CREATE TABLE `commodity`( /* 商品表 */
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(255),
`mallPrice` DOUBLE,/* 商城价格 */
`markPrice` DOUBLE,/* 市场价格 */
`description` VARCHAR(5000),
`image` VARCHAR(255),
`classId` BIGINT,
CONSTRAINT `classId_fk` FOREIGN KEY (`classId`) REFERENCES `classification` (`id`)
);
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
);
CREATE TABLE `order_commodity`( /* 订单项表 */
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`commodityId` BIGINT,
`orderId` BIGINT,
`number` INT,
`price` DOUBLE,
CONSTRAINT `commodityId_fk` FOREIGN KEY (`commodityId`) REFERENCES `commodity` (`id`),
CONSTRAINT `orderId_fk` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`)
);
CREATE TABLE `adminuser`(
`id` BIGINT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(255),
`password` VARCHAR(255)
);

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

INSERT INTO `commodity`(`name`,`mallPrice`,`marketPrice`,`describe`,`image`,`classId`) VALUES
('白菜',299.0,500.0,'有机蔬菜','path',1);