package g3;

import ag.q;
import ag.r;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ClassLoader f5108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Thread f5109b;

    public static r a(bg.b bVar) {
        int i8;
        int i9;
        r rVar = null;
        if (bVar == null) {
            return null;
        }
        List listZ = se.e.z(r.f, bVar, 0, 0, true, new q(1), 6);
        if (listZ.size() == 1) {
            return (r) ((Pair) listZ.get(0)).getSecond();
        }
        int length = bVar.length();
        ArrayList arrayList = null;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            while (true) {
                char cCharAt = bVar.charAt(i10);
                if (cCharAt != ' ' && cCharAt != ',') {
                    i8 = i10;
                    i9 = i8;
                    break;
                }
                i10++;
                if (i10 >= length) {
                    i8 = i10;
                    i9 = i11;
                    break;
                }
            }
            while (i8 < length) {
                char cCharAt2 = bVar.charAt(i8);
                if (cCharAt2 == ' ' || cCharAt2 == ',') {
                    break;
                }
                i8++;
            }
            Pair pair = (Pair) CollectionsKt.singleOrNull(r.f.y(bVar, i9, i8, true, new q(1)));
            if (pair == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(bVar.subSequence(i9, i8).toString());
            } else if (rVar == null) {
                rVar = (r) pair.getSecond();
            } else {
                rVar = new r(rVar.f784a || ((r) pair.getSecond()).f784a, rVar.f785b || ((r) pair.getSecond()).f785b, rVar.f786c || ((r) pair.getSecond()).f786c, CollectionsKt.emptyList());
            }
            i10 = i8;
            i11 = i9;
        }
        if (rVar == null) {
            rVar = r.e;
        }
        return arrayList == null ? rVar : new r(rVar.f784a, rVar.f785b, rVar.f786c, arrayList);
    }

    public static synchronized ClassLoader b() {
        try {
            if (f5108a == null) {
                f5108a = c();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f5108a;
    }

    public static synchronized ClassLoader c() {
        ClassLoader contextClassLoader = null;
        if (f5109b == null) {
            f5109b = d();
            if (f5109b == null) {
                return null;
            }
        }
        synchronized (f5109b) {
            try {
                contextClassLoader = f5109b.getContextClassLoader();
            } catch (SecurityException e) {
                Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e.getMessage());
            }
        }
        return contextClassLoader;
    }

    public static synchronized Thread d() {
        SecurityException e;
        Thread fVar;
        Thread thread;
        ThreadGroup threadGroup;
        ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
        if (threadGroup2 == null) {
            return null;
        }
        synchronized (Void.class) {
            try {
                try {
                    int iActiveGroupCount = threadGroup2.activeGroupCount();
                    ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                    threadGroup2.enumerate(threadGroupArr);
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= iActiveGroupCount) {
                            threadGroup = null;
                            break;
                        }
                        threadGroup = threadGroupArr[i9];
                        if ("dynamiteLoader".equals(threadGroup.getName())) {
                            break;
                        }
                        i9++;
                    }
                    if (threadGroup == null) {
                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                    }
                    int iActiveCount = threadGroup.activeCount();
                    Thread[] threadArr = new Thread[iActiveCount];
                    threadGroup.enumerate(threadArr);
                    while (true) {
                        if (i8 >= iActiveCount) {
                            thread = null;
                            break;
                        }
                        thread = threadArr[i8];
                        if ("GmsDynamite".equals(thread.getName())) {
                            break;
                        }
                        i8++;
                    }
                    if (thread == null) {
                        try {
                            fVar = new f(threadGroup, "GmsDynamite");
                            try {
                                fVar.setContextClassLoader(null);
                                fVar.start();
                            } catch (SecurityException e4) {
                                e = e4;
                                Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e.getMessage());
                            }
                        } catch (SecurityException e10) {
                            e = e10;
                            fVar = thread;
                        }
                        thread = fVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (SecurityException e11) {
                e = e11;
                fVar = null;
            }
        }
        return thread;
    }
}
