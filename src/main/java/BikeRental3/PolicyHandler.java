package BikeRental3;

import BikeRental3.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRentalCancelled_DeliverCancelled(@Payload RentalCancelled rentalCancelled){

        if(rentalCancelled.isMe()){
            System.out.println("##### listener DeliverCancelled : " + rentalCancelled.toJson());
        }
    }

}
