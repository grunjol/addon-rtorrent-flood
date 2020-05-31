ARG BUILD_FROM=hassioaddons/base:7.2.0
# hadolint ignore=DL3006
FROM ${BUILD_FROM}

ARG FLOOD_VER=master
ARG BUILD_CORES

ENV FLOOD_SECRET=supersecret \
    WEBROOT=/ \
    PKG_CONFIG_PATH=/usr/local/lib/pkgconfig
    
COPY rootfs /

RUN NB_CORES=${BUILD_CORES-`getconf _NPROCESSORS_CONF`} \
 && apk -U upgrade \
 && apk add -t build-dependencies \
    build-base \
    git \
    libtool \
    automake \
    autoconf \
    wget \
    tar \
    xz \
    zlib-dev \
    cppunit-dev \
    openssl-dev \
    ncurses-dev \
    curl-dev \
    binutils \
    linux-headers \
 && apk add \
    ca-certificates \
    curl \
    ncurses \
    openssl \
    gzip \
    zip \
    zlib \
    python \
    nodejs \
    nodejs-npm \
    unrar \
    findutils \
    mktorrent \
    mediainfo \
    rtorrent \
 && mkdir -p /usr/flood && cd /usr/flood && wget -qO- https://github.com/Flood-UI/flood/archive/${FLOOD_VER}.tar.gz | tar xz --strip 1 \
 && JOBS=`getconf _NPROCESSORS_CONF` npm install --loglevel verbose && npm cache clean --force && npm run build \
 && apk del build-dependencies \
 && rm -rf /var/cache/apk/* /tmp/*

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
