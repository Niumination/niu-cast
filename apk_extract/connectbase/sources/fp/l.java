package fp;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class l extends m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f6261e;

    public static class b<K> implements Map.Entry<K, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map.Entry<K, l> f6262a;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f6262a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            l value = this.f6262a.getValue();
            if (value == null) {
                return null;
            }
            return value.e();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof q) {
                return this.f6262a.getValue().d((q) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        public b(Map.Entry<K, l> entry) {
            this.f6262a = entry;
        }
    }

    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<Map.Entry<K, Object>> f6263a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f6263a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f6263a.next();
            return next.getValue() instanceof l ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6263a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f6263a.remove();
        }
    }

    public q e() {
        return c(this.f6261e);
    }

    public boolean equals(Object obj) {
        return e().equals(obj);
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e().toString();
    }
}
