package by.maksim.petstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private int id;
    private int petId;
    private int quantity;
    @NotEmpty
    @NotBlank
    private String shipDate;
    @NotEmpty
    @NotBlank
    private OrderStatus orderStatus;
    @NotEmpty
    @NotBlank
    private boolean complete;
}
