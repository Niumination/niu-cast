package d7;

import android.graphics.Outline;
import ks.g;

/* JADX INFO: loaded from: classes2.dex */
public class d implements of.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3622a = "d";

    @Override // of.d
    public boolean a() {
        return false;
    }

    @Override // of.d
    public void b(Outline outline, int i10, int i11, int i12, int i13, float f10, int i14) {
        String str = f3622a;
        StringBuilder sbA = i0.a.a("aosp not support setSmoothRoundRect [", i10, g.f9491d, i11, ", ");
        sbA.append(i12);
        sbA.append(", ");
        sbA.append(i13);
        sbA.append("], radius=");
        sbA.append(f10);
        dc.e.n(str, sbA.toString());
    }
}
