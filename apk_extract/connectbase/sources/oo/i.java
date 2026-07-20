package oo;

import java.util.Map;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.n0;
import lm.t0;
import nm.c1;
import nm.d1;
import nm.x;
import os.l;
import un.o;
import uo.m;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f12352h = {l1.f9319a.n(new g1(l1.d(i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final up.i f12353g;

    public static final class a extends n0 implements jn.a<Map<dp.f, ? extends jp.g<? extends Object>>> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @l
        public final Map<dp.f, ? extends jp.g<? extends Object>> invoke() {
            jp.g<?> gVarC;
            uo.b bVar = i.this.f12335d;
            Map<dp.f, ? extends jp.g<? extends Object>> mapK = null;
            if (bVar instanceof uo.e) {
                gVarC = d.f12343a.c(((uo.e) bVar).c());
            } else {
                gVarC = bVar instanceof m ? d.f12343a.c(x.k(bVar)) : null;
            }
            if (gVarC != null) {
                c.f12337a.getClass();
                mapK = c1.k(new t0(c.f12339c, gVarC));
            }
            return mapK == null ? d1.z() : mapK;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@l uo.a aVar, @l qo.h hVar) {
        super(hVar, aVar, ao.k.a.F);
        l0.p(aVar, "annotation");
        l0.p(hVar, "c");
        this.f12353g = hVar.f14088a.f14055a.h(new a());
    }

    @Override // oo.b, fo.c
    @l
    public Map<dp.f, jp.g<Object>> a() {
        return (Map) up.m.a(this.f12353g, this, f12352h[0]);
    }
}
