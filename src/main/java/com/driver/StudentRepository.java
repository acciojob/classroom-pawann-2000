package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        studentMap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            ArrayList<String> temp = (ArrayList<String>) teacherStudentMapping.get(teacher);
            temp.add(student);
            teacherStudentMapping.put(teacher, temp);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(student);
            teacherStudentMapping.put(teacher, temp);
        }
        Teacher teacherObject = teacherMap.get(teacher);
        teacherObject.setNumberOfStudents(teacherObject.getNumberOfStudents()+1);
    }

    public Student findStudent(String student){
        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher){
        return teacherMap.get(teacher);
    }

    public List<String> findStudentsFromTeacher(String teacher){
        return teacherStudentMapping.getOrDefault(teacher, new ArrayList<>());
    }

    public List<String> findAllStudents(){
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher){
        for(String tName: teacherStudentMapping.get(teacher)){
            studentMap.remove(tName);
        }

        teacherMap.remove(teacher);
        teacherStudentMapping.remove(teacher);
    }

    public void deleteAllTeachers(){
        for(String teacher: teacherMap.keySet()){
            deleteTeacher(teacher);
        }

        teacherStudentMapping.clear();
    }
}