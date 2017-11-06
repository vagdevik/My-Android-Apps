package com.example.vubuntu.indianstates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] states = {"Andaman & Nicobar Islands (UT)","Andhra Pardesh","Arunachal Pradesh","Assam","Bihar","Chandigarh (UT)","Chhattisgarh","Dadra and Nagar Haveli (UT)","Daman and Diu (UT)","Delhi (UT)","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Lakshadweep (UT)","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Orissa","Pondicherry (UT)","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttaranchal","Uttar Pradesh","West Bengal"};
        String[] capitals = {" Port Blair","Amaravati","Itanagar","Dispur","Patna","Chandigarh","Raipur"," Silvasa","Daman","New Delhi", "Panaji","Gandhinagar","Chandigarh","Shimla"," Srinagar (Winter : Jammu)","Ranchi","Bangalooru","Tirubanantapuram","Kavaratti","Bhopal","Mumbai","Imphal","Shillong","Aizawl"," Kohima","Bhubaneswar","Pondicherry","Chandigarh","Jaipur","Gangtok","Chennai","Hyderabad","Agartala","Dehradun","Lucknow"," Kolkata"};

        final ArrayList statesArrayList = new ArrayList(Arrays.asList(states));
        final ArrayList capitalArrayList = new ArrayList(Arrays.asList(capitals));

        ListView listView = (ListView) findViewById(R.id.myListView);

        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,statesArrayList);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,capitalArrayList);

        listView.setAdapter(arrayAdapter1);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Capital of "+statesArrayList.get(i)+" : "+capitalArrayList.get(i),Toast.LENGTH_SHORT).show();
            }
        });


    }

}
