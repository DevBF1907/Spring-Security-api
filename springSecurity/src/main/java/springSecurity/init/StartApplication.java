package springSecurity.init;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import springSecurity.model.User;
import springSecurity.repository.UserRepository;

@Component
public class StartApplication implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(String... args) {

        User user = repository.findByUsername("admin");
        if (user == null) {
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.getRoles().add("MANAGERS");
        }

        if (user.getPassword() == null || !user.getPassword().startsWith("$2")) {
            user.setPassword(passwordEncoder.encode("master123"));
        }
        repository.save(user);

        user = repository.findByUsername("user");
        if (user == null) {
            user = new User();
            user.setName("USER");
            user.setUsername("user");
            user.getRoles().add("USERS");
        }

        if (user.getPassword() == null || !user.getPassword().startsWith("$2")) {
            user.setPassword(passwordEncoder.encode("user123"));
        }
        repository.save(user);
    }
}
