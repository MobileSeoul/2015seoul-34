package com.example.administrator.festival;

/**
 * Created by Administrator on 2015-10-30.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class Nf extends Activity implements OnClickListener {

    /* slide menu */
    private DisplayMetrics metrics;
    private LinearLayout slidingPanel;
    private LinearLayout leftMenuPanel;

    private FrameLayout.LayoutParams slidingPanelParameters;
    private FrameLayout.LayoutParams leftMenuPanelParameters;

    private int panelWidth;
    private static boolean isLeftExpanded;

    private Button bt_left;
    private ImageButton mainB,musicB,artB,playB,natureB,etcB,noticeB,epilogueB,homeB,nf,nch,nbd,nbe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.n_free);


        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        panelWidth = (int) ((metrics.widthPixels) * 0.75);

        bt_left = (Button) findViewById(R.id.bt_left);
        bt_left.setOnClickListener(this);
        View ic_leftslidemenu = (View) findViewById(R.id.ic_leftslidemenu);
        // sliding view Initialize
        slidingPanel = (LinearLayout) findViewById(R.id.slidingPanel);
        slidingPanelParameters = (FrameLayout.LayoutParams) slidingPanel
                .getLayoutParams();
        slidingPanelParameters.width = metrics.widthPixels;
        slidingPanel.setLayoutParams(slidingPanelParameters);

        // left slide menu initialize
        leftMenuPanel = (LinearLayout) findViewById(R.id.leftMenuPanel);
        leftMenuPanelParameters = (FrameLayout.LayoutParams) leftMenuPanel
                .getLayoutParams();
        leftMenuPanelParameters.width = panelWidth;
        leftMenuPanel.setLayoutParams(leftMenuPanelParameters);
        mainB = (ImageButton) findViewById(R.id.mainB);
        mainB.setOnClickListener(this);
        musicB = (ImageButton) findViewById(R.id.musicB);
        musicB.setOnClickListener(this);
        artB = (ImageButton) findViewById(R.id.artB);
        artB.setOnClickListener(this);
        playB = (ImageButton) findViewById(R.id.playB);
        playB.setOnClickListener(this);
        natureB = (ImageButton) findViewById(R.id.natureB);
        natureB.setOnClickListener(this);
        etcB = (ImageButton) findViewById(R.id.etcB);
        etcB.setOnClickListener(this);
        noticeB = (ImageButton) findViewById(R.id.noticeB);
        noticeB.setOnClickListener(this);
        epilogueB = (ImageButton) findViewById(R.id.epilogueB);
        epilogueB.setOnClickListener(this);
        homeB = (ImageButton) findViewById(R.id.homeB);
        homeB.setOnClickListener(this);
        nf = (ImageButton) findViewById(R.id.nf);
        nf.setOnClickListener(this);
        nch = (ImageButton) findViewById(R.id.nch);
        nch.setOnClickListener(this);
        nbd = (ImageButton) findViewById(R.id.nbd);
        nbd.setOnClickListener(this);
        nbe = (ImageButton) findViewById(R.id.nbe);
        nbe.setOnClickListener(this);



    }

    /**
     * 좌측 메뉴 토글시 처리
     */
    void menuLeftSlideAnimationToggle() {

        if (!isLeftExpanded) {

            // networkRequestTimeLineGetNewCnt();

            isLeftExpanded = true;

            leftMenuPanel.setVisibility(View.VISIBLE);

            // Expand
            new ExpandAnimation(slidingPanel, panelWidth, "left",
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.75f, 0, 0.0f, 0, 0.0f);

            // disable all of main view
            // LinearLayout viewGroup = (LinearLayout) findViewById(
            FrameLayout viewGroup = (FrameLayout) findViewById(R.id.ll_fragment)
                    .getParent();
            enableDisableViewGroup(viewGroup, false);

            // enable empty view
            ((LinearLayout) findViewById(R.id.ll_empty))
                    .setVisibility(View.VISIBLE);

            findViewById(R.id.ll_empty).setEnabled(true);
            findViewById(R.id.ll_empty).setOnTouchListener(
                    new OnTouchListener() {

                        @Override
                        public boolean onTouch(View arg0, MotionEvent arg1) {
                            menuLeftSlideAnimationToggle();
                            return true;
                        }
                    });

        } else {
            isLeftExpanded = false;

            // Collapse
            new CloseAnimation(slidingPanel, panelWidth,
                    TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
                    TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);

            // enable all of main view
            // LinearLayout viewGroup = (LinearLayout) findViewById(
            FrameLayout viewGroup = (FrameLayout) findViewById(R.id.ll_fragment)
                    .getParent();
            enableDisableViewGroup(viewGroup, true);

            // disable empty view
            ((LinearLayout) findViewById(R.id.ll_empty))
                    .setVisibility(View.GONE);
            findViewById(R.id.ll_empty).setEnabled(false);

        }
    }

    public static void enableDisableViewGroup(ViewGroup viewGroup,
                                              boolean enabled) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = viewGroup.getChildAt(i);

            if (view.getId() != R.id.bt_left) {
                view.setEnabled(enabled);
                if (view instanceof ViewGroup) {
                    enableDisableViewGroup((ViewGroup) view, enabled);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_left:
                menuLeftSlideAnimationToggle();
                break;
            case R.id.mainB:
                isLeftExpanded=false;
                finish();
                Intent main_it = new Intent(this, Startmain.class);
                startActivity(main_it);
                break;
            case R.id.musicB:
                isLeftExpanded=false;
                finish();
                Intent music_it = new Intent(this, Music.class);
                startActivity(music_it);
                break;
            case R.id.artB:
                isLeftExpanded=false;
                finish();
                Intent art_it = new Intent(this, Art.class);
                startActivity(art_it);
                break;
            case R.id.playB:
                isLeftExpanded=false;
                finish();
                Intent play_it = new Intent(this, Play.class);
                startActivity(play_it);
                break;
            case R.id.natureB:
                isLeftExpanded=false;
                finish();
                Intent nature_it = new Intent(this, Nature.class);
                startActivity(nature_it);
                break;
            case R.id.etcB:
                isLeftExpanded=false;
                finish();
                Intent etc_it = new Intent(this, Etc.class);
                startActivity(etc_it);
                break;
            case R.id.noticeB:
                isLeftExpanded=false;
                finish();
                Intent notice_it = new Intent(this, Notice.class);
                startActivity(notice_it);
                break;
            case R.id.epilogueB:
                isLeftExpanded=false;
                finish();
                Intent epilogue_it = new Intent(this, Epilogue.class);
                startActivity(epilogue_it);
                break;
            case R.id.homeB:
                isLeftExpanded=false;
                finish();
                Intent home_it = new Intent(this, Startmain.class);
                startActivity(home_it);
                break;
            case R.id.nf:
                isLeftExpanded=false;
                Intent nf_it = new Intent(this, Nf.class);
                startActivity(nf_it);
                break;
            case R.id.nch:
                isLeftExpanded=false;
                Intent nch_it = new Intent(this, Nch.class);
                startActivity(nch_it);
                break;
            case R.id.nbd:
                isLeftExpanded=false;
                Intent nbd_it = new Intent(this, Naturea.class);
                startActivity(nbd_it);
                break;
            case R.id.nbe:
                isLeftExpanded=false;
                Intent nbe_it = new Intent(this, Natureb.class);
                startActivity(nbe_it);
                break;

        }
    }
}