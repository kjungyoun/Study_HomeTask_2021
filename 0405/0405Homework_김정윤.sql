use ssafydb;

-- 1. DDL (Data Definition Language) 테이블 생성
create table product(
	prodno 		int auto_increment,
    prodname	varchar(30) not null,
    price		int not null,
    constraint primary key(prodno)
);

-- 2. DML (Data Manipulation Language) 데이터 삽입
insert into product (prodname, price) values('TV',3000000);
insert into product (prodname, price) values('냉장고',2500000);
insert into product (prodname, price) values('노트북',2350000);
insert into product (prodname, price) values('핸드폰',1270000);
insert into product (prodname, price) values('피아노',350000);
insert into product (prodname, price) values('전동드릴',40000);
insert into product (prodname, price) values('컴퓨터',1732000);
insert into product (prodname, price) values('TV홈시어터',1020000);
insert into product (prodname, price) values('TV다이',325000);

-- 3. DML Select 데이터 출력
select prodno, prodname, price as "정가", price*0.75 as "할인 가격"
from product;

-- 4. DML Update & Select
update product set price = price * 0.8
where prodname like "%TV%";

select * from product
order by price;

-- 5. DML Select (sum)
select sum(price) as "총 금액"
from product;