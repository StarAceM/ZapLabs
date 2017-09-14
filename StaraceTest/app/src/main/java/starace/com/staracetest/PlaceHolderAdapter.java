package starace.com.staracetest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import starace.com.staracetest.models.PlaceHolderModel;

/**
 * Created by mstarace on 9/13/17.
 */

public class PlaceHolderAdapter extends RecyclerView.Adapter<PlaceHolderAdapter.PlaceHolderViewHolder> {

    private List<PlaceHolderModel> placeHolderModelList;

    public PlaceHolderAdapter(List<PlaceHolderModel> placeHolderModelList) {
        this.placeHolderModelList = placeHolderModelList;
    }

    public void updateAdapterList(List<PlaceHolderModel> placeHolderModelList) {
        this.placeHolderModelList = placeHolderModelList;
        notifyDataSetChanged();
    }

    @Override
    public PlaceHolderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlaceHolderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recylcer_view_conatiner,
                parent, false));
    }

    @Override
    public void onBindViewHolder(PlaceHolderViewHolder holder, int position) {
        holder.viewBody.setText(placeHolderModelList.get(position).getBody());
        setImageView(holder.image, placeHolderModelList.get(position).getImageUrl());
    }

    private void setImageView(ImageView image, String url) {
        Picasso.with(image.getContext())
                .load(url)
                .resize(200, 200)
                .centerCrop()
                .into(image);
    }

    @Override
    public int getItemCount() {
        return placeHolderModelList.size();
    }

    public class PlaceHolderViewHolder extends RecyclerView.ViewHolder {
        private TextView viewBody;

        private ImageView image;

        public PlaceHolderViewHolder(View itemView) {
            super(itemView);

            viewBody = (TextView) itemView.findViewById(R.id.text_view);

            image = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }
}
