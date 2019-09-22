package org.lampropoul.jobsfeeder.helpers;

import org.lampropoul.jobsfeeder.errors.Error;
import org.lampropoul.jobsfeeder.model.BaseObject;
import org.lampropoul.jobsfeeder.services.SequenceGeneratorService;
import org.springframework.data.mongodb.repository.MongoRepository;

public class ControllersHelper<FeederRepo extends MongoRepository<FeederModel, Long>, FeederModel extends BaseObject> {

    public Response<FeederModel> generateResponse(FeederRepo feederRepo, FeederModel feederModel, SequenceGeneratorService sequenceGeneratorService) {
        Response<FeederModel> response = new Response<>();
        Long modelId = (feederModel.getId() != null) ? feederModel.getId() : 0L;
        if (feederRepo.existsById(modelId)) {
            response.setError(new Error("1", "FeederModel already exists. Check the id you provided."));
        } else {
            feederModel.setId(sequenceGeneratorService.generateSequence(BaseObject.SEQUENCE_NAME));
            response.setObject(feederRepo.save(feederModel));
        }
        return response;
    }
}
