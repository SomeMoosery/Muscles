package carter.muscles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ChooseCollege extends AppCompatActivity {

    private String TAG = "ChooseCollege: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_college);

        populateListview();
        registerClickCallback();
    }

    private void populateListview() {
        //List of colleges
        String[] colleges = {
                //Big 10, SEC, Pac-12 included
                "University of Alabama",
                "University of Arizona",
                "Arizona State University",
                "Auburn University",
                "University of Arkansas",
                "University of California, Berkeley",
                "University of California, Los Angeles",
                "University of Colorado, Boulder",
                "University of Florida",
                "University of Georgia",
                "University of Illinois",
                "Indiana University",
                "University of Iowa",
                "University of Kentucky",
                "Louisiana State University",
                "University of Maryland",
                "University of Michigan",
                "Michigan State University",
                "University of Minnesota",
                "University of Mississippi",
                "Mississippi State University",
                "University of Missouri",
                "University of Nebraska",
                "Northwestern University",
                "Ohio State University",
                "University of Oregon",
                "Oregon State University",
                "Pennsylvania State University",
                "Purdue University",
                "Rutgers University",
                "University of South Carolina",
                "University of Southern California",
                "Stanford University",
                "University of Tennessee",
                "Texas A&M University",
                "University of Utah",
                "University of Washington",
                "Washington State University",
                "THE University of Wisconsin",
                "Vanderbilt University"};

        //Build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.colleges_list,
                colleges);

        //Configure ListView
        ListView collegeList = (ListView) findViewById(R.id.college_list_view);
        collegeList.setAdapter(adapter);
        }

        //Click handler
        private void registerClickCallback() {
            ListView list = (ListView) findViewById(R.id.college_list_view);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView tv = (TextView) view;
                    String collegeClicked = tv.getText().toString().trim();
                    getApplication().setTheme(R.style.WisconsinTheme);
                    Log.i("Test", "Working");
                    //recreate();
                }
            });
        }
    }
