# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product (
  ean                       varchar(255) not null,
  name                      varchar(255),
  description               varchar(255),
  picture                   varbinary(255),
  constraint pk_product primary key (ean))
;

create sequence product_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists product;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product_seq;
