FROM openjdk:17-jdk-bullseye

ENV DEBIAN_FRONTEND=noninteractive
ENV CLOJURE_CLI_VERSION=1.10.3.986
ENV BABASHKA_VERSION=0.6.2
ENV FUNNEL_VERSION=0.1.42
ENV NODEJS_VERSION=14
ENV BOOT_AS_ROOT=yes
ENV BOOT_VERSION=2.8.3

# RUN apt-get update

RUN curl -O https://download.clojure.org/install/linux-install-$CLOJURE_CLI_VERSION.sh && \
    chmod +x linux-install-$CLOJURE_CLI_VERSION.sh && \
    ./linux-install-$CLOJURE_CLI_VERSION.sh && \
    rm ./linux-install-$CLOJURE_CLI_VERSION.sh

RUN curl https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein > /usr/bin/lein && \
    chmod +x /usr/bin/lein && lein --version

RUN curl -L https://github.com/babashka/babashka/releases/download/v$BABASHKA_VERSION/babashka-$BABASHKA_VERSION-linux-amd64.tar.gz | tar -xzO > /usr/bin/bb && chmod +x /usr/bin/bb

RUN curl -L https://github.com/lambdaisland/funnel/releases/download/v$FUNNEL_VERSION/funnel.linux-amd64 > /usr/bin/funnel && chmod +x /usr/bin/funnel

RUN curl -fSL https://github.com/boot-clj/boot-bin/releases/download/latest/boot.sh > /usr/bin/boot && chmod +x /usr/bin/boot && boot --version

RUN curl -sL https://deb.nodesource.com/setup_$NODEJS_VERSION.x | bash -

RUN apt-get update && apt-get install -y make nodejs maven && apt-get clean

RUN npm install -g yarn shadow-cljs
