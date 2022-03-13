package com.example.chapter3.demo.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

import com.example.chapter3.demo.R;

public class ThreeBombsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_bombs);

        final ImageView thumbsUp = findViewById(R.id.thumbs_up);
        final ImageView coin = findViewById(R.id.coin);
        final ImageView collection = findViewById(R.id.collection);



        thumbsUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation alphaAnimation = AnimationUtils.loadAnimation(ThreeBombsActivity.this, R.anim.alpha);
                Animation rotateAnimation = AnimationUtils.loadAnimation(ThreeBombsActivity.this, R.anim.rotate);

                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(rotateAnimation);
                thumbsUp.startAnimation(animationSet);


            }
        });

        coin.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Animation alphaAnimation = AnimationUtils.loadAnimation(ThreeBombsActivity.this,
                        R.anim.alpha);
                Animation rotateAnimation = AnimationUtils.loadAnimation(ThreeBombsActivity.this,
                        R.anim.translate);

                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(rotateAnimation);
                thumbsUp.startAnimation(animationSet);

                ObjectAnimator coinAnimator = ObjectAnimator.ofFloat(coin,
                        "rotation", 0, 360);
                coinAnimator.setDuration(2000);
                coinAnimator.setInterpolator(new AnticipateInterpolator());
                coinAnimator.start();
                ObjectAnimator collectionAnimatorX = ObjectAnimator.ofFloat(collection,
                       "scaleX", 0, 3, 1);
                ObjectAnimator collectionAnimatorY = ObjectAnimator.ofFloat(collection,
                        "scaleY", 0, 3, 1);
                collectionAnimatorX.setDuration(2000);
                collectionAnimatorX.setInterpolator(new AnticipateInterpolator());
                collectionAnimatorX.start();
                collectionAnimatorY.setDuration(2000);
                collectionAnimatorY.setInterpolator(new AnticipateInterpolator());
                collectionAnimatorY.start();


//


                return false;
            }
        });

        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator collectionAnimator = ObjectAnimator.ofFloat(collection,
                        "alpha", 0f, 1f);
                collectionAnimator.setDuration(2000);
                collectionAnimator.setInterpolator(new AccelerateInterpolator());
                collectionAnimator.start();
//                ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 10);
//                valueAnimator.setDuration(2000);
//                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                        int animatedValue = (int) valueAnimator.getAnimatedValue();
////                        ViewGroup.LayoutParams thumbsParams = thumbsUp.getLayoutParams();
////                        thumbsParams.width=20*animatedValue;
////                        thumbsParams.height=20*animatedValue;
////                        ViewGroup.LayoutParams coinParams = coin.getLayoutParams();
////                        coinParams.width=20*animatedValue;
////                        coinParams.height=20*animatedValue;
//                        ViewGroup.LayoutParams collectionParams = collection.getLayoutParams();
//                        System.out.println(collectionParams);
//                        collectionParams.width=20*animatedValue;
//                        collectionParams.height=20*animatedValue;
////                        thumbsUp.requestLayout();
////                        coin.requestLayout();
//                        collection.requestLayout();
//
//                    }
//                });
//                valueAnimator.start();
            }
        });
    }
}