package kz.bitlab.G115sprinttask3.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;
}
