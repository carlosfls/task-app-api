package com.carloscorp.task_app.services.impl;

import com.carloscorp.task_app.services.StepFactory;
import com.carloscorp.task_app.services.TaskService;
import com.carloscorp.task_app.services.dto.CreateTaskDTO;
import com.carloscorp.task_app.services.dto.Step;
import com.carloscorp.task_app.services.dto.TaskDTO;
import com.carloscorp.task_app.services.enums.StepType;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RabbitMqTaskServiceImpl implements TaskService {

    private final RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        rabbitTemplate.convertAndSend("x.task","", "Ack Message");
    }

    @Override
    public void createAndSend(CreateTaskDTO dto){
        TaskDTO task = TaskDTO.builder()
                .description(dto.getDescription())
                .steps(getStepsFromTask(dto))
                .build();

       send(task);
    }

    @Override
    public void send(TaskDTO task) {
        rabbitTemplate.convertAndSend("x.task","", task);
    }

    private List<Step> getStepsFromTask(CreateTaskDTO dto){
        List<Step> steps = new ArrayList<>();
        for (Map<String,String> attributes : dto.getSteps()){
            StepType type = Enum.valueOf(StepType.class, attributes.get("type"));
            StepFactory factory = StepFactory.create(type);
            Step step = factory.build(attributes);
            steps.add(step);
        }
        return steps;
    }
}
