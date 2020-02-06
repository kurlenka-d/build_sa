FROM debian:stretch-slim

RUN apt update \
    && apt upgrade -y \
    && apt install --no-install-recommends --no-install-suggests -y nginx \
    && rm -rf /var/lib/apt/lists/*
    # Clear up the cache also

USER www-data
