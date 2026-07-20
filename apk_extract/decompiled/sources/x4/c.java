package x4;

import java.io.IOException;
import v4.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile p0 f10835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f10836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f10837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ v4.q f10838d;
    public final /* synthetic */ c5.a e;
    public final /* synthetic */ d f;

    public c(d dVar, boolean z2, boolean z3, v4.q qVar, c5.a aVar) {
        this.f = dVar;
        this.f10836b = z2;
        this.f10837c = z3;
        this.f10838d = qVar;
        this.e = aVar;
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (this.f10836b) {
            bVar.skipValue();
            return null;
        }
        p0 delegateAdapter = this.f10835a;
        if (delegateAdapter == null) {
            delegateAdapter = this.f10838d.getDelegateAdapter(this.f, this.e);
            this.f10835a = delegateAdapter;
        }
        return delegateAdapter.read(bVar);
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        if (this.f10837c) {
            dVar.nullValue();
            return;
        }
        p0 delegateAdapter = this.f10835a;
        if (delegateAdapter == null) {
            delegateAdapter = this.f10838d.getDelegateAdapter(this.f, this.e);
            this.f10835a = delegateAdapter;
        }
        delegateAdapter.write(dVar, obj);
    }
}
