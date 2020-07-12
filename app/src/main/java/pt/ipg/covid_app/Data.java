package pt.ipg.covid_app;

public class Data {

    String nome;
    String tele;
    String morada;
    String idade;
    String genero;
    String viajar;
    String asma;
    String sintomas;
    String resultado;

    public Data(){

    }

    //criar tabela

    public static final String CREATE_TABLE=
            "CREATE TABLE " + "Questionario" + "("+
                    "Nome" + " TexT, " +
                    "Tele" + " TexT, " +
                    "Morada" + " TexT, " +
                    "Idade" + " TexT, " +
                    "Genero" + " TexT, " +
                    "viajar" + " TexT, " +
                    "asma" + " TexT, " +
                    "sintomas" + " TexT, " +
                    "resultado" + " TexT, " +  ")";

    public Data(String nome, String tele, String morada, String idade, String genero, String viajar, String asma, String sintomas, String resultado) {

        this.nome = nome;
        this.tele = tele;
        this.morada = morada;
        this.idade = idade;
        this.genero = genero;
        this.viajar = viajar;
        this.asma = asma;
        this.sintomas = sintomas;
        this.resultado = resultado;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getViajar() {
        return viajar;
    }

    public void setViajar(String viajar) {
        this.viajar = viajar;
    }

    public String getAsma() {
        return asma;
    }

    public void setAsma(String asma) {
        this.asma = asma;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
