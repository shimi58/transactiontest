INSERT INTO employee.member
 (id, name, phone, mail)
values
 (1, '森岡 陽介','03-1111-1111','morioka@aa.com'),
 (2, '浦田 康之','03-1111-1112','urata@aa.com'),
 (3, '大岩 尚人','03-1111-1113','oiwa@aa.com')
 ;
ALTER SEQUENCE employee.id RESTART WITH 100;


INSERT INTO employee.status
 (category, count)
values
 ('employee', '3')
;

