package to.msn.wings.play_nico;

import java.util.ArrayList;

/**
 * Created by sonu on 24/07/17.
 */

public class SectionModel {
    private CharSequence sectionLabel;
    private ArrayList<CharSequence> itemTitleList;
    private ArrayList<CharSequence> itemDescList;
    private ArrayList<CharSequence> layoutIdentifierList;

    public SectionModel(CharSequence sectionLabel, ArrayList<CharSequence> itemTitleList, ArrayList<CharSequence> itemDescList, ArrayList<CharSequence> layoutIdentifierList) {
        this.sectionLabel = sectionLabel;
        this.itemTitleList = itemTitleList;
        this.itemDescList = itemDescList;
        this.layoutIdentifierList = layoutIdentifierList;
    }

    public CharSequence getSectionLabel() {
        return sectionLabel;
    }
    public ArrayList<CharSequence> getItemTitleList() { return itemTitleList; }
    public ArrayList<CharSequence> getItemDescList() { return itemDescList; }
    public ArrayList<CharSequence> getLayoutIdentifierList() { return layoutIdentifierList; }
    public int getItemCount() {return this.itemTitleList.size();}

}
