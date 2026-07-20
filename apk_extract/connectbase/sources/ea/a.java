package ea;

import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static fd.a f4166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static n7.a f4167b;

    public static int a(float f10) {
        return b(b.a.f5986f).a(f10);
    }

    public static yf.a b(String str) {
        if (b.b(str)) {
            fd.a aVar = f4166a;
            if (aVar != null) {
                return aVar;
            }
            fd.a aVar2 = new fd.a();
            f4166a = aVar2;
            return aVar2;
        }
        n7.a aVar3 = f4167b;
        if (aVar3 != null) {
            return aVar3;
        }
        n7.a aVar4 = new n7.a();
        f4167b = aVar4;
        return aVar4;
    }
}
