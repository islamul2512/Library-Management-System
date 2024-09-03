package com.example.mylibrary.controller;

import com.example.mylibrary.DTO.RequestDto.StudentRequestDto;
import com.example.mylibrary.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllStudentResponseDto;
import com.example.mylibrary.DTO.ResponsDto.StudentResponseDto;
import com.example.mylibrary.DTO.ResponsDto.UpdateStudentMobResponseDto;
import com.example.mylibrary.entity.Student;
import com.example.mylibrary.exception.StudentNotFoundException;
import com.example.mylibrary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }
    @PutMapping("/update_mobile")
    public UpdateStudentMobResponseDto updateMobNo(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {
           return studentService.updateMobNo(updateStudentMobRequestDto);
    }

    // delete a student by id

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id) {
        return studentService.deleteStudentById(id);
    }

    // update the student by id

    @GetMapping("/get_student")
    public StudentResponseDto getStudent(@RequestParam("id") int id){
        return studentService.getStudentById(id);
    }

    // find all the students
//    ResponseEntity<List<StudentResponseDto>>
    @GetMapping("/all")
    public ResponseEntity<List<GetAllStudentResponseDto>> getAllStudents() {
        List<GetAllStudentResponseDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }


}
