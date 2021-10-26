PROJECTS := kaocha kaocha-cucumber kaocha-cloverage kaocha-junit-xml zipper-viz ansi kaocha-midje

DEPS_JOBS := $(addsuffix -deps,${PROJECTS}) publish-dev-orbs promote-orb-kaocha promote-orb-clojure update-deps

${DEPS_JOBS}: %-deps:
	cd $*
	clojure -Sdeps '{:deps {olical/depot {:mvn/version "RELEASE"}}}' -m depot.outdated.main --update
	git diff deps.edn

update-deps: ${DEPS_JOBS}

publish-dev-orbs:
	circleci orb publish circleci/kaocha_orb.yml lambdaisland/kaocha@dev:first
	circleci orb publish circleci/clojure_orb.yml lambdaisland/clojure@dev:first

promote-orb-kaocha:
	circleci orb publish promote lambdaisland/kaocha@dev:first patch

promote-orb-clojure:
	circleci orb publish promote lambdaisland/clojure@dev:first patch
