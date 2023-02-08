package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.model.Library;
import com.example.LibraryManagement.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/library-management")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("findAll")
    public List<Library> findAll(){
        return libraryService.findAll();
    }
    @GetMapping("find/name/{name}")
    public Library findByName(@PathVariable String name){
       return libraryService.findByName(name);
    }
    @PostMapping("addLibrary")
    public void addLibrary(@RequestBody Library library){
        libraryService.addLibrary(library);
    }

    @PutMapping("update-library/name/{name}")
    public void updateLibrary(@PathVariable String name, @RequestBody Library library){
        libraryService.updateLibrary(name, library);
    }
    @DeleteMapping("delete-library/name/{name}")
    public void deleteLibrary(@PathVariable String name){
        libraryService.deleteLibrary(name);
    }

}
