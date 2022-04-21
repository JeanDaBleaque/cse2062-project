public class Department {

    private long overseer_id;
    private String departmentName;

    public Department(long overseer_id, String departmentName) {
        this.overseer_id = overseer_id;
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public long getOverseer_id() {
        return overseer_id;
    }

    public void setOverseer_id(long overseer_id) {
        this.overseer_id = overseer_id;
    }

    @Override
    public String toString() {
        return departmentName;
    }
}
