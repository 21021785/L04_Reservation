package sg.edu.rp.c346.id21021785.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Date;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText number;
    EditText group;
    CheckBox smoking;
    DatePicker date;
    TimePicker time;
    Button submit;
    Button reset;
    TextView nameconfirm;
    TextView numberconfirm;
    TextView groupconfirm;
    TextView smokingconfirm;
    TextView dateconfirm;
    TextView timeconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameinput);
        number = findViewById(R.id.numberinput);
        group = findViewById(R.id.groupinput);
        smoking = findViewById(R.id.smokinginput);
        date = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);
        submit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);
        nameconfirm = findViewById(R.id.nameconfirm);
        numberconfirm = findViewById(R.id.numberconfirm);
        groupconfirm = findViewById(R.id.groupconfirm);
        smokingconfirm = findViewById(R.id.smokingconfirm);
        dateconfirm = findViewById(R.id.dateconfirm);
        timeconfirm = findViewById(R.id.timeconfirm);

        date.updateDate(2020, 5, 1);
        time.setCurrentHour(19);
        time.setCurrentMinute(30);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty() || number.getText().toString().isEmpty() || group.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,"Incomplete reservation form, please check all if inputs are filled in", Toast.LENGTH_SHORT).show();
                    nameconfirm.setText("Incomplete reservation form, please check all if inputs are filled in");
                    numberconfirm.setText("");
                    groupconfirm.setText("");
                    smokingconfirm.setText("");
                    dateconfirm.setText("");
                    timeconfirm.setText("");

                } else {
                    String newSmoking = "No";
                    if (smoking.isChecked()) {
                        newSmoking = "Yes";
                    } else {
                        newSmoking = "No";
                    }
                    Toast.makeText(MainActivity.this,"Name: " + name.getText().toString() + "\nMobile Number: " + number.getText().toString() + "\nGroup Size: " + group.getText().toString() + "\nSmoking Area: " + newSmoking + "\nDate: " + date.getDayOfMonth() + "/" + date.getMonth() + 1 + "/" + date.getYear() + "\nTime: " + time.getCurrentHour() + ":" + time.getCurrentMinute(), Toast.LENGTH_LONG).show();
                    nameconfirm.setText("Name: " + name.getText().toString());
                    numberconfirm.setText("Mobile Number: " + number.getText().toString());
                    groupconfirm.setText("Group Size: " + group.getText().toString());
                    smokingconfirm.setText("Smoking Area: " + newSmoking);
                    dateconfirm.setText("Date: " + date.getDayOfMonth() + "/" + (date.getMonth() + 1) + "/" + date.getYear());
                    timeconfirm.setText("Time: " + time.getCurrentHour() + ":" + time.getCurrentMinute());

                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                number.setText("");
                group.setText("");
                smoking.setChecked(false);
                date.updateDate(2020, 5, 1);
                time.setCurrentHour(19);
                time.setCurrentMinute(30);

            }
        });

    }
}