# rTorrent and Flood Web UI


rTorrent is a text-based ncurses BitTorrent client written in C++, based on the libTorrent whose goal is focus on high performance and good code.

Flood is a monitoring service for rTorrent. It's a Node.js service that communicates with rTorrent instances and serves a decent web UI for administration. It's a work-in-progress

## Installation

1. Add grunjol repository https://github.com/grunjol/hassio-repository
1. Search for the "rTorrent and Flood" add-on in the Supervisor add-on store and install it.
1. Start the "rTorrent and Flood" add-on.
1. Configure it

## Configuration

These are the options to start the services.

**Note**: _Remember to restart the add-on when the configuration is changed._

Add-on configuration:

```yaml
log_level: info
```

### Option: `log_level`

The `log_level` option controls the level of log output by the addon and can
be changed to be more or less verbose, which might be useful when you are
dealing with an unknown issue. Possible values are:

- `trace`: Show every detail, like all called internal functions.
- `debug`: Shows detailed debug information.
- `info`: Normal (usually) interesting events.
- `warning`: Exceptional occurrences that are not errors.
- `error`:  Runtime errors that do not require immediate action.
- `fatal`: Something went terribly wrong. Add-on becomes unusable.

Please note that each level automatically includes log messages from a
more severe level, e.g., `debug` also shows `info` messages. By default,
the `log_level` is set to `info`, which is the recommended setting unless
you are troubleshooting.

### Option: `path`

Path

## Changelog & Releases

This repository keeps a change log using [GitHub's releases][releases]
functionality. 
Releases are based on [Semantic Versioning][semver], and use the format
of ``MAJOR.MINOR.PATCH``. In a nutshell, the version will be incremented
based on the following:

- ``MAJOR``: Incompatible or major changes.
- ``MINOR``: Backwards-compatible new features and enhancements.
- ``PATCH``: Backwards-compatible bugfixes and package updates.

## Support

Got questions?

You have several options to get them answered:

You could [open an issue here][issue] GitHub.

## Authors & contributors

The original setup of this repository is by grunjol

For a full list of all authors and contributors,
check [the contributor's page][contributors].

## License

MIT License

Copyright (c) 2020 grunjol

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

[contributors]: https://github.com/grunjol/addon-rtorrent-flood/graphs/contributors
[issue]: https://github.com/hassio-addons/addon-rtorrent-flood/issues
[releases]: https://github.com/hassio-addons/addon-rtorrent-flood/releases
[semver]: http://semver.org/spec/v2.0.0.html
