package bean;

public class EducationDegree {
    private int EducationDegreeId;
    private String EducationDegreeName;

    public EducationDegree(int educationDegreeId, String educationDegreeName) {
        EducationDegreeId = educationDegreeId;
        EducationDegreeName = educationDegreeName;
    }

    public int getEducationDegreeId() {
        return EducationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        EducationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return EducationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        EducationDegreeName = educationDegreeName;
    }
}
