. .dbconnection

liquibase --driver=$DRIVER \
          --changeLogFile=changelog.xml \
          --url=$URL \
          --username=$USER \
	  --password=$PASSWD \
          --logLevel=info \
            rollbackCount $1 

