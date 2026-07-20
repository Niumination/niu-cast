package ko;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kn.l0;
import nm.h0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends p implements h, uo.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final TypeVariable<?> f9397a;

    public a0(@os.l TypeVariable<?> typeVariable) {
        l0.p(typeVariable, "typeVariable");
        this.f9397a = typeVariable;
    }

    @Override // uo.d
    public boolean C() {
        return h.a.c(this);
    }

    @os.m
    public e N(@os.l dp.c cVar) {
        return h.a.a(this, cVar);
    }

    @os.l
    public List<e> O() {
        return h.a.b(this);
    }

    @Override // uo.y
    @os.l
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public List<n> getUpperBounds() {
        Type[] bounds = this.f9397a.getBounds();
        l0.o(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        int length = bounds.length;
        int i10 = 0;
        while (i10 < length) {
            Type type = bounds[i10];
            i10++;
            arrayList.add(new n(type));
        }
        n nVar = (n) h0.k5(arrayList);
        return l0.g(nVar == null ? null : nVar.f9430b, Object.class) ? k0.INSTANCE : arrayList;
    }

    @Override // uo.d
    public uo.a d(dp.c cVar) {
        return h.a.a(this, cVar);
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof a0) && l0.g(this.f9397a, ((a0) obj).f9397a);
    }

    @Override // uo.d
    public Collection getAnnotations() {
        return h.a.b(this);
    }

    @Override // ko.h
    @os.m
    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable = this.f9397a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // uo.t
    @os.l
    public dp.f getName() {
        dp.f fVarK = dp.f.k(this.f9397a.getName());
        l0.o(fVarK, "identifier(typeVariable.name)");
        return fVarK;
    }

    public int hashCode() {
        return this.f9397a.hashCode();
    }

    @os.l
    public String toString() {
        return a0.class.getName() + ": " + this.f9397a;
    }
}
