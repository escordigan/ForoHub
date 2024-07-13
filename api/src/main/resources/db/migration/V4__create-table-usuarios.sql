create table usuarios(

    id bigint not null auto_increment,
	email varchar(100) unique not null,
	password varchar(100) not null,

	primary key(id)
);