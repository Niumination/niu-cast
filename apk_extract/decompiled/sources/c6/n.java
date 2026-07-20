package c6;

import com.permissionx.guolindev.request.InvisibleFragment;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends Lambda implements Function0 {
    final /* synthetic */ Map<String, Boolean> $grantResults;
    final /* synthetic */ InvisibleFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(InvisibleFragment invisibleFragment, Map<String, Boolean> map) {
        super(0);
        this.this$0 = invisibleFragment;
        this.$grantResults = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m52invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m52invoke() {
        InvisibleFragment invisibleFragment = this.this$0;
        Map<String, Boolean> grantResults = this.$grantResults;
        Intrinsics.checkNotNullExpressionValue(grantResults, "grantResults");
        if (invisibleFragment.b()) {
            r rVar = invisibleFragment.f2290b;
            r rVar2 = null;
            a aVar = null;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar = null;
            }
            rVar.f.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry<String, Boolean> entry : grantResults.entrySet()) {
                String key = entry.getKey();
                if (entry.getValue().booleanValue()) {
                    r rVar3 = invisibleFragment.f2290b;
                    if (rVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        rVar3 = null;
                    }
                    rVar3.f.add(key);
                    r rVar4 = invisibleFragment.f2290b;
                    if (rVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        rVar4 = null;
                    }
                    rVar4.f1444g.remove(key);
                    r rVar5 = invisibleFragment.f2290b;
                    if (rVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        rVar5 = null;
                    }
                    rVar5.f1445h.remove(key);
                } else if (invisibleFragment.shouldShowRequestPermissionRationale(key)) {
                    arrayList.add(key);
                    r rVar6 = invisibleFragment.f2290b;
                    if (rVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        rVar6 = null;
                    }
                    rVar6.f1444g.add(key);
                } else {
                    arrayList2.add(key);
                    r rVar7 = invisibleFragment.f2290b;
                    if (rVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        rVar7 = null;
                    }
                    rVar7.f1445h.add(key);
                    r rVar8 = invisibleFragment.f2290b;
                    if (rVar8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        rVar8 = null;
                    }
                    rVar8.f1444g.remove(key);
                }
            }
            ArrayList<String> arrayList3 = new ArrayList();
            r rVar9 = invisibleFragment.f2290b;
            if (rVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar9 = null;
            }
            arrayList3.addAll(rVar9.f1444g);
            r rVar10 = invisibleFragment.f2290b;
            if (rVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar10 = null;
            }
            arrayList3.addAll(rVar10.f1445h);
            for (String str : arrayList3) {
                if (a.a.a(invisibleFragment.requireContext(), str)) {
                    r rVar11 = invisibleFragment.f2290b;
                    if (rVar11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        rVar11 = null;
                    }
                    rVar11.f1444g.remove(str);
                    r rVar12 = invisibleFragment.f2290b;
                    if (rVar12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pb");
                        rVar12 = null;
                    }
                    rVar12.f.add(str);
                }
            }
            r rVar13 = invisibleFragment.f2290b;
            if (rVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar13 = null;
            }
            int size = rVar13.f.size();
            r rVar14 = invisibleFragment.f2290b;
            if (rVar14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar14 = null;
            }
            if (size == rVar14.f1442c.size()) {
                a aVar2 = invisibleFragment.f2291c;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("task");
                } else {
                    aVar = aVar2;
                }
                aVar.g();
                return;
            }
            r rVar15 = invisibleFragment.f2290b;
            if (rVar15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar15 = null;
            }
            rVar15.getClass();
            r rVar16 = invisibleFragment.f2290b;
            if (rVar16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar16 = null;
            }
            rVar16.getClass();
            r rVar17 = invisibleFragment.f2290b;
            if (rVar17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
                rVar17 = null;
            }
            rVar17.getClass();
            a aVar3 = invisibleFragment.f2291c;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("task");
                aVar3 = null;
            }
            aVar3.g();
            r rVar18 = invisibleFragment.f2290b;
            if (rVar18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pb");
            } else {
                rVar2 = rVar18;
            }
            rVar2.getClass();
        }
    }
}
