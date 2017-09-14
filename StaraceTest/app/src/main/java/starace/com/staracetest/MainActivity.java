package starace.com.staracetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import starace.com.staracetest.contract.Contract;
import starace.com.staracetest.models.PlaceHolderModel;

public class MainActivity extends AppCompatActivity implements Contract.View {

    private ProgressBar progressBar;

    private PlaceHolderAdapter adapter;

    private Contract.Presenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = Presenter.getPresenterInstance(this);
        setUpViews();
    }

    private void setUpViews() {
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlaceHolderAdapter(new ArrayList<PlaceHolderModel>());
        recyclerView.setAdapter(adapter);

        presenter.requestModelList();
    }

    @Override
    public void updateRecyclerView(List<PlaceHolderModel> placeHolderModelList) {
        adapter.updateAdapterList(placeHolderModelList);
        progressBar.setVisibility(View.GONE);
    }
}
