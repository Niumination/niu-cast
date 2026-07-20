package z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo;

import android.widget.EdgeEffect;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ts.a;

/* JADX INFO: loaded from: classes3.dex */
public class z1OoOdo extends RecyclerView.EdgeEffectFactory implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g6.a f21775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g6.a f21776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g6.a f21777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g6.a f21778d;

    @Override // ts.a
    public void a() {
        g6.a aVar = this.f21775a;
        if (aVar != null) {
            aVar.a();
        }
        g6.a aVar2 = this.f21776b;
        if (aVar2 != null) {
            aVar2.a();
        }
        g6.a aVar3 = this.f21777c;
        if (aVar3 != null) {
            aVar3.a();
        }
        g6.a aVar4 = this.f21778d;
        if (aVar4 != null) {
            aVar4.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
    @NonNull
    public EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i10) {
        if (i10 == 0) {
            g6.a aVar = new g6.a(recyclerView, i10);
            this.f21775a = aVar;
            return aVar;
        }
        if (i10 == 1) {
            g6.a aVar2 = new g6.a(recyclerView, i10);
            this.f21777c = aVar2;
            return aVar2;
        }
        if (i10 == 2) {
            g6.a aVar3 = new g6.a(recyclerView, i10);
            this.f21776b = aVar3;
            return aVar3;
        }
        if (i10 != 3) {
            return super.createEdgeEffect(recyclerView, i10);
        }
        g6.a aVar4 = new g6.a(recyclerView, i10);
        this.f21778d = aVar4;
        return aVar4;
    }
}
