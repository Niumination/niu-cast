package cj;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public class a implements aj.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final aj.c f1455b = new a(dj.d.a.f3705a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f1456a;

    public a(Handler handler) {
        this.f1456a = handler;
    }

    @Override // aj.c
    public void a(Runnable runnable) {
        Handler handler = this.f1456a;
        if (handler != null) {
            handler.post(runnable);
        }
    }
}
