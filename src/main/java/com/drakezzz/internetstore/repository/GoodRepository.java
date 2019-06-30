package com.drakezzz.internetstore.repository;

import com.drakezzz.internetstore.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodRepository extends JpaRepository<Good, Long> {

    List<Good> findByCategory(Long categoryId);

}
