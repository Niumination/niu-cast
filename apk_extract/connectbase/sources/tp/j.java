package tp;

import eo.k0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kn.l0;
import nm.d0;
import nm.h0;
import nm.m0;

/* JADX INFO: loaded from: classes3.dex */
public class j extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final k0 f16007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final String f16008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final dp.c f16009i;

    public j(@os.l k0 k0Var, @os.l yo.a.l lVar, @os.l ap.c cVar, @os.l ap.a aVar, @os.m g gVar, @os.l rp.j jVar, @os.l String str, @os.l jn.a<? extends Collection<dp.f>> aVar2) {
        l0.p(k0Var, "packageDescriptor");
        l0.p(lVar, "proto");
        l0.p(cVar, "nameResolver");
        l0.p(aVar, "metadataVersion");
        l0.p(jVar, "components");
        l0.p(str, "debugName");
        l0.p(aVar2, "classNames");
        yo.a.t typeTable = lVar.getTypeTable();
        l0.o(typeTable, "proto.typeTable");
        ap.g gVar2 = new ap.g(typeTable);
        ap.h.a aVar3 = ap.h.f672b;
        yo.a.w versionRequirementTable = lVar.getVersionRequirementTable();
        l0.o(versionRequirementTable, "proto.versionRequirementTable");
        rp.l lVarA = jVar.a(k0Var, cVar, gVar2, aVar3.a(versionRequirementTable), aVar, gVar);
        List<yo.a.i> functionList = lVar.getFunctionList();
        l0.o(functionList, "proto.functionList");
        List<yo.a.n> propertyList = lVar.getPropertyList();
        l0.o(propertyList, "proto.propertyList");
        List<yo.a.r> typeAliasList = lVar.getTypeAliasList();
        l0.o(typeAliasList, "proto.typeAliasList");
        super(lVarA, functionList, propertyList, typeAliasList, aVar2);
        this.f16007g = k0Var;
        this.f16008h = str;
        this.f16009i = k0Var.e();
    }

    @Override // op.i, op.k
    @os.l
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public List<eo.m> e(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        Collection<eo.m> collectionL = l(dVar, lVar, mo.d.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<go.b> iterable = this.f15978b.f14748a.f14737k;
        ArrayList arrayList = new ArrayList();
        Iterator<go.b> it = iterable.iterator();
        while (it.hasNext()) {
            d0.r0(arrayList, it.next().a(this.f16009i));
        }
        return h0.E4(collectionL, arrayList);
    }

    @Override // tp.i, op.i, op.k
    @os.m
    public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        g(fVar, bVar);
        return super.f(fVar, bVar);
    }

    @Override // op.i, op.k
    public void g(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        lo.a.b(this.f15978b.f14748a.f14735i, bVar, this.f16007g, fVar);
    }

    @Override // tp.i
    public void k(@os.l Collection<eo.m> collection, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(collection, "result");
        l0.p(lVar, "nameFilter");
    }

    @Override // tp.i
    @os.l
    public dp.b o(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        return new dp.b(this.f16009i, fVar);
    }

    @os.l
    public String toString() {
        return this.f16008h;
    }

    @Override // tp.i
    @os.m
    public Set<dp.f> u() {
        return m0.INSTANCE;
    }

    @Override // tp.i
    @os.l
    public Set<dp.f> v() {
        return m0.INSTANCE;
    }

    @Override // tp.i
    @os.l
    public Set<dp.f> w() {
        return m0.INSTANCE;
    }

    @Override // tp.i
    public boolean y(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        if (!super.y(fVar)) {
            Iterable<go.b> iterable = this.f15978b.f14748a.f14737k;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator<go.b> it = iterable.iterator();
                while (it.hasNext()) {
                    if (it.next().c(this.f16009i, fVar)) {
                    }
                }
            }
            return false;
        }
        return true;
    }
}
