package sq;

import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nMigration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n1#1,496:1\n193#2:497\n*S KotlinDebug\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n*L\n435#1:497\n*E\n"})
public final /* synthetic */ class y {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayEach$1", f = "Migration.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, s = {})
    public static final class a<T> extends xm.o implements jn.p<T, um.d<? super l2>, Object> {
        final /* synthetic */ long $timeMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, um.d<? super a> dVar) {
            super(2, dVar);
            this.$timeMillis = j10;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new a(this.$timeMillis, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                long j10 = this.$timeMillis;
                this.label = 1;
                if (nq.d1.b(j10, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(T t10, @os.m um.d<? super l2> dVar) {
            return ((a) create(t10, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1", f = "Migration.kt", i = {}, l = {415}, m = "invokeSuspend", n = {}, s = {})
    public static final class b<T> extends xm.o implements jn.p<j<? super T>, um.d<? super l2>, Object> {
        final /* synthetic */ long $timeMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j10, um.d<? super b> dVar) {
            super(2, dVar);
            this.$timeMillis = j10;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new b(this.$timeMillis, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                long j10 = this.$timeMillis;
                this.label = 1;
                if (nq.d1.b(j10, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l j<? super T> jVar, @os.m um.d<? super l2> dVar) {
            return ((b) create(jVar, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class c extends kn.n0 implements jn.l<Throwable, Boolean> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l Throwable th2) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
    public static final class d<T> extends xm.o implements jn.q<j<? super T>, Throwable, um.d<? super l2>, Object> {
        final /* synthetic */ T $fallback;
        final /* synthetic */ jn.l<Throwable, Boolean> $predicate;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(jn.l<? super Throwable, Boolean> lVar, T t10, um.d<? super d> dVar) {
            super(3, dVar);
            this.$predicate = lVar;
            this.$fallback = t10;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws Throwable {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                j jVar = (j) this.L$0;
                Throwable th2 = (Throwable) this.L$1;
                if (!this.$predicate.invoke(th2).booleanValue()) {
                    throw th2;
                }
                T t10 = this.$fallback;
                this.L$0 = null;
                this.label = 1;
                if (jVar.emit(t10, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l j<? super T> jVar, @os.l Throwable th2, @os.m um.d<? super l2> dVar) {
            d dVar2 = new d(this.$predicate, this.$fallback, dVar);
            dVar2.L$0 = jVar;
            dVar2.L$1 = th2;
            return dVar2.invokeSuspend(l2.f10208a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @r1({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n*L\n1#1,218:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1", f = "Migration.kt", i = {}, l = {193, 193}, m = "invokeSuspend", n = {}, s = {})
    public static final class e<R, T> extends xm.o implements jn.q<j<? super R>, T, um.d<? super l2>, Object> {
        final /* synthetic */ jn.p $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(jn.p pVar, um.d dVar) {
            super(3, dVar);
            this.$transform = pVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            j jVar;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    jVar = (j) this.L$0;
                    d1.n(obj);
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }
            d1.n(obj);
            jVar = (j) this.L$0;
            Object obj2 = this.L$1;
            jn.p pVar = this.$transform;
            this.L$0 = jVar;
            this.label = 1;
            obj = pVar.invoke(obj2, this);
            if (obj == aVar) {
                return aVar;
            }
            this.L$0 = null;
            this.label = 2;
            if (n.g(jVar, (i) obj, this) == aVar) {
                return aVar;
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l j<? super R> jVar, T t10, @os.m um.d<? super l2> dVar) {
            e eVar = new e(this.$transform, dVar);
            eVar.L$0 = jVar;
            eVar.L$1 = t10;
            return eVar.invokeSuspend(l2.f10208a);
        }
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @lm.a1(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @os.l
    public static final <T> i<T> A(@os.l i<? extends T> iVar, int i10) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @lm.a1(expression = "scan(initial, operation)", imports = {}))
    @os.l
    public static final <T, R> i<R> B(@os.l i<? extends T> iVar, R r10, @lm.b @os.l jn.q<? super R, ? super T, ? super um.d<? super R>, ? extends Object> qVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @lm.a1(expression = "runningReduce(operation)", imports = {}))
    @os.l
    public static final <T> i<T> C(@os.l i<? extends T> iVar, @os.l jn.q<? super T, ? super T, ? super um.d<? super T>, ? extends Object> qVar) {
        return new b0.k(iVar, qVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @lm.a1(expression = "drop(count)", imports = {}))
    @os.l
    public static final <T> i<T> D(@os.l i<? extends T> iVar, int i10) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @lm.a1(expression = "onStart { emit(value) }", imports = {}))
    @os.l
    public static final <T> i<T> E(@os.l i<? extends T> iVar, T t10) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @lm.a1(expression = "onStart { emitAll(other) }", imports = {}))
    @os.l
    public static final <T> i<T> F(@os.l i<? extends T> iVar, @os.l i<? extends T> iVar2) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void G(@os.l i<? extends T> iVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void H(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void I(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar, @os.l jn.p<? super Throwable, ? super um.d<? super l2>, ? extends Object> pVar2) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'flowOn' instead")
    @os.l
    public static final <T> i<T> J(@os.l i<? extends T> iVar, @os.l um.g gVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @lm.a1(expression = "this.flatMapLatest(transform)", imports = {}))
    @os.l
    public static final <T, R> i<R> K(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super i<? extends R>>, ? extends Object> pVar) {
        return w.n(iVar, new e(pVar, null));
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @lm.a1(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @os.l
    public static final <T> i<T> a(@os.l i<? extends T> iVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @lm.a1(expression = "this.combine(other, transform)", imports = {}))
    @os.l
    public static final <T1, T2, R> i<R> b(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l jn.q<? super T1, ? super T2, ? super um.d<? super R>, ? extends Object> qVar) {
        return new c0.d(iVar, iVar2, qVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @lm.a1(expression = "combine(this, other, other2, transform)", imports = {}))
    @os.l
    public static final <T1, T2, T3, R> i<R> c(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @os.l jn.r<? super T1, ? super T2, ? super T3, ? super um.d<? super R>, ? extends Object> rVar) {
        return c0.d(iVar, iVar2, iVar3, rVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @lm.a1(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @os.l
    public static final <T1, T2, T3, T4, R> i<R> d(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @os.l i<? extends T4> iVar4, @os.l jn.s<? super T1, ? super T2, ? super T3, ? super T4, ? super um.d<? super R>, ? extends Object> sVar) {
        return c0.e(iVar, iVar2, iVar3, iVar4, sVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @lm.a1(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @os.l
    public static final <T1, T2, T3, T4, T5, R> i<R> e(@os.l i<? extends T1> iVar, @os.l i<? extends T2> iVar2, @os.l i<? extends T3> iVar3, @os.l i<? extends T4> iVar4, @os.l i<? extends T5> iVar5, @os.l jn.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super um.d<? super R>, ? extends Object> tVar) {
        return c0.f(iVar, iVar2, iVar3, iVar4, iVar5, tVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @lm.a1(expression = "let(transformer)", imports = {}))
    @os.l
    public static final <T, R> i<R> f(@os.l i<? extends T> iVar, @os.l jn.l<? super i<? extends T>, ? extends i<? extends R>> lVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @lm.a1(expression = "flatMapConcat(mapper)", imports = {}))
    @os.l
    public static final <T, R> i<R> g(@os.l i<? extends T> iVar, @os.l jn.l<? super T, ? extends i<? extends R>> lVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @lm.a1(expression = "onCompletion { emit(value) }", imports = {}))
    @os.l
    public static final <T> i<T> h(@os.l i<? extends T> iVar, T t10) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @lm.a1(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    @os.l
    public static final <T> i<T> i(@os.l i<? extends T> iVar, @os.l i<? extends T> iVar2) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @lm.a1(expression = "onEach { delay(timeMillis) }", imports = {}))
    @os.l
    public static final <T> i<T> j(@os.l i<? extends T> iVar, long j10) {
        return new b0.h(iVar, new a(j10, null));
    }

    @lm.k(level = lm.m.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @lm.a1(expression = "onStart { delay(timeMillis) }", imports = {}))
    @os.l
    public static final <T> i<T> k(@os.l i<? extends T> iVar, long j10) {
        return new t.e(new b(j10, null), iVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @lm.a1(expression = "flatMapConcat(mapper)", imports = {}))
    @os.l
    public static final <T, R> i<R> l(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super i<? extends R>>, ? extends Object> pVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @lm.a1(expression = "flattenConcat()", imports = {}))
    @os.l
    public static final <T> i<T> m(@os.l i<? extends i<? extends T>> iVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @lm.a1(expression = "collect(action)", imports = {}))
    public static final <T> void n(@os.l i<? extends T> iVar, @os.l jn.p<? super T, ? super um.d<? super l2>, ? extends Object> pVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @lm.a1(expression = "flattenConcat()", imports = {}))
    @os.l
    public static final <T> i<T> o(@os.l i<? extends i<? extends T>> iVar) {
        throw x.a();
    }

    @os.l
    public static final Void p() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @lm.k(level = lm.m.ERROR, message = "Collect flow in the desired context instead")
    @os.l
    public static final <T> i<T> q(@os.l i<? extends T> iVar, @os.l um.g gVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @lm.a1(expression = "catch { emitAll(fallback) }", imports = {}))
    @os.l
    public static final <T> i<T> r(@os.l i<? extends T> iVar, @os.l i<? extends T> iVar2) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @lm.a1(expression = "catch { emitAll(fallback) }", imports = {}))
    @os.l
    public static final <T> i<T> s(@os.l i<? extends T> iVar, @os.l i<? extends T> iVar2) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @lm.a1(expression = "catch { emit(fallback) }", imports = {}))
    @os.l
    public static final <T> i<T> t(@os.l i<? extends T> iVar, T t10) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @lm.a1(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @os.l
    public static final <T> i<T> u(@os.l i<? extends T> iVar, T t10, @os.l jn.l<? super Throwable, Boolean> lVar) {
        return new u.a(iVar, new d(lVar, t10, null));
    }

    public static i v(i iVar, Object obj, jn.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = c.INSTANCE;
        }
        return u(iVar, obj, lVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @lm.a1(expression = "this.shareIn(scope, 0)", imports = {}))
    @os.l
    public static final <T> i<T> w(@os.l i<? extends T> iVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @lm.a1(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @os.l
    public static final <T> i<T> x(@os.l i<? extends T> iVar, int i10) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Collect flow in the desired context instead")
    @os.l
    public static final <T> i<T> y(@os.l i<? extends T> iVar, @os.l um.g gVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @lm.a1(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @os.l
    public static final <T> i<T> z(@os.l i<? extends T> iVar) {
        throw x.a();
    }
}
