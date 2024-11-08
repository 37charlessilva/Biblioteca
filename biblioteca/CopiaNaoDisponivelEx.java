package lp2g03.biblioteca;

public class CopiaNaoDisponivelEx extends Exception{

    public CopiaNaoDisponivelEx(){
    }

    public String toString(){
        return "Todos as copias fora emprestadas.";
    }
}
