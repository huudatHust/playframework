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

create table stock_item (
  id                        bigint not null,
  product_ean               varchar(255),
  quantity                  bigint,
  constraint pk_stock_item primary key (id))
;

create sequence product_seq;

create sequence stock_item_seq;

alter table stock_item add constraint fk_stock_item_product_1 foreign key (product_ean) references product (ean) on delete restrict on update restrict;
create index ix_stock_item_product_1 on stock_item (product_ean);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists product;

drop table if exists stock_item;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists product_seq;

drop sequence if exists stock_item_seq;

