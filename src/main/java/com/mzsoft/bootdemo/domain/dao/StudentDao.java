package com.mzsoft.bootdemo.domain.dao;

import com.mzsoft.bootdemo.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student,Long> {
    Student findById(Long id);
    Student findByName(String name);
}
