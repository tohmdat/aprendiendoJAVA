package klondikeconherencia;

class Palo extends Mazo {

    public Palo() {
        super(Baraja.NUM_NUMEROS, "Palo");
    }

    @Override
    public void mostrarContenido() {
        this.cima().mostrar();        
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
