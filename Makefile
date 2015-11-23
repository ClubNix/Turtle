CLASSPATH=/usr/share/java/jzmq.jar:/usr/share/java/jeromq.jar:.
BUILD_DIR=build/
JFLAGS=-Xlint:all -d ${BUILD_DIR} #-Wall -o build/*.class

all:	class turtle.jar

turtle.jar:
	@jar cmf Manifest turtle.jar -C build/ .

class:
	@mkdir build/ 2> /dev/null || true
	@javac ${JFLAGS} -cp ${CLASSPATH} src/*.java

clean:
	@rm build/* 2> /dev/null || true
	@rm turtle.jar
