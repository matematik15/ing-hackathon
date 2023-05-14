package com.ing.hackathon.atmservice.service;

import com.ing.hackathon.atmservice.model.ATM;
import com.ing.hackathon.atmservice.model.Task;
import com.ing.hackathon.atmservice.util.TaskPriorityQueue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DefaultAtmService implements AtmService{

    @Override
    public List<ATM> doCalculation(List<Task> tasks) {
        //if we knew the number of regions upfront, we could use an ArrayList and use the index as the region
        //since the number of regions isn't known upfront, a HashMap is used where the keys correspond to the regions
        HashMap<Integer, TaskPriorityQueue> regionTasks = new HashMap<>();

        // Process the tasks and store them in the appropriate region
        for (Task task : tasks) {
            int region = task.getRegion();
            regionTasks.putIfAbsent(region, new TaskPriorityQueue(Task.taskPriorityComparator));
            regionTasks.get(region).addOrUpdate(task);
        }

        // Flatten the regionAtms HashMap
        List<ATM> flattenedAtms = new ArrayList<>();
        for (TaskPriorityQueue taskQueue : regionTasks.values()) {
            flattenedAtms.addAll(taskQueue.getSortedAtms());
        }
        return flattenedAtms;
    }
}
