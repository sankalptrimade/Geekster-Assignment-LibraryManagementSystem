package com.example.LibraryManagement.service;

import com.example.LibraryManagement.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class LibraryService {

    private static List<Library> libraries = new ArrayList<>();
    private static int count=1;
    static {
        libraries.add(new Library(count++, "Academic-libraries.", "New Shanti vihar", 98563274, "Separate Reading Hall.",  250));
        libraries.add(new Library(count++, "National-libraries.", "New Shankar Nagar", 89745689, "Digital library and Internet Facility.", 100));
        libraries.add(new Library(count++, "Public-lending-libraries.", "Marine Drive", 74586321, "Open Access for all students.", 100));
        libraries.add(new Library(count++, "Universal-libraries.", "Telibandha Colony", 58796231, "Photocopy and printing facility.", 150));
        libraries.add(new Library(count++, "New-Accounts-library.", "Shri Ram Nagar", 25896314, "Book bank facility for needy and SC/ST student", 350));
    }

    public List<Library> findAll(){
        return libraries;
    }

    public Library findByName(String name){
        Predicate<? super Library> predicate = library -> library.getLibraryName().equals(name);
        Library library = libraries.stream().filter(predicate).findFirst().get();
        return library;
    }

    public void addLibrary(Library library){
        libraries.add(library);
    }

    public void updateLibrary(String name, Library newLibrary){
        Library library = findByName(name);

        library.setId(newLibrary.getId());
        library.setLibraryName(newLibrary.getLibraryName());
        library.setLibraryAddress(newLibrary.getLibraryAddress());
        library.setLibraryNumber(newLibrary.getLibraryNumber());
        library.setLibraryFacilities(newLibrary.getLibraryFacilities());
        library.setSeatingCapacity(newLibrary.getSeatingCapacity());
    }

    public void deleteLibrary(String name){
        Predicate<? super Library> predicate = library -> library.getLibraryName().equals(name);
        libraries.removeIf(predicate);
    }
}
