PROJECTS := kaocha kaocha-cucumber kaocha-cloverage kaocha-junit-xml zipper-viz ansi kaocha-midje

# trikl uri
# cucumber xml

BADGE_JOBS := $(addsuffix -badges,${PROJECTS})
LICENSE_JOBS := $(addsuffix -license,${PROJECTS})
DEPS_JOBS := $(addsuffix -deps,${PROJECTS}) publish-dev-orbs promote-orb-kaocha promote-orb-clojure update-deps

.ONESHELL:
.PHONY: ${BADGE_JOBS} ${DEPS_JOBS}

${BADGE_JOBS}: %-badges:
	if grep "\-- badges --" $*/README.md; then
	ed $*/README.md <<-EOF
		/-- badges --/+,/-- \/badges --/- d
		i
		[![CircleCI](https://circleci.com/gh/lambdaisland/$*.svg?style=svg)](https://circleci.com/gh/lambdaisland/$*) [![cljdoc badge](https://cljdoc.org/badge/lambdaisland/$*)](https://cljdoc.org/d/lambdaisland/$*) [![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/$*.svg)](https://clojars.org/lambdaisland/$*) [![codecov](https://codecov.io/gh/lambdaisland/$*/branch/master/graph/badge.svg)](https://codecov.io/gh/lambdaisland/$*)
		.
		wq
	EOF
	fi
	git -C $* diff README.md

${LICENSE_JOBS}: %-license:
	if grep "\-- license-epl --" $*/README.md; then
	ed $*/README.md <<-EOF
		/-- license-epl --/+,/-- \/license-epl --/- d
		i
		## License
		&nbsp;
		Copyright &copy; 2018-2019 Arne Brasseur
		&nbsp;
		Available under the terms of the Eclipse Public License 1.0, see LICENSE.txt
		.
		wq
	EOF
	fi
	git -C $* diff README.md

update-licenses: ${LICENSE_JOBS}
update-badges: ${BADGE_JOBS}

${DEPS_JOBS}: %-deps:
	cd $*
	clojure -Sdeps '{:deps {olical/depot {:mvn/version "1.5.0"}}}' -m depot.outdated.main --update
	git diff deps.edn

update-deps: ${DEPS_JOBS}

publish-dev-orbs:
	circleci orb publish circleci/kaocha_orb.yml lambdaisland/kaocha@dev:first
	circleci orb publish circleci/clojure_orb.yml lambdaisland/clojure@dev:first

promote-orb-kaocha:
	circleci orb publish promote lambdaisland/kaocha@dev:first patch

promote-orb-clojure:
	circleci orb publish promote lambdaisland/clojure@dev:first patch
