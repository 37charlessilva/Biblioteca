package lp2g03.biblioteca;

public class LivroNaoCadastradoEx extends Exception{
    public LivroNaoCadastradoEx(){
    }

    public String toString(){
        return "Livro não encontrado";
    }
}
