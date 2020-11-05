package to.msn.wings.play_nico;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class SettingActivity extends AppCompatActivity {

    public static RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String[] titles = getResources().getStringArray(R.array.setting_items);
//        String[] descs = getResources().getStringArray(R.array.setting_item_descs);
//        ArrayList<SettingListItem> data = new ArrayList<>();
//        for (int i = 0; i < titles.length; i++) {
//            SettingListItem item = new SettingListItem(titles[i], descs[i]);
//            item.setId((new Random()).nextLong());
//            data.add(item);
//        }
//
//        RecyclerView rv = findViewById(R.id.rv);
//        rv.setHasFixedSize(true);
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        //GridLayoutManager manager = new GridLayoutManager(this, 2);
//        rv.setLayoutManager(manager);
//        this.adapter = new SettingListAdapter(data);
//        rv.setAdapter(adapter);
//        ((SettingListAdapter) adapter).setOnItemClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int line = ((SettingListAdapter) adapter).getLine();
//
//                switch(line) {
//                    case 0:
//                        Intent i0 = new Intent(
//                                SettingActivity.this, to.msn.wings.play_nico.LoginActivity.class);
//                        startActivity(i0);
//                        break;
//
//                    case 1:
//                        Intent i1 = new Intent(
//                                SettingActivity.this, to.msn.wings.play_nico.PlayerSettingActivity.class);
//                        startActivity(i1);
//                        break;
//
//                    case 2:
//                        Intent i2 = new Intent(
//                                SettingActivity.this, to.msn.wings.play_nico.CacheSettingActivity.class);
//                        startActivity(i2);
//                        break;
//                }
//            }
//        });
    }

    public void linearSectionedRecyclerViewVertical(View view) {
        startRecyclerViewActivity(RecyclerViewType.LINEAR_VERTICAL);
    }

    public void linearSectionedRecyclerViewHorizontal(View view) {
        startRecyclerViewActivity(RecyclerViewType.LINEAR_HORIZONTAL);
    }

    public void gridSectionedRecyclerView(View view) {
        startRecyclerViewActivity(RecyclerViewType.GRID);
    }

    /**
     * method to start RecyclerViewActivity
     *
     * @param recyclerViewType enum type to show recyclerview on basis if button call
     */
    private void startRecyclerViewActivity(RecyclerViewType recyclerViewType) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RecyclerViewActivity.RECYCLER_VIEW_TYPE, recyclerViewType);
        startActivity(new Intent(this, RecyclerViewActivity.class).putExtras(bundle));
    }
}

