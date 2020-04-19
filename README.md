# Lambda Island Open Source

Lambda Island Open Source is a collection of Clojure/ClojureScript libraries and
tools created by the same people who brought you [Lambda Island
Education](https://lambdaisland.com).

Look at the [combined CHANGELOG]() to see what's new.

## Project Overview

### Kaocha

Kaocha is our flagship project, a test runner for the future. Easy to use, rich
in features, extensible, and built with tooling in mind.

Kaocha is actually a collection of projects, which includes kaocha-cljs,
kaocha-junit-xml, kaocha-cloverage, kaocha-cucumber, and kaocha-boot.

### deep-diff2

Deep-diff is our most downloaded project, it compares Clojure data structures
and gives an easy to scan visual overview of the differences. This is a spin-off
from Kaocha, where it is used to provide clearer error messages when tests fail.

### Regal

_still in alpha_

Regal is Clojure's ultimate regular expression library. It provides a
Hiccup-like syntax for regular expression, and eases the burden of writing
cross-platform code. With its support for string generation it pairs wonderfully
with generative testing, and its parser can be used to manipulate regular
expressions as data, and to convert between Java and JavaScript regexes.

### lambdaisland/uri

A idiomatic and cross-platform URI library. RFC-compliant to the dot, it also
contains helpers for normalization, and for manipulating query strings.

### Glogi

A ClojureScript logging library based on `goog.log`, inspired by `pedestal.log`.
It does syntax highlighting, plays well with cljs-devtools, and allows tweaking
the log level per namespace.

### ANSI

Convert ANSI escape codes (the ones used to provide color in terminal
applications), and convert to Hiccup. Valuable if you're putting anything
Terminal-based onto the web.

### Chui

_still in alpha_

A browser-based ClojureScript test runner with a delightful UI, built with
auto-reload workflows in mind.

### edn-lines

_still in alpha_

Read/write newline-separated EDN files.

### lambdaisland/fetch

_still in alpha_

An idiomatic, promises-based wrapped for JavaScript's `fetch`.

### Trikl

_still in alpha_

Build rich terminal applications with Hiccup. An ongoing research project.

### zipper-viz

_still in alpha_

Visualize Clojure.zip zippers with graphviz.

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
