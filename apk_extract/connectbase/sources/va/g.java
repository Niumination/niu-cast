package va;

import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e8.f f16774a;

    public pg.f a() {
        e8.f fVar = this.f16774a;
        if (fVar != null) {
            return fVar;
        }
        e8.f fVar2 = new e8.f();
        this.f16774a = fVar2;
        return fVar2;
    }

    public void b(Looper looper, long j10) {
        if (looper == null) {
            throw new NullPointerException("Looper cannot be null");
        }
        a().a(looper, j10);
    }
}
