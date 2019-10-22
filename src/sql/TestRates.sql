/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     19.10.2019 18:22:14                          */
/*==============================================================*/


drop index MNEMONICS_IND;

drop table dbo.currencies;

drop table dbo.rates;

/*==============================================================*/
/* Table: currencies                                            */
/*==============================================================*/
create table currencies (
  code                 INT4                 not null,
  mnemonics            CHAR(3)              not null,
  description          VARCHAR(35)          null,
  constraint PK_CURRENCIES primary key (code)
);

comment on table currencies is
'Справочник валют';

/*==============================================================*/
/* Index: MNEMONICS_IND                                         */
/*==============================================================*/
create  index MNEMONICS_IND on currencies (
  mnemonics
);

/*==============================================================*/
/* Table: rates                                                 */
/*==============================================================*/
create table rates (
  cdate                INT8                 not null,
  code                 INT4                 not null,
  buy                  DECIMAL(15,5)        not null,
  sell                 DECIMAL(15,5)        not null,
  constraint PK_RATES primary key (cdate, code)
);

comment on table rates is
'Курсы валют';

alter table rates
  add constraint FK_RATES_FK_RATES__CURRENCI foreign key (code)
references currencies (code)
on delete restrict on update restrict;
