ARG BUILD_FROM=ghcr.io/hassio-addons/base:20.1.0

# hadolint ignore=DL3006
FROM ${BUILD_FROM}
# Add env
ENV LANG C.UTF-8

# Set shell
SHELL ["/bin/bash", "-o", "pipefail", "-c"]

ARG FLOOD_VER=v4.13.9

RUN apk --no-cache add \
    bash \
    coreutils \
    gcompat \
    git \
    pythonispython3 \
    python3 \
    binutils \
    ca-certificates \
    ncurses-terminfo-base \
    findutils \
    mktorrent \
    mediainfo \
    rtorrent \
 && mkdir -p /usr/flood && cd /usr/flood \
 && wget https://github.com/jesec/flood/releases/download/${FLOOD_VER}/flood-linux-x64 \
 && mv flood-linux-x64 flood \
 && chmod 0755 flood \
 && rm -rf /var/cache/apk/* /tmp/*

COPY rootfs /

RUN chmod 0755 /usr/bin/rtorrent.sh
RUN chmod 0755 /usr/bin/flood.sh
RUN chmod 0755 /usr/bin/rtunrar.sh

# Build arguments
ARG BUILD_ARCH
ARG BUILD_DATE
ARG BUILD_REF
ARG BUILD_VERSION
ARG BUILD_DESCRIPTION
ARG BUILD_NAME
ARG BUILD_REPOSITORY

# Labels
LABEL \
    io.hass.name="${BUILD_NAME}" \
    io.hass.description="${BUILD_DESCRIPTION}" \
    io.hass.arch="${BUILD_ARCH}" \
    io.hass.type="addon" \
    io.hass.version=${BUILD_VERSION} \
    maintainer="grunjol <grunjol@gmail.com>" \
    org.opencontainers.image.title="${BUILD_NAME}" \
    org.opencontainers.image.description="${BUILD_DESCRIPTION}" \
    org.opencontainers.image.vendor="grunjol" \
    org.opencontainers.image.authors="grunjol <grunjol@gmail.com>" \
    org.opencontainers.image.licenses="MIT" \
    org.opencontainers.image.url="https://github.com/grunjol/hassio-repository" \
    org.opencontainers.image.source="https://github.com/${BUILD_REPOSITORY}" \
    org.opencontainers.image.documentation="https://github.com/${BUILD_REPOSITORY}/blob/main/README.md" \
    org.opencontainers.image.created=${BUILD_DATE} \
    org.opencontainers.image.revision=${BUILD_REF} \
    org.opencontainers.image.version=${BUILD_VERSION}
