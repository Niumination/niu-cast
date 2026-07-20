package f9;

import w9.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f5012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r8.b f5013b;

    public final ha.a a() {
        if (l9.b.a(l9.a.f)) {
            b bVar = this.f5012a;
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            this.f5012a = bVar2;
            return bVar2;
        }
        j9.a.c("a", "TranAospWindowManagerExtra");
        r8.b bVar3 = this.f5013b;
        if (bVar3 != null) {
            return bVar3;
        }
        r8.b bVar4 = new r8.b();
        bVar4.f9384a = null;
        this.f5013b = bVar4;
        return bVar4;
    }
}
