package af;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class h4 extends ze.c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f309a = 0;

    @Override // ze.c1
    public String a() {
        return "pick_first";
    }

    @Override // ze.c1
    public int b() {
        return 5;
    }

    @Override // ze.c1
    public boolean c() {
        return true;
    }

    @Override // ze.c1
    public final ze.b1 d(ze.f0 f0Var) {
        return new g4(f0Var);
    }

    @Override // ze.c1
    public ze.s1 e(Map map) {
        try {
            return new ze.s1(new d4(j2.b("shuffleAddressList", map)));
        } catch (RuntimeException e) {
            return new ze.s1(ze.q2.f11411n.g(e).h("Failed parsing configuration for " + a()));
        }
    }
}
