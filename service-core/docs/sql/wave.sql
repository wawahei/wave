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