package cl.patrones.sysdonaciones.core.services;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

import cl.patrones.sysdonaciones.core.entities.Donacion;
import cl.patrones.sysdonaciones.core.exceptions.SocioInexistenteException;

public interface DonacionService {
	
	public Optional<Donacion> obtenerDonacion(String transaccionId);
	
	public UUID registrarDonacionAnonima(File comprobante, Long monto);
	
	public UUID registrarMensualidadSocio(File comprobante, Long monto, String rut) throws SocioInexistenteException;
	
	public UUID registrarDonacionGeneral(File comprobante, Long monto, String rut, String nombre, String email, String telefono);
	
}
