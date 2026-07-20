package gk;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kn.l1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements fl.v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final b f6742b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final fl.b<z> f6743c = new fl.b<>("DataConversion");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Map<Type, fl.v> f6744a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Map<Type, fl.v> f6745a = new LinkedHashMap();

        public final <T> void a(jn.l<? super d0, l2> lVar) {
            kn.l0.p(lVar, "configure");
            kn.l0.P();
            c(l1.d(Object.class), lVar);
        }

        public final void b(@os.l un.d<?> dVar, @os.l fl.v vVar) {
            kn.l0.p(dVar, "klass");
            kn.l0.p(vVar, "convertor");
            this.f6745a.put(in.b.e(dVar), vVar);
        }

        public final void c(@os.l un.d<?> dVar, @os.l jn.l<? super d0, l2> lVar) {
            kn.l0.p(dVar, "klass");
            kn.l0.p(lVar, "configure");
            d0 d0Var = new d0(dVar);
            lVar.invoke(d0Var);
            b(dVar, d0Var);
        }

        public final void d(@os.l un.s sVar, @os.l fl.v vVar) {
            kn.l0.p(sVar, "ktype");
            kn.l0.p(vVar, "convertor");
            this.f6745a.put(wn.e.g(sVar), vVar);
        }

        @os.l
        public final Map<Type, fl.v> e() {
            return this.f6745a;
        }
    }

    public static final class b implements dk.h<dk.c, a, z> {
        public b() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public z a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar = new a();
            lVar.invoke(aVar);
            return new z(aVar.f6745a);
        }

        @Override // dk.h
        @os.l
        public fl.b<z> getKey() {
            return z.f6743c;
        }

        public b(kn.w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z(@os.l Map<Type, ? extends fl.v> map) {
        kn.l0.p(map, "converters");
        this.f6744a = map;
    }

    @Override // fl.v
    @os.l
    public List<String> a(@os.m Object obj) {
        Class<?> cls = obj == null ? null : obj.getClass();
        if (cls == null) {
            return nm.k0.INSTANCE;
        }
        fl.v vVar = this.f6744a.get(cls);
        if (vVar == null) {
            vVar = fl.e0.f6029a;
        }
        return vVar.a(obj);
    }

    @Override // fl.v
    @os.m
    public Object b(@os.l List<String> list, @os.l Type type) {
        kn.l0.p(list, "values");
        kn.l0.p(type, ik.y0.a.f8215h);
        fl.v vVar = this.f6744a.get(type);
        if (vVar == null) {
            vVar = fl.e0.f6029a;
        }
        return vVar.b(list, type);
    }
}
