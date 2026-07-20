package o4;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class p implements u4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set f8395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set f8396b;

    @Override // u4.a
    public final Object get() {
        if (this.f8396b == null) {
            synchronized (this) {
                try {
                    if (this.f8396b == null) {
                        this.f8396b = Collections.newSetFromMap(new ConcurrentHashMap());
                        synchronized (this) {
                            try {
                                Iterator it = this.f8395a.iterator();
                                while (it.hasNext()) {
                                    this.f8396b.add(((u4.a) it.next()).get());
                                }
                                this.f8395a = null;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return Collections.unmodifiableSet(this.f8396b);
    }
}
