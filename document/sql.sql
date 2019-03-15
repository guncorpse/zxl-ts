CREATE DATABASE zxl_ts DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE zxl_ts;
/*==============================================================*/
  --  用户      zxl_ts_user
/*==============================================================*/
drop table if exists zxl_ts_user;
create table zxl_ts_user(
    ID                            char(36)            character set utf8 collate utf8_bin    not null comment '用户编号',
    NAME                          varchar(32)         character set utf8 collate utf8_bin    not null comment '用户昵称',
    ACCOUNT                       varchar(32)         character set utf8 collate utf8_bin    not null comment '用户账号',
    PASSWORD                      varchar(32)         character set utf8 collate utf8_bin    not null comment '用户密码',    
    IS_ADMIN                      char(1)             character set utf8 collate utf8_bin    not null comment '是否是管理员',        
    primary key(ID),
    unique key (ACCOUNT)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '用户';

/*==============================================================*/
  --  书籍      zxl_ts_book
/*==============================================================*/
drop table if exists zxl_ts_book;
create table zxl_ts_book(
    ID                            char(36)            character set utf8 collate utf8_bin    not null comment '书籍编号',
    DOUBAN_ID                     varchar(32)         character set utf8 collate utf8_bin        null comment '豆瓣编号',
    TITLE                         varchar(255)        character set utf8 collate utf8_bin        null comment '标题',
    SUBTITLE                      varchar(255)        character set utf8 collate utf8_bin        null comment '子标题',
    AUTHOR                        varchar(255)        character set utf8 collate utf8_bin        null comment '作者',    
    TRANSLATOR                    text                character set utf8 collate utf8_bin        null comment '翻译',  
    CATALOG                       text                character set utf8 collate utf8_bin        null comment '章节',
    EBOOK_URL                     varchar(64)         character set utf8 collate utf8_bin        null comment '电子书链接',
    ORIGIN_TITLE                  varchar(255)        character set utf8 collate utf8_bin        null comment '原标题',
    IMAGE                         varchar(255)        character set utf8 collate utf8_bin        null comment '封面图',
    PAGES                         varchar(32)          character set utf8 collate utf8_bin        null comment '页数',
    ALT                           varchar(64)         character set utf8 collate utf8_bin        null comment 'alt地址',
    PUBLISHER                     varchar(64)         character set utf8 collate utf8_bin        null comment '出版社',
    ISBN10                        varchar(16)         character set utf8 collate utf8_bin        null comment '10位ISBN',
    ISBN13                        varchar(16)         character set utf8 collate utf8_bin        null comment '13位ISBN',
    AUTHOR_INTRO                  text                character set utf8 collate utf8_bin        null comment '作者简介',
    SUMMARY                       text                character set utf8 collate utf8_bin        null comment '书籍简介',
    EBOOK_PRICE                   varchar(32)         character set utf8 collate utf8_bin        null comment '电子书价格',
    PRICE                         varchar(32)         character set utf8 collate utf8_bin        null comment '价格',
    BINDING                       varchar(32)         character set utf8 collate utf8_bin        null comment '装订',
    TAGS                          text                character set utf8 collate utf8_bin        null comment '标签',
    PUBDATE                       varchar(16)         character set utf8 collate utf8_bin        null comment '出版时间',
 	CREATE_TIMESTAMP              BIGINT                                                         null comment '创建时间',
    primary key(ID)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '书籍';

/*==============================================================*/
  --  收藏夹      zxl_ts_favorite
/*==============================================================*/
drop table if exists zxl_ts_favorite;
create table zxl_ts_favorite(
    ID                            char(36)            character set utf8 collate utf8_bin    not null comment '收藏编号',
    USER_ID                       char(36)            character set utf8 collate utf8_bin    not null comment '用户编号',
    USER_NAME                     varchar(32)         character set utf8 collate utf8_bin    not null comment '用户名称',
    BOOK_ID                       char(36)            character set utf8 collate utf8_bin    not null comment '书籍编号',    
    BOOK_NAME                     varchar(32)         character set utf8 collate utf8_bin    not null comment '书籍名称',
    BOOK_ALT                      varchar(64)         character set utf8 collate utf8_bin    not null comment '书籍链接',
    BOOK_AUTHOR                   varchar(128)        character set utf8 collate utf8_bin    not null comment '书籍作者',
    BOOK_IMAGE                    varchar(255)        character set utf8 collate utf8_bin    not null comment '书籍封面',
    SC_TIMESTAMP                  BIGINT                                                     not null comment '收藏时间',        
    primary key(ID)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '收藏夹';

