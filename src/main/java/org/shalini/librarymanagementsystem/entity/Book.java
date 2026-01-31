package org.shalini.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private long isbn;

    private String author;

    private String category;

    @Column(name = "added_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date addedDate;

    @Column(name = "total_copies")
    private int totalCopies;

    private String publisher;

}
