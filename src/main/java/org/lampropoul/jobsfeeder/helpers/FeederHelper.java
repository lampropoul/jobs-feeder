package org.lampropoul.jobsfeeder.helpers;

import org.jetbrains.annotations.NotNull;
import org.lampropoul.jobsfeeder.model.BaseObject;
import org.lampropoul.jobsfeeder.services.SequenceGeneratorService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FeederHelper<FeederRepo extends MongoRepository<FeederModel, Long>, FeederModel extends BaseObject> {

    private SequenceGeneratorService sequenceGeneratorService;

    public FeederHelper(SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public ResponseEntity<FeederModel> saveAndGenerateResponse(@NotNull FeederRepo feederRepo, @NotNull FeederModel feederModel) {
        Long id = (feederModel.getId() != null) ? feederModel.getId() : 0L;
        HttpStatus status = HttpStatus.OK;
        if (!feederRepo.existsById(id)) {
            feederModel.setId(sequenceGeneratorService.generateSequence(BaseObject.SEQUENCE_NAME));
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(feederRepo.save(feederModel), status);
    }
}
