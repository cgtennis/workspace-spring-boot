### Tutorial Youtube URL
https://www.youtube.com/watch?v=lS1GwdIfk0c

However I can't launch docker directly from spring boot due to I don't have docker desktop. I'm using WSL.
That's why I need to define my own docker-compose.yaml in WSL and run the postgresql docker externally


### launch postgresql docker container from my WSL on the same machine
- ***docker-compose.yaml***
```
version: '3.1'

services:

  db:
    image: postgres
    restart: always
    ports:
      - "5432:5432"
    environment:
      POSTGRES_USERNAME: postgres
      POSTGRES_PASSWORD: password
      POSTGRES_DB: blog

```
to launch docker postgres, from the same folder run
```sh
docker-compose up -d
```
to check
```
docker ps
```
to connect to postgres container and run psql client
```sh
docker exec -it <container_id_or_name> bash
psql -U <username> -d <database>

```