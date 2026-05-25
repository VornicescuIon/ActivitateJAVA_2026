import java.util.Objects;

class Student {
    public String name;
    public int grade;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;

    }

    // Pentru cerința 9 (Unique Objects)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }

    @Override
    public String toString() {
        return name + " (" + grade + ")";
    }
}
