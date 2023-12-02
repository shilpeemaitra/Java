public class University {

    // Static variables for university-wide information
    private static String universityName;
    private static String[] universityDepartments;

    // Static block for initializing university-wide information
    static {
        universityName = "Elite University";
        universityDepartments = new String[]{"Computer Science", "Business Administration", "Engineering"};
        System.out.println("Welcome to " + universityName + "!");
    }

    // Static method to provide university-wide information
    public static void universityInfo() {
        System.out.println("University Information:");
        System.out.println("Name: " + universityName);
        System.out.println("Departments: " + arrayToString(universityDepartments));
    }

    // Static method to convert an array to a string
    private static String arrayToString(String[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    // Static variable to count the total number of students enrolled in the university
    private static int totalStudents = 0;

    // Instance variables for a student
    private String studentName;
    private int studentId;
    private String[] enrolledCourses;
    private int courseCount; // To track the number of enrolled courses

    // Constructor to enroll a student in the university
    public University(String studentName) {
        this.studentName = studentName;
        this.studentId = ++totalStudents; // Increment totalStudents for each new student to assign a unique ID
        this.enrolledCourses = new String[5]; // Assuming a student can enroll in up to 5 courses
        this.courseCount = 0; // Initializing the course count
    }

    // Instance method to display student information
    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Enrolled Courses: " + arrayToString(enrolledCourses));
    }

    // Instance method to enroll a student in a course
    public void enrollInCourse(String courseName) {
        if (courseCount < enrolledCourses.length) {
            enrolledCourses[courseCount++] = courseName; // Add the course and then increment the courseCount
            System.out.println(studentName + " has been enrolled in the course: " + courseName);
        } else {
            System.out.println("Maximum number of courses reached for " + studentName);
        }
    }

    public static void main(String[] args) {
        // Display university information
        University.universityInfo();

        // Enroll two students in the university
        University student1 = new University("John Doe");
        University student2 = new University("Jane Doe");

        // Display individual student information before enrolling in courses
        System.out.println("\nStudent 1 Information:");
        student1.displayStudentInfo();

        System.out.println("\nStudent 2 Information:");
        student2.displayStudentInfo();

        // Enroll students in courses
        student1.enrollInCourse("Introduction to Programming");
        student1.enrollInCourse("Database Management");

        student2.enrollInCourse("Business Ethics");
        student2.enrollInCourse("Marketing Fundamentals");

        // Display student information after enrolling in courses
        System.out.println("\nStudent 1 Information After Enrollment:");
        student1.displayStudentInfo();

        System.out.println("\nStudent 2 Information After Enrollment:");
        student2.displayStudentInfo();
    }
}
