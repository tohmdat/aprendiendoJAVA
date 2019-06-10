package klondikepolimorfismo;

class MovimientoColumnaPalo extends MovimientoOrigenDestino {

    protected MovimientoColumnaPalo(Tapete tapete) {
        super("Mover de columna a palo", tapete);
    }

    @Override
    public void ejecutar() {
        origen = tapete.getColumna(this.recoger("De qu� columna", Tapete.NUM_COLUMNAS));
        destino = tapete.getPalo(this.recoger("A qu� palo", Baraja.NUM_PALOS));
        super.ejecutar();
    }
    
 }
