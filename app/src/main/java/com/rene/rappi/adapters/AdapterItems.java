package com.rene.rappi.adapters;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.v7.widget.SwitchCompat;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rene.rappi.R;
import com.rene.rappi.activities.ItemActivity;
import com.rene.rappi.model.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rene on 04/11/2015.
 */
public class AdapterItems extends RecyclerView.Adapter<AdapterItems.ViewHolder> implements ItemClickListener {

    private Context context;
    private List<Entry> mDataset;
    /**
     * Interfaz de comunicación
     */
    public interface OnItemClickListener {
        void onItemClick(ViewHolder item, int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        // Campos respectivos de un item
        public TextView title;
        public TextView desc;
        public TextView categoty;
        public ImageView icon;
        public ItemClickListener listener;

        private AdapterItems padre = null;

        public ViewHolder(View v,  ItemClickListener listener) {
            super(v);


            title = (TextView) v.findViewById(R.id.titulo);
            desc  = (TextView) v.findViewById(R.id.summary);
            categoty   = (TextView) v.findViewById(R.id.category);
            icon = (ImageView) v.findViewById(R.id.icon);
            this.listener = listener;
            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }
    }

    @Override
    public long getItemId(int position) {
        //return Office.OFFICES.get(position).getId();
        return position;
    }

    public AdapterItems(Context context,List<Entry> entries) {

        this.context = context;
        this.mDataset = entries;
    }

    @Override
    public int getItemCount() {
     /*   if(Office.OFFICES!=null)
            return Office.OFFICES.size();
        else
            return 1;*/
        return this.mDataset.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = null;

        TelephonyManager manager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        if(manager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE){
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.content_item_menu_grid, viewGroup, false);
        }else{
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.content_item_menu, viewGroup, false);
        }

        return new ViewHolder(v, this);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {


        final Entry entry = mDataset.get(i);

        viewHolder.title.setText(entry.getTitle().getLabel());
        viewHolder.desc.setText(entry.getSummary().getLabel());
        viewHolder.categoty.setText(entry.getCategory().getAttributes().getLabel());

        if(entry.getImageList()!=null)
            if(entry.getImageList().size()>0) {
                Glide.with(viewHolder.itemView.getContext())
                        .load(entry.getImageList().get(0).getLabel())
                        .centerCrop()
                        .into(viewHolder.icon);
            }

    }


    @Override
    public void onItemClick(View view, int position) {
        ItemActivity.createInstance(
                (Activity) context, mDataset.get(position));
    }


}


interface ItemClickListener {
    void onItemClick(View view, int position);
}
