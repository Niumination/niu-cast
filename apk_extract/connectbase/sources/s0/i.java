package s0;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f14915d = "\r";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f14917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f14918c;

    public i(String str, float f10, float f11) {
        this.f14916a = str;
        this.f14918c = f11;
        this.f14917b = f10;
    }

    public boolean a(String str) {
        if (this.f14916a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f14916a.endsWith(f14915d)) {
            String str2 = this.f14916a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
