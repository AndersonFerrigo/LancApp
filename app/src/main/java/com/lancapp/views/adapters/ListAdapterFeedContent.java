package com.lancapp.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.lancapp.R;

public class ListAdapterFeedContent extends RecyclerView.Adapter<ListAdapterFeedContent.MyHolder>{

    int flag = 0;

    private Context context;

    public ListAdapterFeedContent( Context context) {
        this.context = context;
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imgPerfil;
        public TextView nome;
        public TextView post;
        public TextView infoLike;
        public TextView whoLike;

        ImageButton btnLikeShared;
        ImageButton btnCommentShared;


        public MyHolder(View view) {
            super(view);
            Toast.makeText(view.getContext(), "Entrou no MyHolder", Toast.LENGTH_LONG).show();

            imgPerfil = view.findViewById(R.id.image_user);
            nome = view.findViewById(R.id.recebe_nome_from_login);
            post = view.findViewById(R.id.main_post);
            infoLike = view.findViewById(R.id.text_inform_like);
            whoLike = view.findViewById(R.id.text_quantity_likes);
            btnLikeShared = view.findViewById(R.id.button_receive_like_not);
            btnCommentShared = view.findViewById(R.id.button_add_comment);

        }

        @Override
        public void onClick(View v) {

        }
    }

        @Override
        public  ListAdapterFeedContent.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_home_content, parent, false);

         ListAdapterFeedContent.MyHolder feedContentViewHolder = new ListAdapterFeedContent.MyHolder(view);


         return feedContentViewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapterFeedContent.MyHolder viewHolder,
                                     int position) {

            final ListAdapterFeedContent.MyHolder feedContentHolder = viewHolder;

            feedContentHolder.imgPerfil.setImageResource(R.drawable.ic_user_profile);

            feedContentHolder.nome.setText("Seu nome aqui");

            feedContentHolder.post.setText("Usando o layout do quadro é muito fácil de superar isso. Aqui uma outra vantagem é que você pode dar eventos de clique para botões.se você definir ícones usando setCompoundDrawables, você não pode dar o clique eventos.\n" +
                    "                       Eu implementei no meu projeto que barra de pesquisa tem  excluir e ícones de pesquisa.\"/>\n");


            feedContentHolder.btnCommentShared.setBackgroundResource(R.mipmap.ic_comment_posts);




            feedContentHolder.btnLikeShared.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(flag == 0){
                        feedContentHolder.btnLikeShared.setImageResource(R.mipmap.ic_like_reaction);
                        feedContentHolder.infoLike.setText("Curtido por");
                        feedContentHolder.whoLike.setText("Anderson e outras pessoas");

                        flag = 1;

                    }else if(flag == 1){
                        feedContentHolder.btnLikeShared.setImageResource(R.mipmap.ic_like_no_reaction);
                        feedContentHolder.infoLike.setText("");
                        feedContentHolder.whoLike.setText("");

                        flag = 0;
                    }
                }
            });

            feedContentHolder.btnCommentShared.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Você cometou", Toast.LENGTH_LONG).show();
                }
            });



        }

    @Override
    public int getItemCount(){
        return 3;
    }

}




