JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Car.java \
	CarPosition.java \
	Light.java \
	Lane.java \
	TrafficSystem.java \
	Simulation.java
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
