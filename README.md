# test-micro
微服务玩玩

1. nacos install
   standalone   
        startup.cmd -m standalone
2. sentinel install
   java -Dserver.port=8089 -Dcsp.sentinel.dashboard.server=localhost:8089 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.1.jar
   

-------------------------------------------------------------------------------------------------------------------------------------
zabbix  server部署：
docker run -itd --name zabbix-mysql \
-e MYSQL_USER="zabbix" \
-e MYSQL_PASSWORD="123=abc" \
-e MYSQL_ROOT_PASSWORD="123=abc" \
-v /www/server/zabbix/mysql/data/:/var/lib/mysql/ \
-p 3307:3306 \
mariadb \
--character-set-server=utf8 \
--collation-server=utf8_unicode_ci


docker run -itd --name "zabbix-server" \
--link zabbix-mysql:mysql \
-e DB_SERVER_HOST="192.168.244.135" \
-e DB_SERVER_PORT=3307 \
-e MYSQL_DATABASE="zabbix" \
-e MYSQL_ROOT_PASSWORD="123=abc" \
-e MYSQL_USER="zabbix" \
-e MYSQL_PASSWORD="123=abc" \
-v /www/server/zabbix/zabbix-server/alertscripts/:/usr/lib/zabbix/alertscripts/ \
-v /www/server/zabbix/zabbix-server/externalscripts/:/usr/lib/zabbix/externalscripts/ \
-p 10051:10051 \
zabbix/zabbix-server-mysql

docker run -itd --name zabbix-web \
--link zabbix-mysql:mysql \
--link zabbix-server:zabbix-server \
-e DB_SERVER_HOST=192.168.244.135 \
-e DB_SERVER_PORT=3307 \
-e MYSQL_USER=zabbix \
-e MYSQL_PASSWORD=123=abc \
-e MYSQL_DATABASE=zabbix \
-e ZBX_SERVER_HOST=zabbix-server \
-e PHP_TZ="Asia/Shanghai" \
-p 8880:8080 \
-p 8443:8443 \
zabbix/zabbix-web-nginx-mysql

zabbix agent 部署
-----------------------------------------------------------------------------------------------------------------------------------
Prometheus 部署

docker run -d -p 9100:9100 \
-v "/proc:/host/proc:ro" \
-v "/sys:/host/sys:ro" \
-v "/:/rootfs:ro" \
--net="host" \
prom/node-exporter

docker run  -d \
-p 9090:9090 \
-v /usr/local/prometheus/prometheus.yml:/etc/prometheus/prometheus.yml  \
prom/prometheus

docker run -d \
-p 3000:3000 \
--name=grafana \
-v /usr/local/grafana-storage:/var/lib/grafana \
grafana/grafana

-----------------------------------------------------------------------------------------------------------------------
skywalking部署

docker pull docker.elastic.co/elasticsearch/elasticsearch:6.8.13

docker run --name elasticsearch -p 9200:9200 -p 9300:9300  \
-e "discovery.type=single-node" -e ES_JAVA_OPTS="-Xms512m -Xmx512m" -d docker.elastic.co/elasticsearch/elasticsearch:6.8.13

docker pull apache/skywalking-base:8.3.0-es6  
docker pull apache/skywalking-oap-server:8.3.0-es6  
docker pull apache/skywalking-ui:8.3.0
docker run --name skywalking-oap --restart always \
-p 1234:1234 -p 11800:11800 -p 12800:12800 -d \
--link elasticsearch:elasticsearch -e SW_STORAGE=elasticsearch \
-e SW_STORAGE_ES_CLUSTER_NODES=elasticsearch:9200 apache/skywalking-oap-server:8.3.0-es6

docker run --name skywalking-ui --restart always -p 9898:8080 \
--link skywalking-oap:skywalking-oap -d \
-e SW_OAP_ADDRESS=skywalking-oap:12800 apache/skywalking-ui:8.3.0

-javaagent:/path/to/skywalking-agent/skywalking-agent.jar -Dskywalking.agent.service_name=my-App-name -Dskywalking.collector.backend_service=localhost:11800


---------------------------------------------------------------------------------------------------------------------------------------------------------
rocketmq docker单机部署
#namesrv
docker run -d -p 9876:9876 -v /www/mq/data/namesrv/logs:/root/logs \
-v /www/mq/data/namesrv/store:/root/store \
--name rmqnamesrv \
-e "JAVA_OPTS=-Duser.home=/opt" -e "JAVA_OPT_EXT=-server -Xms300m -Xmx512m" \
rocketmqinc/rocketmq sh mqnamesrv

#broker
docker run -d -p 10911:10911 -p 10909:10909 \
-v /www/mq/data/broker/logs:/root/logs \
-v /www/mq/rocketmq/data/broker/store:/root/store \
-v /www/mq/conf/broker.conf:/opt/rocketmq/conf/broker.conf \
--name rmqbroker \
-e "NAMESRV_ADDR=10.60.48.183:9876" -e "JAVA_OPTS=-Duser.home=/opt" \
-e "JAVA_OPT_EXT=-server -Xms200m -Xmx512m" \
rocketmqinc/rocketmq sh mqbroker -c /opt/rocketmq/conf/broker.conf

#console
docker run -e "JAVA_OPTS=-Drocketmq.config.namesrvAddr=10.60.48.183:9876 \
-Drocketmq.config.isVIPChannel=false" -p 9993:8080 -t styletang/rocketmq-console-ng