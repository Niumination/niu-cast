package i4;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class s2 extends ReentrantLock {
    volatile int count;
    final u3 map;
    int modCount;
    final AtomicInteger readCount = new AtomicInteger();
    volatile AtomicReferenceArray<p2> table;
    int threshold;

    public s2(u3 u3Var, int i8) {
        this.map = u3Var;
        initTable(newEntryArray(i8));
    }

    public static <K, V, E extends p2> boolean isCollected(E e) {
        return e.getValue() == null;
    }

    public abstract p2 castForTesting(p2 p2Var);

    public void clear() {
        if (this.count != 0) {
            lock();
            try {
                AtomicReferenceArray<p2> atomicReferenceArray = this.table;
                for (int i8 = 0; i8 < atomicReferenceArray.length(); i8++) {
                    atomicReferenceArray.set(i8, null);
                }
                maybeClearReferenceQueues();
                this.readCount.set(0);
                this.modCount++;
                this.count = 0;
            } finally {
                unlock();
            }
        }
    }

    public <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
        while (referenceQueue.poll() != null) {
        }
    }

    public boolean clearValueForTesting(Object obj, int i8, r3 r3Var) {
        lock();
        try {
            AtomicReferenceArray<p2> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i8;
            p2 p2Var = atomicReferenceArray.get(length);
            for (p2 p2VarC = p2Var; p2VarC != null; p2VarC = p2VarC.c()) {
                Object key = p2VarC.getKey();
                if (p2VarC.b() == i8 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                    if (((q3) p2VarC).a() != r3Var) {
                        return false;
                    }
                    atomicReferenceArray.set(length, removeFromChain(p2Var, p2VarC));
                    return true;
                }
            }
            return false;
        } finally {
            unlock();
        }
    }

    public boolean containsKey(Object obj, int i8) {
        try {
            boolean z2 = false;
            if (this.count == 0) {
                return false;
            }
            p2 liveEntry = getLiveEntry(obj, i8);
            if (liveEntry != null && liveEntry.getValue() != null) {
                z2 = true;
            }
            return z2;
        } finally {
            postReadCleanup();
        }
    }

    public boolean containsValue(Object obj) {
        try {
            if (this.count != 0) {
                AtomicReferenceArray<p2> atomicReferenceArray = this.table;
                int length = atomicReferenceArray.length();
                for (int i8 = 0; i8 < length; i8++) {
                    for (p2 p2VarC = atomicReferenceArray.get(i8); p2VarC != null; p2VarC = p2VarC.c()) {
                        Object liveValue = getLiveValue(p2VarC);
                        if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } finally {
            postReadCleanup();
        }
    }

    public p2 copyEntry(p2 p2Var, p2 p2Var2) {
        return this.map.entryHelper.f(self(), p2Var, p2Var2);
    }

    public p2 copyForTesting(p2 p2Var, p2 p2Var2) {
        return this.map.entryHelper.f(self(), castForTesting(p2Var), castForTesting(p2Var2));
    }

    public void drainKeyReferenceQueue(ReferenceQueue<Object> referenceQueue) {
        int i8 = 0;
        do {
            Object objPoll = referenceQueue.poll();
            if (objPoll == null) {
                return;
            }
            this.map.reclaimKey((p2) objPoll);
            i8++;
        } while (i8 != 16);
    }

    public void drainValueReferenceQueue(ReferenceQueue<Object> referenceQueue) {
        int i8 = 0;
        do {
            Object objPoll = referenceQueue.poll();
            if (objPoll == null) {
                return;
            }
            this.map.reclaimValue((r3) objPoll);
            i8++;
        } while (i8 != 16);
    }

    public void expand() {
        AtomicReferenceArray<p2> atomicReferenceArray = this.table;
        int length = atomicReferenceArray.length();
        if (length >= 1073741824) {
            return;
        }
        int i8 = this.count;
        AtomicReferenceArray<p2> atomicReferenceArrayNewEntryArray = newEntryArray(length << 1);
        this.threshold = (atomicReferenceArrayNewEntryArray.length() * 3) / 4;
        int length2 = atomicReferenceArrayNewEntryArray.length() - 1;
        for (int i9 = 0; i9 < length; i9++) {
            p2 p2VarC = atomicReferenceArray.get(i9);
            if (p2VarC != null) {
                p2 p2VarC2 = p2VarC.c();
                int iB = p2VarC.b() & length2;
                if (p2VarC2 == null) {
                    atomicReferenceArrayNewEntryArray.set(iB, p2VarC);
                } else {
                    p2 p2Var = p2VarC;
                    while (p2VarC2 != null) {
                        int iB2 = p2VarC2.b() & length2;
                        if (iB2 != iB) {
                            p2Var = p2VarC2;
                            iB = iB2;
                        }
                        p2VarC2 = p2VarC2.c();
                    }
                    atomicReferenceArrayNewEntryArray.set(iB, p2Var);
                    while (p2VarC != p2Var) {
                        int iB3 = p2VarC.b() & length2;
                        p2 p2VarCopyEntry = copyEntry(p2VarC, atomicReferenceArrayNewEntryArray.get(iB3));
                        if (p2VarCopyEntry != null) {
                            atomicReferenceArrayNewEntryArray.set(iB3, p2VarCopyEntry);
                        } else {
                            i8--;
                        }
                        p2VarC = p2VarC.c();
                    }
                }
            }
        }
        this.table = atomicReferenceArrayNewEntryArray;
        this.count = i8;
    }

    public Object get(Object obj, int i8) {
        try {
            p2 liveEntry = getLiveEntry(obj, i8);
            if (liveEntry == null) {
                return null;
            }
            Object value = liveEntry.getValue();
            if (value == null) {
                tryDrainReferenceQueues();
            }
            return value;
        } finally {
            postReadCleanup();
        }
    }

    public p2 getEntry(Object obj, int i8) {
        if (this.count == 0) {
            return null;
        }
        for (p2 first = getFirst(i8); first != null; first = first.c()) {
            if (first.b() == i8) {
                Object key = first.getKey();
                if (key == null) {
                    tryDrainReferenceQueues();
                } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                    return first;
                }
            }
        }
        return null;
    }

    public p2 getFirst(int i8) {
        AtomicReferenceArray<p2> atomicReferenceArray = this.table;
        return atomicReferenceArray.get(i8 & (atomicReferenceArray.length() - 1));
    }

    public ReferenceQueue<Object> getKeyReferenceQueueForTesting() {
        throw new AssertionError();
    }

    public p2 getLiveEntry(Object obj, int i8) {
        return getEntry(obj, i8);
    }

    public Object getLiveValue(p2 p2Var) {
        if (p2Var.getKey() == null) {
            tryDrainReferenceQueues();
            return null;
        }
        Object value = p2Var.getValue();
        if (value != null) {
            return value;
        }
        tryDrainReferenceQueues();
        return null;
    }

    public Object getLiveValueForTesting(p2 p2Var) {
        return getLiveValue(castForTesting(p2Var));
    }

    public ReferenceQueue<Object> getValueReferenceQueueForTesting() {
        throw new AssertionError();
    }

    public r3 getWeakValueReferenceForTesting(p2 p2Var) {
        throw new AssertionError();
    }

    public void initTable(AtomicReferenceArray<p2> atomicReferenceArray) {
        this.threshold = (atomicReferenceArray.length() * 3) / 4;
        this.table = atomicReferenceArray;
    }

    public void maybeClearReferenceQueues() {
    }

    public void maybeDrainReferenceQueues() {
    }

    public AtomicReferenceArray<p2> newEntryArray(int i8) {
        return new AtomicReferenceArray<>(i8);
    }

    public p2 newEntryForTesting(Object obj, int i8, p2 p2Var) {
        return this.map.entryHelper.c(self(), obj, i8, castForTesting(p2Var));
    }

    public r3 newWeakValueReferenceForTesting(p2 p2Var, Object obj) {
        throw new AssertionError();
    }

    public void postReadCleanup() {
        if ((this.readCount.incrementAndGet() & 63) == 0) {
            runCleanup();
        }
    }

    public void preWriteCleanup() {
        runLockedCleanup();
    }

    public Object put(Object obj, int i8, Object obj2, boolean z2) {
        lock();
        try {
            preWriteCleanup();
            int i9 = this.count + 1;
            if (i9 > this.threshold) {
                expand();
                i9 = this.count + 1;
            }
            AtomicReferenceArray<p2> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i8;
            p2 p2Var = atomicReferenceArray.get(length);
            for (p2 p2VarC = p2Var; p2VarC != null; p2VarC = p2VarC.c()) {
                Object key = p2VarC.getKey();
                if (p2VarC.b() == i8 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                    Object value = p2VarC.getValue();
                    if (value == null) {
                        this.modCount++;
                        setValue(p2VarC, obj2);
                        this.count = this.count;
                        return null;
                    }
                    if (z2) {
                        return value;
                    }
                    this.modCount++;
                    setValue(p2VarC, obj2);
                    return value;
                }
            }
            this.modCount++;
            p2 p2VarC2 = this.map.entryHelper.c(self(), obj, i8, p2Var);
            setValue(p2VarC2, obj2);
            atomicReferenceArray.set(length, p2VarC2);
            this.count = i9;
            return null;
        } finally {
            unlock();
        }
    }

    public boolean reclaimKey(p2 p2Var, int i8) {
        lock();
        try {
            AtomicReferenceArray<p2> atomicReferenceArray = this.table;
            int length = i8 & (atomicReferenceArray.length() - 1);
            p2 p2Var2 = atomicReferenceArray.get(length);
            for (p2 p2VarC = p2Var2; p2VarC != null; p2VarC = p2VarC.c()) {
                if (p2VarC == p2Var) {
                    this.modCount++;
                    p2 p2VarRemoveFromChain = removeFromChain(p2Var2, p2VarC);
                    int i9 = this.count - 1;
                    atomicReferenceArray.set(length, p2VarRemoveFromChain);
                    this.count = i9;
                    return true;
                }
            }
            return false;
        } finally {
            unlock();
        }
    }

    public boolean reclaimValue(Object obj, int i8, r3 r3Var) {
        lock();
        try {
            AtomicReferenceArray<p2> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i8;
            p2 p2Var = atomicReferenceArray.get(length);
            for (p2 p2VarC = p2Var; p2VarC != null; p2VarC = p2VarC.c()) {
                Object key = p2VarC.getKey();
                if (p2VarC.b() == i8 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                    if (((q3) p2VarC).a() != r3Var) {
                        return false;
                    }
                    this.modCount++;
                    p2 p2VarRemoveFromChain = removeFromChain(p2Var, p2VarC);
                    int i9 = this.count - 1;
                    atomicReferenceArray.set(length, p2VarRemoveFromChain);
                    this.count = i9;
                    return true;
                }
            }
            return false;
        } finally {
            unlock();
        }
    }

    public Object remove(Object obj, int i8) {
        lock();
        try {
            preWriteCleanup();
            AtomicReferenceArray<p2> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i8;
            p2 p2Var = atomicReferenceArray.get(length);
            for (p2 p2VarC = p2Var; p2VarC != null; p2VarC = p2VarC.c()) {
                Object key = p2VarC.getKey();
                if (p2VarC.b() == i8 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                    Object value = p2VarC.getValue();
                    if (value == null && !isCollected(p2VarC)) {
                        return null;
                    }
                    this.modCount++;
                    p2 p2VarRemoveFromChain = removeFromChain(p2Var, p2VarC);
                    int i9 = this.count - 1;
                    atomicReferenceArray.set(length, p2VarRemoveFromChain);
                    this.count = i9;
                    return value;
                }
            }
            return null;
        } finally {
            unlock();
        }
    }

    public boolean removeEntryForTesting(p2 p2Var) {
        int iB = p2Var.b();
        AtomicReferenceArray<p2> atomicReferenceArray = this.table;
        int length = iB & (atomicReferenceArray.length() - 1);
        p2 p2Var2 = atomicReferenceArray.get(length);
        for (p2 p2VarC = p2Var2; p2VarC != null; p2VarC = p2VarC.c()) {
            if (p2VarC == p2Var) {
                this.modCount++;
                p2 p2VarRemoveFromChain = removeFromChain(p2Var2, p2VarC);
                int i8 = this.count - 1;
                atomicReferenceArray.set(length, p2VarRemoveFromChain);
                this.count = i8;
                return true;
            }
        }
        return false;
    }

    public p2 removeFromChain(p2 p2Var, p2 p2Var2) {
        int i8 = this.count;
        p2 p2VarC = p2Var2.c();
        while (p2Var != p2Var2) {
            p2 p2VarCopyEntry = copyEntry(p2Var, p2VarC);
            if (p2VarCopyEntry != null) {
                p2VarC = p2VarCopyEntry;
            } else {
                i8--;
            }
            p2Var = p2Var.c();
        }
        this.count = i8;
        return p2VarC;
    }

    public p2 removeFromChainForTesting(p2 p2Var, p2 p2Var2) {
        return removeFromChain(castForTesting(p2Var), castForTesting(p2Var2));
    }

    public boolean removeTableEntryForTesting(p2 p2Var) {
        return removeEntryForTesting(castForTesting(p2Var));
    }

    public boolean replace(Object obj, int i8, Object obj2, Object obj3) {
        lock();
        try {
            preWriteCleanup();
            AtomicReferenceArray<p2> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i8;
            p2 p2Var = atomicReferenceArray.get(length);
            for (p2 p2VarC = p2Var; p2VarC != null; p2VarC = p2VarC.c()) {
                Object key = p2VarC.getKey();
                if (p2VarC.b() == i8 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                    Object value = p2VarC.getValue();
                    if (value != null) {
                        if (!this.map.valueEquivalence().equivalent(obj2, value)) {
                            return false;
                        }
                        this.modCount++;
                        setValue(p2VarC, obj3);
                        return true;
                    }
                    if (isCollected(p2VarC)) {
                        this.modCount++;
                        p2 p2VarRemoveFromChain = removeFromChain(p2Var, p2VarC);
                        int i9 = this.count - 1;
                        atomicReferenceArray.set(length, p2VarRemoveFromChain);
                        this.count = i9;
                    }
                    return false;
                }
            }
            return false;
        } finally {
            unlock();
        }
    }

    public void runCleanup() {
        runLockedCleanup();
    }

    public void runLockedCleanup() {
        if (tryLock()) {
            try {
                maybeDrainReferenceQueues();
                this.readCount.set(0);
            } finally {
                unlock();
            }
        }
    }

    public abstract s2 self();

    public void setTableEntryForTesting(int i8, p2 p2Var) {
        this.table.set(i8, castForTesting(p2Var));
    }

    public void setValue(p2 p2Var, Object obj) {
        this.map.entryHelper.e(self(), p2Var, obj);
    }

    public void setValueForTesting(p2 p2Var, Object obj) {
        this.map.entryHelper.e(self(), castForTesting(p2Var), obj);
    }

    public void setWeakValueReferenceForTesting(p2 p2Var, r3 r3Var) {
        throw new AssertionError();
    }

    public void tryDrainReferenceQueues() {
        if (tryLock()) {
            try {
                maybeDrainReferenceQueues();
            } finally {
                unlock();
            }
        }
    }

    public boolean remove(Object obj, int i8, Object obj2) {
        lock();
        try {
            preWriteCleanup();
            AtomicReferenceArray<p2> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i8;
            p2 p2Var = atomicReferenceArray.get(length);
            p2 p2VarC = p2Var;
            while (true) {
                boolean z2 = false;
                if (p2VarC == null) {
                    return false;
                }
                Object key = p2VarC.getKey();
                if (p2VarC.b() == i8 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                    if (this.map.valueEquivalence().equivalent(obj2, p2VarC.getValue())) {
                        z2 = true;
                    } else if (!isCollected(p2VarC)) {
                        return false;
                    }
                    this.modCount++;
                    p2 p2VarRemoveFromChain = removeFromChain(p2Var, p2VarC);
                    int i9 = this.count - 1;
                    atomicReferenceArray.set(length, p2VarRemoveFromChain);
                    this.count = i9;
                    return z2;
                }
                p2VarC = p2VarC.c();
            }
        } finally {
            unlock();
        }
    }

    public Object replace(Object obj, int i8, Object obj2) {
        lock();
        try {
            preWriteCleanup();
            AtomicReferenceArray<p2> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i8;
            p2 p2Var = atomicReferenceArray.get(length);
            for (p2 p2VarC = p2Var; p2VarC != null; p2VarC = p2VarC.c()) {
                Object key = p2VarC.getKey();
                if (p2VarC.b() == i8 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                    Object value = p2VarC.getValue();
                    if (value == null) {
                        if (isCollected(p2VarC)) {
                            this.modCount++;
                            p2 p2VarRemoveFromChain = removeFromChain(p2Var, p2VarC);
                            int i9 = this.count - 1;
                            atomicReferenceArray.set(length, p2VarRemoveFromChain);
                            this.count = i9;
                        }
                        return null;
                    }
                    this.modCount++;
                    setValue(p2VarC, obj2);
                    return value;
                }
            }
            return null;
        } finally {
            unlock();
        }
    }
}
