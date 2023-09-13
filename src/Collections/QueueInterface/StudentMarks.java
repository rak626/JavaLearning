package Collections.QueueInterface;

import java.util.Objects;

public class StudentMarks {

    private int math;
    private int physics;


    private int chemistry;

    public int getMath() {
        return math;
    }

    public int getPhysics() {
        return physics;
    }

    public int getChemistry() {
        return chemistry;
    }

    @Override
    public String toString() {
        return "StudentMarks{" + "math=" + math + ", physics=" + physics + ", chemistry=" + chemistry + '}';
    }

    public StudentMarks(int math, int physics, int chemistry) {
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;

    }


//    @Override
//    public int compareTo(StudentMarks studentMarks) {
//        if (this.math < studentMarks.math) return 1;
//        if (this.math > studentMarks.math) return -1;
//        return studentMarks.physics - this.physics;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentMarks that = (StudentMarks) o;
        return math == that.math && physics == that.physics && chemistry == that.chemistry;
    }

    @Override
    public int hashCode() {
        return Objects.hash(math, physics, chemistry);
    }
}
