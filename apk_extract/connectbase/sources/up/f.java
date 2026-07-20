package up;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import jq.h0;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public class f implements up.n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f16363d = h0.x5(f.class.getCanonicalName(), ".", "");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final up.n f16364e = new a("NO_LOCKS", InterfaceC0441f.f16375a, up.e.f16362b);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ boolean f16365f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final up.k f16366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0441f f16367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16368c;

    public static class a extends f {
        public a(String str, InterfaceC0441f interfaceC0441f, up.k kVar) {
            super(str, interfaceC0441f, kVar);
        }

        public static /* synthetic */ void j(int i10) {
            String str = i10 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 1 ? 3 : 2];
            if (i10 != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i10 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i10 != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 1) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // up.f
        @os.l
        public <K, V> o<V> p(@os.l String str, K k10) {
            if (str == null) {
                j(0);
            }
            o<V> oVarA = o.a();
            if (oVarA == null) {
                j(1);
            }
            return oVarA;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> extends j<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f16369e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, jn.a aVar, Object obj) {
            super(fVar, aVar);
            this.f16369e = obj;
        }

        private static /* synthetic */ void a(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }

        @Override // up.f.h
        @os.l
        public o<T> c(boolean z10) {
            o<T> oVarD = o.d(this.f16369e);
            if (oVarD == null) {
                a(0);
            }
            return oVarD;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class c<T> extends k<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ jn.l f16371f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ jn.l f16372g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f fVar, jn.a aVar, jn.l lVar, jn.l lVar2) {
            super(fVar, aVar);
            this.f16371f = lVar;
            this.f16372g = lVar2;
        }

        private static /* synthetic */ void a(int i10) {
            String str = i10 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i10 != 2 ? 2 : 3];
            if (i10 != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i10 != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i10 == 2) {
                objArr[2] = "doPostCompute";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 2) {
                throw new IllegalArgumentException(str2);
            }
        }

        @Override // up.f.h
        @os.l
        public o<T> c(boolean z10) {
            jn.l lVar = this.f16371f;
            if (lVar == null) {
                o<T> oVarC = super.c(z10);
                if (oVarC == null) {
                    a(0);
                }
                return oVarC;
            }
            o<T> oVarD = o.d(lVar.invoke(Boolean.valueOf(z10)));
            if (oVarD == null) {
                a(1);
            }
            return oVarD;
        }

        @Override // up.f.i
        public void d(@os.l T t10) {
            if (t10 == null) {
                a(2);
            }
            this.f16372g.invoke(t10);
        }
    }

    public static class d<K, V> extends e<K, V> implements up.a<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ boolean f16374d = false;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@os.l f fVar, @os.l ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap);
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }

        private static /* synthetic */ void b(int i10) {
            String str = i10 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 3 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 == 2) {
                objArr[0] = "computation";
            } else if (i10 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i10 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i10 == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i10 != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 3) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // up.f.e, up.a
        @os.l
        public V a(K k10, @os.l jn.a<? extends V> aVar) {
            if (aVar == null) {
                b(2);
            }
            V v10 = (V) super.a(k10, aVar);
            if (v10 == null) {
                b(3);
            }
            return v10;
        }

        public /* synthetic */ d(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }
    }

    public static class e<K, V> extends l<g<K, V>, V> implements up.b<K, V> {

        public class a implements jn.l<g<K, V>, V> {
            @Override // jn.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public V invoke(g<K, V> gVar) {
                return gVar.f16377b.invoke();
            }
        }

        public /* synthetic */ e(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }

        private static /* synthetic */ void b(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i10 != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @os.m
        public V a(K k10, @os.l jn.a<? extends V> aVar) {
            if (aVar == null) {
                b(2);
            }
            return invoke(new g(k10, aVar));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@os.l f fVar, @os.l ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap, new a());
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }
    }

    /* JADX INFO: renamed from: up.f$f, reason: collision with other inner class name */
    public interface InterfaceC0441f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InterfaceC0441f f16375a = new a();

        /* JADX INFO: renamed from: up.f$f$a */
        public static class a implements InterfaceC0441f {
            public static /* synthetic */ void b(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // up.f.InterfaceC0441f
            @os.l
            public RuntimeException a(@os.l Throwable th2) throws Throwable {
                if (th2 == null) {
                    b(0);
                }
                l0.p(th2, "e");
                throw th2;
            }
        }

        @os.l
        RuntimeException a(@os.l Throwable th2);
    }

    public static class g<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f16376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jn.a<? extends V> f16377b;

        public g(K k10, jn.a<? extends V> aVar) {
            this.f16376a = k10;
            this.f16377b = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.f16376a.equals(((g) obj).f16376a);
        }

        public int hashCode() {
            return this.f16376a.hashCode();
        }
    }

    public static class h<T> implements up.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f16378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jn.a<? extends T> f16379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.m
        public volatile Object f16380c;

        public h(@os.l f fVar, @os.l jn.a<? extends T> aVar) {
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
            this.f16380c = n.NOT_COMPUTED;
            this.f16378a = fVar;
            this.f16379b = aVar;
        }

        private static /* synthetic */ void a(int i10) {
            String str = (i10 == 2 || i10 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 2 || i10 == 3) ? 2 : 3];
            if (i10 == 1) {
                objArr[0] = "computable";
            } else if (i10 == 2 || i10 == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i10 == 2) {
                objArr[1] = "recursionDetected";
            } else if (i10 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i10 != 2 && i10 != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 != 2 && i10 != 3) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public void b(T t10) {
        }

        @os.l
        public o<T> c(boolean z10) {
            o<T> oVarP = this.f16378a.p("in a lazy value", null);
            if (oVarP == null) {
                a(2);
            }
            return oVarP;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x003e A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007b, B:35:0x007c, B:36:0x0082, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x0042 A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007b, B:35:0x007c, B:36:0x0082, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x004d A[Catch: all -> 0x0024, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007b, B:35:0x007c, B:36:0x0082, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x0052 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #1 {all -> 0x0024, blocks: (B:7:0x0012, B:9:0x0018, B:14:0x0026, B:16:0x002a, B:18:0x0039, B:19:0x003e, B:21:0x0042, B:23:0x004d, B:24:0x0052, B:28:0x0061, B:30:0x0067, B:32:0x006d, B:33:0x0073, B:34:0x007b, B:35:0x007c, B:36:0x0082, B:25:0x0054), top: B:41:0x0012, inners: #0 }] */
        @Override // jn.a
        public T invoke() {
            T tInvoke;
            o<T> oVarC;
            Object obj = this.f16380c;
            if (!(obj instanceof n)) {
                return (T) eq.g.f(obj);
            }
            this.f16378a.f16366a.lock();
            try {
                Object obj2 = this.f16380c;
                if (obj2 instanceof n) {
                    n nVar = n.COMPUTING;
                    if (obj2 == nVar) {
                        this.f16380c = n.RECURSION_WAS_DETECTED;
                        o<T> oVarC2 = c(true);
                        if (!oVarC2.c()) {
                            tInvoke = oVarC2.b();
                        } else if (obj2 == n.RECURSION_WAS_DETECTED) {
                            oVarC = c(false);
                            if (oVarC.c()) {
                                this.f16380c = nVar;
                                try {
                                    tInvoke = this.f16379b.invoke();
                                    b(tInvoke);
                                    this.f16380c = tInvoke;
                                } catch (Throwable th2) {
                                    if (eq.c.a(th2)) {
                                        this.f16380c = n.NOT_COMPUTED;
                                        throw th2;
                                    }
                                    if (this.f16380c == n.COMPUTING) {
                                        this.f16380c = eq.g.c(th2);
                                    }
                                    throw this.f16378a.f16367b.a(th2);
                                }
                            } else {
                                tInvoke = oVarC.b();
                            }
                        } else {
                            this.f16380c = nVar;
                            tInvoke = this.f16379b.invoke();
                            b(tInvoke);
                            this.f16380c = tInvoke;
                        }
                    } else if (obj2 == n.RECURSION_WAS_DETECTED) {
                        oVarC = c(false);
                        if (oVarC.c()) {
                            tInvoke = oVarC.b();
                        } else {
                            this.f16380c = nVar;
                            tInvoke = this.f16379b.invoke();
                            b(tInvoke);
                            this.f16380c = tInvoke;
                        }
                    } else {
                        this.f16380c = nVar;
                        tInvoke = this.f16379b.invoke();
                        b(tInvoke);
                        this.f16380c = tInvoke;
                    }
                } else {
                    tInvoke = (T) eq.g.f(obj2);
                }
                this.f16378a.f16366a.unlock();
                return tInvoke;
            } catch (Throwable th3) {
                this.f16378a.f16366a.unlock();
                throw th3;
            }
        }

        public boolean m() {
            return (this.f16380c == n.NOT_COMPUTED || this.f16380c == n.COMPUTING) ? false : true;
        }
    }

    public static abstract class i<T> extends h<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.m
        public volatile up.l<T> f16381d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@os.l f fVar, @os.l jn.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
            this.f16381d = null;
        }

        private static /* synthetic */ void a(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // up.f.h
        public final void b(T t10) {
            this.f16381d = new up.l<>(t10);
            try {
                d(t10);
            } finally {
                this.f16381d = null;
            }
        }

        public abstract void d(T t10);

        @Override // up.f.h, jn.a
        public T invoke() {
            up.l<T> lVar = this.f16381d;
            return (lVar == null || !lVar.b()) ? (T) super.invoke() : lVar.a();
        }
    }

    public static class j<T> extends h<T> implements up.i<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ boolean f16382d = false;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(@os.l f fVar, @os.l jn.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i10) {
            String str = i10 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 2 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "computable";
            } else if (i10 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i10 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i10 != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 2) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // up.f.h, jn.a
        @os.l
        public T invoke() {
            T t10 = (T) super.invoke();
            if (t10 == null) {
                a(2);
            }
            return t10;
        }
    }

    public static abstract class k<T> extends i<T> implements up.i<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ boolean f16383e = false;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(@os.l f fVar, @os.l jn.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i10) {
            String str = i10 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 2 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "computable";
            } else if (i10 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i10 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i10 != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 2) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // up.f.i, up.f.h, jn.a
        @os.l
        public T invoke() {
            T t10 = (T) super.invoke();
            if (t10 == null) {
                a(2);
            }
            return t10;
        }
    }

    public static class l<K, V> implements up.h<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f16384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentMap<K, Object> f16385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jn.l<? super K, ? extends V> f16386c;

        public l(@os.l f fVar, @os.l ConcurrentMap<K, Object> concurrentMap, @os.l jn.l<? super K, ? extends V> lVar) {
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (lVar == null) {
                b(2);
            }
            this.f16384a = fVar;
            this.f16385b = concurrentMap;
            this.f16386c = lVar;
        }

        private static /* synthetic */ void b(int i10) {
            String str = (i10 == 3 || i10 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 3 || i10 == 4) ? 2 : 3];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 == 2) {
                objArr[0] = "compute";
            } else if (i10 == 3 || i10 == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i10 == 3) {
                objArr[1] = "recursionDetected";
            } else if (i10 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i10 != 3 && i10 != 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 != 3 && i10 != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public f c() {
            return this.f16384a;
        }

        @os.l
        public final AssertionError d(K k10, Object obj) {
            AssertionError assertionError = (AssertionError) f.q(new AssertionError("Race condition detected on input " + k10 + ". Old value is " + obj + " under " + this.f16384a));
            if (assertionError == null) {
                b(4);
            }
            return assertionError;
        }

        @os.l
        public o<V> e(K k10, boolean z10) {
            o<V> oVarP = this.f16384a.p("", k10);
            if (oVarP == null) {
                b(3);
            }
            return oVarP;
        }

        /* JADX WARN: Code duplicated, block: B:18:0x003e A[Catch: all -> 0x003b, PHI: r0
          0x003e: PHI (r0v6 java.lang.Object) = (r0v5 java.lang.Object), (r0v13 java.lang.Object) binds: [B:10:0x0020, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x003b, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:18:0x003e, B:20:0x0042, B:22:0x004d, B:24:0x0054, B:34:0x007f, B:37:0x0087, B:39:0x0095, B:40:0x0099, B:41:0x009a, B:42:0x00a2, B:43:0x00a3, B:44:0x00ab, B:45:0x00ac, B:46:0x00b3, B:27:0x005a, B:31:0x0079, B:32:0x007d), top: B:49:0x0018, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:20:0x0042 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:18:0x003e, B:20:0x0042, B:22:0x004d, B:24:0x0054, B:34:0x007f, B:37:0x0087, B:39:0x0095, B:40:0x0099, B:41:0x009a, B:42:0x00a2, B:43:0x00a3, B:44:0x00ab, B:45:0x00ac, B:46:0x00b3, B:27:0x005a, B:31:0x0079, B:32:0x007d), top: B:49:0x0018, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x004d A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:18:0x003e, B:20:0x0042, B:22:0x004d, B:24:0x0054, B:34:0x007f, B:37:0x0087, B:39:0x0095, B:40:0x0099, B:41:0x009a, B:42:0x00a2, B:43:0x00a3, B:44:0x00ab, B:45:0x00ac, B:46:0x00b3, B:27:0x005a, B:31:0x0079, B:32:0x007d), top: B:49:0x0018, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x0052 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:24:0x0054 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #0 {all -> 0x003b, blocks: (B:9:0x0018, B:11:0x0022, B:13:0x002f, B:18:0x003e, B:20:0x0042, B:22:0x004d, B:24:0x0054, B:34:0x007f, B:37:0x0087, B:39:0x0095, B:40:0x0099, B:41:0x009a, B:42:0x00a2, B:43:0x00a3, B:44:0x00ab, B:45:0x00ac, B:46:0x00b3, B:27:0x005a, B:31:0x0079, B:32:0x007d), top: B:49:0x0018, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x0059  */
        /* JADX WARN: Code duplicated, block: B:29:0x0071  */
        /* JADX WARN: Code duplicated, block: B:31:0x0079 A[Catch: all -> 0x007e, TRY_ENTER, TryCatch #1 {all -> 0x007e, blocks: (B:27:0x005a, B:31:0x0079, B:32:0x007d), top: B:50:0x005a, outer: #0 }] */
        @Override // jn.l
        @os.m
        public V invoke(K k10) {
            AssertionError assertionErrorD;
            V vInvoke;
            Object objPut;
            V vB;
            o<V> oVarE;
            Object obj = this.f16385b.get(k10);
            if (obj != null && obj != n.COMPUTING) {
                return (V) eq.g.d(obj);
            }
            this.f16384a.f16366a.lock();
            try {
                Object obj2 = this.f16385b.get(k10);
                n nVar = n.COMPUTING;
                if (obj2 == nVar) {
                    obj2 = n.RECURSION_WAS_DETECTED;
                    o<V> oVarE2 = e(k10, true);
                    if (!oVarE2.c()) {
                        vB = oVarE2.b();
                    } else if (obj2 == n.RECURSION_WAS_DETECTED) {
                        oVarE = e(k10, false);
                        if (!oVarE.c()) {
                            vB = oVarE.b();
                        } else {
                            if (obj2 != null) {
                                assertionErrorD = null;
                                try {
                                    this.f16385b.put(k10, nVar);
                                    vInvoke = this.f16386c.invoke(k10);
                                    objPut = this.f16385b.put(k10, eq.g.b(vInvoke));
                                    if (objPut == nVar) {
                                        this.f16384a.f16366a.unlock();
                                        return vInvoke;
                                    }
                                    assertionErrorD = d(k10, objPut);
                                    throw assertionErrorD;
                                } catch (Throwable th2) {
                                    if (eq.c.a(th2)) {
                                        this.f16385b.remove(k10);
                                        throw th2;
                                    }
                                    if (th2 == assertionErrorD) {
                                        throw this.f16384a.f16367b.a(th2);
                                    }
                                    Object objPut2 = this.f16385b.put(k10, eq.g.c(th2));
                                    if (objPut2 != n.COMPUTING) {
                                        throw d(k10, objPut2);
                                    }
                                    throw this.f16384a.f16367b.a(th2);
                                }
                            }
                            vB = (V) eq.g.d(obj2);
                        }
                    } else {
                        if (obj2 != null) {
                            assertionErrorD = null;
                            this.f16385b.put(k10, nVar);
                            vInvoke = this.f16386c.invoke(k10);
                            objPut = this.f16385b.put(k10, eq.g.b(vInvoke));
                            if (objPut == nVar) {
                                this.f16384a.f16366a.unlock();
                                return vInvoke;
                            }
                            assertionErrorD = d(k10, objPut);
                            throw assertionErrorD;
                        }
                        vB = (V) eq.g.d(obj2);
                    }
                } else if (obj2 == n.RECURSION_WAS_DETECTED) {
                    oVarE = e(k10, false);
                    if (!oVarE.c()) {
                        vB = oVarE.b();
                    } else {
                        if (obj2 != null) {
                            assertionErrorD = null;
                            this.f16385b.put(k10, nVar);
                            vInvoke = this.f16386c.invoke(k10);
                            objPut = this.f16385b.put(k10, eq.g.b(vInvoke));
                            if (objPut == nVar) {
                                this.f16384a.f16366a.unlock();
                                return vInvoke;
                            }
                            assertionErrorD = d(k10, objPut);
                            throw assertionErrorD;
                        }
                        vB = (V) eq.g.d(obj2);
                    }
                } else {
                    if (obj2 != null) {
                        assertionErrorD = null;
                        this.f16385b.put(k10, nVar);
                        vInvoke = this.f16386c.invoke(k10);
                        objPut = this.f16385b.put(k10, eq.g.b(vInvoke));
                        if (objPut == nVar) {
                            this.f16384a.f16366a.unlock();
                            return vInvoke;
                        }
                        assertionErrorD = d(k10, objPut);
                        throw assertionErrorD;
                    }
                    vB = (V) eq.g.d(obj2);
                }
                this.f16384a.f16366a.unlock();
                return vB;
            } catch (Throwable th3) {
                this.f16384a.f16366a.unlock();
                throw th3;
            }
        }

        @Override // up.h
        public boolean y(K k10) {
            Object obj = this.f16385b.get(k10);
            return (obj == null || obj == n.COMPUTING) ? false : true;
        }
    }

    public static class m<K, V> extends l<K, V> implements up.g<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ boolean f16387d = false;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(@os.l f fVar, @os.l ConcurrentMap<K, Object> concurrentMap, @os.l jn.l<? super K, ? extends V> lVar) {
            super(fVar, concurrentMap, lVar);
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (lVar == null) {
                b(2);
            }
        }

        private static /* synthetic */ void b(int i10) {
            String str = i10 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i10 != 3 ? 3 : 2];
            if (i10 == 1) {
                objArr[0] = "map";
            } else if (i10 == 2) {
                objArr[0] = "compute";
            } else if (i10 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i10 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i10 != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 3) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // up.f.l, jn.l
        @os.l
        public V invoke(K k10) {
            V v10 = (V) super.invoke(k10);
            if (v10 == null) {
                b(3);
            }
            return v10;
        }
    }

    public enum n {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    public static class o<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ boolean f16389c = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f16390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f16391b;

        public o(T t10, boolean z10) {
            this.f16390a = t10;
            this.f16391b = z10;
        }

        @os.l
        public static <T> o<T> a() {
            return new o<>(null, true);
        }

        @os.l
        public static <T> o<T> d(T t10) {
            return new o<>(t10, false);
        }

        public T b() {
            return this.f16390a;
        }

        public boolean c() {
            return this.f16391b;
        }

        public String toString() {
            return c() ? "FALL_THROUGH" : String.valueOf(this.f16390a);
        }
    }

    public /* synthetic */ f(String str, InterfaceC0441f interfaceC0441f, up.k kVar, a aVar) {
        this(str, interfaceC0441f, kVar);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    private static /* synthetic */ void j(int i10) {
        String str = (i10 == 10 || i10 == 13 || i10 == 20 || i10 == 37) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 10 || i10 == 13 || i10 == 20 || i10 == 37) ? 2 : 3];
        if (i10 == 1 || i10 == 3 || i10 == 5) {
            objArr[0] = "exceptionHandlingStrategy";
        } else if (i10 != 6) {
            switch (i10) {
                case 8:
                    objArr[0] = "exceptionHandlingStrategy";
                    break;
                case 9:
                case 11:
                case 14:
                case 16:
                case 19:
                case 21:
                    objArr[0] = "compute";
                    break;
                case 10:
                case 13:
                case 20:
                case 37:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                    break;
                case 12:
                case 17:
                case 25:
                case 27:
                    objArr[0] = "onRecursiveCall";
                    break;
                case 15:
                case 18:
                case 22:
                    objArr[0] = "map";
                    break;
                case 23:
                case 24:
                case 26:
                case 28:
                case 30:
                case 31:
                case 32:
                case 34:
                    objArr[0] = "computable";
                    break;
                case 29:
                case 33:
                    objArr[0] = "postCompute";
                    break;
                case 35:
                    objArr[0] = "source";
                    break;
                case 36:
                    objArr[0] = "throwable";
                    break;
                default:
                    objArr[0] = "debugText";
                    break;
            }
        } else {
            objArr[0] = "lock";
        }
        if (i10 == 10 || i10 == 13) {
            objArr[1] = "createMemoizedFunction";
        } else if (i10 == 20) {
            objArr[1] = "createMemoizedFunctionWithNullableValues";
        } else if (i10 != 37) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        } else {
            objArr[1] = "sanitizeStackTrace";
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "<init>";
                break;
            case 7:
            case 8:
                objArr[2] = "replaceExceptionHandling";
                break;
            case 9:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createMemoizedFunction";
                break;
            case 10:
            case 13:
            case 20:
            case 37:
                break;
            case 19:
            case 21:
            case 22:
                objArr[2] = "createMemoizedFunctionWithNullableValues";
                break;
            case 23:
            case 24:
            case 25:
                objArr[2] = "createLazyValue";
                break;
            case 26:
            case 27:
                objArr[2] = "createRecursionTolerantLazyValue";
                break;
            case 28:
            case 29:
                objArr[2] = "createLazyValueWithPostCompute";
                break;
            case 30:
                objArr[2] = "createNullableLazyValue";
                break;
            case 31:
                objArr[2] = "createRecursionTolerantNullableLazyValue";
                break;
            case 32:
            case 33:
                objArr[2] = "createNullableLazyValueWithPostCompute";
                break;
            case 34:
                objArr[2] = "compute";
                break;
            case 35:
                objArr[2] = "recursionDetectedDefault";
                break;
            case 36:
                objArr[2] = "sanitizeStackTrace";
                break;
            default:
                objArr[2] = "createWithExceptionHandling";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 10 && i10 != 13 && i10 != 20 && i10 != 37) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @os.l
    public static <K> ConcurrentMap<K, Object> m() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    @os.l
    public static <T extends Throwable> T q(@os.l T t10) {
        if (t10 == null) {
            j(36);
        }
        StackTraceElement[] stackTrace = t10.getStackTrace();
        int length = stackTrace.length;
        int i10 = 0;
        while (i10 < length) {
            if (!stackTrace[i10].getClassName().startsWith(f16363d)) {
                List listSubList = Arrays.asList(stackTrace).subList(i10, length);
                t10.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
                return t10;
            }
            i10++;
        }
        i10 = -1;
        List listSubList2 = Arrays.asList(stackTrace).subList(i10, length);
        t10.setStackTrace((StackTraceElement[]) listSubList2.toArray(new StackTraceElement[listSubList2.size()]));
        return t10;
    }

    @Override // up.n
    @os.l
    public <K, V> up.g<K, V> a(@os.l jn.l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            j(9);
        }
        up.g<K, V> gVarN = n(lVar, m());
        if (gVarN == null) {
            j(10);
        }
        return gVarN;
    }

    @Override // up.n
    @os.l
    public <K, V> up.a<K, V> b() {
        return new d(this, m());
    }

    @Override // up.n
    public <T> T c(@os.l jn.a<? extends T> aVar) {
        if (aVar == null) {
            j(34);
        }
        this.f16366a.lock();
        try {
            T tInvoke = aVar.invoke();
            this.f16366a.unlock();
            return tInvoke;
        } catch (Throwable th2) {
            try {
                throw this.f16367b.a(th2);
            } catch (Throwable th3) {
                this.f16366a.unlock();
                throw th3;
            }
        }
    }

    @Override // up.n
    @os.l
    public <T> up.i<T> d(@os.l jn.a<? extends T> aVar, jn.l<? super Boolean, ? extends T> lVar, @os.l jn.l<? super T, l2> lVar2) {
        if (aVar == null) {
            j(28);
        }
        if (lVar2 == null) {
            j(29);
        }
        return new c(this, aVar, lVar, lVar2);
    }

    @Override // up.n
    @os.l
    public <K, V> up.b<K, V> e() {
        return new e(this, m());
    }

    @Override // up.n
    @os.l
    public <K, V> up.h<K, V> f(@os.l jn.l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            j(19);
        }
        up.h<K, V> hVarO = o(lVar, m());
        if (hVarO == null) {
            j(20);
        }
        return hVarO;
    }

    @Override // up.n
    @os.l
    public <T> up.j<T> g(@os.l jn.a<? extends T> aVar) {
        if (aVar == null) {
            j(30);
        }
        return new h(this, aVar);
    }

    @Override // up.n
    @os.l
    public <T> up.i<T> h(@os.l jn.a<? extends T> aVar) {
        if (aVar == null) {
            j(23);
        }
        return new j(this, aVar);
    }

    @Override // up.n
    @os.l
    public <T> up.i<T> i(@os.l jn.a<? extends T> aVar, @os.l T t10) {
        if (aVar == null) {
            j(26);
        }
        if (t10 == null) {
            j(27);
        }
        return new b(this, aVar, t10);
    }

    @os.l
    public <K, V> up.g<K, V> n(@os.l jn.l<? super K, ? extends V> lVar, @os.l ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            j(14);
        }
        if (concurrentMap == null) {
            j(15);
        }
        return new m(this, concurrentMap, lVar);
    }

    @os.l
    public <K, V> up.h<K, V> o(@os.l jn.l<? super K, ? extends V> lVar, @os.l ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            j(21);
        }
        if (concurrentMap == null) {
            j(22);
        }
        return new l(this, concurrentMap, lVar);
    }

    @os.l
    public <K, V> o<V> p(@os.l String str, K k10) {
        if (str == null) {
            j(35);
        }
        StringBuilder sb2 = new StringBuilder("Recursion detected ");
        sb2.append(str);
        sb2.append(k10 == null ? "" : c0.a.a("on input: ", k10));
        sb2.append(" under ");
        sb2.append(this);
        throw ((AssertionError) q(new AssertionError(sb2.toString())));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("@");
        sb2.append(Integer.toHexString(hashCode()));
        sb2.append(" (");
        return j.c.a(sb2, this.f16368c, ")");
    }

    public f(@os.l String str, @os.l InterfaceC0441f interfaceC0441f, @os.l up.k kVar) {
        if (str == null) {
            j(4);
        }
        if (interfaceC0441f == null) {
            j(5);
        }
        if (kVar == null) {
            j(6);
        }
        this.f16366a = kVar;
        this.f16367b = interfaceC0441f;
        this.f16368c = str;
    }

    public f(String str) {
        this(str, (Runnable) null, (jn.l<InterruptedException, l2>) null);
    }

    public f(String str, @os.m Runnable runnable, @os.m jn.l<InterruptedException, l2> lVar) {
        this(str, InterfaceC0441f.f16375a, up.k.f16392a.a(runnable, lVar));
    }
}
