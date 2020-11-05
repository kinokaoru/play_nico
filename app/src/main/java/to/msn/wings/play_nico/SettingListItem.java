package to.msn.wings.play_nico;

import android.view.View;

public class SettingListItem {
    private long id = 0;
    private String title = null;
    private String desc = null;
    private String viewType = "list_setting";

    SettingListItem(String title, String desc, String viewType) {
        this.title = title;
        this.desc = desc;
        this.viewType = viewType;
    }

    SettingListItem(String title, String desc) {
        this.title = title;
        this.desc = desc;
        this.viewType = "list_setting";
    }

    long getId() { return id; }
    String getTitle() { return title; }
    String getDesc() { return desc; }
    String getViewType() { return viewType; }

    void setId(long id) { this.id = id; }
    void setTitle(String title) { this.title = title; }
    void setDesc(String desc) { this.desc = desc; }
    void setViewType(String view_type) { this.viewType = view_type; }
}
