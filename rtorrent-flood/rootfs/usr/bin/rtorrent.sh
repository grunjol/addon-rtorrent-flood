#!/usr/bin/with-contenv bashio
# ==============================================================================
# rTorrent add-on for Hass.io.
# ------------------------------------------------------------------------------
main() {
	exec rtorrent -n -o import=/etc/rtorrent.d/rtorrent.rc
}
main "$@"