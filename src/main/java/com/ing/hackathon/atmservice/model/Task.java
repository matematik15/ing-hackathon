package com.ing.hackathon.atmservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Comparator;

@Data
public class Task {

  private int region;
  @EqualsAndHashCode.Exclude private RequestType requestType;
  private int atmId;

  public static Comparator<Task> taskPriorityComparator =
          Comparator.comparingInt(task -> task.getRequestType().getPriority());

}
