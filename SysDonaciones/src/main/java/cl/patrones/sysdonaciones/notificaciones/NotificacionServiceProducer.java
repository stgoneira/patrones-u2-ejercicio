package cl.patrones.sysdonaciones.notificaciones;

import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.patrones.sysdonaciones.core.services.ConfiguracionService;

@Configuration
public class NotificacionServiceProducer {

	private ConfiguracionService configuracionService;	
	
    public NotificacionServiceProducer(ConfiguracionService configuracionService) {
		super();
		this.configuracionService = configuracionService;
	}

	@Bean
	@DependsOnDatabaseInitialization	
    NotificacionService notificacionService() {
		var claveNotiEmail 	= "notificacion-email";
		var notificarViaEmail= configuracionService.obtenerConfiguración(claveNotiEmail);
		var claveNotiSms 	= "notificacion-sms";
		var notificarViaSms 	= configuracionService.obtenerConfiguración(claveNotiSms);
		var claveNotiApp 	= "notificacion-app";
		var notificarViaApp 	= configuracionService.obtenerConfiguración(claveNotiApp);
		
		NotificacionService notificacionService = null; 
		if( Boolean.valueOf(notificarViaEmail) ) {
			notificacionService = new EmailNotificacionService(notificacionService);
		}
		if( Boolean.valueOf(notificarViaSms)) {
			notificacionService = new SmsNotificacionService(notificacionService);
		}
		if( Boolean.valueOf(notificarViaApp)) {
			notificacionService = new MobileAppNotificacionService(notificacionService);
		}
		
		// no puede devolver null
		// por tanto la notificacion por defecto es via email
		if( notificacionService == null) {
			notificacionService = new EmailNotificacionService(notificacionService);
		}
		
		return notificacionService; 
	}
}
