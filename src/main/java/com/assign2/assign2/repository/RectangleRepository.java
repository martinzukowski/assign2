package com.assign2.assign2.repository;

import com.assign2.assign2.models.Rectangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RectangleRepository extends JpaRepository<Rectangle, Long> {
}
