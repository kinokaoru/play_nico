package to.msn.wings.play_nico;


import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Random;

public class PlayerSettingActivity extends AppCompatActivity {

    public static RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ArrayList<SettingListItem> data = new ArrayList<>();
        TypedArray playerSettingArray = getResources().obtainTypedArray(
                                                    R.array.setting_items);

        final int[] resourceIds = new int[playerSettingArray.length()];
        for (int i = 0; i < resourceIds.length; ++i) {
            int resourceId = playerSettingArray.getResourceId(i, 0);
            String[] array = getResources().getStringArray(resourceId);
            SettingListItem item = new SettingListItem(array[0], array[1], array[2]);
            item.setId((new Random()).nextLong());
            data.add(item);
        }

        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
//        mMergeRecyclerAdapter = new RecyclerViewMergeAdapter()(this);
        //GridLayoutManager manager = new GridLayoutManager(this, 2);
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
//
//                        break;
//
//                    case 1:
//
//                        break;
//
//                    case 2:
//
//                        break;
//                }
//            }
//        });
    }
}