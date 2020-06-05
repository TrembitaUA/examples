
DECLARE
  l_acl_name         VARCHAR2(30) := 'UXPCLIENT.xml';
  l_server_ip        VARCHAR2(20) := '192.168.1.52';
  l_server_name      VARCHAR2(20); -- := 'ftp.oracle.com';
  l_username         VARCHAR2(30) := 'C##UXPCLIENT';
BEGIN
  DBMS_NETWORK_ACL_ADMIN.create_acl (
    acl          => l_acl_name, 
    description  => 'Allow connections using UTL_TCP',
    principal    => l_username,
    is_grant     => TRUE, 
    privilege    => 'connect',
    start_date   => SYSTIMESTAMP,
    end_date     => NULL);

  COMMIT;

  DBMS_NETWORK_ACL_ADMIN.add_privilege ( 
    acl         => l_acl_name, 
    principal   => l_username,
    is_grant    => FALSE, 
    privilege   => 'connect', 
    position    => NULL, 
    start_date  => NULL,
    end_date    => NULL);

  COMMIT;

  DBMS_NETWORK_ACL_ADMIN.assign_acl (
    acl         => l_acl_name,
    host        => l_server_ip, 
    lower_port  => 80,
    upper_port  => 80);
    
    IF l_server_name is not null THEN
        DBMS_NETWORK_ACL_ADMIN.assign_acl (
            acl         => l_acl_name,
            host        => l_server_name, 
            lower_port  => 80,
            upper_port  => 80);
    end if;

  COMMIT;
END;
/

quit;
