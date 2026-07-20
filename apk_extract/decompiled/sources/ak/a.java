package ak;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import v4.p0;
import v4.q;
import zj.i;
import zj.j;
import zj.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f800a;

    public a(q qVar) {
        this.f800a = qVar;
    }

    @Override // zj.i
    public final j a(Type type) {
        c5.a<?> aVar = c5.a.get(type);
        q qVar = this.f800a;
        return new b(qVar, qVar.getAdapter(aVar));
    }

    @Override // zj.i
    public final j b(Type type, Annotation[] annotationArr, q0 q0Var) {
        c5.a<?> aVar = c5.a.get(type);
        q qVar = this.f800a;
        p0 adapter = qVar.getAdapter(aVar);
        ad.b bVar = new ad.b();
        bVar.f92a = qVar;
        bVar.f93b = adapter;
        return bVar;
    }
}
