package models;

import enums.ProjectType;

public class Projects {
    private int id;
    private String name;
    private String announcement;
    private boolean showAnnouncement;
    private boolean isCompleted;
    private int completedOn;
    private Integer suiteMode;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public boolean isShowAnnouncement() {
        return showAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(int completedOn) {
        this.completedOn = completedOn;
    }

    public Integer getSuiteMode() {
        return suiteMode;
    }

    public void setSuiteMode(Integer suiteMode) {
        this.suiteMode = suiteMode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

