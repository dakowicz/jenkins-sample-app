alter system set processes=300 scope=spfile;
alter system set sessions=480 scope=spfile;
commit;

ALTER PROFILE DEFAULT LIMIT PASSWORD_GRACE_TIME UNLIMITED;
