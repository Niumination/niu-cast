package lm;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
@in.g
@f1(version = "1.3")
public final class c1<T> implements Serializable {

    @os.l
    public static final a Companion = new a();

    @os.m
    private final Object value;

    public static final class a {
        public a() {
        }

        @an.f
        @in.i(name = "failure")
        public final <T> Object a(Throwable th2) {
            kn.l0.p(th2, "exception");
            return c1.m59constructorimpl(d1.a(th2));
        }

        @an.f
        @in.i(name = "success")
        public final <T> Object b(T t10) {
            return c1.m59constructorimpl(t10);
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b implements Serializable {

        @in.f
        @os.l
        public final Throwable exception;

        public b(@os.l Throwable th2) {
            kn.l0.p(th2, "exception");
            this.exception = th2;
        }

        public boolean equals(@os.m Object obj) {
            return (obj instanceof b) && kn.l0.g(this.exception, ((b) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        @os.l
        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    @z0
    public /* synthetic */ c1(Object obj) {
        this.value = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final T a(Object obj) {
        if (m64isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ c1 m58boximpl(Object obj) {
        return new c1(obj);
    }

    @z0
    @os.l
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m59constructorimpl(@os.m Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m60equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof c1) && kn.l0.g(obj, ((c1) obj2).m67unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m61equalsimpl0(Object obj, Object obj2) {
        return kn.l0.g(obj, obj2);
    }

    @os.m
    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m62exceptionOrNullimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).exception;
        }
        return null;
    }

    @z0
    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m63hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* JADX INFO: renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m64isFailureimpl(Object obj) {
        return obj instanceof b;
    }

    /* JADX INFO: renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m65isSuccessimpl(Object obj) {
        return !(obj instanceof b);
    }

    @os.l
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m66toStringimpl(Object obj) {
        return obj instanceof b ? ((b) obj).toString() : em.a.a("Success(", obj, ')');
    }

    public boolean equals(Object obj) {
        return m60equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m63hashCodeimpl(this.value);
    }

    @os.l
    public String toString() {
        return m66toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m67unboximpl() {
        return this.value;
    }
}
