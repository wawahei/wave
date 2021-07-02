create table  `T_DICT_VALUE`
(
       `VALUE_ID`        int not null AUTO_INCREMENT comment '字典值ID 序列',
       `TYPE_CODE`       VARCHAR(100) not null comment '字典类型编码 字典类型编码',
       `VALUE_CODE`      VARCHAR(100) comment '字典值 字典值',
       `VALUE_NAME`      VARCHAR(100) comment '字典值展示名称 字典值展示名称',
       `VALUE_DESC`      VARCHAR(200) comment '描述 描述',
       `CREATE_TIME`     DATETIME comment '创建时间 创建时间',
       `UPDATE_TIME`     DATETIME comment '最后更新时间 最后更新时间',
       `IS_DELETED`      TINYINT comment '状态 状态 0:正常  1: 删除',
       `GROUP_ID`        NUMERIC(10) comment '集团ID 集团ID',
	   primary key (`VALUE_ID`)
);

alter table `T_DICT_VALUE` comment= '字典值表 GROUP_ID为0的数据为初始化数据';


create table  `T_DICT_TYPE`
(
       `TYPE_ID`         int not null AUTO_INCREMENT comment '字典类型ID 字典类型ID',
       `TYPE_CODE`       VARCHAR(100) not null comment '字典类型编码 字典类型编码',
       `TYPE_NAME`       VARCHAR(100) not null comment '字典类型名称 字典类型名称',
       `CREATE_TIME`     DATETIME comment '创建时间 创建时间',
       `UPDATE_TIME`     DATETIME comment '最后更新时间 最后更新时间',
       `IS_DELETED`      TINYINT comment '状态 状态 0:正常  1: 删除',
       `GROUP_ID`        NUMERIC(10) comment '集团ID 集团ID',
	   primary key (`TYPE_ID`)
);

alter table `T_DICT_TYPE` comment= '字典类型表 GROUP_ID为0的数据为初始化数据';


create table  `T_USER`
(
       `USER_ID`         int not null AUTO_INCREMENT comment '用户ID 序列' ,
       `USER_NO`         VARCHAR(50) comment '工号 员工工号',
       `USER_NAME`       VARCHAR(200) not null comment '用户姓名',
       `USER_MOBILE`     VARCHAR(20) comment '用户手机号 用户手机号',
       `USER_GENDER`     TINYINT comment '用户性别 用户性别',
       `USER_EMAIL`      VARCHAR(100) comment '用户邮箱 用户邮箱',
       `USER_BIRTHDAY`   VARCHAR(30) comment '用户生日 用户生日',
       `USER_ADDR`       VARCHAR(500) comment '用户地址 用户地址',
       `USER_DESC`       VARCHAR(500) comment '用户描述 用户描述',
       `USER_LOGIN_ACCOUNT` VARCHAR(200) comment '登录账号 登录账号',
       `USER_LOGIN_PWD`  VARCHAR(100) comment '登录密码 登录密码',
       `IS_DELETED`      TINYINT comment '用户状态 用户状态:0 正常  1 删除  2：冻结',
       `CREATE_TIME`     DATETIME comment '创建时间 创建时间',
       `UPDATE_TIME`     DATETIME comment '最后更新时间 最后更新时间',
	   primary key (`USER_ID`)
);

alter table `T_USER` comment= '用户表';

