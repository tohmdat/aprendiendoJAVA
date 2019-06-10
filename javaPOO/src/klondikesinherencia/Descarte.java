package klondikesinherencia;

class Descarte {

    private Carta[] cartas;

    private int ultima;

    public Descarte() {
        ultima = 0;
        cartas = new Carta[52 - 28];
    }

    private boolean vacia() {
        return ultima == 0;
    }

    private boolean completa() {
        return ultima == Baraja.NUM_PALOS * Baraja.NUM_NUMEROS;
    }

    public Carta sacar() {
        assert !this.vacia();
        ultima--;
        return cartas[ultima];
    }

    public void poner(Carta carta) {
        assert carta != null;
        assert carta.bocaArriba();
        assert !this.completa();
        cartas[ultima] = carta;
        ultima++;
    }

    public void mostrar() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("\nDescarte: ");
        if (this.vacia()) {
            gestorIO.out("<VACIA>");
        } else {
            int primeraVisible = ultima - 3;
            if (primeraVisible < 0) {
                primeraVisible = 0;
            }
            for (int i = primeraVisible; i < ultima; i++) {
                cartas[i].mostrar();
            }
        }
    }

    public void moverA(Palo palo) {
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
