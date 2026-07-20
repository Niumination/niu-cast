package com.transsion.core.utils;

import com.transsion.core.CoreUtil;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionUtil {
    public static boolean lacksPermission(String str) {
        return CoreUtil.getContext().checkSelfPermission(str) == -1;
    }

    public static boolean lacksPermissions(String... strArr) {
        for (String str : strArr) {
            if (lacksPermission(str)) {
                return true;
            }
        }
        return false;
    }
}
