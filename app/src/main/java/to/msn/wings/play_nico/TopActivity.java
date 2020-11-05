package to.msn.wings.play_nico;



import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Date;


public class TopActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_list, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch(itemId) {
            case R.id.opt_my_page:
                Toast toast = Toast.makeText(this, new Date().toString(),Toast.LENGTH_LONG);
                toast.show();

                break;

            case R.id.opt_temp_my_list:

                break;

            case R.id.opt_cache_manager:

                break;

            case R.id.opt_movie_id_input:
                Intent i = new Intent(this, to.msn.wings.play_nico.SettingActivity.class);
                startActivity(i);
                break;

            case R.id.opt_setting:
                linearSectionedRecyclerViewVertical();
                break;
        }


        return super.onOptionsItemSelected(item);

    }

    private void linearSectionedRecyclerViewVertical() {
        startRecyclerViewActivity(RecyclerViewType.LINEAR_VERTICAL);
    }

    private void linearSectionedRecyclerViewHorizontal() {
        startRecyclerViewActivity(RecyclerViewType.LINEAR_HORIZONTAL);
    }

    private void gridSectionedRecyclerView() {
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
