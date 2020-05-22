create database aula;
use aula;

create table t_aula_artista(
codigo int auto_increment,
nomeartistico varchar(100),
nacionalidade varchar(20),
cadastro Date,
primary key (codigo)
);

create table t_aula_musica(
codigo int auto_increment,	
titulo varchar(100),
ano int,
codartista int,
primary key (codigo),
foreign key (codartista) references t_aula_artista(codigo)
);

use aula;
create table t_aula_usuario(
id int auto_increment,
nome varchar(40),
email varchar(50),
senha varchar(15),
foto varchar(100),
primary key(id)
);

select * from aula.t_aula_artista;
select * from aula.t_aula_musica;
select * from aula.t_aula_usuario;


--drop table t_aula_artista;
--drop table t_aula_musica;

 insert into aula.t_aula_usuario (nome, email, senha, foto)
values ("Vanessa", "vanessa.nunez.p@gmail.com", "1234", "vanessa.jpg");


 insert into aula.t_aula_usuario (nome, email, senha, foto)
values ("Chico", "chico.frederico@gmail.com", "1234", "chico.jpg");

update t_aula_usuario
set foto="images/\vanessa.png"
where id=1;

select * from t_aula_usuario;


