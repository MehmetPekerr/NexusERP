package com.example.mimari.repository;

import model.UrunTanitimPlanlari;
import model.UrunTanitimPlanlari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrunTanitimPlanlariRepository extends JpaRepository<UrunTanitimPlanlari, Long> {
}
