package budgetproject.budget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FirstPageActivity extends AppCompatActivity {
    private EditText budgetText , goalText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        budgetText = (EditText) findViewById(R.id.budget_text);
        goalText = (EditText) findViewById(R.id.goal_text);
    }
    public void clickOK(View view){
        BudgetTable budgetTable = new BudgetTable(this);
        budgetTable.addValToSQLite(goalText.getText().toString(),getbudgetText());
        Intent intent = new Intent(FirstPageActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public double getbudgetText(){
        return Double.parseDouble(budgetText.getText().toString()) ;

    }
}
