package com.example.notice.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

  public static String getCurrentDateAsYyyyMMdd() {
    return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
  }
}
