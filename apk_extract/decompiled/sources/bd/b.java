package bd;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import bb.w;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpScreenLockRequestBean;
import eb.k1;
import eb.l2;
import eb.y;
import hh.c;
import hh.e;
import j3.z;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.security.auth.x500.X500Principal;
import k3.gc;
import k3.p1;
import k3.pb;
import kotlin.UByte;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.g2;
import mg.f;
import mg.l;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import q7.g;
import w7.d;
import x7.i;
import x7.j;
import yg.o;
import yg.p;
import yg.q;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements w, j, z9.b, f {
    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    public static final String c(byte[] bArr, byte[][] bArr2, int i8) {
        int i9;
        boolean z2;
        int i10;
        int i11;
        int i12 = -1;
        byte[] bArr3 = PublicSuffixDatabase.e;
        int length = bArr.length;
        int i13 = 0;
        while (i13 < length) {
            int i14 = (i13 + length) / 2;
            while (i14 > i12 && bArr[i14] != ((byte) 10)) {
                i14 += i12;
            }
            int i15 = i14 + 1;
            int i16 = 1;
            while (true) {
                i9 = i15 + i16;
                if (bArr[i9] == ((byte) 10)) {
                    break;
                }
                i16++;
            }
            int i17 = i9 - i15;
            int i18 = i8;
            boolean z3 = false;
            int i19 = 0;
            int i20 = 0;
            while (true) {
                if (z3) {
                    i10 = 46;
                    z2 = false;
                } else {
                    byte b9 = bArr2[i18][i19];
                    byte[] bArr4 = ej.b.f4964a;
                    int i21 = b9 & UByte.MAX_VALUE;
                    z2 = z3;
                    i10 = i21;
                }
                byte b10 = bArr[i15 + i20];
                byte[] bArr5 = ej.b.f4964a;
                i11 = i10 - (b10 & UByte.MAX_VALUE);
                if (i11 != 0) {
                    break;
                }
                i20++;
                i19++;
                if (i20 == i17) {
                    break;
                }
                if (bArr2[i18].length != i19) {
                    z3 = z2;
                } else {
                    if (i18 == bArr2.length - 1) {
                        break;
                    }
                    i18++;
                    z3 = true;
                    i19 = -1;
                }
            }
            if (i11 >= 0) {
                if (i11 <= 0) {
                    int i22 = i17 - i20;
                    int length2 = bArr2[i18].length - i19;
                    int length3 = bArr2.length;
                    for (int i23 = i18 + 1; i23 < length3; i23++) {
                        length2 += bArr2[i23].length;
                    }
                    if (length2 < i22) {
                        length = i14;
                    } else if (length2 <= i22) {
                        Charset UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                        return new String(bArr, i15, i17, UTF_8);
                    }
                }
                i13 = i9 + 1;
            } else {
                length = i14;
            }
            i12 = -1;
        }
        return null;
    }

    public static void f() {
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer;
        d.f10679a = 1;
        Intrinsics.checkNotNullParameter("ScreenControlUtils", "tag");
        Intrinsics.checkNotNullParameter("lockScreen", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("ScreenControlUtils"), "lockScreen");
        }
        if (d.f10682d == null || (tCCPHandshakeSocketServer = l2.f4772a) == null) {
            return;
        }
        tCCPHandshakeSocketServer.sendRequest(TccpConfig.INSTANCE.getLOCKSCREEN_TCCP(), new TccpScreenLockRequestBean(true));
    }

    public static void g() throws Exception {
        gc.a("ScreenControlUtils", "screenOn");
        Application context = pb.a();
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        if (((KeyguardManager) systemService).isKeyguardLocked()) {
            return;
        }
        pa.a aVar = pa.a.f8703a;
        if ((pa.a.j("ro.tr_project.flip_screen.support") || pa.a.j("ro.tr_project.foldable_screen.support")) && pa.a.j("ro.tr_project.flip_screen.support")) {
            o6.a aVar2 = d.f10680b;
            if (((AtomicBoolean) aVar2.f8409d).get()) {
                throw new Exception("not registerDisplayFoldListener,must registerDisplayFoldListener to get the value");
            }
            if (aVar2.f8408c) {
                gc.a("ScreenControlUtils", "screenOn not unlock");
                return;
            }
        }
        gc.a("ScreenControlUtils", "screenOn unlock");
        if (d.f10682d != null) {
            z.c();
        }
    }

    @Override // z9.b
    public void a(Outline outline, int i8, int i9, float f, int i10) {
        StringBuilder sbR = o.d.r(i8, i9, "aosp not support setSmoothRoundRect [0,0, ", ", ", "], radius=");
        sbR.append(f);
        String string = sbR.toString();
        boolean z2 = j9.a.f6132a;
        Log.w("b", string);
    }

    @Override // x7.j
    public void b(q7.f disconnectInfoBean) {
        Intrinsics.checkNotNullParameter(disconnectInfoBean, "disconnectInfoBean");
        String log = "on TCCP DisConnected: " + disconnectInfoBean;
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("SocketServerManager"), log);
        }
        l2.b();
    }

    @Override // bb.w
    public void d(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        Intrinsics.checkNotNullParameter("multi_screen_con_settings", "entry");
        Intrinsics.checkNotNullParameter("multi_screen_con_settings", "entry");
        bVar.f8437a.getClass();
        Intrinsics.checkNotNullParameter("multi_screen_con_settings", "entry");
        Bundle bundle = new Bundle();
        bundle.putString("entry", "multi_screen_con_settings");
        bundle.putString("my_device_type", tj.w.B());
        tj.w.X("iot_multi_con_settings_user_guide_click", bundle);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("tips://deeplink/core/category?categoryid=29"));
        intent.addFlags(268435456);
        try {
            Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
            Intrinsics.checkNotNullParameter("startActivity", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("SettingViewModel"), "startActivity");
            }
            pb.a().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intrinsics.checkNotNullParameter("SettingViewModel", "tag");
            Intrinsics.checkNotNullParameter("No app can handle this deeplink: tips://deeplink/core/category?categoryid=29", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("SettingViewModel"), "No app can handle this deeplink: tips://deeplink/core/category?categoryid=29");
            }
        }
    }

    public synchronized boolean e() {
        synchronized (this) {
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                if (keyStore.getEntry("crypto", null) instanceof KeyStore.PrivateKeyEntry) {
                    return true;
                }
            } catch (Exception unused) {
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
            gregorianCalendar2.add(1, 100);
            try {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder("crypto", 3);
                builder.setCertificateSubject(new X500Principal("CN=crypto")).setEncryptionPaddings("PKCS1Padding").setCertificateSerialNumber(BigInteger.valueOf(1337L)).setCertificateNotBefore(gregorianCalendar.getTime()).setCertificateNotAfter(gregorianCalendar2.getTime());
                keyPairGenerator.initialize(builder.build());
                keyPairGenerator.generateKeyPair();
                return true;
            } catch (Exception unused2) {
                return false;
            }
        }
    }

    @Override // mg.f
    public zg.a getKey() {
        return q.f11217i;
    }

    @Override // x7.j
    public void k(g error) {
        Intrinsics.checkNotNullParameter(error, "error");
        String log = "on TCCP error:" + error + " ";
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("SocketServerManager"), log);
        }
        l2.b();
    }

    @Override // mg.f
    public Object m(e eVar, Function1 configure) throws c {
        mg.a pipeline = (mg.a) eVar;
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        Intrinsics.checkNotNullParameter(configure, "configure");
        p pVar = new p();
        configure.invoke(pVar);
        q qVar = new q(pVar.f11213b, pVar.f11214c, pVar.f11215d, pVar.f11212a);
        pipeline.f8043r.b(l.f8074d, new sb.a(qVar, 10));
        pipeline.f8057k.p(wg.b.f10753j, new o(null));
        return qVar;
    }

    @Override // x7.j
    public void onConnected() {
        String mac;
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("Connect TCCP success init Ability complete", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), "Connect TCCP success init Ability complete");
        }
        ta.b.a();
        y.f4799a.n();
        k1 k1Var = k1.f4765a;
        hc.c cVar = k1.e;
        if (cVar != null && (mac = cVar.f5288c) != null) {
            i iVar = i.f10886a;
            Intrinsics.checkNotNullParameter(mac, "mac");
            TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
            Intrinsics.checkNotNullParameter(mac, "mac");
            String log = "recordPeerDeviceMac:".concat(mac);
            Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectSdkProxy"), log);
            }
            x7.f.f10882a.recordPeerDeviceMac(mac);
        }
        g2 g2Var = l2.f4773b;
        if (g2Var != null) {
            g2Var.h(null);
        }
        ta.b.a();
        p1.a(pb.a());
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
        l2.g();
    }
}
