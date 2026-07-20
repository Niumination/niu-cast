package wn;

import cp.g;
import eo.y0;
import jn.p;
import kn.g0;
import kn.l0;
import kn.l1;
import kotlin.Metadata;
import lm.t0;
import lm.v;
import os.l;
import os.m;
import rp.w;
import un.h;
import un.i;
import xn.h0;
import xn.k;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    public /* synthetic */ class a extends g0 implements p<w, yo.a.i, y0> {
        public static final a INSTANCE = new a();

        public a() {
            super(2);
        }

        @Override // kn.q, un.c
        @l
        public final String getName() {
            return "loadFunction";
        }

        @Override // kn.q
        @l
        public final h getOwner() {
            return l1.d(w.class);
        }

        @Override // kn.q
        @l
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        @Override // jn.p
        @l
        public final y0 invoke(@l w wVar, @l yo.a.i iVar) {
            l0.p(wVar, "p0");
            l0.p(iVar, "p1");
            return wVar.j(iVar);
        }
    }

    @m
    @wn.a
    public static final <R> i<R> a(@l v<? extends R> vVar) {
        l0.p(vVar, "<this>");
        Metadata metadata = (Metadata) vVar.getClass().getAnnotation(Metadata.class);
        if (metadata == null) {
            return null;
        }
        String[] strArrD1 = metadata.d1();
        if (strArrD1.length == 0) {
            strArrD1 = null;
        }
        if (strArrD1 == null) {
            return null;
        }
        t0<cp.f, yo.a.i> t0VarJ = g.j(strArrD1, metadata.d2());
        cp.f fVarComponent1 = t0VarJ.component1();
        yo.a.i iVarComponent2 = t0VarJ.component2();
        cp.e eVar = new cp.e(metadata.mv(), (metadata.xi() & 8) != 0);
        Class<?> cls = vVar.getClass();
        yo.a.t typeTable = iVarComponent2.getTypeTable();
        l0.o(typeTable, "proto.typeTable");
        return new k(xn.b.f20307d, (y0) h0.h(cls, iVarComponent2, fVarComponent1, new ap.g(typeTable), eVar, a.INSTANCE));
    }
}
