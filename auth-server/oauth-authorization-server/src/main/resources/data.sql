create table if not exists users(
  username varchar(64) not null primary key,
  password varchar(64) not null,
  email varchar(128),
  cpf varchar(14),
  firstName varchar(128) not null,
  lastName varchar(128) not null,
  birthDate DATE not null );

delete from users;
insert into users(username,password,email, cpf, firstName, lastName,birthDate) values('demo','demo','jean.premier@example.com', '22222222222', 'Jean', 'Premier', PARSEDATETIME('1970-01-01','yyyy-MM-dd'));
