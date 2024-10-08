package com.mocktest;

public class TeacherConst {

  public static String TEACHER_1 = "{ \"name\": \"John Doe\", \n " +
          "\"officeHour\": \"10:00 AM - 11:00 AM\", \n " +
          "\"room\": 1, \n" +
          "\"period\": " + Period.MORNING + " }";

  public static String TEACHER_2 = "{ \"name\": \"Jane Smith\", \n " +
          "\"officeHour\": \"11:00 AM - 12:00 PM\", \n " +
          "\"room\": 7, \n" +
          "\"period\": " + Period.MORNING + " }";

  public static String TEACHER_3 = "{ \"name\": \"Alice Johnson\", \n " +
          "\"officeHour\": \"1:00 PM - 2:00 PM\", \n " +
          "\"room\": 12, \n" +
          "\"period\": " + Period.AFTERNOON + " }";

  public static String TEACHER_4 = "{ \"name\": \"Bob Brown\", \n " +
          "\"officeHour\": \"2:00 PM - 3:00 PM\", \n " +
          "\"room\": 17, \n" +
          "\"period\": " + Period.AFTERNOON + " }";

  public static String TEACHER_5 = "{ \"name\": \"Charlie Davis\", \n " +
          "\"officeHour\": \"3:00 PM - 4:00 PM\", \n " +
          "\"room\": 22, \n" +
          "\"period\": " + Period.AFTERNOON + " }";

  public static String TEACHER_6 = "{ \"name\": \"Diana Evans\", \n " +
          "\"officeHour\": \"9:00 AM - 10:00 AM\", \n " +
          "\"room\": 26, \n" +
          "\"period\": " + Period.MORNING + " }";

  public static String TEACHER_7 = "{ \"name\": \"Evan Foster\", \n " +
          "\"officeHour\": \"10:00 AM - 11:00 AM\", \n " +
          "\"room\": 32, \n" +
          "\"period\": " + Period.MORNING + " }";

  public static String TEACHER_8 = "{ \"name\": \"Fiona Green\", \n " +
          "\"officeHour\": \"11:00 AM - 12:00 PM\", \n " +
          "\"room\": 5, \n" +
          "\"period\": " + Period.AFTERNOON + " }";

  public static String TEACHER_9 = "{ \"name\": \"George Harris\", \n " +
          "\"officeHour\": \"1:00 PM - 2:00 PM\", \n " +
          "\"room\": 8, \n" +
          "\"period\": " + Period.AFTERNOON + " }";

  public static String TEACHER_10 = "{ \"name\": \"Hannah White\", \n " +
          "\"officeHour\": \"2:00 PM - 3:00 PM\", \n " +
          "\"room\": 10, \n" +
          "\"period\": " + Period.AFTERNOON + " }";

  public static String concatIntoJsonArray(String... jsonObjects) {
    StringBuilder jsonArray = new StringBuilder();

    jsonArray.append("[");

    for (int i = 0; i < jsonObjects.length; i++) {
      jsonArray.append(jsonObjects[i]);
      if (i < jsonObjects.length - 1) {
        jsonArray.append(", ");
      }
    }

    jsonArray.append(" ]");
    return jsonArray.toString();
  }
}