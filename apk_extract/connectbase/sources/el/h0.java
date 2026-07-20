package el;

import androidx.core.app.NotificationCompat;
import kn.l0;
import kn.l1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final fl.b<h> f4530a = new fl.b<>("SessionKey");

    @xm.f(c = "io.ktor.sessions.SessionsKt", f = "Sessions.kt", i = {0, 0}, l = {215}, m = "receiveSessionData", n = {"$this$receiveSessionData", "receivedValue"}, s = {"L$0", "L$1"})
    public static final class a<S> extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return h0.i(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.sessions.SessionsKt", f = "Sessions.kt", i = {0, 0}, l = {224, 230}, m = "sendSessionData", n = {"$this$sendSessionData", NotificationCompat.CATEGORY_CALL}, s = {"L$0", "L$1"})
    public static final class b<S> extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return h0.k(null, null, this);
        }
    }

    public static final <T> void d(d dVar) {
        l0.p(dVar, "<this>");
        l0.P();
        dVar.a(dVar.c(l1.d(Object.class)));
    }

    public static final <T> T e(d dVar) {
        l0.p(dVar, "<this>");
        l0.P();
        T t10 = (T) dVar.get(dVar.c(l1.d(Object.class)));
        l0.P();
        return t10;
    }

    public static final <T> T f(d dVar, String str, jn.a<? extends T> aVar) {
        l0.p(dVar, "<this>");
        l0.p(str, "name");
        l0.p(aVar, "generator");
        l0.P();
        T t10 = (T) dVar.get(dVar.c(l1.d(Object.class)));
        l0.P();
        if (t10 != null) {
            return t10;
        }
        T tInvoke = aVar.invoke();
        dVar.b(str, tInvoke);
        return tInvoke;
    }

    public static Object g(d dVar, String str, jn.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l0.P();
            str = dVar.c(l1.d(Object.class));
        }
        l0.p(dVar, "<this>");
        l0.p(str, "name");
        l0.p(aVar, "generator");
        l0.P();
        Object obj2 = dVar.get(dVar.c(l1.d(Object.class)));
        l0.P();
        if (obj2 != null) {
            return obj2;
        }
        Object objInvoke = aVar.invoke();
        dVar.b(str, objInvoke);
        return objInvoke;
    }

    @os.l
    public static final d h(@os.l dk.b bVar) {
        l0.p(bVar, "<this>");
        h hVar = (h) bVar.c().b(f4530a);
        if (hVar != null) {
            return hVar;
        }
        j(bVar);
        throw new lm.y();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <S> Object i(k<S> kVar, dk.b bVar, um.d<? super l<S>> dVar) {
        a aVar;
        k<S> kVar2;
        String str;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        boolean z10 = true;
        if (i11 == 0) {
            d1.n(obj);
            String strA = kVar.f4533c.a(bVar);
            r<S> rVar = kVar.f4534d;
            aVar.L$0 = kVar;
            aVar.L$1 = strA;
            aVar.label = 1;
            Object objB = rVar.b(bVar, strA, aVar);
            if (objB == aVar2) {
                return aVar2;
            }
            kVar2 = kVar;
            str = strA;
            obj = objB;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) aVar.L$1;
            kVar2 = (k) aVar.L$0;
            d1.n(obj);
        }
        if (str == null && obj == null) {
            z10 = false;
        }
        return new l(obj, z10, kVar2);
    }

    public static final Void j(dk.b bVar) {
        dk.i.a(bVar.a(), f0.f4523b);
        throw new j();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <S> Object k(l<S> lVar, dk.b bVar, um.d<? super l2> dVar) {
        b bVar2;
        if (dVar instanceof b) {
            bVar2 = (b) dVar;
            int i10 = bVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar2 = new b(dVar);
            }
        } else {
            bVar2 = new b(dVar);
        }
        Object objA = bVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar2.label;
        if (i11 == 0) {
            d1.n(objA);
            S s10 = lVar.f4535a;
            if (s10 != null) {
                r<S> rVar = lVar.f4537c.f4534d;
                bVar2.L$0 = lVar;
                bVar2.L$1 = bVar;
                bVar2.label = 1;
                objA = rVar.a(bVar, s10, bVar2);
                if (objA == aVar) {
                    return aVar;
                }
                lVar.f4537c.f4533c.b(bVar, (String) objA);
            } else if (lVar.f4536b) {
                lVar.f4537c.f4533c.c(bVar);
                r<S> rVar2 = lVar.f4537c.f4534d;
                bVar2.label = 2;
                if (rVar2.c(bVar, bVar2) == aVar) {
                    return aVar;
                }
                return l2.f10208a;
            }
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objA);
                return l2.f10208a;
            }
            bVar = (dk.b) bVar2.L$1;
            lVar = (l) bVar2.L$0;
            d1.n(objA);
            lVar.f4537c.f4533c.b(bVar, (String) objA);
        }
        return l2.f10208a;
    }

    public static final <T> void l(d dVar, T t10) {
        l0.p(dVar, "<this>");
        l0.P();
        dVar.b(dVar.c(l1.d(Object.class)), t10);
    }
}
