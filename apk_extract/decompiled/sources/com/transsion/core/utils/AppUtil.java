package com.transsion.core.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.transsion.core.CoreUtil;

/* JADX INFO: loaded from: classes2.dex */
public class AppUtil {
    public static String getAppName() {
        try {
            PackageManager packageManager = CoreUtil.getContext().getPackageManager();
            return packageManager != null ? packageManager.getPackageInfo(CoreUtil.getContext().getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getInstallerPackageName() {
        try {
            return CoreUtil.getContext().getPackageManager().getInstallerPackageName(getPkgName());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getPkgName() {
        return CoreUtil.getContext().getPackageName();
    }

    public static int getVersionCode() {
        Context context = CoreUtil.getContext();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getVersionName() {
        Context context = CoreUtil.getContext();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
