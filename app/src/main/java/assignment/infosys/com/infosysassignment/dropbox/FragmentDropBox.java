package assignment.infosys.com.infosysassignment.dropbox;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import assignment.infosys.com.infosysassignment.R;
import assignment.infosys.com.infosysassignment.apimodel.Facts;
import assignment.infosys.com.infosysassignment.root.BaseApplication;
import assignment.infosys.com.infosysassignment.root.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FragmentDropBox extends BaseFragment implements DropBoxContractMVP.View{

    BropboxRecyclerViewAdapter listAdapter;
    private List<Facts.Data> resultList=new ArrayList<>();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeContainer;


    private Unbinder unbinder;

    @Inject
    DropBoxContractMVP.Presenter presenter;

    public FragmentDropBox() {
    }

    public static FragmentDropBox newInstance() {
        FragmentDropBox fragment = new FragmentDropBox();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
        ((BaseApplication) getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dropbox, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       // super.onViewCreated(view, savedInstanceState);
        listAdapter=new BropboxRecyclerViewAdapter(resultList);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loaddata();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            presenter.setView(this);
            presenter.loaddata();
        }
        catch (Exception ex)
        {
            Log.e("Error:",ex.toString());
        }


    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void updateActionbar(String title) {
        iFragmentCallback.toolbarTitle(title);

    }
    @Override
    public void updateList(List<Facts.Data> mList) {
        if(swipeContainer.isRefreshing())
        swipeContainer.setRefreshing(false);
        resultList.clear();
        resultList.addAll(mList);
        listAdapter.notifyDataSetChanged();
    }
    @Override
    public void showProgressIndicator(boolean show) {
        if(show)
            proDialog.Loadershow();
        else
            proDialog.Loadermiss();
    }

    @Override
    public void makeToast(int message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSnackBar(String msg) {
        Snackbar.make(recyclerView, msg, Snackbar.LENGTH_SHORT).show();
    }
}
