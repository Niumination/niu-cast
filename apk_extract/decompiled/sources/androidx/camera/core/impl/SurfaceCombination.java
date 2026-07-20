package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class SurfaceCombination {
    private final List<SurfaceConfig> mSurfaceConfigList = new ArrayList();

    private static void generateArrangements(List<int[]> list, int i8, int[] iArr, int i9) {
        if (i9 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i10 = 0; i10 < i8; i10++) {
            int i11 = 0;
            while (true) {
                if (i11 >= i9) {
                    iArr[i9] = i10;
                    generateArrangements(list, i8, iArr, i9 + 1);
                    break;
                } else if (i10 == iArr[i11]) {
                    break;
                } else {
                    i11++;
                }
            }
        }
    }

    private List<int[]> getElementsArrangements(int i8) {
        ArrayList arrayList = new ArrayList();
        generateArrangements(arrayList, i8, new int[i8], 0);
        return arrayList;
    }

    public boolean addSurfaceConfig(@NonNull SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.add(surfaceConfig);
    }

    @NonNull
    public List<SurfaceConfig> getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    public boolean isSupported(@NonNull List<SurfaceConfig> list) {
        if (list.isEmpty()) {
            return true;
        }
        if (list.size() > this.mSurfaceConfigList.size()) {
            return false;
        }
        for (int[] iArr : getElementsArrangements(this.mSurfaceConfigList.size())) {
            boolean zIsSupported = true;
            for (int i8 = 0; i8 < this.mSurfaceConfigList.size() && (iArr[i8] >= list.size() || ((zIsSupported = zIsSupported & this.mSurfaceConfigList.get(i8).isSupported(list.get(iArr[i8]))))); i8++) {
            }
            if (zIsSupported) {
                return true;
            }
        }
        return false;
    }

    public boolean removeSurfaceConfig(@NonNull SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.remove(surfaceConfig);
    }
}
