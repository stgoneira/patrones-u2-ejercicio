package cl.patrones.sysdonaciones.notificaciones;

import cl.patrones.sysdonaciones.core.entities.Donacion;

public class EmailNotificacionService extends NotificacionServiceBase {

	public EmailNotificacionService(NotificacionService decorado) {
		super(decorado);
	}

	@Override
	public void notificar(String transaccionId) {
		super.notificar(transaccionId);
		System.out.println("Enviando email....");
	}

	@Override
	public void donacionRegistrada(Donacion donacion) {
		notificar(donacion.getId().toString());
	}

	
	
}
