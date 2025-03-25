ARG BUILD_FROM
# hadolint ignore=DL3006
FROM ${BUILD_FROM}
# Add env
ENV LANG C.UTF-8

# Set shell
SHELL ["/bin/bash", "-o", "pipefail", "-c"]

ARG FLOOD_VER=v4.9.3

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

# Labels
LABEL \
    io.hass.name="rTorrent and Flood" \
    io.hass.description="rTorrent and Flood web UI add-on for Hass.io" \
    io.hass.arch="${BUILD_ARCH}" \
    io.hass.type="addon" \
    io.hass.version=${BUILD_VERSION} \
    maintainer="grunjol <grunjol@gmail.com>" \
    org.opencontainers.image.title="rTorrent and Flood" \
    org.opencontainers.image.description="rTorrent and Flood web UI add-on for Hass.io" \
    org.opencontainers.image.vendor="grunjol" \
    org.opencontainers.image.authors="grunjol <grunjol@gmail.com>" \
    org.opencontainers.image.licenses="MIT" \
    org.opencontainers.image.url="https://addons.community" \
    org.opencontainers.image.source="https://github.com/grunjol/addon-rtorrent-flood" \
    org.opencontainers.image.documentation="https://github.com/grunjol/addon-rtorrent-flood/blob/master/README.md" \
    org.opencontainers.image.created=${BUILD_DATE} \
    org.opencontainers.image.revision=${BUILD_REF} \
    org.opencontainers.image.version=${BUILD_VERSION}
