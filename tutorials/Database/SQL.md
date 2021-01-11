# SQL 

Linguagem para definir, manipular e questionar uma Base de Dados Relacional

SQL = DDL + DML + DQL + ...

* DDL: Data Definition Language
* DML: Data Manipulation Language
* DQL: Data Query Language

## Criação de Tabelas 

    create table <nometabela> (
      <nome coluna> <tipo coluna>,
      <nome coluna> <tipo coluna>);


## Remoção de Tabelas

    drop table <nometabela> 

## Tipos de Dados 

* char(n) - Cadeia de caracteres de tamanho fixo n.
* varchar(n) - Cadeia de caracteres com tamanho máximo n. 
* text - Cadeira de caracteres sem tamanho definido. 
* int - Números inteiros ( 4 bytes )
* numeric(precisão, escala) - Números reais sem limite de tamanho
* date e time - Data e hora 
* timestamp - Data + hora no mesmo camp 
* boolean - Valores booleanos


        create table empregado (
            bi integer, 
            nome varchar (256),
            salario numeric (9,2),
            datanascimento date
        ); 


### Valores por Omissão 

Podem ser definidos valores por omissão para cada coluna usando a palavra- chave default


        create table empregado (
            bi integer,
            nome varchar (256),
            salario numeric (9,2) default 0,
            datanascimento date
        ); 

## Restrições de Integridade 
* Check 
* Not Null 
* Unique (Chaves candidatas não primárias)
* Primary Key (Chave candidata primária)
* Foreign Key (Chaves estrangeiras)

### Restrições Check
Permitem garantir que umas ou mais coluna seguem uma determinada regra que pode ser expressa como uma expressão matemática. 


        create table empregado (
            bi integer,
            nome varchar (256),
            salario numeric (9,2) 
                default 0
                check (salario >= 0),
            datanascimento date
        ); 

Podemos e devemos dar sempre nome às restrições 

        create table empregado (
            bi integer,
            nome varchar (256),
            salario numeric (9,2)
                default 0
                constraint sal_positivo check (salario >= 0),
            datanascimento date
        ); 

No caso da restrição abranger mais do que uma coluna temos de usar uma restrição de tabela

        create table empregado (
            bi integer,
            nome varchar (256),
            salario numeric (9,2)
            descontos numeric (9,2)
            constraint desconto_menor_salario check (desconto < salario)
        ); 

### Restrições Not Null 
Para garantir que uma coluna não vai ter valores nulos 

        create table empregado (
            bi integer,
            nome varchar (256) not null
        ); 

### Restrições Chave Primária

Podemos definir uma, e só uma, chave primária para a tabela. 
Uma chave primária não pode conter valores nulos nem pode ter valores repetidos

        create table empregado (
            bi integer primary key,
            nome varchar (256) not null
        );

Uma chave primária pode ser composta por mais do que um atributo. Nesse caso temos de usar uma restrição da tabela 

        create table empregado (
            pnome varchar (256), 
            unome varchar (256), 
            datanascimento date, 
            primary key (pnome, unome)
        );

### Restrições Chaves Candidatas

Chaves candidatas alternativas podem ser definidas usando restrições do tipo unique.
Estas restrições são equivalentes às restrições da chave primária mas não obrigam os valores a ser não nulços

        create table empregado (
            bi integer primary key,
            nif integer unique, 
            salario numeric(9,2)
        );

Tal como as outras restrições devem ser nomeadas e no caso de incluirem mais do que uma coluna devem ser declaradas como restrições de tabela. 

        create table empregado (
            bi integer primary key,
            nif integer constraint nif_unique unique,
            pnome varchar (256),
            unome varchar (256),
            constraint nome_unico unique (pnome, unome)
        );

### Restrições de Chaves Estrangeiras 

Uma restrição do tipo foreign key permite declarar chaves estrangeiras. Uma chave estrangeira deve sempre referenciar uma chave primária ou única

        create table empregado (
            bi integer primary key,
            depid integer references departamento(id)
        );

No caso da coluna referenciada ser a chave primária de outra tabela, podemos omitir o nome da coluna referenciada

        create table empregado (
            bi integer primary key,
            depid integer references departamento
        );

No caso da chave estrangeira ser composta por mais de uma coluna usa-se uma restrição da tabela 

        create table empregado (
            bi integer primary key,
            rua varchar (256)
            cidade varchar (256)
            foreign key (rua,cidade) references rua
        );

## Exercício 

    Uma empresa pretende criar um sistema de informação para guardar informações referentes às tarefas a executar pelos seus empregados: 
    * Cada empregado tem um número identificativo (obrigatório e unico), um nome (obrigatório), uma morada (facultativa) e um contacto telefónico (obrigatório). 
    * Uma tarefa tem um id (único), um título, uma descrição, uma data limite de conclusão e uma data efetiva de conclusão. Todos os dados são obrigatórios exceto a data efetiva de conclusão que é apenas preenchida quando a tarefa for terminada. 
    * Uma tarefa pode depender de várias outras tarefas e pode ter várias tarefas que dependem dela. 
    * Quando uma tarefa é introduzida no sistema deve ficar registado qual o empregado que a introduziu (supervisor da tarefa). Não podem existir tarefas sem supervisor. Mais tarde, a tarefa é atribuida a um empregado (executante). 
    * Numa tarefa podem ser utilizados vários tipos de peças. Um tipo de peça é caracterizado por uma referência (única), um nome e uma quantidade em stock. Todos estes dados são obrigatórios.