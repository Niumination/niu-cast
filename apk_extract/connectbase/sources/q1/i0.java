package q1;

import com.google.j2objc.annotations.RetainedWith;
import f1.p4;
import java.io.Closeable;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@o0
@t1.f("Use ClosingFuture.from(Futures.immediate*Future)")
@b1.d
public final class i0<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f13498d = Logger.getLogger(i0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<x> f13499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f13500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u0<V> f13501c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f13502a;

        public a(final z val$consumer) {
            this.f13502a = val$consumer;
        }

        @Override // java.lang.Runnable
        public void run() {
            i0.y(this.f13502a, i0.this);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13504a;

        static {
            int[] iArr = new int[x.values().length];
            f13504a = iArr;
            try {
                iArr[x.SUBSUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13504a[x.WILL_CREATE_VALUE_AND_CLOSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13504a[x.WILL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13504a[x.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13504a[x.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13504a[x.OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class c implements e1<Closeable> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f13506b;

        public c(final Executor val$closingExecutor) {
            this.f13506b = val$closingExecutor;
        }

        @Override // q1.e1
        public void a(Throwable t10) {
        }

        @Override // q1.e1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(@gm.a Closeable result) {
            i0.this.f13500b.closer.a(result, this.f13506b);
        }
    }

    public class d implements Callable<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f13507a;

        public d(final o val$callable) {
            this.f13507a = val$callable;
        }

        @Override // java.util.concurrent.Callable
        @c2
        public V call() throws Exception {
            return (V) this.f13507a.a(i0.this.f13500b.closer);
        }

        public String toString() {
            return this.f13507a.toString();
        }
    }

    public class e implements q1.w<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f13509a;

        public e(final l val$callable) {
            this.f13509a = val$callable;
        }

        @Override // q1.w
        public s1<V> call() throws Exception {
            n nVar = new n(null);
            try {
                i0<V> i0VarA = this.f13509a.a(nVar.closer);
                i0VarA.i(i0.this.f13500b);
                u0<V> u0Var = i0VarA.f13501c;
                i0.this.f13500b.add(nVar, n0.INSTANCE);
                return u0Var;
            } catch (Throwable th2) {
                i0.this.f13500b.add(nVar, n0.INSTANCE);
                throw th2;
            }
        }

        public String toString() {
            return this.f13509a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    public class f<U> implements q1.x<V, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f13511a;

        public f(final p val$function) {
            this.f13511a = val$function;
        }

        @Override // q1.x
        public s1<U> apply(V input) throws Exception {
            return i0.this.f13500b.applyClosingFunction(this.f13511a, input);
        }

        public String toString() {
            return this.f13511a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    public class g<U> implements q1.x<V, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f13513a;

        public g(final m val$function) {
            this.f13513a = val$function;
        }

        @Override // q1.x
        public s1<U> apply(V input) throws Exception {
            return i0.this.f13500b.applyAsyncClosingFunction(this.f13513a, input);
        }

        public String toString() {
            return this.f13513a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [U] */
    public class h<U> implements m<V, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q1.x f13515a;

        public h(final q1.x val$function) {
            this.f13515a = val$function;
        }

        @Override // q1.i0.m
        public i0<U> a(v closer, V input) throws Exception {
            return i0.w(this.f13515a.apply(input));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [W, X] */
    public class i<W, X> implements q1.x<X, W> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f13516a;

        public i(final p val$fallback) {
            this.f13516a = val$fallback;
        }

        /* JADX WARN: Incorrect types in method signature: (TX;)Lq1/s1<TW;>; */
        @Override // q1.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public s1 apply(Throwable exception) throws Exception {
            return i0.this.f13500b.applyClosingFunction(this.f13516a, exception);
        }

        public String toString() {
            return this.f13516a.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [W, X] */
    public class j<W, X> implements q1.x<X, W> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f13518a;

        public j(final m val$fallback) {
            this.f13518a = val$fallback;
        }

        /* JADX WARN: Incorrect types in method signature: (TX;)Lq1/s1<TW;>; */
        @Override // q1.x
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public s1 apply(Throwable exception) throws Exception {
            return i0.this.f13500b.applyAsyncClosingFunction(this.f13518a, exception);
        }

        public String toString() {
            return this.f13518a.toString();
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i0 i0Var = i0.this;
            x xVar = x.WILL_CLOSE;
            x xVar2 = x.CLOSING;
            i0Var.o(xVar, xVar2);
            i0.this.p();
            i0.this.o(xVar2, x.CLOSED);
        }
    }

    public interface l<V> {
        i0<V> a(v closer) throws Exception;
    }

    public interface m<T, U> {
        i0<U> a(v closer, @c2 T input) throws Exception;
    }

    public interface o<V> {
        @c2
        V a(v closer) throws Exception;
    }

    public interface p<T, U> {
        @c2
        U a(v closer, @c2 T input) throws Exception;
    }

    @t1.f("Use ClosingFuture.whenAllSucceed() or .whenAllComplete() instead.")
    public static class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f13521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f13522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f1.i3<i0<?>> f13523c;

        public class a implements Callable<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f13524a;

            public a(final d val$combiningCallable) {
                this.f13524a = val$combiningCallable;
            }

            @Override // java.util.concurrent.Callable
            @c2
            public V call() throws Exception {
                return (V) new w(q.this.f13523c).c(this.f13524a, q.this.f13521a);
            }

            public String toString() {
                return this.f13524a.toString();
            }
        }

        public class b implements q1.w<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f13526a;

            public b(final c val$combiningCallable) {
                this.f13526a = val$combiningCallable;
            }

            @Override // q1.w
            public s1<V> call() throws Exception {
                return new w(q.this.f13523c).d(this.f13526a, q.this.f13521a);
            }

            public String toString() {
                return this.f13526a.toString();
            }
        }

        public interface c<V> {
            i0<V> a(v closer, w peeker) throws Exception;
        }

        public interface d<V> {
            @c2
            V a(v closer, w peeker) throws Exception;
        }

        public /* synthetic */ q(boolean z10, Iterable iterable, c cVar) {
            this(z10, iterable);
        }

        public <V> i0<V> c(final d<V> combiningCallable, Executor executor) {
            i0<V> i0Var = new i0<>(e().a(new a(combiningCallable), executor));
            i0Var.f13500b.add(this.f13521a, n0.INSTANCE);
            return i0Var;
        }

        public <V> i0<V> d(final c<V> combiningCallable, Executor executor) {
            i0<V> i0Var = new i0<>(e().b(new b(combiningCallable), executor));
            i0Var.f13500b.add(this.f13521a, n0.INSTANCE);
            return i0Var;
        }

        public final h1.c<Object> e() {
            return this.f13522b ? h1.F(f()) : h1.D(f());
        }

        public final f1.i3<u0<?>> f() {
            return f1.p1.u(this.f13523c).L(new j0()).F();
        }

        public q(boolean allMustSucceed, Iterable<? extends i0<?>> inputs) {
            this.f13521a = new n(null);
            this.f13522b = allMustSucceed;
            this.f13523c = f1.i3.copyOf(inputs);
            Iterator<? extends i0<?>> it = inputs.iterator();
            while (it.hasNext()) {
                it.next().i(this.f13521a);
            }
        }
    }

    public static final class r<V1, V2> extends q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final i0<V1> f13528d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final i0<V2> f13529e;

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class a<U> implements q.d<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f13530a;

            public a(final d val$function) {
                this.f13530a = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // q1.i0.q.d
            @c2
            public U a(v vVar, w wVar) throws Exception {
                return (U) this.f13530a.a(vVar, wVar.e(r.this.f13528d), wVar.e(r.this.f13529e));
            }

            public String toString() {
                return this.f13530a.toString();
            }
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class b<U> implements q.c<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f13532a;

            public b(final c val$function) {
                this.f13532a = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // q1.i0.q.c
            public i0<U> a(v closer, w peeker) throws Exception {
                return this.f13532a.a(closer, peeker.e(r.this.f13528d), peeker.e(r.this.f13529e));
            }

            public String toString() {
                return this.f13532a.toString();
            }
        }

        public interface c<V1, V2, U> {
            i0<U> a(v closer, @c2 V1 value1, @c2 V2 value2) throws Exception;
        }

        public interface d<V1, V2, U> {
            @c2
            U a(v closer, @c2 V1 value1, @c2 V2 value2) throws Exception;
        }

        public /* synthetic */ r(i0 i0Var, i0 i0Var2, c cVar) {
            this(i0Var, i0Var2);
        }

        public <U> i0<U> j(d<V1, V2, U> dVar, Executor executor) {
            return c(new a(dVar), executor);
        }

        public <U> i0<U> k(c<V1, V2, U> cVar, Executor executor) {
            return d(new b(cVar), executor);
        }

        public r(i0<V1> future1, i0<V2> future2) {
            super(true, f1.i3.of((i0<V2>) future1, future2));
            this.f13528d = future1;
            this.f13529e = future2;
        }
    }

    public static final class s<V1, V2, V3> extends q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final i0<V1> f13534d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final i0<V2> f13535e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final i0<V3> f13536f;

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class a<U> implements q.d<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f13537a;

            public a(final d val$function) {
                this.f13537a = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // q1.i0.q.d
            @c2
            public U a(v vVar, w wVar) throws Exception {
                return (U) this.f13537a.a(vVar, wVar.e(s.this.f13534d), wVar.e(s.this.f13535e), wVar.e(s.this.f13536f));
            }

            public String toString() {
                return this.f13537a.toString();
            }
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class b<U> implements q.c<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f13539a;

            public b(final c val$function) {
                this.f13539a = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // q1.i0.q.c
            public i0<U> a(v closer, w peeker) throws Exception {
                return this.f13539a.a(closer, peeker.e(s.this.f13534d), peeker.e(s.this.f13535e), peeker.e(s.this.f13536f));
            }

            public String toString() {
                return this.f13539a.toString();
            }
        }

        public interface c<V1, V2, V3, U> {
            i0<U> a(v closer, @c2 V1 value1, @c2 V2 value2, @c2 V3 value3) throws Exception;
        }

        public interface d<V1, V2, V3, U> {
            @c2
            U a(v closer, @c2 V1 value1, @c2 V2 value2, @c2 V3 value3) throws Exception;
        }

        public /* synthetic */ s(i0 i0Var, i0 i0Var2, i0 i0Var3, c cVar) {
            this(i0Var, i0Var2, i0Var3);
        }

        public <U> i0<U> k(d<V1, V2, V3, U> dVar, Executor executor) {
            return c(new a(dVar), executor);
        }

        public <U> i0<U> l(c<V1, V2, V3, U> cVar, Executor executor) {
            return d(new b(cVar), executor);
        }

        public s(i0<V1> future1, i0<V2> future2, i0<V3> future3) {
            super(true, f1.i3.of((i0<V3>) future1, (i0<V3>) future2, future3));
            this.f13534d = future1;
            this.f13535e = future2;
            this.f13536f = future3;
        }
    }

    public static final class t<V1, V2, V3, V4> extends q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final i0<V1> f13541d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final i0<V2> f13542e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final i0<V3> f13543f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final i0<V4> f13544g;

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class a<U> implements q.d<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f13545a;

            public a(final d val$function) {
                this.f13545a = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // q1.i0.q.d
            @c2
            public U a(v vVar, w wVar) throws Exception {
                return (U) this.f13545a.a(vVar, wVar.e(t.this.f13541d), wVar.e(t.this.f13542e), wVar.e(t.this.f13543f), wVar.e(t.this.f13544g));
            }

            public String toString() {
                return this.f13545a.toString();
            }
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class b<U> implements q.c<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f13547a;

            public b(final c val$function) {
                this.f13547a = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // q1.i0.q.c
            public i0<U> a(v closer, w peeker) throws Exception {
                return this.f13547a.a(closer, peeker.e(t.this.f13541d), peeker.e(t.this.f13542e), peeker.e(t.this.f13543f), peeker.e(t.this.f13544g));
            }

            public String toString() {
                return this.f13547a.toString();
            }
        }

        public interface c<V1, V2, V3, V4, U> {
            i0<U> a(v closer, @c2 V1 value1, @c2 V2 value2, @c2 V3 value3, @c2 V4 value4) throws Exception;
        }

        public interface d<V1, V2, V3, V4, U> {
            @c2
            U a(v closer, @c2 V1 value1, @c2 V2 value2, @c2 V3 value3, @c2 V4 value4) throws Exception;
        }

        public /* synthetic */ t(i0 i0Var, i0 i0Var2, i0 i0Var3, i0 i0Var4, c cVar) {
            this(i0Var, i0Var2, i0Var3, i0Var4);
        }

        public <U> i0<U> l(d<V1, V2, V3, V4, U> dVar, Executor executor) {
            return c(new a(dVar), executor);
        }

        public <U> i0<U> m(c<V1, V2, V3, V4, U> cVar, Executor executor) {
            return d(new b(cVar), executor);
        }

        public t(i0<V1> future1, i0<V2> future2, i0<V3> future3, i0<V4> future4) {
            super(true, f1.i3.of((i0<V4>) future1, (i0<V4>) future2, (i0<V4>) future3, future4));
            this.f13541d = future1;
            this.f13542e = future2;
            this.f13543f = future3;
            this.f13544g = future4;
        }
    }

    public static final class u<V1, V2, V3, V4, V5> extends q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final i0<V1> f13549d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final i0<V2> f13550e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final i0<V3> f13551f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final i0<V4> f13552g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final i0<V5> f13553h;

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class a<U> implements q.d<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f13554a;

            public a(final d val$function) {
                this.f13554a = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // q1.i0.q.d
            @c2
            public U a(v vVar, w wVar) throws Exception {
                return (U) this.f13554a.a(vVar, wVar.e(u.this.f13549d), wVar.e(u.this.f13550e), wVar.e(u.this.f13551f), wVar.e(u.this.f13552g), wVar.e(u.this.f13553h));
            }

            public String toString() {
                return this.f13554a.toString();
            }
        }

        /* JADX INFO: Add missing generic type declarations: [U] */
        public class b<U> implements q.c<U> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f13556a;

            public b(final c val$function) {
                this.f13556a = val$function;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // q1.i0.q.c
            public i0<U> a(v closer, w peeker) throws Exception {
                return this.f13556a.a(closer, peeker.e(u.this.f13549d), peeker.e(u.this.f13550e), peeker.e(u.this.f13551f), peeker.e(u.this.f13552g), peeker.e(u.this.f13553h));
            }

            public String toString() {
                return this.f13556a.toString();
            }
        }

        public interface c<V1, V2, V3, V4, V5, U> {
            i0<U> a(v closer, @c2 V1 value1, @c2 V2 value2, @c2 V3 value3, @c2 V4 value4, @c2 V5 value5) throws Exception;
        }

        public interface d<V1, V2, V3, V4, V5, U> {
            @c2
            U a(v closer, @c2 V1 value1, @c2 V2 value2, @c2 V3 value3, @c2 V4 value4, @c2 V5 value5) throws Exception;
        }

        public /* synthetic */ u(i0 i0Var, i0 i0Var2, i0 i0Var3, i0 i0Var4, i0 i0Var5, c cVar) {
            this(i0Var, i0Var2, i0Var3, i0Var4, i0Var5);
        }

        public <U> i0<U> m(d<V1, V2, V3, V4, V5, U> dVar, Executor executor) {
            return c(new a(dVar), executor);
        }

        public <U> i0<U> n(c<V1, V2, V3, V4, V5, U> cVar, Executor executor) {
            return d(new b(cVar), executor);
        }

        public u(i0<V1> future1, i0<V2> future2, i0<V3> future3, i0<V4> future4, i0<V5> future5) {
            super(true, f1.i3.of((i0<V5>) future1, (i0<V5>) future2, (i0<V5>) future3, (i0<V5>) future4, future5));
            this.f13549d = future1;
            this.f13550e = future2;
            this.f13551f = future3;
            this.f13552g = future4;
            this.f13553h = future5;
        }
    }

    public static final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @RetainedWith
        public final n f13558a;

        public v(n list) {
            this.f13558a = list;
        }

        @t1.a
        @c2
        public <C extends Closeable> C a(@c2 C closeable, Executor closingExecutor) {
            closingExecutor.getClass();
            if (closeable != null) {
                this.f13558a.add(closeable, closingExecutor);
            }
            return closeable;
        }
    }

    public static final class w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f1.i3<i0<?>> f13559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f13560b;

        public /* synthetic */ w(f1.i3 i3Var, c cVar) {
            this(i3Var);
        }

        @c2
        public final <V> V c(q.d<V> combiner, n closeables) throws Exception {
            this.f13560b = true;
            n nVar = new n(null);
            try {
                return combiner.a(nVar.closer, this);
            } finally {
                closeables.add(nVar, n0.INSTANCE);
                this.f13560b = false;
            }
        }

        public final <V> u0<V> d(q.c<V> combiner, n closeables) throws Exception {
            this.f13560b = true;
            n nVar = new n(null);
            try {
                i0<V> i0VarA = combiner.a(nVar.closer, this);
                i0VarA.i(closeables);
                return i0VarA.f13501c;
            } finally {
                closeables.add(nVar, n0.INSTANCE);
                this.f13560b = false;
            }
        }

        @c2
        public final <D> D e(i0<D> i0Var) throws ExecutionException {
            c1.h0.g0(this.f13560b);
            c1.h0.d(this.f13559a.contains(i0Var));
            return (D) h1.j(i0Var.f13501c);
        }

        public w(f1.i3<i0<?>> futures) {
            futures.getClass();
            this.f13559a = futures;
        }
    }

    public enum x {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    public static final class y<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i0<? extends V> f13562a;

        public y(i0<? extends V> closingFuture) {
            closingFuture.getClass();
            this.f13562a = closingFuture;
        }

        public void a() {
            this.f13562a.p();
        }

        @c2
        public V b() throws ExecutionException {
            return (V) h1.j(this.f13562a.f13501c);
        }
    }

    public interface z<V> {
        void a(y<V> valueAndCloser);
    }

    public /* synthetic */ i0(s1 s1Var, c cVar) {
        this(s1Var);
    }

    public static <V> i0<V> A(o<V> callable, Executor executor) {
        return new i0<>(callable, executor);
    }

    public static <V> i0<V> B(l<V> callable, Executor executor) {
        return new i0<>(callable, executor);
    }

    public static q E(Iterable<? extends i0<?>> futures) {
        return new q(false, futures);
    }

    public static q F(i0<?> future1, i0<?>... moreFutures) {
        return E(new p4.e(future1, moreFutures));
    }

    public static <V1, V2> r<V1, V2> G(i0<V1> future1, i0<V2> future2) {
        return new r<>(future1, future2);
    }

    public static <V1, V2, V3> s<V1, V2, V3> H(i0<V1> future1, i0<V2> future2, i0<V3> future3) {
        return new s<>(future1, future2, future3);
    }

    public static <V1, V2, V3, V4> t<V1, V2, V3, V4> I(i0<V1> future1, i0<V2> future2, i0<V3> future3, i0<V4> future4) {
        return new t<>(future1, future2, future3, future4);
    }

    public static <V1, V2, V3, V4, V5> u<V1, V2, V3, V4, V5> J(i0<V1> future1, i0<V2> future2, i0<V3> future3, i0<V4> future4, i0<V5> future5) {
        return new u<>(future1, future2, future3, future4, future5);
    }

    public static q K(Iterable<? extends i0<?>> futures) {
        return new q(true, futures);
    }

    public static q L(i0<?> future1, i0<?> future2, i0<?> future3, i0<?> future4, i0<?> future5, i0<?> future6, i0<?>... moreFutures) {
        return K(f1.p1.C(future1, future2, future3, future4, future5, future6).e(moreFutures));
    }

    public static <V, U> m<V, U> N(final q1.x<V, U> function) {
        function.getClass();
        return new h(function);
    }

    public static void q(@gm.a final Closeable closeable, Executor executor) {
        if (closeable == null) {
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: q1.h0
                @Override // java.lang.Runnable
                public final void run() {
                    i0.x(closeable);
                }
            });
        } catch (RejectedExecutionException e10) {
            Logger logger = f13498d;
            Level level = Level.WARNING;
            if (logger.isLoggable(level)) {
                logger.log(level, String.format("while submitting close to %s; will close inline", executor), (Throwable) e10);
            }
            q(closeable, n0.INSTANCE);
        }
    }

    @Deprecated
    public static <C extends Closeable> i0<C> t(s1<C> future, final Executor closingExecutor) {
        closingExecutor.getClass();
        i0<C> i0Var = new i0<>(h1.u(future));
        h1.c(future, new c(closingExecutor), n0.INSTANCE);
        return i0Var;
    }

    public static <V> i0<V> w(s1<V> future) {
        return new i0<>(future);
    }

    public static /* synthetic */ void x(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException | RuntimeException e10) {
            f13498d.log(Level.WARNING, "thrown by close()", e10);
        }
    }

    public static <C, V extends C> void y(z<C> consumer, i0<V> closingFuture) {
        consumer.a(new y<>(closingFuture));
    }

    public <U> i0<U> C(final p<? super V, U> function, Executor executor) {
        function.getClass();
        f fVar = new f(function);
        u0<V> u0Var = this.f13501c;
        u0Var.getClass();
        return s((u0) q1.r.O(u0Var, fVar, executor));
    }

    public <U> i0<U> D(final m<? super V, U> function, Executor executor) {
        function.getClass();
        g gVar = new g(function);
        u0<V> u0Var = this.f13501c;
        u0Var.getClass();
        return s((u0) q1.r.O(u0Var, gVar, executor));
    }

    @b1.e
    public CountDownLatch M() {
        return this.f13500b.whenClosedCountDown();
    }

    public void finalize() {
        if (this.f13499a.get().equals(x.OPEN)) {
            f13498d.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            u();
        }
    }

    public final void i(n otherCloseables) {
        o(x.OPEN, x.SUBSUMED);
        otherCloseables.add(this.f13500b, n0.INSTANCE);
    }

    @t1.a
    public boolean j(boolean mayInterruptIfRunning) {
        f13498d.log(Level.FINER, "cancelling {0}", this);
        boolean zCancel = this.f13501c.cancel(mayInterruptIfRunning);
        if (zCancel) {
            p();
        }
        return zCancel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> i0<V> k(Class<X> exceptionType, p<? super X, ? extends V> fallback, Executor executor) {
        return n(exceptionType, fallback, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> i0<V> l(Class<X> exceptionType, m<? super X, ? extends V> fallback, Executor executor) {
        return m(exceptionType, fallback, executor);
    }

    public final <X extends Throwable, W extends V> i0<V> m(Class<X> cls, m<? super X, W> mVar, Executor executor) {
        mVar.getClass();
        j jVar = new j(mVar);
        u0<V> u0Var = this.f13501c;
        u0Var.getClass();
        return (i0<V>) s((u0) q1.a.O(u0Var, cls, jVar, executor));
    }

    public final <X extends Throwable, W extends V> i0<V> n(Class<X> cls, p<? super X, W> pVar, Executor executor) {
        pVar.getClass();
        i iVar = new i(pVar);
        u0<V> u0Var = this.f13501c;
        u0Var.getClass();
        return (i0<V>) s((u0) q1.a.O(u0Var, cls, iVar, executor));
    }

    public final void o(x oldState, x newState) {
        c1.h0.B0(g0.e.a(this.f13499a, oldState, newState), "Expected state to be %s, but it was %s", oldState, newState);
    }

    public final void p() {
        f13498d.log(Level.FINER, "closing {0}", this);
        this.f13500b.close();
    }

    public final boolean r(x oldState, x newState) {
        return g0.e.a(this.f13499a, oldState, newState);
    }

    public final <U> i0<U> s(u0<U> future) {
        i0<U> i0Var = new i0<>(future);
        i(i0Var.f13500b);
        return i0Var;
    }

    public String toString() {
        c1.z.b bVarJ = c1.z.c(this).j("state", this.f13499a.get());
        bVarJ.h().f1270b = this.f13501c;
        return bVarJ.toString();
    }

    public u0<V> u() {
        if (!g0.e.a(this.f13499a, x.OPEN, x.WILL_CLOSE)) {
            switch (b.f13504a[this.f13499a.get().ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
                case 2:
                    throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
                case 3:
                case 4:
                case 5:
                    throw new IllegalStateException("Cannot call finishToFuture() twice");
                case 6:
                    throw new AssertionError();
            }
        }
        f13498d.log(Level.FINER, "will close {0}", this);
        this.f13501c.addListener(new k(), n0.INSTANCE);
        return this.f13501c;
    }

    public void v(final z<? super V> consumer, Executor executor) {
        consumer.getClass();
        if (g0.e.a(this.f13499a, x.OPEN, x.WILL_CREATE_VALUE_AND_CLOSER)) {
            this.f13501c.addListener(new a(consumer), executor);
            return;
        }
        int i10 = b.f13504a[this.f13499a.get().ordinal()];
        if (i10 == 1) {
            throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
        }
        if (i10 == 2) {
            throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
        }
        if (i10 != 3 && i10 != 4 && i10 != 5) {
            throw new AssertionError(this.f13499a);
        }
        throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
    }

    public s1<?> z() {
        u0<V> u0Var = this.f13501c;
        c1.v.b bVar = new c1.v.b(null);
        n0 n0Var = n0.INSTANCE;
        u0Var.getClass();
        return h1.u((u0) q1.r.N(u0Var, bVar, n0Var));
    }

    public static final class n extends IdentityHashMap<Closeable, Executor> implements Closeable {
        private volatile boolean closed;
        private final v closer;

        @gm.a
        private volatile CountDownLatch whenClosed;

        public n() {
            this.closer = new v(this);
        }

        public void add(@gm.a Closeable closeable, Executor executor) {
            executor.getClass();
            if (closeable == null) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        i0.q(closeable, executor);
                    } else {
                        put(closeable, executor);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public <V, U> u0<U> applyAsyncClosingFunction(m<V, U> transformation, @c2 V input) throws Exception {
            n nVar = new n();
            try {
                i0<U> i0VarA = transformation.a(nVar.closer, input);
                i0VarA.i(nVar);
                return i0VarA.f13501c;
            } finally {
                add(nVar, n0.INSTANCE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <V, U> s1<U> applyClosingFunction(p<? super V, U> transformation, @c2 V input) throws Exception {
            n nVar = new n();
            try {
                return h1.o(transformation.a(nVar.closer, input));
            } finally {
                add(nVar, n0.INSTANCE);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    for (Map.Entry<Closeable, Executor> entry : entrySet()) {
                        i0.q(entry.getKey(), entry.getValue());
                    }
                    clear();
                    if (this.whenClosed != null) {
                        this.whenClosed.countDown();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public CountDownLatch whenClosedCountDown() {
            if (this.closed) {
                return new CountDownLatch(0);
            }
            synchronized (this) {
                try {
                    if (this.closed) {
                        return new CountDownLatch(0);
                    }
                    c1.h0.g0(this.whenClosed == null);
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.whenClosed = countDownLatch;
                    return countDownLatch;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public /* synthetic */ n(c cVar) {
            this();
        }
    }

    public i0(s1<V> future) {
        this.f13499a = new AtomicReference<>(x.OPEN);
        this.f13500b = new n(null);
        this.f13501c = u0.J(future);
    }

    public i0(final o<V> callable, Executor executor) {
        this.f13499a = new AtomicReference<>(x.OPEN);
        this.f13500b = new n(null);
        callable.getClass();
        a3 a3VarO = a3.O(new d(callable));
        executor.execute(a3VarO);
        this.f13501c = a3VarO;
    }

    public i0(final l<V> callable, Executor executor) {
        this.f13499a = new AtomicReference<>(x.OPEN);
        this.f13500b = new n(null);
        callable.getClass();
        a3 a3VarP = a3.P(new e(callable));
        executor.execute(a3VarP);
        this.f13501c = a3VarP;
    }
}
