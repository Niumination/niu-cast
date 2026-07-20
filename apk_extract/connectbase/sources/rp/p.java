package rp;

import eo.h0;
import eo.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p extends o {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final ap.a f14760i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.m
    public final tp.g f14761n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final ap.d f14762p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public final y f14763v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.m
    public yo.a.m f14764w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public op.h f14765x;

    public static final class a extends n0 implements jn.l<dp.b, z0> {
        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final z0 invoke(@os.l dp.b bVar) {
            l0.p(bVar, "it");
            tp.g gVar = p.this.f14761n;
            if (gVar != null) {
                return gVar;
            }
            z0 z0Var = z0.f4654a;
            l0.o(z0Var, "NO_SOURCE");
            return z0Var;
        }
    }

    public static final class b extends n0 implements jn.a<Collection<? extends dp.f>> {
        public b() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Collection<? extends dp.f> invoke() {
            Set<dp.b> setKeySet = p.this.B0().f14778d.keySet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : setKeySet) {
                dp.b bVar = (dp.b) obj;
                if (!bVar.l()) {
                    h.f14718c.getClass();
                    if (!h.f14719d.contains(bVar)) {
                        arrayList.add(obj);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(nm.z.b0(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((dp.b) it.next()).j());
            }
            return arrayList2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@os.l dp.c cVar, @os.l up.n nVar, @os.l h0 h0Var, @os.l yo.a.m mVar, @os.l ap.a aVar, @os.m tp.g gVar) {
        super(cVar, nVar, h0Var);
        l0.p(cVar, "fqName");
        l0.p(nVar, "storageManager");
        l0.p(h0Var, "module");
        l0.p(mVar, "proto");
        l0.p(aVar, "metadataVersion");
        this.f14760i = aVar;
        this.f14761n = gVar;
        yo.a.p strings = mVar.getStrings();
        l0.o(strings, "proto.strings");
        yo.a.o qualifiedNames = mVar.getQualifiedNames();
        l0.o(qualifiedNames, "proto.qualifiedNames");
        ap.d dVar = new ap.d(strings, qualifiedNames);
        this.f14762p = dVar;
        this.f14763v = new y(mVar, dVar, aVar, new a());
        this.f14764w = mVar;
    }

    @Override // rp.o
    public void F0(@os.l j jVar) {
        l0.p(jVar, "components");
        yo.a.m mVar = this.f14764w;
        if (mVar == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize");
        }
        this.f14764w = null;
        yo.a.l lVar = mVar.getPackage();
        l0.o(lVar, "proto.`package`");
        this.f14765x = new tp.j(this, lVar, this.f14762p, this.f14760i, this.f14761n, jVar, l0.C("scope of ", this), new b());
    }

    @Override // rp.o
    @os.l
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public y B0() {
        return this.f14763v;
    }

    @Override // eo.k0
    @os.l
    public op.h o() {
        op.h hVar = this.f14765x;
        if (hVar != null) {
            return hVar;
        }
        l0.S("_memberScope");
        return null;
    }
}
