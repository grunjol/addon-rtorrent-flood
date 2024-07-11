#!/usr/bin/with-contenv bashio
# ==============================================================================
# Flood UI add-on for Hass.io.
# ------------------------------------------------------------------------------
main() {
    bashio::log.trace "${FUNCNAME[0]}"
  	exec /usr/flood/flood --host=0.0.0.0
}
main "$@"
