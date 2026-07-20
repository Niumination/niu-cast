package i4;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k3.l9;

/* JADX INFO: loaded from: classes.dex */
public class j0 extends j1 {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient j0 f5611d;

    public j0(t0 t0Var, int i8) {
        super(t0Var, i8);
    }

    public static <K, V> i0 builder() {
        return new i0();
    }

    public static <K, V> j0 copyOf(a4 a4Var) {
        j1 j1Var = (j1) a4Var;
        if (j1Var.isEmpty()) {
            return of();
        }
        if (j1Var instanceof j0) {
            j0 j0Var = (j0) j1Var;
            if (!j0Var.isPartialView()) {
                return j0Var;
            }
        }
        return fromMapEntries(j1Var.asMap().entrySet(), null);
    }

    public static <K, V> j0 fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        m0 m0Var = new m0(collection.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            h0 h0VarCopyOf = comparator == null ? h0.copyOf((Collection) value) : h0.sortedCopyOf(comparator, value);
            if (!h0VarCopyOf.isEmpty()) {
                m0Var.b(key, h0VarCopyOf);
                size = h0VarCopyOf.size() + size;
            }
        }
        return new j0(m0Var.a(), size);
    }

    public static <K, V> j0 of() {
        return t.INSTANCE;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
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
            c0 c0VarBuilder = h0.builder();
            for (int i12 = 0; i12 < i11; i12++) {
                c0VarBuilder.b(objectInputStream.readObject());
            }
            c0VarBuilder.f5714c = true;
            m0VarBuilder.b(object, h0.asImmutableList(c0VarBuilder.f5712a, c0VarBuilder.f5713b));
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
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                }
            } catch (IllegalAccessException e4) {
                throw new AssertionError(e4);
            }
        } catch (IllegalArgumentException e10) {
            throw ((InvalidObjectException) new InvalidObjectException(e10.getMessage()).initCause(e10));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        l9.b(this, objectOutputStream);
    }

    @Override // i4.j1
    @Deprecated
    public /* bridge */ /* synthetic */ a0 replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    public static <K, V> j0 of(K k8, V v3) {
        i0 i0VarBuilder = builder();
        i0VarBuilder.e(k8, v3);
        return i0VarBuilder.d();
    }

    @Override // i4.j1
    public j0 inverse() {
        j0 j0Var = this.f5611d;
        if (j0Var != null) {
            return j0Var;
        }
        i0 i0VarBuilder = builder();
        h5 it = mo146entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            i0VarBuilder.e(entry.getValue(), entry.getKey());
        }
        j0 j0VarD = i0VarBuilder.d();
        j0VarD.f5611d = this;
        this.f5611d = j0VarD;
        return j0VarD;
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
    public /* bridge */ /* synthetic */ List mo152replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    @Override // i4.j1
    /* JADX INFO: renamed from: get */
    public h0 mo148get(Object obj) {
        h0 h0Var = (h0) this.map.get(obj);
        return h0Var == null ? h0.of() : h0Var;
    }

    @Override // i4.j1
    @Deprecated
    /* JADX INFO: renamed from: removeAll */
    public final h0 mo151removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // i4.j1
    @Deprecated
    public final h0 replaceValues(Object obj, Iterable<Object> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> j0 of(K k8, V v3, K k10, V v8) {
        i0 i0VarBuilder = builder();
        i0VarBuilder.e(k8, v3);
        i0VarBuilder.e(k10, v8);
        return i0VarBuilder.d();
    }

    public static <K, V> j0 copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        i0 i0Var = new i0();
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            i0Var.c(it.next());
        }
        return i0Var.d();
    }

    public static <K, V> j0 of(K k8, V v3, K k10, V v8, K k11, V v10) {
        i0 i0VarBuilder = builder();
        i0VarBuilder.e(k8, v3);
        i0VarBuilder.e(k10, v8);
        i0VarBuilder.e(k11, v10);
        return i0VarBuilder.d();
    }

    public static <K, V> j0 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11) {
        i0 i0VarBuilder = builder();
        i0VarBuilder.e(k8, v3);
        i0VarBuilder.e(k10, v8);
        i0VarBuilder.e(k11, v10);
        i0VarBuilder.e(k12, v11);
        return i0VarBuilder.d();
    }

    public static <K, V> j0 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11, K k13, V v12) {
        i0 i0VarBuilder = builder();
        i0VarBuilder.e(k8, v3);
        i0VarBuilder.e(k10, v8);
        i0VarBuilder.e(k11, v10);
        i0VarBuilder.e(k12, v11);
        i0VarBuilder.e(k13, v12);
        return i0VarBuilder.d();
    }
}
