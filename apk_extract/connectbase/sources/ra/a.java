package ra;

import android.net.MacAddress;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final long A = -1;
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f14304n = "TranSoftApConfiguration";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f14305o = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f14306p = 63;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f14307q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f14308r = 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f14309s = 4;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f14310t = 7;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f14311u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f14312v = 14;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f14313w = 34;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f14314x = 196;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f14315y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f14316z = 253;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MacAddress f14318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f14324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f14325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<MacAddress> f14326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<MacAddress> f14327k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f14328l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f14329m;

    /* JADX INFO: renamed from: ra.a$a, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0345a {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public a(String str, MacAddress macAddress, String str2, boolean z10, int i10, int i11, int i12, int i13, boolean z11, long j10, boolean z12, List<MacAddress> list, List<MacAddress> list2) {
        this.f14317a = str;
        this.f14318b = macAddress;
        this.f14319c = str2;
        this.f14320d = z10;
        this.f14321e = i10;
        this.f14322f = i11;
        this.f14324h = i12;
        this.f14323g = i13;
        this.f14328l = z11;
        this.f14329m = j10;
        this.f14325i = z12;
        this.f14326j = new ArrayList(list);
        this.f14327k = new ArrayList(list2);
    }

    public static boolean y(int i10) {
        return i10 != 0 && (i10 & (-8)) == 0;
    }

    public static boolean z(int i10, int i11) {
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 4 || i10 < 1 || i10 > 253) {
                    return false;
                }
            } else if (i10 < 34 || i10 > 196) {
                return false;
            }
        } else if (i10 < 1 || i10 > 14) {
            return false;
        }
        return true;
    }

    public boolean A() {
        return this.f14325i;
    }

    public boolean B() {
        return this.f14320d;
    }

    public List<MacAddress> n() {
        return this.f14327k;
    }

    public int o() {
        return this.f14321e;
    }

    public List<MacAddress> p() {
        return this.f14326j;
    }

    public MacAddress q() {
        return this.f14318b;
    }

    public int r() {
        return this.f14322f;
    }

    public int s() {
        return this.f14323g;
    }

    public String t() {
        return this.f14319c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ssid=");
        sb2.append(this.f14317a);
        if (this.f14318b != null) {
            sb2.append(" \n bssid=");
            sb2.append(this.f14318b.toString());
        }
        sb2.append(" \n Passphrase =");
        sb2.append(TextUtils.isEmpty(this.f14319c) ? "<empty>" : "<non-empty>");
        sb2.append(" \n HiddenSsid =");
        sb2.append(this.f14320d);
        sb2.append(" \n Band =");
        sb2.append(this.f14321e);
        sb2.append(" \n Channel =");
        sb2.append(this.f14322f);
        sb2.append(" \n SecurityType=");
        sb2.append(this.f14324h);
        sb2.append(" \n MaxClient=");
        sb2.append(this.f14323g);
        sb2.append(" \n AutoShutdownEnabled=");
        sb2.append(this.f14328l);
        sb2.append(" \n ShutdownTimeoutMillis=");
        sb2.append(this.f14329m);
        sb2.append(" \n ClientControlByUser=");
        sb2.append(this.f14325i);
        sb2.append(" \n BlockedClientList=");
        sb2.append(this.f14326j);
        sb2.append(" \n AllowedClientList=");
        sb2.append(this.f14327k);
        return sb2.toString();
    }

    public int u() {
        return this.f14324h;
    }

    public long v() {
        return this.f14329m;
    }

    public String w() {
        return this.f14317a;
    }

    public boolean x() {
        return this.f14328l;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f14330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MacAddress f14331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f14332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f14333d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14334e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f14335f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14336g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14337h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f14338i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f14339j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f14340k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<MacAddress> f14341l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public List<MacAddress> f14342m;

        public b() {
            this.f14330a = null;
            this.f14331b = null;
            this.f14332c = null;
            this.f14333d = false;
            this.f14334e = 1;
            this.f14335f = 0;
            this.f14336g = 0;
            this.f14337h = 0;
            this.f14338i = true;
            this.f14339j = -1L;
            this.f14340k = false;
            this.f14341l = new ArrayList();
            this.f14342m = new ArrayList();
        }

        public a a() {
            return new a(this.f14330a, this.f14331b, this.f14332c, this.f14333d, this.f14334e, this.f14335f, this.f14337h, this.f14336g, this.f14338i, this.f14339j, this.f14340k, this.f14341l, this.f14342m);
        }

        public b b(List<MacAddress> list) {
            this.f14342m = new ArrayList(list);
            return this;
        }

        public b c(boolean z10) {
            this.f14338i = z10;
            return this;
        }

        public b d(int i10) {
            this.f14334e = i10;
            this.f14335f = 0;
            return this;
        }

        public b e(List<MacAddress> list) {
            this.f14341l = new ArrayList(list);
            return this;
        }

        public b f(MacAddress macAddress) {
            this.f14331b = macAddress;
            return this;
        }

        public b g(int i10, int i11) {
            this.f14334e = i11;
            this.f14335f = i10;
            return this;
        }

        public b h(boolean z10) {
            this.f14340k = z10;
            return this;
        }

        public b i(boolean z10) {
            this.f14333d = z10;
            return this;
        }

        public b j(int i10) {
            this.f14336g = i10;
            return this;
        }

        public b k(String str, int i10) {
            this.f14337h = i10;
            this.f14332c = str;
            return this;
        }

        public b l(long j10) {
            this.f14339j = j10;
            return this;
        }

        public b m(String str) {
            this.f14330a = str;
            return this;
        }

        public b(a aVar) {
            this.f14330a = aVar.f14317a;
            this.f14331b = aVar.f14318b;
            this.f14332c = aVar.f14319c;
            this.f14333d = aVar.f14320d;
            this.f14334e = aVar.f14321e;
            this.f14335f = aVar.f14322f;
            this.f14336g = aVar.f14323g;
            this.f14337h = aVar.f14324h;
            this.f14338i = aVar.f14328l;
            this.f14339j = aVar.f14329m;
            this.f14340k = aVar.f14325i;
            this.f14341l = new ArrayList(aVar.f14326j);
            this.f14342m = new ArrayList(aVar.f14327k);
        }
    }
}
