package lp2g03.biblioteca;

import java.io.Serializable;
import java.util.*;

public class EmprestPara implements Serializable{
    private GregorianCalendar dataEmprestimo;
    private GregorianCalendar dataDevolucao;

    private String codigoUsuario;

    public EmprestPara(String codigo, GregorianCalendar dataEmprestimo, GregorianCalendar dataDevolucao){
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.codigoUsuario = codigo;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public void setDataDevolv(){
        // Usar isso pra alterar a data de devolução
        this.dataDevolucao = new GregorianCalendar();
    }


    public String toString(){
        if(dataDevolucao == null){
            return "\ncodigo do usuario: " + getCodigoUsuario() + "\nData de emprestimo: " + dataEmprestimo.get(Calendar.DAY_OF_MONTH) + '\\' + (dataEmprestimo.get(Calendar.MONTH)  + 1) + '\\' + dataEmprestimo.get(Calendar.YEAR) + 
            "\nData de devolucao: ainda não foi devolvido";
        }
        else{
            return "\ncodigo do usuario: " + getCodigoUsuario() + "\nData de emprestimo: " + dataEmprestimo.get(Calendar.DAY_OF_MONTH) + '\\' + (dataEmprestimo.get(Calendar.MONTH)  + 1) + '\\' + dataEmprestimo.get(Calendar.YEAR) + 
            "\nData de devolucao: " + dataDevolucao.get(Calendar.DAY_OF_MONTH) + '\\' + (dataEmprestimo.get(Calendar.MONTH)  + 1) + '\\' + dataDevolucao.get(Calendar.YEAR);
        }
    }
}
