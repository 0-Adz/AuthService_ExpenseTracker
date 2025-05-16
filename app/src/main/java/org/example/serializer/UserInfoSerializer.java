package org.example.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.example.eventProducer.UserInfoEvent;
import org.example.model.UserInfoDto;

public class UserInfoSerializer implements Serializer<UserInfoDto> {
    @Override
    public byte[] serialize(String s, UserInfoDto eventData) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            retVal = objectMapper.writeValueAsBytes(eventData);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return retVal;
    }
}
