package com.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.repository.TaskRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private TaskRepository taskRepository;

    public Map<String, Object> getTaskSummary() {
        long completedTasks = taskRepository.countByStatus("Completed");
        long pendingTasks = taskRepository.countByStatus("Pending");
        long totalTasks = taskRepository.count();

        Map<String, Object> report = new HashMap<>();
        report.put("totalTasks", totalTasks);
        report.put("completedTasks", completedTasks);
        report.put("pendingTasks", pendingTasks);

        return report;
    }
}
