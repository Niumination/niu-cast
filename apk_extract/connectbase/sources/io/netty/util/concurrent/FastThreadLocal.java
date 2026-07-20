package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class FastThreadLocal<V> {
    private final int index = InternalThreadLocalMap.nextVariableIndex();

    private static void addToVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Set setNewSetFromMap;
        int i10 = InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX;
        Object objIndexedVariable = internalThreadLocalMap.indexedVariable(i10);
        if (objIndexedVariable == InternalThreadLocalMap.UNSET || objIndexedVariable == null) {
            setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            internalThreadLocalMap.setIndexedVariable(i10, setNewSetFromMap);
        } else {
            setNewSetFromMap = (Set) objIndexedVariable;
        }
        setNewSetFromMap.add(fastThreadLocal);
    }

    public static void destroy() {
        InternalThreadLocalMap.destroy();
    }

    private V initialize(InternalThreadLocalMap internalThreadLocalMap) throws Throwable {
        V vInitialValue;
        try {
            vInitialValue = initialValue();
            try {
                if (vInitialValue == InternalThreadLocalMap.UNSET) {
                    throw new IllegalArgumentException("InternalThreadLocalMap.UNSET can not be initial value.");
                }
            } catch (Exception e10) {
                e = e10;
                PlatformDependent.throwException(e);
            }
        } catch (Exception e11) {
            e = e11;
            vInitialValue = null;
        }
        internalThreadLocalMap.setIndexedVariable(this.index, vInitialValue);
        addToVariablesToRemove(internalThreadLocalMap, this);
        return vInitialValue;
    }

    public static void removeAll() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return;
        }
        try {
            Object objIndexedVariable = ifSet.indexedVariable(InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX);
            if (objIndexedVariable != null && objIndexedVariable != InternalThreadLocalMap.UNSET) {
                for (FastThreadLocal fastThreadLocal : (FastThreadLocal[]) ((Set) objIndexedVariable).toArray(new FastThreadLocal[0])) {
                    fastThreadLocal.remove(ifSet);
                }
            }
        } finally {
            InternalThreadLocalMap.remove();
        }
    }

    private static void removeFromVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Object objIndexedVariable = internalThreadLocalMap.indexedVariable(InternalThreadLocalMap.VARIABLES_TO_REMOVE_INDEX);
        if (objIndexedVariable == InternalThreadLocalMap.UNSET || objIndexedVariable == null) {
            return;
        }
        ((Set) objIndexedVariable).remove(fastThreadLocal);
    }

    private void setKnownNotUnset(InternalThreadLocalMap internalThreadLocalMap, V v10) {
        if (internalThreadLocalMap.setIndexedVariable(this.index, v10)) {
            addToVariablesToRemove(internalThreadLocalMap, this);
        }
    }

    public static int size() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return 0;
        }
        return ifSet.size();
    }

    public final V get() {
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        V v10 = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v10 != InternalThreadLocalMap.UNSET ? v10 : initialize(internalThreadLocalMap);
    }

    public final V getIfExists() {
        V v10;
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null || (v10 = (V) ifSet.indexedVariable(this.index)) == InternalThreadLocalMap.UNSET) {
            return null;
        }
        return v10;
    }

    public V initialValue() throws Exception {
        return null;
    }

    public final boolean isSet() {
        return isSet(InternalThreadLocalMap.getIfSet());
    }

    public void onRemoval(V v10) throws Exception {
    }

    public final void remove() throws Throwable {
        remove(InternalThreadLocalMap.getIfSet());
    }

    public final void set(V v10) throws Throwable {
        if (v10 != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(InternalThreadLocalMap.get(), v10);
        } else {
            remove();
        }
    }

    public final boolean isSet(InternalThreadLocalMap internalThreadLocalMap) {
        return internalThreadLocalMap != null && internalThreadLocalMap.isIndexedVariableSet(this.index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void remove(InternalThreadLocalMap internalThreadLocalMap) throws Throwable {
        Object objRemoveIndexedVariable;
        if (internalThreadLocalMap == null || (objRemoveIndexedVariable = internalThreadLocalMap.removeIndexedVariable(this.index)) == InternalThreadLocalMap.UNSET) {
            return;
        }
        removeFromVariablesToRemove(internalThreadLocalMap, this);
        try {
            onRemoval(objRemoveIndexedVariable);
        } catch (Exception e10) {
            PlatformDependent.throwException(e10);
        }
    }

    public final V get(InternalThreadLocalMap internalThreadLocalMap) {
        V v10 = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v10 != InternalThreadLocalMap.UNSET ? v10 : initialize(internalThreadLocalMap);
    }

    public final void set(InternalThreadLocalMap internalThreadLocalMap, V v10) throws Throwable {
        if (v10 != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(internalThreadLocalMap, v10);
        } else {
            remove(internalThreadLocalMap);
        }
    }
}
