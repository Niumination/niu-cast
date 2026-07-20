package id;

import android.content.Context;
import android.os.Handler;
import dc.e;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements bg.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7928b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7929a = bc.a.a();

    @Override // bg.a
    public Handler getHandler() {
        Handler handler = (Handler) new f(this.f7929a).c(new a(), "");
        e.f(f7928b, "getHandler mHandler:" + handler);
        return handler;
    }
}
