package com.example.cattlediseaseprediction;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;

public class PredictDiseaseActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_GALLERY_IMAGE = 2;

    private ImageView cattleImageView;
    private Button uploadImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict_disease);

        cattleImageView = findViewById(R.id.cattleImageView);
        uploadImageButton = findViewById(R.id.uploadImageButton);

        // Check and request permissions
        checkPermissions();

        uploadImageButton.setOnClickListener(view -> showImageUploadOptions());

        // Configure symptom blocks
        configureSymptomBlocks();

        // Set up Predict Disease button to navigate to the results activity
        Button predictDiseaseButton = findViewById(R.id.predictDiseaseButton);
        predictDiseaseButton.setOnClickListener(v -> {
            Intent intent = new Intent(PredictDiseaseActivity.this, PredictionResultsActivity.class);
            startActivity(intent);
        });
    }

    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    100);
        }
    }

    private void showImageUploadOptions() {
        String[] options = {"Take Photo", "Choose from Gallery"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Upload Cattle Image");
        builder.setItems(options, (dialog, which) -> {
            if (which == 0) {
                openCamera();
            } else {
                openGallery();
            }
        });
        builder.show();
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
        } else {
            Toast.makeText(this, "Camera not available", Toast.LENGTH_SHORT).show();
        }
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, REQUEST_GALLERY_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE && data != null) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                cattleImageView.setImageBitmap(photo);
            } else if (requestCode == REQUEST_GALLERY_IMAGE && data != null) {
                Uri selectedImageUri = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                    cattleImageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void configureSymptomBlocks() {
        configureSymptomBlock(findViewById(R.id.symptom_salivation), "1. Is there excessive salivation in the cattle? / کیا مویشی سے زیادہ تھوک بہ رہا ہے؟", R.drawable.salivation);
        configureSymptomBlock(findViewById(R.id.symptom_ulcers), "2. Does the cattle have ulcers? / کیا مویشی کو زخم ہیں؟", R.drawable.ulcer);
        configureSymptomBlock(findViewById(R.id.symptom_weight_loss), "3. Is the cattle losing weight? / کیا مویشی کا وزن کم ہو رہا ہے؟", R.drawable.losingweight);
        configureSymptomBlock(findViewById(R.id.symptom_anorexia), "4. Does the cattle have anorexia? / کیا مویشی کوھوک کی کمی کا سامنا ہے؟", R.drawable.anorexia);
        configureSymptomBlock(findViewById(R.id.symptom_abortions), "5. Has the cattle experienced abortions? / کیا مویشی نے اسقاط حمل کا سامنا کیا ہے؟", R.drawable.abortion);
        configureSymptomBlock(findViewById(R.id.symptom_arthrogyposis), "6. Does the cattle have arthrogyposis? /  کیامویشی کےجوڑ غیر معمولی طور پر سخت یا مڑے ہوئےہیں؟", R.drawable.arthrogyposis);
        configureSymptomBlock(findViewById(R.id.symptom_blood_loss), "7. Is there blood loss in the cattle? / کیا مویشی میں خون کی کمی ہو رہی ہے؟", R.drawable.bloodloss);
        configureSymptomBlock(findViewById(R.id.symptom_blisters), "8. Does the cattle have blisters? / کیا مویشی کے جسم پر چھالے ہیں؟", R.drawable.blisters);
        configureSymptomBlock(findViewById(R.id.symptom_coughing), "9. Is the cattle coughing? / کیا مویشی کھانسی کر رہا ہے؟", R.drawable.coughing);
        configureSymptomBlock(findViewById(R.id.symptom_depression), "10. Is the cattle showing signs of depression? / کیا مویشی افسردگی کے علامات ظاہر کر رہا ہے؟", R.drawable.depression);
        configureSymptomBlock(findViewById(R.id.symptom_diarrhoea), "11. Does the cattle have diarrhoea? / کیا مویشی کو  پاخانہ  پتلا اور بار بار آ رہا ہیں؟", R.drawable.diarrhoea);
        configureSymptomBlock(findViewById(R.id.symptom_dull), "12. Is the cattle looking dull? / کیا مویشی بےجان یا تھکا ہوا نظر آ رہا ہے؟", R.drawable.dull);
        configureSymptomBlock(findViewById(R.id.symptom_fever), "13. Does the cattle have a fever? / کیا مویشی کو بخار ہے؟", R.drawable.fever);
        configureSymptomBlock(findViewById(R.id.symptom_loss_of_appetite), "14. Has the cattle lost its appetite? / کیا مویشی کی بھوک چلی گئی ہے؟", R.drawable.lossappetite);
        configureSymptomBlock(findViewById(R.id.symptom_milk_fever), "15. Is the quality of the cattle's milk not good? / کیا مویشی کے دودھ کی کوالٹی ٹھیک نہیں ہے؟", R.drawable.milkfever);
        configureSymptomBlock(findViewById(R.id.symptom_nasal_discharges), "16. Is there nasal discharge in the cattle? / کیا مویشی سے ناک سے پانی بہ رہا ہے؟", R.drawable.nasaldischarge);
        configureSymptomBlock(findViewById(R.id.symptom_reduction_milk_yields), "17. Has the milk yield decreased in the cattle? / کیا مویشی کی دودھ کی پیداوار میں کمی آئی ہے؟", R.drawable.reducedmilkyields);
        configureSymptomBlock(findViewById(R.id.symptom_reduces_feed_intake), "18. Is the cattle reducing feed intake? / کیا مویشی کھانا کم کھا رہا ہے؟", R.drawable.reducefeed);
        configureSymptomBlock(findViewById(R.id.symptom_torticollis), "19. Does the cattle have torticollis (twisted neck)? / کیا مویشی کو گردن کا درد یا (مڑھاؤ یا گردن کا جھکاؤ) ہے؟", R.drawable.torticollis);
        configureSymptomBlock(findViewById(R.id.symptom_high_temp), "20. Does the cattle have a high temperature? / کیا مویشی کا درجہ حرارت زیادہ ہے؟", R.drawable.hightemprature);

    }

    private void configureSymptomBlock(View symptomBlock, String questionText, int imageResId) {
        TextView question = symptomBlock.findViewById(R.id.symptomText);
        Button toggleButton = symptomBlock.findViewById(R.id.symptomImageToggleButton);
        ImageView symptomImage = symptomBlock.findViewById(R.id.symptomImage);


        question.setText(questionText);

        symptomImage.setImageResource(imageResId);

        toggleButton.setOnClickListener(v -> {
            if (symptomImage.getVisibility() == View.GONE) {
                symptomImage.setVisibility(View.VISIBLE);
                toggleButton.setText("Hide Image");
            } else {
                symptomImage.setVisibility(View.GONE);
                toggleButton.setText("Show Image");
            }
        });
    }
}
