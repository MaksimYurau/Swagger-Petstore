package by.maksim.petstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private int id;
    @NotEmpty
    @NotBlank
    private Category category;
    @NotEmpty
    @NotBlank
    private String name;
    @NotEmpty
    @NotBlank
    private List<Tag> tags;
    @NotEmpty
    @NotBlank
    private Status status;
}
