package com.example.mylibrary.service.impl;

import com.example.mylibrary.DTO.RequestDto.StudentRequestDto;
import com.example.mylibrary.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.mylibrary.DTO.ResponsDto.CardResponseDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllStudentResponseDto;
import com.example.mylibrary.DTO.ResponsDto.StudentResponseDto;
import com.example.mylibrary.DTO.ResponsDto.UpdateStudentMobResponseDto;
import com.example.mylibrary.entity.Card;
import com.example.mylibrary.entity.Student;
import com.example.mylibrary.enums.CardStatus;
import com.example.mylibrary.exception.StudentNotFoundException;
import com.example.mylibrary.repository.StudentRepository;
import com.example.mylibrary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setMobNo(studentRequestDto.getMobNo());
        student.setEmail(studentRequestDto.getEmail());
        student.setDepartment(studentRequestDto.getDepartment());

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2025-01-01");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        return "Student Added !";
    }

    @Override
    public UpdateStudentMobResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        try{
            Student student = studentRepository.findById(updateStudentMobRequestDto.getId()).get();
            student.setMobNo(updateStudentMobRequestDto.getMobNo());
            Student updateStudent = studentRepository.save(student);

            UpdateStudentMobResponseDto updateStudentMobResponseDto = new UpdateStudentMobResponseDto();
            updateStudentMobResponseDto.setName(updateStudent.getName());
            updateStudentMobResponseDto.setMobNo(updateStudentMobRequestDto.getMobNo());
            return updateStudentMobResponseDto;
        }catch(Exception e){
            throw new StudentNotFoundException("Invalid student id ");

        }

    }

    @Override
    public String deleteStudentById(int id) {
        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Student deleted successfully";
        } else {
            return "Student not found";
        }
    }


    @Override
    public StudentResponseDto getStudentById(int id) {
        Student student = studentRepository.findById(id).get();

        // prepare response dto
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setMobNo(student.getMobNo());



        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setUpdatedOn(student.getCard().getUpdatedOn());
        cardResponseDto.setValidTill(student.getCard().getValidTill());
        cardResponseDto.setId(student.getCard().getId());

        studentResponseDto.setCardResponseDto(cardResponseDto);
        return studentResponseDto;
    }

    @Override
    public List<GetAllStudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        // Convert entities to DTOs
        return students.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private GetAllStudentResponseDto convertToDto(Student student) {
        return new GetAllStudentResponseDto(student.getId(),student.getName(),student.getAge(),student.getDepartment(),student.getMobNo(),student.getEmail());
    }




}
