package com.transsion.iotservice.multiscreen.pc.ui.permission;

import a.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.transsion.iotservice.multiscreen.pc.bean.Permission;
import java.util.ArrayList;
import java.util.Iterator;
import k3.pb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/permission/PermissionViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nPermissionViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionViewModel.kt\ncom/transsion/iotservice/multiscreen/pc/ui/permission/PermissionViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,142:1\n1863#2,2:143\n*S KotlinDebug\n*F\n+ 1 PermissionViewModel.kt\ncom/transsion/iotservice/multiscreen/pc/ui/permission/PermissionViewModel\n*L\n53#1:143,2\n*E\n"})
public final class PermissionViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData f2793a = new MutableLiveData();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f2794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData f2795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f2796d;
    public final ArrayList e;
    public final MutableLiveData f;

    public PermissionViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData(Boolean.FALSE);
        this.f2794b = mutableLiveData;
        this.f2795c = mutableLiveData;
        this.e = new ArrayList();
        this.f = new MutableLiveData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a(int i8, int i9) {
        Integer num = (Integer) this.f.getValue();
        return (num != null && num.intValue() == 1) ? i9 : i8;
    }

    public final void b() {
        ArrayList arrayList = this.e;
        arrayList.clear();
        ArrayList<Permission> arrayList2 = this.f2796d;
        if (arrayList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
            arrayList2 = null;
        }
        for (Permission permission : arrayList2) {
            Iterator<String> it = permission.getPermissions().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                if (!a.a(pb.a(), it.next())) {
                    arrayList.add(permission);
                    break;
                }
            }
        }
        if (arrayList.isEmpty()) {
            this.f2794b.setValue(Boolean.TRUE);
        } else {
            this.f2793a.setValue(arrayList.get(0));
        }
    }
}
