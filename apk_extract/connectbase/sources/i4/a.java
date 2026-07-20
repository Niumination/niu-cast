package i4;

import jq.e0;
import k4.m;
import ks.c;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f7717a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f7718b = "DeviceUtils";

    public final boolean a() {
        boolean z10 = e0.K1("tablet", m4.a.C0275a.f10375a.t("ro.tr_device.type", c.f9460f), true) || e0.K1("tablet", m4.a.C0275a.f10375a.t("ro.build.characteristics", c.f9460f), true);
        m.b(f7718b, "isPhoneDevice: " + z10);
        return !z10;
    }
}
