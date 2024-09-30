package model;
public enum EnumMoeda {
    BRL("Real brasileiro"),
    USD("Dolar americano"),
    EUR("Euro"),
    ARS("Peso argentino"),
    BOB("Boliviano"),
    CLP("Peso chileno"),
    COP("Peso colombiano");

    private String tittle;

    EnumMoeda(String tittle) {
        this.tittle = tittle;
    }

    public String getTitle() {
        return this.tittle;
    }

    public static void mostrar() {
        System.out.println("**************************************");
        for (EnumMoeda enumMoeda : EnumMoeda.values()) {
            System.out.println(enumMoeda.ordinal() + 1 + " - " + enumMoeda + " " + enumMoeda.getTitle());
        }
        System.out.println("**************************************");
    }
}
