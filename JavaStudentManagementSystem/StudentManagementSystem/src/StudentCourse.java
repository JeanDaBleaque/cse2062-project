public class StudentCourse {
    private String courseId;
    private int midterm1; // first midterm grade
    private int midterm2; // second midterm grade
    private int finalExam; // final exam grade
    private String letterGrade;

    public StudentCourse(String courseId, int midterm1, int midterm2, int finalExam) {
        this.courseId = courseId;
        this.midterm1 = midterm1;
        this.midterm2 = midterm2;
        this.finalExam = finalExam;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getMidterm1() {
        return midterm1;
    }

    public void setMidterm1(int midterm1) {
        this.midterm1 = midterm1;
    }

    public int getMidterm2() {
        return midterm2;
    }

    public void setMidterm2(int midterm2) {
        this.midterm2 = midterm2;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(int finalExam) {
        this.finalExam = finalExam;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public void calculateGrade(Course course) {
        if (course.getCourseId().equals(getCourseId())) {
            float grade = course.getpM1()*getMidterm1()+course.getpM2()*getMidterm2()+course.getpFinal()*getFinalExam();
            if (grade >= 90) {
                letterGrade = "AA";
            } else if (grade >= 85) {
                letterGrade = "BA";
            } else if (grade >= 80) {
                letterGrade = "BB";
            } else if (grade >= 75) {
                letterGrade = "CB";
            } else if (grade >= 70) {
                letterGrade = "CC";
            } else if (grade >= 65) {
                letterGrade = "DC";
            }  else if (grade >= 60) {
                letterGrade = "DD";
            } else if (grade >= 55) {
                letterGrade = "FD";
            } else {
                letterGrade = "FF";
            }
        } else {
            System.out.println("Course ID does not match");
        }
    }

    public static String calculateGrade(Course course, int midterm1, int midterm2, int finalExam) {
        float grade = course.getpM1()*midterm1+course.getpM2()*midterm2+course.getpFinal()*finalExam;
        if (grade >= 90) {
            return "AA";
        } else if (grade >= 85) {
            return "BA";
        } else if (grade >= 80) {
            return "BB";
        } else if (grade >= 75) {
            return "CB";
        } else if (grade >= 70) {
            return "CC";
        } else if (grade >= 65) {
            return "DC";
        }  else if (grade >= 60) {
            return "DD";
        } else if (grade >= 55) {
            return "FD";
        } else {
            return "FF";
        }
    }
}
