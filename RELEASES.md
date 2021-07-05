# [Dom-types](https://github.com/lambadisland/dom-types) 0.0.11 (2021-05-21 / 72aceee)

-  First release
# [Glogi](https://github.com/lambadisland/glogi) 1.0.116 (2021-04-26 / e1dbcb3)

-  Fixed an issue with advanced compilation when calling `level-value`, which is
  used by the console handler

# [Daedalus](https://github.com/lambadisland/daedalus) 0.0.35 (2021-04-24 / 3ee44c0)

-  `next?` predicate

# [Glogi](https://github.com/lambadisland/glogi) 1.0.112 (2021-04-21 / a104211)

-  Artifact name changed to `com.lambdaisland/glogi` in line with Clojars policy

# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 1.0.93 (2021-04-21 / b6a7aa1)

-  Clearly alert the user that ClojureScript versions before 1.10 aren't
  supported, rather than failing on whatever 1.10 functionality happens to be
  invoked first.
-  Show the file/line of the deftest in case cljs.test is not able to provide a
  reasonable file/line number.
-  Bump com.lambdaisland/glogi to 1.0.112
-  Release under com.lambdaisland/kaocha-cljs in line with Clojars policy
-  Bump all dependencies

# [Funnel-client](https://github.com/lambadisland/funnel-client) 0.0.18 (2021-04-21 / 9afe32b)

-  Bump lambdaisland/glogi to 1.0.106

# [Glogi](https://github.com/lambadisland/glogi) 1.0.106 (2021-04-20 / 1128462)

-  Prevent single-arg `logger` from erasing the log level

# [Regal](https://github.com/lambadisland/regal) 0.0.94 (2021-04-20 / e087c28)

-  Added support for `[:repeat form num]` (so fixed number of repeats, instead of
  min/max) to the generator

# [Regal](https://github.com/lambadisland/regal) 0.0.97 (2021-04-20 / 6f5f1cc)

-  Add `lambdaisland.regal.generator/generate` as a shorthand for generating a
  single value from a regal expression

# [Chui](https://github.com/lambadisland/chui) 1.0.179 (2021-04-19 / 7332d1e)

-  Upgrade glogi dependency

# [Glogi](https://github.com/lambadisland/glogi) 1.0.100 (2021-04-15 / 8a8ccf0)

-  More fixes to deal with upstream changes in Google Closure Library

# [Daedalus](https://github.com/lambadisland/daedalus) 0.0.31 (2021-04-05 / d48b47e)

-  Two-arity version of debug draw functions
-  Add debug-draw to path-handler
-  Add ILookup support to path-handler

# [Daedalus](https://github.com/lambadisland/daedalus) 0.0.28 (2021-04-03 / 6df687c)

-  Added combined "path-handler" for a more convenient and encapsulated API

# [Daedalus](https://github.com/lambadisland/daedalus) 0.0.25 (2021-03-28 / ce0c699)

-  Added `reset` for path-iterators
-  Added `polygon` function

# [Glogi](https://github.com/lambadisland/glogi) 1.0.80 (2021-03-09 / 9c5ea2b)

-  Maintain compatibility with newer versions of the Google Closure library,
  which introduced breaking changes in v20210302

# [Glogi](https://github.com/lambadisland/glogi) 1.0.83 (2021-03-09 / d0f76e8)

-  With `lambdaisland.glogc` there is now an official way to use the
  Glogi/Pedestal-log combo in a consistent cross-platform way

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.829 (2021-03-08 / a88ebda)

-  Kaocha watch can now add ignores from `.gitignore` and `.ignore`. To enable
    this feature, set `:kaocha.watch/use-ignore-file` to true in your deps.edn.
-  Kaocha now falls back to the notifications provided by Java's AWT when it can't
    find `notify-send` or `terminal-notifier`.
-  Clearly alert the user that Clojure versions before 1.9 aren't supported, rather than
    failing on whatever 1.9 functionality happens to be invoked first.
-  Fixed an issue with the definition of spec `:kaocha.test-plan/load-error` that
    caused a ClassCastException whenever a generator was created for it.
-  Errors when loading plugins are more specific, specifying which namespaces, if
    any, failed to load.
-  Warn when running Kaocha without a configuration file. This is fine for
    experimenting, but for long-term use, we recommend creating a configuration
    file to avoid changes in behavior between releases.
-  Provide a warning when no tests are found.
-  Fix exception when running Kaocha on Windows with the built-in notification
    plugin enabled.

# [Daedalus](https://github.com/lambadisland/daedalus) 0.0.14 (2021-02-28 / 83a1146)

-  Initial release
# [Data-printers](https://github.com/lambadisland/data-printers) 0.0.22 (2021-02-28 / f763641)


# [Chui](https://github.com/lambadisland/chui) 1.0.173 (2021-02-26 / 1e3ed0b)

-  Added text wrapping support for test reports
-  Added basic column resizing via `resize: horizontal` CSS support
-  Change default in UI to show passing tests

# [Data-printers](https://github.com/lambadisland/data-printers) 0.0.19 (2021-02-25 / 68f6e4e)

-  Improve ClojureScript handling

# [Data-printers](https://github.com/lambadisland/data-printers) 0.0.8 (2021-02-24 / 0aa1553)

-  `lambdaisland.data-printers/register-print`
-  `lambdaisland.data-printers/register-pprint`
-  `lambdaisland.data-printers.puget/register-puget`
-  `lambdaisland.data-printers.deep-diff/register-deep-diff`
-  `lambdaisland.data-printers.deep-diff2/register-deep-diff2`
-  `lambdaisland.data-printers.transit/register-write-handler`
# [Data-printers](https://github.com/lambadisland/data-printers) 0.0.11 (2021-02-24 / c94fdcc)

-  Include optional dependencies in the pom, marked as optional

# [Garden-watcher](https://github.com/lambadisland/garden-watcher) 1.0.33 (2021-01-14 / 777c23b)

-  Support for *.cljc files
-  Make namespace to file path conversion (and vice versa) more robust

# [Garden-watcher](https://github.com/lambadisland/garden-watcher) 1.0.36 (2021-01-14 / 4628d5b)

-  Update dependencies
  - com.stuartsierra/component {:mvn/version "0.4.0"} -> {:mvn/version "1.0.0"}
  - org.clojure/java.classpath {:mvn/version "0.3.0"} -> {:mvn/version "1.0.0"}
  - garden {:mvn/version "1.3.9"} -> {:mvn/version "1.3.10"}
-  com.stuartsierra/component {:mvn/version "0.4.0"} -> {:mvn/version "1.0.0"}
-  org.clojure/java.classpath {:mvn/version "0.3.0"} -> {:mvn/version "1.0.0"}
-  garden {:mvn/version "1.3.9"} -> {:mvn/version "1.3.10"}

# [Fetch](https://github.com/lambadisland/fetch) 0.0.23 (2021-01-04 / b8a521a)

-  Fix query-params encoding issue and path/query-params normalization (@den1k)
-  Dependency version bumps: lambdaisland/uri, js-interop, transit-cljs
-  Remove direct dependency on Clojure/ClojureScript, people will generally bring them themselves

# [Fetch](https://github.com/lambadisland/fetch) 0.0.16 (2020-12-01 / d5f92bd)

-  * Replaced `kitchen-async` dependency with `mhuebert/kitchen-async`, which is the same lib with a fixed version on Clojars
# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.732 (2020-11-26 / b418350)

-  Fixed an issue with the optional `clojure.test.check` dependency (follow-up)

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.726 (2020-11-24 / faa6ef6)

-  `If the value of a configuration key is not a collection or symbol,
  a more helpful error message is output. Fixes #124`
-  `kaocha.type.spec.test.check` now correctly builds fdef testables with
  configuration options from their enclosing test suites.
-  `kaocha.plugin.alpha.spec-test-check` now honors command line arguments based
  upon all of the configured STC suites rather than the static
  `:generative-fdef-checks` selector.
-  Fix an issue where `clojure.test.check` would be required for Kaocha to work,
  rather than being an optional dependency
-  Breaking! Test configuration (`tests.edn`) is now validated with spec, meaning
  existing configs may fail. In most cases you should be able to update your
  config so it is valid, but please do report any issues.
