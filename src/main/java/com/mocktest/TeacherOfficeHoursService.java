package com.mocktest;

/**
 * WebService
 */

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public interface TeacherOfficeHoursService {
  /**
   * Get teacher office hours info
   * @param teacherName
   * @return Teacher office hours info in JSON format converted to string, if not exists return NULL
   */
  public String fetchData();
}
