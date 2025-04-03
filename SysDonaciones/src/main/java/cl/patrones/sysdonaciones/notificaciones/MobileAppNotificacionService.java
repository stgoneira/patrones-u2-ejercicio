package cl.patrones.sysdonaciones.notificaciones;

import cl.patrones.sysdonaciones.core.entities.Donacion;

public class MobileAppNotificacionService extends NotificacionServiceBase {

	public MobileAppNotificacionService(NotificacionService decorado) {
		super(decorado);
	}

	@Override
	public void notificar(String transaccionId) {
		super.notificar(transaccionId);
		System.out.println("Enviando push notification....");
	}

	@Override
	public void donacionRegistrada(Donacion donacion) {
		notificar(donacion.getId().toString());
	}
	
	
}
