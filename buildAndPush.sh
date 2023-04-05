imagename=tinyangrykitten/http-mqtt:latest
./gradlew build -Dquarkus.package.type=native

docker build -f src/main/docker/Dockerfile.native-micro -t $imagename --platform linux/amd64 .
docker push $imagename