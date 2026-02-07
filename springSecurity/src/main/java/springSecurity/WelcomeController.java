package springSecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/")
    public String publicEndpoint() {
        return "Endpoint público — qualquer um acessa";
    }


    @GetMapping("/users")
    public String usersEndpoint() {
        return "Endpoint USERS — usuário autenticado";
    }

    @GetMapping("/managers")
    public String managersEndpoint() {
        return "Endpoint MANAGERS — acesso restrito";
    }
}
