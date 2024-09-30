public enum EnumMoeda {
    BRL("Real brasileiro"), 
    USD("Dolar americano"), 
    EUR("Euro"), 
    ARS("Peso argentino"), 
    BOB("Boliviano"), 
    CLP("Peso chileno"), 
    COP("Peso colombiano"), 
    TOP("Paanga"), 
    SSP("Somão");

    private String nome;

    EnumMoeda(String nome) {
        this.nome = nome;
    }

    public String getTitle() {
        return this.nome;
    }

    public static void mostrar(){

        for (EnumMoeda enumMoeda : EnumMoeda.values()) {
            System.out.println(enumMoeda.ordinal()+1 +" - "+ enumMoeda + " " + enumMoeda.getTitle());
        }
    }
}
