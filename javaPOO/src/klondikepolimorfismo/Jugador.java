package klondikepolimorfismo;

abstract class Jugador {
    
    protected char color;
    
    protected Tablero tablero;
    
    protected Jugador(char color, Tablero tablero){
        assert color == 'o' || color == 'x';
        assert tablero != null;
        this.color = color;
        this.tablero = tablero;
    }
    
    public char color() {
        return color;
    }
    
    public void ponerFicha() {
        assert !tablero.estaCompleto(this.color());
        this.ponerFicha(null);
    }
    
    protected void ponerFicha(CoordenadaTresEnRaya coordenadaProhibida) {
        if (coordenadaProhibida==null){
            new GestorIO().out("Pone el jugador con " + color + "\n");
        }
        tablero.ponerFicha(this.recogerCoordenadaPuestaValida(coordenadaProhibida), color);
    }
    
    protected abstract CoordenadaTresEnRaya recogerCoordenadaPuestaValida(CoordenadaTresEnRaya coordenadaProhibida);
    
    public void moverFicha() {
        assert tablero.estaCompleto(this.color());
        new GestorIO().out("Mueve el jugador con " + color + "\n");
        CoordenadaTresEnRaya retirada = this.recogerCoordenadaRetiradaValida();
        tablero.retirarFicha(retirada);
        this.ponerFicha(retirada);
    }
    
    protected abstract CoordenadaTresEnRaya recogerCoordenadaRetiradaValida();

    public void cantaVictoria() {
        new GestorIO().out("eoeoeoeoeoeoeoeoe! los " + color + " son lo mejores\n");
    }
    
}
