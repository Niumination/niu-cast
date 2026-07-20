package n0;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Bitmap f11043f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k(int i10, int i11, String str, String str2, String str3) {
        this.f11038a = i10;
        this.f11039b = i11;
        this.f11040c = str;
        this.f11041d = str2;
        this.f11042e = str3;
    }

    @Nullable
    public Bitmap a() {
        return this.f11043f;
    }

    public String b() {
        return this.f11042e;
    }

    public String c() {
        return this.f11041d;
    }

    public int d() {
        return this.f11039b;
    }

    public String e() {
        return this.f11040c;
    }

    public int f() {
        return this.f11038a;
    }

    public boolean g() {
        return this.f11043f != null || (this.f11041d.startsWith("data:") && this.f11041d.indexOf("base64,") > 0);
    }

    public void h(@Nullable Bitmap bitmap) {
        this.f11043f = bitmap;
    }
}
