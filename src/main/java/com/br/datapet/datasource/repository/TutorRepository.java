package com.br.datapet.datasource.repository;

import com.br.datapet.datasource.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TutorRepository extends JpaRepository<Tutor, UUID> {
}
