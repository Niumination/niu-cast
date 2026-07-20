package z4;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21837e;

    public m(int i10, String str, String str2, boolean z10, int i11) {
        b(i10, str, str2, z10, i11);
    }

    public boolean a(int i10, String str, String str2, boolean z10, int i11) {
        return i10 == this.f21833a && Objects.equals(str, this.f21834b) && Objects.equals(str2, this.f21835c) && z10 == this.f21836d && i11 == this.f21837e;
    }

    public void b(int i10, String str, String str2, boolean z10, int i11) {
        this.f21833a = i10;
        this.f21834b = str;
        this.f21835c = str2;
        this.f21836d = z10;
        this.f21837e = i11;
    }
}
