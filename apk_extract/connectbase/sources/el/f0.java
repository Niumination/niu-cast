package el;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final b f4523b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final fl.b<f0> f4524c = new fl.b<>("Sessions");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<k<?>> f4525a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final ArrayList<k<?>> f4526a = new ArrayList<>();

        @os.l
        public final List<k<?>> a() {
            return nm.h0.V5(this.f4526a);
        }

        public final void b(@os.l k<?> kVar) {
            Object obj;
            Object next;
            l0.p(kVar, "provider");
            Iterator<T> it = this.f4526a.iterator();
            do {
                obj = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!l0.g(((k) next).f4531a, kVar.f4531a));
            k kVar2 = (k) next;
            if (kVar2 != null) {
                throw new IllegalArgumentException("There is already registered session provider with name " + kVar.f4531a + ": " + kVar2);
            }
            for (Object obj2 : this.f4526a) {
                if (l0.g(((k) obj2).f4532b, kVar.f4532b)) {
                    obj = obj2;
                    break;
                }
            }
            k kVar3 = (k) obj;
            if (kVar3 == null) {
                this.f4526a.add(kVar);
                return;
            }
            throw new IllegalArgumentException("There is already registered session provider for type " + kVar.f4532b + ": " + kVar3);
        }
    }

    public static final class b implements dk.h<dk.c, a, f0> {

        @xm.f(c = "io.ktor.sessions.Sessions$Feature$install$1", f = "Sessions.kt", i = {0, 0}, l = {63}, m = "invokeSuspend", n = {"$this$intercept", "destination$iv$iv"}, s = {"L$0", "L$1"})
        public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ f0 $sessions;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f0 f0Var, um.d<? super a> dVar) {
                super(3, dVar);
                this.$sessions = f0Var;
            }

            /* JADX WARN: Code duplicated, block: B:14:0x0057  */
            /* JADX WARN: Code duplicated, block: B:16:0x0077 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:17:0x0078  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0078 -> B:18:0x0079). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // xm.a
            @os.m
            public final java.lang.Object invokeSuspend(@os.l java.lang.Object r8) {
                /*
                    r7 = this;
                    wm.a r0 = wm.a.COROUTINE_SUSPENDED
                    int r1 = r7.label
                    r2 = 1
                    if (r1 == 0) goto L29
                    if (r1 != r2) goto L21
                    java.lang.Object r1 = r7.L$4
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.Object r3 = r7.L$3
                    java.util.Map r3 = (java.util.Map) r3
                    java.lang.Object r4 = r7.L$2
                    java.util.Iterator r4 = (java.util.Iterator) r4
                    java.lang.Object r5 = r7.L$1
                    java.util.Map r5 = (java.util.Map) r5
                    java.lang.Object r6 = r7.L$0
                    nl.f r6 = (nl.f) r6
                    lm.d1.n(r8)
                    goto L79
                L21:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L29:
                    lm.d1.n(r8)
                    java.lang.Object r8 = r7.L$0
                    nl.f r8 = (nl.f) r8
                    el.f0 r1 = r7.$sessions
                    java.util.List<el.k<?>> r1 = r1.f4525a
                    java.lang.Iterable r1 = (java.lang.Iterable) r1
                    r3 = 10
                    int r3 = nm.z.b0(r1, r3)
                    int r3 = nm.c1.j(r3)
                    r4 = 16
                    if (r3 >= r4) goto L45
                    r3 = r4
                L45:
                    java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
                    r4.<init>(r3)
                    java.util.Iterator r1 = r1.iterator()
                    r6 = r8
                    r3 = r4
                    r4 = r1
                L51:
                    boolean r8 = r4.hasNext()
                    if (r8 == 0) goto L80
                    java.lang.Object r8 = r4.next()
                    el.k r8 = (el.k) r8
                    java.lang.String r1 = r8.f4531a
                    java.lang.Object r5 = r6.getContext()
                    dk.b r5 = (dk.b) r5
                    r7.L$0 = r6
                    r7.L$1 = r3
                    r7.L$2 = r4
                    r7.L$3 = r3
                    r7.L$4 = r1
                    r7.label = r2
                    java.lang.Object r8 = el.h0.b(r8, r5, r7)
                    if (r8 != r0) goto L78
                    return r0
                L78:
                    r5 = r3
                L79:
                    el.l r8 = (el.l) r8
                    r3.put(r1, r8)
                    r3 = r5
                    goto L51
                L80:
                    el.h r8 = new el.h
                    el.f0 r7 = r7.$sessions
                    r8.<init>(r7, r3)
                    java.lang.Object r7 = r6.getContext()
                    dk.b r7 = (dk.b) r7
                    fl.c r7 = r7.c()
                    fl.b r0 = el.h0.a()
                    r7.g(r0, r8)
                    lm.l2 r7 = lm.l2.f10208a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: el.f0.b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
                a aVar = new a(this.$sessions, dVar);
                aVar.L$0 = fVar;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        /* JADX INFO: renamed from: el.f0$b$b, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.sessions.Sessions$Feature$install$2", f = "Sessions.kt", i = {0, 0}, l = {80}, m = "invokeSuspend", n = {"$this$intercept", "sessionData"}, s = {"L$0", "L$1"})
        public static final class C0104b extends xm.o implements jn.q<nl.f<Object, dk.b>, Object, um.d<? super l2>, Object> {
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;

            public C0104b(um.d<? super C0104b> dVar) {
                super(3, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                nl.f fVar;
                h hVar;
                Iterator it;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    nl.f fVar2 = (nl.f) this.L$0;
                    h hVar2 = (h) ((dk.b) fVar2.getContext()).c().b(h0.f4530a);
                    if (hVar2 == null) {
                        return l2.f10208a;
                    }
                    fVar = fVar2;
                    hVar = hVar2;
                    it = hVar2.f4528b.values().iterator();
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) this.L$2;
                    hVar = (h) this.L$1;
                    fVar = (nl.f) this.L$0;
                    d1.n(obj);
                }
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    dk.b bVar = (dk.b) fVar.getContext();
                    this.L$0 = fVar;
                    this.L$1 = hVar;
                    this.L$2 = it;
                    this.label = 1;
                    if (h0.k(lVar, bVar, this) == aVar) {
                        return aVar;
                    }
                }
                hVar.f4529c = true;
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj, @os.m um.d<? super l2> dVar) {
                C0104b c0104b = new C0104b(dVar);
                c0104b.L$0 = fVar;
                return c0104b.invokeSuspend(l2.f10208a);
            }
        }

        public b() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f0 a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            l0.p(cVar, "pipeline");
            l0.p(lVar, "configure");
            a aVar = new a();
            lVar.invoke(aVar);
            f0 f0Var = new f0(nm.h0.V5(aVar.f4526a));
            dk.c.f3706v.getClass();
            cVar.x(dk.c.f3709y, new a(f0Var, null));
            vk.d dVar = cVar.f3713p;
            vk.d.f17581n.getClass();
            dVar.x(vk.d.f17582p, new C0104b(null));
            return f0Var;
        }

        @Override // dk.h
        @os.l
        public fl.b<f0> getKey() {
            return f0.f4524c;
        }

        public b(kn.w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0(@os.l List<? extends k<?>> list) {
        l0.p(list, "providers");
        this.f4525a = list;
    }

    @os.l
    public final List<k<?>> b() {
        return this.f4525a;
    }
}
