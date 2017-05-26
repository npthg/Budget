package budgetproject.budget;

import android.app.ListActivity;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HistoryActivity extends ListActivity{
    private BudgetTable budgetTable ;
    private SimpleCursorAdapter simpleAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_history);

        budgetTable = new BudgetTable(this);
        createListView();
    }

    private void createListView() {
        Cursor ListDate = budgetTable.readAllData();
        String[] form = new String[]{BudgetTable.COLUMN_EXPENSE};
        int[] target = new int[]{R.id.textListDate};
        simpleAdapter = new SimpleCursorAdapter(this,R.layout.activity_history,ListDate,form,target);
        setListAdapter(simpleAdapter);
    }

}
