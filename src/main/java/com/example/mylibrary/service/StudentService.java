package com.example.mylibrary.service;

import com.example.mylibrary.DTO.RequestDto.StudentRequestDto;
import com.example.mylibrary.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.mylibrary.DTO.ResponsDto.GetAllStudentResponseDto;
import com.example.mylibrary.DTO.ResponsDto.StudentResponseDto;
import com.example.mylibrary.DTO.ResponsDto.UpdateStudentMobResponseDto;
import com.example.mylibrary.entity.Student;
import com.example.mylibrary.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    public String addStudent(StudentRequestDto studentRequestDto);
    public String deleteStudentById(int id);
    public List<GetAllStudentResponseDto> getAllStudents();

    public StudentResponseDto getStudentById(int id);

    public UpdateStudentMobResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException;
}
