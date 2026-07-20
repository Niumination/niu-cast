package mp;

import eo.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import nm.d0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final List<f> f10859b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@l List<? extends f> list) {
        l0.p(list, "inner");
        this.f10859b = list;
    }

    @Override // mp.f
    @l
    public List<dp.f> a(@l eo.e eVar) {
        l0.p(eVar, "thisDescriptor");
        List<f> list = this.f10859b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            d0.r0(arrayList, ((f) it.next()).a(eVar));
        }
        return arrayList;
    }

    @Override // mp.f
    public void b(@l eo.e eVar, @l dp.f fVar, @l Collection<y0> collection) {
        l0.p(eVar, "thisDescriptor");
        l0.p(fVar, "name");
        l0.p(collection, "result");
        Iterator<T> it = this.f10859b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).b(eVar, fVar, collection);
        }
    }

    @Override // mp.f
    public void c(@l eo.e eVar, @l List<eo.d> list) {
        l0.p(eVar, "thisDescriptor");
        l0.p(list, "result");
        Iterator<T> it = this.f10859b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).c(eVar, list);
        }
    }

    @Override // mp.f
    public void d(@l eo.e eVar, @l dp.f fVar, @l Collection<y0> collection) {
        l0.p(eVar, "thisDescriptor");
        l0.p(fVar, "name");
        l0.p(collection, "result");
        Iterator<T> it = this.f10859b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).d(eVar, fVar, collection);
        }
    }

    @Override // mp.f
    @l
    public List<dp.f> e(@l eo.e eVar) {
        l0.p(eVar, "thisDescriptor");
        List<f> list = this.f10859b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            d0.r0(arrayList, ((f) it.next()).e(eVar));
        }
        return arrayList;
    }
}
