package com.carloscorp.task_app.services.factory;

import com.carloscorp.task_app.services.StepFactory;
import com.carloscorp.task_app.services.dto.Step;
import com.carloscorp.task_app.services.dto.StepPressKey;
import lombok.extern.slf4j.Slf4j;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class StepPressKeyFactory implements StepFactory {

    @Override
    public Step build(Map<String, String> attributes) {
        String keys = attributes.getOrDefault("keys", "");
        return StepPressKey.builder()
                .keys(getKeyEvents(keys))
                .delay(Integer.parseInt(attributes.getOrDefault("delay","0")))
                .combine(Boolean.parseBoolean(attributes.getOrDefault("combine", "false")))
                .build();
    }

    private List<Integer> getKeyEvents(String keys){
        List<Integer> keyEvents = new ArrayList<>();
        for (String s : keys.split("\\s+")){
            try {
                Field field = KeyEvent.class.getField("VK_" + s);
                Integer code = (Integer) field.get(null);
                keyEvents.add(code);
            }catch (Exception e){
                log.info(e.getMessage());
            }
        }
        return keyEvents;
    }
}
