scgi_local = /tmp/rtorrent.sock

system.daemon.set = true

encoding_list = UTF-8
port_range = 49184-49184
port_random = no
check_hash = no

directory = {{ .download_dir }}/Incomplete
session = {{ .download_dir }}/.session
encryption = allow_incoming, try_outgoing, enable_retry
trackers.use_udp.set = yes
dht.mode.set = off
protocol.pex.set = no

min_peers = 1
max_peers = 100
min_peers_seed = 1
max_peers_seed = 50
max_uploads = 15

throttle.global_down.max_rate.set_kb = {{ .max_download_speed }}
throttle.global_up.max_rate.set_kb = {{ .max_upload_speed }}

network.xmlrpc.size_limit.set = 10000000

schedule = watch_directory,1,1,"load.start={{ .download_dir }}/Incoming/*.torrent"
schedule = untied_directory,5,5,"stop_untied={{ .download_dir }}/Incoming/*.torrent"
schedule = scgi_permission,0,0,"execute.nothrow=chmod,\"g+w,o=\",/tmp/rtorrent.sock"
schedule = insufficient_disk_space,1,30,close_low_diskspace=500M

# method.set_key=event.download.finished,unrar,"execute={/usr/bin/rtunrar.sh,$d.base_path=}"
method.set_key=event.download.inserted_new,loaded_time,"d.custom.set=addtime,$cat=$system.time=;d.save_full_session="

# upon completion, move content to path specified above via custom1
method.insert = d.data_path, simple, "if=(d.is_multi_file), (cat,(d.directory),/), (cat,(d.directory),/,(d.name))"
method.insert = d.move_to_complete, simple, "d.directory.set=$argument.1=; execute=mkdir,-p,$argument.1=; execute=mv,-u,$argument.0=,$argument.1=; d.save_full_session="
method.set_key = event.download.finished,move_complete,"d.move_to_complete=$d.data_path=,{{ .download_dir }}"
