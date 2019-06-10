package klondikepolimorfismo;

class MovimeintoDescarteBaraja extends MovimientoOrigenDestino {

    MovimeintoDescarteBaraja(Tapete tapete){
        super("Mover de descarte a baraja", tapete);
    }
    
    @Override
    public void ejecutar() {
        if (tapete.getBaraja().vacia()){
            this.error("La baraja no est� vac�a");
        } else  {
            origen = tapete.getDescarte();
            destino = tapete.getBaraja();
            while (!origen.vacia()){
                super.ejecutar();
            }
        }
    }

}
