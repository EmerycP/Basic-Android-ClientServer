package com.emerycp.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Service s;
    LoginRequest lR = new LoginRequest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitHelper.getReal();
        s = RetrofitHelper.service;

        Button btnInit = findViewById(R.id.init);
        Button btnCreate = findViewById(R.id.create);
        Button btnMoney = findViewById(R.id.money);
        Button btnCombien = findViewById(R.id.combienBtn);

        Button btnCookie = findViewById(R.id.Cookie);
        Button btnManger = findViewById(R.id.Manger);

        final EditText etUser = findViewById(R.id.username);
        final TextView tvUser = findViewById(R.id.textUser);

        final EditText etId = findViewById(R.id.numberET);
        final TextView tvRicher = findViewById(R.id.combienText);

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.toInit().enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.isSuccessful())
                            Toast.makeText(getApplicationContext(), "Creation des utilisateurs du Init réussie!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                lR.user = etUser.getText().toString();
                s.toCreate(lR).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if(response.isSuccessful())
                        {
                            tvUser.setText("Création de l\'utilisateur " + lR.user);
                            etUser.setText("");
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
            }
        });

        btnMoney.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                lR.user = etUser.getText().toString();
                s.toClick(lR).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful())
                        {
                            tvUser.setText("Vous avez ajouter 1$ à l\'utilisateur " + lR.user + ". \n Il possède maintenant " + response.body().count +" $!");
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });

        btnCombien.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(etId.getText().toString());
                s.toMany(id).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful())
                        {
                            tvRicher.setText("L\'utilisateur à cet ID possède " + response.body().count +" $! \n (Il faut garder l\'anonymat :D)");
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });

        btnCookie.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                s.toCookie().enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        if(response.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "Creation du cookie " + response.body().token, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {

                    }
                });
            }
        });
        btnManger.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                s.toDelete().enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if(response.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "Suppression du cookie", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
            }
        });
    }
}
