S
INSERT INTO WEB_MEMBER VALUES('test1','test','testest','test');
INSERT INTO WEB_MEMBER VALUES('admin','1234','0000','멋이당게');

-- 1. 회원의 정보를 관리할 수 있는 테이블 생성 --
create table web_member(
	email varchar2(50) primary key,
	pw varchar2(50) not null,
	tel varchar2(50) not null,
	address varchar2(50) not null
);

SELECT * FROM WEB_MEMBER;
		SELECT case when count(*)>0 then 1 else 0 end result FROM wen_member WHERE email=#{email}

DELETE FROM WEB_MEMBER;


--메세지의 번호, 보배는 사람, 받는 사람, 내용, 보낸 날짜--

create table web_message(
	num number primary key,
	sendName varchar2(50) not null,
	receiveEmail varchar2(50) not null,
	message varchar2(100) not null,
	m_date date
);

SELECT * FROM web_message;

CREATE SEQUENCE num_message
  START WITH 1
  INCREMENT BY 1;
  
  insert into web_message VALUES(num_message.nextval,'csm','tests','test Message1',sysdate);
  insert into web_message VALUES(num_message.nextval,'smhrd','tests','test Message2',sysdate);
  
  
  
  create table web_board(
  	num number primary key,
  	title varchar(50) not null,
  	writer varchar2(50) not null,
  	filename varchar2(100),
  	content varchar2(100) not null,
	b_date date
);

CREATE SEQUENCE num_board
  START WITH 1
  INCREMENT BY 1;
  
SELECT * FROM web_board;
  
  insert into web_board values(num_board.nextVal,'csm','tests','tests','test Message1',sysdate);
  

