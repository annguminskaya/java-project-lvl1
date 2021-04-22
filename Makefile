# Запустите сборку проекта и убедитесь, что в процессе сборки также была запущена проверка кода линтером.
# При install checkstyleMain не отрабатывает:
# Selected primary task 'installDist' from project :
# Tasks to be executed: [task ':compileJava', task ':processResources', task ':classes', task ':jar', task ':startScripts', task ':installDist']
# Линтер по умолчанию отрабатывает при вызове ./gradlew build
install:
	./gradlew clean install
build:
	./gradlew clean build
run-dist:
	./build/install/app/bin/app
check-updates:
	./gradlew dependencyUpdates
lint:
	./gradlew checkstyleMain