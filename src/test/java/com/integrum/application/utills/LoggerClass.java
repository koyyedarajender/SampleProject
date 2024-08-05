package com.integrum.application.utills;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface LoggerClass {
  default Logger log() {
    return LogManager.getLogger(this.getClass());
  }
}
