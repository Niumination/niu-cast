package rs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.spi.MDCAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class a implements MDCAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InheritableThreadLocal<Map<String, String>> f14849a = new C0368a();

    /* JADX INFO: renamed from: rs.a$a, reason: collision with other inner class name */
    public class C0368a extends InheritableThreadLocal<Map<String, String>> {
        public C0368a() {
        }

        @Override // java.lang.InheritableThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<String, String> childValue(Map<String, String> map) {
            if (map == null) {
                return null;
            }
            return new HashMap(map);
        }
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        Map<String, String> map = this.f14849a.get();
        if (map == null) {
            map = new HashMap<>();
            this.f14849a.set(map);
        }
        map.put(str, str2);
    }

    @Override // org.slf4j.spi.MDCAdapter
    public Map<String, String> b() {
        Map<String, String> map = this.f14849a.get();
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void c(Map<String, String> map) {
        this.f14849a.set(new HashMap(map));
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void clear() {
        Map<String, String> map = this.f14849a.get();
        if (map != null) {
            map.clear();
            this.f14849a.remove();
        }
    }

    public Set<String> d() {
        Map<String, String> map = this.f14849a.get();
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    @Override // org.slf4j.spi.MDCAdapter
    public String get(String str) {
        Map<String, String> map = this.f14849a.get();
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void remove(String str) {
        Map<String, String> map = this.f14849a.get();
        if (map != null) {
            map.remove(str);
        }
    }
}
