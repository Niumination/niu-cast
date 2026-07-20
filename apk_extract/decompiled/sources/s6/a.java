package s6;

import android.text.TextUtils;
import m3.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f9515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9516d;

    /* JADX WARN: Code duplicated, block: B:20:0x0047  */
    public final boolean a() {
        boolean z2;
        b bVar = this.f9515c;
        int i8 = bVar.f;
        int i9 = bVar.f9521g;
        int i10 = bVar.f9522h;
        int i11 = bVar.f9518b;
        int i12 = bVar.f9519c;
        if (i11 == 100 && i8 == 0 && i9 == 100 && i10 == 1 && i12 == 1) {
            return true;
        }
        String strB = !TextUtils.isEmpty(z6.b.b()) ? z6.b.b() : g0.h(e8.b.f4712i);
        if (TextUtils.isEmpty(strB)) {
            z2 = true;
        } else {
            int iAbs = Math.abs(strB.hashCode()) % (i10 * 100);
            if (iAbs < i8 || iAbs > i9) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        boolean z3 = Math.abs(m6.a.f7947d.nextInt()) % (i12 * 100) < i11;
        if (d.p || TextUtils.equals(d.q, "test")) {
            z6.a.e("gaidHashHit: " + z2 + " eventHashHit: " + z3 + " gmin = " + i8 + " gmax = " + i9);
        }
        return z2 && z3;
    }
}
