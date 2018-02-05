package com.lhc.harlan.mvp.http;




import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lhc.harlan.mvp.AppConstants;
import com.lhc.harlan.mvp.HttpConstants;
import com.lhc.harlan.mvp.base.BaseEntity;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Dell on 2017/7/26.
 * Created time:2017/7/26 14:50
 */

public class RetrofitManager {

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;
    private static RetrofitManager sInstace;

    /**
     * 私有构造方法
     */
    private RetrofitManager() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        File cacheFile = new File(AppConstants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!CommonUtils.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (CommonUtils.isNetworkConnected()) {
                    int maxAge = 0;
                    // 有网络时, 不缓存, 最大保存时长为0
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };

        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(new MLoggerIntercrptor("SmartCommunityHttp", true));
        builder.cache(cache);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        mOkHttpClient = builder.build();

        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(HttpProvider.getHttpIpAdds())
                .client(mOkHttpClient)
                .build();
    }

    /**
     * 创建单例
     */
    public static RetrofitManager getInstace() {
        if (sInstace == null) {
            synchronized (RetrofitManager.class) {
                sInstace = new RetrofitManager();
            }
        }
        return sInstace;
    }

    private Gson buildGson() {
        return new GsonBuilder()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();
    }

    /**
     * 更改请求头
     *
     * @param newApiHeaders
     */
    public void addApiHeader(Map<String, String> newApiHeaders) {
        mOkHttpClient.newBuilder().addInterceptor(new MLoggerIntercrptor("SmartCommunityHttp", true, newApiHeaders)).build();
        getRetrofit().newBuilder().client(mOkHttpClient).build();
    }



    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public OkHttpClient getmOkHttpClient(){
        return mOkHttpClient;
    }

    Observable.Transformer schedulersTransformer() {
        return new Observable.Transformer() {
            @Override
            public Object call(Object observable) {
                return ((Observable) observable).subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public <T> Observable.Transformer<BaseEntity<T>, BaseEntity<T>> transformer() {
        return new Observable.Transformer() {
            @Override
            public Object call(Object observable) {
                return ((Observable) observable).map(new HandleFuc<T>()).onErrorResumeNext(new HttpResponseFunc<T>());
            }
        };
    }

    private static class HttpResponseFunc<T> implements Func1<Throwable, Observable<T>> {
        @Override
        public Observable<T> call(Throwable t) {
            return Observable.error(ExceptionHandle.handleException(t));
        }
    }

    private class HandleFuc<T> implements Func1<BaseEntity<T>, BaseEntity<T>> {
        @Override
        public BaseEntity<T> call(BaseEntity<T> response) {
            if (!response.isSuccess()) {
//                throw new RuntimeException(response.getCode() + "" + response.getResult() != null ? response.getResult() : "");
                if (response.getResultCode() != HttpConstants.OPERAT_OK){  // 操作成功
                    throw ExceptionHandle.handleHttpException(response);
                }
            }
            return response;
        }
    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

    public  <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
