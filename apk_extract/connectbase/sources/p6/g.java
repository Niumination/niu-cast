package p6;

import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class g implements bf.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f12966a = new h();

    public static class a implements h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.h.a f12967a;

        public a(h9.h.a aVar) {
            this.f12967a = aVar;
        }

        @Override // p6.h.b
        public void a(IBinder iBinder, String str, int i10, boolean z10) {
            h9.h.a aVar = this.f12967a;
            if (aVar != null) {
                aVar.a(iBinder, str, i10, z10);
            }
        }
    }

    @Override // bf.e
    public boolean a(h9.h.a aVar) {
        return this.f12966a.a(new a(aVar));
    }
}
