package com.drakezzz.internetstore.repository;

import com.drakezzz.internetstore.entity.GoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<GoodCategory, Long> {
}
