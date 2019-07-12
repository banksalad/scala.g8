.PHONY: build test

run:
	docker-compose run app sbt "~ ;reStart ; run"

test:
	docker-compose run app sbt clean scalafmt::test test
