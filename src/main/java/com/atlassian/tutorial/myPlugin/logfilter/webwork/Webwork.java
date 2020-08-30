package com.atlassian.tutorial.myPlugin.logfilter.webwork;

import com.atlassian.jira.web.action.JiraWebActionSupport;
import com.atlassian.tutorial.myPlugin.logfilter.util.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Webwork extends JiraWebActionSupport {
    private static final Logger log = LoggerFactory.getLogger(Webwork.class);
    private List<String> logFiltered;
    private int maxEntries;
    private String logFile;
    private String fromDate;
    private String toDate;
    private String className;
    private String logLevel;

    public Webwork() {
        logFile = "";
    }

    @Override
    public String execute() {
        try {
            logFiltered = new Reader().read(logFile, maxEntries, fromDate, toDate, className, logLevel);
        } catch (IOException | ParseException e) {
            log.error(e.getMessage(), e);
        }
        return "logfilter";
    }

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }

    public List<String> getLogFiltered() {
        return logFiltered;
    }

    public void setLogFiltered(List<String> logFiltered) {
        this.logFiltered = logFiltered;
    }

    public int getMaxEntries() {
        return maxEntries;
    }

    public void setMaxEntries(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
}
