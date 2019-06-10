package klondikeconherencia;

class Coordenada {

    private int fila;

    private int columna;

    private static final Intervalo LIMITES = new Intervalo(1, 3);

    public Coordenada() {
    }

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        assert this.valida();
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean igual(Coordenada coordenada) {
        assert coordenada != null;
        return fila == coordenada.fila && columna == coordenada.columna;
    }

    public void recoger() {
        GestorIO gestorIO = new GestorIO();
        boolean error = false;
        do {
            gestorIO.out("Introduce fila [1,3]: ");
            fila = gestorIO.inInt();
            gestorIO.out("Introduce columna [1,3]: ");
            columna = gestorIO.inInt();
            error = !this.valida();
            if (error) {
                gestorIO.out("Error!!! Valores fuera de rango\n");
            }
        } while (error);
    }

    private boolean valida() {
        return LIMITES.incluye(fila) && LIMITES.incluye(columna);
    }

    public static void main(String[] args) {
        GestorIO gestorIO = new GestorIO();
        for (int i = 0; i < 3; i++) {
            gestorIO.out("Primera coordenada\n");
            Coordenada coordenada1 = new Coordenada();
            coordenada1.recoger();
            gestorIO.out("Segunda coordenada\n");
            Coordenada coordenada2 = new Coordenada();
            coordenada2.recoger();
            gestorIO.out("Iguales: " + coordenada1.igual(coordenada2)+ "\n\n");
        }
    }

    public int direccion(Coordenada coordenada) {
        if (fila == coordenada.fila){
            return 0;
        }
        if (columna == coordenada.columna){
            return 1;
        }
        if (fila - columna == 0 && coordenada.fila - coordenada.columna == 0){
            return 2;
        }
        if (fila +  columna == 4 && coordenada.fila + coordenada.columna == 4){
            return 3;
        }       
        return -1;
    }

}
