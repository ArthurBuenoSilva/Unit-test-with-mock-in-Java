package com.mocktest;

import java.util.ArrayList;

enum Period {
  MORNING, EVENING
}

public class TeacherOfficeHoursModel {
  public String name;
  public String officeHour;
  public Period period;
  public int room;
  public ArrayList<String> building;

  //* Constructor
  public TeacherOfficeHoursModel(String name, String officeHour, Period period, int room) {
    this.name = name;
    this.officeHour = officeHour;
    this.period = period;
    this.room = room;
  }
}
