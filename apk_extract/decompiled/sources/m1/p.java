package m1;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public final class p extends x1.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x1.b f7611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x1.c f7612d;
    public final /* synthetic */ p1.c e;

    public p(x1.b bVar, x1.c cVar, p1.c cVar2) {
        this.f7611c = bVar;
        this.f7612d = cVar;
        this.e = cVar2;
    }

    @Override // x1.c
    public final Object a(x1.b bVar) {
        float f = bVar.f10819a;
        float f4 = bVar.f10820b;
        String str = ((p1.c) bVar.f10821c).f8618a;
        String str2 = ((p1.c) bVar.f10822d).f8618a;
        float f10 = bVar.e;
        float f11 = bVar.f;
        float f12 = bVar.f10823g;
        x1.b bVar2 = this.f7611c;
        bVar2.f10819a = f;
        bVar2.f10820b = f4;
        bVar2.f10821c = str;
        bVar2.f10822d = str2;
        bVar2.e = f10;
        bVar2.f = f11;
        bVar2.f10823g = f12;
        String str3 = (String) this.f7612d.f10825b;
        p1.c cVar = (p1.c) (bVar.f == 1.0f ? bVar.f10822d : bVar.f10821c);
        String str4 = cVar.f8619b;
        float f13 = cVar.f8620c;
        p1.b bVar3 = cVar.f8621d;
        int i8 = cVar.e;
        float f14 = cVar.f;
        float f15 = cVar.f8622g;
        int i9 = cVar.f8623h;
        int i10 = cVar.f8624i;
        float f16 = cVar.f8625j;
        boolean z2 = cVar.f8626k;
        PointF pointF = cVar.f8627l;
        PointF pointF2 = cVar.f8628m;
        p1.c cVar2 = this.e;
        cVar2.f8618a = str3;
        cVar2.f8619b = str4;
        cVar2.f8620c = f13;
        cVar2.f8621d = bVar3;
        cVar2.e = i8;
        cVar2.f = f14;
        cVar2.f8622g = f15;
        cVar2.f8623h = i9;
        cVar2.f8624i = i10;
        cVar2.f8625j = f16;
        cVar2.f8626k = z2;
        cVar2.f8627l = pointF;
        cVar2.f8628m = pointF2;
        return cVar2;
    }
}
