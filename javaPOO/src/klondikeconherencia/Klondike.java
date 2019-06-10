package klondikeconherencia;

class Klondike {

    private Baraja baraja;

    private Descarte descarte;

    private Palo[] palos;

    private Columna[] columnas;
    
    private static final int NUM_COLUMNAS = 7;

    private Klondike() {
        baraja = new Baraja();
        descarte = new Descarte();
        palos = new Palo[Baraja.NUM_PALOS];
        for (int i = 0; i < palos.length; i++) {
            palos[i] = new Palo();
        }
        columnas = new Columna[NUM_COLUMNAS];
        for (int i = 0; i < columnas.length; i++) {
            columnas[i] = new Columna(i + 1, baraja);
        }
    }

    private void jugar() {
        Menu menu = new Menu();
        int opcion;
        do {
            this.mostrar();
            menu.mostrar();
            opcion = menu.getOpcion();
            switch (opcion) {
            case 1:
                baraja.moverA(descarte);
                break;
            case 2:
                descarte.moverA(this.recogerPalo("A"));
                break;
            case 3:
                descarte.moverA(this.recogerColumna("A"));
                break;
            case 4:
                this.recogerPalo("De").moverA(this.recogerColumna("A"));
                break;
            case 5:
                this.recogerColumna("De").moverA(this.recogerPalo("A"));
                break;
            case 6:
                this.recogerColumna("De").moverA(this.recogerColumna("A"));
                break;
            case 7:
                this.recogerColumna("De").voltear();
                break;
            case 8:
                descarte.voltear(baraja);
                break;
            case 9:
                break;
            }
        } while (opcion != 9);
    }
    
    private Palo recogerPalo(String prefijo){
        GestorIO gestorIO = new GestorIO();
        int palo;
        boolean error;
        do {
            gestorIO.out("�" + prefijo + " qu� palo? [1-"+ Baraja.NUM_PALOS + "]: ");
            palo = gestorIO.inInt();
            error = !new Intervalo(1,Baraja.NUM_PALOS).incluye(palo);
            if (error){
                gestorIO.out("Error!!! Debe ser un n�mero entre 1 y "+ Baraja.NUM_PALOS);
            }
        } while(error);
        return palos[palo-1];
    }
    
    private Columna recogerColumna(String prefijo){
        GestorIO gestorIO = new GestorIO();
        int columna;
        boolean error;
        do {
            gestorIO.out("�" + prefijo + " qu� columna? [1-"+ NUM_COLUMNAS + "]: ");
            columna = gestorIO.inInt();
            error = !new Intervalo(1,NUM_COLUMNAS).incluye(columna);
            if (error){
                gestorIO.out("Error!!! Debe ser un n�mero entre 1 y "+ NUM_COLUMNAS);
            }
        } while(error);
        return columnas[columna-1];
    }

    private void mostrar() {
        baraja.mostrar();
        descarte.mostrar();
        for (Palo palo : palos) {
            palo.mostrar();
        }
        for (Columna columna : columnas) {
            columna.mostrar();
        }
    }

    public static void main(String[] args) {
        new Klondike().jugar();
    }
}
