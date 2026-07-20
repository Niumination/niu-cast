package xa;

import android.os.ParcelFileDescriptor;
import fc.b;
import xd.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20132c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f20133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g8.a f20134b;

    public boolean a() {
        return b(b.a.f5981a).b();
    }

    public rg.a b(String str) {
        if (b.b(str)) {
            dc.e.f(f20132c, "TranThubFontManager");
            e eVar = this.f20133a;
            if (eVar != null) {
                return eVar;
            }
            e eVar2 = new e();
            this.f20133a = eVar2;
            return eVar2;
        }
        dc.e.f(f20132c, g8.a.f6436c);
        g8.a aVar = this.f20134b;
        if (aVar != null) {
            return aVar;
        }
        g8.a aVar2 = new g8.a();
        this.f20134b = aVar2;
        return aVar2;
    }

    @yb.a(level = 0)
    public int c(String str, String str2) {
        return b(b.a.f5982b).d(str, str2);
    }

    @yb.a(level = 0)
    public int d(ParcelFileDescriptor parcelFileDescriptor, String str) {
        return b(b.a.f5982b).c(parcelFileDescriptor, str);
    }

    public void e() {
        b(b.a.f5981a).a();
    }
}
