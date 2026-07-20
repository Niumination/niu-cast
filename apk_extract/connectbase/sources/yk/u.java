package yk;

import java.util.List;
import kn.l0;
import kn.n0;
import lm.l2;
import nq.c2;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    public static final class a extends n0 implements jn.l<Object, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        public final void invoke(@os.l Object obj) {
            l0.p(obj, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
            invoke(obj);
            return l2.f10208a;
        }
    }

    public static final class b extends n0 implements jn.l<Object, l2> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        public final void invoke(@os.l Object obj) {
            l0.p(obj, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
            invoke(obj);
            return l2.f10208a;
        }
    }

    public static final class c extends n0 implements jn.l<Object, l2> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        public final void invoke(@os.l Object obj) {
            l0.p(obj, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
            invoke(obj);
            return l2.f10208a;
        }
    }

    public static final class d extends n0 implements jn.l<yk.c, l2> {
        final /* synthetic */ String $host;
        final /* synthetic */ jn.l<dk.a, l2> $module;
        final /* synthetic */ um.g $parentCoroutineContext;
        final /* synthetic */ int $port;
        final /* synthetic */ s0 $this_embeddedServer;
        final /* synthetic */ List<String> $watchPaths;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(s0 s0Var, um.g gVar, List<String> list, jn.l<? super dk.a, l2> lVar, int i10, String str) {
            super(1);
            this.$this_embeddedServer = s0Var;
            this.$parentCoroutineContext = gVar;
            this.$watchPaths = list;
            this.$module = lVar;
            this.$port = i10;
            this.$host = str;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(yk.c cVar) {
            invoke2(cVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l yk.c cVar) {
            l0.p(cVar, "$this$applicationEngineEnvironment");
            cVar.p(this.$this_embeddedServer.getCoroutineContext().plus(this.$parentCoroutineContext));
            ps.a aVarJ = ps.b.j("ktor.application");
            l0.o(aVarJ, "getLogger(\"ktor.application\")");
            cVar.o(aVarJ);
            cVar.r(this.$watchPaths);
            cVar.k(this.$module);
            int i10 = this.$port;
            String str = this.$host;
            List<x> list = cVar.f21375f;
            w wVar = new w(null, 1, null);
            wVar.f21436c = i10;
            wVar.h(str);
            list.add(wVar);
        }
    }

    @os.l
    public static final <TEngine extends yk.a, TConfiguration extends yk.a.C0542a> TEngine a(@os.l s0 s0Var, @os.l f<? extends TEngine, TConfiguration> fVar, int i10, @os.l String str, @os.l List<String> list, @os.l um.g gVar, @os.l jn.l<? super TConfiguration, l2> lVar, @os.l jn.l<? super dk.a, l2> lVar2) {
        l0.p(s0Var, "<this>");
        l0.p(fVar, "factory");
        l0.p(str, "host");
        l0.p(list, "watchPaths");
        l0.p(gVar, "parentCoroutineContext");
        l0.p(lVar, "configure");
        l0.p(lVar2, "module");
        return (TEngine) c(fVar, yk.d.a(new d(s0Var, gVar, list, lVar2, i10, str)), lVar);
    }

    @os.l
    public static final <TEngine extends yk.a, TConfiguration extends yk.a.C0542a> TEngine b(@os.l f<? extends TEngine, TConfiguration> fVar, int i10, @os.l String str, @os.l List<String> list, @os.l jn.l<? super TConfiguration, l2> lVar, @os.l jn.l<? super dk.a, l2> lVar2) {
        l0.p(fVar, "factory");
        l0.p(str, "host");
        l0.p(list, "watchPaths");
        l0.p(lVar, "configure");
        l0.p(lVar2, "module");
        return (TEngine) a(c2.f11831a, fVar, i10, str, list, um.i.INSTANCE, lVar, lVar2);
    }

    @os.l
    public static final <TEngine extends yk.a, TConfiguration extends yk.a.C0542a> TEngine c(@os.l f<? extends TEngine, TConfiguration> fVar, @os.l yk.b bVar, @os.l jn.l<? super TConfiguration, l2> lVar) {
        l0.p(fVar, "factory");
        l0.p(bVar, "environment");
        l0.p(lVar, "configure");
        return (TEngine) fVar.a(bVar, lVar);
    }

    public static /* synthetic */ yk.a e(f fVar, int i10, String str, List list, jn.l lVar, jn.l lVar2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 80;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            str = "0.0.0.0";
        }
        String str2 = str;
        if ((i11 & 8) != 0) {
            list = nm.x.k(f0.a());
        }
        List list2 = list;
        if ((i11 & 16) != 0) {
            lVar = a.INSTANCE;
        }
        return b(fVar, i12, str2, list2, lVar, lVar2);
    }

    public static /* synthetic */ yk.a f(f fVar, yk.b bVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            lVar = c.INSTANCE;
        }
        return c(fVar, bVar, lVar);
    }
}
