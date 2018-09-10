package assignment.infosys.com.infosysassignment.dropbox;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import assignment.infosys.com.infosysassignment.R;
import assignment.infosys.com.infosysassignment.apimodel.Facts;

import java.util.List;


public class BropboxRecyclerViewAdapter extends RecyclerView.Adapter<BropboxRecyclerViewAdapter.ViewHolder> {

    private final List<Facts.Data> mValues;

    Context mContext;
    public BropboxRecyclerViewAdapter(List<Facts.Data> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext=parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_dropbox_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
       holder.tvTitle.setText(mValues.get(position).getTitle());
       holder.tvDescription.setText(mValues.get(position).getDescription());
       if(mValues.get(position).getImageHref()!=null && !mValues.get(position).getImageHref().equals("")) {
          /* Picasso.with(mContext)
                   .load(mValues.get(position).getImageHref().toString())
                   .into(holder.imgPlaceHolder);*/
           Glide.with(mContext)
                   .load(mValues.get(position).getImageHref().toString())
                   .into(holder.imgPlaceHolder);

       }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public  View mView;
        public  TextView tvTitle;
        public  TextView tvDescription;
        public ImageView imgPlaceHolder;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvDescription = (TextView) view.findViewById(R.id.tv_description);
            imgPlaceHolder = (ImageView) view.findViewById(R.id.img_place_holder);
        }

    }
}
