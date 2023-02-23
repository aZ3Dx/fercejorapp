package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Cuenta;

public interface CuentaServiceAPI {

    List<Cuenta> obtenerTodasLasCuentas();
    Optional<Cuenta> obtenerCuentaPorId(Long id);
    Cuenta crearCuenta(Cuenta cuenta);
    void eliminarCuenta(Long id);
    Cuenta actualizarCuenta(Cuenta cuenta);

    Cuenta obtenerCuentaPorUsuario(String usuario);
    
}
