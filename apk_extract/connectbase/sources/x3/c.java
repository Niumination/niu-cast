package x3;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.transsion.athena.data.TrackData;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f20004b;

    public c(Context context) {
        this.f20003a = context;
    }

    public void a() {
    }

    public void b(int i10) {
    }

    public abstract void c(Message message, long j10);

    public abstract void d(Runnable runnable);

    public abstract void e(Runnable runnable, long j10);

    public abstract void f(String str, TrackData trackData, long j10);

    public Handler g() {
        return this.f20004b;
    }

    public boolean h() {
        return true;
    }

    public void i() {
    }
}
