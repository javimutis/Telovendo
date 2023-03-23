package com.example.telovendo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telovendo.R;
import com.example.telovendo.model.Flores;

import java.util.List;

public class FloresAdapter extends
        RecyclerView.Adapter<FloresAdapter.FloresViewHolder> {
    private final Context mContext;
    private final List<Flores> flores;

    private final FloresAdapterOnClickHandler clickHandler;
     public interface FloresAdapterOnClickHandler {
        void onClick(Flores flores);
    }
    public FloresAdapter(Context context, FloresAdapterOnClickHandler
            clickHandler, List<Flores> flores) {
        this.mContext = context;
        this.clickHandler = clickHandler;
        this.flores = flores;
    }
    @NonNull
    @Override
    public FloresAdapter.FloresViewHolder onCreateViewHolder(@NonNull
        ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.hm_card_landscape,
                        parent, false);
        return new FloresViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull FloresAdapter.FloresViewHolder
                                         holder, int position) {
        Flores floresItem = flores.get(position);
        holder.imageViewFoto.setImageResource(floresItem.getFoto());
        holder.textViewNombre.setText(floresItem.getNombre());
    }
    @Override
    public int getItemCount() {
        return flores.size();
    }
    class FloresViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{
        // Elementos de UI a rellenar
        public TextView textViewNombre;
        public ImageView imageViewFoto;
        public FloresViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre =
                    itemView.findViewById(R.id.textViewCardFlores);
            imageViewFoto =
                    itemView.findViewById(R.id.imageViewCardFlores);
                    itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            // Obtiene la posición de la vista en el adapter
            int mItemSelected = getAdapterPosition();
            // Envia el parque a través del clic
            clickHandler.onClick(flores.get(mItemSelected));
        }
    }
}
