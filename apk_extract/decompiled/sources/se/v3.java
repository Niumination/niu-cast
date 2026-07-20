package se;

import java.util.LinkedHashSet;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.p f10029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10032d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f10033h;

    public v3(com.welink.protocol.nfbd.p pVar, String str, String str2, int i8, int i9, int i10) {
        this.f10029a = pVar;
        this.f10030b = str;
        this.f10031c = str2;
        this.f10032d = i8;
        this.e = i9;
        this.f10033h = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.welink.protocol.nfbd.p pVar = this.f10029a;
        LinkedHashSet linkedHashSet = pVar.f4187g;
        String str = this.f10030b;
        if (linkedHashSet.contains(str)) {
            li.l0.p(pVar.f4190j, null, null, new x3(pVar, str, this.f10031c, this.f10032d, this.e, this.f10033h, null), 3);
            return;
        }
        String mes = "Device not registered for notifications: ".concat(str);
        Intrinsics.checkNotNullParameter("NearLanTcpServer", "tag");
        Intrinsics.checkNotNullParameter(mes, "mes");
        if (lb.f6529c >= 1) {
            h0.a.x("TransConnect:", mes, "NearLanTcpServer", null);
        }
    }
}
