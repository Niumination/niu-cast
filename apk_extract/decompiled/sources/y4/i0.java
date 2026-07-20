package y4;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends v4.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v4.q f11056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v4.p0 f11057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f11058c;

    public i0(v4.q qVar, v4.p0 p0Var, Type type) {
        this.f11056a = qVar;
        this.f11057b = p0Var;
        this.f11058c = type;
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) {
        return this.f11057b.read(bVar);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x003b  */
    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) {
        v4.p0 serializationDelegate;
        Type type = this.f11058c;
        Type type2 = (obj == null || !((type instanceof Class) || (type instanceof TypeVariable))) ? type : obj.getClass();
        v4.p0 p0Var = this.f11057b;
        if (type2 != type) {
            v4.p0 adapter = this.f11056a.getAdapter(c5.a.get(type2));
            if (adapter instanceof b0) {
                v4.p0 p0Var2 = p0Var;
                while ((p0Var2 instanceof h0) && (serializationDelegate = ((h0) p0Var2).getSerializationDelegate()) != p0Var2) {
                    p0Var2 = serializationDelegate;
                }
                if (p0Var2 instanceof b0) {
                    p0Var = adapter;
                }
            } else {
                p0Var = adapter;
            }
        }
        p0Var.write(dVar, obj);
    }
}
