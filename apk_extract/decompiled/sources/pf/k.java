package pf;

import java.io.InputStream;
import k3.mb;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends cg.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8853a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f8854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zf.i f8855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f8856d;

    public k(hh.f fVar, zf.i iVar, Object obj) {
        this.f8856d = obj;
        zf.s sVar = ((vf.c) fVar.f5401a).f10559c;
        String[] strArr = zf.v.f11551a;
        String strI = sVar.i("Content-Length");
        this.f8854b = strI != null ? Long.valueOf(Long.parseLong(strI)) : null;
        if (iVar == null) {
            zf.i iVar2 = zf.f.f11498a;
            iVar = zf.f.f11498a;
        }
        this.f8855c = iVar;
    }

    @Override // cg.j
    public final Long a() {
        switch (this.f8853a) {
            case 0:
                break;
        }
        return this.f8854b;
    }

    @Override // cg.j
    public final zf.i b() {
        switch (this.f8853a) {
            case 0:
                break;
        }
        return this.f8855c;
    }

    @Override // cg.i
    public final jh.o e() {
        switch (this.f8853a) {
            case 0:
                return (jh.o) this.f8856d;
            default:
                return mb.a((InputStream) this.f8856d);
        }
    }

    public k(vf.c cVar, zf.i iVar, Object obj) {
        this.f8856d = obj;
        zf.s sVar = cVar.f10559c;
        String[] strArr = zf.v.f11551a;
        String strI = sVar.i("Content-Length");
        this.f8854b = strI != null ? Long.valueOf(Long.parseLong(strI)) : null;
        if (iVar == null) {
            zf.i iVar2 = zf.f.f11498a;
            iVar = zf.f.f11498a;
        }
        this.f8855c = iVar;
    }
}
