## elastic search ##

1. docker pull docker.elastic.co/elasticsearch/elasticsearch:6.1.3

2. docker run -d --name es -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.1.3