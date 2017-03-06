#SQL入门
SQL命令的类型
* 数据定义语言（DDL）：定义数据库结构
  creat table,alter table,drop table,create index,alter index,drop index,create view,drop view
* 数据操作语言（DML）
  insert,update,delete
* 数据查询语言（DQL）
  select
* 数据控制语言（DCL）：用于控制对数据库的访问
  alter password,grant,revoke,create synonym
* 数据管理命令
  start audit
  stop audit
* 事务控制命令
  commit：保存数据库事务
  rollback：撤销数据库事务
  savepoint：在一组事务里创建保存点用于回退
  set transaction：设置事务名称