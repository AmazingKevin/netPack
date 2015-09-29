package cn.ddkl.android.netlayer.netbean.interface4n;

import cn.ddkl.android.netlayer.netbean.NetBean;

/**
 * Created by Administrator on 2015/9/18.
 */
public interface TestBean extends NetBean{
    void setResultcode(String resultcode);

    void setReason(String reason);

    void setResult(ResultEntity result);

    void setError_code(int error_code);

    String getResultcode();

    String getReason();

    ResultEntity getResult();

    int getError_code();

    public static class ResultEntity {
        /**
         * province : 广东
         * city : 深圳
         * areacode : 0755
         * zip : 518000
         * company : 中国移动
         * card : 移动全球通卡
         */

        private String province;
        private String city;
        private String areacode;
        private String zip;
        private String company;
        private String card;

        public void setProvince(String province) {
            this.province = province;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setAreacode(String areacode) {
            this.areacode = areacode;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public String getProvince() {
            return province;
        }

        public String getCity() {
            return city;
        }

        public String getAreacode() {
            return areacode;
        }

        public String getZip() {
            return zip;
        }

        public String getCompany() {
            return company;
        }

        public String getCard() {
            return card;
        }
    }
}
