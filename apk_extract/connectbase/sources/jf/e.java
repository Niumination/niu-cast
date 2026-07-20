package jf;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface e {
    int A(String str, String str2);

    void B(ComponentName componentName, int i10, int i11, int i12);

    boolean C(String str, int i10);

    void D();

    List<ResolveInfo> E(Intent intent, int i10, int i11);

    void F(String str, x6.f.a aVar, int i10);

    void G();

    boolean H(String str);

    void I(String str, int i10, int i11);

    void J();

    List<ApplicationInfo> a(int i10, int i11);

    String b(int i10);

    String c(int i10);

    boolean d(String str, int i10);

    String e(int i10);

    PackageInfo f(String str, int i10, int i11);

    void g(ComponentName componentName, int i10);

    void h(IntentFilter intentFilter, int i10, ComponentName[] componentNameArr, ComponentName componentName, int i11);

    void i(String str, x6.f.a aVar, int i10, int i11);

    int j(String str, int i10);

    List<PackageInfo> k(int i10, int i11);

    List<ApplicationInfo> l(int i10);

    String m();

    PackageInfo n(String str, int i10, int i11);

    void o(String str, boolean z10);

    String p(int i10);

    boolean q(String str, int i10);

    void r(String str, int i10, int i11, int i12, String str2);

    void s(String str, int i10, int i11);

    String[] t();

    boolean u(String str, int i10);

    int v(String str, int i10);

    ComponentName w(List<ResolveInfo> list);

    int x(String str);

    ApplicationInfo y(String str, int i10, int i11);

    List<ResolveInfo> z(Intent intent, int i10, int i11);
}
