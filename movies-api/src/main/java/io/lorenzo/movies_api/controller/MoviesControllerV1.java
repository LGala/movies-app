package io.lorenzo.movies_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/movies/v1")
@Controller()
public class MoviesControllerV1 {

    @GetMapping("")
    @ResponseBody
    public String getAll() {
        return "Hello World!";
    }

    @PostMapping("")
    @ResponseBody
    public String create() {
        return "Hello World!";
    }

    @DeleteMapping("/:id")
    @ResponseBody
    public String delete() {
        return "Hello World!";
    }

    @PutMapping("/:id")
    @ResponseBody
    public String edit() {
        return "Hello World!";
    }
}
