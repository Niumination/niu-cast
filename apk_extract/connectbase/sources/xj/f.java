package xj;

import jn.p;
import kn.k1;
import kn.l0;
import kn.r1;
import lm.d1;
import lm.l2;
import nq.a1;
import nq.r2;
import nq.s0;
import os.l;
import os.m;
import sq.i0;
import sq.z;
import vj.y2;
import vj.z2;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nHelpers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Helpers.kt\nio/grpc/kotlin/HelpersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,87:1\n1#2:88\n*E\n"})
public final class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @xm.f(c = "io.grpc.kotlin.HelpersKt$doneValue$2", f = "Helpers.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class a<T> extends o implements p<s0, um.d<? super T>, Object> {
        final /* synthetic */ a1<T> $this_doneValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(a1<? extends T> a1Var, um.d<? super a> dVar) {
            super(2, dVar);
            this.$this_doneValue = a1Var;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new a(this.$this_doneValue, dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                a1<T> a1Var = this.$this_doneValue;
                this.label = 1;
                obj = a1Var.O0(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return obj;
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super T> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @xm.f(c = "io.grpc.kotlin.HelpersKt$singleOrStatusFlow$1", f = "Helpers.kt", i = {0}, l = {62}, m = "invokeSuspend", n = {"found"}, s = {"L$0"})
    public static final class b<T> extends o implements p<sq.j<? super T>, um.d<? super l2>, Object> {
        final /* synthetic */ Object $descriptor;
        final /* synthetic */ String $expected;
        final /* synthetic */ sq.i<T> $this_singleOrStatusFlow;
        private /* synthetic */ Object L$0;
        int label;

        public static final class a<T> implements sq.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k1.a f20256a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ sq.j<T> f20257b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f20258c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Object f20259d;

            /* JADX WARN: Multi-variable type inference failed */
            public a(k1.a aVar, sq.j<? super T> jVar, String str, Object obj) {
                this.f20256a = aVar;
                this.f20257b = jVar;
                this.f20258c = str;
                this.f20259d = obj;
            }

            @Override // sq.j
            @m
            public final Object emit(T t10, @l um.d<? super l2> dVar) throws z2 {
                k1.a aVar = this.f20256a;
                if (!aVar.element) {
                    aVar.element = true;
                    Object objEmit = this.f20257b.emit(t10, dVar);
                    return objEmit == wm.a.COROUTINE_SUSPENDED ? objEmit : l2.f10208a;
                }
                throw new z2(y2.f17562s.u("Expected one " + this.f20258c + " for " + this.f20259d + " but received two"));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(sq.i<? extends T> iVar, String str, Object obj, um.d<? super b> dVar) {
            super(2, dVar);
            this.$this_singleOrStatusFlow = iVar;
            this.$expected = str;
            this.$descriptor = obj;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            b bVar = new b(this.$this_singleOrStatusFlow, this.$expected, this.$descriptor, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) throws z2 {
            k1.a aVar;
            wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                sq.j jVar = (sq.j) this.L$0;
                k1.a aVar3 = new k1.a();
                sq.i<T> iVar = this.$this_singleOrStatusFlow;
                a aVar4 = new a(aVar3, jVar, this.$expected, this.$descriptor);
                this.L$0 = aVar3;
                this.label = 1;
                if (iVar.a(aVar4, this) == aVar2) {
                    return aVar2;
                }
                aVar = aVar3;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (k1.a) this.L$0;
                d1.n(obj);
            }
            if (aVar.element) {
                return l2.f10208a;
            }
            throw new z2(y2.f17562s.u("Expected one " + this.$expected + " for " + this.$descriptor + " but received none"));
        }

        @Override // jn.p
        @m
        public final Object invoke(@l sq.j<? super T> jVar, @m um.d<? super l2> dVar) {
            return ((b) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @m
    public static final Object a(@l nq.l2 l2Var, @l String str, @m Exception exc, @l um.d<? super l2> dVar) {
        r2.e(l2Var, str, exc);
        Object objT = l2Var.t(dVar);
        return objT == wm.a.COROUTINE_SUSPENDED ? objT : l2.f10208a;
    }

    public static /* synthetic */ Object b(nq.l2 l2Var, String str, Exception exc, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            exc = null;
        }
        return a(l2Var, str, exc, dVar);
    }

    public static final <T> T c(@l a1<? extends T> a1Var) {
        l0.p(a1Var, "<this>");
        if (a1Var.isCompleted()) {
            return (T) nq.j.a(nq.k1.g(), new a(a1Var, null));
        }
        throw new IllegalStateException("doneValue should only be called on completed Deferred values");
    }

    @m
    public static final <T> Object d(@l sq.i<? extends T> iVar, @l String str, @l Object obj, @l um.d<? super T> dVar) {
        return z.j(e(iVar, str, obj), dVar);
    }

    @l
    public static final <T> sq.i<T> e(@l sq.i<? extends T> iVar, @l String str, @l Object obj) {
        l0.p(iVar, "<this>");
        l0.p(str, "expected");
        l0.p(obj, "descriptor");
        return new i0(new b(iVar, str, obj, null));
    }
}
