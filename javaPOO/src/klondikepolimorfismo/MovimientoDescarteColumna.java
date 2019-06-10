package klondikepolimorfismo;

class MovimientoDescarteColumna extends MovimientoOrigenDestino {

    protected MovimientoDescarteColumna(Tapete tapete) {
        super("Mover de descarte a columna", tapete);
    }

    @Override
    public void ejecutar() {
        origen = tapete.getDescarte();
        destino = tapete.getColumna(this.recoger("A qu� columna", Tapete.NUM_COLUMNAS));
        super.ejecutar();
    }
   
}
