public class Student {
    private String name;
    private int grade;
    private int id;
    private int feespaid=0;
    private int feestotal = 30000;

    public int getFeespaid() {
        return feespaid;
    }

    public int getFeestotal() {
        return feestotal;
    }

    public void payfee(int fee) {
        feespaid += fee;
        School.updateTotalmoneyearned(feespaid);
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(int id, String name, int grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getId() {
        return id;
    }
}
