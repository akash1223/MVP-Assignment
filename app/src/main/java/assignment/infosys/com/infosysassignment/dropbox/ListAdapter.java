package assignment.infosys.com.infosysassignment.dropbox;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.moviemvp.R;

import java.util.List;

import assignment.infosys.com.infosysassignment.apimodel.Facts;

/**
 * Created by user on 03-Mar-18.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {

    private List<Facts> list;

    public ListAdapter(List<Facts> list) {
        this.list = list;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {

        holder.itemName.setText(list.get(position).getName());
        holder.countryName.setText(list.get(position).getCountry());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder {

        public TextView itemName;
        public TextView countryName;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.textView_fragmentlist_task_name);
            countryName = (TextView) itemView.findViewById(R.id.textView_fragmentlist_country_name);
        }
    }
}