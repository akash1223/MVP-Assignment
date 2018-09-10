package assignment.infosys.com.infosysassignment.root;

import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Toast;

import javax.inject.Inject;

import assignment.infosys.com.infosysassignment.apimodel.Facts;
import assignment.infosys.com.infosysassignment.custom_control.CustLoader;
import assignment.infosys.com.infosysassignment.dropbox.DropBoxContractMVP;
import assignment.infosys.com.infosysassignment.http.HttpApi;

/**
 * Created by user on 03-Mar-18.
 */

public class BaseFragment extends Fragment  {

    protected IFragmentCallback iFragmentCallback;
    protected Context mContext;
    protected CustLoader proDialog;
    private Dialog errorDialog;
    @Inject
    protected HttpApi mAPI;
    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        proDialog=new CustLoader(mContext);
        ((BaseApplication) getActivity().getApplication()).getComponent().inject(this);
        iFragmentCallback = (IFragmentCallback) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mContext!=null)
            mContext=null;
        if(proDialog!=null)
            proDialog=null;
        if(iFragmentCallback!=null)
            iFragmentCallback=null;
    }

    public boolean onBackPressed() {
        return false;
    }
/*
    @Override
    public void updateData(Facts viewModel) {

    }

   */
}
