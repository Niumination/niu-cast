package ko;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends z implements uo.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Type f9424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final z f9425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Collection<uo.a> f9426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9427e;

    public k(@os.l Type type) {
        z zVarA;
        l0.p(type, "reflectType");
        this.f9424b = type;
        if (!(type instanceof GenericArrayType)) {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    z.a aVar = z.f9442a;
                    Class<?> componentType = cls.getComponentType();
                    l0.o(componentType, "getComponentType()");
                    zVarA = aVar.a(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + type.getClass() + "): " + type);
        }
        z.a aVar2 = z.f9442a;
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        l0.o(genericComponentType, "genericComponentType");
        zVarA = aVar2.a(genericComponentType);
        this.f9425c = zVarA;
        this.f9426d = k0.INSTANCE;
    }

    @Override // uo.d
    public boolean C() {
        return this.f9427e;
    }

    @Override // ko.z
    @os.l
    public Type N() {
        return this.f9424b;
    }

    @os.l
    public z O() {
        return this.f9425c;
    }

    @Override // uo.d
    @os.l
    public Collection<uo.a> getAnnotations() {
        return this.f9426d;
    }

    @Override // uo.f
    public uo.x o() {
        return this.f9425c;
    }
}
