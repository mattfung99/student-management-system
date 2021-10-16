build:
	chmod +x gradlew
	./gradlew prepareDocker
	docker build --tag="sm-system/smsystem:0.1" build/docker/server/

run:
	docker start smsServer

run-initial:
	docker run -d -p 8080:8080 --name smsServer sm-system/smsystem:0.1

stop:
	docker stop smsServer