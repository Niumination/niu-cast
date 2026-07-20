package qc;

import android.content.pm.ActivityInfo;
import com.transsion.hubsdk.content.pm.TranActivityInfo;

/* JADX INFO: loaded from: classes2.dex */
public class a implements jf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranActivityInfo f13900a;

    public a() {
        this.f13900a = null;
        this.f13900a = new TranActivityInfo();
    }

    @Override // jf.a
    public int a(ActivityInfo activityInfo) {
        return this.f13900a.resizeMode(activityInfo);
    }

    @Override // jf.a
    public boolean b(int i10) {
        return this.f13900a.isResizeableMode(i10);
    }
}
