package com.lhc.harlan.mvp.bean;

import android.databinding.BaseObservable;

import java.util.List;

import javax.annotation.Nullable;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/**
 * Created by 23 on 2018/2/5.
 */

public class Test1{
    /**
     * status : 1
     * tel : 客服热线：020-28265666
     * qq : 客服QQ：3142278362
     * banner : [{"imgs":"http://t.6666ht.com/Uploads/201706/59477206aedcf1.png","title":"交强险","url":"http://t.6666ht.com/Home/Index/bannerShow/id/30"},{"imgs":"http://t.6666ht.com/Uploads/201706/5947742de64ee1.png","title":"车损险","url":"http://t.6666ht.com/Home/Index/bannerShow/id/31"},{"imgs":"http://t.6666ht.com/Uploads/201706/5947749f43d431.png","title":"第三者责任险","url":"http://t.6666ht.com/Home/Index/bannerShow/id/32"},{"imgs":"http://t.6666ht.com/Uploads/201706/5947902f8cd981.png","title":"全车盗抢险","url":"http://t.6666ht.com/Home/Index/bannerShow/id/34"},{"imgs":"http://t.6666ht.com/Uploads/201706/5947a3c8350611.png","title":"车上人员责任险","url":"http://t.6666ht.com/Home/Index/bannerShow/id/35"},{"imgs":"http://t.6666ht.com/Uploads/201706/5947a414a9b081.png","title":"自然损失险","url":"http://t.6666ht.com/Home/Index/bannerShow/id/36"},{"imgs":"http://t.6666ht.com/Uploads/201706/5947a44bec9451.png","title":"玻璃单独破碎险","url":"http://t.6666ht.com/Home/Index/bannerShow/id/37"},{"imgs":"http://t.6666ht.com/Uploads/201706/5947a46c4e9e61.png","title":"车身划痕险","url":"http://t.6666ht.com/Home/Index/bannerShow/id/38"},{"imgs":"http://t.6666ht.com/Uploads/201706/5947a48c4677b1.png","title":"不计免赔","url":"http://t.6666ht.com/Home/Index/bannerShow/id/39"}]
     */

    private int status;
    private String tel;
    private String qq;
    private List<BannerBean> banner;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }



    public static class BannerBean {
        /**
         * imgs : http://t.6666ht.com/Uploads/201706/59477206aedcf1.png
         * title : 交强险
         * url : http://t.6666ht.com/Home/Index/bannerShow/id/30
         */

        private String imgs;
        private String title;
        private String url;

        public String getImgs() {
            return imgs;
        }

        public void setImgs(String imgs) {
            this.imgs = imgs;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
