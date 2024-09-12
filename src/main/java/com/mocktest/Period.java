package com.mocktest;

public enum Period {
  MORNING("morning"),
  AFTERNOON("afternoon");

  public final String label;

  Period(String label) {
    this.label = label;
  }
}
