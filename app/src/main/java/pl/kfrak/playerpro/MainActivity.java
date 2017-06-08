package pl.kfrak.playerpro;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    private SeekBar volume_seekBar;
   // private ImageButton play_pause_button;
    //private ImageButton rewind_button;
    private MediaPlayer dubstep;

    @BindDrawable(android.R.drawable.ic_media_play)
    Drawable playImage;

    @BindDrawable(android.R.drawable.ic_media_pause)
    Drawable pauseImage;

    @BindView(R.id.play_pause_button)
    ImageButton play_pause_button;

    @BindView(R.id.rewind_button)
    ImageButton rewind_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dubstep = MediaPlayer.create(this, R.raw.bensound_dubstep);
        ButterKnife.bind(this);

    }


    public void playSound(View view) {
        playOrPauseDobstep();
        playOrPauseButtonDubstep();
    }

    //inClick lub tak jak jest
    //@OnClick(R.id.rewind_button)
    public void rewindDubstep(View view){
        dubstep.seekTo(0);
    }

    public void stopSound(View view){
        dubstep.pause();
        dubstep.seekTo(0);
       // refreshplaypausebutton

    }

    private void playOrPauseButtonDubstep() {
        if (dubstep.isPlaying()) {
            play_pause_button.setImageDrawable(pauseImage);
        } else {
            play_pause_button.setImageDrawable(playImage);
        }
    }

    private void playOrPauseDobstep() {
        if (!dubstep.isPlaying()) {
            dubstep.start();
        } else {
            dubstep.pause();
        }
    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
    }
}
