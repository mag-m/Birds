package mag.birds;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText EditTextEmailLogin;
    private EditText EditTextPasswordLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditTextEmailLogin = findViewById(R.id.LoginEditTextEmail);
        EditTextPasswordLogin = findViewById(R.id.LoginEditTextPassword);
        mAuth = FirebaseAuth.getInstance();
    }

    public void LoginClicked(View view) {
        final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this,"Loading...","Proccessing...",true);

        (mAuth.signInWithEmailAndPassword(EditTextEmailLogin.getText().toString(), EditTextPasswordLogin.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login succesfull", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            i.putExtra("Email", mAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        }

                        else {
                            Log.e("Error", task.getException().toString());
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
