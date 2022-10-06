package com.example.taller_login_manuel_paredes;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    Button register;
    ProgressBar loadingPB;
    EditText nombre, password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        register = (Button) findViewById(R.id.RegisterButton);
        nombre = (EditText) findViewById(R.id.nameInput);
        email = (EditText) findViewById(R.id.emailInput);
        password = (EditText) findViewById(R.id.passwordInput);
        loadingPB = findViewById(R.id.idLoadingPB);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nombre.getText().toString().isEmpty()
                        && email.getText().toString().isEmpty()
                        && password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please complete all the fields!", Toast.LENGTH_SHORT).show();
                }
              /*  Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
                startActivity(intent);*/

                Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                postData(nombre.getText().toString(), email.getText().toString(), password.getText().toString());
            }
        });
    }

    private void postData(String nombrePost, String emailPost, String passwordPost) {

        String url = "http://localhost:8080/guardar";
        loadingPB.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        JSONObject resObj = new JSONObject();
        try {
            resObj.put("nombre", nombrePost);
            resObj.put("email", emailPost);
            resObj.put("password", passwordPost);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String reqBody = resObj.toString();
        Log.e("Test...", resObj.toString());

        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
        try {
            JSONObject myObj = new JSONObject(response);
            myObj.getString("1...2...3");

        }catch (JSONException e){
            e.printStackTrace();
        }
     }
                , error -> {
            Toast.makeText(MainActivity.this, "Fail to get response  " + error, Toast.LENGTH_SHORT).show();
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {

                try {
                    return reqBody.getBytes(StandardCharsets.UTF_8);
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {

                String responseString = "";
                if (response != null) {
                    responseString = String.valueOf(response.statusCode);
                }
                return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
            }
        };
        queue.add(request);
    }


}
   /*new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loadingPB.setVisibility(View.GONE);
                nombre.setText("");
                email.setText("");
                password.setText("");
                try {
                    JSONObject resObj = new JSONObject(response);
                    String nameObj = resObj.getString("name");

                    String emailObj = resObj.getString("email");
                    String passObj = resObj.getString("password");

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }*/