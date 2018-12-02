package fi.mixerboy24.tech.allsky_finlandskycamera;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.annotation.Documented;

public class MainActivity extends AppCompatActivity {
    ImageView ImageView;
    String url = "https://mixerboy24.dyndns.org/Allsky/image.jpg";

    SwipeRefreshLayout swipeRefreshLayout;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.Swipe);
        textView = (TextView) findViewById(R.id.tvSwipe);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 4000);
            }
        });

        //allsky pic1
        ImageView = (ImageView) findViewById(R.id.ImageView);
        loadImageFromUrl(url);

    }

    public void loadImageFromUrl (String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
         .into(ImageView,new  com.squareup.picasso.Callback(){

             @Override
             public void onSuccess() {

             }

             @Override
             public void onError() {


             }
         });

    }

}

