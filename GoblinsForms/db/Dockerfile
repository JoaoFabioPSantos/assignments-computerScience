FROM postgres:16-alpine

ENV POSTGRES_DB=goblins_db
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=password123

COPY ./init.sql /docker-entrypoint-initdb.d/