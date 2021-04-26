CREATE TABLE `ssafy_ws_5th`.`product` (
  `id` VARCHAR(30) NOT NULL,
  `name` VARCHAR(45) NULL,
  `company` VARCHAR(45) NULL,
  `price` INT NULL,
  `description` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `ssafy_ws_5th`.`product` (`id`, `name`, `company`, `price`, `description`) VALUES ('1000', 'TV', 'Samsung', '500000', '삼성 OLED 55인치');
INSERT INTO `ssafy_ws_5th`.`product` (`id`, `name`, `company`, `price`) VALUES ('2000', 'PC', 'Apple', '2500000');
