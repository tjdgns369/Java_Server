create table people1(name varchar2(50), major varchar2(50), phone varchar2(50));

insert into PEOPLE1 values('송승호', '정보통신공학과','010-9278-5713');
insert into PEOPLE1 values('임정민', '중국어학과','010-1234-5678');
insert into PEOPLE1 values('강성훈', '체육학과','010-5678-1234');

select * from PEOPLE1;

delete from PEOPLE1 where name='강성훈';