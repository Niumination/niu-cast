package ik;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import k3.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements ck.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList f5908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f5909b;

    public v(ck.j jVar) {
        LinkedList linkedList = new LinkedList();
        this.f5908a = linkedList;
        linkedList.add(jVar);
    }

    public final void a(ck.j jVar) {
        if (jVar.isUnsubscribed()) {
            return;
        }
        if (!this.f5909b) {
            synchronized (this) {
                try {
                    if (!this.f5909b) {
                        LinkedList linkedList = this.f5908a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f5908a = linkedList;
                        }
                        linkedList.add(jVar);
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        jVar.unsubscribe();
    }

    @Override // ck.j
    public final boolean isUnsubscribed() {
        return this.f5909b;
    }

    @Override // ck.j
    public final void unsubscribe() {
        if (this.f5909b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f5909b) {
                    return;
                }
                this.f5909b = true;
                LinkedList linkedList = this.f5908a;
                ArrayList arrayList = null;
                this.f5908a = null;
                if (linkedList == null) {
                    return;
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    try {
                        ((ck.j) it.next()).unsubscribe();
                    } catch (Throwable th2) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th2);
                    }
                }
                x1.a(arrayList);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
