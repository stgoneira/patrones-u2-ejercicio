package cl.patrones.sysdonaciones.notificaciones;

import cl.patrones.sysdonaciones.core.entities.Donacion;

public class SmsNotificacionService extends NotificacionServiceBase {

	public SmsNotificacionService(NotificacionService decorado) {
		super(decorado);
	}

	@Override
	public void notificar(String transaccionId) {
		super.notificar(transaccionId);
		System.out.println("Enviando SMS....");
	}

	@Override
	public void donacionRegistrada(Donacion donacion) {
		notificar(donacion.getId().toString());
	}
	
	
}
