package com.kingman.myresume.models;

/**
 * Created by wb-lijinwei.a on 2016/5/24.
 */
public class EducationInfo {
    private String startYear;
    private String endYear;
    private String school;
    private String profession;
    private String education;

    public EducationInfo(String startYear, String endYear, String school, String profession, String education) {
        this.startYear = startYear;
        this.endYear = endYear;
        this.school = school;
        this.profession = profession;
        this.education = education;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }


}
