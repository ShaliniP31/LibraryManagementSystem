package org.shalini.librarymanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.shalini.librarymanagementsystem.dto.BookDTO;
import org.shalini.librarymanagementsystem.entity.Book;

@Mapper
public interface BookMapper{

    BookDTO convertToBookDTO(Book book);

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "addedDate", ignore = true)
    Book convertToBook(BookDTO bookDTO);
}