-  `kaocha.plugin.alpha.spec-test-check` now respects a priority of supplied
  configuration. CLI options always take precedence, followed by options
  specified in individual test suites, followed by global options.
-  Improved spec definitions and generative fdef coverage

# [Kaocha-cloverage](https://github.com/lambadisland/kaocha-cloverage) 1.0.72 (2020-11-20 / 20ea1aa)

-  handle correctly test-ns-regex, converting strings into regexes and
  adding cli support for the option as `--cov-test-ns-regex`

# [Kaocha-cloverage](https://github.com/lambadisland/kaocha-cloverage) 1.0.75 (2020-11-20 / 4c85364)

-  Fix cljdoc build

# [Garden-watcher](https://github.com/lambadisland/garden-watcher) 1.0.27 (2020-10-30 / 634bccc)

-  Make classpath detection more robust

# [Kaocha-cljs2](https://github.com/lambadisland/kaocha-cljs2) 0.0.35 (2020-10-02 / 3a506bd)

-  Fix fixtures :once :after hook

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.700 (2020-09-18 / 552b977)

-  Fix documentation table of contents
-  Make Ctrl-C (SIGINT) handling more reliable, so you can always short-circuit
  Kaocha to see your failing tests.
-  Make spec-test-check plugin honor commond line arguments, so you can run only
  the generated test suite.
-  Don't run group tests (e.g. namespace) when there are no tests inside it that
  would run (empty or all tests skipped)

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.690 (2020-09-14 / 8a12b69)

-  fdef/spec based tests via plugin: honor `:clojure.spec.test.check/instrument?`
  and `:clojure.spec.test.check/check-asserts?` from `tests.edn`

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.681 (2020-09-10 / 5031360)

-  Added `:kaocha.plugin/debug` for easy introspection of Kaocha's machinery
-  Added docstrings and markdown docs for the Orchestra and Preloads plugins
-  In the filter plugin's pre-load early filtering of test suites, check flags
  provided directly in the config, instead of only checking command line
  arguments. This fixes kaocha.repl invocations like
  `(kaocha.repl/run {:kaocha.filter/skip [:unit]})`

# [Edn-lines](https://github.com/lambadisland/edn-lines) 1.0.10 (2020-08-27 / 73502c2)

-  Honor tagged reader functions from `clojure.core/*data-readers*`

# [Kaocha-cljs2](https://github.com/lambadisland/kaocha-cljs2) 0.0.28 (2020-08-27 / 9ed88aa)

-  Make the timeout configurable with `:kaocha.cljs2/timeout` in miliseconds. If
  no Funnel message has been received for this amount of time then we assume the
  client has gotten stuck or gone away and we time out
-  Upgrade Chui, this fixes handling of `:once` fixtures

# [Chui](https://github.com/lambadisland/chui) 0.0.156 (2020-08-26 / 460519c)

-  Fix :once fixtures when running via chui-remote

# [Glogi](https://github.com/lambadisland/glogi) 1.0.74 (2020-08-26 / acf8c48)

-  Export lambdaisland.glogi.set-levels so you can use it from the browser
  console (pass in an array of two-element arrays of strings)

# [Funnel](https://github.com/lambadisland/funnel) 0.1.42 (2020-08-26 / 4c14cec)

