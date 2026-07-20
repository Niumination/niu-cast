package vq;

import java.util.ArrayDeque;
import java.util.Iterator;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nStackTraceRecovery.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,216:1\n1735#2,6:217\n12744#2,2:225\n1627#2,6:229\n12744#2,2:235\n1627#2,6:238\n37#3,2:223\n26#4:227\n26#4:228\n1#5:237\n*S KotlinDebug\n*F\n+ 1 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n43#1:217,6\n131#1:225,2\n141#1:229,6\n173#1:235,2\n194#1:238,6\n106#1:223,2\n133#1:227\n135#1:228\n*E\n"})
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f17880a = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f17881b = "kotlinx.coroutines.internal.StackTraceRecoveryKt";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final StackTraceElement f17882c = new a.a().a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f17883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f17884e;

    static {
        Object objM59constructorimpl;
        Object objM59constructorimpl2;
        try {
            lm.c1.a aVar = lm.c1.Companion;
            objM59constructorimpl = lm.c1.m59constructorimpl(xm.a.class.getCanonicalName());
        } catch (Throwable th2) {
            lm.c1.a aVar2 = lm.c1.Companion;
            objM59constructorimpl = lm.c1.m59constructorimpl(lm.d1.a(th2));
        }
        if (lm.c1.m62exceptionOrNullimpl(objM59constructorimpl) != null) {
            objM59constructorimpl = f17880a;
        }
        f17883d = (String) objM59constructorimpl;
        try {
            lm.c1.a aVar3 = lm.c1.Companion;
            objM59constructorimpl2 = lm.c1.m59constructorimpl(t0.class.getCanonicalName());
        } catch (Throwable th3) {
            lm.c1.a aVar4 = lm.c1.Companion;
            objM59constructorimpl2 = lm.c1.m59constructorimpl(lm.d1.a(th3));
        }
        if (lm.c1.m62exceptionOrNullimpl(objM59constructorimpl2) != null) {
            objM59constructorimpl2 = f17881b;
        }
        f17884e = (String) objM59constructorimpl2;
    }

    public static /* synthetic */ void a() {
    }

    public static /* synthetic */ void b() {
    }

    public static final <E extends Throwable> lm.t0<E, StackTraceElement[]> d(E e10) {
        lm.t0<E, StackTraceElement[]> t0Var;
        Throwable cause = e10.getCause();
        if (cause == null || !kn.l0.g(cause.getClass(), e10.getClass())) {
            t0Var = new lm.t0<>(e10, new StackTraceElement[0]);
        } else {
            StackTraceElement[] stackTrace = e10.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (j(stackTraceElement)) {
                    return new lm.t0<>(cause, stackTrace);
                }
            }
            t0Var = new lm.t0<>(e10, new StackTraceElement[0]);
        }
        return t0Var;
    }

    public static final <E extends Throwable> E e(E e10, E e11, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(f17882c);
        StackTraceElement[] stackTrace = e10.getStackTrace();
        int iH = h(stackTrace, f17883d);
        int i10 = 0;
        if (iH == -1) {
            e11.setStackTrace((StackTraceElement[]) arrayDeque.toArray(new StackTraceElement[0]));
            return e11;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + iH];
        for (int i11 = 0; i11 < iH; i11++) {
            stackTraceElementArr[i11] = stackTrace[i11];
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            stackTraceElementArr[i10 + iH] = it.next();
            i10++;
        }
        e11.setStackTrace(stackTraceElementArr);
        return e11;
    }

    public static final ArrayDeque<StackTraceElement> f(xm.e eVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = eVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            eVar = eVar.getCallerFrame();
            if (eVar == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = eVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    public static final boolean g(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && kn.l0.g(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && kn.l0.g(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && kn.l0.g(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    public static final int h(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (kn.l0.g(str, stackTraceElementArr[i10].getClassName())) {
                return i10;
            }
        }
        return -1;
    }

    public static final void i(@os.l Throwable th2, @os.l Throwable th3) {
        th2.initCause(th3);
    }

    public static final boolean j(@os.l StackTraceElement stackTraceElement) {
        return jq.e0.s2(stackTraceElement.getClassName(), a.b.c(), false, 2, null);
    }

    public static final void k(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            } else if (j(stackTraceElementArr[i10])) {
                break;
            } else {
                i10++;
            }
        }
        int i11 = i10 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i11 > length2) {
            return;
        }
        while (true) {
            if (g(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i11) {
                return;
            } else {
                length2--;
            }
        }
    }

    @os.m
    public static final Object l(@os.l Throwable th2, @os.l um.d<?> dVar) throws Throwable {
        throw th2;
    }

    public static final Object m(Throwable th2, um.d<?> dVar) throws Throwable {
        throw th2;
    }

    public static final <E extends Throwable> E n(E e10, xm.e eVar) {
        lm.t0 t0VarD = d(e10);
        Throwable th2 = (Throwable) t0VarD.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) t0VarD.component2();
        Throwable thG = p.g(th2);
        if (thG == null) {
            return e10;
        }
        ArrayDeque<StackTraceElement> arrayDequeF = f(eVar);
        if (arrayDequeF.isEmpty()) {
            return e10;
        }
        if (th2 != e10) {
            k(stackTraceElementArr, arrayDequeF);
        }
        return (E) e(th2, thG, arrayDequeF);
    }

    @os.l
    public static final <E extends Throwable> E o(@os.l E e10) {
        return e10;
    }

    @os.l
    public static final <E extends Throwable> E p(@os.l E e10, @os.l um.d<?> dVar) {
        return e10;
    }

    public static final <E extends Throwable> E q(E e10) {
        StackTraceElement[] stackTrace = e10.getStackTrace();
        int length = stackTrace.length;
        int length2 = stackTrace.length - 1;
        if (length2 < 0) {
            length2 = -1;
            break;
        }
        while (true) {
            int i10 = length2 - 1;
            if (kn.l0.g(f17884e, stackTrace[length2].getClassName())) {
                break;
            }
            if (i10 < 0) {
                length2 = -1;
                break;
            }
            length2 = i10;
        }
        int i11 = length2 + 1;
        int iH = h(stackTrace, f17883d);
        int i12 = 0;
        int i13 = (length - length2) - (iH == -1 ? 0 : length - iH);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i13];
        while (i12 < i13) {
            stackTraceElementArr[i12] = i12 == 0 ? f17882c : stackTrace[(i11 + i12) - 1];
            i12++;
        }
        e10.setStackTrace(stackTraceElementArr);
        return e10;
    }

    @lm.z0
    @os.l
    public static final <E extends Throwable> E r(@os.l E e10) {
        return e10;
    }

    @lm.z0
    @os.l
    public static final <E extends Throwable> E s(@os.l E e10) {
        E e11 = (E) e10.getCause();
        if (e11 != null && kn.l0.g(e11.getClass(), e10.getClass())) {
            for (StackTraceElement stackTraceElement : e10.getStackTrace()) {
                if (j(stackTraceElement)) {
                    return e11;
                }
            }
        }
        return e10;
    }
}
