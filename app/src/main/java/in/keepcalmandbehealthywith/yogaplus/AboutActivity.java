package in.keepcalmandbehealthywith.yogaplus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by G.BHARATHVAJ on 28-09-2016.
 */

public class AboutActivity extends YouTubeBaseActivity
{

    Button mbutton;
    private YouTubePlayerView myouTubePlayerView;
    private YouTubePlayer.OnInitializedListener monInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        myouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        monInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("4ZdcGKUQufU");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        mbutton = (Button) findViewById(R.id.playbutton);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myouTubePlayerView.initialize("AIzaSyA_bMEqSJbYilFoPeVwrxtGhKfGWfs22_g", monInitializedListener);
            }
        });
    }
}
