package com.dsm.library.service;

import com.dsm.library.controller.response.LibraryResponse;
import com.dsm.library.domain.library.Library;
import com.dsm.library.domain.library.LibraryRepository;
import com.dsm.library.exception.LibraryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibrarySearchService {
    private final LibraryRepository libraryRepository;

    public List<LibraryResponse.Library> test() {
        List<LibraryResponse.Library> libraries = libraryRepository.findAll()
                .stream()
                .map(library -> new LibraryResponse.Library(library.getId(), library.getName(), library.getFoundingYear()))
                .collect(Collectors.toList());

        return libraries;
    }

    public Library getLibrary(long libraryId) {
        return libraryRepository.findById(libraryId)
                .orElseThrow(() -> new LibraryNotFoundException(libraryId));
    }
}