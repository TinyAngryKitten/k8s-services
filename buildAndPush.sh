imagename=tinyangrykitten/:latest
./mvnw package

docker build -f src/main/docker/Dockerfile.jvm -t $imagename --platform linux/amd64 .
docker push $imagename