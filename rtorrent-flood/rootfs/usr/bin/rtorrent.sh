#!/usr/bin/with-contenv bashio
# ==============================================================================
# rTorrent add-on for Hass.io.
# ------------------------------------------------------------------------------
main() {
    bashio::log.trace "${FUNCNAME[0]}"

    while true; do
        echo "Checking rTorrent"
        sleep 60
    done
}
main "$@"