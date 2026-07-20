package o5;

import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import b2.d;
import c2.i;
import c2.n;
import ck.e;
import com.transsion.message.bank.MessageBank;
import com.transsion.widgetslib.widget.shadow.SpringFloatingOvalButton;
import dj.e0;
import j2.k;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import jd.h;
import k3.ae;
import k3.d2;
import k3.ja;
import k3.ka;
import k3.x1;
import k3.xa;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import li.l;
import mg.a0;
import tj.x;
import zj.f;
import zj.m;
import zj.o;
import zj.o0;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements h, e, k2.b, f2.b, ck.a, ae, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f8405a;

    public /* synthetic */ c(Object obj) {
        this.f8405a = obj;
    }

    public void a(StringBuilder sb2, Iterator it) {
        try {
            if (it.hasNext()) {
                Object next = it.next();
                Objects.requireNonNull(next);
                sb2.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (it.hasNext()) {
                    sb2.append((CharSequence) this.f8405a);
                    Object next2 = it.next();
                    Objects.requireNonNull(next2);
                    sb2.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // jd.h
    public void b(View view, boolean z2) {
        SpringFloatingOvalButton springFloatingOvalButton = (SpringFloatingOvalButton) this.f8405a;
        h hVar = springFloatingOvalButton.f3657b;
        if (hVar != null) {
            hVar.b(view, z2);
            if (z2) {
                return;
            }
            springFloatingOvalButton.playSoundEffect(0);
        }
    }

    public b2.c c(Object obj) throws IOException {
        b2.b bVar = (b2.b) obj;
        d dVar = (d) this.f8405a;
        d2.a(bVar.f1183a, "CctTransportBackend", "Making request to: %s");
        HttpURLConnection httpURLConnection = (HttpURLConnection) bVar.f1183a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(dVar.f1193g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/2.3.3 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = bVar.f1185c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    x xVar = dVar.f1189a;
                    i iVar = bVar.f1184b;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    s4.d dVar2 = (s4.d) xVar.f10264a;
                    s4.e eVar = new s4.e(bufferedWriter, dVar2.f9502a, dVar2.f9503b, dVar2.f9504c, dVar2.f9505d);
                    eVar.e(iVar);
                    eVar.g();
                    eVar.f9507b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), a1.a.o(responseCode, "Status Code: "));
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b2.c(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b2.c(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            b2.c cVar = new b2.c(responseCode, null, n.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).f1422a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return cVar;
                        } catch (Throwable th2) {
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th4) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    throw th4;
                }
            } catch (Throwable th5) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th5;
            }
        } catch (ConnectException | UnknownHostException e) {
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
            return new b2.c(500, null, 0L);
        } catch (IOException | q4.b e4) {
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e4);
            return new b2.c(400, null, 0L);
        }
    }

    @Override // ek.b
    /* JADX INFO: renamed from: call */
    public void mo0call(Object obj) {
        ck.i iVar = (ck.i) obj;
        pk.a aVar = (pk.a) this.f8405a;
        nk.a aVar2 = ck.c.f1727b;
        try {
            iVar.getClass();
            ck.a aVar3 = aVar.f1728a;
            aVar2.getClass();
            aVar3.mo0call(iVar);
        } catch (Throwable th2) {
            x1.b(th2);
            try {
                aVar2.getClass();
                iVar.onError(th2);
            } catch (Throwable th3) {
                x1.b(th3);
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th2.getMessage() + "] and then again while trying to pass to onError.", th3);
                aVar2.getClass();
                throw runtimeException;
            }
        }
    }

    @Override // zj.f
    public void d(zj.c cVar, o0 o0Var) {
        boolean zC = o0Var.f11691a.c();
        l lVar = (l) this.f8405a;
        if (!zC) {
            m mVar = new m(o0Var);
            Result.Companion companion = Result.INSTANCE;
            lVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(mVar)));
            return;
        }
        Object obj = o0Var.f11692b;
        if (obj != null) {
            lVar.resumeWith(Result.m159constructorimpl(obj));
            return;
        }
        e0 e0VarRequest = cVar.request();
        e0VarRequest.getClass();
        Intrinsics.checkNotNullParameter(o.class, MessageBank.KEY_TYPE);
        Object objCast = o.class.cast(e0VarRequest.f.get(o.class));
        if (objCast == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(objCast, "call.request().tag(Invocation::class.java)!!");
        Method method = ((o) objCast).f11689a;
        StringBuilder sb2 = new StringBuilder("Response from ");
        Intrinsics.checkExpressionValueIsNotNull(method, "method");
        Class<?> declaringClass = method.getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass, "method.declaringClass");
        sb2.append(declaringClass.getName());
        sb2.append('.');
        sb2.append(method.getName());
        sb2.append(" was null but response body type was declared as non-null");
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb2.toString());
        Result.Companion companion2 = Result.INSTANCE;
        lVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(kotlinNullPointerException)));
    }

    @Override // k2.b
    public Object execute() {
        j2.h hVar = (j2.h) ((j2.c) this.f8405a);
        long jA = hVar.f6049b.a() - hVar.f6051d.f6038d;
        SQLiteDatabase sQLiteDatabaseA = hVar.a();
        sQLiteDatabaseA.beginTransaction();
        try {
            int iDelete = sQLiteDatabaseA.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(jA)});
            sQLiteDatabaseA.setTransactionSuccessful();
            return Integer.valueOf(iDelete);
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // yh.a
    public Object get() {
        return new j2.h(new n5.a(), new a0(), j2.a.f, (k) ((se.e) this.f8405a).get());
    }

    @Override // zj.f
    public void onFailure(Throwable th2) {
        Result.Companion companion = Result.INSTANCE;
        ((l) this.f8405a).resumeWith(Result.m159constructorimpl(ResultKt.createFailure(th2)));
    }

    @Override // ck.e
    public void request(long j8) {
        long j10;
        long j11;
        if (j8 > 0) {
            fk.h hVar = (fk.h) this.f8405a;
            AtomicLong atomicLong = hVar.f5075m;
            do {
                j10 = atomicLong.get();
                j11 = j10 + j8;
                if (j11 < 0) {
                    j11 = Long.MAX_VALUE;
                }
            } while (!atomicLong.compareAndSet(j10, j11));
            hVar.d();
        }
    }

    @Override // k3.ae
    public df.m zza() {
        d2.a aVar = new d2.a();
        aVar.f4259c = v5.a.c() ? ja.TYPE_THICK : ja.TYPE_THIN;
        x xVar = new x();
        xVar.f10264a = (ka) this.f8405a;
        aVar.e = new xa(xVar);
        return new df.m(aVar, 0);
    }

    public c(byte[] bArr) {
        byte[] bytes = "abcdefghijk1mnop".getBytes();
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f8405a = cipher;
            cipher.init(1, secretKeySpec, new IvParameterSpec(bytes));
            Cipher.getInstance("AES/CBC/PKCS5Padding").init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bytes));
        } catch (Exception e) {
            ad.c.h(Log.getStackTraceString(e));
        }
    }

    public c(String str) {
        str.getClass();
        this.f8405a = str;
    }

    public c(int i8) {
        switch (i8) {
            case 2:
                this.f8405a = new AtomicLong();
                break;
            case 13:
                this.f8405a = new q3.k();
                break;
            default:
                this.f8405a = Choreographer.getInstance();
                Looper.myLooper();
                break;
        }
    }
}
