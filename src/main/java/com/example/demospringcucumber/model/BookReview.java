package com.example.demospringcucumber.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author aroussi
 * @version %I% %G%
 */
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "book_review")
public class BookReview implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookTitle;
    private String bookImagePath;

    @OneToMany(cascade = CascadeType.ALL)
    @BatchSize(size = 20)
    private Set<Comment> comments;
}
