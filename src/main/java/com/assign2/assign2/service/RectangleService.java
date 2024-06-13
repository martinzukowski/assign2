package com.assign2.assign2.service;

import com.assign2.assign2.models.Rectangle;
import com.assign2.assign2.repository.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RectangleService {

    @Autowired
    private RectangleRepository rectangleRepository;

    public List<Rectangle> findAll() {
        return rectangleRepository.findAll();
    }

    public Optional<Rectangle> findById(Long id) {
        return rectangleRepository.findById(id);
    }

    public Rectangle save(Rectangle rectangle) {
        return rectangleRepository.save(rectangle);
    }

    public void deleteById(Long id) {
        rectangleRepository.deleteById(id);
    }
}
