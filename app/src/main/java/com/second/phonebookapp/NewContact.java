package com.second.phonebookapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.second.phonebookapp.databinding.UserDetailsBinding;

public class NewContact extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details);
        UserDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.user_details);

        User user = new User();
        binding.setUser(user);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user.getUsername();
                String phonenumber = user.getPhonenumber();
                String groupuser = user.getGroupuser();

                if (!username.isEmpty() && !phonenumber.isEmpty() && !groupuser.isEmpty()) {
                    DatabaseReference dbref = FirebaseDatabase.getInstance().getReference("contacts");
                    String contactid = dbref.push().getKey();
                    User sample = new User(username, phonenumber, groupuser);
                    dbref.child(contactid).setValue(sample);

                    Toast.makeText(NewContact.this, "Added data successfully", Toast.LENGTH_SHORT).show();

                    // Clear the input fields or create a new User object to bind to the layout
                    user.setUsername("");
                    user.setPhonenumber("");
                    user.setGroupuser("");
                } else {
                    Toast.makeText(NewContact.this, "Entry should not be null", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
