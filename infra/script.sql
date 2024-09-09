create table auditoria(
    id int,
    nome varchar(50),
    dataHora datetime
);

insert into auditoria(id, nome, dataHora) values
(1, 'abc', now()),
(2, 'drf', now()),
(3, 'ghi', now());

SELECT * from auditoria;