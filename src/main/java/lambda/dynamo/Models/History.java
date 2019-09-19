package lambda.dynamo.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.text.SimpleDateFormat;
import java.util.Date;

@DynamoDBDocument
public class History {
    Date dateOfAction;
    String advancement;

    public History() {}

    public History(String advancement) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        this.dateOfAction = date;
        this.advancement = advancement;
    }

    public Date getDateOfAction() {
        return dateOfAction;
    }

    public void setDateOfAction(Date dateOfAction) {
        this.dateOfAction = dateOfAction;
    }

    public String getAdvancement() {
        return advancement;
    }

    public void setAdvancement(String advancement) {
        this.advancement = advancement;
    }
}
