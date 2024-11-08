package lp2g03.biblioteca;

import java.io.Serializable;
import java.util.*;

public class Emprest implements Serializable{
    private GregorianCalendar dataEmprestimo;
    private GregorianCalendar dataDevolucao;

    private String codigoLivro;

    public Emprest(String codigo, GregorianCalendar dataEmprestimo, GregorianCalendar dataDevolucao){
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.codigoLivro = codigo;
    }

    public void setDataDevolv(){
        // Arqui provalvelmente eu mudo
        this.dataDevolucao = new GregorianCalendar();
    }

    public GregorianCalendar getDataEmprestimo() {
        return dataEmprestimo;
    }

    public GregorianCalendar getDataDevolucao() {
        return dataDevolucao;
    }
    
    public String getCodigoLivro() {
        return codigoLivro;
    }
    
    public String toString(){
        if(dataDevolucao == null){
            return "\nCodigo do livro: " + getCodigoLivro() + "\nData de emprestimo: " + dataEmprestimo.get(Calendar.DAY_OF_MONTH) + '\\' + (dataEmprestimo.get(Calendar.MONTH)  + 1) + '\\' + dataEmprestimo.get(Calendar.YEAR) + 
            "\nData de devolucao: ainda não foi devolvido";
        }
        else{
            return "\nCodigo do livro: " + getCodigoLivro() + "\nData de emprestimo: " + dataEmprestimo.get(Calendar.DAY_OF_MONTH) + '\\' + (dataEmprestimo.get(Calendar.MONTH) + 1) + '\\' + dataEmprestimo.get(Calendar.YEAR) + 
            "\nData de devolucao: " + dataDevolucao.get(Calendar.DAY_OF_MONTH) + '\\' + (dataEmprestimo.get(Calendar.MONTH)  + 1) + '\\' + dataDevolucao.get(Calendar.YEAR);
        }
    }
}
