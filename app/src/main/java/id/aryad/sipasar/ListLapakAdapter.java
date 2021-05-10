package id.aryad.sipasar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListLapakAdapter extends RecyclerView.Adapter<ListLapakAdapter.ListViewHolder> {
    Context context;
    private ArrayList<Lapak> listLapak;

    public ListLapakAdapter(Context context, ArrayList<Lapak> list) {
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
        final Lapak lapak = listLapak.get(position);
        holder.tvName.setText(lapak.getNama_lapak());
        holder.tvFrom.setText(lapak.getLokasi());
        holder.relative.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PembayaranLapak.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("tvName", lapak.getNama_lapak());
                context.startActivity(intent);
            }
        });
        }

    @Override
    public int getItemCount() {
        return listLapak.size();
    }

    public void filterList(ArrayList<Lapak> filteredList){
        listLapak = filteredList;
        notifyDataSetChanged();
    }

    public interface OnItemClickCallback {
        void onItemClicked(Lapak data);
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvFrom;
        RelativeLayout relative;
        ListViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            relative=itemView.findViewById(R.id.relative);
        }
    }
}
