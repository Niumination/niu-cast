package x4;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import v4.p0;
import v4.q0;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements q0, Cloneable {
    public static final d DEFAULT = new d();
    private static final double IGNORE_VERSIONS = -1.0d;
    private boolean requireExpose;
    private double version = IGNORE_VERSIONS;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;
    private List<v4.a> serializationStrategies = Collections.emptyList();
    private List<v4.a> deserializationStrategies = Collections.emptyList();

    private static boolean isInnerClass(Class<?> cls) {
        return cls.isMemberClass() && !a5.d.isStatic(cls);
    }

    private boolean isValidSince(w4.c cVar) {
        if (cVar != null) {
            return this.version >= cVar.value();
        }
        return true;
    }

    private boolean isValidUntil(w4.d dVar) {
        if (dVar != null) {
            return this.version < dVar.value();
        }
        return true;
    }

    private boolean isValidVersion(w4.c cVar, w4.d dVar) {
        return isValidSince(cVar) && isValidUntil(dVar);
    }

    @Override // v4.q0
    public <T> p0 create(v4.q qVar, c5.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean zExcludeClass = excludeClass(rawType, true);
        boolean zExcludeClass2 = excludeClass(rawType, false);
        if (zExcludeClass || zExcludeClass2) {
            return new c(this, zExcludeClass2, zExcludeClass, qVar, aVar);
        }
        return null;
    }

    public d disableInnerClassSerialization() {
        d dVarClone = clone();
        dVarClone.serializeInnerClasses = false;
        return dVarClone;
    }

    public boolean excludeClass(Class<?> cls, boolean z2) {
        if (this.version != IGNORE_VERSIONS && !isValidVersion((w4.c) cls.getAnnotation(w4.c.class), (w4.d) cls.getAnnotation(w4.d.class))) {
            return true;
        }
        if (!this.serializeInnerClasses && isInnerClass(cls)) {
            return true;
        }
        if (!z2 && !Enum.class.isAssignableFrom(cls) && a5.d.isAnonymousOrNonStaticLocal(cls)) {
            return true;
        }
        Iterator<v4.a> it = (z2 ? this.serializationStrategies : this.deserializationStrategies).iterator();
        if (!it.hasNext()) {
            return false;
        }
        o.d.y(it.next());
        throw null;
    }

    public boolean excludeField(Field field, boolean z2) {
        w4.a aVar;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != IGNORE_VERSIONS && !isValidVersion((w4.c) field.getAnnotation(w4.c.class), (w4.d) field.getAnnotation(w4.d.class))) || field.isSynthetic()) {
            return true;
        }
        if ((this.requireExpose && ((aVar = (w4.a) field.getAnnotation(w4.a.class)) == null || (!z2 ? aVar.deserialize() : aVar.serialize()))) || excludeClass(field.getType(), z2)) {
            return true;
        }
        List<v4.a> list = z2 ? this.serializationStrategies : this.deserializationStrategies;
        if (list.isEmpty()) {
            return false;
        }
        new v4.b(field);
        Iterator<v4.a> it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        o.d.y(it.next());
        throw null;
    }

    public d excludeFieldsWithoutExposeAnnotation() {
        d dVarClone = clone();
        dVarClone.requireExpose = true;
        return dVarClone;
    }

    public d withExclusionStrategy(v4.a aVar, boolean z2, boolean z3) {
        d dVarClone = clone();
        if (z2) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            dVarClone.serializationStrategies = arrayList;
            arrayList.add(aVar);
        }
        if (z3) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            dVarClone.deserializationStrategies = arrayList2;
            arrayList2.add(aVar);
        }
        return dVarClone;
    }

    public d withModifiers(int... iArr) {
        d dVarClone = clone();
        dVarClone.modifiers = 0;
        for (int i8 : iArr) {
            dVarClone.modifiers = i8 | dVarClone.modifiers;
        }
        return dVarClone;
    }

    public d withVersion(double d7) {
        d dVarClone = clone();
        dVarClone.version = d7;
        return dVarClone;
    }

    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
