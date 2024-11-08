package lp2g03.biblioteca;

import java.util.*;

public class Usuario extends Pessoa{

    private String codigoUsuario;
    private String endereco;
    private ArrayList<Emprest> hist; // classe Emprest

    public Usuario(String codigoUsuario, String nome, String sobreN, int dia, int mes, int ano, String endereco, ArrayList<Emprest> hist){
        super(nome, sobreN, dia, mes, ano);
        this.codigoUsuario = codigoUsuario;
        this.endereco = endereco;
        this.hist = hist;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public ArrayList<Emprest> getHist() {
        return hist;
    }

    // Adicionar um livro ao historico
    public void addLivroHist(String codigo, GregorianCalendar cal){
        Emprest livro = new Emprest(codigo, cal, null);
        hist.add(livro);
    }

    public String toString(){
        return "\nCodigo: " + getCodigoUsuario() + "" + super.toString();
    }

    public String imprimeHist(){
        String aux = "";
        for(int c = 0; c < hist.size(); c++){
            aux += hist.get(c).toString();
        }
        return aux;
    }
}