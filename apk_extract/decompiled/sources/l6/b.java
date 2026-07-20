package l6;

import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7341d;
    public final int e;
    public final boolean f;

    public b(String str, int i8, String str2, int i9, int i10, boolean z2) {
        this.f7338a = str;
        this.f7339b = str2;
        this.f7340c = i8;
        this.f7341d = i9;
        this.e = i10;
        this.f = z2;
    }

    public final String a() {
        return this.f7338a + "-" + this.f7339b + "-" + this.f7341d + "-" + this.f7340c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return TextUtils.equals(a(), ((b) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f7338a, this.f7339b, Integer.valueOf(this.f7340c), Integer.valueOf(this.f7341d), Integer.valueOf(this.e), Boolean.valueOf(this.f));
    }
}
