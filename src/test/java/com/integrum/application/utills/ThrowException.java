package com.integrum.application.utills;

public class ThrowException extends RuntimeException {

  public ThrowException(String message) {
    super(message);
  }

  public ThrowException(String message, Throwable cause) {
    super(message, cause);
  }
}
