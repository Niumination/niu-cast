package jd;

import android.content.Context;
import com.transsion.hubsdk.internal.policy.TranSystemBarUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b implements cg.b {
    @Override // cg.b
    public int a(Context context) {
        return TranSystemBarUtils.getStatusBarHeight(context);
    }
}
