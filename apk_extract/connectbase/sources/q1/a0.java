package q1;

import f1.t4;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@o0
@b1.d
public final class a0<K> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Map<K, Long> f13403a;
    private final ConcurrentHashMap<K, AtomicLong> map;

    public class a implements c1.t<AtomicLong, Long> {
        public a(final a0 this$0) {
        }

        @Override // c1.t
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long apply(AtomicLong atomic) {
            return Long.valueOf(atomic.get());
        }
    }

    public a0(ConcurrentHashMap<K, AtomicLong> map) {
        map.getClass();
        this.map = map;
    }

    public static <K> a0<K> create() {
        return new a0<>(new ConcurrentHashMap());
    }

    public final Map<K, Long> a() {
        return Collections.unmodifiableMap(t4.B0(this.map, new a()));
    }

    @t1.a
    public long addAndGet(K key, long delta) {
        AtomicLong atomicLongPutIfAbsent;
        long j10;
        long j11;
        do {
            atomicLongPutIfAbsent = this.map.get(key);
            if (atomicLongPutIfAbsent == null && (atomicLongPutIfAbsent = this.map.putIfAbsent(key, new AtomicLong(delta))) == null) {
                return delta;
            }
            do {
                j10 = atomicLongPutIfAbsent.get();
                if (j10 != 0) {
                    j11 = j10 + delta;
                }
            } while (!atomicLongPutIfAbsent.compareAndSet(j10, j11));
            return j11;
        } while (!this.map.replace(key, atomicLongPutIfAbsent, new AtomicLong(delta)));
        return delta;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map = this.f13403a;
        if (map != null) {
            return map;
        }
        Map<K, Long> mapA = a();
        this.f13403a = mapA;
        return mapA;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    @t1.a
    public long decrementAndGet(K key) {
        return addAndGet(key, -1L);
    }

    public long get(K key) {
        AtomicLong atomicLong = this.map.get(key);
        if (atomicLong == null) {
            return 0L;
        }
        return atomicLong.get();
    }

    @t1.a
    public long getAndAdd(K key, long delta) {
        AtomicLong atomicLongPutIfAbsent;
        long j10;
        do {
            atomicLongPutIfAbsent = this.map.get(key);
            if (atomicLongPutIfAbsent == null && (atomicLongPutIfAbsent = this.map.putIfAbsent(key, new AtomicLong(delta))) == null) {
                return 0L;
            }
            do {
                j10 = atomicLongPutIfAbsent.get();
                if (j10 == 0) {
                }
            } while (!atomicLongPutIfAbsent.compareAndSet(j10, j10 + delta));
            return j10;
        } while (!this.map.replace(key, atomicLongPutIfAbsent, new AtomicLong(delta)));
        return 0L;
    }

    @t1.a
    public long getAndDecrement(K key) {
        return getAndAdd(key, -1L);
    }

    @t1.a
    public long getAndIncrement(K key) {
        return getAndAdd(key, 1L);
    }

    @t1.a
    public long incrementAndGet(K key) {
        return addAndGet(key, 1L);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @t1.a
    public long put(K key, long newValue) {
        AtomicLong atomicLongPutIfAbsent;
        long j10;
        do {
            atomicLongPutIfAbsent = this.map.get(key);
            if (atomicLongPutIfAbsent == null && (atomicLongPutIfAbsent = this.map.putIfAbsent(key, new AtomicLong(newValue))) == null) {
                return 0L;
            }
            do {
                j10 = atomicLongPutIfAbsent.get();
                if (j10 == 0) {
                }
            } while (!atomicLongPutIfAbsent.compareAndSet(j10, newValue));
            return j10;
        } while (!this.map.replace(key, atomicLongPutIfAbsent, new AtomicLong(newValue)));
        return 0L;
    }

    public void putAll(Map<? extends K, ? extends Long> m10) {
        for (Map.Entry<? extends K, ? extends Long> entry : m10.entrySet()) {
            put(entry.getKey(), entry.getValue().longValue());
        }
    }

    public long putIfAbsent(K key, long newValue) {
        AtomicLong atomicLongPutIfAbsent;
        do {
            atomicLongPutIfAbsent = this.map.get(key);
            if (atomicLongPutIfAbsent == null && (atomicLongPutIfAbsent = this.map.putIfAbsent(key, new AtomicLong(newValue))) == null) {
                return 0L;
            }
            long j10 = atomicLongPutIfAbsent.get();
            if (j10 != 0) {
                return j10;
            }
        } while (!this.map.replace(key, atomicLongPutIfAbsent, new AtomicLong(newValue)));
        return 0L;
    }

    @t1.a
    public long remove(K key) {
        long j10;
        AtomicLong atomicLong = this.map.get(key);
        if (atomicLong == null) {
            return 0L;
        }
        do {
            j10 = atomicLong.get();
            if (j10 == 0) {
                break;
            }
        } while (!atomicLong.compareAndSet(j10, 0L));
        this.map.remove(key, atomicLong);
        return j10;
    }

    public void removeAllZeros() {
        Iterator<Map.Entry<K, AtomicLong>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            AtomicLong value = it.next().getValue();
            if (value != null && value.get() == 0) {
                it.remove();
            }
        }
    }

    @t1.a
    public boolean removeIfZero(K key) {
        return remove(key, 0L);
    }

    public boolean replace(K key, long expectedOldValue, long newValue) {
        if (expectedOldValue == 0) {
            return putIfAbsent(key, newValue) == 0;
        }
        AtomicLong atomicLong = this.map.get(key);
        if (atomicLong == null) {
            return false;
        }
        return atomicLong.compareAndSet(expectedOldValue, newValue);
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        Iterator<AtomicLong> it = this.map.values().iterator();
        long j10 = 0;
        while (it.hasNext()) {
            j10 += it.next().get();
        }
        return j10;
    }

    public String toString() {
        return this.map.toString();
    }

    public static <K> a0<K> create(Map<? extends K, ? extends Long> m10) {
        a0<K> a0VarCreate = create();
        a0VarCreate.putAll(m10);
        return a0VarCreate;
    }

    public boolean remove(K key, long value) {
        AtomicLong atomicLong = this.map.get(key);
        if (atomicLong == null) {
            return false;
        }
        long j10 = atomicLong.get();
        if (j10 != value) {
            return false;
        }
        if (j10 != 0 && !atomicLong.compareAndSet(j10, 0L)) {
            return false;
        }
        this.map.remove(key, atomicLong);
        return true;
    }
}
