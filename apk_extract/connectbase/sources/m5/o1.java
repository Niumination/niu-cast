package m5;

import androidx.annotation.NonNull;
import com.transsion.connectx.sdk.FileInfo;

/* JADX INFO: loaded from: classes2.dex */
public class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10512h = 1;

    public o1() {
    }

    @NonNull
    public static o1 a(@NonNull FileInfo fileInfo, int i10, String str) {
        o1 o1Var = new o1();
        o1Var.f10510f = fileInfo.getId();
        o1Var.f10508d = fileInfo.getUri();
        o1Var.f10505a = str;
        o1Var.f10507c = fileInfo.getName();
        o1Var.f10506b = 0;
        o1Var.f10512h = i10;
        return o1Var;
    }

    @NonNull
    public static o1 j(@NonNull n2.v vVar, String str) {
        o1 o1Var = new o1();
        o1Var.f10510f = vVar.c();
        o1Var.f10508d = vVar.a();
        o1Var.f10505a = str;
        o1Var.f10506b = 1;
        o1Var.f10512h = vVar.e();
        return o1Var;
    }

    public String b() {
        String str = this.f10510f;
        return str == null ? "" : str;
    }

    public String c() {
        String str = this.f10507c;
        return str == null ? "" : str;
    }

    public int d() {
        return this.f10506b;
    }

    public String e() {
        String str = this.f10505a;
        return str == null ? "" : str;
    }

    public String f() {
        String str = this.f10509e;
        return str == null ? "" : str;
    }

    public String g() {
        String str = this.f10511g;
        return str == null ? "" : str;
    }

    public String h() {
        String str = this.f10508d;
        return str == null ? "" : str;
    }

    public int i() {
        return this.f10512h;
    }

    public void k(String str) {
        this.f10510f = str;
    }

    public void l(String str) {
        this.f10507c = str;
    }

    public void m(int i10) {
        this.f10506b = i10;
    }

    public void n(String str) {
        this.f10505a = str;
    }

    public void o(String str) {
        this.f10509e = str;
    }

    public void p(String str) {
        this.f10511g = str;
    }

    public void q(String str) {
        this.f10508d = str;
    }

    public void r(int i10) {
        this.f10512h = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("TransferFileInfo{packageName='");
        sb2.append(this.f10505a);
        sb2.append("', fileSource=");
        sb2.append(this.f10506b);
        sb2.append(", fileName='");
        sb2.append(this.f10507c);
        sb2.append("', sendPath='");
        sb2.append(this.f10508d);
        sb2.append("', savePath='");
        sb2.append(this.f10509e);
        sb2.append("', fileId='");
        sb2.append(this.f10510f);
        sb2.append("', sdkId='");
        sb2.append(this.f10511g);
        sb2.append("', transferType=");
        return u.a.a(sb2, this.f10512h, rs.f.f14860b);
    }

    public o1(String str, int i10, String str2, String str3, String str4) {
        this.f10505a = str;
        this.f10506b = i10;
        this.f10507c = str2;
        this.f10508d = str3;
        this.f10509e = str4;
    }
}
