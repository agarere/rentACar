package agarere.io.rentACar.business.abstracts;

import agarere.io.rentACar.business.requests.CreateBrandRequest;
import agarere.io.rentACar.business.requests.UpdateBrandRequest;
import agarere.io.rentACar.business.responses.GetAllBrandsResponse;
import agarere.io.rentACar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
