package com.example.mydiary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class WriteActivity extends AppCompatActivity {
    ImageView imageDiary;
    Button btnImage, btnSave, btnPhoto;
    EditText editTitle, editContent;
    String currentPhotoPath;
    Uri photoURI;
    File photoFile;
    DBHelper dbHelper;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 2;
    static final int REQUEST_PHOTO_SELECTION = 3;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        imageDiary = findViewById(R.id.imageDiary);
        btnSave = findViewById(R.id.btnSave);
        btnImage = findViewById(R.id.btnImage);
        editTitle = findViewById(R.id.editTitle);
        editContent = findViewById(R.id.editContent);
        btnImage.setOnClickListener(v ->{
            dispatchTakePictureIntent();
        });


        btnSave.setOnClickListener(v ->{

            insertBtn();
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void insertBtn(){
        dbHelper = new DBHelper(getApplicationContext());
        DiaryVO diaryVO = new DiaryVO();
        MemoDAO dao =new MemoDAO();
        diaryVO.setTitle(editTitle.getText().toString());
        diaryVO.setContent(editContent.getText().toString());
        diaryVO.setImg(currentPhotoPath);
        dao.insert(dbHelper, diaryVO);
        if(){
         //등록이나 수정이 한페이지에서 다 되어야함.
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//        }
        photoFile = null;
        try {
            photoFile = createImageFile();
        } catch (IOException ex) {
        }
        if (photoFile != null) {
            photoURI = FileProvider.getUriForFile(this,
                    "com.example.mydiary",
                    photoFile);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }

    private void getPhoto(){
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_PHOTO_SELECTION);
    }

    public void setPicture(String picturePath, int sampleSize) {
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        currentPhotoPath = image.getAbsolutePath(); //이값을 DB에 저장
        return image;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageDiary.setImageBitmap(imageBitmap);
        }else if(requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK){
            imageDiary.setImageURI(photoURI);
        }else if(requestCode == REQUEST_PHOTO_SELECTION && resultCode == RESULT_OK){
            Uri selectedImage = data.getData();
            imageDiary.setImageURI(selectedImage);
        }
    }
}
