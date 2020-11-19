package by.maksim.petstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    @NotBlank
    @OneToOne
    private Category category;
    @NotEmpty
    @NotBlank
    private String name;
    @NotEmpty
    @NotBlank
    @OneToMany
    private List<Tag> tags;
    @NotEmpty
    @NotBlank
    private Status status;
}
