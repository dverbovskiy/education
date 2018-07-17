package boot.dynamodb.model;

import boot.dynamodb.util.TableNameResolver;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.google.common.base.Objects;

import java.util.List;

@TableNameResolver("dynamodb.table.name.review")
@DynamoDBTable(tableName = "THIS_SHOULD_BE_REPLACED_FROM_PROPERTY_FILE")
public class Review {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute
    private String reviewId;

    @DynamoDBAttribute
    private String createDate;

    @DynamoDBAttribute
    private Owner reviewOwner;

    @DynamoDBAttribute
    private List<Asset> assets;

    public String getId() {
        return id;
    }

    public Review setId(String id) {
        this.id = id;
        return this;
    }

    public String getReviewId() {
        return reviewId;
    }

    public Review setReviewId(String reviewId) {
        this.reviewId = reviewId;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public Review setCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    public Owner getReviewOwner() {
        return reviewOwner;
    }

    public Review setReviewOwner(Owner reviewOwner) {
        this.reviewOwner = reviewOwner;
        return this;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public Review setAssets(List<Asset> assets) {
        this.assets = assets;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Review review = (Review) o;
        return Objects.equal(getId(), review.getId())
                && Objects.equal(getReviewId(), review.getReviewId())
                && Objects.equal(getCreateDate(), review.getCreateDate())
                && Objects.equal(getReviewOwner(), review.getReviewOwner())
                && Objects.equal(getAssets(), review.getAssets());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getReviewId(), getCreateDate(), getReviewOwner(), getAssets());
    }

}
