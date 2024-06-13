package com.assign2.assign2.controllers;

import com.assign2.assign2.models.Rectangle;
import com.assign2.assign2.service.RectangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/rectangles")
public class RectangleController {

    @Autowired
    private RectangleService rectangleService;

    @GetMapping
    public String listRectangles(Model model) {
        model.addAttribute("rectangles", rectangleService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createRectangleForm(Model model) {
        model.addAttribute("rectangle", new Rectangle());
        return "create";
    }

    @PostMapping
    public String createRectangle(@ModelAttribute Rectangle rectangle) {
        System.out.println("Received Rectangle object in createRectangle method: " + rectangle);
        rectangleService.save(rectangle);
        return "redirect:/rectangles";
    }

    @GetMapping("/edit/{id}")
    public String editRectangleForm(@PathVariable Long id, Model model) {
        Optional<Rectangle> rectangle = rectangleService.findById(id);
        if (rectangle.isPresent()) {
            model.addAttribute("rectangle", rectangle.get());
            return "edit";
        } else {
            return "redirect:/rectangles";
        }
    }

    @PostMapping("/edit/{id}")
    public String editRectangle(@PathVariable Long id, @ModelAttribute Rectangle rectangle) {
        rectangle.setId(id);
        System.out.println("Received Rectangle object in editRectangle method: " + rectangle);
        rectangleService.save(rectangle);
        return "redirect:/rectangles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRectangle(@PathVariable Long id) {
        rectangleService.deleteById(id);
        return "redirect:/rectangles";
    }

    @GetMapping("/{id}")
    public String viewRectangle(@PathVariable Long id, Model model) {
        Optional<Rectangle> rectangle = rectangleService.findById(id);
        if (rectangle.isPresent()) {
            model.addAttribute("rectangle", rectangle.get());
            return "view";
        } else {
            return "redirect:/rectangles";
        }
    }

    @PostMapping("/{id}")
    public String updateRectangle(@PathVariable Long id, @ModelAttribute Rectangle rectangle) {
        rectangle.setId(id);
        System.out.println("Received Rectangle object in updateRectangle method: " + rectangle);
        rectangleService.save(rectangle);
        return "redirect:/rectangles";
    }
}
