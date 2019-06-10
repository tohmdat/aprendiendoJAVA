package klondikesinherencia;


class Carta {
    
    private int palo;
    
    private int numero;
    
    private boolean bocaArriba;
    
    private static final String[] PALOS = {"Picas", "Treboles", "Diamantes", "Corazones"};
    
    private static final Intervalo NEGROS = new Intervalo(0,1);
    
    private static final Intervalo ROJOS = new Intervalo(2,3);
    
    private static final String[] NUMEROS = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 

    public Carta(int palo, int numero) {
        assert new Intervalo(0,Baraja.NUM_PALOS-1).incluye(palo);
        assert new Intervalo(0,Baraja.NUM_NUMEROS-1).incluye(numero);
        this.palo = palo;
        this.numero = numero;
        bocaArriba = false;
    }
    
    public boolean bocaArriba() {
        return bocaArriba;
    }
    
    public void voltear() {
        bocaArriba = !bocaArriba;        
    }

    public boolean esAs() {
        return numero == 0;
    }
    
    public boolean esRey() {
        return numero == 12;
    } 

    public boolean siguiente(Carta carta) {
        return numero == carta.numero+1;
    }

    public boolean igualPalo(Carta carta) {
        return palo == carta.palo;
    }

    public boolean distintoColor(Carta carta) {
        return this.rojo() && carta.negro() ||
                this.negro() && carta.rojo();
    }  
    
    private boolean rojo() {
        return ROJOS.incluye(palo);
    }
    
    private boolean negro() {
        return NEGROS.incluye(palo);
    }

    public void mostrar() {
        String numero = "???";
        String palo= "???";
        if (this.bocaArriba()){
            numero = NUMEROS[this.numero];
            palo = PALOS[this.palo];
        }
        new GestorIO().out("(" + numero + " de " + palo + ")");       
    }
    
    public static void main(String[] args){
        GestorIO gestorIO = new GestorIO();
        Carta[] cartas = new Carta[]{
                new Carta(0,0),
                new Carta(2,10),
                new Carta(1,7),
                new Carta(3,1),
                new Carta(1,11),
                new Carta(2,4),
                new Carta(3,12)
        };
        for (Carta carta : cartas) {
            carta.mostrar();
            carta.voltear();
            carta.mostrar();
            gestorIO.out("\nEs as? " +carta.esAs());
            gestorIO.out("\nEs rey? " +carta.esRey());
            gestorIO.out("\nEs rojo? " +carta.rojo());
            gestorIO.out("\nEs negro? " +carta.negro());
            gestorIO.out("\n");
        }
        Carta[][] paresCartas = new Carta[][]{
                { new Carta(1,0), new Carta(0,0)},
                { new Carta(1,1), new Carta(0,0)},
                { new Carta(3,7), new Carta(0,12)},
                { new Carta(2,2), new Carta(2,2)},
                { new Carta(0,5), new Carta(0,6)},
                { new Carta(1,12), new Carta(1,0)},
                { new Carta(2,0), new Carta(2,12)},
                { new Carta(0,9), new Carta(3,3)}
        };
        for (Carta[] parCartas : paresCartas) {
            parCartas[0].voltear();
            parCartas[0].mostrar();
            gestorIO.out(" y ");
            parCartas[1].voltear();
            parCartas[1].mostrar();
            gestorIO.out("\nSon siguientes? " + parCartas[0].siguiente(parCartas[1]));
            gestorIO.out("\nSon de igual palo? " + parCartas[0].igualPalo(parCartas[1]));
            gestorIO.out("\nSon de distinto color? " + parCartas[0].distintoColor(parCartas[1]));
            gestorIO.out("\n");
        }
        
        
        
        
    }

}

