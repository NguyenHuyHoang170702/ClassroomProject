package com.hoangdev.Classroom.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String content;
    private Date timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "news_id", referencedColumnName = "id", nullable = false)
    private News news;


    @Override
    public int hashCode() {
        return Objects.hash(id, content, timestamp);
    }
}
