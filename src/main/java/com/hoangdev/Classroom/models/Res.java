package com.hoangdev.Classroom.models;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Res {
    private int status;
    private String message;
    private String url;
}
