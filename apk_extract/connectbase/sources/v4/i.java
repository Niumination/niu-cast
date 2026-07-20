package v4;

import com.transsion.aiotlink.IStreamDataListener;
import com.transsion.aiotlink.ITCCPListener;
import com.transsion.aiotlink.NativeLinkManager;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16579b = "SinkLinkManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NativeLinkManager f16580a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f16581a = new i();
    }

    public static i e() {
        return a.f16581a;
    }

    public void a(String str, int i10, IStreamDataListener iStreamDataListener) {
        k4.m.e(f16579b, " videoLink connectVideoServer new method");
        if (this.f16580a.connectAudio(str, i10, iStreamDataListener)) {
            return;
        }
        k4.m.c(f16579b, "connectVideoServer link error");
    }

    public void b(String str, int i10, ITCCPListener iTCCPListener) {
        k4.m.e(f16579b, " connectTccpServer: run");
        if (this.f16580a.connectTccpServer(str, i10, iTCCPListener)) {
            return;
        }
        k4.m.c(f16579b, "connectTccpServer link error");
    }

    public void c(String str, int i10) {
        k4.m.e(f16579b, " connectUibcServer: run");
        this.f16580a.connectUibcServer(str, i10);
    }

    public void d(String str, int i10, IStreamDataListener iStreamDataListener) {
        k4.m.e(f16579b, " videoLink connectVideoServer new method");
        if (this.f16580a.connectVideo(str, i10, iStreamDataListener)) {
            return;
        }
        k4.m.c(f16579b, "connectVideoServer link error");
    }

    public void f(short s10, String str) {
        k4.m.b(f16579b, "sendTccpRequest:code:" + ((int) s10) + ";data:" + str);
        this.f16580a.sendTccpRequestBySink(s10, str);
    }

    public void g(byte[] bArr, int i10) {
        this.f16580a.sendUibcData(bArr, i10);
    }

    public i() {
        this.f16580a = NativeLinkManager.a();
    }
}
