package gcg.akula.entity.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MembershipRequest {

    protected Long consumerId;

    protected Long resourceId;



    /*
    * 1 - User
    * 2 - Department
    *
    * TODO: переделать на ENUM
    * */
    protected Integer consumerType;

    /*
     * 1 - Course
     *
     * TODO: переделать на ENUM
     * */
    protected Integer resourceType;

    public MembershipRequest() {
    }

    public MembershipRequest(Long consumerId, Long resourceId, Integer consumerType, Integer resourceType) {
        this.consumerId = consumerId;
        this.resourceId = resourceId;
        this.consumerType = consumerType;
        this.resourceType = resourceType;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getConsumerType() {
        return consumerType;
    }

    public void setConsumerType(Integer consumerType) {
        this.consumerType = consumerType;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
}
