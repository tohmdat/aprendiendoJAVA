package codigoclase07;

class Tablero {

    private char[][] casillas;
    
    private static final int DIMENSION = 3;
    
    private static final char VACIA = '_';

    public Tablero() {
        casillas = new char[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                casillas[i][j] = VACIA;
            }
        }
    }

    public void mostrar() {
        GestorIO gestorIO = new GestorIO();
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                gestorIO.out(" " + casillas[i][j]);
            }
            gestorIO.out("\n");
        }
        gestorIO.out("\n");
    }

    public boolean hayTresEnRaya() {
        return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
    }

    private boolean hayTresEnRaya(char color) {
        int[] filas = new int[DIMENSION];
        int[] columnas = new int[DIMENSION];
        int diagonal = 0;
        int secundaria = 0;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (color == casillas[i][j]) {
                    filas[i]++;
                    columnas[j]++;
                    if (i == j) {
                        diagonal++;
                    }
                    if (i + j == 2) {
                        secundaria++;
                    }
                }
            }
        }
        if (diagonal == DIMENSION || secundaria == DIMENSION) {
            return true;
        } else {
            for(int i=0; i<3; i++){
                if (filas[i] == DIMENSION || columnas[i] == DIMENSION){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estaCompleto(Jugador jugador) {
        assert jugador != null;
        int fichas = 0;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (jugador.color() == casillas[i][j]) {
                    fichas++;
                }
            }
        }
        return fichas==DIMENSION;
    }

    public boolean ocupada(Coordenada coordenada, char color) {
        assert coordenada != null;
        return casillas[coordenada.getFila()-1][coordenada.getColumna()-1] == color;
    }
    
    public boolean ocupada(Coordenada coordenada) {
        return !this.ocupada(coordenada,VACIA);
    }

    public void ponerFicha(Coordenada coordenada, char color) {
        assert coordenada != null;     
        casillas[coordenada.getFila()-1][coordenada.getColumna()-1] = color;
    }

    public void retirarFicha(Coordenada coordenada) {
        assert coordenada != null;
        assert this.ocupada(coordenada); 
        this.ponerFicha(coordenada, VACIA);
    }
    
    public static void main (String[] args){
        GestorIO gestorIO = new GestorIO();
        Coordenada[][] coleccionesCoordenadas = new Coordenada[][]{
                {new Coordenada(1,1), new Coordenada(2,1), new Coordenada(3,1)},
                {new Coordenada(1,2), new Coordenada(2,2), new Coordenada(3,2)},
                {new Coordenada(1,3), new Coordenada(2,3), new Coordenada(3,3)},
                {new Coordenada(1,1), new Coordenada(1,2), new Coordenada(1,3)},
                {new Coordenada(2,1), new Coordenada(2,2), new Coordenada(2,3)},
                {new Coordenada(3,1), new Coordenada(3,2), new Coordenada(3,3)},
                {new Coordenada(1,1), new Coordenada(2,2), new Coordenada(3,3)},
                {new Coordenada(1,3), new Coordenada(2,2), new Coordenada(3,1)},
                {new Coordenada(1,1), new Coordenada(2,2), new Coordenada(3,1)},
                {new Coordenada(1,2), new Coordenada(2,1), new Coordenada(3,3)},
                {new Coordenada(2,3), new Coordenada(1,2), new Coordenada(3,2)},
        };
        for (Coordenada[] coleccionCoordenadas : coleccionesCoordenadas) {
            gestorIO.out("----------------------------------\n");
            Tablero tablero = new Tablero();
            tablero.mostrar();
            for (Coordenada coordenada : coleccionCoordenadas) {
                tablero.ponerFicha(coordenada, 'x');
                tablero.mostrar();
                gestorIO.out("Completo: " + tablero.estaCompleto(new Jugador('x')) + "\n");
                gestorIO.out("Ocupada la coordenada (2,2): " + tablero.ocupada(new Coordenada(2,2)) + "\n");
                gestorIO.out("Ocupada la coordenada (2,2) por una x: " + tablero.ocupada(new Coordenada(2,2),'x') + "\n");
                gestorIO.out("Ocupada la coordenada (2,2) por un o: " + tablero.ocupada(new Coordenada(2,2),'o') + "\n");
            }
            gestorIO.out("Tres en raya: " + tablero.hayTresEnRaya() + "\n");
            for (Coordenada coordenada : coleccionCoordenadas) {
                tablero.retirarFicha(coordenada);
                tablero.mostrar();
                gestorIO.out("Completo: " + tablero.estaCompleto(new Jugador('x')) + "\n");
                gestorIO.out("Ocupada la coordenada (2,2): " + tablero.ocupada(new Coordenada(2,2)) + "\n");
                gestorIO.out("Ocupada la coordenada (2,2) por una x: " + tablero.ocupada(new Coordenada(2,2),'x') + "\n");
                gestorIO.out("Ocupada la coordenada (2,2) por un o: " + tablero.ocupada(new Coordenada(2,2),'o') + "\n");
            }
        }
    }

}
