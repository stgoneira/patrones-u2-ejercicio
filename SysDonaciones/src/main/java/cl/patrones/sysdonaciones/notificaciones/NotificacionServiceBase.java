package cl.patrones.sysdonaciones.notificaciones;


abstract public class NotificacionServiceBase implements NotificacionService {

	private NotificacionService decorado;

	public NotificacionServiceBase(NotificacionService decorado) {
		super();
		this.decorado = decorado;
	}

	@Override
	public void notificar(String transaccionId) {
		if( decorado != null)
			decorado.notificar(transaccionId);		
	}
	
}
