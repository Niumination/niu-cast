package we;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l1.c f10725b = new l1.c(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f10726a;

    public g(boolean z2, String threadName) {
        Object next;
        HandlerThread handlerThread;
        f fVar;
        Object next2;
        StringBuilder sb2;
        HandlerThread handlerThread2;
        StringBuilder sb3;
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        if (z2) {
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper(...)");
            fVar = new f(this, mainLooper);
        } else {
            l1.c cVar = f10725b;
            synchronized (cVar) {
                try {
                    Iterator it = cVar.f7096a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        HandlerThread handlerThread3 = (HandlerThread) next;
                        String name = handlerThread3.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        if (StringsKt__StringsJVMKt.startsWith$default(name, threadName == null ? "NearThreadHandler" : threadName, false, 2, null) && handlerThread3.isAlive()) {
                            break;
                        }
                    }
                    handlerThread = (HandlerThread) next;
                    if (handlerThread != null) {
                        Log.i("HandlerThreadPool", "HandlerThread count: " + cVar.f7096a.size());
                    } else {
                        if (cVar.f7096a.size() < 32) {
                            if (threadName != null) {
                                int size = cVar.f7096a.size() + 1;
                                sb3 = new StringBuilder();
                                sb3.append(threadName);
                                sb3.append("-");
                                sb3.append(size);
                            } else {
                                int size2 = cVar.f7096a.size() + 1;
                                sb3 = new StringBuilder();
                                sb3.append("NearThreadHandler");
                                sb3.append("-");
                                sb3.append(size2);
                            }
                            handlerThread2 = new HandlerThread(sb3.toString());
                            handlerThread2.start();
                            cVar.f7096a.add(handlerThread2);
                        } else {
                            Iterator it2 = cVar.f7096a.iterator();
                            do {
                                if (!it2.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it2.next();
                            } while (((HandlerThread) next2).isAlive());
                            HandlerThread handlerThread4 = (HandlerThread) next2;
                            if (handlerThread4 != null) {
                                cVar.f7096a.remove(handlerThread4);
                                if (threadName != null) {
                                    int size3 = cVar.f7096a.size() + 1;
                                    sb2 = new StringBuilder();
                                    sb2.append(threadName);
                                    sb2.append("-");
                                    sb2.append(size3);
                                } else {
                                    int size4 = cVar.f7096a.size() + 1;
                                    sb2 = new StringBuilder();
                                    sb2.append("NearThreadHandler");
                                    sb2.append("-");
                                    sb2.append(size4);
                                }
                                handlerThread2 = new HandlerThread(sb2.toString());
                                handlerThread2.start();
                                cVar.f7096a.add(handlerThread2);
                            } else {
                                Log.e("HandlerThreadPool", "No available handler thread found, please try again later.");
                                handlerThread = null;
                            }
                        }
                        handlerThread = handlerThread2;
                        Log.i("HandlerThreadPool", "HandlerThread count: " + cVar.f7096a.size());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (handlerThread != null) {
                Looper looper = handlerThread.getLooper();
                Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
                fVar = new f(this, looper);
            } else {
                fVar = null;
            }
        }
        this.f10726a = fVar;
    }

    public final f a() {
        f fVar = this.f10726a;
        Intrinsics.checkNotNull(fVar, "null cannot be cast to non-null type android.os.Handler");
        return fVar;
    }

    public void b(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    public final synchronized boolean c(Runnable runnable) {
        boolean zHasCallbacks;
        try {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            f fVar = this.f10726a;
            if (fVar != null) {
                zHasCallbacks = fVar.hasCallbacks(runnable);
            } else {
                Log.e("HandlerThreadPool", "mainHandler is null, please check the initialization of HandlerUtil.");
                zHasCallbacks = false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return zHasCallbacks;
    }

    public final Message d() {
        Message messageObtainMessage = a().obtainMessage();
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        return messageObtainMessage;
    }

    public final Message e(int i8, int i9, int i10, Object obj) {
        Message messageObtainMessage = a().obtainMessage(i8, i9, i10, obj);
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
        return messageObtainMessage;
    }

    public final synchronized void f(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        synchronized (this) {
            try {
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                f fVar = this.f10726a;
                if (fVar != null) {
                    fVar.post(runnable);
                } else {
                    Log.e("HandlerThreadPool", "mainHandler is null, please check the initialization of HandlerUtil.");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized void g(long j8, Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        synchronized (this) {
            try {
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                f fVar = this.f10726a;
                if (fVar != null) {
                    fVar.postDelayed(runnable, j8);
                } else {
                    Log.e("HandlerThreadPool", "mainHandler is null, please check the initialization of HandlerUtil.");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized void h(Runnable runnable) {
        try {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            f fVar = this.f10726a;
            if (fVar != null) {
                fVar.removeCallbacks(runnable);
            } else {
                Log.e("HandlerThreadPool", "mainHandler is null, please check the initialization of HandlerUtil.");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void i(Message msg) {
        try {
            Intrinsics.checkNotNullParameter(msg, "msg");
            f fVar = this.f10726a;
            if (fVar != null) {
                fVar.sendMessage(msg);
            } else {
                Log.e("HandlerThreadPool", "mainHandler is null, please check the initialization of HandlerUtil.");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
