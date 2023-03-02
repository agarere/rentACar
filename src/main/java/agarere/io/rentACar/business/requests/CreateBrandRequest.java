package agarere.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Response Request Pattern
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
    private String name;
}
