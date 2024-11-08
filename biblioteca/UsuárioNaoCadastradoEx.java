package lp2g03.biblioteca;

public class UsuárioNaoCadastradoEx extends Exception{
    public UsuárioNaoCadastradoEx(){
    }

    public String toString(){
        return "Usuario não encontrado";
    }
}
