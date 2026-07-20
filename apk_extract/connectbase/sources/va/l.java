package va;

import java.io.File;
import vd.a0;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16794a = "l";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static pg.j f16795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static pg.j f16796c;

    public static pg.j a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16794a, "TranThubSELinux");
            pg.j jVar = f16795b;
            if (jVar != null) {
                return jVar;
            }
            a0 a0Var = new a0();
            f16795b = a0Var;
            return a0Var;
        }
        dc.e.f(f16794a, "TranAospSELinux");
        pg.j jVar2 = f16796c;
        if (jVar2 != null) {
            return jVar2;
        }
        e8.n nVar = new e8.n();
        f16796c = nVar;
        return nVar;
    }

    public static boolean b(File file) {
        return a(fc.b.a.f5987g).a(file);
    }
}
