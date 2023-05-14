package com.ing.hackathon.atmservice.util;

import com.ing.hackathon.atmservice.model.ATM;
import com.ing.hackathon.atmservice.model.Task;

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class TaskPriorityQueue extends PriorityQueue<Task> {

    //keeps track of all tasks and their highest priority
    //this serves the purpose of ignoring the duplicates later on without having to remove it from the queue
    private final HashMap<Task, Integer> taskMap;

    public TaskPriorityQueue(Comparator<Task> taskPriorityComparator) {
        super(taskPriorityComparator);
        this.taskMap = new HashMap<>();
    }

    public void addOrUpdate(Task task) {
        taskMap.put(task, task.getRequestType().getPriority());
        super.add(task);
    }

    public List<ATM> getSortedAtms() {
        List<ATM> sortedAtms = new ArrayList<>();
        Task task;
        while ((task = this.poll()) != null) {
            //ignoring duplicates
            if (taskMap.get(task).equals(task.getRequestType().getPriority())) {
                sortedAtms.add(new ATM(task.getRegion(), task.getAtmId()));
            }
        }
        return sortedAtms;
    }
}