package c8;

import android.content.Context;
import android.service.notification.Condition;
import android.service.notification.ZenModeConfig;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1381b = "TranAospZenModeConfig";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1382a;

    public c(Context context) {
        this.f1382a = context;
    }

    public static Condition a(Context context, int i10, int i11) {
        return ZenModeConfig.toTimeCondition(context, i10, i11);
    }
}
