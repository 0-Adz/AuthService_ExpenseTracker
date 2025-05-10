package org.example.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.example.eventProducer.UserInfoEvent;
import org.example.model.UserInfoDto;

public class UserInfoSerializer implements Serializer<UserInfoEvent> {
    @Override
    public byte[] serialize(String s, UserInfoEvent eventData) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            retVal = objectMapper.writeValueAsString(eventData).getBytes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return retVal;
    }
}
