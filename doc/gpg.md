# Setup gpg

### Setup gpg on Mac OSX

#### 1. Install gpg
`brew install gpg`

#### 2. Generate key
`gpg --gen-key`

* Use the default kind of key:  RSA and RSA (default)
* 2048 or 4096 keysize
* Expire in 2years

#### 3. On Mac OSX, need to install pinentry-mac for gpg-agent to work
`brew install pinentry-mac`

```
echo 'pinentry-program /path/to/pinentry-mac' > ~/.gnupg/gpg-agent.conf
```
Note: the `pinentry-mac` is probably installed at `/opt/homebrew/bin/pinentry-mac`

#### 4. Make public key available
`gpg --send-keys ABCD1234`

#### 5. Config the shell
add this

`
GPG_TTY=$(tty)
export GPG_TTY
`
to your zsh/bashrc

### References

* [lein GPG](https://github.com/technomancy/leiningen/blob/master/doc/GPG.md)
* [lein deploy](https://github.com/technomancy/leiningen/blob/master/doc/DEPLOY.md#authentication)
* [clojars](https://github.com/clojars/clojars-web/wiki/tutorial)
* [pinentry-mac use](https://github.com/IJHack/qtpass/issues/156)

