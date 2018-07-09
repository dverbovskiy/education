package boot.dynamodb.model;

import boot.dynamodb.config.TableNameResolver;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.google.common.base.Objects;

import java.io.Serializable;

@TableNameResolver("dynamodb.table.name.user")
@DynamoDBTable(tableName = "THIS_SHOULD_BE_REPLACED_FROM_PROPERTY_FILE")
public class User implements Serializable {

    private String id;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String name, String lastName) {
        this.firstName = name;
        this.lastName = lastName;
    }

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    @DynamoDBAttribute
    public String getFirstName() {
        return firstName;
    }

    @DynamoDBAttribute
    public String getLastName() {
        return lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equal(getId(), user.getId())
                && Objects.equal(getFirstName(), user.getFirstName())
                && Objects.equal(getLastName(), user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "User{"
                + "id='" + id + '\''
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + '}';
    }
}