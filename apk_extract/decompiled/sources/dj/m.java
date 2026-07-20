package dj;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements f2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f4609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4612d;

    public /* synthetic */ m(Object obj, Object obj2, Object obj3, Object obj4) {
        this.f4609a = obj;
        this.f4610b = obj2;
        this.f4611c = obj3;
        this.f4612d = obj4;
    }

    public IOException a(boolean z2, boolean z3, IOException ioe) {
        if (ioe != null) {
            g(ioe);
        }
        hj.i call = (hj.i) this.f4610b;
        if (z3) {
            if (ioe != null) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(ioe, "ioe");
            } else {
                Intrinsics.checkNotNullParameter(call, "call");
            }
        }
        if (z2) {
            if (ioe != null) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(ioe, "ioe");
            } else {
                Intrinsics.checkNotNullParameter(call, "call");
            }
        }
        return call.h(this, z3, z2, ioe);
    }

    public void b(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            Unit unit = Unit.INSTANCE;
        }
        e();
    }

    public void c(hj.f call) {
        Intrinsics.checkNotNullParameter(call, "call");
        call.f5438a.decrementAndGet();
        b((ArrayDeque) this.f4611c, call);
    }

    public j5.c d(String str) {
        if (!((ConcurrentHashMap) this.f4612d).containsKey(str)) {
            synchronized (this) {
                try {
                    if (!((ConcurrentHashMap) this.f4612d).containsKey(str)) {
                        try {
                            InputStream inputStreamA = ((i5.a) this.f4609a).a(str);
                            ((i5.b) this.f4610b).getClass();
                            for (e5.j jVar : i5.b.a(inputStreamA)) {
                                j5.a aVar = (j5.a) this.f4611c;
                                ka.d dVar = aVar.f6106b;
                                if (((String) ((j5.b) dVar.f6817b).a(jVar)).equals("001")) {
                                    aVar.f6105a.a(jVar);
                                } else {
                                    dVar.a(jVar);
                                }
                            }
                            ((ConcurrentHashMap) this.f4612d).put(str, str);
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            throw new IllegalStateException("Failed to read file " + str, e);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return (j5.a) this.f4611c;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006e  */
    /* JADX WARN: Code duplicated, block: B:27:0x007b A[Catch: all -> 0x00ae, TryCatch #4 {all -> 0x00ae, blocks: (B:25:0x0075, B:27:0x007b, B:30:0x00b0), top: B:55:0x0075 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x007b, please report this as an issue */
    public void e() {
        int size;
        int i8;
        hj.f fVar;
        byte[] bArr = ej.b.f4964a;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = ((ArrayDeque) this.f4610b).iterator();
                Intrinsics.checkNotNullExpressionValue(it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    hj.f asyncCall = (hj.f) it.next();
                    if (((ArrayDeque) this.f4611c).size() >= 64) {
                        break;
                    }
                    if (asyncCall.f5438a.get() < 5) {
                        it.remove();
                        asyncCall.f5438a.incrementAndGet();
                        Intrinsics.checkNotNullExpressionValue(asyncCall, "asyncCall");
                        arrayList.add(asyncCall);
                        ((ArrayDeque) this.f4611c).add(asyncCall);
                    }
                }
                synchronized (this) {
                    ((ArrayDeque) this.f4611c).size();
                    ((ArrayDeque) this.f4612d).size();
                }
                size = arrayList.size();
                for (i8 = 0; i8 < size; i8++) {
                    fVar = (hj.f) arrayList.get(i8);
                    synchronized (this) {
                        try {
                            if (((ThreadPoolExecutor) this.f4609a) == null) {
                                TimeUnit timeUnit = TimeUnit.SECONDS;
                                SynchronousQueue synchronousQueue = new SynchronousQueue();
                                String name = ej.b.f4968g + " Dispatcher";
                                Intrinsics.checkNotNullParameter(name, "name");
                                this.f4609a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new ej.a(name, false));
                            }
                            ThreadPoolExecutor executorService = (ThreadPoolExecutor) this.f4609a;
                            Intrinsics.checkNotNull(executorService);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    fVar.getClass();
                    Intrinsics.checkNotNullParameter(executorService, "executorService");
                    hj.i iVar = fVar.f5440c;
                    m mVar = iVar.p.f4495a;
                    byte[] bArr2 = ej.b.f4964a;
                    try {
                        try {
                            executorService.execute(fVar);
                        } catch (RejectedExecutionException e) {
                            InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                            interruptedIOException.initCause(e);
                            iVar.i(interruptedIOException);
                            fVar.f5439b.b(interruptedIOException);
                            iVar.p.f4495a.c(fVar);
                        }
                    } catch (Throwable th3) {
                        iVar.p.f4495a.c(fVar);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        Unit unit = Unit.INSTANCE;
        size = arrayList.size();
        while (i8 < size) {
            fVar = (hj.f) arrayList.get(i8);
            synchronized (this) {
                if (((ThreadPoolExecutor) this.f4609a) == null) {
                    TimeUnit timeUnit2 = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue2 = new SynchronousQueue();
                    String name2 = ej.b.f4968g + " Dispatcher";
                    Intrinsics.checkNotNullParameter(name2, "name");
                    this.f4609a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit2, synchronousQueue2, new ej.a(name2, false));
                }
                ThreadPoolExecutor executorService2 = (ThreadPoolExecutor) this.f4609a;
                Intrinsics.checkNotNull(executorService2);
                fVar.getClass();
                Intrinsics.checkNotNullParameter(executorService2, "executorService");
                hj.i iVar2 = fVar.f5440c;
                m mVar2 = iVar2.p.f4495a;
                byte[] bArr3 = ej.b.f4964a;
                executorService2.execute(fVar);
            }
        }
    }

    public i0 f(boolean z2) throws IOException {
        try {
            i0 i0VarG = ((ij.d) this.f4612d).g(z2);
            if (i0VarG != null) {
                Intrinsics.checkNotNullParameter(this, "deferredTrailers");
                i0VarG.f4571m = this;
            }
            return i0VarG;
        } catch (IOException ioe) {
            hj.i call = (hj.i) this.f4610b;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(ioe, "ioe");
            g(ioe);
            throw ioe;
        }
    }

    public void g(IOException iOException) {
        ((hj.e) this.f4611c).c(iOException);
        hj.m mVarB = ((ij.d) this.f4612d).b();
        hj.i call = (hj.i) this.f4610b;
        synchronized (mVarB) {
            try {
                Intrinsics.checkNotNullParameter(call, "call");
                if (!(iOException instanceof kj.f0)) {
                    if (!(mVarB.f != null) || (iOException instanceof kj.a)) {
                        mVarB.f5460i = true;
                        if (mVarB.f5463l == 0) {
                            hj.m.d(call.p, mVarB.q, iOException);
                            mVarB.f5462k++;
                        }
                    }
                } else if (((kj.f0) iOException).errorCode == kj.c.REFUSED_STREAM) {
                    int i8 = mVarB.f5464m + 1;
                    mVarB.f5464m = i8;
                    if (i8 > 1) {
                        mVarB.f5460i = true;
                        mVarB.f5462k++;
                    }
                } else if (((kj.f0) iOException).errorCode != kj.c.CANCEL || !call.f5452m) {
                    mVarB.f5460i = true;
                    mVarB.f5462k++;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // yh.a
    public Object get() {
        return new i2.j((Executor) ((yh.a) this.f4609a).get(), (j2.c) ((yh.a) this.f4610b).get(), (i2.d) ((u6.a) this.f4611c).get(), (k2.c) ((yh.a) this.f4612d).get());
    }

    public m() {
        this.f4610b = new ArrayDeque();
        this.f4611c = new ArrayDeque();
        this.f4612d = new ArrayDeque();
    }

    public m(hj.i call, hj.e finder, ij.d codec) {
        l eventListener = l.f4605d;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.f4610b = call;
        this.f4611c = finder;
        this.f4612d = codec;
        this.f4609a = codec.b();
    }

    public m(i5.a aVar, i5.b bVar, j5.a aVar2) {
        this.f4609a = aVar;
        this.f4610b = bVar;
        this.f4611c = aVar2;
        this.f4612d = new ConcurrentHashMap();
    }
}
