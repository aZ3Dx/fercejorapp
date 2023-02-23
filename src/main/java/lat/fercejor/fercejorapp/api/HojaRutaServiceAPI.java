package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.HojaRuta;

public interface HojaRutaServiceAPI {

    List<HojaRuta> obtenerTodasLasHojasRuta();
    Optional<HojaRuta> obtenerHojaRutaPorId(Long id);
    HojaRuta crearHojaRuta(HojaRuta hojaRuta);
    void eliminarHojaRuta(Long id);
    HojaRuta actualizarHojaRuta(HojaRuta hojaRuta);
    
}
