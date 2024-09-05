package com.mocktest;

/**
 * WebService
 */

public interface TeacherOfficeHoursService {
  /**
   * Get teacher office hours info
   * @param teacherName
   * @return Teacher office hours info in JSON format converted to string, if not exists return NULL
   */
  public String fetchData();
}
