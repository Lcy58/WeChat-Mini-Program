package com.ruoyi.system.controller.api;


import com.ruoyi.common.core.domain.BaseEntity;

public class Zlzp extends BaseEntity {

    private String jobTitle;
    private String company;
    private String salary;
    private String location;
    private String jobYear;
    private String eduLevel;
    private String hrImg;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHrImg() {
        return hrImg;
    }

    public void setHrImg(String hrImg) {
        this.hrImg = hrImg;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobYear() {
        return jobYear;
    }

    public void setJobYear(String jobYear) {
        this.jobYear = jobYear;
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    // Default constructor
    public Zlzp() {
    }

    public Zlzp(String jobTitle, String company, String salary, String location, String jobYear, String eduLevel, String hrImg) {
        this.jobTitle = jobTitle;
        this.company = company;
        this.salary = salary;
        this.location = location;
        this.jobYear = jobYear;
        this.eduLevel = eduLevel;
        this.hrImg = hrImg;
    }

    @Override
    public String toString() {
        return "Zlzp{" +
                "jobTitle='" + jobTitle + '\'' +
                ", company='" + company + '\'' +
                ", salary='" + salary + '\'' +
                ", location='" + location + '\'' +
                ", jobYear='" + jobYear + '\'' +
                ", eduLevel='" + eduLevel + '\'' +
                ", hrImg='" + hrImg + '\'' +
                '}';
    }
}
