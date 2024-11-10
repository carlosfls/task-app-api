package com.carloscorp.task_app.services.factory;

import com.carloscorp.task_app.services.dto.Step;
import com.carloscorp.task_app.services.dto.StepClick;
import com.carloscorp.task_app.services.enums.MouseKeyType;
import com.carloscorp.task_app.services.StepFactory;

import java.util.Map;

public class StepClickFactory implements StepFactory {

    @Override
    public Step build(Map<String, String> attributes) {
        return StepClick.builder()
                .noClicks(Integer.parseInt(attributes.getOrDefault("noClicks","1")))
                .mouseKeyType(Enum.valueOf(MouseKeyType.class,
                        attributes.getOrDefault("mouseKeyType","LEFT_CLICK")))
                .build();
    }
}
