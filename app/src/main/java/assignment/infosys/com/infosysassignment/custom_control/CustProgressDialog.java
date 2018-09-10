package assignment.infosys.com.infosysassignment.custom_control;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import assignment.infosys.com.infosysassignment.R;


/**
 * Created by akash on 2016-02-16.
 */
public class CustProgressDialog extends Dialog {

    Context context;
    public CustProgressDialog(Context context) {

        super(context,R.style.TransparentDialogTheme);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCancelable(false);

        try {
            setContentView(R.layout.custom_dialog);
             RotateAnimation rotation = new RotateAnimation(0, 360,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                    0.5f);

            rotation.setInterpolator(new LinearInterpolator());
            rotation.setDuration(1000);
            rotation.setRepeatCount(Animation.INFINITE);

            rotation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {


                }
            });
            ((ImageView)findViewById(R.id.imageviewnew1)).startAnimation(rotation);
        }
        catch (Exception ex)
        {
            String str=ex+"";
        }

    }
}
