package sa;

import androidx.recyclerview.widget.DiffUtil;
import com.transsion.iotservice.multiscreen.pc.adapter.SearchPcItemAdapter;
import com.transsion.iotservice.multiscreen.pc.bean.PcBleScanedDeviceBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends DiffUtil.ItemCallback {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(Object obj, Object obj2) {
        PcBleScanedDeviceBean oldItem = (PcBleScanedDeviceBean) obj;
        PcBleScanedDeviceBean newItem = (PcBleScanedDeviceBean) obj2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return !SearchPcItemAdapter.f2391g && oldItem.getMRssi() == newItem.getMRssi() && oldItem.getMConnectState() == newItem.getMConnectState();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(Object obj, Object obj2) {
        PcBleScanedDeviceBean oldItem = (PcBleScanedDeviceBean) obj;
        PcBleScanedDeviceBean newItem = (PcBleScanedDeviceBean) obj2;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return Intrinsics.areEqual(oldItem.getMDeviceMac(), newItem.getMDeviceMac());
    }
}
