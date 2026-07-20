package d2;

import af.m0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f4281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a2.b f4282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a2.d f4283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f4284d;

    public k(d dVar, a2.b bVar, a2.d dVar2, l lVar) {
        this.f4281a = dVar;
        this.f4282b = bVar;
        this.f4283c = dVar2;
        this.f4284d = lVar;
    }

    public final void a(a2.a aVar) {
        d dVar = this.f4281a;
        a2.d dVar2 = this.f4283c;
        a2.b bVar = this.f4282b;
        l lVar = this.f4284d;
        c cVarA = j.a();
        String str = dVar.f4269a;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        cVarA.f4266a = str;
        a2.c cVar = aVar.f27b;
        if (cVar == null) {
            throw new NullPointerException("Null priority");
        }
        cVarA.f4268c = cVar;
        cVarA.f4267b = dVar.f4270b;
        d dVarA = cVarA.a();
        a aVar2 = new a();
        aVar2.f4261h = new HashMap();
        aVar2.f4260d = Long.valueOf(lVar.f4285a.a());
        aVar2.e = Long.valueOf(lVar.f4286b.a());
        aVar2.f4257a = "FIREBASE_ML_SDK";
        aVar2.f4259c = new f(bVar, (byte[]) dVar2.apply(aVar.f26a));
        aVar2.f4258b = null;
        b bVarB = aVar2.b();
        h2.a aVar3 = (h2.a) lVar.f4287c;
        aVar3.getClass();
        aVar3.f5231b.execute(new m0(aVar3, dVarA, bVarB, 6, false));
    }
}
