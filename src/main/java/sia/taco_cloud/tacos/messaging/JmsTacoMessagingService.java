package sia.taco_cloud.tacos.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import sia.taco_cloud.tacos.Taco;

@Service
public class JmsTacoMessagingService implements TacoMessagingService {

    private JmsTemplate jms;

    @Autowired
    public JmsTacoMessagingService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public void sendTaco(Taco taco) {

        jms.convertAndSend(taco);
    }
}