-  Added a `--daemonize` flag so Funnel can background itself (experimental)
-  Added a `--logfile FILE` option to redirect output
-  Added a `--ws-port PORT` options
-  Added a `--wss-port PORT` option
-  Added a `--version` flag
-  Correctly format log messages that contain parameters (like jdk.event.security)
-  No longer include a default certificate
-  Only start WSS server when a certificate is provided
-  Changed the default `--keystore-password` from `"funnel"` to `"password"`
  (same as [bhauman/certifiable](https://github.com/bhauman/certifiable))

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.672 (2020-08-26 / ff68cf5)

-  Prevent loading of test suites that are excluded from the run

# [Kaocha-cloverage](https://github.com/lambadisland/kaocha-cloverage) 1.0.63 (2020-08-21 / 83f3706)

-  Bump Cloverage to 1.2.0

# [Chui](https://github.com/lambadisland/chui) 0.0.141 (2020-08-19 / 7d1865b)

-  Source mapped stack trace in UI and remote
-  Make sure terminate callback is always called, this prevents Shadow's
  reloading from hanging indefinitely
-  Better exception reporting

# [Chui](https://github.com/lambadisland/chui) 0.0.146 (2020-08-19 / 6e324e2)

-  Upgrade dependencies, glogi, funnel-client, deep-diff2

# [Chui](https://github.com/lambadisland/chui) 0.0.149 (2020-08-19 / adf2c24)

-  Fail more gracefully when a test definition happens to be not available at
  runtime due to a load error

# [Glogi](https://github.com/lambadisland/glogi) 1.0.70 (2020-08-19 / df34f1a)

-  We no longer pull in a specific Clojure/ClojureScript version, assuming that
  client consumers will already have specific versions declared for their project.

# [Deep-diff2](https://github.com/lambadisland/deep-diff2) 2.0.108 (2020-08-19 / e006fc5)

-  Switch to using lambdaisland/clj-diff, a fork of an upstream fork

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.669 (2020-08-19 / 13abc37)

-  Added internal diagnostics

# [Kaocha-cljs2](https://github.com/lambadisland/kaocha-cljs2) 0.0.15 (2020-08-19 / d6f3fd1)


# [Kaocha-cljs2](https://github.com/lambadisland/kaocha-cljs2) 0.0.18 (2020-08-19 / 239b9b8)

-  Add chui-ui dependency

# [Kaocha-cljs2](https://github.com/lambadisland/kaocha-cljs2) 0.0.21 (2020-08-19 / d4de44c)

-  Remove debug call
-  Version bumps

# [Funnel-client](https://github.com/lambadisland/funnel-client) 0.0.13 (2020-08-19 / 0eb52ad)

-  Bump lambdaisland/glogi to 1.0.70

# [Chui](https://github.com/lambadisland/chui) 0.0.133 (2020-08-17 / af3a0d3)

-  First release of chui-remote, based on Funnel-client

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.658 (2020-08-17 / 22ef88c)

-  Add two new hooks, `:kaocha.hooks/pre-load-test`,
  `:kaocha.hooks/post-load-test`
-  Extend the hooks plugin to allow for `:kaocha.hooks/pre-load-test`,
  `:kaocha.hooks/pre-test` / `:kaocha.hooks/post-test` and
  `:kaocha.hooks/post-load-test` hooks to be defined on the testable (i.e. on
  the test suite)
-  The `:post-summary` hook can now be used through the hooks plugin (before it
  was only available to plugins)
-  Allow test type implementations to add `:kaocha.testable/aliases` to
  testables, these can be used when focusing/skipping
-  `:kaocha.hooks/before` / `:kaocha.hooks/after` now get converted to
  `:kaocha.hooks/pre-test` / `:kaocha.hooks/post-test` hooks. The former are
  considered deprecated but will continue to work.
-  the `post-summary` hook will also be called when invoked via `kaocha.repl`
-  `kaocha.testable/test-seq` only returns actual testables, not a top level
  config/test-plan map
-  Bumped Orchestra and Expound, this pulled in a breaking change in Orchestra
  where it no longer includes the explained spec error in the exception message.
  To accomodate for this the Orchestra plugin has been updated so the
  explanation appears in the reported output.
-  Only instrument lambdaisland/kaocha namespaces with Orchestra. For
  instrumentation of your own code or third party libraries use the `:orchestra`
  plugin.

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.663 (2020-08-17 / 2a815a3)

-  Fix `post-summary` when used from  hooks plugin

# [Funnel-client](https://github.com/lambadisland/funnel-client) 0.0.9 (2020-08-17 / 445658b)


# [Kaocha-cloverage](https://github.com/lambadisland/kaocha-cloverage) 1.0.56 (2020-08-13 / 304162e)

-  Switch back to vanilla Cloverage, and bump it to 1.1.3. This version no longer
  contains an aot-compiled tools.reader.

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0.76 (2020-07-21 / 397a3c1)

-  Added a flag to omit `system-out` from the generated junit.xml file, (thanks @ondrs)

# [Regal](https://github.com/lambadisland/regal) 0.0.89 (2020-07-20 / f46699b)

-  Java flavor: parse `\s` and `\S` to to semantically equivalent forms, instead
  of incorrectly parsing to `:whitespace` / `:non-whitespace`
-  All flavors: parse unkown escape codes to their respective characters
-  Use the Malli error protocol so we get error messages automatically (thanks @ikitommi)
-  Generators: `:any` should not generate newlines (now also for cljs)

# [Regal](https://github.com/lambadisland/regal) 0.0.80 (2020-07-17 / 3976988)

-  `[:char ...]` for code point literal
-  `[:ctrl ...]` for control character literals
-  `:line-break`, `:alert`, `:escape`, `:vertical-whitespace`, `:vertical-tab`
-  `[:(negative-)lookahead ... ]` positve/negative lookahead
-  `[:(negative-)lookbehind ...]` positive/negative lookbehind
-  `[:atomic ...]` atomic groups (prevent backtracking)
-  Parsing of `\w \W \d \D \s \S`
-  Parsing of suffixed expressions `+ * ? {1,2}`
-  `lambdaisland.regal.normalize` for getting a canonicalized version of a regal form
-  Make `:whitespace` behave consistently across platforms
-  Drop the use of `java.runtime.version` (GraalVM compat)
-  Make instaparse grammar work on ClojureScript
-  Generator fixes
-  Correctly parse a single `&` inside a bracketed character class
-  Drop `[:range from to]`, instead use `[:class [from to]]`
-  Using `:whitespace` inside `[:class ...]` or `[:not ...]` will throw an
  AssertionError, since we can't support it across platforms
-  The parser returns canonical forms, meaning single-character strings instead of characters

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.641 (2020-07-09 / ec75d9c)

-  The hooks plugin now understands two new hooks at the test suite level,
  `:kaocha.hooks/before` and `:kaocha.hooks/after`
-  Make the Hawk filesystem watcher configurable with `:kaocha.watch/hawk-opts`

# [Uri](https://github.com/lambadisland/uri) 1.4.54 (2020-06-16 / 05a8a19)

-  Make query decoding handle `+` as space, so the conversion between maps and
  query strings correctly round trips.
-  Handle percent encoding of control characters (codepoints < 16)
-  make `lambdaisland.uri.platform/string->byte-seq` return unsigned bytes on
  both plaforms (clj/cljs)

# [Uri](https://github.com/lambadisland/uri) 1.4.49 (2020-06-11 / ee48e58)

-  Make `assoc-query` / `query-encode` encode spaces as "+" rather than "%20",
  which brings it in line to how most languages/libraries do it.

# [Funnel](https://github.com/lambadisland/funnel) 0.1.16 (2020-05-26 / 81b2e61)

-  First prerelease version, implements `:funnel/whoami`, `:funnel/subscribe`,
  `:funnel/unsubscribe`, `:funnel/broadcast`, `:funnel/query`.
-  Selectors: `true`, vector, map.
# [Chui](https://github.com/lambadisland/chui) 0.0.117 (2020-05-19 / 039e492)

-  Work around an issue that cropped up due to Shadow's monkey patching of
  cljs.test.

# [Chui](https://github.com/lambadisland/chui) 0.0.103 (2020-05-13 / 70c2df1)

-  Don't wait on next tick in between interceptor steps, so as not to unduly slow
  things down
-  UI improvements

# [Chui](https://github.com/lambadisland/chui) 0.0.106 (2020-05-13 / cafb56e)

-  chui-ui: include compiled styles.clj in jar, not garden-based styles.clj

# [Chui](https://github.com/lambadisland/chui) 0.0.111 (2020-05-13 / 7ce25e2)

-  Added a warning when synchronous fixtures are used, these are not supported
-  Make the whole namespace name and surrounding block a click target for toggle
-  Show original form in failing assertion
-  Change select behaviour in column 3 to be more intuitive
-  Sort namespaces by name and vars by line number
-  Don't delegate to the original cljs.test/report, no need for all that noise in
  the console
-  Only show expected/actual sections when the assertion contains the relevant
  keys

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.632 (2020-05-13 / 149d913)

-  Added a `:kaocha.testable/skip-add-classpath?` flag on the test suite to
  prevent Kaocha from modifying the classpath

# [Chui](https://github.com/lambadisland/chui) 0.0.91 (2020-05-12 / 0a80a97)

-  Improve release process
-  Colorize progress bar / top bar based on run result

# [Chui](https://github.com/lambadisland/chui) 0.0.94 (2020-05-12 / e9fc96b)

-  Don't call capture-test-data at the top level, this may fix issues when our
  code is included in a doo project

# [Chui](https://github.com/lambadisland/chui) 0.0.73 (2020-05-11 / a151fae)


# [Glogi](https://github.com/lambadisland/glogi) 1.0.63 (2020-05-05 / bcafca0)

-  the Closure constant `lambdaisland.glogi.console.colorize` can now take four
  possible values, `"true"` (use `console.log` CSS formatting), `"false"` (log
  plain text), `"raw"`, log objects directly (good for cljs-devtools), or
  `"auto"` (detect most suitable option)

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0.629 (2020-05-02 / 6275298)

-  An Orchestra plugin `:kaocha.plugin/orchestra` for instrumenting
  functions specs with [Orchestra](https://github.com/jeaye/orchestra)
-  A Preloads plugin `:kaocha.plugin/preloads` for requiring namespaces
  before Kaocha loads test suites. This is useful for requiring spec
  namespaces or other side-effecting namespaces that are not required
  by test code.
-  Fixed an issue where plugin names where not correctly normalized before
  deduplication, leading to potentially having a plugin twice in the stack
-  Added `:kaocha.report/printed-expression` to the `debug` reporter, for
  debugging reporting issues with kaocha-cljs

# [Uri](https://github.com/lambadisland/uri) 1.3.45 (2020-05-01 / a04368b)

-  Added function for dealing with query strings as maps: `query-string->map`,
  `map->query-string`, `query-map`, `query-encode`, `assoc-query`,
  `assoc-query*`.
-  Fix query string normalization, for delimiter characters like `=` and `+`
  there is a semantic difference between the encoded and decoded form, when they
  are encoded in the input normalization should not decode them and vice versa

# [Deep-diff2](https://github.com/lambadisland/deep-diff2) 2.0.0-93 (2020-04-20 / 6ff9209)

-  Fix unsupported cljs lookbehind regex in code inherited from Puget (Thanks [@JarrodCTaylor](https://github.com/JarrodCTaylor)!)

# [Glogi](https://github.com/lambadisland/glogi) 1.0-60 (2020-04-15 / 71bea10)

-  For for when goog.log.ENABLED is false (for use in prod builds)

# [Glogi](https://github.com/lambadisland/glogi) 1.0-55 (2020-04-07 / 592208d)

-  Fix incorrect variable reference in `logger`
-  Honor goog.log.ENABLED, important for release builds

# [Edn-lines](https://github.com/lambadisland/edn-lines) 0.0-5 (2020-04-03 / b4300af)

-  First public API: `slurp`, `spit`, `reader-seq`, `append`, `with-append`
# [Glogi](https://github.com/lambadisland/glogi) 1.0-44 (2020-04-02 / 5a377e7)

-  Added colored printing of objects and arrays
-  Fixed colored printing of seqs and vectors
-  Better mapping of log levels to log methods and colors. `:trace` is now an
  alias for `:finer`, `:debug` for `:fine` (before `:trace` = `:fine` , `:debug`
  = `:config`)

# [Glogi](https://github.com/lambadisland/glogi) 1.0-47 (2020-04-02 / 35d7fff)

-  Print support for cljs.core.PersistentQueue

# [Deep-diff2](https://github.com/lambadisland/deep-diff2) 2.0.0-84 (2020-04-01 / 9c2af83)

-  Typos in deep_diff2.cljs resulting from naming changes

# [Glogi](https://github.com/lambadisland/glogi) 1.0-41 (2020-03-31 / ab9f97f)

-  Added colorization of Clojure data structures, for places where devtools is
  not available
-  Added the `config` macro, which logs to the corresponding log level

# [Glogi](https://github.com/lambadisland/glogi) 0.0-36 (2020-03-30 / e2606fb)

-  Added `spy` macro, logs the expression and its return value, returns the value
-  Added logging macros corresponding with goog.log log levels: `shout`,
  `severe`, `fine`, `finer`, `finest`
-  Use the correct console log method (log, error, warn, info) based on the log
  level

# [Kaocha-cloverage](https://github.com/lambadisland/kaocha-cloverage) 1.0-45 (2020-03-29 / 8642129)

-  Get rid of clojure.tools.reader warnings, by switching to a Cloverage version
  that does not include an AOT compiled clojure.tools.reader.

# [Kaocha](https://github.com/lambadisland/kaocha) 1.0-612 (2020-03-29 / 06293c8)

-  Kaocha's own plugins can now use a simple keyword in `tests.edn`, e.g.
  `:notifier` instead of `:kaocha.plugin/notifier`, similar to what we do on the
  command line.
-  Bumped several dependencies: org.clojure/spec.alpha, org.clojure/tools.cli, and aero

# [Deep-diff2](https://github.com/lambadisland/deep-diff2) 2.0.0-72 (2020-03-27 / 2862182)

-  Added support for ClojureScript (ported to CLJC)
-  Changed namespace and artifact (jar) names to include a "2" suffix, because of breaking changes.

# [Glogi](https://github.com/lambadisland/glogi) 0.0-29 (2020-03-25 / 991866f)

-  Got rid of the `LogBuffer/CAPACITY` hack, to prevent issues with advanced
  compilation

# [Glogi](https://github.com/lambadisland/glogi) 0.0-33 (2020-03-25 / cd9df6b)

-  Added the ability to use keywords or symbols to look up a logger, or the
  special `:glogi/root` to find the root logger.
-  Fixed `set-levels` to match its docstring. Takes a map.

# [Tools.namespace](https://github.com/lambadisland/tools.namespace) 0.0-237 (2020-03-11 / 45b51b6)

-  `ctn-find/find-namespaces-in-dir` no longer swallows exceptions when the ns
  form can't be read, instead it returns a triplet of
  [::ctn-find/reader-exception io-file exception]

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-601 (2020-03-11 / 6b88d96)

-  Namespaces where the ns form can not be read by tools.readers are now reported
  as a test failure, rather than being quietly ignored.

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-597 (2020-03-10 / 746943b)

-  Added support in the reporter for the `=?` macro as used in Expectations
  (thanks [@dharrigan](https://github.com/dharrigan) 🎉)

# [Regal](https://github.com/lambadisland/regal) 0.0.0 (2020-02-28 / 9a40397ba)


# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 0.0-71 (2020-02-24 / 773860f)

-  Depend on an actual version of Glogi, instead or "RELEASE"

# [Uri](https://github.com/lambadisland/uri) 1.2.1 (2020-02-23 / a992787)

-  Remove dependencies on ClojureScript and data.json.

# [Uri](https://github.com/lambadisland/uri) 1.2.0 (2020-02-17 / c0e1f1a)

-  `lambdaisland.uri.normalize/normalize`, for normalizing URI instances.
-  Added type hints to avoid reflection (thanks @totakke!)

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-590 (2020-02-05 / 70d314f)

-  Fix support for dynamic bindings with `set!` in watch mode. (thanks
  [@frenchy64](https://github.com/frenchy64))
-  Fixes support for `:config` hooks in the hooks plugin.

# [Kaocha-boot](https://github.com/lambadisland/kaocha-boot) 0.0-20 (2020-01-23 / 7e209fb)

-  Inherit dependencies in Boot pod without modification (thanks [@jffry](https://github.com/jffry))

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-581 (2020-01-22 / be2bd38)

-  Breaking change! Focus/skip options are now applied in two passes, once for
  options in `tests.edn`, once for command-line/REPL options. The result is that
  command line options can only narrow the set of tests to be run. (thanks
  [@otwieracz](https://github.com/otwieracz))

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-573 (2020-01-13 / 156d084)

-  Added `#meta-merge` reader literal for `tests.edn`. (thanks
  [@RickyMoynihan](https://github.com/RickMoynihan))

# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 0.0-68 (2019-12-25 / 71c2d86)

-  Wait for websocket client namespace to load before attempting to connect. This
  should help in particular with reliability when running against a browser
  environment.
-  Pick a free port for websockets automatically instead of using a hard-coded port

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-565 (2019-12-10 / 72be8ec)

-  Fix an issue with the Kaocha keyword hierarchy where two keys had an ancestor
  via two different paths, causing problems when trying to `underive`.
-  Make the version-filter plugin work with non-numeric version segments, as in
  `"1.8.0_212-20190523183340.buildslave.jdk8u"`

# [Kaocha-cucumber](https://github.com/lambadisland/kaocha-cucumber) 0.0-53 (2019-11-04 / 281b7b5)

-  Fixed reflection warnings
-  Updated Clojure and Kaocha to latest versions

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-549 (2019-10-01 / aff529c)

-  Added the `--profile` command line flag, which gets passed to Aero's `#profile
  {}` tagged literal reader. Defaults to `:ci` when `CI=true`.
-  Output a warning when `--focus TESTABLE-ID` does not match any tests.

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-554 (2019-10-01 / fc5d93a)

-  Fix regression, only show the `--focus` warning when applicable

# [Kaocha-cloverage](https://github.com/lambadisland/kaocha-cloverage) 0.0-41 (2019-09-25 / 0f12673)

-  Support code using tagged literals ([#6](https://github.com/lambdaisland/kaocha-cloverage/pull/6))

# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 0.0-59 (2019-09-12 / 9159233)

-  Added support for matcher-combinators
-  When using the nodejs repl type, automatically set the CLJS compile target to :nodejs

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-541 (2019-09-11 / c97a2cb)

-  The `kaocha.report.progress/progress` progress bar reporter now allows the
  appropriate exception to be reported when there is a syntax error in Clojure
  source code. Was formerly throwing NullPointerException.
-  Consolidate `kaocha.hierarchy`, so it can be used for kaocha-cljs

# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 0.0-51 (2019-09-11 / 4b6a751)

-  Added compatibility with Figwheel REPL
-  Make the CLJS-side logging configurable with `:closure-defines`
-  Use the same compiler env for the load and run stages
-  isomorphic-ws is no longer needed on Node (ws still is)
-  rework the websocket connection to be more reliable

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-529 (2019-07-04 / 975bbc6)

-  Be smarter about loading namespaces and resolving vars for dynamic bindings
  set in `tests.edn`

# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 0.0-40 (2019-07-02 / d0324dd)

-  Correctly pass custom compiler-options to the prepl
-  Instead of using the ClojureScript PREPL we now use a queue based solution
  that bypasses the need for a Reader. This should hopefully lead to better
  reliability.

# [Glogi](https://github.com/lambadisland/glogi) 0.0-25 (2019-06-25 / 0e226a8)

-  Added `set-level` for convenience
-  Fix assertion in `set-level`

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-521 (2019-06-19 / b652f99)

-  Type hints to eliminate reflection warnings.
-  Fix `--watch` when invoked without a `[:kaocha/cli-options :config-file]`,
  either because `tests.edn` doesn't exist, or the config originated elsewhere.
-  Make `kaocha.repl/config` set `[:kaocha/cli-options :config-file]` if
  applicable.
-  Handle exceptions in `--watch` higher up, to prevent certain errors from being
  silently ignored.
-  When providing dynamic var bindings in `tests.edn`, we now try to load the
  given namespaces before setting the bindings.

# [Glogi](https://github.com/lambadisland/glogi) 0.0-18 (2019-06-11 / a27f7fc)

-  `lambdaisland.glogi.console` provides an alternative to `goog.debug.Console`,
  with the main benefit that it will log full data structures, thus playing
  nicely with cljs-devtools
-  Added an `info` macro for compat with pedestal.
-  The default formatter is now `identity` instead of `pr-str`. This way we
  preserve full data structures until the last minute. Note that goog.debug.Logger
  will stringify the message, unless care is taken for it not to.

# [Glogi](https://github.com/lambadisland/glogi) 0.0-22 (2019-06-11 / 0d56b02)

-  Fix glogi.console when devtools isn't available

# [Glogi](https://github.com/lambadisland/glogi) 0.0-13 (2019-06-10 / 0668ebe)


# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 0.0-32 (2019-04-23 / 3d46a25)

-  Honor `:kaocha.testable/wrap`, and thus `:kaocha.hooks/wrap-run`, which fixes
  support for output capturing. This work is funded by
  [Nextjournal](https://nextjournal.com/).

# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 0.0-29 (2019-04-16 / 56f47ff)

-  The `kaocha.type.cljs/*debug*` var can be set to see what kaocha-cljs is doing
  (use `:binding {kaocha.type.cljs/*debug* true}` in `tests.edn`)
-  Proper support `cljs.test/use-fixtures`. It still only supports the map
  version, i.e. `(use-fixtures :once {:before ... :after ...})`, but should run
  both `:once`, and `:each` fixtures, honoring uses of `async` in the fixture
  functions. This work is funded by [Nextjournal](https://nextjournal.com/).
-  Improved error handling and cleanup, to prevent cases where Kaocha would fail
  to exit after an exception.

# [Deep-diff2](https://github.com/lambadisland/deep-diff2) 0.0-47 (2019-04-11 / 27cf55c)

-  Print `#uuid` and `#inst` similarly to how the Clojure printer handles them. This handles `java.util.Date`, `java.util.GregorianCalendar`, `java.sql.Timestamp`, `java.util.UUID`. (by [Nate Smith](https://github.com/nwjsmith))
-   mvxcvi/puget {:mvn/version "1.1.1"} -> {:mvn/version "1.1.2"}

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-418 (2019-04-11 / d445b44)

-  Make sure "no tests found" warning only shows up when it really needs to.
-  lambdaisland/deep-diff {:mvn/version "0.0-29"} -> {:mvn/version "0.0-47"}
-  nubank/matcher-combinators {:mvn/version "0.8.1"} -> {:mvn/version "0.9.0"}

# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 0.0-24 (2019-04-09 / 248e33c)

-  Added support for `cljs.test/async`.
-  Added initial support for `cljs.test/use-fixtures`. Currently both `:each` and `:once` fixtures are treated as `:each` fixtures, so they run before/after each test var.

# [Hillchart](https://github.com/lambadisland/hillchart) 1.0.0 (2019-04-05)


# [Hillchart](https://github.com/lambadisland/hillchart) 1.0.0 (2019-04-05)


# [Deep-diff2](https://github.com/lambadisland/deep-diff2) 0.0-35 (2019-03-31 / 3b2ad04)

-  Added type hints to prevent reflective calls

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-70 (2019-03-30 / 0377e39)

-  `<` and `>` are now escaped in XML attributes

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-413 (2019-03-30 / 9477eaf)

-  Added a check to make sure org.clojure/tools.cli is up to date.

# [Deep-diff2](https://github.com/lambadisland/deep-diff2) 0.0-29 (2019-03-19 / 3fb9abc)

-  Fix issue [diff hangs on nil](https://github.com/lambdaisland/deep-diff/issues/6) (see [upstream issue](https://github.com/droitfintech/clj-diff/issues/3))
-  mvxcvi/puget {:mvn/version "1.0.3"} -> {:mvn/version "1.1.1"}
-  fipp {:mvn/version "0.6.14"} -> {:mvn/version "0.6.17"}
-  org.clojure/core.rrb-vector {:mvn/version "0.0.13"} -> {:mvn/version "0.0.14"}
-  tech.droit/clj-diff {:mvn/version "1.0.0"} -> {:mvn/version "1.0.1"}
-  mvxcvi/arrangement {:mvn/version "1.1.1"} -> {:mvn/version "1.2.0"}

# [Kaocha-cloverage](https://github.com/lambadisland/kaocha-cloverage) 0.0-32 (2019-03-19 / 8da7e96)

-  Allow passing excluded calls to Cloverage, see also [Cloverage#242](https://github.com/cloverage/cloverage/pull/242)
-  Upgrade Cloverage to version 1.1.1

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-409 (2019-03-19 / 8f177ea)

-  Built in plugins in the `kaocha.plugin` can now be specified as simple (rather
  than namespaced) keywords.
-  The binding plugin has been removed, instead its functionality is now
  built-in, which allowed us to address several issues.
-  Load errors now end in an immediate failure of the test run, instead of a
  warning. They are reported as an error so plugins like the notifier and
  junit.xml can display them.
-  dependency upgrades, this fixes an upstream issue with clj-diff
-  lambdaisland/deep-diff {:mvn/version "0.0-25"} -> {:mvn/version "0.0-29"}
-  orchestra {:mvn/version "2018.12.06-2"} -> {:mvn/version "2019.02.06-1"}

# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 0.0-21 (2019-02-28 / 1be9c73)

-  Add ClojureScript implicit options during analysis, fixes issues with CLJSJS,
  among others.

# [Kaocha-cucumber](https://github.com/lambadisland/kaocha-cucumber) 0.0-46 (2019-02-28 / a6dccb4)

-  Fixed compatiblity with latest cucumber-jvm

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-57 (2019-02-15 / 3804cb7)

-  Addressed a warning.

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-63 (2019-02-15 / 5243781)

-  Fix potential NullPointerException

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-389 (2019-01-29 / 152db39)

-  Added a `pre-report` hook. This allows plugins to inspect and change test
  events just before they are passed to the reporter.
-  Added a `:kaocha.plugin/notifier` plugin that pops up desktop notifications
  when a test run passes or fails.
-  Add the `wrap-run` hook to the hooks plugin.
-  Watch mode: re-run all tests by pressing "enter"
-  Watch mode: watch `tests.edn` for changes
-  Watch mode: ignore certain files with `:kaocha.watch/ignore [".*" ,,,]`
-  To disable output capturing you can now use `:capture-output? false`, instead
  of `:kaocha.plugin.capture-output/capture-output? false`. Since this is a
  built-in plugin that's enabled by default it makes sense to provide a
  shorthand for this.
-  Added a `:kaocha.plugin/bindings` plugin that allows setting dynamic var
  bindings from `tests.edn`
-  Preserve changes to the config made in a `pre-load` hook
-  Watch mode: if a namespace fails to load then report it clearly and fail the
  test run, skipping any remaining tests.
-  Ignore `--focus-meta` when none of the tests have this particular metadata.
-  Print a nicer message when a plugin can't be loaded (Daniel Compton)
-  Only print random seed when test run failsg

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-53 (2019-01-28 / 69d2e2f)

-  Render non-leaf test types (e.g. clojure.test / ns) if they contain failures
  or errors (e.g. load errors).

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-367 (2019-01-16 / 514765b)

-  Added a "version-filter" plugin, which will skip tests if their metadata
  indicates they are not compatible with the Clojure or Java version being used.

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-359 (2019-01-15 / 53d06ab)

-  Mark tests with `^:kaocha/pending` metadata to skip over them, and report them
  as "pending"
-  Added a "hooks" plugin (`:kaocha.plugin/hooks`), that allows hooking into
  various parts of Kaocha's process using simple functions. This provides a more
  lightweight alternative to end users for full fledged plugins.
-  The `pre-test` hook now runs earlier, so that `:kaocha.testable/skip` or
  `:kaocha.testable/pending` can be set from the hook and still be recognized.

# [Kaocha-boot](https://github.com/lambadisland/kaocha-boot) 0.0-14 (2019-01-14 / 4c7053e)

-  Dynamically add test paths to classpath

# [Kaocha-boot](https://github.com/lambadisland/kaocha-boot) 0.0-5 (2018-12-31 / 3962fb0)


# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-343 (2018-12-31 / c38d94f)

-  [internal] Extracted `kaocha.runner/run`, to be used by alternative command
  line runners like boot.

# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 0.0-16 (2018-12-31 / 214b14e)

-  Capture exception type and message so it can be reported

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-50 (2018-12-28 / d44f155)

-  Fixed an issue in the code that strips out ANSI escape sequences, to prevent
  it from eating up some of the input.
-  The rendering of errors and failures has been made more in line with what
  consumers expect, with a one-line message attribute, and with full multiline
  output as a text element.
-  Each failure and error is now output as a separate XML element, rather than
  being grouped into a single element for each type.
-  Rendering of errors (exceptions) will look for a
  `:kaocha.report/error-message` and `:kaocha.report/error-type`, before falling
  back to calling `.getMessage` / `.getClass` on the Exception. This is for
  cases like ClojureScript where the error is originating and captured outside
  the JVM.

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-333 (2018-12-28 / 89b4c13)

-  Added a TAP reporter (`kaocha.report/tap`)
-  Added a new `--print-env` flag to the `:kaocha.plugin.alpha/info` plugin,
  which outputs the Clojure and Java version before each run.
-  Filter out `jdk.internal.reflect` stack frames when detecting source file (Java 9+)
-  Prefer a stackframe-based file/line detection over taking the file/line of the
  test definition, this way the reported location is that of the assertion,
  rather than that of the test.
-  The `print-invocations` plugin no longer prints out the `--config-file` flag
  when it hasn't changed from its default value (`tests.edn`)

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-319 (2018-12-12 / 012b4ef)

-  [internal] Test types can signal that any remaining sibling tests should be
  skipped. This is used by the ClojureScript test type: if a test times out then
  we can no longer rely on the JavaScript environment being responsive. Instead
  fail the test (signal a timeout) and skip any remaining tests in the same
  suite.
-  Removed debug prn calls

# [Kaocha-cljs](https://github.com/lambadisland/kaocha-cljs) 0.0-11 (2018-12-12 / 53fe73a)

-  Initial implementation
# [Kaocha-cloverage](https://github.com/lambadisland/kaocha-cloverage) 0.0-22 (2018-12-10 / ee13a86)

-  Don't rely on Cloverage to find namespaces, this fixes compatibility with Cucumber.

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-313 (2018-12-10 / b45ccd1)

-  A new work-in-progress information plugin, `:kaocha.plugin.alpha/info`,
  currently only prints the list of all test ids.
-  In watch mode: Scan test-dirs/source-dirs, rather than letting tools.namespace
  derive the list of paths from the classpath
-  When specifying test suites defaults are always provided, so it's no longer
  necessary to provide `:src-paths`, `:test-paths`, etc. if they don't deviate
  from the defaults. This also means all test suites get the default
  `:kaocha.filter/skip-meta [:kaocha/skip]`.

# [Kaocha-cucumber](https://github.com/lambadisland/kaocha-cucumber) 0.0-36 (2018-12-10 / ddb341a)

-  Ignore dangling symlinks for features (similar to fix in 0.0-25, but that one was for glue).
-  Prevent glue files from being reloaded for every single scenario, providing a good speedup.
-  Report file/line of pending scenarios because of missing snippets
-  Honor tags on features as metadata
-  Auto-require transformer namespace of custom types
-  Don't emit a `:pass` event after every scenario, it inflates the assertion count
-  Make sure the test result contains result counts, for things like junit-xml
-  In case of failure the output now contains the file name, line, scenario, and
  step that was currently executing.
-  No longer add the scenario as a `*testing-contexts*`, to prevent the docs
  formatter from printing it twice.
-  Give tests nicer ids, based on the filename and scenario description

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-47 (2018-12-07 / db418fa)

-  Detect "leaf" test types through Kaocha's hierarchy functions, this fixes
  compatibility with `kaocha-cucumber`

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-305 (2018-12-07 / 8b51576)

-  Consider `(is (= ))` assertions with only a single argument as failures, as
  these are most likely typos, they always evaluate to true.
-  Honor the `capture-output?` flag when provided in `tests.edn`
-  Print captured output when a test fails because it doesn't contain assertions
-  Make file/line in failures more accurate
-  Kaocha now also considers the global hierarchy when determining event types.
  This makes it possible for third-party clojure.test reporters to be
  Kaocha-aware without having to depend on Kaocha.
-  [lambdaisland/kaocha-cloverage](https://github.com/lambdaisland/kaocha-cloverage)
  is now its own project, make sure to include it in your deps/project files.

# [Tools.namespace](https://github.com/lambadisland/tools.namespace) 0.0-234 (2018-12-05 / 039c9b8)

-  Bumped dependencies of java.classpath and tools.reader

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-39 (2018-12-05 / 1507bab)

-  Automatically create parent directory of output file if it doesn't exist
-  Encode single quote as the more widely understood `&apos;` rather than `&#27;`

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-43 (2018-12-05 / 311587e)

-  Address cljdoc analysis error preventing the docs to build

# [Kaocha-cloverage](https://github.com/lambadisland/kaocha-cloverage) 0.0-18 (2018-12-05 / 9c8c629)

-  Allow configuring ns-regex and ns-exclude-regex from tests.edn ([#2](https://github.com/lambdaisland/kaocha-cloverage/pull/2))

# [Kaocha-cucumber](https://github.com/lambadisland/kaocha-cucumber) 0.0-25 (2018-12-05 / dc68f6e)

-  Don't try to load dangling symlinks, this prevents issues with emacs tmp files

# [Kaocha-cucumber](https://github.com/lambadisland/kaocha-cucumber) 0.0-28 (2018-12-05 / 39c6c82)

-  Add Kaocha as a dependency, so that cljdoc can analyze kaocha-cucumber

# [Hillchart](https://github.com/lambadisland/hillchart) [2.4.0](https://github.com/broofa/node-mime/compare/v2.3.1...v2.4.0) (2018-11-26)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.4.0](https://github.com/broofa/node-mime/compare/v2.3.1...v2.4.0) (2018-11-26)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.4.0](https://github.com/broofa/node-mime/compare/v2.3.1...v2.4.0) (2018-11-26)


# [Kaocha-cucumber](https://github.com/lambadisland/kaocha-cucumber) 0.0-20 (2018-11-23 / bf77871)

-  Report syntax errors as failures, rather than crashing the process

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-31 (2018-11-20 / 060108f)

-  Make XML output strictly conform to the JUnit XML schema ([#2](https://github.com/lambdaisland/kaocha-junit-xml/issues/2))
-  Strip escape characters in text node, they are not valid XML
-  Strip ANSI color codes
-  Number of skipped tests and number of assertions are no longer reported. While
  some sources seem to suggest they are part of the JUnit XML format, they are
  not part of the schema, and so hinder validation.

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-27 (2018-11-17 / a7f8432)

-  Fix entity escaping of text nodes and attribute values in output XML ([#1](https://github.com/lambdaisland/kaocha-junit-xml/issues/1))

# [Kaocha-cloverage](https://github.com/lambadisland/kaocha-cloverage) 0.0-3 (2018-11-15 / 80c323a)

-  Initial release
# [Kaocha-cloverage](https://github.com/lambadisland/kaocha-cloverage) 0.0-6 (2018-11-15 / 8308b88)

-  Correctly specify Cloverage as a dependency

# [Kaocha-cucumber](https://github.com/lambadisland/kaocha-cucumber) 0.0-15 (2018-11-14 / e6f43af)

-  Initial implementation

# [Deep-diff2](https://github.com/lambadisland/deep-diff2) 0.0-25 (2018-11-10 / 2fab8b1)

-  Fix support for records with inserts [#4](https://github.com/lambdaisland/deep-diff/pull/4)
-  Version upgrades:
-  mvxcvi/puget {:mvn/version "1.0.2"} -> {:mvn/version "1.0.3"}
-  fipp {:mvn/version "0.6.13"} -> {:mvn/version "0.6.14"}
-  lambdaisland/kaocha {:mvn/version "0.0-239"} -> {:mvn/version "0.0-266"}
-  lambdaisland/kaocha-junit-xml {:sha "fb06678e9f947cd7ff0deff456e8e6afae687afe"} -> {:sha "a35398d4bf553bdb09b8ef07f4bf8bd3bd40bc61"}

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-266 (2018-11-08 / 0e9d0ee)

-  Cucumber support, see [lambdaisland/kaocha-cucumber](https://github.com/lambdaisland/kaocha-cucumber)
-  Function specs are now checked with orchestra + expound
-  Plugins in the `kaocha.plugin` namespace can now be specified on the command line with their short name
-  `kaocha.assertions` namespace with custom `clojure.test` assertions. Currently
  for internal use but might evolve into its own library.
-  Added Cloverage integration, currently still included in the main `lambdaisland/kaocha` artifact.
-  Added support for "pending" tests (skipped but still reported). Currently only used by Cucumber.
-  Speeded up startup by avoiding loading kaocha.watch, core.async, fipp, puget [#14](https://github.com/lambdaisland/kaocha/issues/14)
-  This release contains several internal changes to support disparate test suite types.
-  The test summary now reads "x tests, y assertions, z failures", rather than "test vars", to be more test type agnostic.

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-18 (2018-11-05 / 83a953b)

-  error elements now contain the full stack trace as a child element, and only
  the short message as a message attribute

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-13 (2018-11-01 / a22889b)

-  Make target file configurable in tests.edn

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-248 (2018-11-01 / d6edc4f)

-  De-dupe plugins, for cases where a plugin is added to `tests.edn` and on the CLI

# [Kaocha-junit-xml](https://github.com/lambadisland/kaocha-junit-xml) 0.0-7 (2018-10-31 / 163d219)


# [Deep-diff2](https://github.com/lambadisland/deep-diff2) 0.0-15 (2018-10-31 / 63d30b5)

-  Fix support for Clojure records. Currently they are considered in the same
  equality partition as maps. (by [@ikitommi](https://github.com/ikitommi), [#1](https://github.com/lambdaisland/deep-diff/pull/1))
-  Pin explicitly to the latest version of Fipp and rrb-vector, to prevent issues
  on Java 11, see [CRRBV-18](https://dev.clojure.org/jira/browse/CRRBV-18)

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-239 (2018-10-31 / f1b9a61)

-  Skip tests marked as `^:kaocha/skip` by default
-  Junit.xml output, see [lambdaisland/kaocha-junit-xml](https://github.com/lambdaisland/kaocha-junit-xml)
-  Fix Java 11 compatiblity
-  deep-diff functionality has been extracted into [its own library](https://github.com/lambdaisland/deep-diff)

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-243 (2018-10-31 / 55bb5c1)

-  Fix matcher-combinator support

# [Deep-diff2](https://github.com/lambadisland/deep-diff2) 0.0-4 (2018-10-30 / 3d82596)

-  Extracted from Kaocha, and added a top-level namespace.
# [Deep-diff2](https://github.com/lambadisland/deep-diff2) 0.0-8 (2018-10-30 / 6bd7918)

-  `lambdaisland.deep-diff.printer/print-*` are now public, as they can be used
  in custom print handlers.

# [Hillchart](https://github.com/lambadisland/hillchart) [1.4.0](https://github.com/medikoo/cli-color/compare/v1.3.0...v1.4.0) (2018-10-23)


# [Hillchart](https://github.com/lambadisland/hillchart) [1.4.0](https://github.com/medikoo/cli-color/compare/v1.3.0...v1.4.0) (2018-10-23)


# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-217 (2018-10-22 / 642cff8)

-  Looking up of print-handler fails for nil

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-206 (2018-10-21 / 4654f45)

-  `kaocha.plugin.alpha/xfail`, mark failing tests with `^:kaocha/xfail` to make them pass, and vice versa. ([#2](https://github.com/lambdaisland/kaocha/issues/2))
-  `(is (= ,,,))` assertions are now deep diffed and pretty printed.
-  Plugins now take a "docstring" (added under the `:description` key). (For future use.)
-  `--fail-fast` mode is incompatible with the check which fails tests when they don't contain any assertions. ([#10](https://github.com/lambdaisland/kaocha/issues/10))
-  `kaocha.repl` does not correctly merge in extra config keys
-  Reported line number in case of failures points to the failed assertion, not to the failed var.
-  Passing extra config to `kaocha.repl/run` will still by default run the current `*ns*`, rather than all tests.
-  Honor `*print-length*` when set. (defaults to 100)
-  Make sure `kaocha.testable/*current-testable*` is bound when plugin's `wrap-run` result executes.
-  Config merging (defaults + tests.edn + repl values) now uses `meta-merge` for flexible append/prepend/replace.
-  Print the testable-id in failure messages rather than just the var name, so it can be passed straight on to `--focus`

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-211 (2018-10-21 / fd7e623)

-  Fix regression in `kaocha.report.progress`

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-185 (2018-09-28 / 15081ed)

-  BREAKING: `kaocha.repl/run-tests` and `kaocha.repl/run-all-tests` have been
  renamed to `run` and `run-all`, so a `(use 'kaocha.repl)` doesn't clash with
  `clojure.test`.
-  Skip reloading namespaces during load if they are already defined. In watch
  mode they still get reloaded through tools.namespace when necessary. This
  change is done to make REPL usage more intuitive. When running
  `kaocha.repl/run-tests` it will refrain from doing a `(require ... :reload)`,
  instead accepting whatever state your REPL process is in.

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-189 (2018-09-28 / 087b78b)

-  Fixed `kaocha.repl/run-all`

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-181 (2018-09-27 / 472f63f)

-  Documentation updates

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-176 (2018-09-23 / 7fd6c80)

-  Make Kaocha's reporters more easily extendable through keyword hierarchies
-  Load errors in `--watch` mode no longer cause the process to exit. Instead you
  get a warning and the loading is retried on next change.
-  Made `kaocha.repl` a lot more useful, making it easy to do a full or partial
  test run from a REPL or buffer.

# [Tools.namespace](https://github.com/lambadisland/tools.namespace) 0.0-228 (2018-09-22 / 88d4488)

-  Forked from `clojure.tools.namespace` as `lambdaisland.tools.namespace`
-  Track load errors instead of bailing out

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-162 (2018-09-20 / dc503f4)

-  Reporters in the `kaocha.report` namespace now can be specified on the command
  line with just their short name, e.g. `--reporter dots`
-  Improved matcher-combinators support, now failure summary is only shown at the
  end (for dots or docs reporter), and output is correctly captured and
  displayed.
-  Compatibility with newer matcher-combinators.

# [Kaocha-midje](https://github.com/lambadisland/kaocha-midje) 0.0-5 (2018-09-19 / 2cb6b39)

-  Initial release

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-147 (2018-09-19 / 351429d)

-  Use tools.namespace.track for tracking/reloading namespaces in watch mode.
  This should make this a lot more reliable.
-  Change the `add-classpath` classloader hack so it doesn't mess up the thread
  binding stack.
-  Make dots reporter compatible with newer versions of matcher-combinators.

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-153 (2018-09-19 / 25a68bd)

-  BREAKING: Instead of `#kaocha` use `#kaocha/v1` as a reader literal that
  normalizes configuration. The old version is still supported for now but
  generates a warning.

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-138 (2018-09-17 / 9bc74e4)

-  Due a limitation of Aero `:ns-patterns` must be strings, and not regex
  literals. Clarified this in the docs.

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-134 (2018-09-16 / d0da4e2)

-  filter keys (skip/skip-meta/focus/focus-meta) can now be used without namespace when using the `#kaocha` reader literal for configuration. Before: `:kaocha.filter/focus`, after: `:focus`.
-  Added a `:kaocha.hooks/pre-load` hook to complement `:kaocha.hooks/post-load`.

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-122 (2018-09-12 / 735aa75)

-  BREAKING: `:kaocha.type/suite` is now called `:kaocha.type/clojure.test`

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-118 (2018-09-09 / cc55d42)

-  `--version` command line flag (only works when running from a JAR)
-  `--help` as alternative to `--test-help`, for environments where `--help` isn't shadowed
-  Make code base analysable by cljdoc.xyz
-  Make sure clojars.org links to correct

# [Kaocha](https://github.com/lambadisland/kaocha) 0.0-97 (2018-09-08 / 734df37)

-  `kaocha.repl/run-tests` / `kaocha.repl/run-all-tests` (since renamed to `run` and `run-all`)
-  Dynamically adding test directories to the classpath should be more robust now.
-  `:kaocha.suite/ns-patterns`, `:kaocha.suite/source-paths` and
-  `:kaocha.suite/test-paths` have been renamed to just use the `:kaocha`
namespace.

# [Hillchart](https://github.com/lambadisland/hillchart) [1.3.0](https://github.com/medikoo/cli-color/compare/v1.2.0...v1.3.0) (2018-08-20)


# [Hillchart](https://github.com/lambadisland/hillchart) [1.3.0](https://github.com/medikoo/cli-color/compare/v1.2.0...v1.3.0) (2018-08-20)


# [Kaocha](https://github.com/lambadisland/kaocha) b0a70dc267a (2018-07-29)

-  Capture output, this is enabled by default. Only output of failing tests is
  printed. This also introduced a new plugin hook, `wrap-run`, which allows you
  to decorate `run-testables` for doing things like adding bindings.
-  Reporters now always get the current testable in their clojure.test reporting
  event.
-  Added a progress bar reporter
-  Documentation reporter: show in the documentation output which tests fail.
-  The randomize plugin could cause an exception because the
  sort-by-random-number-generator wasn't stable (it violated the contract of a
  comparator). Instead assign each testable a sort key first, then sort by
  those. This does mean seeds from before this change will no longer produce the
  same result.
-  When specifying an invalid reporter var, error before trying to load tests.
-  Correctly count matcher-combinator mismatch failures when exiting early (Ctrl-C).

# [Hillchart](https://github.com/lambadisland/hillchart) [3.3.0](https://github.com/kelektiv/node-uuid/compare/v3.2.1...v3.3.0) (2018-06-22)


# [Hillchart](https://github.com/lambadisland/hillchart) [3.3.0](https://github.com/kelektiv/node-uuid/compare/v3.2.1...v3.3.0) (2018-06-22)


# [Kaocha](https://github.com/lambadisland/kaocha) 7b79fad92d (2018-06-16)

-  The profiling plugin can now be configured on the command line and from
  tests.edn, with `--[no-]profiling`, `--profiling-count`,
  `:kaocha.plugin.profiling/profiling?`, `:kaocha.plugin.profiling/count`
-  Don't count filtered tests in profiling results.
-  `--focus` and `--focus-meta` override config-level `:focus`/`:focus-meta`,
  rather than append. This is more intuitive, when focusing from the command
  line you don't want extra tests to show up.
-  Don't run the `post-summary` hook when using the API, this prevents noise from
  plugins in the `--print-test-plan` / `--print-result` output.

# [Kaocha](https://github.com/lambadisland/kaocha) 3319ed6f81 (2018-06-13)

-  Added the `kaocha.plugin/defplugin` macro, making plugins look more like a
  deftype.

# [Kaocha](https://github.com/lambadisland/kaocha) 9a920204bc (2018-06-13)

-  Make the test-plan available in `pre-test` and `post-test` plugin hooks, so
  that they have access to top level configuration items.

# [Kaocha](https://github.com/lambadisland/kaocha) 8eeff5b340 (2018-06-13)

-  Testable now has an optional `:kaocha.var/wrap` key, which can contain a seq
  of functions that will be used to "wrap" the actual test function, useful e.g.
  for providing bindings. clojure.test style :each fixtures are also handled
  through this key, so plugins can choose to add wrapping functions at the start
  or the end of this seq to wrap "inside" or "around" the fixtures.

# [Kaocha](https://github.com/lambadisland/kaocha) 9a6fa32592 (2018-06-02)

-  The configuration format has changed, you should now start with the `#kaocha
  {}` tagged reader literal in `tests.edn` to provide defaults. If you want more
  control then overwrite `tests.edn` with the output of `--print-config` and
  tweak.

# [Hillchart](https://github.com/lambadisland/hillchart) [2.3.0](https://github.com/broofa/node-mime/compare/v2.2.2...v2.3.0) (2018-04-11)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.3.0](https://github.com/broofa/node-mime/compare/v2.2.2...v2.3.0) (2018-04-11)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.3.0](https://github.com/broofa/node-mime/compare/v2.2.2...v2.3.0) (2018-04-11)


# [Hillchart](https://github.com/lambadisland/hillchart) [6.0.0](https://github.com/moxystudio/node-cross-spawn/compare/5.1.0...6.0.0) (2018-01-23)


# [Hillchart](https://github.com/lambadisland/hillchart) [6.0.0](https://github.com/moxystudio/node-cross-spawn/compare/5.1.0...6.0.0) (2018-01-23)


# [Hillchart](https://github.com/lambadisland/hillchart) [3.2.0](https://github.com/kelektiv/node-uuid/compare/v3.1.0...v3.2.0) (2018-01-16)


# [Hillchart](https://github.com/lambadisland/hillchart) [3.2.0](https://github.com/kelektiv/node-uuid/compare/v3.1.0...v3.2.0) (2018-01-16)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.2.0](https://github.com/broofa/node-mime/compare/v2.1.0...v2.2.0) (2018-01-04)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.2.0](https://github.com/broofa/node-mime/compare/v2.1.0...v2.2.0) (2018-01-04)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.2.0](https://github.com/broofa/node-mime/compare/v2.1.0...v2.2.0) (2018-01-04)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.1.0](https://github.com/broofa/node-mime/compare/v2.0.5...v2.1.0) (2017-12-22)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.1.0](https://github.com/broofa/node-mime/compare/v2.0.5...v2.1.0) (2017-12-22)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.1.0](https://github.com/broofa/node-mime/compare/v2.0.5...v2.1.0) (2017-12-22)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.2.0](https://github.com/knownasilya/cli-width/compare/v2.1.1...v2.2.0) (2017-08-22)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.2.0](https://github.com/knownasilya/cli-width/compare/v2.1.1...v2.2.0) (2017-08-22)


# [Hillchart](https://github.com/lambadisland/hillchart) [3.1.0](https://github.com/kelektiv/node-uuid/compare/v3.1.0...v3.0.1) (2017-06-17)


# [Hillchart](https://github.com/lambadisland/hillchart) [3.1.0](https://github.com/kelektiv/node-uuid/compare/v3.1.0...v3.0.1) (2017-06-17)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.0.0](https://github.com/nexdrew/ansi-align/compare/v1.1.0...v2.0.0) (2017-05-01)


# [Hillchart](https://github.com/lambadisland/hillchart) [2.0.0](https://github.com/nexdrew/ansi-align/compare/v1.1.0...v2.0.0) (2017-05-01)


# [Uri](https://github.com/lambadisland/uri) 1.1.0 (2017-04-25)

-  Predicate functions `absolute?` and `relative?`

# [Uri](https://github.com/lambadisland/uri) 1.0.0 (2017-02-23)

-  Initial release, public vars: `uri`, `join`, `coerce`, `parse`, `edn-readers`
# [Hillchart](https://github.com/lambadisland/hillchart) 3.0.1 (2016-11-28)


# [Hillchart](https://github.com/lambadisland/hillchart) 3.0.1 (2016-11-28)


# [Hillchart](https://github.com/lambadisland/hillchart) 3.0.0 (2016-11-17)


# [Hillchart](https://github.com/lambadisland/hillchart) 3.0.0 (2016-11-17)


# [Hillchart](https://github.com/lambadisland/hillchart) [5.0.0](https://github.com/moxystudio/node-cross-spawn/compare/4.0.2...5.0.0) (2016-10-30)


# [Hillchart](https://github.com/lambadisland/hillchart) [5.0.0](https://github.com/moxystudio/node-cross-spawn/compare/4.0.2...5.0.0) (2016-10-30)


# [Hillchart](https://github.com/lambadisland/hillchart) [3.0.0](https://github.com/tapjs/signal-exit/compare/v2.1.2...v3.0.0) (2016-06-13)


# [Hillchart](https://github.com/lambadisland/hillchart) [3.0.0](https://github.com/tapjs/signal-exit/compare/v2.1.2...v3.0.0) (2016-06-13)


# [Hillchart](https://github.com/lambadisland/hillchart) [1.1.0](https://github.com/nexdrew/ansi-align/compare/v1.0.0...v1.1.0) (2016-06-06)


# [Hillchart](https://github.com/lambadisland/hillchart) [1.1.0](https://github.com/nexdrew/ansi-align/compare/v1.0.0...v1.1.0) (2016-06-06)


# [Hillchart](https://github.com/lambadisland/hillchart) 1.0.0 (2016-04-30)


# [Hillchart](https://github.com/lambadisland/hillchart) 1.0.0 (2016-04-30)


# [Puck](https://github.com/lambadisland/puck) 1.0.0 (2016-02-04)


