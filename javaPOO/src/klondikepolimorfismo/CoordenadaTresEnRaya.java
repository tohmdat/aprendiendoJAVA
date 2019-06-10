package klondikepolimorfismo;

class CoordenadaTresEnRaya extends Coordenada {

    private static final Intervalo LIMITES = new Intervalo(1, Tablero.DIMENSION);

    public CoordenadaTresEnRaya() {
        super();
    }

    public CoordenadaTresEnRaya(int fila, int columna) {
        super(fila, columna);
        assert this.valida();
    }

    public void recoger() {
        GestorIO gestorIO = new GestorIO();
        boolean error = false;
        do {
            super.recoger("[1, "+ Tablero.DIMENSION +"]");
            error = !this.valida();
            if (error) {
                gestorIO.out("Error!!! Valores fuera de rango\n");
            }
        } while (error);
    }

    private boolean valida() {
        return LIMITES.incluye(fila) && LIMITES.incluye(columna);
    }

    public int direccion(CoordenadaTresEnRaya coordenada) {
        if (this.enFila(coordenada)) {
            return 0;
        }
        if (this.enColumna(coordenada)) {
            return 1;
        }
        if (this.enDiagonalPrincipal() && coordenada.enDiagonalPrincipal()) {
            return 2;
        }
        if (this.enDiagonalSecundaria() && coordenada.enDiagonalSecundaria()) {
            return 3;
        }
        return -1;
    }
    
    private boolean enFila(Coordenada coordenada){
        return fila == coordenada.fila;
    }
    
    private boolean enColumna(Coordenada coordenada){
        return columna == coordenada.columna;
    }

    private boolean enDiagonalPrincipal() {
        return fila - columna == 0;
    }

    private boolean enDiagonalSecundaria() {
        return fila + columna == Tablero.DIMENSION+1;
    }

    public static void main(String[] args) {
        GestorIO gestorIO = new GestorIO();
        for (int i = 0; i < 3; i++) {
            gestorIO.out("Primera coordenada\n");
            CoordenadaTresEnRaya coordenada1 = new CoordenadaTresEnRaya();
            coordenada1.recoger();
            gestorIO.out("Segunda coordenada\n");
            CoordenadaTresEnRaya coordenada2 = new CoordenadaTresEnRaya();
            coordenada2.recoger();
            gestorIO.out("Iguales: " + coordenada1.igual(coordenada2) + "\n\n");
        }
    }

}
