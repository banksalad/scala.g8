.PHONY: build test

build:
	docker-compose build

test:
	docker-compose run app sbt clean scalafmt::test test
