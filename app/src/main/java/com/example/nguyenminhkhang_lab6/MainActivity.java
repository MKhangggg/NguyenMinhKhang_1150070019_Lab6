package com.example.nguyenminhkhang_lab6;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    // Khai báo các biến
    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml, btnBlinkCode, btnZoomInXml, btnZoomInCode,
            btnZoomOutXml, btnZoomOutCode, btnRotateXml, btnRotateCode,
            btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml, btnBounceCode, btnCombineXml, btnCombineCode;

    private ImageView ivUitLogo;

    private GestureDetector gestureDetector;  // Khai báo GestureDetector

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo GestureDetector để phát hiện các cử chỉ
        gestureDetector = new GestureDetector(this, this);

        // Khởi tạo các views và xử lý sự kiện
        findViewsByIds();

        // Thêm sự kiện click cho ImageView để mở NewActivity
        ivUitLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNewActivity = new Intent(MainActivity.this, NewActivity.class);
                startActivity(iNewActivity);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        // Định nghĩa hành động khi người dùng nhấn vào từng nút animation
        setButtonListeners();
    }

    // Hàm tìm các view
    private void findViewsByIds() {
        ivUitLogo = findViewById(R.id.iv_uit_logo);
        btnFadeInXml = findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = findViewById(R.id.btn_blink_xml);
        btnBlinkCode = findViewById(R.id.btn_blink_code);
        btnZoomInXml = findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = findViewById(R.id.btn_rotate_xml);
        btnRotateCode = findViewById(R.id.btn_rotate_code);
        btnMoveXml = findViewById(R.id.btn_move_xml);
        btnMoveCode = findViewById(R.id.btn_move_code);
        btnSlideUpXml = findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = findViewById(R.id.btn_slide_up_code);
        btnBounceXml = findViewById(R.id.btn_bounce_xml);
        btnBounceCode = findViewById(R.id.btn_bounce_code);
        btnCombineXml = findViewById(R.id.btn_combine_xml);
        btnCombineCode = findViewById(R.id.btn_combine_code);
    }

    // Hàm thiết lập các sự kiện click cho nút
    private void setButtonListeners() {
        btnFadeInXml.setOnClickListener(v -> startAnimationFromXml(R.anim.anim_fade_in));
        btnFadeInCode.setOnClickListener(v -> startAnimationFromCode(new AlphaAnimation(0.0f, 1.0f)));

        btnFadeOutXml.setOnClickListener(v -> startAnimationFromXml(R.anim.anim_fade_out));
        btnFadeOutCode.setOnClickListener(v -> startAnimationFromCode(new AlphaAnimation(1.0f, 0.0f)));

        btnBlinkXml.setOnClickListener(v -> startAnimationFromXml(R.anim.anim_blink));
        btnBlinkCode.setOnClickListener(v -> startAnimationFromCode(createBlinkAnimation()));

        btnZoomInXml.setOnClickListener(v -> startAnimationFromXml(R.anim.anim_zoom_in));
        btnZoomInCode.setOnClickListener(v -> startAnimationFromCode(createZoomInAnimation()));

        btnZoomOutXml.setOnClickListener(v -> startAnimationFromXml(R.anim.anim_zoom_out));
        btnZoomOutCode.setOnClickListener(v -> startAnimationFromCode(createZoomOutAnimation()));

        btnRotateXml.setOnClickListener(v -> startAnimationFromXml(R.anim.anim_rotate));
        btnRotateCode.setOnClickListener(v -> startAnimationFromCode(createRotateAnimation()));

        btnMoveXml.setOnClickListener(v -> startAnimationFromXml(R.anim.anim_move));
        btnMoveCode.setOnClickListener(v -> startAnimationFromCode(createMoveAnimation()));

        btnSlideUpXml.setOnClickListener(v -> startAnimationFromXml(R.anim.anim_slide_up));
        btnSlideUpCode.setOnClickListener(v -> startAnimationFromCode(createSlideUpAnimation()));

        btnBounceXml.setOnClickListener(v -> startAnimationFromXml(R.anim.anim_bounce));
        btnBounceCode.setOnClickListener(v -> startAnimationFromCode(createBounceAnimation()));

        btnCombineXml.setOnClickListener(v -> startAnimationFromXml(R.anim.anim_combine));
        btnCombineCode.setOnClickListener(v -> startAnimationFromCode(createCombineAnimation()));
    }

    // Hàm xử lý animation từ XML
    private void startAnimationFromXml(int animationResource) {
        Animation animation = AnimationUtils.loadAnimation(this, animationResource);
        ivUitLogo.startAnimation(animation);
    }

    // Hàm xử lý animation từ code
    private void startAnimationFromCode(Animation animation) {
        ivUitLogo.startAnimation(animation);
    }

    // Các hàm tạo animation từ code (ví dụ animation blink, zoom in...)
    private Animation createBlinkAnimation() {
        AlphaAnimation blink = new AlphaAnimation(0.0f, 1.0f);
        blink.setDuration(300);
        blink.setRepeatMode(Animation.REVERSE);
        blink.setRepeatCount(3);
        return blink;
    }

    private Animation createZoomInAnimation() {
        ScaleAnimation zoomIn = new ScaleAnimation(1.0f, 3.0f, 1.0f, 3.0f);
        zoomIn.setDuration(1000);
        zoomIn.setFillAfter(true);
        return zoomIn;
    }

    private Animation createZoomOutAnimation() {
        ScaleAnimation zoomOut = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f);
        zoomOut.setDuration(1000);
        zoomOut.setFillAfter(true);
        return zoomOut;
    }

    private Animation createRotateAnimation() {
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(600);
        rotate.setRepeatMode(Animation.RESTART);
        rotate.setRepeatCount(2);
        return rotate;
    }

    private Animation createMoveAnimation() {
        TranslateAnimation move = new TranslateAnimation(0, 200, 0, 0);
        move.setDuration(800);
        move.setFillAfter(true);
        return move;
    }

    private Animation createSlideUpAnimation() {
        ScaleAnimation slideUp = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f);
        slideUp.setDuration(500);
        slideUp.setFillAfter(true);
        return slideUp;
    }

    private Animation createBounceAnimation() {
        ScaleAnimation bounce = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f);
        bounce.setDuration(500);
        bounce.setInterpolator(this, android.R.anim.bounce_interpolator);
        bounce.setFillAfter(true);
        return bounce;
    }

    private Animation createCombineAnimation() {
        AnimationSet combine = new AnimationSet(true);
        ScaleAnimation scale = new ScaleAnimation(1.0f, 3.0f, 1.0f, 3.0f);
        scale.setDuration(4000);
        RotateAnimation rotate = new RotateAnimation(0, 360);
        rotate.setDuration(500);
        rotate.setRepeatCount(2);
        combine.addAnimation(scale);
        combine.addAnimation(rotate);
        return combine;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Phân tích cử chỉ khi người dùng vuốt
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {}

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {}

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (distanceX < 0) { // Vuốt từ trái qua phải
            finish();  // Quay lại MainActivity từ NewActivity
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        } else if (distanceX > 0) { // Vuốt từ phải qua trái
            Intent intent = new Intent(MainActivity.this, NewActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}

