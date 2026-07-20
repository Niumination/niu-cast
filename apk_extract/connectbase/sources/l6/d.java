package l6;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f9715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c.InterfaceC0255c f9716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f9717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.d f9718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c.b f9719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.a f9720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9722h;

    public d(String[] strArr, c.InterfaceC0255c interfaceC0255c) {
        this.f9715a = strArr;
        this.f9716b = interfaceC0255c;
        this.f9721g = false;
    }

    public d(String str, c.d dVar) {
        this.f9717c = str;
        this.f9718d = dVar;
        this.f9722h = false;
    }

    public d(boolean z10, String[] strArr, c.b bVar) {
        this.f9719e = bVar;
        this.f9715a = strArr;
        this.f9721g = true;
    }

    public d(boolean z10, String str, c.a aVar) {
        this.f9717c = str;
        this.f9720f = aVar;
        this.f9722h = true;
    }
}
