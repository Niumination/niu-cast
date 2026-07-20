package el;

import androidx.core.app.NotificationCompat;
import ik.y0;
import java.util.NoSuchElementException;
import kn.l0;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class s<S> implements r<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final un.d<S> f4544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final m<S> f4545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final p f4546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final jn.a<String> f4547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final fl.b<String> f4548e;

    @xm.f(c = "io.ktor.sessions.SessionTrackerById", f = "SessionTrackerById.kt", i = {0, 0}, l = {en.a.f4563i}, m = "load", n = {"this", NotificationCompat.CATEGORY_CALL}, s = {"L$0", "L$1"})
    public static final class a extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ s<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s<S> sVar, um.d<? super a> dVar) {
            super(dVar);
            this.this$0 = sVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.b(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.sessions.SessionTrackerById$load$2", f = "SessionTrackerById.kt", i = {0}, l = {77}, m = "invokeSuspend", n = {"channel"}, s = {"L$0"})
    public static final class b extends xm.o implements jn.p<pl.k, um.d<? super S>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ s<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(s<S> sVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.this$0 = sVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.this$0, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            pl.k kVar;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                pl.k kVar2 = (pl.k) this.L$0;
                this.L$0 = kVar2;
                this.label = 1;
                Object objC0 = kVar2.c0(Integer.MAX_VALUE, this);
                if (objC0 == aVar) {
                    return aVar;
                }
                kVar = kVar2;
                obj = objC0;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kVar = (pl.k) this.L$0;
                d1.n(obj);
            }
            String str = (String) obj;
            if (str != null) {
                return this.this$0.f4545b.a(str);
            }
            throw new IllegalStateException(l0.C("Failed to read stored session from ", kVar));
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.k kVar, @os.m um.d<? super S> dVar) {
            return ((b) create(kVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.sessions.SessionTrackerById", f = "SessionTrackerById.kt", i = {0}, l = {97}, m = "store", n = {"sessionId"}, s = {"L$0"})
    public static final class c extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ s<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(s<S> sVar, um.d<? super c> dVar) {
            super(dVar);
            this.this$0 = sVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.sessions.SessionTrackerById$store$2", f = "SessionTrackerById.kt", i = {0}, l = {98}, m = "invokeSuspend", n = {"channel"}, s = {"L$0"})
    public static final class d extends xm.o implements jn.p<pl.n, um.d<? super l2>, Object> {
        final /* synthetic */ String $serialized;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, um.d<? super d> dVar) {
            super(2, dVar);
            this.$serialized = str;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            d dVar2 = new d(this.$serialized, dVar);
            dVar2.L$0 = obj;
            return dVar2;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            pl.n nVar;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                pl.n nVar2 = (pl.n) this.L$0;
                String str = this.$serialized;
                this.L$0 = nVar2;
                this.label = 1;
                if (pl.o.p(nVar2, str, this) == aVar) {
                    return aVar;
                }
                nVar = nVar2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                nVar = (pl.n) this.L$0;
                d1.n(obj);
            }
            pl.o.a(nVar);
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.n nVar, @os.m um.d<? super l2> dVar) {
            return ((d) create(nVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public s(@os.l un.d<S> dVar, @os.l m<S> mVar, @os.l p pVar, @os.l jn.a<String> aVar) {
        l0.p(dVar, y0.a.f8215h);
        l0.p(mVar, "serializer");
        l0.p(pVar, "storage");
        l0.p(aVar, "sessionIdProvider");
        this.f4544a = dVar;
        this.f4545b = mVar;
        this.f4546c = pVar;
        this.f4547d = aVar;
        this.f4548e = new fl.b<>("SessionId");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // el.r
    @os.m
    public Object a(@os.l dk.b bVar, @os.l S s10, @os.l um.d<? super String> dVar) {
        c cVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(this, dVar);
            }
        } else {
            cVar = new c(this, dVar);
        }
        Object obj = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str = (String) cVar.L$0;
            d1.n(obj);
            return str;
        }
        d1.n(obj);
        String str2 = (String) bVar.c().a(this.f4548e, this.f4547d);
        String strSerialize = this.f4545b.serialize(s10);
        p pVar = this.f4546c;
        d dVar2 = new d(strSerialize, null);
        cVar.L$0 = str2;
        cVar.label = 1;
        return pVar.a(str2, dVar2, cVar) == aVar ? aVar : str2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // el.r
    @os.m
    public Object b(@os.l dk.b bVar, @os.m String str, @os.l um.d<? super S> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, dVar);
            }
        } else {
            aVar = new a(this, dVar);
        }
        Object objC = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        try {
            if (i11 == 0) {
                d1.n(objC);
                if (str == null) {
                    return null;
                }
                bVar.c().g(this.f4548e, str);
                p pVar = this.f4546c;
                b bVar2 = new b(this, null);
                aVar.L$0 = this;
                aVar.L$1 = bVar;
                aVar.label = 1;
                objC = pVar.c(str, bVar2, aVar);
                if (objC == aVar2) {
                    return aVar2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar = (dk.b) aVar.L$1;
                this = (s) aVar.L$0;
                d1.n(objC);
            }
            return objC;
        } catch (NoSuchElementException e10) {
            ps.a aVarA = dk.j.a(bVar.a());
            StringBuilder sb2 = new StringBuilder("Failed to lookup session: ");
            String message = e10.getMessage();
            if (message == null) {
                message = e10.toString();
            }
            sb2.append(message);
            sb2.append(". The session id is wrong or outdated.");
            aVarA.debug(sb2.toString());
            bVar.c().c(this.f4548e);
            return null;
        }
    }

    @Override // el.r
    @os.m
    public Object c(@os.l dk.b bVar, @os.l um.d<? super l2> dVar) {
        Object objB;
        String str = (String) bVar.c().e(this.f4548e);
        return (str == null || (objB = this.f4546c.b(str, dVar)) != wm.a.COROUTINE_SUSPENDED) ? l2.f10208a : objB;
    }

    @os.l
    public final m<S> d() {
        return this.f4545b;
    }

    @os.l
    public final fl.b<String> e() {
        return this.f4548e;
    }

    @os.l
    public final jn.a<String> f() {
        return this.f4547d;
    }

    @os.l
    public final p g() {
        return this.f4546c;
    }

    @os.l
    public final un.d<S> h() {
        return this.f4544a;
    }

    @os.l
    public String toString() {
        return l0.C("SessionTrackerById: ", this.f4546c);
    }

    @Override // el.r
    public void validate(@os.l S s10) {
        l0.p(s10, "value");
        if (in.b.g(this.f4544a).isAssignableFrom(s10.getClass())) {
            return;
        }
        throw new IllegalArgumentException("Value for this session tracker expected to be of type " + this.f4544a + " but was " + s10);
    }
}
