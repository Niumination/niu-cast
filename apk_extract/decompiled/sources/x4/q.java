package x4;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends AbstractMap implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new bb.o(3);
    private final boolean allowNullValues;
    private final Comparator<Object> comparator;
    private n entrySet;
    final p header;
    private o keySet;
    int modCount;
    p root;
    int size;

    public q() {
        this(NATURAL_ORDER, true);
    }

    private static boolean equal(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(p pVar, boolean z2) {
        while (pVar != null) {
            p pVar2 = pVar.f10852b;
            p pVar3 = pVar.f10853c;
            int i8 = pVar2 != null ? pVar2.f10858k : 0;
            int i9 = pVar3 != null ? pVar3.f10858k : 0;
            int i10 = i8 - i9;
            if (i10 == -2) {
                p pVar4 = pVar3.f10852b;
                p pVar5 = pVar3.f10853c;
                int i11 = (pVar4 != null ? pVar4.f10858k : 0) - (pVar5 != null ? pVar5.f10858k : 0);
                if (i11 == -1 || (i11 == 0 && !z2)) {
                    rotateLeft(pVar);
                } else {
                    rotateRight(pVar3);
                    rotateLeft(pVar);
                }
                if (z2) {
                    return;
                }
            } else if (i10 == 2) {
                p pVar6 = pVar2.f10852b;
                p pVar7 = pVar2.f10853c;
                int i12 = (pVar6 != null ? pVar6.f10858k : 0) - (pVar7 != null ? pVar7.f10858k : 0);
                if (i12 == 1 || (i12 == 0 && !z2)) {
                    rotateRight(pVar);
                } else {
                    rotateLeft(pVar2);
                    rotateRight(pVar);
                }
                if (z2) {
                    return;
                }
            } else if (i10 == 0) {
                pVar.f10858k = i8 + 1;
                if (z2) {
                    return;
                }
            } else {
                pVar.f10858k = Math.max(i8, i9) + 1;
                if (!z2) {
                    return;
                }
            }
            pVar = pVar.f10851a;
        }
    }

    private void replaceInParent(p pVar, p pVar2) {
        p pVar3 = pVar.f10851a;
        pVar.f10851a = null;
        if (pVar2 != null) {
            pVar2.f10851a = pVar3;
        }
        if (pVar3 == null) {
            this.root = pVar2;
        } else if (pVar3.f10852b == pVar) {
            pVar3.f10852b = pVar2;
        } else {
            pVar3.f10853c = pVar2;
        }
    }

    private void rotateLeft(p pVar) {
        p pVar2 = pVar.f10852b;
        p pVar3 = pVar.f10853c;
        p pVar4 = pVar3.f10852b;
        p pVar5 = pVar3.f10853c;
        pVar.f10853c = pVar4;
        if (pVar4 != null) {
            pVar4.f10851a = pVar;
        }
        replaceInParent(pVar, pVar3);
        pVar3.f10852b = pVar;
        pVar.f10851a = pVar3;
        int iMax = Math.max(pVar2 != null ? pVar2.f10858k : 0, pVar4 != null ? pVar4.f10858k : 0) + 1;
        pVar.f10858k = iMax;
        pVar3.f10858k = Math.max(iMax, pVar5 != null ? pVar5.f10858k : 0) + 1;
    }

    private void rotateRight(p pVar) {
        p pVar2 = pVar.f10852b;
        p pVar3 = pVar.f10853c;
        p pVar4 = pVar2.f10852b;
        p pVar5 = pVar2.f10853c;
        pVar.f10852b = pVar5;
        if (pVar5 != null) {
            pVar5.f10851a = pVar;
        }
        replaceInParent(pVar, pVar2);
        pVar2.f10853c = pVar;
        pVar.f10851a = pVar2;
        int iMax = Math.max(pVar3 != null ? pVar3.f10858k : 0, pVar5 != null ? pVar5.f10858k : 0) + 1;
        pVar.f10858k = iMax;
        pVar2.f10858k = Math.max(iMax, pVar4 != null ? pVar4.f10858k : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        p pVar = this.header;
        pVar.e = pVar;
        pVar.f10854d = pVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        n nVar = this.entrySet;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this);
        this.entrySet = nVar2;
        return nVar2;
    }

    public p find(Object obj, boolean z2) {
        int iCompareTo;
        p pVar;
        Comparator<Object> comparator = this.comparator;
        p pVar2 = this.root;
        if (pVar2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) obj : null;
            while (true) {
                Object obj2 = pVar2.f10855h;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return pVar2;
                }
                p pVar3 = iCompareTo < 0 ? pVar2.f10852b : pVar2.f10853c;
                if (pVar3 == null) {
                    break;
                }
                pVar2 = pVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z2) {
            return null;
        }
        p pVar4 = this.header;
        if (pVar2 != null) {
            pVar = new p(this.allowNullValues, pVar2, obj, pVar4, pVar4.e);
            if (iCompareTo < 0) {
                pVar2.f10852b = pVar;
            } else {
                pVar2.f10853c = pVar;
            }
            rebalance(pVar2, true);
        } else {
            if (comparator == NATURAL_ORDER && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            pVar = new p(this.allowNullValues, pVar2, obj, pVar4, pVar4.e);
            this.root = pVar;
        }
        this.size++;
        this.modCount++;
        return pVar;
    }

    public p findByEntry(Map.Entry<?, ?> entry) {
        p pVarFindByObject = findByObject(entry.getKey());
        if (pVarFindByObject == null || !equal(pVarFindByObject.f10857j, entry.getValue())) {
            return null;
        }
        return pVarFindByObject;
    }

    public p findByObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        p pVarFindByObject = findByObject(obj);
        if (pVarFindByObject != null) {
            return pVarFindByObject.f10857j;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Object> keySet() {
        o oVar = this.keySet;
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(this);
        this.keySet = oVar2;
        return oVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.allowNullValues) {
            throw new NullPointerException("value == null");
        }
        p pVarFind = find(obj, true);
        Object obj3 = pVarFind.f10857j;
        pVarFind.f10857j = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        p pVarRemoveInternalByKey = removeInternalByKey(obj);
        if (pVarRemoveInternalByKey != null) {
            return pVarRemoveInternalByKey.f10857j;
        }
        return null;
    }

    public void removeInternal(p pVar, boolean z2) {
        p pVar2;
        p pVar3;
        int i8;
        if (z2) {
            p pVar4 = pVar.e;
            pVar4.f10854d = pVar.f10854d;
            pVar.f10854d.e = pVar4;
        }
        p pVar5 = pVar.f10852b;
        p pVar6 = pVar.f10853c;
        p pVar7 = pVar.f10851a;
        int i9 = 0;
        if (pVar5 == null || pVar6 == null) {
            if (pVar5 != null) {
                replaceInParent(pVar, pVar5);
                pVar.f10852b = null;
            } else if (pVar6 != null) {
                replaceInParent(pVar, pVar6);
                pVar.f10853c = null;
            } else {
                replaceInParent(pVar, null);
            }
            rebalance(pVar7, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (pVar5.f10858k > pVar6.f10858k) {
            p pVar8 = pVar5.f10853c;
            while (true) {
                p pVar9 = pVar8;
                pVar3 = pVar5;
                pVar5 = pVar9;
                if (pVar5 == null) {
                    break;
                } else {
                    pVar8 = pVar5.f10853c;
                }
            }
        } else {
            p pVar10 = pVar6.f10852b;
            while (true) {
                pVar2 = pVar6;
                pVar6 = pVar10;
                if (pVar6 == null) {
                    break;
                } else {
                    pVar10 = pVar6.f10852b;
                }
            }
            pVar3 = pVar2;
        }
        removeInternal(pVar3, false);
        p pVar11 = pVar.f10852b;
        if (pVar11 != null) {
            i8 = pVar11.f10858k;
            pVar3.f10852b = pVar11;
            pVar11.f10851a = pVar3;
            pVar.f10852b = null;
        } else {
            i8 = 0;
        }
        p pVar12 = pVar.f10853c;
        if (pVar12 != null) {
            i9 = pVar12.f10858k;
            pVar3.f10853c = pVar12;
            pVar12.f10851a = pVar3;
            pVar.f10853c = null;
        }
        pVar3.f10858k = Math.max(i8, i9) + 1;
        replaceInParent(pVar, pVar3);
    }

    public p removeInternalByKey(Object obj) {
        p pVarFindByObject = findByObject(obj);
        if (pVarFindByObject != null) {
            removeInternal(pVarFindByObject, true);
        }
        return pVarFindByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public q(boolean z2) {
        this(NATURAL_ORDER, z2);
    }

    public q(Comparator<Object> comparator, boolean z2) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.allowNullValues = z2;
        this.header = new p(z2);
    }
}
