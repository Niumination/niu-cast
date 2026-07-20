package rs;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.IMarkerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class c implements IMarkerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<String, ps.d> f14854a = new ConcurrentHashMap();

    @Override // org.slf4j.IMarkerFactory
    public ps.d a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Marker name cannot be null");
        }
        ps.d dVar = this.f14854a.get(str);
        if (dVar != null) {
            return dVar;
        }
        b bVar = new b(str);
        ps.d dVarPutIfAbsent = this.f14854a.putIfAbsent(str, bVar);
        return dVarPutIfAbsent != null ? dVarPutIfAbsent : bVar;
    }

    @Override // org.slf4j.IMarkerFactory
    public boolean b(String str) {
        return (str == null || this.f14854a.remove(str) == null) ? false : true;
    }

    @Override // org.slf4j.IMarkerFactory
    public ps.d c(String str) {
        return new b(str);
    }

    @Override // org.slf4j.IMarkerFactory
    public boolean d(String str) {
        if (str == null) {
            return false;
        }
        return this.f14854a.containsKey(str);
    }
}
