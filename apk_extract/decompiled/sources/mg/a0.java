package mg;

import android.os.SystemClock;
import cf.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements hf.v, l2.a {
    public static j0 b(int i8) {
        return new j0(new qj.f(), Math.min(1048576, Math.max(4096, i8)));
    }

    @Override // l2.a
    public long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // hf.v
    public void onCompleted() {
    }

    @Override // hf.v
    public void onError(Throwable th2) {
    }

    @Override // hf.v
    public void onNext(Object obj) {
    }
}
