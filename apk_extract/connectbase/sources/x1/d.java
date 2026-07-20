package x1;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import v1.a0;
import v1.z;

/* JADX INFO: loaded from: classes.dex */
public final class d implements a0, Cloneable {
    public static final d DEFAULT = new d();
    private static final double IGNORE_VERSIONS = -1.0d;
    private boolean requireExpose;
    private double version = -1.0d;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;
    private List<v1.a> serializationStrategies = Collections.emptyList();
    private List<v1.a> deserializationStrategies = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends z<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z<T> f19963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f19964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f19965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ v1.e f19966d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c2.a f19967e;

        public a(boolean z10, boolean z11, v1.e eVar, c2.a aVar) {
            this.f19964b = z10;
            this.f19965c = z11;
            this.f19966d = eVar;
            this.f19967e = aVar;
        }

        public final z<T> delegate() {
            z<T> zVar = this.f19963a;
            if (zVar != null) {
                return zVar;
            }
            z<T> delegateAdapter = this.f19966d.getDelegateAdapter(d.this, this.f19967e);
            this.f19963a = delegateAdapter;
            return delegateAdapter;
        }

        @Override // v1.z
        public T read(d2.a aVar) throws IOException {
            if (!this.f19964b) {
                return delegate().read(aVar);
            }
            aVar.skipValue();
            return null;
        }

        @Override // v1.z
        public void write(d2.d dVar, T t10) throws IOException {
            if (this.f19965c) {
                dVar.nullValue();
            } else {
                delegate().write(dVar, t10);
            }
        }
    }

    private boolean excludeClassChecks(Class<?> cls) {
        if (this.version != -1.0d && !isValidVersion((w1.c) cls.getAnnotation(w1.c.class), (w1.d) cls.getAnnotation(w1.d.class))) {
            return true;
        }
        if (this.serializeInnerClasses || !isInnerClass(cls)) {
            return isAnonymousOrNonStaticLocal(cls);
        }
        return true;
    }

    private boolean excludeClassInStrategy(Class<?> cls, boolean z10) {
        Iterator<v1.a> it = (z10 ? this.serializationStrategies : this.deserializationStrategies).iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrNonStaticLocal(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || isStatic(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean isInnerClass(Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidSince(w1.c cVar) {
        if (cVar != null) {
            return this.version >= cVar.value();
        }
        return true;
    }

    private boolean isValidUntil(w1.d dVar) {
        if (dVar != null) {
            return this.version < dVar.value();
        }
        return true;
    }

    private boolean isValidVersion(w1.c cVar, w1.d dVar) {
        return isValidSince(cVar) && isValidUntil(dVar);
    }

    @Override // v1.a0
    public <T> z<T> create(v1.e eVar, c2.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean zExcludeClassChecks = excludeClassChecks(rawType);
        boolean z10 = zExcludeClassChecks || excludeClassInStrategy(rawType, true);
        boolean z11 = zExcludeClassChecks || excludeClassInStrategy(rawType, false);
        if (z10 || z11) {
            return new a(z11, z10, eVar, aVar);
        }
        return null;
    }

    public d disableInnerClassSerialization() {
        d dVarClone = clone();
        dVarClone.serializeInnerClasses = false;
        return dVarClone;
    }

    public boolean excludeClass(Class<?> cls, boolean z10) {
        return excludeClassChecks(cls) || excludeClassInStrategy(cls, z10);
    }

    public boolean excludeField(Field field, boolean z10) {
        w1.a aVar;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != -1.0d && !isValidVersion((w1.c) field.getAnnotation(w1.c.class), (w1.d) field.getAnnotation(w1.d.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((aVar = (w1.a) field.getAnnotation(w1.a.class)) == null || (!z10 ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrNonStaticLocal(field.getType())) {
            return true;
        }
        List<v1.a> list = z10 ? this.serializationStrategies : this.deserializationStrategies;
        if (list.isEmpty()) {
            return false;
        }
        v1.b bVar = new v1.b(field);
        Iterator<v1.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipField(bVar)) {
                return true;
            }
        }
        return false;
    }

    public d excludeFieldsWithoutExposeAnnotation() {
        d dVarClone = clone();
        dVarClone.requireExpose = true;
        return dVarClone;
    }

    public d withExclusionStrategy(v1.a aVar, boolean z10, boolean z11) {
        d dVarClone = clone();
        if (z10) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            dVarClone.serializationStrategies = arrayList;
            arrayList.add(aVar);
        }
        if (z11) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            dVarClone.deserializationStrategies = arrayList2;
            arrayList2.add(aVar);
        }
        return dVarClone;
    }

    public d withModifiers(int... iArr) {
        d dVarClone = clone();
        dVarClone.modifiers = 0;
        for (int i10 : iArr) {
            dVarClone.modifiers = i10 | dVarClone.modifiers;
        }
        return dVarClone;
    }

    public d withVersion(double d10) {
        d dVarClone = clone();
        dVarClone.version = d10;
        return dVarClone;
    }

    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }
}
