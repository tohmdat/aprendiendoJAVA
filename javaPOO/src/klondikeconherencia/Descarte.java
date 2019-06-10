package klondikeconherencia;

class Descarte extends Mazo {

    public Descarte() {
        super(52 - 28, "Descarte");
    }

    @Override
    public void mostrarContenido() {
        int primeraVisible = ultima - 3;
        if (primeraVisible < 0) {
            primeraVisible = 0;
        }
        for (int i = primeraVisible; i < ultima; i++) {
            cartas[i].mostrar();
        }        
    }

    public void moverA(Palo palo) {
        assert palo != null;
        if (this.vacia()) {
            new GestorIO().out("Error!!! No hay cartas en descarte");
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
            new GestorIO().out("Error!!! No hay cartas en descarte");
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

    public void voltear(Baraja baraja) {
        if (this.vacia()) {
            new GestorIO().out("Error!!! No hay cartas en descarte");
        } else {
            while (!this.vacia()) {
                Carta carta = this.sacar();
                carta.voltear();
                baraja.poner(carta);
            }
        }
    }

}
