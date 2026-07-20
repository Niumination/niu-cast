package wi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.widgetslib.R;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b<T> extends ArrayAdapter<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f18283f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f18285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f18288e;

    public b(@NonNull Context context, T[] tArr) {
        this(context, Arrays.asList(tArr));
    }

    @NonNull
    public static b<CharSequence> a(@NonNull Context context, @ArrayRes int i10) {
        return new b<>(context, context.getResources().getTextArray(i10));
    }

    public void b(boolean z10) {
        this.f18286c = z10;
    }

    public void c(int i10) {
        if (i10 < 0 || i10 >= getCount()) {
            this.f18284a = -1;
        } else {
            this.f18284a = i10;
            this.f18285b = (T) getItem(i10);
        }
    }

    public void d(@Nullable T t10) {
        this.f18284a = getPosition(t10);
        this.f18285b = t10;
    }

    public final void e(int i10, View view) {
        int i11 = 0;
        boolean z10 = this.f18285b == getItem(i10);
        view.findViewById(this.f18287d).setSelected(z10);
        View viewFindViewById = view.findViewById(this.f18288e);
        if (this.f18284a < 0) {
            i11 = 8;
        } else if (!z10) {
            i11 = 4;
        }
        viewFindViewById.setVisibility(i11);
        if (viewFindViewById.getVisibility() == 8) {
            view.setPadding(view.getPaddingEnd(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, @Nullable View view, @NonNull ViewGroup viewGroup) {
        View dropDownView = super.getDropDownView(i10, view, viewGroup);
        if (dropDownView != null && this.f18286c) {
            e(i10, dropDownView);
        }
        return dropDownView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, @Nullable View view, @NonNull ViewGroup viewGroup) {
        View view2 = super.getView(i10, view, viewGroup);
        if (view2 != null) {
            if (this.f18286c) {
                view2.findViewById(this.f18288e).setVisibility(8);
            } else {
                e(i10, view2);
            }
        }
        return view2;
    }

    public b(@NonNull Context context, @NonNull List<T> list) {
        this(context, R.layout.os_popup_item_layout_selected, android.R.id.text1, R.id.os_list_popup_selected, list);
    }

    public b(@NonNull Context context, @LayoutRes int i10, @IdRes int i11, @IdRes int i12, @NonNull List<T> list) {
        super(context, i10, i11, list);
        this.f18284a = -1;
        this.f18287d = i11;
        this.f18288e = i12;
    }
}
