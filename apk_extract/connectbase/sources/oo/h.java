package oo;

import java.util.Map;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.n0;
import lm.t0;
import nm.c1;
import nm.d1;
import os.l;
import un.o;
import up.m;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f12350h = {l1.f9319a.n(new g1(l1.d(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final up.i f12351g;

    public static final class a extends n0 implements jn.a<Map<dp.f, ? extends jp.g<?>>> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @l
        public final Map<dp.f, ? extends jp.g<?>> invoke() {
            Map<dp.f, ? extends jp.g<?>> mapK;
            jp.g<?> gVarA = d.f12343a.a(h.this.f12335d);
            if (gVarA == null) {
                mapK = null;
            } else {
                c.f12337a.getClass();
                mapK = c1.k(new t0(c.f12340d, gVarA));
            }
            return mapK == null ? d1.z() : mapK;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@l uo.a aVar, @l qo.h hVar) {
        super(hVar, aVar, ao.k.a.I);
        l0.p(aVar, "annotation");
        l0.p(hVar, "c");
        this.f12351g = hVar.f14088a.f14055a.h(new a());
    }

    @Override // oo.b, fo.c
    @l
    public Map<dp.f, jp.g<?>> a() {
        return (Map) m.a(this.f12351g, this, f12350h[0]);
    }
}
