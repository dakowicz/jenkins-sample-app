FROM thebookpeople/oracle-xe-11g

RUN	mkdir /db-tmp
ADD	db-tablespaces.sql /db-tmp/
ADD	db-users.sql /db-tmp/
ADD	db_configuration.sql /db-tmp/
ADD	init-db.sh /db-tmp/

ENV	ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe
ENV ORACLE_SID=XE

VOLUME ["/db-tmp"]

EXPOSE 22 1521 8080

RUN apt-get update && \
    apt-get install tzdata && \
    echo "Europe/Warsaw" > /etc/timezone && \
    dpkg-reconfigure -f noninteractive tzdata && \
	chmod +x /db-tmp/init-db.sh && \
	/usr/sbin/startup.sh && sleep 2 && \
	/db-tmp/init-db.sh && \
	service oracle-xe stop

CMD	/usr/sbin/startup.sh && sleep 2 && /usr/sbin/sshd -D

