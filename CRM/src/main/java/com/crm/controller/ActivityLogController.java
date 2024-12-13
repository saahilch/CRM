package com.crm.controller;

import com.crm.entities.ActivityLog;
import com.crm.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {

    @Autowired
    private ActivityLogService activityLogService;

    @GetMapping
    public List<ActivityLog> getAllLogs() {
        return activityLogService.getLogs();
    }

    @PostMapping
    public ActivityLog logAction(@RequestBody ActivityLog log) {
        return activityLogService.logAction(log);
    }
}
