package org.shalini.librarymanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    @JsonProperty("title")
    private String title;

    @JsonProperty("ISBN")
    private long isbn;

    @JsonProperty("author")
    private String author;

    @JsonProperty("category")
    private String category;

    @JsonProperty("totalCopies")
    private int totalCopies;

//    @JsonProperty("publisher")
    private String publisher;

}
