package hf;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import k3.a0;
import k3.i0;
import ze.p1;
import ze.q2;
import ze.s2;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5304d;
    public Object e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Serializable f5305h;

    public g(k3.p pVar) {
        this.f5301a = 1;
        this.f5305h = pVar;
        this.f5303c = pVar.f6568d.entrySet().iterator();
        this.f5302b = null;
        this.f5304d = null;
        this.e = i0.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    @Override // java.util.Iterator
    public final boolean hasNext() throws Throwable {
        Object objTake;
        switch (this.f5301a) {
            case 0:
                break;
            default:
                return ((Iterator) this.f5303c).hasNext() || ((Iterator) this.e).hasNext();
        }
        while (true) {
            Object obj = this.f5302b;
            boolean z2 = true;
            boolean z3 = false;
            if (obj != null) {
                if (!(obj instanceof s2)) {
                    return obj != this;
                }
                s2 s2Var = (s2) obj;
                q2 status = s2Var.getStatus();
                p1 trailers = s2Var.getTrailers();
                status.getClass();
                throw new s2(status, trailers);
            }
            ArrayBlockingQueue arrayBlockingQueue = (ArrayBlockingQueue) this.f5303c;
            ze.j jVar = (ze.j) this.e;
            m mVar = (m) this.f5305h;
            if (mVar == null) {
                while (true) {
                    try {
                        try {
                            objTake = arrayBlockingQueue.take();
                            if (z3) {
                                Thread.currentThread().interrupt();
                            }
                        } catch (InterruptedException e) {
                            try {
                                jVar.a("Thread interrupted", e);
                                z3 = true;
                            } catch (Throwable th2) {
                                th = th2;
                                if (z2) {
                                    Thread.currentThread().interrupt();
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z2 = z3;
                        if (z2) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                }
            } else {
                while (true) {
                    Object objPoll = arrayBlockingQueue.poll();
                    if (objPoll == null) {
                        try {
                            mVar.waitAndDrain();
                        } catch (InterruptedException e4) {
                            jVar.a("Thread interrupted", e4);
                            z3 = true;
                        }
                    } else {
                        if (objPoll == this || (objPoll instanceof s2)) {
                            mVar.shutdown();
                        }
                        if (z3) {
                            Thread.currentThread().interrupt();
                        }
                        objTake = objPoll;
                    }
                }
            }
            this.f5302b = objTake;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f5301a) {
            case 0:
                Object obj = this.f5302b;
                if (!(obj instanceof s2) && obj != this) {
                    ((ze.j) this.e).d(1);
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object obj2 = this.f5302b;
                this.f5302b = null;
                return obj2;
            default:
                if (!((Iterator) this.e).hasNext()) {
                    Map.Entry entry = (Map.Entry) ((Iterator) this.f5303c).next();
                    this.f5302b = entry.getKey();
                    Collection collection = (Collection) entry.getValue();
                    this.f5304d = collection;
                    this.e = collection.iterator();
                }
                return new a0(this.f5302b, ((Iterator) this.e).next());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f5301a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                ((Iterator) this.e).remove();
                Collection collection = (Collection) this.f5304d;
                collection.getClass();
                if (collection.isEmpty()) {
                    ((Iterator) this.f5303c).remove();
                }
                ((k3.p) this.f5305h).e--;
                return;
        }
    }

    public g(ze.j jVar, m mVar) {
        this.f5301a = 0;
        this.f5303c = new ArrayBlockingQueue(3);
        this.f5304d = new f(this);
        this.e = jVar;
        this.f5305h = mVar;
    }
}
