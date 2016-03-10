package collegelife.life.com.pruebarecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private ImageLoader imageLoader;
    private Context context;
    List<BaseClientes> listclientes;
    public CardAdapter(List<BaseClientes> listclientes, Context context){
        super();
        this.listclientes = listclientes;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categoria_lista, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BaseClientes baseClientes =  listclientes.get(position);
        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(baseClientes.getImageUrl(), ImageLoader.getImageListener(holder.imageView, R.drawable.ic_cargando, android.R.drawable.ic_dialog_alert));
        holder.imageView.setImageUrl(baseClientes.getImageUrl(), imageLoader);
        holder.textViewName.setText(baseClientes.getName());
        holder.textViewDescrip.setText(baseClientes.getDescrip());
    }

    @Override
    public int getItemCount() {
        return listclientes.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        public NetworkImageView imageView;
        public TextView textViewName;
        public TextView textViewDescrip;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (NetworkImageView) itemView.findViewById(R.id.imageViewClient);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewDescrip = (TextView) itemView.findViewById(R.id.textViewDescripcion);
        }
    }
}