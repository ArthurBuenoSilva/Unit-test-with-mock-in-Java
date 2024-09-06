package com.mocktest;

/**
 * WebService
 */

public interface TeacherOfficeHoursService {
  /**
   * Get teachers office hours info
   * @return Teachers office hours info in JSON format converted to string, if not exists return NULL
   */
  String fetchData();
}
