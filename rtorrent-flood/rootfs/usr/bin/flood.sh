#!/usr/bin/with-contenv bashio
# ==============================================================================
# Flood UI add-on for Hass.io.
# ------------------------------------------------------------------------------
main() {
    bashio::log.trace "${FUNCNAME[0]}"

    while true; do
        echo "Checking Flood"
        sleep 60
    done
}
main "$@"