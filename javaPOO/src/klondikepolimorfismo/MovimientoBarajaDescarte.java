package klondikepolimorfismo;

class MovimientoBarajaDescarte extends OpcionKlondike {

    public MovimientoBarajaDescarte(Tapete tapete){
        super("Mover de baraja a descarte", tapete);
    }
    
    @Override
    public void ejecutar(){
        if (tapete.getBaraja().vacia()) {
            this.error("No hay cartas en baraja");
        } else {
            int contador = 3;
            while (contador > 0 && !tapete.getBaraja().vacia()) {
                Carta carta = tapete.getBaraja().sacar();
                carta.voltear();
                tapete.getDescarte().poner(carta);
                contador--;
            }
        }
    }
    
}
