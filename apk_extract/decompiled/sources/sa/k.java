package sa;

import androidx.recyclerview.widget.DiffUtil;
import com.transsion.iotservice.multiscreen.pc.bean.TrustDeviceBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends DiffUtil.ItemCallback {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(Object obj, Object obj2) {
        TrustDeviceBean oldItem = (TrustDeviceBean) obj;
        TrustDeviceBean newItem = (TrustDeviceBean) obj2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem, newItem) && oldItem.getPosition() == newItem.getPosition() && oldItem.getTotalCount() == newItem.getTotalCount();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(Object obj, Object obj2) {
        TrustDeviceBean oldItem = (TrustDeviceBean) obj;
        TrustDeviceBean newItem = (TrustDeviceBean) obj2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem.getDeviceId(), newItem.getDeviceId());
    }
}
