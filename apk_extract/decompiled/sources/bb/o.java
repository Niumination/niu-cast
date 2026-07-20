package bb;

import com.transsion.iotservice.multiscreen.pc.bean.PcBleScanedDeviceBean;
import java.io.File;
import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1240a;

    public /* synthetic */ o(int i8) {
        this.f1240a = i8;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f1240a) {
            case 0:
                PcBleScanedDeviceBean pcBleScanedDeviceBean = (PcBleScanedDeviceBean) obj;
                PcBleScanedDeviceBean pcBleScanedDeviceBean2 = (PcBleScanedDeviceBean) obj2;
                if (pcBleScanedDeviceBean == null && pcBleScanedDeviceBean2 == null) {
                    return 0;
                }
                if (pcBleScanedDeviceBean == null) {
                    return -1;
                }
                if (pcBleScanedDeviceBean2 != null) {
                    if (pcBleScanedDeviceBean.getMIsHistoryConnected() == pcBleScanedDeviceBean2.getMIsHistoryConnected()) {
                        return Intrinsics.compare(pcBleScanedDeviceBean2.getMRssi(), pcBleScanedDeviceBean.getMRssi());
                    }
                    if (pcBleScanedDeviceBean.getMIsHistoryConnected()) {
                        return -1;
                    }
                }
                return 1;
            case 1:
                return ((String) ((Map.Entry) obj).getKey()).compareTo((String) ((Map.Entry) obj2).getKey());
            case 2:
                String str = (String) obj;
                int i8 = 0;
                for (int i9 = 0; i9 < str.length(); i9++) {
                    if (str.charAt(i9) == '/') {
                        i8++;
                    }
                }
                Integer numValueOf = Integer.valueOf(i8);
                String str2 = (String) obj2;
                int i10 = 0;
                for (int i11 = 0; i11 < str2.length(); i11++) {
                    if (str2.charAt(i11) == '/') {
                        i10++;
                    }
                }
                return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i10));
            case 3:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 4:
                File file = (File) obj;
                File file2 = (File) obj2;
                if (file.lastModified() < file2.lastModified()) {
                    return -1;
                }
                return file.lastModified() == file2.lastModified() ? 0 : 1;
            case 5:
                return ((File) obj).getName().compareTo(((File) obj2).getName());
            default:
                return ((l6.b) obj2).e - ((l6.b) obj).e;
        }
    }
}
