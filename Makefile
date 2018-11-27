.PHONY: publish_dev_orbs promote_orb_kaocha promote_orb_clojure

publish_dev_orbs:
	circleci orb publish circleci/kaocha_orb.yml lambdaisland/kaocha@dev:first
	circleci orb publish circleci/clojure_orb.yml lambdaisland/clojure@dev:first

promote_orb_kaocha:
	circleci orb publish promote lambdaisland/kaocha@dev:first patch

promote_orb_clojure:
  circleci orb publish promote lambdaisland/clojure@dev:first patch
