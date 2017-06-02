package francescoluise.com.recyclerviewtest.Adapter;

/**
 * Created by francescoluise on 01/06/17.
 */

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import francescoluise.com.recyclerviewtest.Model.Answer;
import francescoluise.com.recyclerviewtest.R;

import static android.R.attr.minHeight;

public class AdapterNation extends RecyclerView.Adapter<AdapterNation.MyViewHolder> {

    private List<Answer> moviesList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nazione, perc;
        public CardView row;

        public MyViewHolder(View view) {
            super(view);
            nazione = (TextView) view.findViewById(R.id.nazione_cv_row);
            perc = (TextView) view.findViewById(R.id.perc_cv_row);
            row = (CardView) view.findViewById(R.id.cv_row);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    collapseView();
                }
            });
        }
        public void collapseView() {

            ValueAnimator anim = ValueAnimator.ofInt(row.getMeasuredHeightAndState(),
                    minHeight);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = row.getLayoutParams();
                    layoutParams.height = val;
                    row.setLayoutParams(layoutParams);

                }
            });
            anim.start();
        }
        public void expandView(int height) {

            ValueAnimator anim = ValueAnimator.ofInt(row.getMeasuredHeightAndState(),
                    height);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = row.getLayoutParams();
                    layoutParams.height = val;
                    row.setLayoutParams(layoutParams);
                }
            });
            anim.start();

        }
    }


    public AdapterNation(Context context, List<Answer> moviesList) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nation_list_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Answer answer = moviesList.get(position);
        holder.nazione.setText(answer.getNation().getName_nation());
        holder.perc.setText(""+answer.getPercentage());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


}