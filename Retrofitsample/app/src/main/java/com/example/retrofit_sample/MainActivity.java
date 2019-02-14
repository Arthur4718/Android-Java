package com.example.retrofit_sample;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.example.retrofit_sample.DataModel.PostDataModel;
import com.example.retrofit_sample.Interface.JsonPlaceHolderApi;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;


public class MainActivity extends AppCompatActivity {
    //Using butter knife to bind the view
    @BindView(R.id.text_view_result)
    TextView tvResultado;

    //Logcat tag
    public static final String APP_TAG = "retrofit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initVars();
        getData();
    }

    private void getData() {
        Retrofit retrofitClient = new Retrofit.Builder()
                .baseUrl("https://betri.esp.br/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonApi = retrofitClient.create(JsonPlaceHolderApi.class);

        Call<List<PostDataModel>> apiCall = jsonApi.getPosts();

        //Execute the call in a background thread
        apiCall.enqueue(new Callback<List<PostDataModel>>() {
            @Override
            public void onResponse(Call<List<PostDataModel>> call, Response<List<PostDataModel>> response) {
                if(!response.isSuccessful()){ //verify if the code its 200
                    tvResultado.setText("Code: " + response.code());
                    return;
                }
                //Get the reponse data from the web service
                List<PostDataModel> postList = response.body();
                for(PostDataModel post : postList){
                    //Log.d(APP_TAG, "post item!!!!!!!");

                    String content ="";
                    content += "ID: " + post.getId() + "\n";

                    tvResultado.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<PostDataModel>> call, Throwable t) {
                //Something went wrong with the http call
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Erro while fetching data...");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        });
    }

    private void initVars() {

        tvResultado.setText("Hello Retrofit/ButterKnife");

    }
}
