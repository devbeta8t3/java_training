create table tblMember (
    id number PRIMARY KEY,
    name varchar2(20) not null,
    phone varchar2(20) not null,
    address varchar2(50) not null,
    team varchar2(20) not null
);
desc tblMember;
SELECT * FROM tblMember;
create SEQUENCE mem_seq;

create table tblZipcode (
    zipcode varchar2(5) not null,
    area1 varchar2(10),
    area2 varchar2(20),
    area3 varchar2(30)
);