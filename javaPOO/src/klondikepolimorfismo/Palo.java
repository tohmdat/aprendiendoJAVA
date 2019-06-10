package klondikepolimorfismo;

class Palo extends Mazo {

    public Palo() {
        super(Baraja.NUM_NUMEROS, "Palo");
    }

    @Override
    public void mostrarContenido() {
        this.cima().mostrar();        
    }

    @Override
    public boolean apilable(Carta carta) {
        assert carta != null;
        return this.vacia() && carta.esAs() || 
                !this.vacia() && carta.siguiente(this.cima()) && carta.igualPalo(this.cima());
    }

}
