package com.carloscorp.task_app.services;

import com.carloscorp.task_app.services.dto.Step;
import com.carloscorp.task_app.services.enums.StepType;
import com.carloscorp.task_app.services.factory.StepClickFactory;
import com.carloscorp.task_app.services.factory.StepMoveFactory;
import com.carloscorp.task_app.services.factory.StepPressKeyFactory;
import com.carloscorp.task_app.services.factory.StepWriteFactory;

import java.util.Map;

public interface StepFactory {

    Step build(Map<String,String> attributes);

    static StepFactory create(StepType stepType){
        return switch (stepType){
            case MOVE -> new StepMoveFactory();
            case WRITE -> new StepWriteFactory();
            case CLICK -> new StepClickFactory();
            case PRESS_KEY -> new StepPressKeyFactory();
        };
    }
}
