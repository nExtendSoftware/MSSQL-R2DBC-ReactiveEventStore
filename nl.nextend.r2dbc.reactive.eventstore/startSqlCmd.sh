#!/bin/bash
set -e

wait_time=10s 
password=Passwo0RD!

# wait for SQL Server to come up
echo creating database will start in $wait_time...
sleep $wait_time

echo running CreateDatabase...
/opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P $password -i create-db.sql

exec "$@"