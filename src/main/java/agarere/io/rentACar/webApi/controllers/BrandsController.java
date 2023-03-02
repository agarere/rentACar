package agarere.io.rentACar.webApi.controllers;

import agarere.io.rentACar.business.abstracts.BrandService;
import agarere.io.rentACar.business.requests.CreateBrandRequest;
import agarere.io.rentACar.business.responses.GetAllBrandsResponse;
import agarere.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
        brandService.add(createBrandRequest);
    }
}
