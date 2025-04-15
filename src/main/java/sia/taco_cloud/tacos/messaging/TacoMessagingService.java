package sia.taco_cloud.tacos.messaging;

import sia.taco_cloud.tacos.Taco;

public interface TacoMessagingService {

    void sendTaco(Taco order);

}
