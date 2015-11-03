package rmi;

/**
 *
 * @author Danilo
 */
public class PhoneBookEntry  implements java.io.Serializable {

    private int id;
    private String nome;
    private String sobrenome;
    private String telefone;

    public PhoneBookEntry() {
    }
    
    public PhoneBookEntry(String nome, String sobrenome, String telefone){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }
    
    public PhoneBookEntry(int id, String nome, String sobrenome, String telefone){
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "PhoneBookEntry{" + "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + '}';
    }
    
    

}
