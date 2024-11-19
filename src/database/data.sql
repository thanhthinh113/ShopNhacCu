
USE NhacCu
-- Thêm danh mục nhạc cụ
INSERT INTO `NhacCu`.`category` (`name`) VALUES ('Guitar');
INSERT INTO `NhacCu`.`category` (`name`) VALUES ('Piano');
INSERT INTO `NhacCu`.`category` (`name`) VALUES ('Violin');

-- Thêm sản phẩm nhạc cụ
INSERT INTO `NhacCu`.`product` (`description`, `image_name`, `name`, `price`, `weight`, `category_id`) 
VALUES ('Classic acoustic guitar with excellent sound quality and craftsmanship.', 'Dan-Acoustic-guitar-F310.jpg', 'Acoustic Guitar', '150', '3000', '1');
INSERT INTO `NhacCu`.`product` (`description`, `image_name`, `name`, `price`, `weight`, `category_id`) 
VALUES ('A grand piano with rich sound and elegant design.', 'dan-piano-dien-roland-fp-e50.jpg', 'Grand Piano', '5000', '40000', '2');
INSERT INTO `NhacCu`.`product` (`description`, `image_name`, `name`, `price`, `weight`, `category_id`) 
VALUES ('A lightweight electric violin with a modern design and excellent tone.', 'dan-violin-xtq-001-3-4.jpg', 'Electric Violin', '1200', '1000', '3');
INSERT INTO `NhacCu`.`product` (`description`, `image_name`, `name`, `price`, `weight`, `category_id`) 
VALUES ('Beginner-friendly keyboard with 61 keys and built-in speakers.', 'dan-piano-dien-roland-rp-107_4626.jpg', 'Electronic Keyboard', '250', '7000', '2');
INSERT INTO `NhacCu`.`product` (`description`, `image_name`, `name`, `price`, `weight`, `category_id`) 
VALUES ('This 12-string guitar offers a rich, full sound ideal for live performances.', 'Dan-guitar-Acoustic-TAYLOR-214CE.jpg', '12-String Guitar', '600', '3200', '1');
INSERT INTO `NhacCu`.`product` (`description`, `image_name`, `name`, `price`, `weight`, `category_id`) 
VALUES ('An expertly crafted violin made from premium maple and spruce.', 'dan-violin-xtq-002-2-4.jpg', 'Classic Violin', '800', '600', '3');
INSERT INTO `NhacCu`.`product` (`description`, `image_name`, `name`, `price`, `weight`, `category_id`) 
VALUES ('Compact digital piano with realistic touch and sound quality.', 'dan-piano-yamaha-ydp-105b.jpg', 'Digital Piano', '900', '10000', '2');

INSERT INTO `NhacCu`.`roles` (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO `NhacCu`.`roles` (`name`) VALUES ('ROLE_USER');

