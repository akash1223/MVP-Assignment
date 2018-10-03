package assignment.infosys.com.infosysassignment.custom_control;

import android.content.Context;

/**
 * Created by user on 17-10-16.
 */
public class CircularLoader extends CircularProgressDialog {

    public CircularLoader(Context context)
    {
        super(context);
    }


    public void Loadershow() {
        super.show();
    }


    public void Loadermiss() {
        super.dismiss();
    }
}
