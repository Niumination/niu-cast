package i4;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k3.l9;

/* JADX INFO: loaded from: classes.dex */
public class w1 extends j1 {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient s1 f5703d;
    public transient w1 e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient u1 f5704h;

    public w1(t0 t0Var, int i8, Comparator<Object> comparator) {
        super(t0Var, i8);
        this.f5703d = comparator == null ? s1.of() : z1.emptySet(comparator);
    }

    public static <K, V> t1 builder() {
        return new t1();
    }

    public static <K, V> w1 copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        t1 t1Var = new t1();
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            t1Var.c(it.next());
        }
        return t1Var.d();
    }

    public static <K, V> w1 fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        m0 m0Var = new m0(collection.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            AbstractCollection abstractCollectionCopyOf = comparator == null ? s1.copyOf((Collection) value) : z1.copyOf((Comparator) comparator, (Collection) value);
            if (!abstractCollectionCopyOf.isEmpty()) {
                m0Var.b(key, abstractCollectionCopyOf);
                size = abstractCollectionCopyOf.size() + size;
            }
        }
        return new w1(m0Var.a(), size, comparator);
    }

    public static <K, V> w1 of() {
        return u.INSTANCE;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int i8 = objectInputStream.readInt();
        if (i8 < 0) {
            throw new InvalidObjectException(a1.a.o(i8, "Invalid key count "));
        }
        m0 m0VarBuilder = t0.builder();
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            Object object = objectInputStream.readObject();
            int i11 = objectInputStream.readInt();
            if (i11 <= 0) {
                throw new InvalidObjectException(a1.a.o(i11, "Invalid value count "));
            }
            q1 q1Var = comparator == null ? new q1(4) : new x1(comparator);
            for (int i12 = 0; i12 < i11; i12++) {
                q1Var.d(objectInputStream.readObject());
            }
            s1 s1VarE = q1Var.e();
            if (s1VarE.size() != i11) {
                throw new InvalidObjectException(a1.a.p(object, "Duplicate key-value pairs exist for key "));
            }
            m0VarBuilder.b(object, s1VarE);
            i9 += i11;
        }
        try {
            u4 u4VarA = m0VarBuilder.a();
            tj.w wVar = f1.f5584a;
            wVar.getClass();
            try {
                ((Field) wVar.f10262b).set(this, u4VarA);
                tj.w wVar2 = f1.f5585b;
                wVar2.getClass();
                try {
                    ((Field) wVar2.f10262b).set(this, Integer.valueOf(i9));
                    tj.w wVar3 = v1.f5702a;
                    Object objOf = comparator == null ? s1.of() : z1.emptySet(comparator);
                    wVar3.getClass();
                    try {
                        ((Field) wVar3.f10262b).set(this, objOf);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    }
                } catch (IllegalAccessException e4) {
                    throw new AssertionError(e4);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        } catch (IllegalArgumentException e11) {
            throw ((InvalidObjectException) new InvalidObjectException(e11.getMessage()).initCause(e11));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        l9.b(this, objectOutputStream);
    }

    @Override // i4.j1
    @Deprecated
    public /* bridge */ /* synthetic */ a0 replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    public Comparator<Object> valueComparator() {
        s1 s1Var = this.f5703d;
        if (s1Var instanceof z1) {
            return ((z1) s1Var).comparator();
        }
        return null;
    }

    public static <K, V> w1 of(K k8, V v3) {
        t1 t1VarBuilder = builder();
        t1VarBuilder.e(k8, v3);
        return t1VarBuilder.d();
    }

    @Override // i4.j1
    public w1 inverse() {
        w1 w1Var = this.e;
        if (w1Var != null) {
            return w1Var;
        }
        t1 t1VarBuilder = builder();
        h5 it = mo146entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            t1VarBuilder.e(entry.getValue(), entry.getKey());
        }
        w1 w1VarD = t1VarBuilder.d();
        w1VarD.e = this;
        this.e = w1VarD;
        return w1VarD;
    }

    @Override // i4.j1
    @Deprecated
    /* JADX INFO: renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo152replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    @Override // i4.j1
    @Deprecated
    /* JADX INFO: renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Set mo152replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    @Override // i4.j1
    /* JADX INFO: renamed from: entries, reason: merged with bridge method [inline-methods] */
    public s1 mo146entries() {
        u1 u1Var = this.f5704h;
        if (u1Var != null) {
            return u1Var;
        }
        u1 u1Var2 = new u1(this);
        this.f5704h = u1Var2;
        return u1Var2;
    }

    @Override // i4.j1
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public s1 mo148get(Object obj) {
        s1 s1Var = (s1) this.map.get(obj);
        if (s1Var == null && (s1Var = this.f5703d) == null) {
            throw new NullPointerException("Both parameters are null");
        }
        return s1Var;
    }

    @Override // i4.j1
    @Deprecated
    /* JADX INFO: renamed from: removeAll, reason: merged with bridge method [inline-methods] */
    public final s1 mo151removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // i4.j1
    @Deprecated
    public final s1 replaceValues(Object obj, Iterable<Object> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> w1 of(K k8, V v3, K k10, V v8) {
        t1 t1VarBuilder = builder();
        t1VarBuilder.e(k8, v3);
        t1VarBuilder.e(k10, v8);
        return t1VarBuilder.d();
    }

    public static <K, V> w1 copyOf(a4 a4Var) {
        a4Var.getClass();
        if (((j1) a4Var).isEmpty()) {
            return of();
        }
        if (a4Var instanceof w1) {
            w1 w1Var = (w1) a4Var;
            if (!w1Var.isPartialView()) {
                return w1Var;
            }
        }
        return fromMapEntries(a4Var.asMap().entrySet(), null);
    }

    public static <K, V> w1 of(K k8, V v3, K k10, V v8, K k11, V v10) {
        t1 t1VarBuilder = builder();
        t1VarBuilder.e(k8, v3);
        t1VarBuilder.e(k10, v8);
        t1VarBuilder.e(k11, v10);
        return t1VarBuilder.d();
    }

    public static <K, V> w1 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11) {
        t1 t1VarBuilder = builder();
        t1VarBuilder.e(k8, v3);
        t1VarBuilder.e(k10, v8);
        t1VarBuilder.e(k11, v10);
        t1VarBuilder.e(k12, v11);
        return t1VarBuilder.d();
    }

    public static <K, V> w1 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11, K k13, V v12) {
        t1 t1VarBuilder = builder();
        t1VarBuilder.e(k8, v3);
        t1VarBuilder.e(k10, v8);
        t1VarBuilder.e(k11, v10);
        t1VarBuilder.e(k12, v11);
        t1VarBuilder.e(k13, v12);
        return t1VarBuilder.d();
    }
}
