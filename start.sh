#!/bin/bash
nohup java -jar animateBackend-0.0.1-SNAPSHOT.jar > app.log 2>&1 &
echo $! > app.pid 