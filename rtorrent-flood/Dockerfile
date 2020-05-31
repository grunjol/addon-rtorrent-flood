ARG BUILD_FROM=hassioaddons/base:7.2.0
# hadolint ignore=DL3006
FROM ${BUILD_FROM}

ARG RTORRENT_VER=0.9.7
ARG LIBTORRENT_VER=0.13.7
ARG MEDIAINFO_VER=19.04
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
 && cd /tmp && mkdir libtorrent rtorrent \
 && cd libtorrent && wget -qO- https://github.com/rakshasa/libtorrent/archive/v${LIBTORRENT_VER}.tar.gz | tar xz --strip 1 \
 && rm src/utils/diffie_hellman.cc \
 && wget -q https://raw.githubusercontent.com/ppentchev/libtorrent/b293276bc5f17f6372146bd605a33340a8162072/src/utils/diffie_hellman.cc -O src/utils/diffie_hellman.cc \
 && cd ../rtorrent && wget -qO- https://github.com/rakshasa/rtorrent/releases/download/v${RTORRENT_VER}/rtorrent-${RTORRENT_VER}.tar.gz | tar xz --strip 1 \
 && cd /tmp \
 && git clone https://github.com/mirror/xmlrpc-c.git \
 && git clone https://github.com/grunjol/mktorrent.git \
 && cd /tmp/mktorrent && make -j ${NB_CORES} && make install \
 && cd /tmp/xmlrpc-c/advanced && ./configure && make -j ${NB_CORES} && make install \
 && cd /tmp/libtorrent && ./autogen.sh && ./configure && make -j ${NB_CORES} && make install \
 && cd /tmp/rtorrent && ./autogen.sh && ./configure --with-xmlrpc-c && make -j ${NB_CORES} && make install \
 && cd /tmp \
 && wget -q http://mediaarea.net/download/binary/mediainfo/${MEDIAINFO_VER}/MediaInfo_CLI_${MEDIAINFO_VER}_GNU_FromSource.tar.gz \
 && wget -q http://mediaarea.net/download/binary/libmediainfo0/${MEDIAINFO_VER}/MediaInfo_DLL_${MEDIAINFO_VER}_GNU_FromSource.tar.gz \
 && tar xzf MediaInfo_DLL_${MEDIAINFO_VER}_GNU_FromSource.tar.gz \
 && tar xzf MediaInfo_CLI_${MEDIAINFO_VER}_GNU_FromSource.tar.gz \
 && cd /tmp/MediaInfo_DLL_GNU_FromSource && ./SO_Compile.sh \
 && cd /tmp/MediaInfo_DLL_GNU_FromSource/ZenLib/Project/GNU/Library && make install \
 && cd /tmp/MediaInfo_DLL_GNU_FromSource/MediaInfoLib/Project/GNU/Library && make install \
 && cd /tmp/MediaInfo_CLI_GNU_FromSource && ./CLI_Compile.sh \
 && cd /tmp/MediaInfo_CLI_GNU_FromSource/MediaInfo/Project/GNU/CLI && make install \
 && strip -s /usr/local/bin/rtorrent \
 && strip -s /usr/local/bin/mktorrent \
 && strip -s /usr/local/bin/mediainfo \
 && ln -sf /usr/local/bin/mediainfo /usr/bin/mediainfo \
 && mkdir /usr/flood && cd /usr/flood && wget -qO- https://github.com/Flood-UI/flood/archive/${FLOOD_VER}.tar.gz | tar xz --strip 1 \
 && npm install && npm cache clean --force && npm run build \
 && apk del build-dependencies \
 && rm -rf /var/cache/apk/* /tmp/*

# Build arguments
ARG BUILD_ARCH
ARG BUILD_DATE
ARG BUILD_REF
ARG BUILD_VERSION

# Labels
LABEL \
    io.hass.name="rTorrent + Flood" \
    io.hass.description="rTorrent and Flood web UI add-on for Hass.io" \
    io.hass.arch="${BUILD_ARCH}" \
    io.hass.type="addon" \
    io.hass.version=${BUILD_VERSION} \
    maintainer="grunjol <grunjol@gmail.com>" \
    org.opencontainers.image.title="rTorrent + Flood" \
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
