package budgetproject.budget;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private BudgetTable budgetTable ;
    private double budget = 0 , firstBudget ;
    private TextView showBudget ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBudget = (TextView) findViewById(R.id.budget_text);
        connectedDatabase();
        firstBudget = budgetTable.currentBudget();
        setCurrentBudget();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        setCurrentBudget();
    }
    private void setCurrentBudget() {
        if (budgetTable.currentBudget()==firstBudget) {
            showBudget.setText(Double.toString(firstBudget));
        } else {
            budget = budgetTable.currentBudget();
            firstBudget -= budget;
            showBudget.setText(Double.toString(firstBudget));
        }
    }
    public void clickExpense(View view){
            Intent intent = new Intent(MainActivity.this, RecordBudgetActivity.class);
            startActivity(intent);
    }
    public void clickHistory(View view){
        Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
        startActivity(intent);
    }

    private void testUpdate() {
         budgetTable.addValToSQLite("test" , 10.00);
    }

    private void connectedDatabase() {
        budgetTable = new BudgetTable(this);
    }
}
