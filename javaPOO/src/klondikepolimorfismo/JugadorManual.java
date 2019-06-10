package klondikepolimorfismo;

class JugadorManual extends Jugador {

    public JugadorManual(char color, Tablero tablero) {
        super(color, tablero);
        assert color == 'x' || color == 'o';
    }

    @Override
    protected CoordenadaTresEnRaya recogerCoordenadaPuestaValida(CoordenadaTresEnRaya coordenadaProhibida) {
        CoordenadaTresEnRaya resultado = new CoordenadaTresEnRaya();
        String error = "";
        do {
            resultado.recoger();
            error = this.errorPuesta(resultado, coordenadaProhibida);
            if (!error.equals("")) {
                new GestorIO().out("Error!!! " + error + "\n");
            }
        } while (!error.equals(""));
        return resultado;
    }

    private String errorPuesta(CoordenadaTresEnRaya coordenada, CoordenadaTresEnRaya coordenadaProhibida) {
        if (tablero.ocupada(coordenada)) {
            return "Coordenada ocupada en el tablero";
        }
        if (coordenadaProhibida != null && coordenadaProhibida.igual(coordenada)) {
            return "No se puede poner de donde se quit� la ficha";
        }
        return "";
    }

    @Override
    protected CoordenadaTresEnRaya recogerCoordenadaRetiradaValida() {
        CoordenadaTresEnRaya resultado = new CoordenadaTresEnRaya();
        String error = "";
        do {
            resultado.recoger();
            error = this.errorRetirada(resultado);
            if (!error.equals("")) {
                new GestorIO().out("Error!!! " + error + "\n");
            }
        } while (!error.equals(""));
        return resultado;
    }
    
    private String errorRetirada(CoordenadaTresEnRaya coordenada) {
        if (!tablero.ocupada(coordenada, color)) {
            return "Coordenada no ocupada en el tablero por una ficha " + color;
        }
        return "";
    }
    
    public static void main(String[] args){
        Tablero tablero = new Tablero();
        JugadorManual jugador = new JugadorManual('o', tablero);
        jugador.cantaVictoria();
        for (int i = 0; i < 3; i++) {
            jugador.ponerFicha();
            tablero.mostrar();
        }
        for (int i = 0; i < 3; i++) {
            jugador.moverFicha();
            tablero.mostrar();
        }
    }

}
