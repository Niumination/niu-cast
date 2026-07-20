package gk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final b f6593b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final fl.b<f> f6594c = new fl.b<>("Conditional Headers");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<jn.l<nk.s, nk.c>> f6595a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final List<jn.l<nk.s, nk.c>> f6596a;

        /* JADX INFO: renamed from: gk.f$a$a, reason: collision with other inner class name */
        public static final class C0163a extends kn.n0 implements jn.l<nk.s, nk.c> {
            public static final C0163a INSTANCE = new C0163a();

            public C0163a() {
                super(1);
            }

            @Override // jn.l
            @os.m
            public final nk.c invoke(@os.l nk.s sVar) {
                kn.l0.p(sVar, t2.a.f15437d);
                return nk.e.a(sVar);
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f6596a = arrayList;
            arrayList.add(C0163a.INSTANCE);
        }

        @os.l
        public final List<jn.l<nk.s, nk.c>> a() {
            return this.f6596a;
        }

        public final void b(@os.l jn.l<? super nk.s, nk.c> lVar) {
            kn.l0.p(lVar, "provider");
            this.f6596a.add(lVar);
        }
    }

    public static final class b implements dk.h<dk.c, a, f> {

        @xm.f(c = "io.ktor.features.CachingHeaders$Feature$install$1", f = "CachingHeaders.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<Object, dk.b>, Object, um.d<? super l2>, Object> {
            final /* synthetic */ f $feature;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f fVar, um.d<? super a> dVar) {
                super(3, dVar);
                this.$feature = fVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
                this.$feature.b((nl.f) this.L$0, this.L$1);
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj, @os.m um.d<? super l2> dVar) {
                a aVar = new a(this.$feature, dVar);
                aVar.L$0 = fVar;
                aVar.L$1 = obj;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public b() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar = new a();
            lVar.invoke(aVar);
            f fVar = new f(aVar.f6596a);
            vk.d dVar = cVar.f3713p;
            vk.d.f17581n.getClass();
            dVar.x(vk.d.f17587z, new a(fVar, null));
            return fVar;
        }

        @Override // dk.h
        @os.l
        public fl.b<f> getKey() {
            return f.f6594c;
        }

        public b(kn.w wVar) {
        }
    }

    public static final class c extends kn.n0 implements jn.p<String, List<? extends String>, l2> {
        final /* synthetic */ vk.g $responseHeaders;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(vk.g gVar) {
            super(2);
            this.$responseHeaders = gVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(String str, List<? extends String> list) {
            invoke2(str, (List<String>) list);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l String str, @os.l List<String> list) {
            kn.l0.p(str, "name");
            kn.l0.p(list, "values");
            vk.g gVar = this.$responseHeaders;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                vk.g.c(gVar, str, (String) it.next(), false, 4, null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@os.l List<? extends jn.l<? super nk.s, nk.c>> list) {
        kn.l0.p(list, "optionsProviders");
        this.f6595a = list;
    }

    public final void b(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj) {
        kl.d dVar;
        kn.l0.p(fVar, "context");
        kn.l0.p(obj, "message");
        dk.b context = fVar.getContext();
        List<nk.c> listC = obj instanceof nk.s ? c((nk.s) obj) : nm.k0.INSTANCE;
        if (listC.isEmpty()) {
            return;
        }
        ik.b0.a aVar = ik.b0.f7939b;
        Object obj2 = null;
        ik.c0 c0Var = new ik.c0(0, 1, null);
        List<nk.c> list = listC;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ik.d dVar2 = ((nk.c) it.next()).f11511a;
            if (dVar2 != null) {
                arrayList.add(dVar2);
            }
        }
        List<ik.d> listA = fl.m.a(arrayList);
        if (listA.isEmpty()) {
            listA = null;
        }
        List<ik.d> list2 = listA;
        if (list2 != null) {
            ik.j0.f8048a.getClass();
            c0Var.a(ik.j0.f8070l, nm.h0.m3(list2, ", ", null, null, 0, null, null, 62, null));
        }
        for (Object obj3 : list) {
            if (((nk.c) obj3).f11512b != null) {
                obj2 = obj3;
                break;
            }
        }
        nk.c cVar = (nk.c) obj2;
        if (cVar != null && (dVar = cVar.f11512b) != null) {
            ik.j0.f8048a.getClass();
            c0Var.a(ik.j0.C, ik.r.e(dVar));
        }
        c0Var.f().e(new c(context.e().b()));
    }

    @os.l
    public final List<nk.c> c(@os.l nk.s sVar) {
        kn.l0.p(sVar, t2.a.f15437d);
        List<jn.l<nk.s, nk.c>> list = this.f6595a;
        ArrayList arrayList = new ArrayList(this.f6595a.size());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            nk.c cVar = (nk.c) ((jn.l) it.next()).invoke(sVar);
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }
}
