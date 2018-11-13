package music_39.framgia.com.demoretrofitrx;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;
import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private Context mContext;
    private List<Hero> mHeroList;
    private int mPosition;

    public HeroAdapter(Context context) {
        mContext = context;
        mHeroList = new ArrayList<>();
    }

    public void updateAdapter(List<Hero> heroList) {
        if (mHeroList != null) {
            mHeroList.clear();
            mHeroList.addAll(heroList);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView;
        itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_hero, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind();
    }

    @Override
    public int getItemCount() {
        return mHeroList != null ? mHeroList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextViewHeroName;
        private TextView mTextViewTeamHero;
        private ImageView mImageViewHero;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewHeroName = itemView.findViewById(R.id.textViewNameHero);
            mTextViewTeamHero = itemView.findViewById(R.id.textViewTeamHero);
            mImageViewHero = itemView.findViewById(R.id.imageViewHero);
            itemView.setOnClickListener(this);
        }

        private void bind() {
            Hero hero = mHeroList.get(getAdapterPosition());
            mTextViewHeroName.setText(hero.getName());
            mTextViewTeamHero.setText(hero.getTeam());
            Glide.with(mContext)
                    .load(hero.getImageurl())
                    .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                    .into(mImageViewHero);
        }

        @Override
        public void onClick(View v) {
            mPosition = getAdapterPosition();
            showSnackbar(v, "Real Name: "+mHeroList.get(mPosition).getRealname()+"\n"+mHeroList.get(mPosition).getBio());
        }

        public void showSnackbar(View view, String message) {
            final Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
            snackbar.getView().setBackgroundColor(Color.DKGRAY);
            snackbar.getView().getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
            TextView textView = snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
            textView.setMaxLines(40);
            snackbar.setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });
            snackbar.show();
        }
    }
}

