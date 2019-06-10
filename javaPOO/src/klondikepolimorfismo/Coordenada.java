package klondikepolimorfismo;

class Coordenada {

    protected int fila;

    protected int columna;

    public Coordenada() {
    }

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public boolean igual(Coordenada coordenada) {
        assert coordenada != null;
        return fila == coordenada.fila && columna == coordenada.columna;
    }

    public void recoger(String limites) {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Introduce fila " + limites + ": ");
        fila = gestorIO.inInt();
        gestorIO.out("Introduce columna " + limites + ": ");
        columna = gestorIO.inInt();
    }

    public static void main(String[] args) {
        GestorIO gestorIO = new GestorIO();
        for (int i = 0; i < 3; i++) {
            gestorIO.out("Primera coordenada\n");
            Coordenada coordenada1 = new Coordenada();
            coordenada1.recoger("");
            gestorIO.out("Segunda coordenada\n");
            Coordenada coordenada2 = new Coordenada();
            coordenada2.recoger("");
            gestorIO.out("Iguales: " + coordenada1.igual(coordenada2) + "\n\n");
        }
    }

}
