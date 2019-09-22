package org.lampropoul.jobsfeeder.helpers;

import org.lampropoul.jobsfeeder.errors.ErrorCode;
import org.lampropoul.jobsfeeder.model.BaseObject;
import org.lampropoul.jobsfeeder.services.SequenceGeneratorService;
import org.springframework.data.mongodb.repository.MongoRepository;

public class ControllersHelper<FeederRepo extends MongoRepository<FeederModel, Long>, FeederModel extends BaseObject> {

    public Response<FeederModel> generateResponse(FeederRepo feederRepo, FeederModel feederModel, SequenceGeneratorService sequenceGeneratorService) {
        Response<FeederModel> response = new Response<>();
        Long modelId = (feederModel.getId() != null) ? feederModel.getId() : 0L;
        if (feederRepo.existsById(modelId)) {
            response.setErrorCode(ErrorCode.ERROR_EXISTS);
        } else {
            feederModel.setId(sequenceGeneratorService.generateSequence(BaseObject.SEQUENCE_NAME));
            response.setObject(feederRepo.save(feederModel));
        }
        return response;
    }
}
