package moe.utaha.myapplication;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.IOException;

import cz.msebera.android.httpclient.Header;

/**
 * Created by chojeaho on 2016-01-06.
 */
public class MyService extends Service{
    private MediaPlayer mediaPlayer;
    private AssetFileDescriptor ad;
    @Override
    public void onCreate()
    {
        super.onCreate();

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopSelf();
            }
        });
        Log.i("sunrin", "onCreate");
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("sunrin", "onStartCommand");
        try {
            mp3Play();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("sunrin", "onBind");
        throw null;
    }

    @Override
    public void onDestroy() {
        Log.i("sunrin", "onDestroy");
        mp3Stop();
        super.onDestroy();
    }
    private void mp3Play() throws IOException {
        AssetManager assetManager = getAssets();
        ad = getAssets().openFd("test.mp3");
        new Thread(runnable).start();
    }
    private void mp3Stop()
    {
        if (mediaPlayer != null && mediaPlayer.isPlaying() == true)
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                mediaPlayer.setDataSource(ad.getFileDescriptor());
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
