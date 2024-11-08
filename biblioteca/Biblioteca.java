package lp2g03.biblioteca;

import java.io.*;

import java.util.*;

public class Biblioteca implements Serializable{
    private Hashtable<String, Usuario> cadUsuarios;
    private Hashtable<String, Livro> cadLivros;

    public Biblioteca(){
        this.cadUsuarios = new Hashtable<String, Usuario>();
        this.cadLivros = new Hashtable<String, Livro>();
    }

    public Biblioteca(String cad1, String cad2){
        try {
            // Lendo os usuarios
            ObjectInputStream in1 = new ObjectInputStream(new FileInputStream(cad1));
            cadUsuarios = (Hashtable<String, Usuario>) in1.readObject();
            in1.close();
    
            // Lendo os livros
            ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(cad2));
            cadLivros = (Hashtable<String, Livro>) in2.readObject();
            in2.close();
        } catch (Exception e) {
            System.out.println("\nNão foi possível recuperar os dados.\n");
        }
    }

    public void cadastraUsuario(Usuario us)
    {
        cadUsuarios.put(us.getCodigoUsuario() + "", us);
    }

    public void cadastraLivro(Livro li)
    {
        String aux = (cadLivros.size() + 1) + "";
        cadLivros.put(li.getCodigoLivro() + "", li);
    }

    public void salvaArquivo(Hashtable conteudo, String nomeArqu){
        //Escrever nos objetos
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArqu));
            out.writeObject(conteudo);
            out.close();
        }
        catch (Exception  e){
            System.out.println("Não foi possivel salvar os dados.");
            e.printStackTrace();
        }
    }

    public void leArquivo(String nomeArqu, int n){
        try{
            // Lendo os usuarios
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArqu));
            
            if(n == 0){
                cadUsuarios = (Hashtable)in.readObject();
            }
            else{
                cadLivros = (Hashtable)in.readObject();
            }
            in.close();
            
        }
        catch (Exception  e){
            System.out.println("Não foi possivel recuperar os dados.");
        }
    }

    // Metodos get
    public Hashtable<String, Usuario> getCadUsuarios() {
        return cadUsuarios;
    }
    
    public Hashtable<String, Livro> getCadLivros() {
        return cadLivros;
    }
    
    public Livro getLivro(String cod) throws LivroNaoCadastradoEx{

            if(cadLivros.get(cod) == null){
                throw new LivroNaoCadastradoEx();
            }
        return cadLivros.get(cod);
    }

    public Usuario getUsuario(String cod) throws UsuárioNaoCadastradoEx{
        if(cadUsuarios.get(cod) == null){
            throw new UsuárioNaoCadastradoEx();
        }
        return cadUsuarios.get(cod);
        
    }

    public void emprestaLivro(Usuario us, Livro li){
        try{
            li.empresta();
            us.addLivroHist(li.getCodigoLivro(), new GregorianCalendar());
            li.addUsuarioHist(us.getCodigoUsuario(), new GregorianCalendar());
            System.out.println("\nLivro emprestado\n");
        }
        catch(CopiaNaoDisponivelEx e){
            System.out.println(e);
        }
    }

    public void devolveLivro(Usuario us, Livro li){
        try{
            li.devolve();
            for(int c = 0; c < us.getHist().size(); c++){
                if(us.getHist().get(c).getCodigoLivro().equals(li.getCodigoLivro())){
                    us.getHist().get(c).setDataDevolv();
                }
            }
            for(int c = 0; c < li.getHist().size(); c++){
                if(li.getHist().get(c).getCodigoUsuario().equals(us.getCodigoUsuario())){
                    li.getHist().get(c).setDataDevolv();
                }
            }
        }
        catch(NenhumaCopiaEmprestadaEx e){
            System.out.println(e);
        }
    }

    public Comparator<Usuario> usuarioc = new Comparator<Usuario>() {
        public int compare (Usuario p1, Usuario p2){ // recebe PessoaIMC como Object
            String s1, s2;
            s1 = p1.get_nome();
            s2 = p2.get_nome();

            return (s1.compareToIgnoreCase(s2));
        }
    };

    public Comparator<Livro> livroc = new Comparator<Livro>() {
        public int compare (Livro p1, Livro p2){ // recebe PessoaIMC como Object
            String s1, s2;
            s1 = p1.getTituloLivro();
            s2 = p2.getTituloLivro();

            return (s1.compareToIgnoreCase(s2));
        }
    };

    // Imprimi livros e usuarios
    public String imprimeUsuarios(){
        ArrayList<Usuario> valoresOrdenados = new ArrayList<>(cadUsuarios.values());
        Collections.sort(valoresOrdenados, usuarioc);
        String aux = "";

        for (Usuario valor : valoresOrdenados) {
            aux +=  "\n" + valor.toString();
        }
        return aux;
    }

    public String imprimeLivros(){
        ArrayList<Livro> valoresOrdenados = new ArrayList<>(cadLivros.values());
        Collections.sort(valoresOrdenados, livroc);
        String aux = "";

        for (Livro valor : valoresOrdenados) {
            aux +=  "\n" + valor.toString();
        }
        return aux;
    }
}