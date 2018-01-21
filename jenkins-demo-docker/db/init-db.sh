#!/bin/sh
/u01/app/oracle/product/11.2.0/xe/bin/sqlplus sys/oracle as sysdba < /db-tmp/db_configuration.sql
/u01/app/oracle/product/11.2.0/xe/bin/sqlplus system/oracle < /db-tmp/db-tablespaces.sql
/u01/app/oracle/product/11.2.0/xe/bin/sqlplus sys/oracle as sysdba < /db-tmp/db-users.sql
