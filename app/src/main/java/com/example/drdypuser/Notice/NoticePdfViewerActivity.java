package com.example.drdypuser.Notice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.drdypuser.Ebook.PdfViewerActivity;
import com.example.drdypuser.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NoticePdfViewerActivity extends AppCompatActivity {

    private String Url;
    private PDFView pdfView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_pdf_viewer);

        Url = getIntent().getStringExtra("downloadUrl");
        pdfView = findViewById(R.id.noticePdfView);

        new pdfDownload().execute(Url);
    }
    private class pdfDownload extends AsyncTask<String, Void , InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;

            try {
                URL Url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) Url.openConnection();

                if(httpURLConnection.getResponseCode() == 200){
                    inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                }
            } catch (IOException e) {

            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }
    }
}