package br.edu.devmedia.util;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.edu.devmedia.entity.Content;
import de.bytefish.fcmjava.client.FcmClient;
import de.bytefish.fcmjava.client.settings.PropertiesBasedSettings;
import de.bytefish.fcmjava.model.options.FcmMessageOptions;
import de.bytefish.fcmjava.requests.data.DataUnicastMessage;
import de.bytefish.fcmjava.requests.notification.NotificationPayload;
import de.bytefish.fcmjava.requests.notification.NotificationUnicastMessage;

public class Post2FCM {
	
	public static void main(String[] args) {
		
		postUnicast(criarContent() );
		
	}
	
	private static Content criarContent() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Content content = new Content();
		content.addRegId("e6C9Ku0ISno:APA91bHfTU6PMpSZyJqtyt9XEyRzYkIgfAh_ZR8k_vXAl76U4R9uOVYz437SZKY_kju4E2LwNyBME0t4_3iKqlj1miOb8Z5_t-aS0WuaE0lxG7j1BJi_X8esmTDdaV_bYgSOo_QWMPs-");
		content.addData("titulo", "Notificação Teste");
		content.addData("message", "Mensagem teste.");
		content.addData("data", simpleDateFormat.format(new Date() ) );
		content.addData("id", "2");
		content.addData("imgUrl", "https://d30y9cdsu7xlg0.cloudfront.net/png/1199198-200.png");
		return content;
		
	}
	
	public static boolean postUnicast(Content content) {
		
		try (FcmClient client = new FcmClient(PropertiesBasedSettings.createFromDefault())) {

            FcmMessageOptions options = FcmMessageOptions.builder()
                    .setTimeToLive(Duration.ofHours(1))
                    .build();

            Map<String, String> data = content.getData();
            List<String> regIds = content.getRegIds();
            String to = regIds.get(0);
            DataUnicastMessage notification = new DataUnicastMessage(options, to, data);
            client.send(notification);
            return true;
            
        } catch(Exception e) {
        	
        	e.printStackTrace();
        	return false;
        	
        }		
		
	}

}
