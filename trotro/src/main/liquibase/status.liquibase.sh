. .dbconnection

liquibase --driver=$DRIVER \
          --classpath=$LIQUIBASECLASSPATH \
          --changeLogFile=changelog.xml \
          --url=$URL \
          --username=$USER \
          --password=$PASSWD \
          --logLevel=info \
            status 

