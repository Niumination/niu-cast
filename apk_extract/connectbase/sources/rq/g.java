package rq;

import gq.v;
import in.x;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import jn.p;
import jq.e0;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.u1;
import kn.w;
import lm.c1;
import lm.d1;
import lm.l2;
import lm.z0;
import nm.h0;
import nm.r;
import nm.z;
import nq.r0;
import nq.r2;
import nq.t2;
import vq.q0;
import vq.t0;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,620:1\n150#1:638\n151#1,4:640\n156#1,5:645\n150#1:650\n151#1,4:652\n156#1,5:657\n1#2:621\n1#2:639\n1#2:651\n766#3:622\n857#3,2:623\n1208#3,2:625\n1238#3,4:627\n1855#3,2:665\n350#3,7:673\n1819#3,8:680\n603#4:631\n603#4:644\n603#4:656\n603#4:662\n1295#4,2:663\n37#5,2:632\n37#5,2:634\n37#5,2:636\n1627#6,6:667\n1735#6,6:688\n*S KotlinDebug\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n245#1:638\n245#1:640,4\n245#1:645,5\n252#1:650\n252#1:652,4\n252#1:657,5\n245#1:639\n252#1:651\n110#1:622\n110#1:623,2\n111#1:625,2\n111#1:627,4\n307#1:665,2\n416#1:673,7\n506#1:680,8\n154#1:631\n245#1:644\n252#1:656\n287#1:662\n288#1:663,2\n211#1:632,2\n212#1:634,2\n213#1:636,2\n355#1:667,6\n558#1:688,6\n*E\n"})
@z0
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final g f14829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final StackTraceElement f14830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final SimpleDateFormat f14831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public static Thread f14832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final rq.b<a<?>, Boolean> f14833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f14834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f14835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f14836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.m
    public static final jn.l<Boolean, l2> f14837i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final rq.b<xm.e, rq.e> f14838j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public static final b f14839k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public static final c f14840l;

    public static final class a<T> implements um.d<T>, xm.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @in.f
        @os.l
        public final um.d<T> f14841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @in.f
        @os.l
        public final rq.e f14842b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@os.l um.d<? super T> dVar, @os.l rq.e eVar) {
            this.f14841a = dVar;
            this.f14842b = eVar;
        }

        public final m a() {
            return this.f14842b.f14822a;
        }

        @Override // xm.e
        @os.m
        public xm.e getCallerFrame() {
            m mVar = this.f14842b.f14822a;
            if (mVar != null) {
                return mVar.f14847a;
            }
            return null;
        }

        @Override // um.d
        @os.l
        public um.g getContext() {
            return this.f14841a.getContext();
        }

        @Override // xm.e
        @os.m
        public StackTraceElement getStackTraceElement() {
            m mVar = this.f14842b.f14822a;
            if (mVar != null) {
                return mVar.f14848b;
            }
            return null;
        }

        @Override // um.d
        public void resumeWith(@os.l Object obj) {
            g.f14829a.F(this);
            this.f14841a.resumeWith(obj);
        }

        @os.l
        public String toString() {
            return this.f14841a.toString();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final AtomicIntegerFieldUpdater f14843a = AtomicIntegerFieldUpdater.newUpdater(b.class, "installations");

        @x
        private volatile int installations;

        public b() {
        }

        public b(w wVar) {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final AtomicLongFieldUpdater f14844a = AtomicLongFieldUpdater.newUpdater(c.class, "sequenceNumber");

        @x
        private volatile long sequenceNumber;

        public c() {
        }

        public c(w wVar) {
        }
    }

    @r1({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl$dumpCoroutinesInfoImpl$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n1#1,620:1\n1#2:621\n245#3:622\n*E\n"})
    public static final class d extends n0 implements jn.l<a<?>, rq.d> {
        public d() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final rq.d invoke(@os.l a<?> aVar) {
            um.g gVarC;
            if (g.f14829a.z(aVar) || (gVarC = aVar.f14842b.c()) == null) {
                return null;
            }
            return new rq.d(aVar.f14842b, gVarC);
        }
    }

    @r1({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n1#1,328:1\n154#2:329\n*E\n"})
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return rm.g.l(Long.valueOf(((a) t10).f14842b.f14823b), Long.valueOf(((a) t11).f14842b.f14823b));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @r1({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl$dumpCoroutinesInfoImpl$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,620:1\n1#2:621\n*E\n"})
    public static final class f<R> extends n0 implements jn.l<a<?>, R> {
        final /* synthetic */ p<a<?>, um.g, R> $create;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(p<? super a<?>, ? super um.g, ? extends R> pVar) {
            super(1);
            this.$create = pVar;
        }

        @Override // jn.l
        @os.m
        public final R invoke(@os.l a<?> aVar) {
            um.g gVarC;
            if (g.f14829a.z(aVar) || (gVarC = aVar.f14842b.c()) == null) {
                return null;
            }
            return this.$create.invoke(aVar, gVarC);
        }
    }

    /* JADX INFO: renamed from: rq.g$g, reason: collision with other inner class name */
    @r1({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n1#1,328:1\n287#2:329\n*E\n"})
    public static final class C0367g<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return rm.g.l(Long.valueOf(((a) t10).f14842b.f14823b), Long.valueOf(((a) t11).f14842b.f14823b));
        }
    }

    public static final class h extends n0 implements jn.l<a<?>, Boolean> {
        public static final h INSTANCE = new h();

        public h() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l a<?> aVar) {
            return Boolean.valueOf(!g.f14829a.z(aVar));
        }
    }

    @r1({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl$dumpCoroutinesInfoImpl$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n1#1,620:1\n1#2:621\n252#3:622\n*E\n"})
    public static final class i extends n0 implements jn.l<a<?>, rq.j> {
        public i() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final rq.j invoke(@os.l a<?> aVar) {
            um.g gVarC;
            if (g.f14829a.z(aVar) || (gVarC = aVar.f14842b.c()) == null) {
                return null;
            }
            return new rq.j(aVar.f14842b, gVarC);
        }
    }

    public static final class j extends n0 implements jn.a<l2> {
        public static final j INSTANCE = new j();

        public j() {
            super(0);
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            g.f14838j.q();
        }
    }

    static {
        g gVar = new g();
        f14829a = gVar;
        f14830b = new a.a().b();
        f14831c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f14833e = new rq.b<>(false, 1, null);
        f14834f = true;
        f14835g = true;
        f14836h = true;
        f14837i = gVar.t();
        f14838j = new rq.b<>(true);
        f14839k = new b();
        f14840l = new c();
    }

    public static /* synthetic */ void s(nq.l2 l2Var) {
    }

    @in.i(name = "isInstalled$kotlinx_coroutines_debug")
    public final boolean A() {
        return b.f14843a.get(f14839k) > 0;
    }

    public final boolean B(StackTraceElement stackTraceElement) {
        return e0.s2(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, null);
    }

    public final a<?> C(um.d<?> dVar) {
        xm.e eVar = dVar instanceof xm.e ? (xm.e) dVar : null;
        if (eVar != null) {
            return D(eVar);
        }
        return null;
    }

    public final a<?> D(xm.e eVar) {
        while (!(eVar instanceof a)) {
            eVar = eVar.getCallerFrame();
            if (eVar == null) {
                return null;
            }
        }
        return (a) eVar;
    }

    public final void E(PrintStream printStream, List<StackTraceElement> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            printStream.print("\n\tat " + ((StackTraceElement) it.next()));
        }
    }

    public final void F(a<?> aVar) {
        xm.e eVarJ;
        f14833e.remove(aVar);
        xm.e eVarF = aVar.f14842b.f();
        if (eVarF == null || (eVarJ = J(eVarF)) == null) {
            return;
        }
        f14838j.remove(eVarJ);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public final <T> um.d<T> G(@os.l um.d<? super T> dVar) {
        if (!A()) {
            return dVar;
        }
        if (!(f14836h && dVar.getContext() == um.i.INSTANCE) && C(dVar) == null) {
            return e(dVar, f14835g ? Q(K(new Exception())) : null);
        }
        return dVar;
    }

    public final void H(@os.l um.d<?> dVar) {
        V(dVar, rq.f.f14827b);
    }

    public final void I(@os.l um.d<?> dVar) {
        V(dVar, rq.f.f14828c);
    }

    public final xm.e J(xm.e eVar) {
        do {
            eVar = eVar.getCallerFrame();
            if (eVar == null) {
                return null;
            }
        } while (eVar.getStackTraceElement() == null);
        return eVar;
    }

    public final <T extends Throwable> List<StackTraceElement> K(T t10) {
        StackTraceElement[] stackTrace = t10.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i11 = length2 - 1;
                if (l0.g(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i10 = length2;
                    break;
                }
                if (i11 < 0) {
                    break;
                }
                length2 = i11;
            }
        }
        int i12 = i10 + 1;
        if (!f14834f) {
            int i13 = length - i12;
            ArrayList arrayList = new ArrayList(i13);
            for (int i14 = 0; i14 < i13; i14++) {
                arrayList.add(stackTrace[i14 + i12]);
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i12) + 1);
        while (i12 < length) {
            if (B(stackTrace[i12])) {
                arrayList2.add(stackTrace[i12]);
                int i15 = i12 + 1;
                while (i15 < length && B(stackTrace[i15])) {
                    i15++;
                }
                int i16 = i15 - 1;
                int i17 = i16;
                while (i17 > i12 && stackTrace[i17].getFileName() == null) {
                    i17--;
                }
                if (i17 > i12 && i17 < i16) {
                    arrayList2.add(stackTrace[i17]);
                }
                arrayList2.add(stackTrace[i16]);
                i12 = i15;
            } else {
                arrayList2.add(stackTrace[i12]);
                i12++;
            }
        }
        return arrayList2;
    }

    public final void L(boolean z10) {
        f14835g = z10;
    }

    public final void M(boolean z10) {
        f14836h = z10;
    }

    public final void N(boolean z10) {
        f14834f = z10;
    }

    public final void O() {
        f14832d = sm.b.c(false, true, null, "Coroutines Debugger Cleaner", 0, j.INSTANCE, 21, null);
    }

    public final void P() throws InterruptedException {
        Thread thread = f14832d;
        if (thread == null) {
            return;
        }
        f14832d = null;
        thread.interrupt();
        thread.join();
    }

    public final m Q(List<StackTraceElement> list) {
        m mVar = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                mVar = new m(mVar, listIterator.previous());
            }
        }
        return new m(mVar, f14830b);
    }

    public final String R(Object obj) {
        return rq.h.b(obj.toString());
    }

    public final void S() throws InterruptedException {
        jn.l<Boolean, l2> lVar;
        if (!A()) {
            throw new IllegalStateException("Agent was not installed");
        }
        if (b.f14843a.decrementAndGet(f14839k) != 0) {
            return;
        }
        P();
        f14833e.clear();
        f14838j.clear();
        rq.a.f14788a.getClass();
        if (rq.a.f14789b || (lVar = f14837i) == null) {
            return;
        }
        lVar.invoke(Boolean.FALSE);
    }

    public final void T(xm.e eVar, String str) {
        boolean z10;
        if (A()) {
            rq.b<xm.e, rq.e> bVar = f14838j;
            rq.e eVarRemove = bVar.remove(eVar);
            if (eVarRemove != null) {
                z10 = false;
            } else {
                a<?> aVarD = D(eVar);
                if (aVarD == null || (eVarRemove = aVarD.f14842b) == null) {
                    return;
                }
                xm.e eVarF = eVarRemove.f();
                xm.e eVarJ = eVarF != null ? J(eVarF) : null;
                if (eVarJ != null) {
                    bVar.remove(eVarJ);
                }
                z10 = true;
            }
            l0.n(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            eVarRemove.j(str, (um.d) eVar, z10);
            xm.e eVarJ2 = J(eVar);
            if (eVarJ2 == null) {
                return;
            }
            bVar.put(eVarJ2, eVarRemove);
        }
    }

    public final void U(a<?> aVar, um.d<?> dVar, String str) {
        if (A()) {
            aVar.f14842b.j(str, dVar, true);
        }
    }

    public final void V(um.d<?> dVar, String str) {
        if (A()) {
            if (f14836h && dVar.getContext() == um.i.INSTANCE) {
                return;
            }
            if (l0.g(str, rq.f.f14827b)) {
                xm.e eVar = dVar instanceof xm.e ? (xm.e) dVar : null;
                if (eVar == null) {
                    return;
                }
                T(eVar, str);
                return;
            }
            a<?> aVarC = C(dVar);
            if (aVarC == null) {
                return;
            }
            U(aVarC, dVar, str);
        }
    }

    public final void d(nq.l2 l2Var, Map<nq.l2, rq.e> map, StringBuilder sb2, String str) {
        rq.e eVar = map.get(l2Var);
        if (eVar != null) {
            StackTraceElement stackTraceElement = (StackTraceElement) h0.G2(eVar.h());
            String str2 = eVar._state;
            StringBuilder sbA = k.a.a(str);
            sbA.append(r(l2Var));
            sbA.append(", continuation is ");
            sbA.append(str2);
            sbA.append(" at line ");
            sbA.append(stackTraceElement);
            sbA.append('\n');
            sb2.append(sbA.toString());
            str = l.a.a(new StringBuilder(), str, '\t');
        } else if (!(l2Var instanceof q0)) {
            StringBuilder sbA2 = k.a.a(str);
            sbA2.append(r(l2Var));
            sbA2.append('\n');
            sb2.append(sbA2.toString());
            str = l.a.a(new StringBuilder(), str, '\t');
        }
        Iterator<nq.l2> it = l2Var.y().iterator();
        while (it.hasNext()) {
            d(it.next(), map, sb2, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> um.d<T> e(um.d<? super T> dVar, m mVar) {
        if (!A()) {
            return dVar;
        }
        a<?> aVar = new a<>(dVar, new rq.e(dVar.getContext(), mVar, c.f14844a.incrementAndGet(f14840l)));
        rq.b<a<?>, Boolean> bVar = f14833e;
        bVar.put(aVar, Boolean.TRUE);
        if (!A()) {
            bVar.clear();
        }
        return aVar;
    }

    @in.i(name = "dumpCoroutines")
    public final void f(@os.l PrintStream printStream) {
        synchronized (printStream) {
            f14829a.j(printStream);
            l2 l2Var = l2.f10208a;
        }
    }

    @os.l
    public final List<rq.d> g() {
        if (A()) {
            return v.c3(v.p1(v.K2(h0.A1(f14833e.c()), new e()), new d()));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    @os.l
    public final Object[] h() {
        String str;
        List<rq.d> listG = g();
        int size = listG.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList(size);
        for (rq.d dVar : listG) {
            um.g gVar = dVar.f14814a;
            r0 r0Var = (r0) gVar.get(r0.f11910b);
            Long lValueOf = null;
            String strR = (r0Var == null || (str = r0Var.f11911a) == null) ? null : R(str);
            nq.n0 n0Var = (nq.n0) gVar.get(nq.n0.Key);
            String strR2 = n0Var != null ? R(n0Var) : null;
            StringBuilder sbA = e.a.a("\n                {\n                    \"name\": ", strR, ",\n                    \"id\": ");
            nq.q0 q0Var = (nq.q0) gVar.get(nq.q0.f11900b);
            if (q0Var != null) {
                lValueOf = Long.valueOf(q0Var.f11901a);
            }
            sbA.append(lValueOf);
            sbA.append(",\n                    \"dispatcher\": ");
            sbA.append(strR2);
            sbA.append(",\n                    \"sequenceNumber\": ");
            sbA.append(dVar.f14816c);
            sbA.append(",\n                    \"state\": \"");
            sbA.append(dVar.f14818e);
            sbA.append("\"\n                } \n                ");
            arrayList3.add(jq.x.p(sbA.toString()));
            arrayList2.add(dVar.f14820g);
            arrayList.add(dVar.f14819f);
        }
        return new Object[]{l.a.a(new StringBuilder("["), h0.m3(arrayList3, null, null, null, 0, null, null, 63, null), ']'), arrayList.toArray(new Thread[0]), arrayList2.toArray(new xm.e[0]), listG.toArray(new rq.d[0])};
    }

    public final <R> List<R> i(p<? super a<?>, ? super um.g, ? extends R> pVar) {
        if (A()) {
            return v.c3(v.p1(v.K2(h0.A1(f14833e.c()), new e()), new f(pVar)));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    public final void j(PrintStream printStream) {
        if (!A()) {
            throw new IllegalStateException("Debug probes are not installed");
        }
        printStream.print("Coroutines dump " + f14831c.format(Long.valueOf(System.currentTimeMillis())));
        for (a aVar : v.K2(v.p0(h0.A1(f14833e.c()), h.INSTANCE), new C0367g())) {
            rq.e eVar = aVar.f14842b;
            List<StackTraceElement> listH = eVar.h();
            g gVar = f14829a;
            List<StackTraceElement> listN = gVar.n(eVar._state, eVar.lastObservedThread, listH);
            printStream.print("\n\nCoroutine " + aVar.f14841a + ", state: " + ((l0.g(eVar._state, rq.f.f14827b) && listN == listH) ? j.c.a(new StringBuilder(), eVar._state, " (Last suspension stacktrace, not an actual stacktrace)") : eVar._state));
            if (listH.isEmpty()) {
                printStream.print("\n\tat " + f14830b);
                gVar.E(printStream, eVar.b());
            } else {
                gVar.E(printStream, listN);
            }
        }
    }

    @os.l
    public final List<rq.j> k() {
        if (A()) {
            return v.c3(v.p1(v.K2(h0.A1(f14833e.c()), new e()), new i()));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    @os.l
    public final List<StackTraceElement> l(@os.l rq.d dVar, @os.l List<StackTraceElement> list) {
        return n(dVar.f14818e, dVar.f14819f, list);
    }

    @os.l
    public final String m(@os.l rq.d dVar) {
        List<StackTraceElement> listL = l(dVar, dVar.f14821h);
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : listL) {
            StringBuilder sb2 = new StringBuilder("\n                {\n                    \"declaringClass\": \"");
            sb2.append(stackTraceElement.getClassName());
            sb2.append("\",\n                    \"methodName\": \"");
            sb2.append(stackTraceElement.getMethodName());
            sb2.append("\",\n                    \"fileName\": ");
            String fileName = stackTraceElement.getFileName();
            sb2.append(fileName != null ? R(fileName) : null);
            sb2.append(",\n                    \"lineNumber\": ");
            sb2.append(stackTraceElement.getLineNumber());
            sb2.append("\n                }\n                ");
            arrayList.add(jq.x.p(sb2.toString()));
        }
        return l.a.a(new StringBuilder("["), h0.m3(arrayList, null, null, null, 0, null, null, 63, null), ']');
    }

    public final List<StackTraceElement> n(String str, Thread thread, List<StackTraceElement> list) {
        Object objM59constructorimpl;
        if (!l0.g(str, rq.f.f14827b) || thread == null) {
            return list;
        }
        try {
            c1.a aVar = c1.Companion;
            objM59constructorimpl = c1.m59constructorimpl(thread.getStackTrace());
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            objM59constructorimpl = c1.m59constructorimpl(d1.a(th2));
        }
        if (c1.m64isFailureimpl(objM59constructorimpl)) {
            objM59constructorimpl = null;
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) objM59constructorimpl;
        if (stackTraceElementArr == null) {
            return list;
        }
        int length = stackTraceElementArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i10];
            if (l0.g(stackTraceElement.getClassName(), t0.f17880a) && l0.g(stackTraceElement.getMethodName(), "resumeWith") && l0.g(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                break;
            }
            i10++;
        }
        lm.t0<Integer, Integer> t0VarO = o(i10, stackTraceElementArr, list);
        int iIntValue = t0VarO.component1().intValue();
        int iIntValue2 = t0VarO.component2().intValue();
        if (iIntValue == -1) {
            return list;
        }
        ArrayList arrayList = new ArrayList((((list.size() + i10) - iIntValue) - 1) - iIntValue2);
        int i11 = i10 - iIntValue2;
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(stackTraceElementArr[i12]);
        }
        int size = list.size();
        for (int i13 = iIntValue + 1; i13 < size; i13++) {
            arrayList.add(list.get(i13));
        }
        return arrayList;
    }

    public final lm.t0<Integer, Integer> o(int i10, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        for (int i11 = 0; i11 < 3; i11++) {
            int iP = f14829a.p((i10 - 1) - i11, stackTraceElementArr, list);
            if (iP != -1) {
                return new lm.t0<>(Integer.valueOf(iP), Integer.valueOf(i11));
            }
        }
        return new lm.t0<>(-1, 0);
    }

    public final int p(int i10, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) r.Pe(stackTraceElementArr, i10);
        if (stackTraceElement == null) {
            return -1;
        }
        int i11 = 0;
        for (StackTraceElement stackTraceElement2 : list) {
            if (l0.g(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && l0.g(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && l0.g(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public final Set<a<?>> q() {
        return f14833e.c();
    }

    public final String r(nq.l2 l2Var) {
        return l2Var instanceof t2 ? ((t2) l2Var).G1() : l2Var.toString();
    }

    public final jn.l<Boolean, l2> t() {
        Object objM59constructorimpl;
        try {
            c1.a aVar = c1.Companion;
            Object objNewInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(null);
            l0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            objM59constructorimpl = c1.m59constructorimpl((jn.l) u1.q(objNewInstance, 1));
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            objM59constructorimpl = c1.m59constructorimpl(d1.a(th2));
        }
        return (jn.l) (c1.m64isFailureimpl(objM59constructorimpl) ? null : objM59constructorimpl);
    }

    public final boolean u() {
        return f14835g;
    }

    public final boolean v() {
        return f14836h;
    }

    public final boolean w() {
        return f14834f;
    }

    @os.l
    public final String x(@os.l nq.l2 l2Var) {
        if (!A()) {
            throw new IllegalStateException("Debug probes are not installed");
        }
        Set<a<?>> setC = f14833e.c();
        ArrayList<a> arrayList = new ArrayList();
        for (Object obj : setC) {
            if (((a) obj).f14841a.getContext().get(nq.l2.f11882k) != null) {
                arrayList.add(obj);
            }
        }
        int iJ = nm.c1.j(z.b0(arrayList, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (a aVar : arrayList) {
            linkedHashMap.put(r2.z(aVar.f14841a.getContext()), aVar.f14842b);
        }
        StringBuilder sb2 = new StringBuilder();
        f14829a.d(l2Var, linkedHashMap, sb2, "");
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final void y() {
        jn.l<Boolean, l2> lVar;
        if (b.f14843a.incrementAndGet(f14839k) > 1) {
            return;
        }
        O();
        rq.a.f14788a.getClass();
        if (rq.a.f14789b || (lVar = f14837i) == null) {
            return;
        }
        lVar.invoke(Boolean.TRUE);
    }

    public final boolean z(a<?> aVar) {
        nq.l2 l2Var;
        um.g gVarC = aVar.f14842b.c();
        if (gVarC == null || (l2Var = (nq.l2) gVarC.get(nq.l2.f11882k)) == null || !l2Var.isCompleted()) {
            return false;
        }
        f14833e.remove(aVar);
        return true;
    }
}
