JAVAC = javac
JAVA_FILES = $(wildcard *.java)
CLASS_FILES = $(JAVA_FILES:.java=.class)

build:
	$(JAVAC) $(JAVA_FILES)

clean:
	rm -f $(CLASS_FILES)