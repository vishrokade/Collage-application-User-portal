package com.example.drdypuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class motivation extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView,youTubePlayerView1,youTubePlayerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);

        youTubePlayerView = findViewById(R.id.youtube_videoPlayer);
        youTubePlayerView1 = findViewById(R.id.youtube_videoPlayer1);
        youTubePlayerView2 = findViewById(R.id.youtube_videoPlayer2);

        getLifecycle().addObserver(youTubePlayerView);
        getLifecycle().addObserver(youTubePlayerView1);
        getLifecycle().addObserver(youTubePlayerView2);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {


                String VideoId = "bC0hlK7WGcM";
                youTubePlayer.loadVideo(VideoId,0);

            }
        });

        youTubePlayerView1.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String VideoId = "3SDkzDlw1yc";
                youTubePlayer.loadVideo(VideoId,0);
            }
        });

        youTubePlayerView2.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String VideoId = "LTnI7cmpDZI";
                youTubePlayer.loadVideo(VideoId,0);
            }
        });
    }
}