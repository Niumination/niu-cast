package com.transsion.connectx.mirror.source;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.transsion.connectx.mirror.source.databinding.ActivityMirrorFullScreenBindingImpl;
import com.transsion.connectx.mirror.source.databinding.ActivityPhoneExtendScreenBindingImpl;
import com.transsion.connectx.mirror.source.databinding.ItemActionbarBindingImpl;
import com.transsion.connectx.mirror.source.databinding.ItemBottomNavBindingImpl;
import com.transsion.connectx.mirror.source.databinding.ItemExtendTipBindingImpl;
import com.transsion.connectx.mirror.source.databinding.ItemScreenLockBindingImpl;
import com.transsion.connectx.mirror.source.databinding.ItemSecretScreenBindingImpl;
import com.transsion.connectx.mirror.source.databinding.ItemWindowHelperBindingImpl;
import com.transsion.connectx.mirror.source.databinding.LoadingLayoutBindingImpl;
import com.transsion.connectx.mirror.source.databinding.PhoneFloatingWindowsBindingImpl;
import com.transsion.connectx.mirror.source.databinding.StartLayoutBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1862a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1863b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f1864c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f1865d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f1866e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f1867f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1868g = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f1869h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f1870i = 9;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f1871j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f1872k = 11;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final SparseIntArray f1873l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f1874a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(2);
            f1874a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "viewModel");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f1875a;

        static {
            HashMap<String, Integer> map = new HashMap<>(11);
            f1875a = map;
            map.put("layout/activity_mirror_full_screen_0", Integer.valueOf(R.layout.activity_mirror_full_screen));
            map.put("layout/activity_phone_extend_screen_0", Integer.valueOf(R.layout.activity_phone_extend_screen));
            map.put("layout/item_actionbar_0", Integer.valueOf(R.layout.item_actionbar));
            map.put("layout/item_bottom_nav_0", Integer.valueOf(R.layout.item_bottom_nav));
            map.put("layout/item_extend_tip_0", Integer.valueOf(R.layout.item_extend_tip));
            map.put("layout/item_screen_lock_0", Integer.valueOf(R.layout.item_screen_lock));
            map.put("layout/item_secret_screen_0", Integer.valueOf(R.layout.item_secret_screen));
            map.put("layout/item_window_helper_0", Integer.valueOf(R.layout.item_window_helper));
            map.put("layout/loading_layout_0", Integer.valueOf(R.layout.loading_layout));
            map.put("layout/phone_floating_windows_0", Integer.valueOf(R.layout.phone_floating_windows));
            map.put("layout/start_layout_0", Integer.valueOf(R.layout.start_layout));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(11);
        f1873l = sparseIntArray;
        sparseIntArray.put(R.layout.activity_mirror_full_screen, 1);
        sparseIntArray.put(R.layout.activity_phone_extend_screen, 2);
        sparseIntArray.put(R.layout.item_actionbar, 3);
        sparseIntArray.put(R.layout.item_bottom_nav, 4);
        sparseIntArray.put(R.layout.item_extend_tip, 5);
        sparseIntArray.put(R.layout.item_screen_lock, 6);
        sparseIntArray.put(R.layout.item_secret_screen, 7);
        sparseIntArray.put(R.layout.item_window_helper, 8);
        sparseIntArray.put(R.layout.loading_layout, 9);
        sparseIntArray.put(R.layout.phone_floating_windows, 10);
        sparseIntArray.put(R.layout.start_layout, 11);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i10) {
        return a.f1874a.get(i10);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i10) {
        int i11 = f1873l.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i11) {
            case 1:
                if ("layout/activity_mirror_full_screen_0".equals(tag)) {
                    return new ActivityMirrorFullScreenBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(c0.a.a("The tag for activity_mirror_full_screen is invalid. Received: ", tag));
            case 2:
                if ("layout/activity_phone_extend_screen_0".equals(tag)) {
                    return new ActivityPhoneExtendScreenBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(c0.a.a("The tag for activity_phone_extend_screen is invalid. Received: ", tag));
            case 3:
                if ("layout/item_actionbar_0".equals(tag)) {
                    return new ItemActionbarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(c0.a.a("The tag for item_actionbar is invalid. Received: ", tag));
            case 4:
                if ("layout/item_bottom_nav_0".equals(tag)) {
                    return new ItemBottomNavBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(c0.a.a("The tag for item_bottom_nav is invalid. Received: ", tag));
            case 5:
                if ("layout/item_extend_tip_0".equals(tag)) {
                    return new ItemExtendTipBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(c0.a.a("The tag for item_extend_tip is invalid. Received: ", tag));
            case 6:
                if ("layout/item_screen_lock_0".equals(tag)) {
                    return new ItemScreenLockBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(c0.a.a("The tag for item_screen_lock is invalid. Received: ", tag));
            case 7:
                if ("layout/item_secret_screen_0".equals(tag)) {
                    return new ItemSecretScreenBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(c0.a.a("The tag for item_secret_screen is invalid. Received: ", tag));
            case 8:
                if ("layout/item_window_helper_0".equals(tag)) {
                    return new ItemWindowHelperBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(c0.a.a("The tag for item_window_helper is invalid. Received: ", tag));
            case 9:
                if ("layout/loading_layout_0".equals(tag)) {
                    return new LoadingLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(c0.a.a("The tag for loading_layout is invalid. Received: ", tag));
            case 10:
                if ("layout/phone_floating_windows_0".equals(tag)) {
                    return new PhoneFloatingWindowsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(c0.a.a("The tag for phone_floating_windows is invalid. Received: ", tag));
            case 11:
                if ("layout/start_layout_0".equals(tag)) {
                    return new StartLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException(c0.a.a("The tag for start_layout is invalid. Received: ", tag));
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f1875a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f1873l.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
