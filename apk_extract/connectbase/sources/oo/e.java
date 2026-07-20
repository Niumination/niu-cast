package oo;

import java.util.Map;
import jp.v;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.n0;
import lm.t0;
import nm.c1;
import os.l;
import os.m;
import un.o;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f12346h = {l1.f9319a.n(new g1(l1.d(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final up.i f12347g;

    public static final class a extends n0 implements jn.a<Map<dp.f, ? extends v>> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // jn.a
        @l
        public final Map<dp.f, ? extends v> invoke() {
            c.f12337a.getClass();
            return c1.k(new t0(c.f12338b, new v("Deprecated in Java")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@m uo.a aVar, @l qo.h hVar) {
        super(hVar, aVar, ao.k.a.f619y);
        l0.p(hVar, "c");
        this.f12347g = hVar.f14088a.f14055a.h(a.INSTANCE);
    }

    @Override // oo.b, fo.c
    @l
    public Map<dp.f, jp.g<?>> a() {
        return (Map) up.m.a(this.f12347g, this, f12346h[0]);
    }
}
