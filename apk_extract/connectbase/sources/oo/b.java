package oo;

import eo.z0;
import ik.y0;
import java.util.Map;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.n0;
import nm.d1;
import nm.h0;
import os.l;
import os.m;
import un.o;

/* JADX INFO: loaded from: classes3.dex */
public class b implements fo.c, po.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f12331f = {l1.f9319a.n(new g1(l1.d(b.class), y0.a.f8215h, "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final dp.c f12332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final z0 f12333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final up.i f12334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public final uo.b f12335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f12336e;

    public static final class a extends n0 implements jn.a<vp.n0> {
        final /* synthetic */ qo.h $c;
        final /* synthetic */ b this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qo.h hVar, b bVar) {
            super(0);
            this.$c = hVar;
            this.this$0 = bVar;
        }

        @Override // jn.a
        @l
        public final vp.n0 invoke() {
            vp.n0 n0VarQ = this.$c.f14088a.f14069o.n().o(this.this$0.e()).q();
            l0.o(n0VarQ, "c.module.builtIns.getBui…qName(fqName).defaultType");
            return n0VarQ;
        }
    }

    public b(@l qo.h hVar, @m uo.a aVar, @l dp.c cVar) {
        z0 z0VarA;
        l0.p(hVar, "c");
        l0.p(cVar, "fqName");
        this.f12332a = cVar;
        if (aVar == null) {
            z0VarA = z0.f4654a;
            l0.o(z0VarA, "NO_SOURCE");
        } else {
            z0VarA = hVar.f14088a.f14064j.a(aVar);
        }
        this.f12333b = z0VarA;
        this.f12334c = hVar.f14088a.f14055a.h(new a(hVar, this));
        this.f12335d = aVar == null ? null : (uo.b) h0.E2(aVar.n());
        boolean z10 = false;
        if (aVar != null && aVar.j()) {
            z10 = true;
        }
        this.f12336e = z10;
    }

    @Override // fo.c
    @l
    public Map<dp.f, jp.g<?>> a() {
        return d1.z();
    }

    @m
    public final uo.b b() {
        return this.f12335d;
    }

    @Override // fo.c
    @l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public vp.n0 getType() {
        return (vp.n0) up.m.a(this.f12334c, this, f12331f[0]);
    }

    @Override // fo.c
    @l
    public dp.c e() {
        return this.f12332a;
    }

    @Override // fo.c
    @l
    public z0 getSource() {
        return this.f12333b;
    }

    @Override // po.g
    public boolean j() {
        return this.f12336e;
    }
}
