package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CompletedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,662:1\n1#2:663\n*E\n"})
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    @in.f
    public final Object f11826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    @in.f
    public final n f11827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    @in.f
    public final jn.l<Throwable, lm.l2> f11828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    @in.f
    public final Object f11829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    @in.f
    public final Throwable f11830e;

    /* JADX WARN: Multi-variable type inference failed */
    public c0(@os.m Object obj, @os.m n nVar, @os.m jn.l<? super Throwable, lm.l2> lVar, @os.m Object obj2, @os.m Throwable th2) {
        this.f11826a = obj;
        this.f11827b = nVar;
        this.f11828c = lVar;
        this.f11829d = obj2;
        this.f11830e = th2;
    }

    public static c0 g(c0 c0Var, Object obj, n nVar, jn.l lVar, Object obj2, Throwable th2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = c0Var.f11826a;
        }
        if ((i10 & 2) != 0) {
            nVar = c0Var.f11827b;
        }
        n nVar2 = nVar;
        if ((i10 & 4) != 0) {
            lVar = c0Var.f11828c;
        }
        jn.l lVar2 = lVar;
        if ((i10 & 8) != 0) {
            obj2 = c0Var.f11829d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th2 = c0Var.f11830e;
        }
        c0Var.getClass();
        return new c0(obj, nVar2, lVar2, obj4, th2);
    }

    @os.m
    public final Object a() {
        return this.f11826a;
    }

    @os.m
    public final n b() {
        return this.f11827b;
    }

    @os.m
    public final jn.l<Throwable, lm.l2> c() {
        return this.f11828c;
    }

    @os.m
    public final Object d() {
        return this.f11829d;
    }

    @os.m
    public final Throwable e() {
        return this.f11830e;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return kn.l0.g(this.f11826a, c0Var.f11826a) && kn.l0.g(this.f11827b, c0Var.f11827b) && kn.l0.g(this.f11828c, c0Var.f11828c) && kn.l0.g(this.f11829d, c0Var.f11829d) && kn.l0.g(this.f11830e, c0Var.f11830e);
    }

    @os.l
    public final c0 f(@os.m Object obj, @os.m n nVar, @os.m jn.l<? super Throwable, lm.l2> lVar, @os.m Object obj2, @os.m Throwable th2) {
        return new c0(obj, nVar, lVar, obj2, th2);
    }

    public final boolean h() {
        return this.f11830e != null;
    }

    public int hashCode() {
        Object obj = this.f11826a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        n nVar = this.f11827b;
        int iHashCode2 = (iHashCode + (nVar == null ? 0 : nVar.hashCode())) * 31;
        jn.l<Throwable, lm.l2> lVar = this.f11828c;
        int iHashCode3 = (iHashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f11829d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th2 = this.f11830e;
        return iHashCode4 + (th2 != null ? th2.hashCode() : 0);
    }

    public final void i(@os.l q<?> qVar, @os.l Throwable th2) {
        n nVar = this.f11827b;
        if (nVar != null) {
            qVar.p(nVar, th2);
        }
        jn.l<Throwable, lm.l2> lVar = this.f11828c;
        if (lVar != null) {
            qVar.r(lVar, th2);
        }
    }

    @os.l
    public String toString() {
        return "CompletedContinuation(result=" + this.f11826a + ", cancelHandler=" + this.f11827b + ", onCancellation=" + this.f11828c + ", idempotentResume=" + this.f11829d + ", cancelCause=" + this.f11830e + ')';
    }

    public /* synthetic */ c0(Object obj, n nVar, jn.l lVar, Object obj2, Throwable th2, int i10, kn.w wVar) {
        this(obj, (i10 & 2) != 0 ? null : nVar, (i10 & 4) != 0 ? null : lVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th2);
    }
}
