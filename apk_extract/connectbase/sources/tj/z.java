package tj;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sj.o f15757b;

    public z(Collection<a> collection, sj.o oVar) {
        super(collection);
        this.f15757b = oVar;
    }

    public boolean e(String str) {
        p0 p0VarD = r0.d(str);
        ArrayList arrayList = new ArrayList(this.f15733a);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            a aVar = (a) arrayList.get(i10);
            if (aVar instanceof t) {
                if (aVar instanceof r) {
                    throw new sj.c.n(this.f15757b, "The ConfigDocument had an array at the root level, and values cannot be modified inside an array.");
                }
                if (aVar instanceof x) {
                    return ((x) aVar).g(p0VarD);
                }
            }
        }
        throw new sj.c.d("ConfigNodeRoot did not contain a value");
    }

    @Override // tj.t
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public z d(Collection<a> collection) {
        throw new sj.c.d("Tried to indent the root object");
    }

    public z g(String str, b bVar, sj.v vVar) {
        ArrayList arrayList = new ArrayList(this.f15733a);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            a aVar = (a) arrayList.get(i10);
            if (aVar instanceof t) {
                if (aVar instanceof r) {
                    throw new sj.c.n(this.f15757b, "The ConfigDocument had an array at the root level, and values cannot be modified inside an array.");
                }
                if (aVar instanceof x) {
                    if (bVar == null) {
                        arrayList.set(i10, ((x) aVar).j(str, vVar));
                    } else {
                        arrayList.set(i10, ((x) aVar).l(str, bVar, vVar));
                    }
                    return new z(arrayList, this.f15757b);
                }
            }
        }
        throw new sj.c.d("ConfigNodeRoot did not contain a value");
    }

    public t h() {
        for (a aVar : this.f15733a) {
            if (aVar instanceof t) {
                return (t) aVar;
            }
        }
        throw new sj.c.d("ConfigNodeRoot did not contain a value");
    }
}
