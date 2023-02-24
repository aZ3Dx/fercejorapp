package lat.fercejor.fercejorapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Encryptor implements CommandLineRunner {

    @Autowired
    private SecurityBeans securityBeans;

    @Override
    public void run(String... args) throws Exception {
        System.out.print("dev2023 -> ");
        System.out.println(securityBeans.passwordEncoder().encode("admin2023"));
        System.out.print("cliente2023 -> ");
        System.out.println(securityBeans.passwordEncoder().encode("cliente2023"));
    }
    
}
