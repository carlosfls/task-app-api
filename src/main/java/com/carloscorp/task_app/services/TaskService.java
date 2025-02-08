package com.carloscorp.task_app.services;

import com.carloscorp.task_app.services.dto.CreateTaskDTO;
import com.carloscorp.task_app.services.dto.TaskDTO;

public interface TaskService {

    /**
     * Create new task and send to bot
     */
    void createAndSend(CreateTaskDTO dto);

    /**
     * Send task for bot
     */
    void send(TaskDTO task);
}
