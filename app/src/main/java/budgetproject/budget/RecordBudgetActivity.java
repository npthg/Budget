package budgetproject.budget;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class RecordBudgetActivity extends AppCompatActivity {
    private FirstPageActivity first ;
    private TextView textView ;
    private EditText editText ;
    private String getExpense ;
    private String showDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_budget);
        bindWidget();
    }
    public void clickUpdate(View view){
        getExpense = editText.getText().toString().trim();
        if(getExpense.equals("")){
            showAlert();
        }else{
            conFirmData();
        }
    }

    private void conFirmData() {
        BudgetTable budgetTable = new BudgetTable(this);
        long insertData = budgetTable.addValToSQLite(showDate,Double.parseDouble(getExpense));
        editText.setText("");

    }

    private void showAlert() {

    }

    private void bindWidget() {
        editText = (EditText) findViewById(R.id.editText);

    }
}
