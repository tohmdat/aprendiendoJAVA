package klondikeconherencia;

class Columna extends Mazo {

    public Columna(int posicion, Baraja baraja) {
        super(posicion + Baraja.NUM_NUMEROS - 1, "Columna" + posicion);
        for (int i = 0; i < posicion; i++) {
            Carta carta = baraja.sacar();
            if (i == posicion - 1) {
                carta.voltear();
            }
            this.poner(carta);
        }
    }

    @Override
    public void mostrarContenido() {
        for (int i = 0; i < ultima; i++) {
            cartas[i].mostrar();
        }        
    }

    public void moverA(Palo palo) {
        if (this.vacia()) {
            new GestorIO().out("Error!!! No hay cartas en columna");
        } else {
            Carta carta = this.sacar();
            if (palo.apilable(carta)) {
                palo.poner(carta);
            } else {
                this.poner(carta);
                new GestorIO().out("Error!!! No se puede realizar ese movimiento");
            }
        }
    }

    public void moverA(Columna columna) {
        if (this.vacia()) {
            new GestorIO().out("Error!!! No hay cartas en columna");
        } else {
            Carta carta = this.sacar();
            if (columna.apilable(carta)) {
                columna.poner(carta);
            } else {
                this.poner(carta);
                new GestorIO().out("Error!!! No se puede realizar ese movimiento");
            }
        }
    }

    public void voltear() {
        if (this.vacia()) {
            new GestorIO().out("Error!!! No hay carta que voltear");
        } else if (this.cima().bocaArriba()) {
            new GestorIO().out("Error!!! No hay carta boca abajo en la cima");
        } else {
            this.cima().voltear();
        }
    }

    public boolean apilable(Carta carta) {
        assert carta != null;
        return this.vacia() && carta.esRey() || 
                !this.vacia() && this.cima().bocaArriba() && 
                this.cima().siguiente(carta) && 
                this.cima().distintoColor(carta);
    }

}
