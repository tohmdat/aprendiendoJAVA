package klondikepolimorfismo;

class Tapete {

    private Mazo[] mazos;
    
    public static final int NUM_COLUMNAS = 7;

    public Tapete() {
        mazos = new Mazo[13];
        mazos[0] = new Baraja();
        ;
        mazos[1] = new Descarte();
        for (int i = 0; i < Baraja.NUM_PALOS; i++) {
            mazos[i + 2] = new Palo();
        }
        for (int i = 0; i < NUM_COLUMNAS; i++) {
            mazos[i + 6] = new Columna(i + 1, this.getBaraja());
        }
    }
    
    public Baraja getBaraja(){
        return (Baraja) mazos[0];
    }

    public Descarte getDescarte(){
        return (Descarte) mazos[1];
    }
    
    public Palo getPalo(int posicion){
        return (Palo) mazos[posicion+2];
    }
    
    public Columna getColumna(int posicion){
        return (Columna) mazos[posicion+6];
    }

    public void mostrar() {
        for (Mazo mazo : mazos) {
            mazo.mostrar();
        }
    }
}
