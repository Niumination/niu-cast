package ko;

import java.lang.reflect.Type;
import java.util.Collection;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends z implements uo.v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Class<?> f9438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Collection<uo.a> f9439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9440d;

    public x(@os.l Class<?> cls) {
        l0.p(cls, "reflectType");
        this.f9438b = cls;
        this.f9439c = k0.INSTANCE;
    }

    @Override // uo.d
    public boolean C() {
        return this.f9440d;
    }

    @Override // ko.z
    public Type N() {
        return this.f9438b;
    }

    @os.l
    public Class<?> O() {
        return this.f9438b;
    }

    @Override // uo.d
    @os.l
    public Collection<uo.a> getAnnotations() {
        return this.f9439c;
    }

    @Override // uo.v
    @os.m
    public ao.i getType() {
        if (l0.g(this.f9438b, Void.TYPE)) {
            return null;
        }
        return mp.e.get(this.f9438b.getName()).getPrimitiveType();
    }
}
