package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.ValidatorFactory;
import model.Student;

@Stateless
public class StudentDao {

    @PersistenceContext
    private EntityManager em;

    public void createStudent(Student student) {

        em.persist(student);
    }

    public Student edit(Student student) {
        return em.merge(student);
    }

    public void removeStudent(long id) {
        em.remove(findStudent(id));
    }

    public Student findStudent(long id) {
        return em.find(Student.class, id);
    }
    
    public void findStudentAndUpdateAge(long id,int age) {
        Student newStudent = em.find(Student.class, id);
        newStudent.setAge(age);
        em.merge(newStudent);
    
    }

    public List<Student> findAllStudents() {
        return em.createQuery("SELECT s FROM Student s").getResultList();
    }

}
