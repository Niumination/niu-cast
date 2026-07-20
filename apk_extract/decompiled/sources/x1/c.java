package x1;

import j1.i0;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f10824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f10825b;

    public c() {
        this.f10824a = new b();
        this.f10825b = null;
    }

    public Object a(b bVar) {
        return this.f10825b;
    }

    public final Object b(float f, float f4, Object obj, Object obj2, float f10, float f11, float f12) {
        b bVar = this.f10824a;
        bVar.f10819a = f;
        bVar.f10820b = f4;
        bVar.f10821c = obj;
        bVar.f10822d = obj2;
        bVar.e = f10;
        bVar.f = f11;
        bVar.f10823g = f12;
        return a(bVar);
    }

    public c(i0 i0Var) {
        this.f10824a = new b();
        this.f10825b = i0Var;
    }
}
