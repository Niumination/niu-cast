package vn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kn.l0;
import kn.l1;
import kn.s1;
import lm.d1;
import lm.f1;
import lm.l2;
import os.l;
import os.m;
import un.n;
import xn.h0;
import xn.y;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "KCallables")
public final class e {

    @xm.f(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0}, l = {56}, m = "callSuspend", n = {"$this$callSuspend", d6.a.F}, s = {"L$0", "L$1"})
    public static final class a<R> extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return e.a(null, null, this);
        }
    }

    @xm.f(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0, 0}, l = {74}, m = "callSuspendBy", n = {"$this$callSuspendBy", d6.a.F, "kCallable"}, s = {"L$0", "L$1", "L$2"})
    public static final class b<R> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return e.b(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    @f1(version = "1.3")
    public static final <R> Object a(@l un.c<? extends R> cVar, @l Object[] objArr, @l um.d<? super R> dVar) {
        a aVar;
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
        Object objCall = aVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar.label;
        if (i11 == 0) {
            d1.n(objCall);
            if (!cVar.isSuspend()) {
                return cVar.call(Arrays.copyOf(objArr, objArr.length));
            }
            if (!(cVar instanceof un.i)) {
                throw new IllegalArgumentException("Cannot callSuspend on a property " + cVar + ": suspend properties are not supported yet");
            }
            aVar.L$0 = cVar;
            aVar.L$1 = objArr;
            aVar.label = 1;
            s1 s1Var = new s1(2);
            s1Var.b(objArr);
            s1Var.a(aVar);
            objCall = cVar.call(s1Var.f9356a.toArray(new Object[s1Var.f9356a.size()]));
            if (objCall == aVar2) {
                xm.h.c(aVar);
            }
            if (objCall == aVar2) {
                return aVar2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (un.c) aVar.L$0;
            d1.n(objCall);
        }
        return (!l0.g(cVar.getReturnType().i(), l1.d(l2.class)) || cVar.getReturnType().o()) ? objCall : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @m
    @f1(version = "1.3")
    public static final <R> Object b(@l un.c<? extends R> cVar, @l Map<n, ? extends Object> map, @l um.d<? super R> dVar) throws vn.a {
        b bVar;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object objC = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        if (i11 == 0) {
            d1.n(objC);
            if (!cVar.isSuspend()) {
                return cVar.callBy(map);
            }
            if (!(cVar instanceof un.i)) {
                throw new IllegalArgumentException("Cannot callSuspendBy on a property " + cVar + ": suspend properties are not supported yet");
            }
            xn.f<?> fVarB = h0.b(cVar);
            if (fVarB == null) {
                throw new y(l0.C("This callable does not support a default call: ", cVar));
            }
            bVar.L$0 = cVar;
            bVar.L$1 = map;
            bVar.L$2 = fVarB;
            bVar.label = 1;
            objC = fVarB.C(map, bVar);
            if (objC == aVar) {
                xm.h.c(bVar);
            }
            if (objC == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (un.c) bVar.L$0;
            d1.n(objC);
        }
        return (!l0.g(cVar.getReturnType().i(), l1.d(l2.class)) || cVar.getReturnType().o()) ? objC : l2.f10208a;
    }

    @m
    @f1(version = "1.1")
    public static final n c(@l un.c<?> cVar, @l String str) {
        l0.p(cVar, "<this>");
        l0.p(str, "name");
        Object obj = null;
        boolean z10 = false;
        Object obj2 = null;
        for (Object obj3 : cVar.getParameters()) {
            if (l0.g(((n) obj3).getName(), str)) {
                if (z10) {
                    return (n) obj;
                }
                z10 = true;
                obj2 = obj3;
            }
        }
        if (z10) {
            obj = obj2;
        }
        return (n) obj;
    }

    @m
    public static final n d(@l un.c<?> cVar) {
        l0.p(cVar, "<this>");
        Object obj = null;
        boolean z10 = false;
        Object obj2 = null;
        for (Object obj3 : cVar.getParameters()) {
            if (((n) obj3).getKind() == n.b.EXTENSION_RECEIVER) {
                if (z10) {
                    return (n) obj;
                }
                z10 = true;
                obj2 = obj3;
            }
        }
        if (z10) {
            obj = obj2;
        }
        return (n) obj;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void e(un.c cVar) {
    }

    @m
    public static final n f(@l un.c<?> cVar) {
        l0.p(cVar, "<this>");
        Object obj = null;
        boolean z10 = false;
        Object obj2 = null;
        for (Object obj3 : cVar.getParameters()) {
            if (((n) obj3).getKind() == n.b.INSTANCE) {
                if (z10) {
                    return (n) obj;
                }
                z10 = true;
                obj2 = obj3;
            }
        }
        if (z10) {
            obj = obj2;
        }
        return (n) obj;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void g(un.c cVar) {
    }

    @l
    public static final List<n> h(@l un.c<?> cVar) {
        l0.p(cVar, "<this>");
        List<n> parameters = cVar.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((n) obj).getKind() == n.b.VALUE) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @f1(version = "1.1")
    public static /* synthetic */ void i(un.c cVar) {
    }
}
