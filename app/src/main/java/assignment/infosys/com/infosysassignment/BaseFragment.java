package assignment.infosys.com.infosysassignment;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by user on 03-Mar-18.
 */

public class BaseFragment extends Fragment {

    protected IFragmentCallback iFragmentCallback;
    protected Context mContext;

    private Dialog errorDialog;

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        iFragmentCallback = (IFragmentCallback) context;
    }

    public boolean onBackPressed() {
        return false;
    }
}
