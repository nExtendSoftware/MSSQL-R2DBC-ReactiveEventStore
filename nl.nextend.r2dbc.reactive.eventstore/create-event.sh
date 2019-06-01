#!/bin/bash
port=${1:-8080}

curl -H "content-type: application/json" -d '{"id":"generate","event":"onNew","version":"7.0.3","level":"20190531-1109"}' http://localhost:${port}/events