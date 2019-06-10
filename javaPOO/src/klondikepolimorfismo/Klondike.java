package klondikepolimorfismo;

class Klondike {
    
    private Tapete tapete;    
    
    private Menu menu;
    
    private Klondike() {
        tapete = new Tapete();
        menu = new Menu();
        menu.añadir(new MovimientoBarajaDescarte(tapete));
        menu.añadir(new MovimientoDescartePalo(tapete));
        menu.añadir(new MovimientoDescarteColumna(tapete));
        menu.añadir(new MovimientoPaloColumna(tapete));
        menu.añadir(new MovimientoColumnaPalo(tapete));
        menu.añadir(new MovimientoColumnaColumna(tapete));
        menu.añadir(new VolteoEnColumna(tapete));
        menu.añadir(new MovimeintoDescarteBaraja(tapete));
        menu.cerrar();
    }
    
    private void jugar() {
        do {
            tapete.mostrar();
            menu.mostrar();
            menu.getOpcion().ejecutar();
        } while (!menu.terminado());
    }
    
    public static void main(String[] args) {
        new Klondike().jugar();
    }
}