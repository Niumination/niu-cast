package com.transsion.widgetslib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.Spinner;
import com.transsion.widgetslib.R;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@b.a({"AppCompatCustomView"})
public class InvertArrowSpinner extends Spinner {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f2727b = "os_spinner";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f2728a;

    public class a implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f2729a;

        public a(ViewTreeObserver viewTreeObserver) {
            this.f2729a = viewTreeObserver;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            InvertArrowSpinner invertArrowSpinner = InvertArrowSpinner.this;
            invertArrowSpinner.setBackground(invertArrowSpinner.getResources().getDrawable(R.drawable.os_spinner_background_material_blue_open));
            if (this.f2729a == null || InvertArrowSpinner.this.f2728a == null) {
                return;
            }
            this.f2729a.removeOnGlobalLayoutListener(InvertArrowSpinner.this.f2728a);
        }
    }

    public InvertArrowSpinner(Context context) {
        this(context, null);
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (zPerformClick) {
            setBackground(getResources().getDrawable(R.drawable.os_spinner_background_material_blue_close));
            try {
                ViewTreeObserver viewTreeObserver = getViewTreeObserver();
                if (viewTreeObserver != null) {
                    Field declaredField = viewTreeObserver.getClass().getDeclaredField("mOnGlobalLayoutListeners");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(viewTreeObserver);
                    Field declaredField2 = obj.getClass().getDeclaredField("mData");
                    declaredField2.setAccessible(true);
                    ArrayList arrayList = (ArrayList) declaredField2.get(obj);
                    if (arrayList.size() == 1) {
                        this.f2728a = (ViewTreeObserver.OnGlobalLayoutListener) arrayList.get(0);
                    }
                }
                Field declaredField3 = Spinner.class.getDeclaredField("mPopup");
                declaredField3.setAccessible(true);
                Object obj2 = declaredField3.get(this);
                if (obj2 instanceof ListPopupWindow) {
                    ((ListPopupWindow) obj2).setOnDismissListener(new a(viewTreeObserver));
                }
            } catch (NoSuchFieldException e10) {
                Log.e(f2727b, "The Spinner background drawable is not exist, performClick() e=" + e10);
            } catch (Exception e11) {
                Log.e(f2727b, "At Spinere.java performClick() has a exception,  e=" + e11);
            }
        }
        return zPerformClick;
    }

    public InvertArrowSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(getResources().getDrawable(R.drawable.os_spinner_background_material_blue_open));
        setPopupBackgroundDrawable(getResources().getDrawable(R.drawable.os_foot_opt_popup_background));
    }
}
