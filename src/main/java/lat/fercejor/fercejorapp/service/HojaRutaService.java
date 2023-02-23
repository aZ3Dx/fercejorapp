package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.HojaRutaServiceAPI;
import lat.fercejor.fercejorapp.model.HojaRuta;
import lat.fercejor.fercejorapp.repository.HojaRutaRepository;

@Service
public class HojaRutaService implements HojaRutaServiceAPI {

    @Autowired
    private HojaRutaRepository hojaRutaRepository;

    @Override
    public List<HojaRuta> obtenerTodasLasHojasRuta() {
        List<HojaRuta> hojasRuta = hojaRutaRepository.findAll();
        return hojasRuta;
    }

    @Override
    public Optional<HojaRuta> obtenerHojaRutaPorId(Long id) {
        Optional<HojaRuta> hojaRuta = hojaRutaRepository.findById(id);
        return hojaRuta;
    }

    @Override
    public HojaRuta crearHojaRuta(HojaRuta hojaRuta) {
        HojaRuta hojaRutaCreada = hojaRutaRepository.save(hojaRuta);
        return hojaRutaCreada;
    }

    @Override
    public void eliminarHojaRuta(Long id) {
        hojaRutaRepository.deleteById(id);
    }

    @Override
    public HojaRuta actualizarHojaRuta(HojaRuta hojaRuta) {
        HojaRuta hojaRutaActualizada = hojaRutaRepository.save(hojaRuta);
        return hojaRutaActualizada;
    }
    
}
