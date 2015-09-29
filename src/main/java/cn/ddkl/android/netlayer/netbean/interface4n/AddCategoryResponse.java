package cn.ddkl.android.netlayer.netbean.interface4n;

import cn.ddkl.android.netlayer.netbean.NetBean;

/**
 * Created by Administrator on 2015/9/24.
 */
public interface AddCategoryResponse extends NetBean {
    ValuesEntity getValues();

    public static class ValuesEntity {
        /**
         * id : 469719
         * name : lisi
         * dealerCode : 338
         * parentId : 26
         * parentName : null
         * createDate : 1443059262000
         * createDateStr : 今天
         * isChecked : null
         * isExpansion : null
         * child : null
         */

        private int id;
        private String name;
        private String dealerCode;
        private int parentId;
        private Object parentName;
        private long createDate;
        private String createDateStr;
        private Object isChecked;
        private Object isExpansion;
        private Object child;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDealerCode(String dealerCode) {
            this.dealerCode = dealerCode;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public void setParentName(Object parentName) {
            this.parentName = parentName;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public void setCreateDateStr(String createDateStr) {
            this.createDateStr = createDateStr;
        }

        public void setIsChecked(Object isChecked) {
            this.isChecked = isChecked;
        }

        public void setIsExpansion(Object isExpansion) {
            this.isExpansion = isExpansion;
        }

        public void setChild(Object child) {
            this.child = child;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDealerCode() {
            return dealerCode;
        }

        public int getParentId() {
            return parentId;
        }

        public Object getParentName() {
            return parentName;
        }

        public long getCreateDate() {
            return createDate;
        }

        public String getCreateDateStr() {
            return createDateStr;
        }

        public Object getIsChecked() {
            return isChecked;
        }

        public Object getIsExpansion() {
            return isExpansion;
        }

        public Object getChild() {
            return child;
        }

        @Override
        public String toString() {
            return "ValuesEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", dealerCode='" + dealerCode + '\'' +
                    ", parentId=" + parentId +
                    ", parentName=" + parentName +
                    ", createDate=" + createDate +
                    ", createDateStr='" + createDateStr + '\'' +
                    ", isChecked=" + isChecked +
                    ", isExpansion=" + isExpansion +
                    ", child=" + child +
                    '}';
        }
    }
}
