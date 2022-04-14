DROP TABLE IF EXISTS cv CASCADE;
DROP TABLE IF EXISTS experiencia CASCADE;
DROP TABLE IF EXISTS educacao CASCADE;
DROP TABLE IF EXISTS secoes CASCADE;

create table cv (
  id uuid not null,
  conhecimentos varchar(255) not null,
  nome varchar(255) not null,
  email varchar(255) not null,
  cargo varchar(255) not null,
  sumario varchar(2000) not null,
  idioma varchar(255) not null,
  status int4 not null,
  primary key (id)
  );

create table experiencia (
  id uuid not null,
  cargo varchar(255) not null,
  data_inicio date not null,
  data_termino date,
  atividades varchar(255) not null,
  primary key (id)
  );

create table educacao (
  id uuid primary key  not null,
  nome_instituicao varchar(255) not null,
  curso varchar(255) not null,
  data_inicio date not null,
  data_termino date
  );

create table secoes (
  id uuid primary key  not null,
  titulo varchar(255) not null,
  campo_texto varchar(2000) not null
  );