package agarere.io.rentACar.business.abstracts;

import agarere.io.rentACar.business.requests.CreateModelRequest;
import agarere.io.rentACar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
