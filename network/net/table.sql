create table tblRegister(
    id varchar2(20) primary key,
    pwd char(20) not null,      -- 변경 가능하므로 미리 고정된 공간 확보
    name char(20) not null,
    regdate date default sysdate
);

insert into tblRegister values('aaa', '1234','홍길동', sysdate);
insert into tblRegister values('bbb', '1234','강도창', sysdate);
insert into tblRegister values('ccc', '1234','오지혁', sysdate);



create table tblMessage(    -- 메세지 테이블
    no number primary key,  -- 자동증가
    fid varchar2(20) not null,       -- 보내는 id (tblRegister 테이블의 id를 참조하므로 타입을 동일하게 설정한다.)
    tid varchar2(20) not null,       -- 받는 id
    msg varchar2(50) not null,    -- 메세지
    mdate timestamp default sysdate
);

create sequence msg_seq;    -- 시퀀스 생성

