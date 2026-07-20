package da;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ed.i f3658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static m7.j f3659b;

    public static Intent a(int i10) {
        return b(fc.b.a.f5988h).a(i10);
    }

    public static xf.e b(String str) {
        if (fc.b.b(str)) {
            ed.i iVar = f3658a;
            if (iVar != null) {
                return iVar;
            }
            ed.i iVar2 = new ed.i();
            f3658a = iVar2;
            return iVar2;
        }
        m7.j jVar = f3659b;
        if (jVar != null) {
            return jVar;
        }
        m7.j jVar2 = new m7.j();
        f3659b = jVar2;
        return jVar2;
    }
}
