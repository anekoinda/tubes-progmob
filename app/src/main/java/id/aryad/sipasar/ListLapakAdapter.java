package id.aryad.sipasar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListLapakAdapter extends RecyclerView.Adapter<ListLapakAdapter.ListViewHolder> {
    Context context;
    private ArrayList<Lapak> listLapak;

    public ListLapakAdapter(ArrayList<Lapak> list) {
        this.context = context;
        this.listLapak = list;
    }

    private OnItemClickCallback onItemClickCallback;


    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_lapak, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Lapak lapak = listLapak.get(position);
        holder.tvName.setText(lapak.getNama_lapak());
        holder.tvFrom.setText(lapak.getLokasi());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listLapak.get(holder.getAdapterPosition()));
            }
        });
        }

    @Override
    public int getItemCount() {
        return listLapak.size();
    }

    public interface OnItemClickCallback {
        void onItemClicked(Lapak data);
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvFrom;
        ListViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
        }
    }
}
