package com.carloscorp.task_app.resources;

import com.carloscorp.task_app.services.TaskService;
import com.carloscorp.task_app.services.dto.CreateTaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskResource {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody CreateTaskDTO dto){
        taskService.createTaskDto(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
