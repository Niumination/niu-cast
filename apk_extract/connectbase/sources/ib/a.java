package ib;

import android.content.Context;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7761c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ie.a f7762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s8.a f7763b;

    public ch.a a(String str) {
        if (fc.b.b(str)) {
            e.f(f7761c, "TranThubDefaultDialerManager");
            ie.a aVar = this.f7762a;
            if (aVar != null) {
                return aVar;
            }
            ie.a aVar2 = new ie.a();
            this.f7762a = aVar2;
            return aVar2;
        }
        e.f(f7761c, "TranAospDefaultDialerManager");
        s8.a aVar3 = this.f7763b;
        if (aVar3 != null) {
            return aVar3;
        }
        s8.a aVar4 = new s8.a();
        this.f7763b = aVar4;
        return aVar4;
    }

    @yb.a(level = 1)
    public boolean b(Context context, String str) {
        return a(fc.b.a.f5989i).a(context, str);
    }
}
