package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.CuentaServiceAPI;
import lat.fercejor.fercejorapp.model.Cuenta;
import lat.fercejor.fercejorapp.repository.CuentaRepository;

@Service
public class CuentaService implements CuentaServiceAPI {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> obtenerTodasLasCuentas() {
        List<Cuenta> cuentas = cuentaRepository.findAll();
        return cuentas;
    }

    @Override
    public Optional<Cuenta> obtenerCuentaPorId(Long id) {
        Optional<Cuenta> cuenta = cuentaRepository.findById(id);
        return cuenta;
    }

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {
        Cuenta cuentaCreada = cuentaRepository.save(cuenta);
        return cuentaCreada;
    }

    @Override
    public void eliminarCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }

    @Override
    public Cuenta actualizarCuenta(Cuenta cuenta) {
        Cuenta cuentaActualizada = cuentaRepository.save(cuenta);
        return cuentaActualizada;
    }

    @Override
    public Cuenta obtenerCuentaPorUsuario(String usuario) {
        Cuenta cuenta = cuentaRepository.findByUsuario(usuario);
        return cuenta;
    }
    
}
