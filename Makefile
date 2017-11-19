
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Aliado.java \
        Ataque.java \
        AtaqueEspecial.java \
        Enemigo.java \
        Jefe.java \
        Juego.java \
        Jugador.java \
        Nivel.java \
        Objeto.java \
        Personaje.java \
        Simulador.java \
        test.java

default: classes

classes: $(CLASSES:.java=.class)

run:
	java Juego

clean:
	$(RM) *.class
