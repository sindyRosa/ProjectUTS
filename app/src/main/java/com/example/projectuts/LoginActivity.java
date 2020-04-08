package com.example.projectuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectuts.models.session;
import com.google.android.material.snackbar.Snackbar;

class LoginActivity extends AppCompatActivity {
    private EditText usernameInput;
    private EditText passwordInput;
    private session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);

        session = Application.getSession();
        if (session.isKeepUsername()) {
            usernameInput.setText(session.getUsername());
        }
    }
    public void btnSignIn(View view) {

        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        boolean success = session.validate(username, password);
        if (success) {
            if (session.isKeepUsername()) {
                session.setUsername(username);
            }
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Snackbar.make(view, "Authentication Failed", Snackbar.LENGTH_SHORT).show();
        }
    }
}
