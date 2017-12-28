package student;

import dao.StudentDao;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import model.Student;

/**
 *
 * @author maria
 */
@Named(value = "studentBean")
@RequestScoped
public class StudentBean {

    private String firstName;
    private String lastName;
    private Integer age;
    private String location;
    private Date date;
    private Student student = new Student();
    private String chosenOne;
    private List<Student> students = new ArrayList<>();

    public Date getDate() {
        return date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @Inject
    private NavigationController nav;

    public NavigationController getNav() {
        return nav;
    }

    public void setNav(NavigationController nav) {
        this.nav = nav;
    }
    public String getChosenOne() {
        return chosenOne;
    }

    public void setChosenOne(String chosenOne) {
        this.chosenOne = chosenOne;
    }

    @Inject
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }
    @Inject
        private StudentDao studentDao;
    
    public String saveStudent() {

        student.setName(firstName);
        student.setLastname(lastName);
        student.setAge(age);
        student.setLocation(nav.getLocation());
        student.setSubject1(subject.getSubject1());
        student.setSubject2(subject.getSubject2());
        student.setSubject3(subject.getSubject3());
        student.setSubject4(subject.getSubject4());

        studentDao.createStudent(student);

        return nav.navigate();
    }
    
    public String testClick() {
        studentDao.removeStudent(Long.parseLong(chosenOne));
        return "deleteStudent";
    }
      
    public String deleteStudent() {
        studentDao.removeStudent(Long.parseLong(chosenOne));
        return "deleteStudent";
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public StudentBean() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String fillArrayFromDb() {
        students = (List<Student>) studentDao.findAllStudents();
        return "showDb";
    }

}
