package dj;

import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f4478a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public tj.w f4479b = new tj.w(5, 5, TimeUnit.MINUTES);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f4480c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f4481d = new ArrayList();
    public final mg.a0 e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f4482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f4484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l f4485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l f4486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l f4487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SocketFactory f4488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f4489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f4490o;
    public final pj.c p;
    public final f q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4491r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4492s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4493t;
    public int u;

    public a0() {
        l asFactory = l.f4605d;
        Intrinsics.checkNotNullParameter(asFactory, "$this$asFactory");
        this.e = new mg.a0();
        this.f = true;
        l lVar = b.f4494a;
        this.f4482g = lVar;
        this.f4483h = true;
        this.f4484i = true;
        this.f4485j = l.f4603b;
        this.f4486k = l.f4604c;
        this.f4487l = lVar;
        SocketFactory socketFactory = SocketFactory.getDefault();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "SocketFactory.getDefault()");
        this.f4488m = socketFactory;
        this.f4489n = b0.D;
        this.f4490o = b0.C;
        this.p = pj.c.f8916a;
        this.q = f.f4531c;
        this.f4492s = ModuleDescriptor.MODULE_VERSION;
        this.f4493t = ModuleDescriptor.MODULE_VERSION;
        this.u = ModuleDescriptor.MODULE_VERSION;
    }
}
