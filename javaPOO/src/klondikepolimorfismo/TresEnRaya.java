// Timothy Budd

package klondikepolimorfismo;

class TresEnRaya {

    private Tablero tablero;
    private Jugador[] jugadores;
    private Turno turno;
    
    private static final int NUM_JUGADORES = 2;
    
    public TresEnRaya(int jugadoresManuales){
        assert new Intervalo(0,NUM_JUGADORES).incluye(jugadoresManuales);
        tablero = new Tablero();
        jugadores = new Jugador[NUM_JUGADORES];
        final char[] COLORES = new char[] {'o', 'x'};
        for(int i=0; i<jugadoresManuales; i++){
            jugadores[i] = new JugadorManual(COLORES[i], tablero);
        }
        for(int i=0; i+jugadoresManuales<NUM_JUGADORES; i++){
            jugadores[i+jugadoresManuales] = new JugadorAutomatico(COLORES[i+jugadoresManuales], tablero);
        }
        turno = new Turno();
    }
    
    public void jugar(){
        tablero.mostrar();
        do {
            if (!tablero.estaCompleto(jugadores[turno.toca()].color())) {
                jugadores[turno.toca()].ponerFicha();
            } else {
                jugadores[turno.toca()].moverFicha();
            }
            tablero.mostrar();
            turno.cambiar();
        } while (!tablero.hayTresEnRaya());
        jugadores[turno.noToca()].cantaVictoria();
    }
    
    public static void main(String[] args){
        new TresEnRaya(Integer.parseInt(args[0])).jugar();
    }
}
