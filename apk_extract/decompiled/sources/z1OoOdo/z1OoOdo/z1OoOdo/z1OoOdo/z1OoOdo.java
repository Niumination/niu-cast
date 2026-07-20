package z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo;

import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import b8.d;
import sk.a;

/* JADX INFO: loaded from: classes3.dex */
public class z1OoOdo extends RecyclerView.EdgeEffectFactory implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f11234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f11235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f11236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f11237d;
    public z1OoOnew e;

    @Override // sk.a
    public final void b() {
        d dVar = this.f11234a;
        if (dVar != null) {
            dVar.a();
        }
        d dVar2 = this.f11235b;
        if (dVar2 != null) {
            dVar2.a();
        }
        d dVar3 = this.f11236c;
        if (dVar3 != null) {
            dVar3.a();
        }
        d dVar4 = this.f11237d;
        if (dVar4 != null) {
            dVar4.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
    public final EdgeEffect createEdgeEffect(RecyclerView recyclerView, int i8) {
        if (i8 == 0) {
            d dVar = new d(recyclerView, i8, this.e);
            this.f11234a = dVar;
            return dVar;
        }
        if (i8 == 1) {
            d dVar2 = new d(recyclerView, i8, this.e);
            this.f11236c = dVar2;
            return dVar2;
        }
        if (i8 == 2) {
            d dVar3 = new d(recyclerView, i8, this.e);
            this.f11235b = dVar3;
            return dVar3;
        }
        if (i8 != 3) {
            return super.createEdgeEffect(recyclerView, i8);
        }
        d dVar4 = new d(recyclerView, i8, this.e);
        this.f11237d = dVar4;
        return dVar4;
    }

    @Override // sk.a
    public final boolean d(d dVar) {
        d8.d dVar2;
        d dVar3 = this.f11236c;
        boolean z2 = (dVar3 == null || dVar3 == dVar || (dVar2 = dVar3.f1222b) == null) ? false : dVar2.e;
        d dVar4 = this.f11237d;
        if (dVar4 == null || dVar4 == dVar) {
            return z2;
        }
        d8.d dVar5 = dVar4.f1222b;
        return z2 | (dVar5 != null ? dVar5.e : false);
    }
}
