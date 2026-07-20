package id;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$integer;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.widget.OSIconTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ArrayAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f5743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5746d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f5748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f5749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f5750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f5751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f5752m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f5753n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorStateList f5754o;
    public CharSequence p;
    public List q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f5755r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ColorStateList f5756s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f5757t;
    public ColorStateList u;

    public a(Context context, List list) {
        super(context, R$layout.os_popup_item_layout_selected, R.id.text1, list);
        this.f5743a = new HashSet();
        this.f5749j = null;
        this.f5750k = null;
        this.f5751l = null;
        this.f5752m = null;
        this.f5753n = null;
        this.f5754o = null;
        this.p = null;
        this.q = null;
        this.f5755r = null;
        this.f5756s = null;
        this.f5757t = null;
        this.u = null;
        this.f5746d = R.id.text1;
        this.e = R$id.os_list_popup_sub_text;
        this.f5747h = R$id.os_list_popup_left_text_icon;
        this.f5748i = R$id.os_list_popup_right_text_icon;
        a();
    }

    public static void c(View view, boolean z2) {
        view.setEnabled(z2);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                c(viewGroup.getChildAt(i8), z2);
            }
        }
    }

    public final void a() {
        int count = getCount();
        if (count <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(count);
        for (int i8 = 0; i8 < count; i8++) {
            Object item = getItem(i8);
            if (item == null) {
                arrayList.add(null);
            } else if (!(item instanceof CharSequence)) {
                return;
            } else {
                arrayList.add((CharSequence) item);
            }
        }
        this.f5751l = arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean areAllItemsEnabled() {
        return this.f5743a.isEmpty();
    }

    public final void b(int i8, View view) {
        boolean z2 = this.f5744b == getItem(i8);
        View viewFindViewById = view.findViewById(this.f5746d);
        viewFindViewById.setSelected(z2);
        CharSequence charSequence = null;
        if (viewFindViewById instanceof TextView) {
            Typeface typefaceCreate = z2 ? Typeface.create(Typeface.SANS_SERIF, view.getResources().getInteger(R$integer.OSSemiBoldWeight), false) : Typeface.create(Typeface.SANS_SERIF, 0);
            TextView textView = (TextView) viewFindViewById;
            List list = this.f5751l;
            CharSequence charSequence2 = (list == null || i8 < 0 || i8 >= list.size()) ? null : (CharSequence) this.f5751l.get(i8);
            if (charSequence2 != null) {
                textView.setText(charSequence2);
            }
            textView.setTypeface(typefaceCreate);
            ColorStateList colorStateList = this.f5750k;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            } else {
                Integer num = this.f5749j;
                if (num != null) {
                    textView.setTextColor(num.intValue());
                }
            }
        }
        View viewFindViewById2 = view.findViewById(this.e);
        if (viewFindViewById2 instanceof TextView) {
            TextView textView2 = (TextView) viewFindViewById2;
            List list2 = this.f5752m;
            CharSequence charSequence3 = (list2 == null || i8 < 0 || i8 >= list2.size()) ? null : (CharSequence) this.f5752m.get(i8);
            if (charSequence3 == null || charSequence3.length() <= 0) {
                viewFindViewById2.setVisibility(8);
            } else {
                viewFindViewById2.setSelected(false);
                textView2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                textView2.setText(charSequence3);
                ColorStateList colorStateList2 = this.f5754o;
                if (colorStateList2 != null) {
                    textView2.setTextColor(colorStateList2);
                } else {
                    Integer num2 = this.f5753n;
                    if (num2 != null) {
                        textView2.setTextColor(num2.intValue());
                    } else {
                        ColorStateList colorStateList3 = this.f5750k;
                        if (colorStateList3 != null) {
                            textView2.setTextColor(colorStateList3);
                        } else {
                            Integer num3 = this.f5749j;
                            if (num3 != null) {
                                textView2.setTextColor(num3.intValue());
                            }
                        }
                    }
                }
                viewFindViewById2.setVisibility(0);
            }
        }
        View viewFindViewById3 = view.findViewById(this.f5747h);
        if (viewFindViewById3 instanceof OSIconTextView) {
            OSIconTextView oSIconTextView = (OSIconTextView) viewFindViewById3;
            List list3 = this.q;
            CharSequence charSequence4 = (list3 == null || i8 < 0 || i8 >= list3.size()) ? null : (CharSequence) this.q.get(i8);
            if (charSequence4 != null && charSequence4.length() != 0) {
                charSequence = charSequence4;
            }
            if (charSequence == null || charSequence.length() <= 0) {
                viewFindViewById3.setVisibility(8);
            } else {
                oSIconTextView.setText(charSequence);
                viewFindViewById3.setSelected(z2);
                ColorStateList colorStateList4 = this.f5756s;
                if (colorStateList4 != null) {
                    oSIconTextView.setTextColor(colorStateList4);
                } else {
                    Integer num4 = this.f5755r;
                    if (num4 != null) {
                        oSIconTextView.setTextColor(num4.intValue());
                    } else {
                        ColorStateList colorStateList5 = this.f5750k;
                        if (colorStateList5 != null) {
                            oSIconTextView.setTextColor(colorStateList5);
                        } else {
                            Integer num5 = this.f5749j;
                            if (num5 != null) {
                                oSIconTextView.setTextColor(num5.intValue());
                            }
                        }
                    }
                }
                viewFindViewById3.setVisibility(0);
            }
        }
        View viewFindViewById4 = view.findViewById(this.f5748i);
        if (viewFindViewById4 instanceof TextView) {
            CharSequence charSequence5 = this.p;
            if (charSequence5 == null || charSequence5.length() == 0) {
                viewFindViewById4.setVisibility(8);
                return;
            }
            OSIconTextView oSIconTextView2 = (OSIconTextView) viewFindViewById4;
            oSIconTextView2.setText(charSequence5);
            viewFindViewById4.setSelected(z2);
            ColorStateList colorStateList6 = this.u;
            if (colorStateList6 != null) {
                oSIconTextView2.setTextColor(colorStateList6);
            } else {
                Integer num6 = this.f5757t;
                if (num6 != null) {
                    oSIconTextView2.setTextColor(num6.intValue());
                } else {
                    ColorStateList colorStateList7 = this.f5750k;
                    if (colorStateList7 != null) {
                        oSIconTextView2.setTextColor(colorStateList7);
                    } else {
                        Integer num7 = this.f5749j;
                        if (num7 != null) {
                            oSIconTextView2.setTextColor(num7.intValue());
                        }
                    }
                }
            }
            oSIconTextView2.setTextSize(1, 16.0f);
            viewFindViewById4.setVisibility(z2 ? 0 : 4);
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i8, View view, ViewGroup viewGroup) {
        View dropDownView = super.getDropDownView(i8, view, viewGroup);
        if (dropDownView != null) {
            c(dropDownView, isEnabled(i8));
            if (this.f5745c) {
                b(i8, dropDownView);
            }
        }
        return dropDownView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i8, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i8, view, viewGroup);
        if (view2 != null) {
            c(view2, isEnabled(i8));
            b(i8, view2);
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i8) {
        return !this.f5743a.contains(Integer.valueOf(i8));
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    public void setDropDownSpinner(boolean z2) {
        this.f5745c = z2;
    }

    public void setLeftTextIcon(CharSequence charSequence) {
        if (charSequence == null) {
            return;
        }
        int count = getCount();
        ArrayList arrayList = new ArrayList(count);
        for (int i8 = 0; i8 < count; i8++) {
            arrayList.add(charSequence);
        }
        this.q = arrayList;
        notifyDataSetChanged();
    }

    public void setLeftTextIconColor(Integer num) {
        this.f5755r = num;
    }

    public void setLeftTextIconColorStateList(ColorStateList colorStateList) {
        this.f5756s = colorStateList;
    }

    public void setLeftTextIconResource(@StringRes int i8) {
        CharSequence text = getContext().getResources().getText(i8);
        int count = getCount();
        ArrayList arrayList = new ArrayList(count);
        for (int i9 = 0; i9 < count; i9++) {
            arrayList.add(text);
        }
        this.q = arrayList;
        notifyDataSetChanged();
    }

    public void setLeftTextIconsResource(@NonNull List<Integer> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Integer num : list) {
            if (num == null || num.intValue() == 0) {
                arrayList.add("");
            } else {
                arrayList.add(getContext().getResources().getText(num.intValue()));
            }
        }
        this.q = arrayList;
        notifyDataSetChanged();
    }

    public void setMainTextArrayResource(@ArrayRes int i8) {
        this.f5751l = Arrays.asList(getContext().getResources().getTextArray(i8));
        notifyDataSetChanged();
    }

    public void setMainTexts(@Nullable List<CharSequence> list) {
        this.f5751l = list;
        notifyDataSetChanged();
    }

    public void setRightTextIcon(CharSequence charSequence) {
        this.p = charSequence;
        notifyDataSetChanged();
    }

    public void setRightTextIconColor(Integer num) {
        this.f5757t = num;
    }

    public void setRightTextIconColorStateList(ColorStateList colorStateList) {
        this.u = colorStateList;
    }

    public void setRightTextIconResource(@StringRes int i8) {
        this.p = getContext().getResources().getText(i8);
        notifyDataSetChanged();
    }

    public void setSelected(int i8) {
        if (i8 < 0 || i8 >= getCount()) {
            return;
        }
        this.f5744b = getItem(i8);
    }

    public void setSubTextArrayResource(@ArrayRes int i8) {
        this.f5752m = Arrays.asList(getContext().getResources().getTextArray(i8));
    }

    public void setSubTextColor(Integer num) {
        this.f5753n = num;
    }

    public void setSubTextColorStateList(ColorStateList colorStateList) {
        this.f5754o = colorStateList;
    }

    public void setSubTexts(List<CharSequence> list) {
        this.f5752m = list;
    }

    public void setTextViewColor(Integer num) {
        this.f5749j = num;
    }

    public void setTextViewColorStateList(ColorStateList colorStateList) {
        this.f5750k = colorStateList;
    }

    public void setSelected(@Nullable Object obj) {
        getPosition(obj);
        this.f5744b = obj;
    }

    public void setLeftTextIcon(List<CharSequence> list) {
        this.q = list;
        notifyDataSetChanged();
    }
}
