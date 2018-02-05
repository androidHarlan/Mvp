package com.lhc.harlan.mvp;

import java.io.File;

/**
 * Created by 23 on 2018/2/2.
 */

public class AppConstants {
    public static final String PATH_DATA = BaseApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";
    /*** 操作成功*/
    public static final int OPERAT_OK = 10005;
}
