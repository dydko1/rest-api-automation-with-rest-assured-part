package com.studentapp.tests2section4;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class StudentPojo1 {
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> courses;
}
