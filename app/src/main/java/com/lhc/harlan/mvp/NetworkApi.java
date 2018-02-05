package com.lhc.harlan.mvp;




import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Dell on 2017/7/7.
 */

public interface NetworkApi {






    @GET(HttpConstants.test)
    Observable<String> getCode();
  //  Observable<BaseEntity<String>> getCode(@Body User codeBean);




}
