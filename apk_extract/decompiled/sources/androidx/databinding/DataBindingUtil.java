package androidx.databinding;

import android.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class DataBindingUtil {
    private static DataBinderMapper sMapper = new DataBinderMapperImpl();
    private static DataBindingComponent sDefaultComponent = null;

    private DataBindingUtil() {
    }

    @Nullable
    public static <T extends ViewDataBinding> T bind(@NonNull View view) {
        return (T) bind(view, sDefaultComponent);
    }

    private static <T extends ViewDataBinding> T bindToAddedViews(DataBindingComponent dataBindingComponent, ViewGroup viewGroup, int i8, int i9) {
        int childCount = viewGroup.getChildCount();
        int i10 = childCount - i8;
        if (i10 == 1) {
            return (T) bind(dataBindingComponent, viewGroup.getChildAt(childCount - 1), i9);
        }
        View[] viewArr = new View[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            viewArr[i11] = viewGroup.getChildAt(i11 + i8);
        }
        return (T) bind(dataBindingComponent, viewArr, i9);
    }

    @Nullable
    public static String convertBrIdToString(int i8) {
        return sMapper.convertBrIdToString(i8);
    }

    @Nullable
    public static <T extends ViewDataBinding> T findBinding(@NonNull View view) {
        while (view != null) {
            T t3 = (T) ViewDataBinding.getBinding(view);
            if (t3 != null) {
                return t3;
            }
            Object tag = view.getTag();
            if (tag instanceof String) {
                String str = (String) tag;
                if (str.startsWith("layout") && str.endsWith("_0")) {
                    char cCharAt = str.charAt(6);
                    int iIndexOf = str.indexOf(47, 7);
                    if (cCharAt == '/') {
                        if (iIndexOf == -1) {
                            return null;
                        }
                    } else if (cCharAt == '-' && iIndexOf != -1 && str.indexOf(47, iIndexOf + 1) == -1) {
                        return null;
                    }
                }
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    @Nullable
    public static <T extends ViewDataBinding> T getBinding(@NonNull View view) {
        return (T) ViewDataBinding.getBinding(view);
    }

    @Nullable
    public static DataBindingComponent getDefaultComponent() {
        return sDefaultComponent;
    }

    public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater layoutInflater, int i8, @Nullable ViewGroup viewGroup, boolean z2) {
        return (T) inflate(layoutInflater, i8, viewGroup, z2, sDefaultComponent);
    }

    public static <T extends ViewDataBinding> T setContentView(@NonNull Activity activity, int i8) {
        return (T) setContentView(activity, i8, sDefaultComponent);
    }

    public static void setDefaultComponent(@Nullable DataBindingComponent dataBindingComponent) {
        sDefaultComponent = dataBindingComponent;
    }

    @Nullable
    public static <T extends ViewDataBinding> T bind(@NonNull View view, DataBindingComponent dataBindingComponent) {
        T t3 = (T) getBinding(view);
        if (t3 != null) {
            return t3;
        }
        Object tag = view.getTag();
        if (!(tag instanceof String)) {
            throw new IllegalArgumentException("View is not a binding layout");
        }
        int layoutId = sMapper.getLayoutId((String) tag);
        if (layoutId != 0) {
            return (T) sMapper.getDataBinder(dataBindingComponent, view, layoutId);
        }
        throw new IllegalArgumentException(a1.a.p(tag, "View is not a binding layout. Tag: "));
    }

    public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater layoutInflater, int i8, @Nullable ViewGroup viewGroup, boolean z2, @Nullable DataBindingComponent dataBindingComponent) {
        boolean z3 = viewGroup != null && z2;
        return z3 ? (T) bindToAddedViews(dataBindingComponent, viewGroup, z3 ? viewGroup.getChildCount() : 0, i8) : (T) bind(dataBindingComponent, layoutInflater.inflate(i8, viewGroup, z2), i8);
    }

    public static <T extends ViewDataBinding> T setContentView(@NonNull Activity activity, int i8, @Nullable DataBindingComponent dataBindingComponent) {
        activity.setContentView(i8);
        return (T) bindToAddedViews(dataBindingComponent, (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content), 0, i8);
    }

    public static <T extends ViewDataBinding> T bind(DataBindingComponent dataBindingComponent, View[] viewArr, int i8) {
        return (T) sMapper.getDataBinder(dataBindingComponent, viewArr, i8);
    }

    public static <T extends ViewDataBinding> T bind(DataBindingComponent dataBindingComponent, View view, int i8) {
        return (T) sMapper.getDataBinder(dataBindingComponent, view, i8);
    }
}
