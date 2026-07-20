package pl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import lm.c1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13215a = d(Throwable.class, -1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final ReentrantReadWriteLock f13216b = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final WeakHashMap<Class<? extends Throwable>, jn.l<Throwable, Throwable>> f13217c = new WeakHashMap<>();

    public static final class a extends kn.n0 implements jn.l<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // jn.l
        @os.m
        public final Throwable invoke(@os.l Throwable th2) {
            Object objM59constructorimpl;
            kn.l0.p(th2, "e");
            try {
                c1.a aVar = c1.Companion;
                Object objNewInstance = this.$constructor$inlined.newInstance(th2.getMessage(), th2);
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                objM59constructorimpl = c1.m59constructorimpl((Throwable) objNewInstance);
                if (c1.m64isFailureimpl(objM59constructorimpl)) {
                    objM59constructorimpl = null;
                }
                return (Throwable) objM59constructorimpl;
            } catch (Throwable th3) {
                c1.a aVar2 = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(d1.a(th3));
            }
        }
    }

    public static final class b extends kn.n0 implements jn.l<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // jn.l
        @os.m
        public final Throwable invoke(@os.l Throwable th2) {
            Object objM59constructorimpl;
            kn.l0.p(th2, "e");
            try {
                c1.a aVar = c1.Companion;
                Object objNewInstance = this.$constructor$inlined.newInstance(th2);
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                objM59constructorimpl = c1.m59constructorimpl((Throwable) objNewInstance);
                if (c1.m64isFailureimpl(objM59constructorimpl)) {
                    objM59constructorimpl = null;
                }
                return (Throwable) objM59constructorimpl;
            } catch (Throwable th3) {
                c1.a aVar2 = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(d1.a(th3));
            }
        }
    }

    public static final class c extends kn.n0 implements jn.l<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // jn.l
        @os.m
        public final Throwable invoke(@os.l Throwable th2) {
            Object objM59constructorimpl;
            kn.l0.p(th2, "e");
            try {
                c1.a aVar = c1.Companion;
                Object objNewInstance = this.$constructor$inlined.newInstance(th2.getMessage());
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                Throwable th3 = (Throwable) objNewInstance;
                th3.initCause(th2);
                objM59constructorimpl = c1.m59constructorimpl(th3);
                if (c1.m64isFailureimpl(objM59constructorimpl)) {
                    objM59constructorimpl = null;
                }
                return (Throwable) objM59constructorimpl;
            } catch (Throwable th4) {
                c1.a aVar2 = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(d1.a(th4));
            }
        }
    }

    public static final class d extends kn.n0 implements jn.l<Throwable, Throwable> {
        final /* synthetic */ Constructor $constructor$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Constructor constructor) {
            super(1);
            this.$constructor$inlined = constructor;
        }

        @Override // jn.l
        @os.m
        public final Throwable invoke(@os.l Throwable th2) {
            Object objM59constructorimpl;
            kn.l0.p(th2, "e");
            try {
                c1.a aVar = c1.Companion;
                Object objNewInstance = this.$constructor$inlined.newInstance(null);
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                Throwable th3 = (Throwable) objNewInstance;
                th3.initCause(th2);
                objM59constructorimpl = c1.m59constructorimpl(th3);
                return (Throwable) (c1.m64isFailureimpl(objM59constructorimpl) ? null : objM59constructorimpl);
            } catch (Throwable th4) {
                c1.a aVar2 = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(d1.a(th4));
            }
        }
    }

    public static final class e extends kn.n0 implements jn.l<Throwable, Throwable> {
        final /* synthetic */ jn.l<Throwable, Throwable> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(jn.l<? super Throwable, ? extends Throwable> lVar) {
            super(1);
            this.$block = lVar;
        }

        @Override // jn.l
        @os.m
        public final Throwable invoke(@os.l Throwable th2) {
            Object objM59constructorimpl;
            kn.l0.p(th2, "e");
            jn.l<Throwable, Throwable> lVar = this.$block;
            try {
                c1.a aVar = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(lVar.invoke(th2));
            } catch (Throwable th3) {
                c1.a aVar2 = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(d1.a(th3));
            }
            if (c1.m64isFailureimpl(objM59constructorimpl)) {
                objM59constructorimpl = null;
            }
            return (Throwable) objM59constructorimpl;
        }
    }

    public static final class f<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return rm.g.l(Integer.valueOf(((Constructor) t11).getParameterTypes().length), Integer.valueOf(((Constructor) t10).getParameterTypes().length));
        }
    }

    public static final class g extends kn.n0 implements jn.l {
        public static final g INSTANCE = new g();

        public g() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final Void invoke(@os.l Throwable th2) {
            kn.l0.p(th2, "it");
            return null;
        }
    }

    public static final class h extends kn.n0 implements jn.l {
        public static final h INSTANCE = new h();

        public h() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final Void invoke(@os.l Throwable th2) {
            kn.l0.p(th2, "it");
            return null;
        }
    }

    public static final jn.l<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new d(constructor);
        }
        if (length != 1) {
            if (length == 2 && kn.l0.g(parameterTypes[0], String.class) && kn.l0.g(parameterTypes[1], Throwable.class)) {
                return new a(constructor);
            }
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (kn.l0.g(cls, Throwable.class)) {
            return new b(constructor);
        }
        if (kn.l0.g(cls, String.class)) {
            return new c(constructor);
        }
        return null;
    }

    public static final int b(Class<?> cls, int i10) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            kn.l0.o(declaredFields, "declaredFields");
            int length = declaredFields.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                Field field = declaredFields[i11];
                i11++;
                if (!Modifier.isStatic(field.getModifiers())) {
                    i12++;
                }
            }
            i10 += i12;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i10;
    }

    public static /* synthetic */ int c(Class cls, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return b(cls, i10);
    }

    public static final int d(Class<?> cls, int i10) {
        Object objM59constructorimpl;
        in.b.i(cls);
        try {
            c1.a aVar = c1.Companion;
            objM59constructorimpl = c1.m59constructorimpl(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            objM59constructorimpl = c1.m59constructorimpl(d1.a(th2));
        }
        Integer numValueOf = Integer.valueOf(i10);
        if (c1.m64isFailureimpl(objM59constructorimpl)) {
            objM59constructorimpl = numValueOf;
        }
        return ((Number) objM59constructorimpl).intValue();
    }

    public static final void e(@os.l Throwable th2) {
        kn.l0.p(th2, "<this>");
        th2.printStackTrace();
    }

    public static final jn.l<Throwable, Throwable> f(jn.l<? super Throwable, ? extends Throwable> lVar) {
        return new e(lVar);
    }

    @os.m
    @ul.d
    public static final <E extends Throwable> E g(@os.l E e10, @os.l Throwable th2) {
        Object objM59constructorimpl;
        kn.l0.p(e10, "exception");
        kn.l0.p(th2, "cause");
        if (e10 instanceof nq.l0) {
            try {
                c1.a aVar = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(((nq.l0) e10).createCopy());
            } catch (Throwable th3) {
                c1.a aVar2 = c1.Companion;
                objM59constructorimpl = c1.m59constructorimpl(d1.a(th3));
            }
            return (E) (c1.m64isFailureimpl(objM59constructorimpl) ? null : objM59constructorimpl);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f13216b;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            jn.l<Throwable, Throwable> lVar = f13217c.get(e10.getClass());
            lock.unlock();
            if (lVar != null) {
                return (E) lVar.invoke(e10);
            }
            int i10 = 0;
            if (f13215a != d(e10.getClass(), 0)) {
                ReentrantReadWriteLock.ReadLock lock2 = reentrantReadWriteLock.readLock();
                int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                int i11 = 0;
                while (i11 < readHoldCount) {
                    i11++;
                    lock2.unlock();
                }
                ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f13217c.put((Class<? extends Throwable>) e10.getClass(), g.INSTANCE);
                    l2 l2Var = l2.f10208a;
                    while (i10 < readHoldCount) {
                        i10++;
                        lock2.lock();
                    }
                    return null;
                } finally {
                    while (i10 < readHoldCount) {
                        i10++;
                        lock2.lock();
                    }
                    writeLock.unlock();
                }
            }
            Constructor<?>[] constructors = e10.getClass().getConstructors();
            kn.l0.o(constructors, "exception.javaClass.constructors");
            jn.l<Throwable, Throwable> lVarA = null;
            for (Constructor constructor : nm.r.Mv(constructors, new f())) {
                kn.l0.o(constructor, "constructor");
                lVarA = a(constructor);
                if (lVarA != null) {
                    break;
                }
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = f13216b;
            ReentrantReadWriteLock.ReadLock lock3 = reentrantReadWriteLock2.readLock();
            int readHoldCount2 = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            int i12 = 0;
            while (i12 < readHoldCount2) {
                i12++;
                lock3.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock2 = reentrantReadWriteLock2.writeLock();
            writeLock2.lock();
            try {
                f13217c.put((Class<? extends Throwable>) e10.getClass(), lVarA == null ? h.INSTANCE : lVarA);
                l2 l2Var2 = l2.f10208a;
                while (i10 < readHoldCount2) {
                    i10++;
                    lock3.lock();
                }
                writeLock2.unlock();
                if (lVarA == null) {
                    return null;
                }
                return (E) lVarA.invoke(th2);
            } catch (Throwable th4) {
                while (i10 < readHoldCount2) {
                    i10++;
                    lock3.lock();
                }
                writeLock2.unlock();
                throw th4;
            }
        } catch (Throwable th5) {
            lock.unlock();
            throw th5;
        }
    }
}
