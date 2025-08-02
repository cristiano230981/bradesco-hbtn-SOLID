import java.util.List;
import java.util.ArrayList;

public class UserModel {

    private int idUser;
    private String descricao;

    public static final int IDADE_MINIMA = 18;

    // Método que retorna todos os usuários
    public List<UserModel> fetchUsers() {
        return new ArrayList<>();
    }

    // Alternativas com nomes consistentes
    public List<UserModel> getAllUsers() {
        return new ArrayList<>();
    }

    public List<UserModel> retrieveUsers() {
        return new ArrayList<>();
    }

    // Getters e setters (opcional)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}