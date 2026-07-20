package ld;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R$bool;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$style;
import gd.p;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f7401a;

    public m(ContextThemeWrapper contextThemeWrapper, int i8) {
        super(contextThemeWrapper, a(contextThemeWrapper, i8));
        this.f7401a = new j(getContext(), this, getWindow());
    }

    public static int a(Context context, int i8) {
        return i8 >= 16777216 ? i8 : R$style.OS_Dialog_Alert_Base;
    }

    public View getListView() {
        return this.f7401a.getListView();
    }

    /* JADX WARN: Code duplicated, block: B:175:0x0410  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v13, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        boolean z2;
        int dimension;
        float dimension2;
        int iA;
        int i8;
        Window window;
        View viewFindViewById;
        WindowManager windowManager;
        TextView titleView;
        super.onCreate(bundle);
        j jVar = this.f7401a;
        jVar.f7380c.setContentView(jVar.f);
        ConstraintLayout constraintLayout = jVar.f7382g;
        constraintLayout.removeAllViews();
        LinearLayout linearLayout = jVar.f7383h;
        linearLayout.removeAllViews();
        LinearLayout linearLayout2 = jVar.f7384i;
        boolean z3 = linearLayout2 != null;
        boolean z5 = jVar.f7385j != null;
        boolean z10 = jVar.f7386k != null;
        boolean z11 = jVar.f7387l != null;
        if (z3) {
            linearLayout2.setId(R$id.os_module_dialog_damping_layout_title);
        }
        Context context = jVar.f7378a;
        if (z5 && (!jVar.I || jVar.P != 1)) {
            if (z3) {
                jVar.f7385j.setPadding(0, (int) context.getResources().getDimension(R$dimen.os_dialog_message_padding_top), 0, 0);
            } else if (z10) {
                jVar.f7385j.setPadding(0, 0, 0, (int) context.getResources().getDimension(R$dimen.os_dialog_message_padding_bottom));
            } else {
                jVar.f7385j.setPadding(0, 0, 0, 0);
            }
            jVar.f7385j.setId(R$id.os_module_dialog_damping_layout_content);
            if (z3) {
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, 0);
                layoutParams.topToBottom = R$id.os_module_dialog_damping_layout_title;
                layoutParams.bottomToBottom = 0;
                layoutParams.matchConstraintDefaultHeight = 1;
                layoutParams.verticalBias = 0.0f;
                constraintLayout.addView(jVar.f7385j, layoutParams);
            } else {
                ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, 0);
                layoutParams2.topToTop = 0;
                layoutParams2.bottomToBottom = 0;
                layoutParams2.matchConstraintDefaultHeight = 1;
                layoutParams2.verticalBias = 0.0f;
                constraintLayout.addView(jVar.f7385j, layoutParams2);
            }
        }
        if (z11 && !z5) {
            ViewGroup viewGroup = (ViewGroup) jVar.f7387l.getParent();
            if (z3) {
                ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-1, 0);
                layoutParams3.topToBottom = R$id.os_module_dialog_damping_layout_title;
                layoutParams3.bottomToBottom = 0;
                layoutParams3.matchConstraintDefaultHeight = 1;
                layoutParams3.verticalBias = 0.0f;
                constraintLayout.addView(viewGroup, layoutParams3);
            } else {
                ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-1, 0);
                layoutParams4.topToTop = 0;
                layoutParams4.bottomToBottom = 0;
                layoutParams4.matchConstraintDefaultHeight = 1;
                layoutParams4.verticalBias = 0.0f;
                constraintLayout.addView(viewGroup, layoutParams4);
            }
        }
        if (z11 && z3 && (titleView = jVar.getTitleView()) != null) {
            titleView.setPaddingRelative(0, 0, 0, (int) context.getResources().getDimension(R$dimen.os_dialog_title_padding_bottom));
            if (!jVar.f7393t && !jVar.f7397y && !jVar.C) {
                constraintLayout.setPadding(0, 0, 0, (int) context.getResources().getDimension(R$dimen.os_list_dialog_margin_bottom));
            }
        }
        if (z11 && !z3) {
            constraintLayout.setPadding(0, 0, 0, 0);
        }
        if (z10) {
            if (z5) {
                ViewGroup.LayoutParams layoutParams5 = jVar.f7385j.getLayoutParams();
                if (layoutParams5 instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
                    if (((ViewGroup.MarginLayoutParams) layoutParams6).height != -2) {
                        ((ViewGroup.MarginLayoutParams) layoutParams6).height = -2;
                        jVar.f7385j.setLayoutParams(layoutParams6);
                    }
                }
            } else if (z11 && constraintLayout.indexOfChild((ViewGroup) jVar.f7387l.getParent()) != -1) {
                ViewGroup viewGroup2 = (ViewGroup) jVar.f7387l.getParent();
                ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) jVar.f7386k.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams7).height = -2;
                layoutParams7.bottomToBottom = 0;
                jVar.f7386k.setLayoutParams(layoutParams7);
                jVar.f7386k.setId(R$id.os_module_dialog_custom_view);
                if (jVar.f7386k.getParent() != null) {
                    ((ViewGroup) jVar.f7386k.getParent()).removeView(jVar.f7386k);
                }
                constraintLayout.addView(jVar.f7386k, layoutParams7);
                ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) viewGroup2.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams8).height = 0;
                layoutParams8.matchConstraintDefaultHeight = 1;
                if (z3) {
                    layoutParams8.topToBottom = R$id.os_module_dialog_damping_layout_title;
                } else {
                    layoutParams8.topToTop = 0;
                }
                layoutParams8.bottomToTop = R$id.os_module_dialog_custom_view;
                layoutParams8.verticalBias = 0.0f;
                viewGroup2.setLayoutParams(layoutParams8);
            }
            if (z5) {
                if (jVar.I && jVar.P == 1) {
                    jVar.f7386k.setId(R$id.os_module_dialog_custom_view);
                    FrameLayout frameLayout = jVar.f7386k;
                    ConstraintLayout.LayoutParams layoutParams9 = new ConstraintLayout.LayoutParams(-1, -2);
                    layoutParams9.topToBottom = R$id.os_module_dialog_damping_layout_title;
                    constraintLayout.addView(frameLayout, layoutParams9);
                    jVar.f7385j.setId(R$id.os_module_dialog_damping_layout_content);
                    ConstraintLayout.LayoutParams layoutParams10 = new ConstraintLayout.LayoutParams(-1, 0);
                    layoutParams10.topToBottom = R$id.os_module_dialog_custom_view;
                    layoutParams10.bottomToBottom = 0;
                    ((ViewGroup.MarginLayoutParams) layoutParams10).topMargin = context.getResources().getDimensionPixelOffset(R$dimen.os_dialog_input_message_margin_top);
                    ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin = context.getResources().getDimensionPixelOffset(R$dimen.os_dialog_input_message_margin_bottom);
                    layoutParams10.matchConstraintDefaultHeight = 1;
                    layoutParams10.verticalBias = 0.0f;
                    constraintLayout.addView(jVar.f7385j, layoutParams10);
                    jVar.f7385j.setElevation(-1.0f);
                } else {
                    jVar.f7386k.setId(R$id.os_module_dialog_custom_view);
                    ConstraintLayout.LayoutParams layoutParams11 = new ConstraintLayout.LayoutParams(-1, -2);
                    layoutParams11.topToBottom = R$id.os_module_dialog_damping_layout_content;
                    layoutParams11.bottomToBottom = 0;
                    constraintLayout.addView(jVar.f7386k, layoutParams11);
                    ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) jVar.f7385j.getLayoutParams();
                    ((ViewGroup.MarginLayoutParams) layoutParams12).height = 0;
                    layoutParams12.bottomToTop = R$id.os_module_dialog_custom_view;
                    layoutParams12.matchConstraintDefaultHeight = 1;
                    layoutParams12.verticalBias = 0.0f;
                    jVar.f7385j.setLayoutParams(layoutParams12);
                    jVar.f7385j.setElevation(-1.0f);
                }
            } else if (z11) {
                ViewGroup viewGroup3 = (ViewGroup) jVar.f7387l.getParent();
                viewGroup3.post(new a(jVar, viewGroup3, z3));
            } else {
                jVar.f7386k.setId(R$id.os_module_dialog_custom_view);
                if (z3) {
                    ConstraintLayout.LayoutParams layoutParams13 = new ConstraintLayout.LayoutParams(-1, 0);
                    layoutParams13.topToBottom = R$id.os_module_dialog_damping_layout_title;
                    layoutParams13.bottomToBottom = 0;
                    layoutParams13.matchConstraintDefaultHeight = 1;
                    layoutParams13.verticalBias = 0.0f;
                    constraintLayout.addView(jVar.f7386k, layoutParams13);
                } else {
                    ConstraintLayout.LayoutParams layoutParams14 = new ConstraintLayout.LayoutParams(-1, 0);
                    layoutParams14.topToTop = 0;
                    layoutParams14.bottomToBottom = 0;
                    layoutParams14.matchConstraintDefaultHeight = 1;
                    layoutParams14.verticalBias = 0.0f;
                    constraintLayout.addView(jVar.f7386k, layoutParams14);
                }
            }
        }
        if (z3 && constraintLayout.indexOfChild(jVar.f7384i) == -1) {
            LinearLayout linearLayout3 = jVar.f7384i;
            ConstraintLayout.LayoutParams layoutParams15 = new ConstraintLayout.LayoutParams(-1, -2);
            layoutParams15.topToTop = R$id.mContainer;
            constraintLayout.addView(linearLayout3, layoutParams15);
        }
        if (jVar.f7393t || jVar.f7397y || jVar.C) {
            if (pd.j.z(context)) {
                jVar.f7391r = true;
            }
            CharSequence charSequence = jVar.f7395w;
            String string = charSequence != null ? charSequence.toString() : "";
            CharSequence charSequence2 = jVar.A;
            String string2 = charSequence2 != null ? charSequence2.toString() : "";
            CharSequence charSequence3 = jVar.E;
            String[] strArr = {string, string2, charSequence3 != null ? charSequence3.toString() : ""};
            int length = 0;
            String str = "";
            for (int i9 = 0; i9 < 3; i9++) {
                String str2 = strArr[i9];
                if (str2.length() >= length) {
                    length = str2.length();
                    str = str2;
                }
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(Typeface.create("sans-serif-medium", 0));
            textPaint.setTextSize(context.getResources().getDimensionPixelSize(R$dimen.os_dialog_button_text_size));
            ?? r10 = jVar.f7393t;
            int i10 = r10;
            if (jVar.f7397y) {
                i10 = r10 + 1;
            }
            int i11 = i10;
            if (jVar.C) {
                i11 = i10 + 1;
            }
            float fMeasureText = textPaint.measureText(str);
            if (context.getResources().getDisplayMetrics().density > 3.0f) {
                fMeasureText += textPaint.measureText(str) - textPaint.measureText(str.replace(" ", ""));
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.os_dialog_margin_horizontal) * 2;
            int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.os_space075) * 2;
            int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R$dimen.os_btn_text_padding) * 2;
            if (i11 > 0) {
                float fG = pd.j.g(context, R$dimen.os_dialog_large_screen_width_weight);
                if (pd.j.t(context) && (!pd.j.r(context) || pd.j.m(context) || pd.j.u(context))) {
                    if (pd.j.p(context)) {
                        i8 = (context.getResources().getBoolean(R$bool.os_flag_refs_pad_value) && pd.j.w(context)) ? pd.j.i(context) : pd.j.j(context);
                        iA = (int) (i8 * fG);
                    } else {
                        iA = Math.min((int) ((pd.j.w(context) ? pd.j.i(context) : pd.j.j(context)) * 0.5f), hd.a.a(context, 400));
                    }
                } else if (pd.j.x(context) || ((!pd.j.x(context) && pd.j.r(context)) || pd.j.z(context))) {
                    int iA2 = context.getResources().getDisplayMetrics().widthPixels;
                    if (iA2 <= 70) {
                        iA2 = hd.a.a(context, context.getResources().getConfiguration().screenWidthDp);
                    }
                    iA = iA2 - (hd.a.a(context, 16) * 2);
                } else {
                    i8 = context.getResources().getDisplayMetrics().widthPixels;
                    iA = (int) (i8 * fG);
                }
                z2 = fMeasureText > (((((float) iA) - ((float) dimensionPixelSize)) / ((float) i11)) - ((float) dimensionPixelSize2)) - ((float) dimensionPixelSize3);
            }
            boolean z12 = jVar.f7391r;
            LayoutInflater layoutInflater = jVar.f7381d;
            if (!z12) {
                jVar.f7391r = z2;
                jVar.f7388m = layoutInflater.inflate(z2 ? R$layout.os_prompt_dialog_buttons_vertical : R$layout.os_prompt_dialog_buttons_horizontal, (ViewGroup) linearLayout, false);
            } else if (pd.j.s()) {
                jVar.f7388m = layoutInflater.inflate(R$layout.os_ultra_small_prompt_dialog_buttons_vertical, (ViewGroup) linearLayout, false);
            } else {
                jVar.f7388m = layoutInflater.inflate(R$layout.os_prompt_dialog_buttons_vertical, (ViewGroup) linearLayout, false);
            }
            jVar.f7388m.findViewById(R$id.view_divider);
            jVar.f7394v = (Button) jVar.f7388m.findViewById(R$id.btn_positive);
            jVar.f7398z = (Button) jVar.f7388m.findViewById(R$id.btn_negative);
            jVar.D = (Button) jVar.f7388m.findViewById(R$id.btn_neutral);
            if (pd.j.s()) {
                jVar.f7394v.setBackgroundResource(R$drawable.os_ultra_small_btn_big);
                jVar.f7398z.setBackgroundResource(R$drawable.os_ultra_small_btn_big_gray);
                jVar.D.setBackgroundResource(R$drawable.os_ultra_small_btn_big_gray);
            }
            if (pd.j.f8768g) {
                jVar.f7394v.setBackgroundResource(R$drawable.os_pad_btn_big);
                jVar.f7398z.setBackgroundResource(R$drawable.os_pad_btn_big_gray);
                jVar.D.setBackgroundResource(R$drawable.os_pad_btn_big_gray);
            }
            boolean z13 = jVar.f7393t;
            ce.c cVar = jVar.Q;
            if (z13) {
                jVar.f7394v.setText(jVar.f7395w);
                Button button = jVar.f7394v;
                button.getViewTreeObserver().addOnGlobalLayoutListener(new p(jVar, button));
                jVar.f7394v.setOnClickListener(cVar);
                jVar.f7394v.setEnabled(jVar.u);
                if (jVar.f7392s) {
                    jVar.f7394v.setTextColor(ContextCompat.getColor(context, R$color.os_dialog_positive_btn_alert_color));
                }
            } else {
                jVar.f7394v.setVisibility(8);
            }
            if (jVar.f7397y) {
                jVar.f7398z.setText(jVar.A);
                Button button2 = jVar.f7398z;
                button2.getViewTreeObserver().addOnGlobalLayoutListener(new p(jVar, button2));
                jVar.f7398z.setOnClickListener(cVar);
            } else {
                jVar.f7398z.setVisibility(8);
            }
            if (jVar.C) {
                jVar.D.setText(jVar.E);
                Button button3 = jVar.D;
                button3.getViewTreeObserver().addOnGlobalLayoutListener(new p(jVar, button3));
                jVar.D.setOnClickListener(cVar);
            } else {
                jVar.D.setVisibility(8);
            }
            if (jVar.f7391r && jVar.f7393t && jVar.f7397y && jVar.C) {
                jVar.f7398z.setTextColor(ContextCompat.getColorStateList(context, R$color.os_dialog_negative_btn_text_color));
            }
            linearLayout.addView(jVar.f7388m);
            int dimensionPixelSize4 = context.getResources().getDimensionPixelSize(R$dimen.os_dialog_button_margin_bottom);
            int dimensionPixelSize5 = context.getResources().getDimensionPixelSize(R$dimen.os_dialog_button_margin_bottom);
            if (pd.j.s()) {
                dimension = (int) context.getResources().getDimension(R$dimen.os_ultra_small_dialog_button_height);
                dimension2 = context.getResources().getDimension(R$dimen.os_ultra_small_space150);
            } else {
                dimension = (int) context.getResources().getDimension(R$dimen.os_dialog_button_height);
                dimension2 = context.getResources().getDimension(R$dimen.os_space150);
            }
            int i12 = (int) dimension2;
            if (jVar.f7391r) {
                int i13 = (jVar.f7393t ? 1 : 0) * dimension;
                int i14 = dimension + i12;
                dimension = (i14 * (jVar.C ? 1 : 0)) + ((jVar.f7397y ? 1 : 0) * i14) + i13;
            }
            int i15 = dimensionPixelSize4 + dimensionPixelSize5;
            if (!jVar.J) {
                dimensionPixelSize5 = i15;
            }
            ((FrameLayout.LayoutParams) constraintLayout.getLayoutParams()).setMargins(0, 0, 0, dimension + dimensionPixelSize5);
        } else {
            ((FrameLayout.LayoutParams) constraintLayout.getLayoutParams()).setMargins(0, 0, 0, jVar.L);
        }
        getContext();
        if (pd.j.s()) {
            pd.j.setUltraSmallModeDialogWidth(this);
        } else {
            pd.j.setDialogWidth(this);
        }
        getContext();
        if (!pd.j.f8768g || (window = getWindow()) == null || (viewFindViewById = window.findViewById(R.id.content)) == null || (windowManager = (WindowManager) getContext().getSystemService("window")) == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        viewFindViewById.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE));
        int measuredHeight = viewFindViewById.getMeasuredHeight();
        int i16 = (int) ((pd.j.w(getContext()) ? pd.j.i(getContext()) : pd.j.j(getContext())) * 0.85f);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (measuredHeight > i16) {
            attributes.height = i16;
            window.setAttributes(attributes);
        }
    }

    public void setDimAmount(float f) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = f;
        window.addFlags(2);
        window.setAttributes(attributes);
    }

    public void setMessage(CharSequence charSequence) {
        this.f7401a.setMessage(charSequence);
    }

    public void setOnPromptDialogStatusChangedListener(l lVar) {
    }

    public void setPromptDialogPaddingTop(int i8) {
        this.f7401a.setPromptDialogPaddingTop(i8);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.f7401a.setTitle(charSequence);
    }

    public void setTitleTextAlignment(int i8) {
        TextView titleView;
        j jVar = this.f7401a;
        if (jVar == null || (titleView = jVar.getTitleView()) == null) {
            return;
        }
        titleView.setTextAlignment(i8);
    }

    public void setTitleTextAppearance(int i8) {
        TextView titleView;
        j jVar = this.f7401a;
        if (jVar == null || (titleView = jVar.getTitleView()) == null) {
            return;
        }
        titleView.setTextAppearance(i8);
    }

    public void setTitleTextDirection(int i8) {
        TextView titleView;
        j jVar = this.f7401a;
        if (jVar == null || (titleView = jVar.getTitleView()) == null) {
            return;
        }
        titleView.setTextDirection(i8);
    }

    public void setTitleViewBg(@ColorInt int i8) {
        this.f7401a.setTitleViewBg(i8);
    }

    public void setTopTitle(int i8) {
        this.f7401a.setTopTitle(getContext().getResources().getString(i8));
    }

    public void setView(View view) {
        this.f7401a.f(0, view);
    }

    public void setTopTitle(CharSequence charSequence) {
        this.f7401a.setTopTitle(charSequence);
    }
}
