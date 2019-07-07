package com.example.otayori;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_MAIL = 1;
    static final int REQUEST_CAMERA = 2;
    static final int REQUEST_GALLERY = 3;

    ImageView imageView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView2);
        editText = (EditText)findViewById(R.id.TEXT1);
        editText.setText("初期");
    }
    public void mail(View v){

        Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.EMPTY);
        intent.putExtra(Intent.EXTRA_SUBJECT,"題名");
        intent.putExtra(Intent.EXTRA_TEXT,"本文");
        startActivityForResult(intent,REQUEST_MAIL);
    }
    public void gallery(View v){

        Intent intent =new Intent(Intent.ACTION_PICK,
        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,REQUEST_GALLERY);
    }
    public void setRequestCamera(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_CAMERA);

    }
}
