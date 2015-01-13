JFLAGS = -g
JC = javac
JVM= java 

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

MAIN = Simulation 

CLASSES = \
	Car.java \
	CarPosition.java \
	Light.java \
	Lane.java \
	TrafficSystem.java \
	Taxi.java \
	Simulation.java


default: classes
	$(JVM) $(MAIN).class


classes: $(CLASSES:.java=.class)


sim: classes

run: sim
	$(JVM) $(MAIN).class

clean:
	$(RM) *.class
