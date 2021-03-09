![](artwork/lambda_island_banner.png)

# Lambda Island Open Source

Lambda Island Open Source is a collection of Clojure/ClojureScript libraries and
tools created by the same people who brought you [Lambda Island
Education](https://lambdaisland.com).

Look at the [RELEASES file](RELEASES.md) to see what we've been up to.

## Project Overview

### Kaocha

<img align="left" width="100" height="100" src="/artwork/kaocha@32x32@5x.png">

Kaocha is our flagship project, a test runner for the future. Easy to use, rich
in features, extensible, and built with tooling in mind.

Kaocha is actually a collection of projects, which includes kaocha-cljs,
kaocha-junit-xml, kaocha-cloverage, kaocha-cucumber, and kaocha-boot.

[project site](https://github.com/lambdaisland/kaocha) | [releases](https://github.com/lambdaisland/kaocha/releases)

### deep-diff2

Deep-diff is our most downloaded project, it compares Clojure data structures
and gives an easy to scan visual overview of the differences. This is a spin-off
from Kaocha, where it is used to provide clearer error messages when tests fail.

[project site](https://github.com/lambdaisland/deep-diff2) | [releases](https://github.com/lambdaisland/deep-diff2/releases)

### Regal

<img align="left" width="100" height="100" src="/artwork/regal@32x32@5x.png">

_still in alpha_

Regal is Clojure's ultimate regular expression library. It provides a
Hiccup-like syntax for regular expression, and eases the burden of writing
cross-platform code. With its support for string generation it pairs wonderfully
with generative testing, and its parser can be used to manipulate regular
expressions as data, and to convert between Java and JavaScript regexes.

[project site](https://github.com/lambdaisland/regal) | [releases](https://github.com/lambdaisland/regal/releases)

### lambdaisland/uri

A idiomatic and cross-platform URI library. RFC-compliant to the dot, it also
contains helpers for normalization, and for manipulating query strings.

[project site](https://github.com/lambdaisland/uri) | [releases](https://github.com/lambdaisland/uri/releases)

### Glogi

A ClojureScript logging library based on `goog.log`, inspired by `pedestal.log`.
It does syntax highlighting, plays well with cljs-devtools, and allows tweaking
the log level per namespace.

[project site](https://github.com/lambdaisland/glogi) | [releases](https://github.com/lambdaisland/glogi/releases)

### ANSI

Convert ANSI escape codes (the ones used to provide color in terminal
applications), and convert to Hiccup. Valuable if you're putting anything
Terminal-based onto the web.

[project site](https://github.com/lambdaisland/ansi) | [releases](https://github.com/lambdaisland/ansi/releases)

### Chui

_still in alpha_

A browser-based ClojureScript test runner with a delightful UI, built with
auto-reload workflows in mind.

[project site](https://github.com/lambdaisland/chui) | [releases](https://github.com/lambdaisland/chui/releases)

### Funnel

Funnel is a WebSocket message relay. It accepts connections from multiple
clients, and then acts as a go-between, funneling messages between them, with
flexible mechanisms for setting up message routing. It also provides
discoverability, so clients can find out who is there to talk to.

[project site](https://github.com/lambdaisland/funnel) | [releases](https://github.com/lambdaisland/funnel/releases)

### edn-lines

Read/write newline-separated EDN files.

[project site](https://github.com/lambdaisland/edn-lines) | [releases](https://github.com/lambdaisland/edn-lines/releases)

### lambdaisland/fetch

An idiomatic, promises-based wrapped for JavaScript's `fetch`.

[project site](https://github.com/lambdaisland/fetch) | [releases](https://github.com/lambdaisland/fetch/releases)

### lambdaisland/data-printers

Define print handlers for custom or third party types easily. Cross platform and with support for multiple printing backends.

[project site](https://github.com/lambdaisland/data-printers) | [releases](https://github.com/lambdaisland/data-printers/releases)

### lambdaisland/daedalus

2D pathfinding for ClojureScript, primarily for use in games. A wrapper around hxDaedalus-js.

[project site](https://github.com/lambdaisland/daedalus) | [releases](https://github.com/lambdaisland/daedalus/releases)

### lambdaisland/cljbox2d

_still in alpha_

2D physics engine API, Uses jBox2D on Clojure, and Planck.js on ClojureScript.

[project site](https://github.com/lambdaisland/cljbox2d) | [releases](https://github.com/lambdaisland/cljbox2d/releases)

### Specmonstah-Malli

_still in alpha_

Generated complex graphs of entities with Specmonstah and Malli.

[project site](https://github.com/lambdaisland/specmonstah-malli) | [releases](https://github.com/lambdaisland/specmonstah-malli/releases)

### Trikl

_still in alpha_

Build rich terminal applications with Hiccup. An ongoing research project.

[project site](https://github.com/lambdaisland/trikl) | [releases](https://github.com/lambdaisland/trikl/releases)

### zipper-viz

_still in alpha_

Visualize Clojure.zip zippers with graphviz.

[project site](https://github.com/lambdaisland/zipper-viz) | [releases](https://github.com/lambdaisland/zipper-viz/releases)

## Style Guide and Project Setup

We have a [style guide](https://nextjournal.com/lambdaisland/clojure-style-guide) that applies to all of our projects.

Our preferred open source/free software license is the Mozilla Public License
v2.0 (a less intrusive copyleft license), although some of our projects still
use the Eclipse Public License.

We prefer Clojure CLI over Leiningen, although some projects may still use
`project.clj` instead of `deps.edn`.

We like to run our tests through Kaocha on CircleCI.

## Code of Conduct

All our projects are covered by the [Contributor Covenant Code of Conduct](https://www.contributor-covenant.org/version/2/0/code_of_conduct.txt).

## Community Guidelines

A code of conduct is important to set a baseline for how we expect people to
behave, however we aspire to go above and beyond that. On the internet people
don't see your face, they don't hear your tone of voice. What was intended as
simply a brief response can easily be construed as rude or unhelpful.

To counter this it is good to be a little "extra" in your communication. Say
"please" and "thank you", be clear and explicit, explain your reasoning, use
emoji and animated gifs. Seriously we love gifs! (jifs?)

Particating in open source can be daunting, overwhelming, and scary. Make it
clear that people are welcome, that their concerns are valid, and that they have
a right to contribute.

## First-timers Only Issue

We aspire to have "first-timers only" issues on every project that is under
active development. These are issues that have it spelled out in very fine
detail what needs to happen. These issues are only open to people who have not
contributed to Lambda Island projects before.

## Open Collective

If you find value in our work please consider [becoming a backer on Open Collective](http://opencollective.com/lambda-island#section-contribute)

## Project Table

<!-- projects -->
| Project | CI | Docs | Release | Coverage |
|---------|----|------|---------|----------|
| [kaocha](https://github.com/lambdaisland/kaocha) | [![CircleCI](https://circleci.com/gh/lambdaisland/kaocha.svg?style=svg)](https://circleci.com/gh/lambdaisland/kaocha) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/kaocha)](https://cljdoc.org/d/lambdaisland/kaocha) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/kaocha.svg)](https://clojars.org/lambdaisland/kaocha) | [![codecov](https://codecov.io/gh/lambdaisland/kaocha/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/kaocha) |
| [kaocha-cljs](https://github.com/lambdaisland/kaocha-cljs) | [![CircleCI](https://circleci.com/gh/lambdaisland/kaocha-cljs.svg?style=svg)](https://circleci.com/gh/lambdaisland/kaocha-cljs) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/kaocha-cljs)](https://cljdoc.org/d/lambdaisland/kaocha-cljs) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/kaocha-cljs.svg)](https://clojars.org/lambdaisland/kaocha-cljs) | [![codecov](https://codecov.io/gh/lambdaisland/kaocha-cljs/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/kaocha-cljs) |
| [kaocha-cucumber](https://github.com/lambdaisland/kaocha-cucumber) | [![CircleCI](https://circleci.com/gh/lambdaisland/kaocha-cucumber.svg?style=svg)](https://circleci.com/gh/lambdaisland/kaocha-cucumber) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/kaocha-cucumber)](https://cljdoc.org/d/lambdaisland/kaocha-cucumber) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/kaocha-cucumber.svg)](https://clojars.org/lambdaisland/kaocha-cucumber) | [![codecov](https://codecov.io/gh/lambdaisland/kaocha-cucumber/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/kaocha-cucumber) |
| [kaocha-junit-xml](https://github.com/lambdaisland/kaocha-junit-xml) | [![CircleCI](https://circleci.com/gh/lambdaisland/kaocha-junit-xml.svg?style=svg)](https://circleci.com/gh/lambdaisland/kaocha-junit-xml) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/kaocha-junit-xml)](https://cljdoc.org/d/lambdaisland/kaocha-junit-xml) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/kaocha-junit-xml.svg)](https://clojars.org/lambdaisland/kaocha-junit-xml) | [![codecov](https://codecov.io/gh/lambdaisland/kaocha-junit-xml/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/kaocha-junit-xml) |
| [kaocha-cloverage](https://github.com/lambdaisland/kaocha-cloverage) | [![CircleCI](https://circleci.com/gh/lambdaisland/kaocha-cloverage.svg?style=svg)](https://circleci.com/gh/lambdaisland/kaocha-cloverage) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/kaocha-cloverage)](https://cljdoc.org/d/lambdaisland/kaocha-cloverage) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/kaocha-cloverage.svg)](https://clojars.org/lambdaisland/kaocha-cloverage) | [![codecov](https://codecov.io/gh/lambdaisland/kaocha-cloverage/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/kaocha-cloverage) |
| [kaocha-boot](https://github.com/lambdaisland/kaocha-boot) | [![CircleCI](https://circleci.com/gh/lambdaisland/kaocha-boot.svg?style=svg)](https://circleci.com/gh/lambdaisland/kaocha-boot) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/kaocha-boot)](https://cljdoc.org/d/lambdaisland/kaocha-boot) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/kaocha-boot.svg)](https://clojars.org/lambdaisland/kaocha-boot) | [![codecov](https://codecov.io/gh/lambdaisland/kaocha-boot/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/kaocha-boot) |
| [deep-diff2](https://github.com/lambdaisland/deep-diff2) | [![CircleCI](https://circleci.com/gh/lambdaisland/deep-diff2.svg?style=svg)](https://circleci.com/gh/lambdaisland/deep-diff2) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/deep-diff2)](https://cljdoc.org/d/lambdaisland/deep-diff2) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/deep-diff2.svg)](https://clojars.org/lambdaisland/deep-diff2) | [![codecov](https://codecov.io/gh/lambdaisland/deep-diff2/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/deep-diff2) |
| [uri](https://github.com/lambdaisland/uri) | [![CircleCI](https://circleci.com/gh/lambdaisland/uri.svg?style=svg)](https://circleci.com/gh/lambdaisland/uri) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/uri)](https://cljdoc.org/d/lambdaisland/uri) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/uri.svg)](https://clojars.org/lambdaisland/uri) | [![codecov](https://codecov.io/gh/lambdaisland/uri/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/uri) |
| [glogi](https://github.com/lambdaisland/glogi) | [![CircleCI](https://circleci.com/gh/lambdaisland/glogi.svg?style=svg)](https://circleci.com/gh/lambdaisland/glogi) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/glogi)](https://cljdoc.org/d/lambdaisland/glogi) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/glogi.svg)](https://clojars.org/lambdaisland/glogi) | [![codecov](https://codecov.io/gh/lambdaisland/glogi/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/glogi) |
| [ansi](https://github.com/lambdaisland/ansi) | [![CircleCI](https://circleci.com/gh/lambdaisland/ansi.svg?style=svg)](https://circleci.com/gh/lambdaisland/ansi) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/ansi)](https://cljdoc.org/d/lambdaisland/ansi) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/ansi.svg)](https://clojars.org/lambdaisland/ansi) | [![codecov](https://codecov.io/gh/lambdaisland/ansi/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/ansi) |
| [chui](https://github.com/lambdaisland/chui) | [![CircleCI](https://circleci.com/gh/lambdaisland/chui.svg?style=svg)](https://circleci.com/gh/lambdaisland/chui) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/chui)](https://cljdoc.org/d/lambdaisland/chui) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/chui.svg)](https://clojars.org/lambdaisland/chui) | [![codecov](https://codecov.io/gh/lambdaisland/chui/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/chui) |
| [edn-lines](https://github.com/lambdaisland/edn-lines) | [![CircleCI](https://circleci.com/gh/lambdaisland/edn-lines.svg?style=svg)](https://circleci.com/gh/lambdaisland/edn-lines) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/edn-lines)](https://cljdoc.org/d/lambdaisland/edn-lines) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/edn-lines.svg)](https://clojars.org/lambdaisland/edn-lines) | [![codecov](https://codecov.io/gh/lambdaisland/edn-lines/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/edn-lines) |
| [fetch](https://github.com/lambdaisland/fetch) | [![CircleCI](https://circleci.com/gh/lambdaisland/fetch.svg?style=svg)](https://circleci.com/gh/lambdaisland/fetch) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/fetch)](https://cljdoc.org/d/lambdaisland/fetch) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/fetch.svg)](https://clojars.org/lambdaisland/fetch) | [![codecov](https://codecov.io/gh/lambdaisland/fetch/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/fetch) |
| [regal](https://github.com/lambdaisland/regal) | [![CircleCI](https://circleci.com/gh/lambdaisland/regal.svg?style=svg)](https://circleci.com/gh/lambdaisland/regal) | [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/regal)](https://cljdoc.org/d/lambdaisland/regal) | [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/regal.svg)](https://clojars.org/lambdaisland/regal) | [![codecov](https://codecov.io/gh/lambdaisland/regal/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/regal) |
<!-- /projects -->
