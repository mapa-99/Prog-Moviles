package com.example.taller_login_manuel_paredes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Button register;
    private ProgressBar loadingPB;
    private EditText name, user, password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        register = (Button) findViewById(R.id.RegisterButton);
        name = (EditText) findViewById(R.id.nameInput);
        user = (EditText) findViewById(R.id.userInput);
        email = (EditText) findViewById(R.id.emailInput);
        password = (EditText) findViewById(R.id.passwordInput);
        loadingPB = findViewById(R.id.idLoadingPB);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty()
                        && user.getText().toString().isEmpty()
                        && email.getText().toString().isEmpty()
                        && password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please complete all the fields!", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                postData(name.getText().toString(),user.getText().toString(), email.getText().toString(), password.getText().toString() );
            }
        });
    }

    private void postData(String namePost, String userPost, String emailPost, String passwordPost){
        String url= "http://localhost:880/guardar";
        loadingPB.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loadingPB.setVisibility(View.GONE);
                name.setText("");
                user.setText("");
                email.setText("");
                password.setText("");
                try {
                    JSONObject resObj = new JSONObject(response);
                    String nameObj = resObj.getString("name");
                    String userObj = resObj.getString("user");
                    String emailObj = resObj.getString("email");
                    String passObj = resObj.getString("password");

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Fail to get response  "+error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }


}