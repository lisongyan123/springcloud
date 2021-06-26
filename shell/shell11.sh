#!/usr/bin/env bash

docker pull pingcap/tidb:latest
docker pull pingcap/tikv:latest
docker pull pingcap/pd:latest
mkdir C:/Users/w/Desktop/tidb


docker run -d --name tikv1 \
  -p 20160:20160 \
  --ulimit nofile=1000000:1000000 \
  pingcap/tikv:latest \
  --addr="0.0.0.0:20160" \
  --advertise-addr="localhost:20160" \
  --data-dir="/tidb/tikv1" \
  --pd="localhost:2379"
docker run -d --name tikv2 \
  -p 20161:20161 \
  --ulimit nofile=1000000:1000000 \
  pingcap/tikv:latest \
  --addr="0.0.0.0:20161" \
  --advertise-addr="localhost:20161" \
  --data-dir="/tidb/tikv2" \
  --pd="localhost:2379"

docker run -d --name tikv3 \
  -p 20162:20162 \
  --ulimit nofile=1000000:1000000 \
  pingcap/tikv:latest \
  --addr="0.0.0.0:20162" \
  --advertise-addr="localhost:20162" \
  --data-dir="/tidb/tikv3" \
  --pd="localhost:2379"