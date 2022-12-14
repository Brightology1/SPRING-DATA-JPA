package com.brightology.springdatajpa.repository;

import com.brightology.springdatajpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository <CourseMaterial, Long> {
}
