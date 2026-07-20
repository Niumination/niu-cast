package z4;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f21821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f21823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f21824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f21825e;

    public g(int i10, String str) {
        Boolean bool = Boolean.TRUE;
        this.f21823c = bool;
        this.f21824d = bool;
        this.f21821a = Integer.valueOf(i10);
        this.f21822b = str;
        this.f21825e = null;
    }

    public Integer a() {
        return this.f21821a;
    }

    public String b() {
        return this.f21822b;
    }

    public Boolean c() {
        return this.f21824d;
    }

    public Boolean d() {
        return this.f21823c;
    }

    public void e() {
        Runnable runnable = this.f21825e;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void f() {
        this.f21823c = Boolean.valueOf(!this.f21823c.booleanValue());
    }

    public void g(Boolean bool) {
        this.f21823c = bool;
    }

    public g(int i10, String str, Runnable runnable) {
        Boolean bool = Boolean.TRUE;
        this.f21823c = bool;
        this.f21824d = bool;
        this.f21821a = Integer.valueOf(i10);
        this.f21822b = str;
        this.f21825e = runnable;
    }

    public g(int i10, String str, Boolean bool, Runnable runnable) {
        Boolean bool2 = Boolean.TRUE;
        this.f21823c = bool2;
        this.f21824d = bool2;
        this.f21821a = Integer.valueOf(i10);
        this.f21822b = str;
        this.f21823c = bool;
        this.f21825e = runnable;
    }

    public g(int i10, String str, Boolean bool, Runnable runnable, Boolean bool2) {
        Boolean bool3 = Boolean.TRUE;
        this.f21823c = bool3;
        this.f21824d = bool3;
        this.f21821a = Integer.valueOf(i10);
        this.f21822b = str;
        this.f21823c = bool;
        this.f21824d = bool2;
        this.f21825e = runnable;
    }
}
