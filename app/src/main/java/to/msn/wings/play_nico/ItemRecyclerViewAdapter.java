package to.msn.wings.play_nico;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter {

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle;
        private TextView itemDesc;
        int viewType = 0;

        public ItemViewHolder(View itemView ) {
            super(itemView);
            itemTitle = (TextView) itemView.findViewById(R.id.item_title);
            itemDesc = (TextView) itemView.findViewById(R.id.item_desc);
        }
    }

    class SettingViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle;
        private TextView itemDesc;
        int viewType = 0;

        public SettingViewHolder(View itemView ) {
            super(itemView);
            itemTitle = (TextView) itemView.findViewById(R.id.setting_title);
            itemDesc = (TextView) itemView.findViewById(R.id.setting_desc);
        }
    }

    class SettingCheckBoxViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle;
        private TextView itemDesc;
        int viewType = 1;

        public SettingCheckBoxViewHolder(View itemView) {
            super(itemView);
            itemTitle = (TextView) itemView.findViewById(R.id.setting_checkbox_title);
            itemDesc = (TextView) itemView.findViewById(R.id.setting_checkbox_desc);
        }
    }

    class ListData {
        CharSequence itemTitle = "";
        CharSequence itemDescs = "";
        int viewType = 0;

        ListData (CharSequence itemTitle,CharSequence itemDescs, int viewType) {
            this.itemTitle = itemTitle;
            this.itemDescs = itemDescs;
            this.viewType = viewType;
        }
    }

    private Context context;
    private SectionModel sectionModel;
    private ArrayList<CharSequence> itemTitleList;
    private ArrayList<CharSequence> itemDescList;
    private ArrayList<CharSequence> layoutIdentifierList;

    private final int VIEWTYPE_SETTING_CHECKBOX = 1;
    private final int VIEWTYPE_SETTING = 0;

    private ArrayList<ListData> itemList = new ArrayList<>();

    public ItemRecyclerViewAdapter(Context context, SectionModel sectionModel) {
        this.context = context;
        this.sectionModel = sectionModel;
        this.itemTitleList = sectionModel.getItemTitleList();
        this.itemDescList = sectionModel.getItemDescList();
        this.layoutIdentifierList = sectionModel.getLayoutIdentifierList();
        init();
    }

    private void init () {
        for (int i = 0; i<sectionModel.getItemCount(); i++) {
            //見出し(メーカー名)
            switch((String)layoutIdentifierList.get(i)){
                case "list_setting":
                    itemList.add(new ListData(itemTitleList.get(i),itemDescList.get(0),0));
                case "list_setting_checkbox":
                    itemList.add(new ListData(itemTitleList.get(i),itemDescList.get(0),1));
            }
        }
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        //viewTypeによって返すViewHolderを変える
        if (viewType== VIEWTYPE_SETTING) {
            vh = new SettingViewHolder(inflater.inflate(R.layout.list_setting,parent, false));
        } else {
            vh = new SettingCheckBoxViewHolder(inflater.inflate(R.layout.list_setting_checkbox,parent, false));
        }

        return vh;
//        switch (viewType){
        ////            case VIEWTYPE_SETTING:
        ////                vh = new SettingViewHolder(inflater.inflate(R.layout.list_setting,parent, false));
        ////            case VIEWTYPE_SETTING_CHECKBOX:
        ////                vh = new SettingCheckBoxViewHolder(inflater.inflate(R.layout.list_setting_checkbox,parent, false));
        ////        }
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_row_layout, parent, false);
//        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListData data = itemList.get(position);

        if (data.viewType == VIEWTYPE_SETTING) {
            ((SettingViewHolder) holder).itemTitle.setText(data.itemTitle);
            ((SettingViewHolder) holder).itemDesc.setText(data.itemDescs);
        } else {
            ((SettingCheckBoxViewHolder) holder).itemTitle.setText(data.itemTitle);
            ((SettingCheckBoxViewHolder) holder).itemDesc.setText(data.itemDescs);
        }
    }

    @Override
    public int getItemCount() {
        return itemTitleList.size();
    }


}