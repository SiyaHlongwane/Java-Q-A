package com.example.javaqa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class forgotPassword extends AppCompatActivity {

    private EditText forgotEmail, newPassword, confirmNewPassword;
    private Button btnResetPassword;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        // Initialize DBHelper
        db = new DBHelper(this);

        // Initialize UI components
        forgotEmail = findViewById(R.id.forgot_email);
        newPassword = findViewById(R.id.new_password);
        confirmNewPassword = findViewById(R.id.confirm_new_password);
        btnResetPassword = findViewById(R.id.btn_reset_password);

        // Handle Reset Password button click
        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = forgotEmail.getText().toString().trim();
                String password = newPassword.getText().toString().trim();
                String confirmPassword = confirmNewPassword.getText().toString().trim();

                // Check if email exists
                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(forgotPassword.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(forgotPassword.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Verify if the email exists in the database
                    boolean isUserExists = db.checkUserEmail(email);
                    if (isUserExists) {
                        // Update the password in the database
                        boolean isPasswordUpdated = db.updatePassword(email, password);
                        if (isPasswordUpdated) {
                            Toast.makeText(forgotPassword.this, "Password reset successfully", Toast.LENGTH_SHORT).show();
                            // Redirect to login activity after successful password reset
                            Intent intent = new Intent(forgotPassword.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(forgotPassword.this, "Failed to reset password. Try again.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(forgotPassword.this, "No account found with this email", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
