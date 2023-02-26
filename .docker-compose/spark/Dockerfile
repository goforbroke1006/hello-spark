FROM debian:bullseye-slim

RUN apt update && apt upgrade -y

RUN apt install curl wget zip unzip -y

RUN apt-get install procps -y

RUN apt-get install -y --no-install-recommends openjdk-11-jre
RUN java --version

RUN wget https://dlcdn.apache.org/spark/spark-3.3.2/spark-3.3.2-bin-hadoop3.tgz && \
    tar -xzf spark-3.3.2-bin-hadoop3.tgz && \
    mv spark-3.3.2-bin-hadoop3 /opt/spark && \
    rm -f spark-3.3.2-bin-hadoop3.tgz
ENV SPARK_HOME=/opt/spark

ENV SPARK_MASTER_PORT=7077
    SPARK_MASTER_WEBUI_PORT=8080
    SPARK_WORKER_CORES=1
    SPARK_WORKER_MEMORY=1G

WORKDIR /opt/spark

COPY ./.docker-compose/spark/entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh
ENTRYPOINT /entrypoint.sh

# master
EXPOSE 8080 7077

# worker
EXPOSE 8081
