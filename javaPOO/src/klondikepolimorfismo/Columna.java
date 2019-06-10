package klondikepolimorfismo;

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

    @Override
    public boolean apilable(Carta carta) {
        assert carta != null;
        return this.vacia() && carta.esRey() || 
                !this.vacia() && this.cima().bocaArriba() && 
                this.cima().siguiente(carta) && 
                this.cima().distintoColor(carta);
    }

}
