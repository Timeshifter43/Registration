CREATE table tenderusers(
  id int not null auto_increment,
  firstName varchar(30) not null ,
  lastName varchar(30) not null ,
  patronymic varchar(30) not null ,
  userName varchar(30) not null ,
  password varchar(30) not null,
  primary key (id)
  )
