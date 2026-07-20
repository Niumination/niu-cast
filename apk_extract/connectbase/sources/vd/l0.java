package vd;

import android.os.UserHandle;
import com.transsion.hubsdk.os.TranUserHandle;

/* JADX INFO: loaded from: classes2.dex */
public class l0 {
    public static UserHandle a() {
        return TranUserHandle.ALL;
    }

    public static int b(int i10) {
        return new TranUserHandle().getAppId(i10);
    }

    public static UserHandle c() {
        return TranUserHandle.CURRENT;
    }

    public static int d(int i10) {
        return TranUserHandle.getUserId(i10);
    }

    public static boolean e() {
        return TranUserHandle.isSystem();
    }

    public static int f() {
        return TranUserHandle.myUserId();
    }

    public static UserHandle g(int i10) {
        return TranUserHandle.of(i10);
    }
}
