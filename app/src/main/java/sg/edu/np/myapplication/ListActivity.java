package sg.edu.np.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView img = (ImageView) findViewById(R.id.ImageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this)
                        .setTitle("Profile")
                        .setMessage("MADness")
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                final Random rand = new Random();
                                int random = rand.nextInt(9999);
                                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                                myIntent.putExtra("random", random);
                                ListActivity.this.startActivity(myIntent);
                            }
                        })
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        ArrayList<User> data = new ArrayList<User>();
        for(int i=0; i<20; i++) {
            User u = new User();
            final Random rand = new Random();
            int random = rand.nextInt(999999999);
            u.setName("Name" + random);
            final Random rand2 = new Random();
            int random2 = rand.nextInt(999999999);
            u.setDescription("Description" + random2);

            data.add(u);
        }

        RecyclerView rv = findViewById(R.id.rv);
        UserAdapter adapter = new UserAdapter(this, data);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }
}