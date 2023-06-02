import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario
{
    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }
    
    public Usuario(int id, String nome, String email, String senha)
    {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario(String nome, String email, String senha)
    {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    // private List<Jogo> biblioteca = new ArrayList<>();
    // private List<Avaliacao> avaliacoes = new ArrayList<>();

    // public void adicionaAvaliacao(Avaliacao a)
    // {
    //     this.avaliacoes.add(a);
    // }

    // public List<Avaliacao> getAvaliacoes() {
    //     return this.avaliacoes;
    // }

    // public void setAvaliacoes(List<Avaliacao> avaliacoes) {
    //     this.avaliacoes = avaliacoes;
    // }

    // public List<Jogo> getBiblioteca() {
    //     return this.biblioteca;
    // }

    // public void setBiblioteca(List<Jogo> biblioteca) {
    //     this.biblioteca = biblioteca;
    // }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Usuario other = (Usuario) obj;
        return this.email == other.email && Objects.equals(this.senha, other.senha);
    }
}
