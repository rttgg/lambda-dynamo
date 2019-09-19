package lambda.dynamo;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.lambda.runtime.Context;
import lambda.dynamo.Models.History;
import lambda.dynamo.Models.Task;

import java.util.ArrayList;

public class updateController {
    private DynamoDB dynamoDb;
    private String DYNAMODB_TABLE_NAME = "task";
    private Regions REGION = Regions.US_WEST_2;

    public Task saveNewTask(Task task, Context context) {


        ArrayList<History> historyArrayList = new ArrayList<>();
        task.setHistoryArrayList(historyArrayList);
        task.setNewHistory(new History("Task: " + task.getDescription() + " was added"));
        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper ddbMapper = new DynamoDBMapper(ddb);


        ddbMapper.save(task);



        return task;
    }

}
