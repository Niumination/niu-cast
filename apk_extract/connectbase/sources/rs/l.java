package rs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class l implements ILoggerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14870a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, k> f14871b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<qs.e> f14872c = new LinkedBlockingQueue<>();

    @Override // org.slf4j.ILoggerFactory
    public synchronized ps.a a(String str) {
        k kVar;
        kVar = this.f14871b.get(str);
        if (kVar == null) {
            kVar = new k(str, this.f14872c, this.f14870a);
            this.f14871b.put(str, kVar);
        }
        return kVar;
    }

    public void b() {
        this.f14871b.clear();
        this.f14872c.clear();
    }

    public LinkedBlockingQueue<qs.e> c() {
        return this.f14872c;
    }

    public List<String> d() {
        return new ArrayList(this.f14871b.keySet());
    }

    public List<k> e() {
        return new ArrayList(this.f14871b.values());
    }

    public void f() {
        this.f14870a = true;
    }
}
