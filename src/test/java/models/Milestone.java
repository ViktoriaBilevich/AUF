package models;

import java.security.Timestamp;

public class Milestone {
    private int id;
    private String name;
    private String description;
    private Timestamp start_on;
    private Timestamp started_on;
    private boolean is_started;
    private Timestamp due_on;
    private boolean isCompleted;
    private Timestamp completedOn;
    private int project_id;
    private int parent_id;
    private String refs;
    private String url;
    private Milestone[] milestones;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStart_on() {
        return start_on;
    }

    public void setStart_on(Timestamp start_on) {
        this.start_on = start_on;
    }

    public Timestamp getStarted_on() {
        return started_on;
    }

    public void setStarted_on(Timestamp started_on) {
        this.started_on = started_on;
    }

    public boolean isIs_started() {
        return is_started;
    }

    public void setIs_started(boolean is_started) {
        this.is_started = is_started;
    }

    public Timestamp getDue_on() {
        return due_on;
    }

    public void setDue_on(Timestamp due_on) {
        this.due_on = due_on;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Timestamp getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(Timestamp completedOn) {
        this.completedOn = completedOn;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getRefs() {
        return refs;
    }

    public void setRefs(String refs) {
        this.refs = refs;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Milestone[] getMilestones() {
        return milestones;
    }

    public void setMilestones(Milestone[] milestones) {
        this.milestones = milestones;
    }
}

