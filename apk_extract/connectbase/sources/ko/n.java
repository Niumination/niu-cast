package ko;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends z implements uo.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Type f9430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final uo.i f9431c;

    public n(@os.l Type type) {
        uo.i lVar;
        l0.p(type, "reflectType");
        this.f9430b = type;
        if (type instanceof Class) {
            lVar = new l((Class) type);
        } else if (type instanceof TypeVariable) {
            lVar = new a0((TypeVariable) type);
        } else {
            if (!(type instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + type.getClass() + "): " + type);
            }
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
            }
            lVar = new l((Class) rawType);
        }
        this.f9431c = lVar;
    }

    @Override // uo.d
    public boolean C() {
        return false;
    }

    @Override // uo.j
    @os.l
    public String D() {
        return this.f9430b.toString();
    }

    @Override // uo.j
    @os.l
    public String F() {
        throw new UnsupportedOperationException(l0.C("Type not found: ", this.f9430b));
    }

    @Override // ko.z
    @os.l
    public Type N() {
        return this.f9430b;
    }

    @Override // ko.z, uo.d
    @os.m
    public uo.a d(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        return null;
    }

    @Override // uo.d
    @os.l
    public Collection<uo.a> getAnnotations() {
        return k0.INSTANCE;
    }

    @Override // uo.j
    @os.l
    public uo.i i() {
        return this.f9431c;
    }

    @Override // uo.j
    public boolean t() {
        Type type = this.f9430b;
        if (!(type instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) type).getTypeParameters();
        l0.o(typeParameters, "getTypeParameters()");
        return !(typeParameters.length == 0);
    }

    @Override // uo.j
    @os.l
    public List<uo.x> y() {
        List<Type> listD = d.d(this.f9430b);
        z.a aVar = z.f9442a;
        ArrayList arrayList = new ArrayList(nm.z.b0(listD, 10));
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((Type) it.next()));
        }
        return arrayList;
    }
}
