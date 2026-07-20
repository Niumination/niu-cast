package sq;

import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSharingStarted.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharingStarted.kt\nkotlinx/coroutines/flow/StartedWhileSubscribed\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,209:1\n1#2:210\n*E\n"})
public final class t0 implements p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15349c;

    @xm.f(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {178, 180, 182, 183, 185}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
    public static final class a extends xm.o implements jn.q<j<? super n0>, Integer, um.d<? super l2>, Object> {
        /* synthetic */ int I$0;
        private /* synthetic */ Object L$0;
        int label;

        public a(um.d<? super a> dVar) {
            super(3, dVar);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ Object invoke(j<? super n0> jVar, Integer num, um.d<? super l2> dVar) {
            return invoke(jVar, num.intValue(), dVar);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x006a  */
        /* JADX WARN: Code duplicated, block: B:28:0x0076 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x0085 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x0093 A[RETURN] */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            j jVar;
            n0 n0Var;
            long j10;
            n0 n0Var2;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        jVar = (j) this.L$0;
                        d1.n(obj);
                        if (t0.this.f15349c > 0) {
                            n0Var = n0.STOP;
                            this.L$0 = jVar;
                            this.label = 3;
                            if (jVar.emit(n0Var, this) == aVar) {
                                return aVar;
                            }
                            j10 = t0.this.f15349c;
                            this.L$0 = jVar;
                            this.label = 4;
                            if (nq.d1.b(j10, this) == aVar) {
                                return aVar;
                            }
                        }
                    } else if (i10 == 3) {
                        jVar = (j) this.L$0;
                        d1.n(obj);
                        j10 = t0.this.f15349c;
                        this.L$0 = jVar;
                        this.label = 4;
                        if (nq.d1.b(j10, this) == aVar) {
                            return aVar;
                        }
                    } else if (i10 == 4) {
                        jVar = (j) this.L$0;
                        d1.n(obj);
                    } else if (i10 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    n0Var2 = n0.STOP_AND_RESET_REPLAY_CACHE;
                    this.L$0 = null;
                    this.label = 5;
                    if (jVar.emit(n0Var2, this) == aVar) {
                        return aVar;
                    }
                }
                d1.n(obj);
            } else {
                d1.n(obj);
                jVar = (j) this.L$0;
                if (this.I$0 > 0) {
                    n0 n0Var3 = n0.START;
                    this.label = 1;
                    if (jVar.emit(n0Var3, this) == aVar) {
                        return aVar;
                    }
                } else {
                    long j11 = t0.this.f15348b;
                    this.L$0 = jVar;
                    this.label = 2;
                    if (nq.d1.b(j11, this) == aVar) {
                        return aVar;
                    }
                    if (t0.this.f15349c > 0) {
                        n0Var = n0.STOP;
                        this.L$0 = jVar;
                        this.label = 3;
                        if (jVar.emit(n0Var, this) == aVar) {
                            return aVar;
                        }
                        j10 = t0.this.f15349c;
                        this.L$0 = jVar;
                        this.label = 4;
                        if (nq.d1.b(j10, this) == aVar) {
                            return aVar;
                        }
                    }
                    n0Var2 = n0.STOP_AND_RESET_REPLAY_CACHE;
                    this.L$0 = null;
                    this.label = 5;
                    if (jVar.emit(n0Var2, this) == aVar) {
                        return aVar;
                    }
                }
            }
            return l2.f10208a;
        }

        @os.m
        public final Object invoke(@os.l j<? super n0> jVar, int i10, @os.m um.d<? super l2> dVar) {
            a aVar = t0.this.new a(dVar);
            aVar.L$0 = jVar;
            aVar.I$0 = i10;
            return aVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.p<n0, um.d<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public b(um.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return Boolean.valueOf(((n0) this.L$0) != n0.START);
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l n0 n0Var, @os.m um.d<? super Boolean> dVar) {
            return ((b) create(n0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public t0(long j10, long j11) {
        this.f15348b = j10;
        this.f15349c = j11;
        if (j10 < 0) {
            throw new IllegalArgumentException(j1.g.a("stopTimeout(", j10, " ms) cannot be negative").toString());
        }
        if (j11 < 0) {
            throw new IllegalArgumentException(j1.g.a("replayExpiration(", j11, " ms) cannot be negative").toString());
        }
    }

    @Override // sq.p0
    @os.l
    public i<n0> a(@os.l u0<Integer> u0Var) {
        return s.a(new v.e(w.n(u0Var, new a(null)), new b(null)));
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof t0) {
            t0 t0Var = (t0) obj;
            if (this.f15348b == t0Var.f15348b && this.f15349c == t0Var.f15349c) {
                return true;
            }
        }
        return false;
    }

    @is.a
    public int hashCode() {
        return Long.hashCode(this.f15349c) + (Long.hashCode(this.f15348b) * 31);
    }

    @os.l
    public String toString() {
        om.b bVar = new om.b(2);
        if (this.f15348b > 0) {
            bVar.add("stopTimeout=" + this.f15348b + "ms");
        }
        if (this.f15349c < Long.MAX_VALUE) {
            bVar.add("replayExpiration=" + this.f15349c + "ms");
        }
        return l.a.a(new StringBuilder("SharingStarted.WhileSubscribed("), nm.h0.m3(nm.x.a(bVar), null, null, null, 0, null, null, 63, null), ')');
    }
}
