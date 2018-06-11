package eswar.com.okro.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.viewpagerindicator.CirclePageIndicator;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import eswar.com.okro.R;
import eswar.com.okro.Model.ViewImageModel;
import eswar.com.okro.Adapters.ViewPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    ImageView igv_next;
    private ArrayList<ViewImageModel> imageModelArrayList;

    private int[] myImageList = new int[]{R.drawable.fruitsnveg, R.drawable.directfarmer,
            R.drawable.subscription,R.drawable.harvest
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
igv_next=findViewById(R.id.igv_next);
igv_next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(ViewPagerActivity.this,LoginActivity.class);
        startActivity(intent);
    }
});
        imageModelArrayList = new ArrayList<>();
        imageModelArrayList = populateList();

        init();

    }

    private ArrayList<ViewImageModel> populateList(){

        ArrayList<ViewImageModel> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            ViewImageModel imageModel = new ViewImageModel();
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);

        }

        return list;
    }

    private void init() {

        mPager = (ViewPager) findViewById(R.id.vp_pager);
        mPager.setAdapter(new ViewPagerAdapter(ViewPagerActivity.this,imageModelArrayList));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.cpi_indicators);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =imageModelArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
//                   onPause();
//                    Intent i = new Intent(ViewPagerActivity.this, LoginActivity.class);
//                    startActivity(i);
//                    finish();
                }
                mPager.setCurrentItem(currentPage++, true);

            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);

            }
        }, 1500, 1500);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

}