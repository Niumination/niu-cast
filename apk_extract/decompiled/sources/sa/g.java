package sa;

import androidx.recyclerview.widget.DiffUtil;
import com.transsion.iotservice.multiscreen.pc.bean.FunctionGuideBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends DiffUtil.ItemCallback {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(Object obj, Object obj2) {
        FunctionGuideBean oldItem = (FunctionGuideBean) obj;
        FunctionGuideBean newItem = (FunctionGuideBean) obj2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem, newItem);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(Object obj, Object obj2) {
        FunctionGuideBean oldItem = (FunctionGuideBean) obj;
        FunctionGuideBean newItem = (FunctionGuideBean) obj2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
    }
}
