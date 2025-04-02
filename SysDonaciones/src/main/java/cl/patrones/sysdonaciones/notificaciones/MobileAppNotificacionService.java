package cl.patrones.sysdonaciones.notificaciones;

public class MobileAppNotificacionService implements NotificacionService {
	
	@Override
	public void notificar(String transaccionId) {
		System.out.println("Enviando push notification....");
	}
	
}
