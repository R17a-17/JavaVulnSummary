create database users;
use users;
create table user
(
    id       INT(20) NOT NULL,
    name     VARCHAR(20),
    password VARCHAR(20),
    date DATE,
    PRIMARY KEY (id)
) engine = innodb
  default charset = 'utf8';
insert into user values(1,'zhansan','111','2021-01-01');
insert into user values(2,'lisi','111','2021-01-01');
insert into user values(3,'wangwu','111','2021-01-01');
insert into user values(4,'wangqiang','111','2021-01-01');