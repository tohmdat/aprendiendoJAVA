package klondikepolimorfismo;

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

    @Override
    public boolean apilable(Carta carta) {
        return true;
    }

}
