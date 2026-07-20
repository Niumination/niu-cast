package a6;

import android.content.Context;
import jq.h0;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final j f71a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final d0 f72b = f0.b(c.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final d0 f73c = f0.b(b.INSTANCE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final d0 f74d = f0.b(a.INSTANCE);

    public static final class a extends n0 implements jn.a<String> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // jn.a
        public final String invoke() {
            return m4.a.C0275a.f10375a.t("ro.product.brand", "");
        }
    }

    public static final class b extends n0 implements jn.a<Boolean> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final Boolean invoke() {
            String strB = j.f71a.b();
            l0.o(strB, "<get-osValue>(...)");
            return Boolean.valueOf(h0.T2(strB, "itel", false, 2, null));
        }
    }

    public static final class c extends n0 implements jn.a<String> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        @Override // jn.a
        public final String invoke() {
            return m4.a.C0275a.f10375a.E("ro.tr_project.tos.type", "ro.tranos.type", "");
        }
    }

    public final String a() {
        return (String) f74d.getValue();
    }

    public final String b() {
        return (String) f72b.getValue();
    }

    public final boolean c(@os.l Context context) {
        l0.p(context, "context");
        boolean z10 = (context.getResources().getConfiguration().uiMode & 48) != 32;
        k4.m.b("OsUtils", "PhoneUtil,getUIMode: isLightMode=" + z10 + " (true: light, false: dark)");
        return z10;
    }

    public final boolean d() {
        String strB = b();
        l0.o(strB, "<get-osValue>(...)");
        return h0.T2(strB, "hios", false, 2, null);
    }

    public final boolean e() {
        return ((Boolean) f73c.getValue()).booleanValue();
    }

    public final boolean f() {
        String strB = b();
        l0.o(strB, "<get-osValue>(...)");
        return h0.T2(strB, "xos", false, 2, null);
    }
}
