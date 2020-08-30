package com.atlassian.tutorial.myPlugin.logfilter.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String line;
    private List<String> result;

    public Reader() {
        result = new ArrayList<>();
    }

    public List<String> read(String logPath, int maxEntries, String fromDate, String toDate, String className, String logLevel) throws IOException, ParseException {
        File logFile = new File(logPath);
        if (!logFile.exists()) {
            result.add("Log file no found");
            return result;
        }
        FileReader reader = new FileReader(logFile);
        BufferedReader bufferedReader = new BufferedReader(reader);
        int i = 0;
        while (i < maxEntries && bufferedReader.ready()) {
            line = bufferedReader.readLine();
            if (!isLogLine(line)){
                continue;
            }
            if (filterClassName(className) && filterLoglevel(logLevel) && filterDate(fromDate, toDate)) {
                result.add(line);
                i++;
            }
        }
        return result;
    }

    private boolean filterDate(String fromDate, String toDate) throws ParseException {
        if (fromDate.isEmpty() && toDate.isEmpty()) {
            return true;
        }
        if (fromDate.isEmpty()) {
            fromDate = "1900-01-01T00:00:00";
        }
        if (toDate.isEmpty()) {
            toDate = "3000-01-01T00:00:00";
        }
        String lineTimeStr = line.split(",")[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime lineTime = LocalDateTime.parse(lineTimeStr, formatter);
        formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime from = LocalDateTime.parse(fromDate, formatter);
        LocalDateTime to = LocalDateTime.parse(toDate, formatter);

        if (lineTime.isAfter(from) && lineTime.isBefore(to)) {

            return true;
        }
        return false;

    }

    private boolean filterClassName(String className) {
        if (line.isEmpty()) {
            return true;
        }
        if (line.contains(className)) {
            return true;
        }
        return false;
    }

    private boolean filterLoglevel(String logLevel) {
        String lineLogLevel = line.split(" ")[3];
        if (lineLogLevel.equals(logLevel) || logLevel.equals("ALL")) {
            return true;
        }
        return false;
    }

    private boolean isLogLine(String line) {
        String[] split = line.split(" ");
        if (split.length < 3) {
            return false;
        }
        String lineLogLevel = split[3];
        if (lineLogLevel.equals("ALL") ||
                lineLogLevel.equals("DEBUG") ||
                lineLogLevel.equals("INFO") ||
                lineLogLevel.equals("WARN") ||
                lineLogLevel.equals("ERROR") ||
                lineLogLevel.equals("FATAL") ||
                lineLogLevel.equals("OFF") ||
                lineLogLevel.equals("TRACE")) {
            return true;
        }
        return false;

    }
}
