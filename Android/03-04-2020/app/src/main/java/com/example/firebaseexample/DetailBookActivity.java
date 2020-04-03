package com.example.firebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DetailBookActivity extends AppCompatActivity {
    private DatabaseReference booksReference;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private FirebaseStorage firebaseStorage = FirebaseStorage.getInstance("gs://a2002gaptech.appspot.com");
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);
        pdfView = findViewById(R.id.pdfView);

        Intent intent = getIntent();
        Book book = (Book)intent.getSerializableExtra("book");
        String url = book.getUrl();

        StorageReference urlReference = firebaseStorage.getReferenceFromUrl(url);
        final long TEN_MEGABYTE = 10 * 1024 * 1024;
        urlReference.getBytes(TEN_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                System.out.println("haha");//read ok, so dislay ?
                try {
                    pdfView.fromBytes(bytes)
                            .enableSwipe(true) // allows to block changing pages using swipe
                            .swipeHorizontal(false)
                            .enableDoubletap(true)
                            .defaultPage(0)
                            // allows to draw something on the current page, usually visible in the middle of the screen
                            .load();
                }catch (Exception e) {
                    System.err.println("keke");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
        urlReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                System.out.println("haha");//read ok, so dislay ?

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                System.out.println("error");
            }
        });

    }
}
