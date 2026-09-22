public enum Cor {

    VERMELHO("Vermelho"), AZUL("Azul"), 
    VERDE("Verde"), BRANCO("Branco"), 
    PRETO( "Preto"), AMARELO("Amarelo");

    private String tipoCor;

    Cor(String tipoCor){
        this.tipoCor = tipoCor;
    }


    public String getTipoCor(){
        return this.tipoCor;
    }
    
}
