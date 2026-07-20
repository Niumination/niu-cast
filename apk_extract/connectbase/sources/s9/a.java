package s9;

import android.content.Context;
import dc.e;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15029c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tc.a f15030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b7.a f15031b;

    public mf.a a(String str) {
        if (b.b(str)) {
            e.f(f15029c, "TranThubFactoryModeManager");
            tc.a aVar = this.f15030a;
            if (aVar != null) {
                return aVar;
            }
            tc.a aVar2 = new tc.a();
            this.f15030a = aVar2;
            return aVar2;
        }
        e.f(f15029c, "TranAospFactoryModeManager");
        b7.a aVar3 = this.f15031b;
        if (aVar3 != null) {
            return aVar3;
        }
        b7.a aVar4 = new b7.a();
        this.f15031b = aVar4;
        return aVar4;
    }

    public boolean b(String str, Context context) {
        if (!fc.a.f()) {
            return false;
        }
        if (str == null || context == null) {
            throw new IllegalArgumentException("params cannot be null");
        }
        return a(b.a.f6000t).a(str, context);
    }
}
