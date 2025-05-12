`ssh -L localhost:27600:0.0.0.0:27600 -L localhost:27602:0.0.0.0:27602 s408778@se.ifmo.ru -p 2222`

`
./bin/standalone.sh -b 0.0.0.0 \
-Dcom.sun.management.jmxremote \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.ssl=false \
-Dcom.sun.management.jmxremote.port=9990 \
-Dcom.sun.management.jmxremote.rmi.port=9990 \
-Djava.rmi.server.hostname=0.0.0.0 \
-Djboss.bind.address.management=0.0.0.0 \
-Djboss.bind.address=0.0.0.0
`

`
jconsole -J-Djava.class.path=/home/techeretic/Documents/OPI/lab3/jboss-cli-client.jar
`

`
visualvm --cp:a /home/techeretic/Documents/OPI/lab3/jboss-cli-client.jar
`

`
service:jmx:remote+http://0.0.0.0:27602
`

`
service:jmx:remote+http://localhost:9990
`