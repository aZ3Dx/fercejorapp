package lat.fercejor.fercejorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.model.Cargo;
import lat.fercejor.fercejorapp.model.Cuenta;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CuentaService cuentaService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cuenta cuenta = cuentaService.obtenerCuentaPorUsuario(username);
        if(cuenta == null) {
            throw new UsernameNotFoundException("Cuenta no encontrada");
        }
        Cargo cargo = cuenta.getCargo();
        String nombreCargo = cargo.getNombreCargo();
        System.out.println("Cargo: " + nombreCargo);
        GrantedAuthority authority = new SimpleGrantedAuthority(nombreCargo);
        List<GrantedAuthority> authorities = List.of(authority);
        return User.builder()
                .username(cuenta.getUsuario())
                .password(cuenta.getClave())
                .authorities(authorities)
                .build();
    }
    
}
