package com.example.segundoauqui.mycamera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private static final int CAMERA_REQUEST = 2;
    ImageView imageView;
    Bitmap picture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.ivImage);


    }

    public void launchCamera(View view) {

        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK){
            picture = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(picture);




        }
    }

    public void launchEmi(View view) {

        Intent intent = new Intent(this, EmiActivity.class);
        startActivity(intent);

    }
}
