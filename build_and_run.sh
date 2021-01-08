#!/bin/bash
set -e

pushd DTUPay-server

mvn package

popd

docker-compose up -d

# Start the server in the background so that the
# shell script is not blocked and can execute the tests
# java -Dquarkus.http.port=1617 -jar target/DTUPay-server-1.0.0-SNAPSHOT-runner.jar &

# Remember the process id of the server process
# so that we can shutdown the server after the tests
# are run.
# Later, when we use docker, we are going to have better
# options available.
# server_pid=$!

# Install a hook that on err or on normal exit of this script,
# the server is killed, so that we can run the script again
# trap 'kill $server_pid' err exit

# popd

# Give the Web server a chance to finish start up
# sleep 2s 

#pushd DTUPay-client
#mvn test
#popd
