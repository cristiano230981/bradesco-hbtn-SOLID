public class Error {

    // ✅ Usa exceção para sinalizar erro e evita null/códigos
    public User createUser(User user) {
        try {
            loadUser(user.getId());
            throw new UserExistsException(user.getId());
        } catch (UserNotFoundException exception) {
            // Usuário não existe, pode ser criado
        }

        resolveGroup(user);
        return userRepository.save(user);
    }

    // ✅ Exceção com contexto claro
    public void validate(String id) {
        if (ownerRepo.count(id) == 0) {
            throw new ValidationException("id: " + id + " não foi informado, deveria ser informado...");
        }
    }

    // Simulações de dependências (para compilar)
    private User loadUser(String id) throws UserNotFoundException {
        // lógica simulada
        throw new UserNotFoundException(id);
    }

    private void resolveGroup(User user) {
        // lógica simulada
    }

    private UserRepository userRepository = new UserRepository();
    private OwnerRepo ownerRepo = new OwnerRepo();

    // Classes simuladas
    public static class User {
        private String id;
        public String getId() { return id; }
    }

    public static class UserRepository {
        public User save(User user) { return user; }
    }

    public static class OwnerRepo {
        public int count(String id) { return 0; }
    }

    public static class UserExistsException extends RuntimeException {
        public UserExistsException(String id) {
            super("Usuário com ID " + id + " já existe.");
        }
    }

    public static class UserNotFoundException extends Exception {
        public UserNotFoundException(String id) {
            super("Usuário com ID " + id + " não encontrado.");
        }
    }

    public static class ValidationException extends RuntimeException {
        public ValidationException(String message) {
            super(message);
        }
    }
}