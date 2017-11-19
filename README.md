Francisco Abarca 201673552-6 
Daniel Toro 201673595-k

Ataques especiales jugador:
- Guillotine Fist +200 ataque, 30pp
- Rising Dragon +500 ataque, 25pp
- Knuckle Arrow +100 ataque, 50pp
- Gate of Hell +5000 ataque, 5pp

Ataques especiales jefe:
- Cannon Spear + 300 ataque
- Limit Break +10000 ataque

Objetos:
- Veil of Discord +600 defensa
- Chainmail +500 defensa
- Guardian Greaves + 500 vida
- Lotus Orb +1000 vida

Uso del Makefile:

Compilacion:
make

Ejecucion:
make run

(Opcional)Limpieza

make clean

Uso del .jaar:

Compilacion:

jar -cfvm juegoTarea.jar Manifest.txt Juego.class Jugador.class Aliado.class Ataque.class AtaqueEspecial.class Enemigo.class Jefe.class Juego.class Nivel.class Objeto.class Personaje.class  Test.class

Ejecucion:
java -jar juegoTarea.jar

Consideraciones menores:
Para los nombres, si son compuestos se deben separar con un guion bajo. (Ej Alan_Brito)
La defensa no puede ser 0 o menos que 0.
