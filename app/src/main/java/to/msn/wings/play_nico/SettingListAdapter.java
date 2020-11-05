//package to.msn.wings.play_nico;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import java.util.ArrayList;
//
////表示するデータソースを管理するクラス
//public class SettingListAdapter extends RecyclerView.Adapter<SettingViewHolder> {
//
//    static final int VIEWTYPE_LIST_SETTING = 0;
//    static final int VIEWTYPE_LIST__SETTING_CHECK_BOX = 1;
//
//    private ArrayList<SettingListItem> settingListItems;
//    private View.OnClickListener m_listener;
//    private int m_line;
//
//
//
//    public SettingListAdapter(ArrayList<SettingListItem> settingListItems) {
//        this.settingListItems = settingListItems;
//    }
//
//    @NonNull
//    @Override
//    public SettingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        SettingViewHolder vh = null;
//        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//
//        switch (viewType) {
//            case VIEWTYPE_LIST_SETTING: {
//                vh = new SettingViewHolder(inflater.inflate(R.layout.list_setting,viewGroup, false));
//            }
//            case VIEWTYPE_LIST__SETTING_CHECK_BOX: {
//                vh = new SettingViewHolder(inflater.inflate(R.layout.list_setting_checkbox,viewGroup, false));;
//            }
//
//            default: {
//
//            }
//        }
//
//        return vh;
//    }
//
//
//
//    @Override
//    public void onBindViewHolder(SettingViewHolder vh, int position) {
//        vh.title.setText(this.settingListItems.get(position).getTitle());
//        vh.desc.setText(this.settingListItems.get(position).getDesc());
//
//        final int pos = position;
//        // リスト上のボタンが押された時に上で登録したクリックリスナーを呼び出してあげる
//        vh.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                m_line = pos;
//                m_listener.onClick(view);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return this.settingListItems.size();
//    }
//
////    @Override
////    public int getItemViewType(int position) {
////        if (position == 0) {
////            return STRING_HEADER;
////        } else if (position < mStrings.size() + 1) {
////            return STRING_DATA;
////        } else if (position == mStrings.size() + 1) {
////            return NUMBER_HEADER;
////        } else {
////            return NUMBER_DATA;
////        }
////    }
//
//    public void setOnItemClickListener(View.OnClickListener listener){
//        m_listener = listener;
//    }
//
//    public int getLine(){
//        return m_line; //行数を取得
//    }
//}




