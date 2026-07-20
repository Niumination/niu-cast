package p8;

import k3.o9;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements fa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f8701a = o9.a("com.transsion.hubsdk.tranthubutils.TranAppProperties");

    @Override // fa.a
    public final void a(String str) {
        Class cls = f8701a;
        if (cls == null) {
            return;
        }
        o9.e(cls, o9.d(cls, "initialize", String.class), str);
    }

    @Override // fa.a
    public final String get(String str) {
        Class cls = f8701a;
        return cls == null ? "" : (String) o9.e(cls, o9.d(cls, "get", String.class), str);
    }
}
