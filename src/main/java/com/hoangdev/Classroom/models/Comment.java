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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(content, comment.content) && Objects.equals(timestamp, comment.timestamp);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, content, timestamp);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
