# Docker Commands
1. `docker run --name customer-mongo -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin mongodb/mongodb-community-server:latest`
2. `docker run --name seller-mongo -p 27018:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin mongodb/mongodb-community-server:latest`

# MongoDB inital Setup in Docker
1. `docker exec -it <MONGODB_CONTAINER_ID> mongosh`
2. `use admin`
3. `db.auth( 'admin', 'admin' )`
4. `db.createUser({ user:'rhythm',pwd:'123456',roles:[ { role:'readWrite', db: 'DB_NAME'}]});`