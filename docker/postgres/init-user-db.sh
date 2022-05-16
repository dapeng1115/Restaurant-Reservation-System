#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE dblocation;
    GRANT ALL PRIVILEGES ON DATABASE dblocation TO dbuser;
    CREATE DATABASE dbinvoicing;
    GRANT ALL PRIVILEGES ON DATABASE dbinvoicing TO dbuser;
    CREATE DATABASE dborder;
    GRANT ALL PRIVILEGES ON DATABASE dborder TO dbuser;
EOSQL
