package j1;

import android.content.Context;
import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f5978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f5980d;

    public /* synthetic */ k(Context context, int i8, String str, String str2) {
        this.f5977a = i8;
        this.f5978b = context;
        this.f5979c = str;
        this.f5980d = str2;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x009a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14, types: [j1.c0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v15, types: [j1.c0] */
    /* JADX WARN: Type inference failed for: r0v2, types: [t1.f] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2, types: [t1.a] */
    /* JADX WARN: Type inference failed for: r5v3, types: [t1.a] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // java.util.concurrent.Callable
    public final Object call() throws Throwable {
        j jVar;
        j jVar2;
        Pair pair;
        c0 c0VarF;
        t1.f fVar;
        t1.d dVar;
        switch (this.f5977a) {
            case 0:
                Context context = this.f5978b;
                String str = this.f5979c;
                String str2 = this.f5980d;
                t1.f fVar2 = d.f5946b;
                ?? c0Var = fVar2;
                if (fVar2 == null) {
                    synchronized (t1.f.class) {
                        try {
                            t1.f fVar3 = d.f5946b;
                            fVar = fVar3;
                            if (fVar3 == null) {
                                Context applicationContext = context.getApplicationContext();
                                t1.d dVar2 = d.f5947c;
                                if (dVar2 == null) {
                                    synchronized (t1.d.class) {
                                        try {
                                            dVar = d.f5947c;
                                            if (dVar == null) {
                                                dVar = new t1.d(new a4.b(applicationContext, 9));
                                                d.f5947c = dVar;
                                            }
                                        } catch (Throwable th2) {
                                            throw th2;
                                        }
                                        break;
                                    }
                                    dVar2 = dVar;
                                }
                                t1.f fVar4 = new t1.f(dVar2, new t1.b());
                                d.f5946b = fVar4;
                                fVar = fVar4;
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    c0Var = fVar;
                }
                ?? r7 = 0;
                r7 = 0;
                if (str2 != null) {
                    try {
                        File fileB = c0Var.f10163a.b(str);
                        if (fileB == null) {
                            pair = null;
                        } else {
                            FileInputStream fileInputStream = new FileInputStream(fileB);
                            t1.c cVar = fileB.getAbsolutePath().endsWith(".zip") ? t1.c.ZIP : fileB.getAbsolutePath().endsWith(".gz") ? t1.c.GZIP : t1.c.JSON;
                            fileB.getAbsolutePath();
                            w1.b.a();
                            pair = new Pair(cVar, fileInputStream);
                        }
                    } catch (FileNotFoundException unused) {
                    }
                    if (pair == null) {
                        jVar = null;
                    } else {
                        t1.c cVar2 = (t1.c) pair.first;
                        InputStream inputStream = (InputStream) pair.second;
                        int i8 = t1.e.f10162a[cVar2.ordinal()];
                        if (i8 == 1) {
                            c0VarF = o.f(context, new ZipInputStream(inputStream), str2);
                        } else if (i8 != 2) {
                            c0VarF = o.c(inputStream, str2);
                        } else {
                            try {
                                c0VarF = o.c(new GZIPInputStream(inputStream), str2);
                            } catch (IOException e) {
                                c0VarF = new c0(e);
                            }
                        }
                        jVar = c0VarF.f5943a;
                        if (jVar == null) {
                            jVar = null;
                        }
                    }
                    break;
                } else {
                    jVar = null;
                }
                if (jVar == null) {
                    w1.b.a();
                    w1.b.a();
                    try {
                        try {
                            t1.a aVarA = c0Var.f10164b.a(str);
                            r7 = 0;
                            try {
                                try {
                                    r7 = aVarA.f10160a.getResponseCode() / 100 == 2;
                                } catch (IOException unused2) {
                                }
                                try {
                                    if (r7 != 0) {
                                        String str3 = str2;
                                        c0 c0VarA = c0Var.a(context, str, aVarA.f10160a.getInputStream(), aVarA.f10160a.getContentType(), str3);
                                        j jVar3 = c0VarA.f5943a;
                                        w1.b.a();
                                        aVarA.close();
                                        c0Var = c0VarA;
                                        r7 = str3;
                                    } else {
                                        c0 c0Var2 = new c0(new IllegalArgumentException(aVarA.a()));
                                        aVarA.close();
                                        c0Var = c0Var2;
                                        r7 = r7;
                                    }
                                } catch (IOException e4) {
                                    w1.b.c("LottieFetchResult close failed ", e4);
                                }
                            } catch (Exception e10) {
                                e = e10;
                                r7 = aVarA;
                                c0 c0Var3 = new c0(e);
                                if (r7 != 0) {
                                    try {
                                        r7.close();
                                    } catch (IOException e11) {
                                        w1.b.c("LottieFetchResult close failed ", e11);
                                    }
                                }
                                c0Var = c0Var3;
                                break;
                            } catch (Throwable th4) {
                                th = th4;
                                r7 = aVarA;
                                if (r7 != 0) {
                                    try {
                                        r7.close();
                                    } catch (IOException e12) {
                                        w1.b.c("LottieFetchResult close failed ", e12);
                                    }
                                    break;
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Exception e13) {
                        e = e13;
                    }
                    break;
                } else {
                    c0Var = new c0(jVar);
                }
                if (str2 != null && (jVar2 = c0Var.f5943a) != null) {
                    p1.h.f8640b.f8641a.put(str2, jVar2);
                }
                return c0Var;
            default:
                return o.b(this.f5978b, this.f5979c, this.f5980d);
        }
    }
}
