import java.util.List;

public class School {
    private List<Teacher> teachers;
    private List <Student> students;
    private  School school;
    private static int totalmoneyearnerd;
    private static int totalmoneyspent;

    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        totalmoneyspent=0;
        totalmoneyearnerd=0;
    }

    public static void updateTotalmoneyearned(int feespaid) {
        totalmoneyearnerd+=feespaid;

    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeachers(Teacher a ) {
        teachers.add(a);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents( Student b) {
        students.add(b);
    }



    public  static int getTotalmoneyearnerd() {
        return totalmoneyearnerd;
    }

//    public static void updateTotalmoneyearnerd(int moneyearnerd) {
//       totalmoneyearnerd+=moneyearnerd;
//    }

    public static int getTotalmoneyspent() {
        return totalmoneyspent;
    }

    public  static  void setTotalmoneyspent(int totalmoneyspent) {
        totalmoneyearnerd-=totalmoneyspent;
    }
}
