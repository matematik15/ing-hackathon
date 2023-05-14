package com.ing.hackathon.atmservice.model;

public enum RequestType {
  FAILURE_RESTART(1),
  PRIORITY(2),
  SIGNAL_LOW(3),
  STANDARD(4);

  private final Integer priority;

  RequestType(Integer priority) {
    this.priority = priority;
  }

  public Integer getPriority() {
    return priority;
  }
}
