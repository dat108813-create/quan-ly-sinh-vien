package com.example.students.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.students.entity.Student;
import com.example.students.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return studentRepository.findAll();
        }
        String kw = keyword.trim();
        // Truyền kw vào đúng cả 4 tham số mà Repository yêu cầu
        return studentRepository.findByStudentCodeContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingIgnoreCase(kw, kw, kw, kw);
    }

    public Student getById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void delete(UUID id) {
        studentRepository.deleteById(id);
    }
}