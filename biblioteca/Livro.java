package lp2g03.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Livro implements Serializable{
    private String codigoLivro;
    private String TituloLivro;
    private String categoria;
    private int quantidade;
    private int emprestados;
    private ArrayList<EmprestPara> hist;


    public Livro(String codigoLivro, String tituto, String cat, int quant,int emprestados,ArrayList<EmprestPara> hist){
        this.codigoLivro = codigoLivro;
        this.TituloLivro = tituto;
        this.categoria = cat;
        this.quantidade = quant;
        this.emprestados = emprestados;
        this.hist = hist;
    }

    public ArrayList<EmprestPara> getHist() {
        return hist;
    }

    public String getCodigoLivro() {
        return codigoLivro;
    }

    public String getTituloLivro() {
        return TituloLivro;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getEmprestados() {
        return emprestados;
    }

    public void empresta() throws CopiaNaoDisponivelEx{

        if(quantidade == emprestados){
            throw new CopiaNaoDisponivelEx();
        }
        emprestados++;
    }

    public void devolve() throws NenhumaCopiaEmprestadaEx{
        try{
            if(emprestados == 0){
                throw new NenhumaCopiaEmprestadaEx();
            }
            emprestados --;
        }
        catch(NenhumaCopiaEmprestadaEx e){
            System.out.println(e);
        }
        // devolve, que não recebe parâmetros e acerta o campo Emprestados. Caso nenhuma
        // cópia tenha sido emprestada, deve levantar a exceção NenhumaCopiaEmprestadaEx.
    }

    public void addUsuarioHist(String codigo, GregorianCalendar cal){
        hist.add(new EmprestPara(codigo,  cal, null));
    }
    
    public String toString(){
        return "\nCodigo: " + getCodigoLivro() + "\nTituloLivro: " + getTituloLivro() + "\ncategoria: " + getCategoria() + "\nQuantidade: " + getQuantidade() + "\nEmprestado: " + getEmprestados();
    }

    public String imprimeHist(){
        String aux = "";
        for(int c = 0; c < hist.size(); c++){
            aux += hist.get(c).toString();
        }
        return aux;
    }
}
