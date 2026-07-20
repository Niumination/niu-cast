package m7;

import android.content.Context;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import m7.i.a;

/* JADX INFO: loaded from: classes2.dex */
public class h implements xf.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f10594a;

    @Override // xf.d
    public Set<da.g.a> a(Context context, Set<String> set, da.g.a aVar, boolean z10) {
        Set<i.a> setA = c().a(context, set, null, z10);
        HashSet hashSet = new HashSet();
        if (aVar != null) {
            for (i.a aVar2 : setA) {
                if (aVar.b() == aVar2.b()) {
                    setA = c().a(context, set, aVar2, z10);
                    break;
                }
            }
        }
        for (i.a aVar3 : setA) {
            hashSet.add(new da.g.a(aVar3.c(), aVar3.b(), aVar3.a()));
        }
        return hashSet;
    }

    @Override // xf.d
    public Set<da.g.a> b(Context context, Set<String> set, da.g.a aVar, boolean z10) {
        i.a aVar2;
        if (aVar != null) {
            i iVarC = c();
            Objects.requireNonNull(iVarC);
            aVar2 = iVarC.new a(aVar.c(), aVar.b(), aVar.a());
        } else {
            aVar2 = null;
        }
        Set<i.a> setB = c().b(context, set, aVar2, z10);
        HashSet hashSet = new HashSet();
        if (aVar != null) {
            for (i.a aVar3 : setB) {
                if (aVar.b() == aVar3.b()) {
                    setB = c().b(context, set, aVar3, z10);
                    break;
                }
            }
        }
        for (i.a aVar4 : setB) {
            da.g.a aVar5 = new da.g.a(aVar4.c(), aVar4.b(), aVar4.a());
            aVar5.f3653d = aVar4.d();
            hashSet.add(aVar5);
        }
        return hashSet;
    }

    public final i c() {
        if (this.f10594a == null) {
            this.f10594a = new i();
        }
        return this.f10594a;
    }
}
