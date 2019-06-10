package klondikepolimorfismo;

import java.util.Random;

class JugadorAutomatico extends Jugador {

    protected JugadorAutomatico(char color, Tablero tablero) {
        super(color, tablero);
    }

    @Override
    protected CoordenadaTresEnRaya recogerCoordenadaPuestaValida(CoordenadaTresEnRaya coordenadaProhibida) {
        CoordenadaTresEnRaya resultado;
        Random aleatorio = new Random();
        do {
            resultado = new CoordenadaTresEnRaya(aleatorio.nextInt(3)+1, aleatorio.nextInt(3)+1);            
        } while (tablero.ocupada(resultado) || 
                coordenadaProhibida != null && resultado.igual(coordenadaProhibida));
        return resultado;
    }

    @Override
    protected CoordenadaTresEnRaya recogerCoordenadaRetiradaValida() {
        CoordenadaTresEnRaya resultado;
        Random aleatorio = new Random();
        do {
            resultado = new CoordenadaTresEnRaya(aleatorio.nextInt(Tablero.DIMENSION)+1, aleatorio.nextInt(Tablero.DIMENSION)+1);            
        } while (!tablero.ocupada(resultado, color));
        return resultado;
    }

}
