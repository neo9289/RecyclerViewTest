package francescoluise.com.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import francescoluise.com.recyclerviewtest.Adapter.AdapterNation;
import francescoluise.com.recyclerviewtest.Model.Answer;
import francescoluise.com.recyclerviewtest.Model.Nation;

public class MainActivity extends AppCompatActivity {

    private List<Answer> answerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterNation mAdapter;
    private LinearLayout llAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_nations);
        mAdapter = new AdapterNation(getBaseContext(),answerList);
        llAdd = (LinearLayout) findViewById(R.id.ll_add);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        llAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNation();
            }
        });
    }

    public void addNation(){
        answerList.add(new Answer(new Nation(10,"Italia"),20));
        mAdapter.notifyDataSetChanged();
    }

}
