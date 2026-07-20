package y6;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import ef.o;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import m3.d0;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f11097d = {"https://time1.google.com", "https://time.cloudflare.com", "https://www.pool.ntp.org"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11098c;

    /* JADX WARN: Code duplicated, block: B:41:0x00a5 A[LOOP:0: B:3:0x0010->B:41:0x00a5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0 A[SYNTHETIC] */
    @Override // y6.d
    public final void a() throws Throwable {
        Exception e;
        HttpURLConnection httpURLConnection;
        o oVar;
        SSLContext sSLContextA;
        Handler handler = this.f11087a;
        Message messageObtainMessage = handler.obtainMessage(TypedValues.PositionType.TYPE_PERCENT_WIDTH);
        messageObtainMessage.obj = 0L;
        while (true) {
            int i8 = this.f11098c;
            if (i8 >= 3) {
                break;
            }
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(f11097d[i8]).openConnection();
                try {
                    try {
                        if (httpURLConnection instanceof HttpsURLConnection) {
                            if (d0.f7650a == null && (sSLContextA = v6.a.a()) != null) {
                                d0.f7650a = sSLContextA.getSocketFactory();
                            }
                            SSLSocketFactory sSLSocketFactory = d0.f7650a;
                            if (sSLSocketFactory != null) {
                                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(v6.a.f10526a);
                            }
                        }
                        httpURLConnection.setReadTimeout(ModuleDescriptor.MODULE_VERSION);
                        httpURLConnection.setConnectTimeout(ModuleDescriptor.MODULE_VERSION);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode < 200 || responseCode >= 400) {
                            httpURLConnection.disconnect();
                            oVar = new o(-1, (Object) 0L);
                        } else {
                            oVar = new o(0, Long.valueOf(httpURLConnection.getDate()));
                            httpURLConnection.disconnect();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        if (e instanceof UnknownHostException) {
                            z6.a.c(e.getMessage());
                        } else {
                            z6.a.c(Log.getStackTraceString(e));
                        }
                        if (httpURLConnection != null) {
                        }
                        oVar = new o(-1, (Object) 0L);
                        if (oVar.f4951a == 0) {
                            messageObtainMessage.obj = oVar.f4952b;
                            handler.sendMessageAtFrontOfQueue(messageObtainMessage);
                        }
                        this.f11098c++;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                httpURLConnection = null;
            } catch (Throwable th3) {
                th = th3;
            }
            if (oVar.f4951a == 0) {
                messageObtainMessage.obj = oVar.f4952b;
                break;
            }
            this.f11098c++;
        }
        handler.sendMessageAtFrontOfQueue(messageObtainMessage);
    }

    @Override // y6.d
    public final String c() {
        return "Retrieve-Time";
    }
}
