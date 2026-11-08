JAVAC   := javac
SRC     := $(wildcard *.java)
CLASSES := $(SRC:.java=.class)

.PHONY: all build clean

all: build

build: $(CLASSES)

%.class: %.java
	$(JAVAC) $<

clean:
	rm -f *.class