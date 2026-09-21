public enum Cor {

    VERMELHO(1, "Vermelho"), AZUL(2, "Azul"), 
    VERDE(3, "Verde"), BRANCO(4, "Branco"), 
    PRETO(5, "Preto"), AMARELO(6, "Amarelo");

    private int numCor;
    private String tipoCor;

    Cor(int numCor, String tipoCor){
        this.numCor = numCor;
        this.tipoCor = tipoCor;
    }

    public int getNumCor(){
        return this.numCor;
    }

    public String getTipoCor(){
        return this.tipoCor;
    }
    
}
