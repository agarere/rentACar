package agarere.io.rentACar.business.abstracts;

import agarere.io.rentACar.business.requests.CreateBrandRequest;
import agarere.io.rentACar.business.responses.GetAllBrandsResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest createBrandRequest);
}
