#!/usr/bin/with-contenv bashio
# ==============================================================================
# Flood UI add-on for Hass.io.
# ------------------------------------------------------------------------------
main() {
    bashio::log.trace "${FUNCNAME[0]}"
    cd /usr/flood
  	exec flood
}
main "$@"
