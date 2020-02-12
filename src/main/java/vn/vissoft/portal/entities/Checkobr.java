package vn.vissoft.portal.entities;

public class Checkobr {
    private int ObjectId;
    private int orId;
    private String ObjectName;
    private  Boolean isSelected;

    public Checkobr() {
    }

    public Checkobr(int objectId, int orId, String objectName, Boolean isSelected) {
        ObjectId = objectId;
        this.orId = orId;
        ObjectName = objectName;
        this.isSelected = isSelected;
    }

    public void setOrId(int orId) {
        this.orId = orId;
    }

    public int getOrId() {
        return orId;
    }

    public void setObjectId(int objectId) {
        ObjectId = objectId;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public int getObjectId() {
        return ObjectId;
    }

    public String getObjectName() {
        return ObjectName;
    }

    public Boolean getSelected() {
        return isSelected;
    }
}
