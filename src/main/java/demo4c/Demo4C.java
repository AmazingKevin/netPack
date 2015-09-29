package demo4c;

import android.content.Context;

import cn.ddkl.android.debug.W;
import cn.ddkl.android.netlayer.HttpHandler;
import cn.ddkl.android.netlayer.callback.NetCallBack;
import cn.ddkl.android.netlayer.netbean.NetBeanType;
import cn.ddkl.android.netlayer.netbean.interface4n.AddCategoryResponse;

/**
 * Created by Administrator on 2015/9/24.
 */
public class Demo4C {

    public void runDemo(Context context)
    {
        HttpHandler.init(context);
      /*  AddCategory json = new AddCategory();
        json.setName("王小二").setDealerCode("5280").setParentId(120);*/

          HttpHandler.getInstance() .postJson("123", NetBeanType.AddCategory, new Object(), new NetCallBack<AddCategoryResponse>() {
              @Override
              public void onError(Exception e) {
                  W.w("onError:", "错误信息:" + e.getMessage());
              }

              @Override
              public void onException(String errorCode, String errorMsg) {
                  W.w("onException:","errorCode:"+errorCode+"errorMsg:"+errorMsg);
              }

              @Override
              public void onSuccess(AddCategoryResponse response) {
                  W.w("onSuccess:",response.getValues().getCreateDateStr());
                  W.w("onSuccess:",response.getValues().getCreateDate()+"");
                  W.w("onSuccess:",response.getValues().getDealerCode());
                  W.w("onSuccess:",response.getValues().getName());
                  W.w("onSuccess:",response.getValues().getId()+"");
              }
          });

    }
}
