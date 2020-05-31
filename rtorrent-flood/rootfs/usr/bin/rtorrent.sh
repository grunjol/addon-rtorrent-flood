#!/usr/bin/with-contenv bashio
# ==============================================================================
# rTorrent add-on for Hass.io.
# ------------------------------------------------------------------------------
main() {
	export TERM="xterm"
	export HOME="/home/torrent"
	export PWD="/home/torrent"
	cd /home/torrent
	exec rtorrent
}
main "$@"