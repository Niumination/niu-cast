package sq;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lm.l2;
import nq.a2;
import nq.b2;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f15282a = "kotlinx.coroutines.flow.defaultConcurrency";

    @os.m
    public static final <T> Object A(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.d<? super l2> dVar) {
        return n.f(iVar, pVar, dVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @lm.a1(expression = "flatMapConcat(mapper)", imports = {}))
    @os.l
    public static final <T, R> i<R> A0(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super i<? extends R>>, ? extends Object> pVar) {
        return y.l(iVar, pVar);
    }

    @os.l
    public static final <T> i<T> A1(@os.l i<? extends T> iVar, @os.l jn.q<? super T, ? super T, ? super um.d<? super T>, ? extends Object> qVar) {
        return new b0.k(iVar, qVar);
    }

    @os.m
    public static final <T> Object B(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar, @os.l um.d<? super l2> dVar) {
        return v.b(iVar, pVar, dVar);
    }

    @a2
    @os.l
    public static final <T, R> i<R> B0(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super i<? extends R>>, ? extends Object> pVar) {
        return w.a(iVar, pVar);
    }

    @b2
    @os.l
    public static final <T> i<T> B1(@os.l i<? extends T> iVar, long j10) {
        return r.h(iVar, j10);
    }

    @a2
    @os.l
    public static final <T, R> i<R> C0(@os.l i<? extends T> iVar, @lm.b @os.l jn.p<? super T, ? super um.d<? super i<? extends R>>, ? extends Object> pVar) {
        return w.b(iVar, pVar);
    }

    @b2
    @os.l
    public static final <T> i<T> C1(@os.l i<? extends T> iVar, long j10) {
        return r.i(iVar, j10);
    }

    @os.l
    public static final <T1, T2, R> i<R> D(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar) {
        return new c0.d(iVar, iVar2, qVar);
    }

    @a2
    @os.l
    public static final <T, R> i<R> D0(@os.l i<? extends T> iVar, int i10, @os.l jn.p<? super T, ? super um.d<? super i<? extends R>>, ? extends Object> pVar) {
        return w.c(iVar, i10, pVar);
    }

    @os.l
    public static final <T, R> i<R> D1(@os.l i<? extends T> iVar, R r10, @lm.b @os.l jn.q<? super R, ? super T, ? super um.d<? super R>, ? extends Object> qVar) {
        return new b0.i(r10, iVar, qVar);
    }

    @os.l
    public static final <T1, T2, T3, R> i<R> E(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @lm.b @os.l jn.r<? super T1, ? super T2, ? super T3, ? super um.d<? super R>, ? extends Object> rVar) {
        return c0.d(iVar, iVar2, iVar3, rVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @lm.a1(expression = "scan(initial, operation)", imports = {}))
    @os.l
    public static final <T, R> i<R> E1(@os.l i<? extends T> iVar, R r10, @lm.b @os.l jn.q<? super R, ? super T, ? super um.d<? super R>, ? extends Object> qVar) {
        return y.B(iVar, r10, qVar);
    }

    @os.l
    public static final <T1, T2, T3, T4, R> i<R> F(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @os.l i<? extends T4> iVar4, @os.l jn.s<? super T1, ? super T2, ? super T3, ? super T4, ? super um.d<? super R>, ? extends Object> sVar) {
        return c0.e(iVar, iVar2, iVar3, iVar4, sVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @lm.a1(expression = "flattenConcat()", imports = {}))
    @os.l
    public static final <T> i<T> F0(@os.l i<? extends i<? extends T>> iVar) {
        return y.m(iVar);
    }

    @lm.k(level = lm.m.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @lm.a1(expression = "runningReduce(operation)", imports = {}))
    @os.l
    public static final <T> i<T> F1(@os.l i<? extends T> iVar, @os.l jn.q<? super T, ? super T, ? super um.d<? super T>, ? extends Object> qVar) {
        return new b0.k(iVar, qVar);
    }

    @os.l
    public static final <T1, T2, T3, T4, T5, R> i<R> G(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @os.l i<? extends T4> iVar4, @os.l i<? extends T5> iVar5, @os.l jn.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super um.d<? super R>, ? extends Object> tVar) {
        return c0.f(iVar, iVar2, iVar3, iVar4, iVar5, tVar);
    }

    @a2
    @os.l
    public static final <T> i<T> G0(@os.l i<? extends i<? extends T>> iVar) {
        return w.e(iVar);
    }

    @os.l
    public static final <T> j0<T> G1(@os.l i<? extends T> iVar, @os.l nq.s0 s0Var, @os.l p0 p0Var, int i10) {
        return a0.g(iVar, s0Var, p0Var, i10);
    }

    @a2
    @os.l
    public static final <T> i<T> H0(@os.l i<? extends i<? extends T>> iVar, int i10) {
        return w.f(iVar, i10);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @lm.a1(expression = "this.combine(other, transform)", imports = {}))
    @os.l
    public static final <T1, T2, R> i<R> I(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar) {
        return new c0.d(iVar, iVar2, qVar);
    }

    @os.m
    public static final <T> Object I1(@os.l i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        return z.j(iVar, dVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @lm.a1(expression = "combine(this, other, other2, transform)", imports = {}))
    @os.l
    public static final <T1, T2, T3, R> i<R> J(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @os.l jn.r<? super T1, ? super T2, ? super T3, ? super um.d<? super R>, ? extends Object> rVar) {
        return c0.d(iVar, iVar2, iVar3, rVar);
    }

    @os.l
    public static final <T> i<T> J0(@lm.b @os.l jn.p<? super j<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new i0(pVar);
    }

    @os.m
    public static final <T> Object J1(@os.l i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        return z.k(iVar, dVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @lm.a1(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @os.l
    public static final <T1, T2, T3, T4, R> i<R> K(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @os.l i<? extends T4> iVar4, @os.l jn.s<? super T1, ? super T2, ? super T3, ? super T4, ? super um.d<? super R>, ? extends Object> sVar) {
        return c0.e(iVar, iVar2, iVar3, iVar4, sVar);
    }

    @in.i(name = "flowCombine")
    @os.l
    public static final <T1, T2, R> i<R> K0(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar) {
        return new c0.d(iVar, iVar2, qVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @lm.a1(expression = "drop(count)", imports = {}))
    @os.l
    public static final <T> i<T> K1(@os.l i<? extends T> iVar, int i10) {
        return y.D(iVar, i10);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @lm.a1(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @os.l
    public static final <T1, T2, T3, T4, T5, R> i<R> L(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @os.l i<? extends T4> iVar4, @os.l i<? extends T5> iVar5, @os.l jn.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super um.d<? super R>, ? extends Object> tVar) {
        return c0.f(iVar, iVar2, iVar3, iVar4, iVar5, tVar);
    }

    @in.i(name = "flowCombineTransform")
    @os.l
    public static final <T1, T2, R> i<R> L0(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @lm.b @os.l jn.r<? super j<? super R>, ? super T1, ? super T2, ? super um.d<? super l2>, ? extends Object> rVar) {
        return c0.q(iVar, iVar2, rVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @lm.a1(expression = "onStart { emit(value) }", imports = {}))
    @os.l
    public static final <T> i<T> L1(@os.l i<? extends T> iVar, T t10) {
        return y.E(iVar, t10);
    }

    @os.l
    public static final <T> i<T> M0(T t10) {
        return new l.C0388l(t10);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @lm.a1(expression = "onStart { emitAll(other) }", imports = {}))
    @os.l
    public static final <T> i<T> M1(@os.l i<? extends T> iVar, @os.l i<? extends T> iVar2) {
        return y.F(iVar, iVar2);
    }

    @os.l
    public static final <T1, T2, R> i<R> N(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @lm.b @os.l jn.r<? super j<? super R>, ? super T1, ? super T2, ? super um.d<? super l2>, ? extends Object> rVar) {
        return c0.i(iVar, iVar2, rVar);
    }

    @os.l
    public static final <T> i<T> N0(@os.l T... tArr) {
        return new l.k(tArr);
    }

    @os.m
    public static final <T> Object N1(@os.l i<? extends T> iVar, @os.l nq.s0 s0Var, @os.l um.d<? super u0<? extends T>> dVar) {
        return a0.i(iVar, s0Var, dVar);
    }

    @os.l
    public static final <T1, T2, T3, R> i<R> O(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @lm.b @os.l jn.s<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super um.d<? super l2>, ? extends Object> sVar) {
        return c0.j(iVar, iVar2, iVar3, sVar);
    }

    @os.l
    public static final <T> i<T> O0(@os.l i<? extends T> iVar, @os.l um.g gVar) {
        return p.h(iVar, gVar);
    }

    @os.l
    public static final <T> u0<T> O1(@os.l i<? extends T> iVar, @os.l nq.s0 s0Var, @os.l p0 p0Var, T t10) {
        return a0.j(iVar, s0Var, p0Var, t10);
    }

    @os.l
    public static final <T1, T2, T3, T4, R> i<R> P(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @os.l i<? extends T4> iVar4, @lm.b @os.l jn.t<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super um.d<? super l2>, ? extends Object> tVar) {
        return c0.k(iVar, iVar2, iVar3, iVar4, tVar);
    }

    @os.m
    public static final <T, R> Object P0(@os.l i<? extends T> iVar, R r10, @os.l jn.q<? super R, ? super T, ? super um.d<? super R>, ? extends Object> qVar, @os.l um.d<? super R> dVar) {
        return z.e(iVar, r10, qVar, dVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void P1(@os.l i<? extends T> iVar) {
        y.G(iVar);
    }

    @os.l
    public static final <T1, T2, T3, T4, T5, R> i<R> Q(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @os.l i<? extends T4> iVar4, @os.l i<? extends T5> iVar5, @lm.b @os.l jn.u<? super j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super um.d<? super l2>, ? extends Object> uVar) {
        return c0.l(iVar, iVar2, iVar3, iVar4, iVar5, uVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @lm.a1(expression = "collect(action)", imports = {}))
    public static final <T> void Q0(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar) {
        y.n(iVar, pVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void Q1(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar) {
        y.H(iVar, pVar);
    }

    public static final int R0() {
        return w.h();
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void R1(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar, @os.l jn.p<? super Throwable, ? super um.d<? super l2>, ? extends Object> pVar2) {
        y.I(iVar, pVar, pVar2);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @lm.a1(expression = "let(transformer)", imports = {}))
    @os.l
    public static final <T, R> i<R> S(@os.l i<? extends T> iVar, @os.l jn.l<? super i<? extends T>, ? extends i<? extends R>> lVar) {
        return y.f(iVar, lVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'flowOn' instead")
    @os.l
    public static final <T> i<T> S1(@os.l i<? extends T> iVar, @os.l um.g gVar) {
        return y.J(iVar, gVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @lm.a1(expression = "flatMapConcat(mapper)", imports = {}))
    @os.l
    public static final <T, R> i<R> T(@os.l i<? extends T> iVar, @os.l jn.l<? super T, ? extends i<? extends R>> lVar) {
        return y.g(iVar, lVar);
    }

    @os.m
    public static final <T> Object T0(@os.l i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        return z.g(iVar, dVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @lm.a1(expression = "this.flatMapLatest(transform)", imports = {}))
    @os.l
    public static final <T, R> i<R> T1(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super i<? extends R>>, ? extends Object> pVar) {
        return y.K(iVar, pVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @lm.a1(expression = "onCompletion { emit(value) }", imports = {}))
    @os.l
    public static final <T> i<T> U(@os.l i<? extends T> iVar, T t10) {
        return y.h(iVar, t10);
    }

    @os.m
    public static final <T> Object U0(@os.l i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        return z.h(iVar, dVar);
    }

    @os.l
    public static final <T> i<T> U1(@os.l i<? extends T> iVar, int i10) {
        return v.g(iVar, i10);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @lm.a1(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    @os.l
    public static final <T> i<T> V(@os.l i<? extends T> iVar, @os.l i<? extends T> iVar2) {
        return y.i(iVar, iVar2);
    }

    @os.l
    public static final <T> nq.l2 V0(@os.l i<? extends T> iVar, @os.l nq.s0 s0Var) {
        return n.h(iVar, s0Var);
    }

    @os.l
    public static final <T> i<T> V1(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        return new v.j(iVar, pVar);
    }

    @os.l
    public static final <T> i<T> W(@os.l i<? extends T> iVar) {
        return p.g(iVar);
    }

    @os.l
    public static final <T, R> i<R> W0(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super R>, ? extends Object> pVar) {
        return new b0.f(iVar, pVar);
    }

    @b2
    @os.l
    public static final <T> i<T> W1(@os.l i<? extends T> iVar, long j10) {
        return r.k(iVar, j10);
    }

    @os.l
    public static final <T> i<T> X(@os.l pq.f0<? extends T> f0Var) {
        return m.c(f0Var);
    }

    @a2
    @os.l
    public static final <T, R> i<R> X0(@os.l i<? extends T> iVar, @lm.b @os.l jn.p<? super T, ? super um.d<? super R>, ? extends Object> pVar) {
        return w.k(iVar, pVar);
    }

    @os.m
    public static final <T, C extends Collection<? super T>> Object X1(@os.l i<? extends T> iVar, @os.l C c10, @os.l um.d<? super C> dVar) {
        return o.a(iVar, c10, dVar);
    }

    @os.m
    public static final <T> Object Y(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar, @os.l um.d<? super Integer> dVar) {
        return q.a(iVar, pVar, dVar);
    }

    @os.l
    public static final <T, R> i<R> Y0(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super R>, ? extends Object> pVar) {
        return new b0.g(iVar, pVar);
    }

    @os.m
    public static final <T> Object Y1(@os.l i<? extends T> iVar, @os.l List<T> list, @os.l um.d<? super List<? extends T>> dVar) {
        return o.a(iVar, list, dVar);
    }

    @os.m
    public static final <T> Object Z(@os.l i<? extends T> iVar, @os.l um.d<? super Integer> dVar) {
        return q.b(iVar, dVar);
    }

    @os.l
    public static final <T> i<T> Z0(@os.l Iterable<? extends i<? extends T>> iterable) {
        return w.l(iterable);
    }

    @os.l
    public static final <T> i<T> a(@os.l gq.m<? extends T> mVar) {
        return new l.f(mVar);
    }

    @b2
    @os.l
    public static final <T> i<T> a0(@os.l i<? extends T> iVar, long j10) {
        return r.a(iVar, j10);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @lm.a1(expression = "flattenConcat()", imports = {}))
    @os.l
    public static final <T> i<T> a1(@os.l i<? extends i<? extends T>> iVar) {
        return y.o(iVar);
    }

    @os.m
    public static final <T> Object a2(@os.l i<? extends T> iVar, @os.l Set<T> set, @os.l um.d<? super Set<? extends T>> dVar) {
        return o.a(iVar, set, dVar);
    }

    @os.l
    public static final <T> i<T> b(@os.l Iterable<? extends T> iterable) {
        return new l.d(iterable);
    }

    @lm.s0
    @b2
    @os.l
    public static final <T> i<T> b0(@os.l i<? extends T> iVar, @os.l jn.l<? super T, Long> lVar) {
        return r.e(iVar, lVar);
    }

    @os.l
    public static final <T> i<T> b1(@os.l i<? extends T>... iVarArr) {
        return w.m(iVarArr);
    }

    @os.l
    public static final <T> i<T> c(@os.l Iterator<? extends T> it) {
        return new l.e(it);
    }

    @b2
    @os.l
    public static final <T> i<T> c0(@os.l i<? extends T> iVar, long j10) {
        return r.c(iVar, j10);
    }

    @os.l
    public static final Void c1() {
        return y.p();
    }

    @os.l
    public static final <T, R> i<R> c2(@os.l i<? extends T> iVar, @lm.b @os.l jn.q<? super j<? super R>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar) {
        return t.g(iVar, qVar);
    }

    @os.l
    public static final <T> i<T> d(@os.l jn.a<? extends T> aVar) {
        return new l.b(aVar);
    }

    @lm.s0
    @in.i(name = "debounceDuration")
    @b2
    @os.l
    public static final <T> i<T> d0(@os.l i<? extends T> iVar, @os.l jn.l<? super T, lq.e> lVar) {
        return r.d(iVar, lVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Collect flow in the desired context instead")
    @os.l
    public static final <T> i<T> d1(@os.l i<? extends T> iVar, @os.l um.g gVar) {
        return y.q(iVar, gVar);
    }

    @a2
    @os.l
    public static final <T, R> i<R> d2(@os.l i<? extends T> iVar, @lm.b @os.l jn.q<? super j<? super R>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar) {
        return w.n(iVar, qVar);
    }

    @os.l
    public static final <T> i<T> e(@os.l jn.l<? super um.d<? super T>, ? extends Object> lVar) {
        return new l.c(lVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @lm.a1(expression = "onEach { delay(timeMillis) }", imports = {}))
    @os.l
    public static final <T> i<T> e0(@os.l i<? extends T> iVar, long j10) {
        return y.j(iVar, j10);
    }

    @os.l
    public static final <T> i<T> e1(@os.l i<? extends T> iVar, @os.l jn.q<? super j<? super T>, ? super Throwable, ? super um.d<? super l2>, ? extends Object> qVar) {
        return new t.b(iVar, qVar);
    }

    @os.l
    public static final <T, R> i<R> e2(@os.l i<? extends T> iVar, @lm.b @os.l jn.q<? super j<? super R>, ? super T, ? super um.d<? super Boolean>, ? extends Object> qVar) {
        return v.i(iVar, qVar);
    }

    @lm.k(level = lm.m.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @os.l
    public static final <T> i<T> f(@os.l pq.d<T> dVar) {
        return new m.a(dVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @lm.a1(expression = "onStart { delay(timeMillis) }", imports = {}))
    @os.l
    public static final <T> i<T> f0(@os.l i<? extends T> iVar, long j10) {
        return y.k(iVar, j10);
    }

    @os.l
    public static final <T> i<T> f1(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new b0.h(iVar, pVar);
    }

    @lm.z0
    @os.l
    public static final <T, R> i<R> f2(@os.l i<? extends T> iVar, @lm.b @os.l jn.q<? super j<? super R>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar) {
        return new t.g(iVar, qVar);
    }

    @os.l
    public static final i<Integer> g(@os.l tn.l lVar) {
        return new l.j(lVar);
    }

    @os.l
    public static final <T> i<T> g0(@os.l i<? extends T> iVar) {
        return s.a(iVar);
    }

    @os.l
    public static final <T> i<T> g1(@os.l i<? extends T> iVar, @os.l jn.p<? super j<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new t.c(iVar, pVar);
    }

    @os.l
    public static final <T> i<nm.s0<T>> g2(@os.l i<? extends T> iVar) {
        return new b0.m(iVar);
    }

    @os.l
    public static final i<Long> h(@os.l tn.o oVar) {
        return new l.a(oVar);
    }

    @os.l
    public static final <T> i<T> h0(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super T, Boolean> pVar) {
        return s.b(iVar, pVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @lm.a1(expression = "catch { emitAll(fallback) }", imports = {}))
    @os.l
    public static final <T> i<T> h1(@os.l i<? extends T> iVar, @os.l i<? extends T> iVar2) {
        return y.r(iVar, iVar2);
    }

    @os.l
    public static final <T1, T2, R> i<R> h2(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar) {
        return new tq.m.b(iVar2, iVar, qVar);
    }

    @os.l
    public static final i<Integer> i(@os.l int[] iArr) {
        return new l.h(iArr);
    }

    @os.l
    public static final <T, K> i<T> i0(@os.l i<? extends T> iVar, @os.l jn.l<? super T, ? extends K> lVar) {
        return s.c(iVar, lVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @lm.a1(expression = "catch { emitAll(fallback) }", imports = {}))
    @os.l
    public static final <T> i<T> i1(@os.l i<? extends T> iVar, @os.l i<? extends T> iVar2) {
        return y.s(iVar, iVar2);
    }

    @os.l
    public static final i<Long> j(@os.l long[] jArr) {
        return new l.i(jArr);
    }

    @os.l
    public static final <T> i<T> j0(@os.l i<? extends T> iVar, int i10) {
        return v.d(iVar, i10);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @lm.a1(expression = "catch { emit(fallback) }", imports = {}))
    @os.l
    public static final <T> i<T> j1(@os.l i<? extends T> iVar, T t10) {
        return y.t(iVar, t10);
    }

    @os.l
    public static final <T> i<T> k(@os.l T[] tArr) {
        return new l.g(tArr);
    }

    @os.l
    public static final <T> i<T> k0(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        return new v.e(iVar, pVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @lm.a1(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @os.l
    public static final <T> i<T> k1(@os.l i<? extends T> iVar, T t10, @os.l jn.l<? super Throwable, Boolean> lVar) {
        return y.u(iVar, t10, lVar);
    }

    @os.l
    public static final <T> j0<T> l(@os.l e0<T> e0Var) {
        return a0.a(e0Var);
    }

    @os.m
    public static final <T> Object l0(@os.l j<? super T> jVar, @os.l pq.f0<? extends T> f0Var, @os.l um.d<? super l2> dVar) {
        return m.d(jVar, f0Var, dVar);
    }

    @os.l
    public static final <T> u0<T> m(@os.l f0<T> f0Var) {
        return a0.b(f0Var);
    }

    @os.m
    public static final <T> Object m0(@os.l j<? super T> jVar, @os.l i<? extends T> iVar, @os.l um.d<? super l2> dVar) {
        return n.g(jVar, iVar, dVar);
    }

    @os.l
    public static final <T> i<T> m1(@os.l i<? extends T> iVar, @os.l jn.p<? super j<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new t.e(pVar, iVar);
    }

    @os.l
    public static final <T> i<T> n0() {
        return h.f15278a;
    }

    @os.l
    public static final <T> j0<T> n1(@os.l j0<? extends T> j0Var, @os.l jn.p<? super j<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return new z0(j0Var, pVar);
    }

    @os.l
    public static final <T> i<T> o(@os.l i<? extends T> iVar, int i10, @os.l pq.i iVar2) {
        return p.b(iVar, i10, iVar2);
    }

    public static final void o0(@os.l j<?> jVar) {
        t.b(jVar);
    }

    @os.l
    public static final <T> pq.f0<T> o1(@os.l i<? extends T> iVar, @os.l nq.s0 s0Var) {
        return m.f(iVar, s0Var);
    }

    @os.l
    public static final <T> i<T> p0(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        return new b0.a(iVar, pVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @lm.a1(expression = "this.shareIn(scope, 0)", imports = {}))
    @os.l
    public static final <T> i<T> p1(@os.l i<? extends T> iVar) {
        return y.w(iVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @lm.a1(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @os.l
    public static final <T> i<T> q1(@os.l i<? extends T> iVar, int i10) {
        return y.x(iVar, i10);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @lm.a1(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @os.l
    public static final <T> i<T> r(@os.l i<? extends T> iVar) {
        return y.a(iVar);
    }

    @os.l
    public static final <R> i<R> r0(@os.l i<?> iVar, @os.l un.d<R> dVar) {
        return new b0.c(iVar, dVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Collect flow in the desired context instead")
    @os.l
    public static final <T> i<T> r1(@os.l i<? extends T> iVar, @os.l um.g gVar) {
        return y.y(iVar, gVar);
    }

    @os.l
    public static final <T> i<T> s(@lm.b @os.l jn.p<? super pq.d0<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return l.k(pVar);
    }

    @os.l
    public static final <T> i<T> s0(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        return new b0.d(iVar, pVar);
    }

    @os.l
    public static final <T> i<T> s1(@os.l pq.f0<? extends T> f0Var) {
        return m.g(f0Var);
    }

    @os.l
    public static final <T> i<T> t(@os.l i<? extends T> iVar) {
        return p.e(iVar);
    }

    @os.l
    public static final <T> i<T> t0(@os.l i<? extends T> iVar) {
        return new b0.e(iVar);
    }

    @os.m
    public static final <S, T extends S> Object t1(@os.l i<? extends T> iVar, @os.l jn.q<? super S, ? super T, ? super um.d<? super S>, ? extends Object> qVar, @os.l um.d<? super S> dVar) {
        return z.i(iVar, qVar, dVar);
    }

    @os.l
    public static final <T> i<T> u(@os.l i<? extends T> iVar, @os.l jn.q<? super j<? super T>, ? super Throwable, ? super um.d<? super l2>, ? extends Object> qVar) {
        return new u.a(iVar, qVar);
    }

    @os.m
    public static final <T> Object u0(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar, @os.l um.d<? super T> dVar) {
        return z.a(iVar, pVar, dVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @lm.a1(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @os.l
    public static final <T> i<T> u1(@os.l i<? extends T> iVar) {
        return y.z(iVar);
    }

    @os.m
    public static final <T> Object v(@os.l i<? extends T> iVar, @os.l j<? super T> jVar, @os.l um.d<? super Throwable> dVar) {
        return u.b(iVar, jVar, dVar);
    }

    @os.m
    public static final <T> Object v0(@os.l i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        return z.b(iVar, dVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @lm.a1(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @os.l
    public static final <T> i<T> v1(@os.l i<? extends T> iVar, int i10) {
        return y.A(iVar, i10);
    }

    @os.l
    public static final <T> i<T> w(@lm.b @os.l jn.p<? super pq.d0<? super T>, ? super um.d<? super l2>, ? extends Object> pVar) {
        return l.l(pVar);
    }

    @os.m
    public static final <T> Object w0(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super Boolean>, ? extends Object> pVar, @os.l um.d<? super T> dVar) {
        return z.c(iVar, pVar, dVar);
    }

    @os.l
    public static final <T> i<T> w1(@os.l i<? extends T> iVar, long j10, @os.l jn.p<? super Throwable, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        return u.e(iVar, j10, pVar);
    }

    @os.m
    public static final <T> Object x0(@os.l i<? extends T> iVar, @os.l um.d<? super T> dVar) {
        return z.d(iVar, dVar);
    }

    @os.m
    public static final Object y(@os.l i<?> iVar, @os.l um.d<? super l2> dVar) {
        return n.b(iVar, dVar);
    }

    @os.l
    public static final pq.f0<l2> y0(@os.l nq.s0 s0Var, long j10, long j11) {
        return r.f(s0Var, j10, j11);
    }

    @os.l
    public static final <T> i<T> y1(@os.l i<? extends T> iVar, @os.l jn.r<? super j<? super T>, ? super Throwable, ? super Long, ? super um.d<? super Boolean>, ? extends Object> rVar) {
        return new u.f(iVar, rVar);
    }

    @os.m
    public static final <T> Object z(@os.l i<? extends T> iVar, @os.l jn.q<? super Integer, ? super T, ? super um.d<? super l2>, ? extends Object> qVar, @os.l um.d<? super l2> dVar) {
        return n.d(iVar, qVar, dVar);
    }

    @os.l
    public static final <T, R> i<R> z1(@os.l i<? extends T> iVar, R r10, @lm.b @os.l jn.q<? super R, ? super T, ? super um.d<? super R>, ? extends Object> qVar) {
        return new b0.i(r10, iVar, qVar);
    }
}
