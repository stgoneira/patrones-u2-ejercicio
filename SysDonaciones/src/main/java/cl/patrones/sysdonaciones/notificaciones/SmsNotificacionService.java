package cl.patrones.sysdonaciones.notificaciones;

public class SmsNotificacionService implements NotificacionService {
	
	@Override
	public void notificar(String transaccionId) {		
		System.out.println("Enviando SMS....");
	}
	
}
