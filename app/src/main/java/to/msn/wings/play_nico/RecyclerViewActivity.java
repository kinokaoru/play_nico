package to.msn.wings.play_nico;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.MenuItem;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    protected static final String RECYCLER_VIEW_TYPE = "recycler_view_type";
    private RecyclerViewType recyclerViewType;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        //get enum type passed from MainActivity
        recyclerViewType = (RecyclerViewType) getIntent().getSerializableExtra(RECYCLER_VIEW_TYPE);
        setUpToolbarTitle(getString(R.string.setting));
        setUpRecyclerView();
        populateRecyclerView();
    }

    //set toolbar title and set back button
    private void setUpToolbarTitle(String title) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);
    }

    //setup recycler view
    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.sectioned_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    //populate recycler view
    private void populateRecyclerView() {
        ArrayList<SectionModel> sectionModelArrayList = new ArrayList<>();

        Resources res = getResources();

        TypedArray accountArray = res.obtainTypedArray(R.array.account_setting_items);
        TypedArray playerArray = res.obtainTypedArray(R.array.player_setting_items);
        TypedArray cacheArray = res.obtainTypedArray(R.array.cache_setting_items);

        CharSequence[][] transposedAccountArray = typedToTransposedCharSequenceArray(accountArray);
        CharSequence[][] transposedPlayerArray = typedToTransposedCharSequenceArray(playerArray);
        CharSequence[][] transposedCacheArray = typedToTransposedCharSequenceArray(cacheArray);

        ArrayList<CharSequence> settingClassNames = new ArrayList<CharSequence>(Arrays.asList(res.getStringArray(R.array.setting_class_names)));

        ArrayList<CharSequence> accountTitles = new ArrayList<>(Arrays.asList(transposedAccountArray[0]));
        ArrayList<CharSequence> accountDescs = new ArrayList<>(Arrays.asList(transposedAccountArray[1]));
        ArrayList<CharSequence> accountIdentifiers = new ArrayList<>(Arrays.asList(transposedAccountArray[2]));

        ArrayList<CharSequence> playerTitles = new ArrayList<>(Arrays.asList(transposedPlayerArray[0]));
        ArrayList<CharSequence> playerDescs = new ArrayList<>(Arrays.asList(transposedPlayerArray[1]));
        ArrayList<CharSequence> playerIdentifiers = new ArrayList<>(Arrays.asList(transposedPlayerArray[2]));

        ArrayList<CharSequence> cacheTitles = new ArrayList<>(Arrays.asList(transposedCacheArray[0]));
        ArrayList<CharSequence> cacheDescs = new ArrayList<>(Arrays.asList(transposedCacheArray[1]));
        ArrayList<CharSequence> cacheIdentifiers = new ArrayList<>(Arrays.asList(transposedCacheArray[2]));


        sectionModelArrayList.add(new SectionModel(settingClassNames.get(0), accountTitles, accountDescs, accountIdentifiers));
        sectionModelArrayList.add(new SectionModel(settingClassNames.get(1), playerTitles, playerDescs, playerIdentifiers));
        sectionModelArrayList.add(new SectionModel(settingClassNames.get(2), cacheTitles, cacheDescs, cacheIdentifiers));

        SectionRecyclerViewAdapter adapter = new SectionRecyclerViewAdapter(this, recyclerViewType, sectionModelArrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public CharSequence[][] typedToTransposedCharSequenceArray(TypedArray typedArray){
        int numberOfRows = typedArray.getTextArray(0).length;
        int numberOfCols = typedArray.length();
        CharSequence[][]  transposedArray = new CharSequence[numberOfRows][numberOfCols];
        for(int i=0 ; i<numberOfCols ; i++) {
            CharSequence[] item = typedArray.getTextArray(i);
            for(int j=0 ; j<numberOfRows ; j++) {
                transposedArray[j][i] = item[j];
            }
        }
        return transposedArray;
    }
}
