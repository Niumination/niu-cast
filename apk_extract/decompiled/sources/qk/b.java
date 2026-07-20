package qk;

import ck.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import k3.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet f9238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f9239b;

    public static void c(Set set) {
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                ((j) it.next()).unsubscribe();
            } catch (Throwable th2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th2);
            }
        }
        x1.a(arrayList);
    }

    public final void a(j jVar) {
        if (jVar.isUnsubscribed()) {
            return;
        }
        if (!this.f9239b) {
            synchronized (this) {
                try {
                    if (!this.f9239b) {
                        if (this.f9238a == null) {
                            this.f9238a = new HashSet(4);
                        }
                        this.f9238a.add(jVar);
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        jVar.unsubscribe();
    }

    public final void b(j jVar) {
        HashSet hashSet;
        if (this.f9239b) {
            return;
        }
        synchronized (this) {
            if (!this.f9239b && (hashSet = this.f9238a) != null) {
                boolean zRemove = hashSet.remove(jVar);
                if (zRemove) {
                    jVar.unsubscribe();
                }
            }
        }
    }

    @Override // ck.j
    public final boolean isUnsubscribed() {
        return this.f9239b;
    }

    @Override // ck.j
    public final void unsubscribe() {
        if (this.f9239b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f9239b) {
                    return;
                }
                this.f9239b = true;
                HashSet hashSet = this.f9238a;
                this.f9238a = null;
                c(hashSet);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
