class Palo {

    private Carta[] cartas;

    private int ultima;

    public Palo() {
        ultima = 0;
        cartas = new Carta[Baraja.NUM_NUMEROS];
    }

    private boolean vacia() {
        return ultima == 0;
    }

    private boolean completa() {
        return ultima == Baraja.NUM_NUMEROS;
    }

    private Carta cima() {
        assert !this.vacia();
        return cartas[ultima - 1];
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
        gestorIO.out("\nPalo: ");
        if (this.vacia()) {
            gestorIO.out("<VACIA>");
        } else {
            this.cima().mostrar();
        }
    }

    public void moverA(Columna columna) {
        if (this.vacia()) {
            new GestorIO().out("Error!!! No hay cartas en palo");
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

    public boolean apilable(Carta carta) {
        assert carta != null;
        return this.vacia() && carta.esAs() || 
                !this.vacia() && carta.siguiente(this.cima()) && carta.igualPalo(this.cima());
    }

}
