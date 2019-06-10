// Timothy Budd

package klondikeconherencia;

class TresEnRaya {

    private Tablero tablero;
    private Jugador[] jugadores;
    private Turno turno;
    
    public TresEnRaya(){
        tablero = new Tablero();
        jugadores = new Jugador[2];
        jugadores[0] = new Jugador('x', tablero);
        jugadores[1] = new Jugador('o', tablero);
        turno = new Turno();
    }
    
    public void jugar(){
        do {
            tablero.mostrar();
            if (!tablero.estaCompleto(jugadores[turno.toca()])) {
                jugadores[turno.toca()].ponerFicha(tablero);
            } else {
                jugadores[turno.toca()].moverFicha(tablero);
            }
            turno.cambiar();
        } while (!tablero.hayTresEnRaya());
        jugadores[turno.noToca()].cantaVictoria();
    }
    
    public static void main(String[] args){
        new TresEnRaya().jugar();
    }
}
