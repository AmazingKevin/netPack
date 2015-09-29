package cn.ddkl.android.netlayer.netbean.implement4n;

import cn.ddkl.android.netlayer.netbean.interface4n.AddCategoryResponse;

/**
 * Created by Administrator on 2015/9/24.
 */
public class AddCategoryResponseImp implements AddCategoryResponse {


    /**
     * executeStatus : 0
     * values : {"id":469719,"name":"lisi","dealerCode":"338","parentId":26,"parentName":null,"createDate":1443059262000,"createDateStr":"今天","isChecked":null,"isExpansion":null,"child":null}
     * errorCode :
     * errorMsg :
     */

    private String executeStatus;
    private ValuesEntity values;
    private String errorCode;
    private String errorMsg;


    public String getExecuteStatus() {
        return executeStatus;
    }

    @Override
    public ValuesEntity getValues() {
        return values;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
