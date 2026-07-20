package hb;

import dc.e;
import fc.b;
import java.util.Optional;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7100a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static he.a f7101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static r8.a f7102c;

    public static bh.a a(String str) {
        if (b.b(str)) {
            e.f(f7100a, "TranThubSetupWizardProperties");
            he.a aVar = f7101b;
            if (aVar != null) {
                return aVar;
            }
            he.a aVar2 = new he.a();
            f7101b = aVar2;
            return aVar2;
        }
        e.f(f7100a, "TranAospSetupWizardProperties");
        r8.a aVar3 = f7102c;
        if (aVar3 != null) {
            return aVar3;
        }
        r8.a aVar4 = new r8.a();
        f7102c = aVar4;
        return aVar4;
    }

    public static Optional<String> b() {
        return a(b.a.f5989i).a();
    }
}
