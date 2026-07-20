package jl;

import ik.y0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kn.l0;
import kn.l1;
import kn.u1;
import lm.l2;
import nm.d1;
import nm.k0;
import os.l;
import os.m;
import un.g;
import un.s;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements jl.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Map<un.d<?>, jl.a> f8743a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final Map<un.d<?>, jl.a> f8744a = new LinkedHashMap();

        public final <T> void a(jn.l<? super f.a<T>, l2> lVar) {
            l0.p(lVar, "configure");
            l0.P();
            c(null, lVar);
        }

        public final void b(@l un.d<?> dVar, @l jl.a aVar) {
            l0.p(dVar, y0.a.f8215h);
            l0.p(aVar, "convertor");
            this.f8744a.put(dVar, aVar);
        }

        public final <T> void c(@l s sVar, @l jn.l<? super f.a<T>, l2> lVar) {
            l0.p(sVar, y0.a.f8215h);
            l0.p(lVar, "configure");
            g gVarI = sVar.i();
            if (gVarI == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.KClass<T of io.ktor.util.converters.DataConversion.Configuration.convert>");
            }
            un.d<?> dVar = (un.d) gVarI;
            f.a aVar = new f.a(dVar);
            lVar.invoke(aVar);
            b(dVar, new f(dVar, aVar.f8750b, (jn.l) u1.q(aVar.f8751c, 1)));
        }

        @l
        public final Map<un.d<?>, jl.a> d() {
            return this.f8744a;
        }
    }

    public c(@l a aVar) {
        l0.p(aVar, "configuration");
        this.f8743a = d1.F0(aVar.f8744a);
    }

    @Override // jl.a
    @l
    public List<String> a(@m Object obj) {
        un.d dVarD = obj == null ? null : l1.d(obj.getClass());
        if (dVarD == null) {
            return k0.INSTANCE;
        }
        jl.a aVar = this.f8743a.get(dVarD);
        if (aVar == null) {
            aVar = e.f8745a;
        }
        return aVar.a(obj);
    }

    @Override // jl.a
    @m
    public Object b(@l List<String> list, @l ol.b bVar) {
        l0.p(list, "values");
        l0.p(bVar, y0.a.f8215h);
        if (list.isEmpty()) {
            return null;
        }
        jl.a aVar = this.f8743a.get(bVar.getType());
        if (aVar == null) {
            aVar = e.f8745a;
        }
        return aVar.b(list, bVar);
    }
}
