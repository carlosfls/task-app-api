package com.carloscorp.task_app.services.factory;

import com.carloscorp.task_app.services.dto.Step;
import com.carloscorp.task_app.services.dto.StepMove;
import com.carloscorp.task_app.services.StepFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class StepMoveFactory implements StepFactory {

    @Override
    public Step build(Map<String, String> attributes) {
        return StepMove.builder()
                .x(Integer.parseInt(attributes.getOrDefault("x","0")))
                .y(Integer.parseInt(attributes.getOrDefault("y","0")))
                .delay(Integer.parseInt(attributes.getOrDefault("delay","0")))
                .build();
    }
}
