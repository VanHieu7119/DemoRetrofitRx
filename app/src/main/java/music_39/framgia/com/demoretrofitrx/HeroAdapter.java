package music_39.framgia.com.demoretrofitrx;

import android.content.Context;
import android.support.annotation.NonNull;
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

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewHeroName;
        private TextView mTextViewTeamHero;
        private ImageView mImageViewHero;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewHeroName = itemView.findViewById(R.id.textViewNameHero);
            mTextViewTeamHero = itemView.findViewById(R.id.textViewTeamHero);
            mImageViewHero = itemView.findViewById(R.id.imageViewHero);
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
    }
}

