package vq;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,116:1\n1#2:117\n11335#3:118\n11670#3,3:119\n12904#3,3:136\n1963#4,14:122\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n45#1:118\n45#1:119,3\n82#1:136,3\n63#1:122,14\n*E\n"})
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f17870a = e(Throwable.class, -1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final k f17871b;

    public static final class a extends kn.n0 implements jn.l<Throwable, Throwable> {
        final /* synthetic */ Constructor<?> $constructor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Constructor<?> constructor) {
            super(1);
            this.$constructor = constructor;
        }

        @Override // jn.l
        @os.l
        public final Throwable invoke(@os.l Throwable th2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Object objNewInstance = this.$constructor.newInstance(th2.getMessage(), th2);
            kn.l0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
            return (Throwable) objNewInstance;
        }
    }

    @r1({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt$createConstructor$1$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
    public static final class b extends kn.n0 implements jn.l<Throwable, Throwable> {
        final /* synthetic */ Constructor<?> $constructor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor<?> constructor) {
            super(1);
            this.$constructor = constructor;
        }

        @Override // jn.l
        @os.l
        public final Throwable invoke(@os.l Throwable th2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Object objNewInstance = this.$constructor.newInstance(th2.getMessage());
            kn.l0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
            Throwable th3 = (Throwable) objNewInstance;
            th3.initCause(th2);
            return th3;
        }
    }

    public static final class c extends kn.n0 implements jn.l<Throwable, Throwable> {
        final /* synthetic */ Constructor<?> $constructor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Constructor<?> constructor) {
            super(1);
            this.$constructor = constructor;
        }

        @Override // jn.l
        @os.l
        public final Throwable invoke(@os.l Throwable th2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Object objNewInstance = this.$constructor.newInstance(th2);
            kn.l0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
            return (Throwable) objNewInstance;
        }
    }

    @r1({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt$createConstructor$1$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
    public static final class d extends kn.n0 implements jn.l<Throwable, Throwable> {
        final /* synthetic */ Constructor<?> $constructor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Constructor<?> constructor) {
            super(1);
            this.$constructor = constructor;
        }

        @Override // jn.l
        @os.l
        public final Throwable invoke(@os.l Throwable th2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Object objNewInstance = this.$constructor.newInstance(null);
            kn.l0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
            Throwable th3 = (Throwable) objNewInstance;
            th3.initCause(th2);
            return th3;
        }
    }

    public static final class e extends kn.n0 implements jn.l {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final Void invoke(@os.l Throwable th2) {
            return null;
        }
    }

    public static final class f extends kn.n0 implements jn.l<Throwable, Throwable> {
        final /* synthetic */ jn.l<Throwable, Throwable> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(jn.l<? super Throwable, ? extends Throwable> lVar) {
            super(1);
            this.$block = lVar;
        }

        @Override // jn.l
        @os.m
        public final Throwable invoke(@os.l Throwable th2) {
            Object objM59constructorimpl;
            jn.l<Throwable, Throwable> lVar = this.$block;
            try {
                lm.c1.a aVar = lm.c1.Companion;
                Throwable thInvoke = lVar.invoke(th2);
                if (!kn.l0.g(th2.getMessage(), thInvoke.getMessage()) && !kn.l0.g(thInvoke.getMessage(), th2.toString())) {
                    thInvoke = null;
                }
                objM59constructorimpl = lm.c1.m59constructorimpl(thInvoke);
            } catch (Throwable th3) {
                lm.c1.a aVar2 = lm.c1.Companion;
                objM59constructorimpl = lm.c1.m59constructorimpl(lm.d1.a(th3));
            }
            return (Throwable) (lm.c1.m64isFailureimpl(objM59constructorimpl) ? null : objM59constructorimpl);
        }
    }

    static {
        k kVar;
        try {
            kVar = r.a() ? i1.f17853a : vq.d.f17830a;
        } catch (Throwable unused) {
            kVar = i1.f17853a;
        }
        f17871b = kVar;
    }

    public static final <E extends Throwable> jn.l<Throwable, Throwable> b(Class<E> cls) {
        Object next;
        jn.l<Throwable, Throwable> lVar;
        lm.t0 t0Var;
        e eVar = e.INSTANCE;
        if (f17870a != e(cls, 0)) {
            return eVar;
        }
        Constructor<?>[] constructors = cls.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.length);
        int length = constructors.length;
        int i10 = 0;
        while (true) {
            next = null;
            if (i10 >= length) {
                break;
            }
            Constructor<?> constructor = constructors[i10];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            int length2 = parameterTypes.length;
            if (length2 == 0) {
                t0Var = new lm.t0(new f(new d(constructor)), 0);
            } else if (length2 == 1) {
                Class<?> cls2 = parameterTypes[0];
                if (kn.l0.g(cls2, String.class)) {
                    t0Var = new lm.t0(new f(new b(constructor)), 2);
                } else {
                    t0Var = kn.l0.g(cls2, Throwable.class) ? new lm.t0(new f(new c(constructor)), 1) : new lm.t0(null, -1);
                }
            } else if (length2 != 2) {
                t0Var = new lm.t0(null, -1);
            } else {
                t0Var = (kn.l0.g(parameterTypes[0], String.class) && kn.l0.g(parameterTypes[1], Throwable.class)) ? new lm.t0(new f(new a(constructor)), 3) : new lm.t0(null, -1);
            }
            arrayList.add(t0Var);
            i10++;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int iIntValue = ((Number) ((lm.t0) next).getSecond()).intValue();
                do {
                    Object next2 = it.next();
                    int iIntValue2 = ((Number) ((lm.t0) next2).getSecond()).intValue();
                    if (iIntValue < iIntValue2) {
                        next = next2;
                        iIntValue = iIntValue2;
                    }
                } while (it.hasNext());
            }
        }
        lm.t0 t0Var2 = (lm.t0) next;
        return (t0Var2 == null || (lVar = (jn.l) t0Var2.getFirst()) == null) ? eVar : lVar;
    }

    public static final int c(Class<?> cls, int i10) {
        do {
            int i11 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i11++;
                }
            }
            i10 += i11;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i10;
    }

    public static /* synthetic */ int d(Class cls, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return c(cls, i10);
    }

    public static final int e(Class<?> cls, int i10) {
        Object objM59constructorimpl;
        in.b.i(cls);
        try {
            lm.c1.a aVar = lm.c1.Companion;
            objM59constructorimpl = lm.c1.m59constructorimpl(Integer.valueOf(d(cls, 0, 1, null)));
        } catch (Throwable th2) {
            lm.c1.a aVar2 = lm.c1.Companion;
            objM59constructorimpl = lm.c1.m59constructorimpl(lm.d1.a(th2));
        }
        Integer numValueOf = Integer.valueOf(i10);
        if (lm.c1.m64isFailureimpl(objM59constructorimpl)) {
            objM59constructorimpl = numValueOf;
        }
        return ((Number) objM59constructorimpl).intValue();
    }

    public static final jn.l<Throwable, Throwable> f(jn.l<? super Throwable, ? extends Throwable> lVar) {
        return new f(lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.m
    public static final <E extends Throwable> E g(@os.l E e10) {
        Object objM59constructorimpl;
        if (!(e10 instanceof nq.l0)) {
            return (E) f17871b.a(e10.getClass()).invoke(e10);
        }
        try {
            lm.c1.a aVar = lm.c1.Companion;
            objM59constructorimpl = lm.c1.m59constructorimpl(((nq.l0) e10).createCopy());
        } catch (Throwable th2) {
            lm.c1.a aVar2 = lm.c1.Companion;
            objM59constructorimpl = lm.c1.m59constructorimpl(lm.d1.a(th2));
        }
        if (lm.c1.m64isFailureimpl(objM59constructorimpl)) {
            objM59constructorimpl = null;
        }
        return (E) objM59constructorimpl;
    }
}
