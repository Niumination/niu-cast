package hh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k3.c9;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import m3.j6;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    private volatile /* synthetic */ Object _interceptors;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zg.h f5397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5400d;
    public h e;

    public e(h... phases) {
        Intrinsics.checkNotNullParameter(phases, "phases");
        this.f5397a = j6.a(true);
        this.f5398b = CollectionsKt.mutableListOf(Arrays.copyOf(phases, phases.length));
        this._interceptors = null;
    }

    public void a() {
    }

    public final Object b(Object context, Object subject, ContinuationImpl continuationImpl) {
        CoroutineContext coroutineContext = continuationImpl.get$context();
        List interceptors = r();
        boolean zH = h();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return ((g.f5402a || zH) ? new b(context, interceptors, subject, coroutineContext) : new o(subject, context, interceptors)).a(subject, continuationImpl);
    }

    public final boolean d(e eVar) {
        if (eVar.f5398b.isEmpty()) {
            return true;
        }
        List list = this.f5398b;
        int i8 = 0;
        if (!list.isEmpty()) {
            return false;
        }
        List list2 = eVar.f5398b;
        int lastIndex = CollectionsKt.getLastIndex(list2);
        if (lastIndex >= 0) {
            while (true) {
                Object obj = list2.get(i8);
                if (obj instanceof h) {
                    list.add(obj);
                } else if (obj instanceof d) {
                    d dVar = (d) obj;
                    h hVar = dVar.f5393a;
                    c9 c9Var = dVar.f5394b;
                    dVar.f5396d = true;
                    list.add(new d(hVar, c9Var, dVar.f5395c));
                }
                if (i8 == lastIndex) {
                    break;
                }
                i8++;
            }
        }
        this.f5399c += eVar.f5399c;
        this._interceptors = eVar.r();
        this.f5400d = true;
        this.e = null;
        return true;
    }

    public final d e(h hVar) {
        List list = this.f5398b;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = list.get(i8);
            if (obj == hVar) {
                d dVar = new d(hVar, k.f5406a);
                list.set(i8, dVar);
                return dVar;
            }
            if (obj instanceof d) {
                d dVar2 = (d) obj;
                if (dVar2.f5393a == hVar) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    public final int f(h hVar) {
        List list = this.f5398b;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = list.get(i8);
            if (obj == hVar || ((obj instanceof d) && ((d) obj).f5393a == hVar)) {
                return i8;
            }
        }
        return -1;
    }

    public abstract boolean h();

    public final boolean j(h hVar) {
        List list = this.f5398b;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = list.get(i8);
            if (obj == hVar) {
                return true;
            }
            if ((obj instanceof d) && ((d) obj).f5393a == hVar) {
                return true;
            }
        }
        return false;
    }

    public final void m(h reference, h phase) throws c {
        c9 c9Var;
        h hVar;
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(phase, "phase");
        if (j(phase)) {
            return;
        }
        int iF = f(reference);
        if (iF == -1) {
            throw new c("Phase " + reference + " was not registered for this pipeline");
        }
        int i8 = iF + 1;
        List list = this.f5398b;
        int lastIndex = CollectionsKt.getLastIndex(list);
        if (i8 <= lastIndex) {
            while (true) {
                Object obj = list.get(i8);
                d dVar = obj instanceof d ? (d) obj : null;
                if (dVar != null && (c9Var = dVar.f5394b) != null) {
                    i iVar = c9Var instanceof i ? (i) c9Var : null;
                    if (iVar != null && (hVar = iVar.f5404a) != null && Intrinsics.areEqual(hVar, reference)) {
                        iF = i8;
                    }
                    if (i8 == lastIndex) {
                        break;
                    } else {
                        i8++;
                    }
                } else {
                    break;
                }
            }
        }
        list.add(iF + 1, new d(phase, new i(reference)));
    }

    public final void n(h reference, h phase) throws c {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(phase, "phase");
        if (j(phase)) {
            return;
        }
        int iF = f(reference);
        if (iF != -1) {
            this.f5398b.add(iF, new d(phase, new j(reference)));
        } else {
            throw new c("Phase " + reference + " was not registered for this pipeline");
        }
    }

    public final void p(h phase, Function3 interceptor) throws c {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(interceptor, "block");
        d dVarE = e(phase);
        if (dVarE == null) {
            throw new c("Phase " + phase + " was not registered for this pipeline");
        }
        List list = (List) this._interceptors;
        if (!this.f5398b.isEmpty() && list != null && !this.f5400d && TypeIntrinsics.isMutableList(list)) {
            if (Intrinsics.areEqual(this.e, phase)) {
                list.add(interceptor);
            } else if (Intrinsics.areEqual(phase, CollectionsKt.last(this.f5398b)) || f(phase) == CollectionsKt.getLastIndex(this.f5398b)) {
                d dVarE2 = e(phase);
                Intrinsics.checkNotNull(dVarE2);
                dVarE2.getClass();
                Intrinsics.checkNotNullParameter(interceptor, "interceptor");
                if (dVarE2.f5396d) {
                    dVarE2.f5395c = CollectionsKt.toMutableList((Collection) dVarE2.f5395c);
                    dVarE2.f5396d = false;
                }
                dVarE2.f5395c.add(interceptor);
                list.add(interceptor);
            }
            this.f5399c++;
            return;
        }
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        if (dVarE.f5396d) {
            dVarE.f5395c = CollectionsKt.toMutableList((Collection) dVarE.f5395c);
            dVarE.f5396d = false;
        }
        dVarE.f5395c.add(interceptor);
        this.f5399c++;
        this._interceptors = null;
        this.f5400d = false;
        this.e = null;
        a();
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0085  */
    /* JADX WARN: Code duplicated, block: B:72:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0027 A[SYNTHETIC] */
    public final void q(e from) throws c {
        Object obj;
        Intrinsics.checkNotNullParameter(from, "from");
        if (d(from)) {
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        List mutableList = CollectionsKt.toMutableList((Collection) from.f5398b);
        while (!mutableList.isEmpty()) {
            Iterator it = mutableList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                h phase = next instanceof h ? (h) next : null;
                if (phase == null) {
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type io.ktor.util.pipeline.PhaseContent<*, *>");
                    phase = ((d) next).f5393a;
                }
                if (j(phase)) {
                    it.remove();
                } else {
                    if (next == phase) {
                        obj = k.f5406a;
                    } else {
                        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type io.ktor.util.pipeline.PhaseContent<*, *>");
                        obj = ((d) next).f5394b;
                    }
                    if (obj instanceof k) {
                        Intrinsics.checkNotNullParameter(phase, "phase");
                        if (!j(phase)) {
                            this.f5398b.add(phase);
                        }
                    } else if (obj instanceof j) {
                        j jVar = (j) obj;
                        if (j(jVar.f5405a)) {
                            n(jVar.f5405a, phase);
                        } else if (obj instanceof i) {
                            m(((i) obj).f5404a, phase);
                        }
                    } else if (obj instanceof i) {
                        m(((i) obj).f5404a, phase);
                    }
                    it.remove();
                }
            }
        }
        if (this.f5399c == 0) {
            this._interceptors = from.r();
            this.f5400d = true;
            this.e = null;
        } else {
            this._interceptors = null;
            this.f5400d = false;
            this.e = null;
        }
        for (Object obj2 : from.f5398b) {
            h hVar = obj2 instanceof h ? (h) obj2 : null;
            if (hVar == null) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.ktor.util.pipeline.PhaseContent<*, *>");
                hVar = ((d) obj2).f5393a;
            }
            if (obj2 instanceof d) {
                d dVar = (d) obj2;
                if (!dVar.f5395c.isEmpty()) {
                    d destination = e(hVar);
                    Intrinsics.checkNotNull(destination);
                    Intrinsics.checkNotNullParameter(destination, "destination");
                    if (!dVar.f5395c.isEmpty()) {
                        if (destination.f5395c.isEmpty()) {
                            dVar.f5396d = true;
                            destination.f5395c = dVar.f5395c;
                            destination.f5396d = true;
                        } else {
                            if (destination.f5396d) {
                                destination.f5395c = CollectionsKt.toMutableList((Collection) destination.f5395c);
                                destination.f5396d = false;
                            }
                            dVar.a(destination.f5395c);
                        }
                    }
                    this.f5399c = dVar.f5395c.size() + this.f5399c;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0064  */
    /* JADX WARN: Code duplicated, block: B:29:0x0067  */
    /* JADX WARN: Code duplicated, block: B:32:0x006b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070 A[LOOP:1: B:26:0x005c->B:34:0x0070, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x0073 A[EDGE_INSN: B:40:0x0073->B:35:0x0073 BREAK  A[LOOP:1: B:26:0x005c->B:34:0x0070], SYNTHETIC] */
    public final List r() {
        ArrayList arrayList;
        int lastIndex;
        int i8;
        Object obj;
        d dVar;
        int lastIndex2;
        if (((List) this._interceptors) == null) {
            int i9 = this.f5399c;
            if (i9 == 0) {
                this._interceptors = CollectionsKt.emptyList();
                this.f5400d = false;
                this.e = null;
                CollectionsKt.emptyList();
            } else {
                List list = this.f5398b;
                if (i9 != 1 || (lastIndex2 = CollectionsKt.getLastIndex(list)) < 0) {
                    arrayList = new ArrayList();
                    lastIndex = CollectionsKt.getLastIndex(list);
                    if (lastIndex >= 0) {
                        i8 = 0;
                        while (true) {
                            obj = list.get(i8);
                            if (obj instanceof d) {
                                dVar = (d) obj;
                            } else {
                                dVar = null;
                            }
                            if (dVar != null) {
                                dVar.a(arrayList);
                            }
                            if (i8 != lastIndex) {
                                break;
                            }
                            i8++;
                        }
                    }
                    this._interceptors = arrayList;
                    this.f5400d = false;
                    this.e = null;
                } else {
                    int i10 = 0;
                    while (true) {
                        Object obj2 = list.get(i10);
                        d dVar2 = obj2 instanceof d ? (d) obj2 : null;
                        if (dVar2 != null && !dVar2.f5395c.isEmpty()) {
                            List list2 = dVar2.f5395c;
                            dVar2.f5396d = true;
                            this._interceptors = list2;
                            this.f5400d = false;
                            this.e = dVar2.f5393a;
                        } else {
                            if (i10 == lastIndex2) {
                                break;
                            }
                            i10++;
                        }
                    }
                    arrayList = new ArrayList();
                    lastIndex = CollectionsKt.getLastIndex(list);
                    if (lastIndex >= 0) {
                        i8 = 0;
                        while (true) {
                            obj = list.get(i8);
                            if (obj instanceof d) {
                                dVar = (d) obj;
                            } else {
                                dVar = null;
                            }
                            if (dVar != null) {
                                dVar.a(arrayList);
                            }
                            if (i8 != lastIndex) {
                                break;
                                break;
                            }
                            i8++;
                        }
                    }
                    this._interceptors = arrayList;
                    this.f5400d = false;
                    this.e = null;
                }
            }
        }
        this.f5400d = true;
        List list3 = (List) this._interceptors;
        Intrinsics.checkNotNull(list3);
        return list3;
    }
}
