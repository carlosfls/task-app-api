package com.carloscorp.task_app.services.factory;

import com.carloscorp.task_app.services.dto.Step;
import com.carloscorp.task_app.services.dto.StepWrite;
import com.carloscorp.task_app.services.StepFactory;

import java.util.Map;

public class StepWriteFactory implements StepFactory {

    @Override
    public Step build(Map<String, String> attributes) {
        return StepWrite.builder()
                .text(attributes.get("text"))
                .delay(Integer.parseInt(attributes.getOrDefault("delay","0")))
                .build();
    }
}
