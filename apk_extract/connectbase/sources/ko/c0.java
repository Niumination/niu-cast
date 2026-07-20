package ko;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends z implements uo.c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final WildcardType f9412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Collection<uo.a> f9413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9414d;

    public c0(@os.l WildcardType wildcardType) {
        l0.p(wildcardType, "reflectType");
        this.f9412b = wildcardType;
        this.f9413c = k0.INSTANCE;
    }

    @Override // uo.d
    public boolean C() {
        return this.f9414d;
    }

    @Override // uo.c0
    public boolean J() {
        Type[] upperBounds = this.f9412b.getUpperBounds();
        l0.o(upperBounds, "reflectType.upperBounds");
        return !l0.g(nm.r.nc(upperBounds), Object.class);
    }

    @Override // ko.z
    public Type N() {
        return this.f9412b;
    }

    @Override // uo.c0
    @os.m
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public z x() {
        Type[] upperBounds = this.f9412b.getUpperBounds();
        Type[] lowerBounds = this.f9412b.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException(l0.C("Wildcard types with many bounds are not yet supported: ", this.f9412b));
        }
        if (lowerBounds.length == 1) {
            z.a aVar = z.f9442a;
            l0.o(lowerBounds, "lowerBounds");
            Object objGt = nm.r.gt(lowerBounds);
            l0.o(objGt, "lowerBounds.single()");
            return aVar.a((Type) objGt);
        }
        if (upperBounds.length == 1) {
            l0.o(upperBounds, "upperBounds");
            Type type = (Type) nm.r.gt(upperBounds);
            if (!l0.g(type, Object.class)) {
                z.a aVar2 = z.f9442a;
                l0.o(type, "ub");
                return aVar2.a(type);
            }
        }
        return null;
    }

    @os.l
    public WildcardType P() {
        return this.f9412b;
    }

    @Override // uo.d
    @os.l
    public Collection<uo.a> getAnnotations() {
        return this.f9413c;
    }
}
