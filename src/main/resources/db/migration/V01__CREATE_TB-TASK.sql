-- create database db_task_menager;
-- use db_task_menager;

create table if not exists tb_task (
    id bigint not null auto_increment,
    title varchar (60) not null,
    description varchar (255) null,
    is_completed boolean not null default false,
    constraint pk_task primary key (id)
);