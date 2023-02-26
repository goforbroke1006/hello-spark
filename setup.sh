#!/bin/bash

set -e

sudo apt update
sudo apt install maven -y

cd ~
if [[ ! -f spark-3.3.2-bin-hadoop3.tgz ]]; then
  wget https://dlcdn.apache.org/spark/spark-3.3.2/spark-3.3.2-bin-hadoop3.tgz
fi

tar -xzf spark-3.3.2-bin-hadoop3.tgz
sudo mv spark-3.3.2-bin-hadoop3 /opt/spark

echo '# Spark' >>~/.bashrc
echo 'export SPARK_HOME=/opt/spark' >>~/.bashrc
echo 'export PATH=$PATH:$SPARK_HOME/bin' >>~/.bashrc
