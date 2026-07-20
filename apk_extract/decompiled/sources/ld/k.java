package ld;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Window;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R$bool;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$string;
import com.transsion.widgetslib.R$style;
import java.util.Arrays;
import k3.z8;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f7399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f7400b;

    public k(Context context) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, m.a(context, 0));
        this.f7400b = new n(contextThemeWrapper);
        this.f7399a = new m(contextThemeWrapper, m.a(context, 0));
    }

    public final m a() {
        InsetDrawable insetDrawable;
        int dimension;
        InsetDrawable insetDrawable2;
        InsetDrawable insetDrawable3;
        n nVar = this.f7400b;
        j jVar = this.f7399a.f7401a;
        CharSequence charSequence = nVar.f7403b;
        if (charSequence != null) {
            String strE = pd.j.E(charSequence.toString());
            nVar.f7403b = strE;
            nVar.f7403b = pd.j.b(strE.toString());
        }
        CharSequence charSequence2 = nVar.f7405d;
        if (charSequence2 != null) {
            nVar.f7405d = pd.j.b(charSequence2.toString());
        }
        CharSequence charSequence3 = nVar.e;
        if (charSequence3 != null) {
            String strE2 = pd.j.E(charSequence3.toString());
            nVar.e = strE2;
            nVar.e = pd.j.b(strE2.toString());
        }
        CharSequence charSequence4 = nVar.f7406g;
        if (charSequence4 != null) {
            String strE3 = pd.j.E(charSequence4.toString());
            nVar.f7406g = strE3;
            nVar.f7406g = pd.j.b(strE3.toString());
        }
        String str = nVar.f7408i;
        if (str != null) {
            String strE4 = pd.j.E(str.toString());
            nVar.f7408i = strE4;
            nVar.f7408i = pd.j.b(strE4.toString());
        }
        String str2 = nVar.f7419w;
        if (str2 != null) {
            String strE5 = pd.j.E(str2.toString());
            nVar.f7419w = strE5;
            nVar.f7419w = pd.j.b(strE5.toString());
        }
        CharSequence[] charSequenceArr = nVar.f7414o;
        if (charSequenceArr != null) {
            String[] strArr = pd.j.f8764a;
            CharSequence[] charSequenceArr2 = (CharSequence[]) charSequenceArr.clone();
            synchronized (charSequenceArr2) {
                for (int i8 = 0; i8 < charSequenceArr2.length; i8++) {
                    try {
                        charSequenceArr2[i8] = pd.j.b(pd.j.E(charSequenceArr2[i8].toString()).toString());
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            nVar.f7414o = charSequenceArr2;
        }
        jVar.setTopTitle(null);
        jVar.setTitleView(nVar.f7403b);
        jVar.setIcon(nVar.f7404c);
        jVar.setMessageView(nVar.f7405d);
        jVar.f(0, nVar.f7413n);
        jVar.setIsAlert(false);
        jVar.e(-1, nVar.e, nVar.f);
        jVar.setPositiveButtonEnable(true);
        jVar.e(-2, nVar.f7406g, nVar.f7407h);
        jVar.e(-3, nVar.f7408i, null);
        jVar.setButtonVertical(false);
        jVar.setNoBtnBottomInsets(0);
        jVar.setInputMessagePosition(0);
        if (nVar.q) {
            CharSequence[] charSequenceArr3 = nVar.f7414o;
            if (charSequenceArr3 != null) {
                boolean[] zArr = nVar.f7416s;
                DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener = nVar.f7417t;
                if (zArr == null) {
                    jVar.q = new boolean[charSequenceArr3.length];
                } else if (charSequenceArr3.length == zArr.length) {
                    jVar.q = zArr;
                } else {
                    jVar.q = new boolean[charSequenceArr3.length];
                    int i9 = 0;
                    while (i9 < charSequenceArr3.length) {
                        jVar.q[i9] = i9 < zArr.length && zArr[i9];
                        i9++;
                    }
                }
                jVar.f7387l = jVar.c(new h(Arrays.asList(charSequenceArr3), 2), new f(jVar, onMultiChoiceClickListener));
            }
        } else if (nVar.f7415r) {
            CharSequence[] charSequenceArr4 = nVar.f7414o;
            if (charSequenceArr4 != null) {
                jVar.f7387l = jVar.c(new h(Arrays.asList(charSequenceArr4), 1), new e(jVar, nVar.p));
            }
        } else {
            CharSequence[] charSequenceArr5 = nVar.f7414o;
            if (charSequenceArr5 != null) {
                jVar.f7387l = jVar.c(new h(Arrays.asList(charSequenceArr5), 0), new d(jVar, nVar.p));
            }
        }
        String str3 = nVar.f7419w;
        if (str3 != null) {
            DialogInterface.OnClickListener onClickListener = nVar.p;
            if (!TextUtils.isEmpty(str3)) {
                Context context = jVar.f7378a;
                if (pd.j.s()) {
                    jVar.f(R$layout.os_ultra_small_prompt_dialog_singlechecked, null);
                } else {
                    jVar.f(R$layout.os_prompt_dialog_singlechecked, null);
                }
                FrameLayout frameLayout = jVar.f7386k;
                if (frameLayout != null) {
                    CheckedTextView checkedTextView = (CheckedTextView) frameLayout.findViewById(R$id.text_choice);
                    jVar.f7389n = checkedTextView;
                    checkedTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(new md.c(context, false), (Drawable) null, (Drawable) null, (Drawable) null);
                    CheckedTextView checkedTextView2 = jVar.f7389n;
                    if (checkedTextView2 != null) {
                        checkedTextView2.setText(str3);
                        jVar.f7389n.setChecked(false);
                        jVar.f7389n.setOnClickListener(new c(jVar, onClickListener));
                    }
                }
            }
        }
        if (nVar.f7415r) {
            jVar.setCheckedItem(nVar.u);
        }
        jVar.setAutoDismiss(true);
        jVar.setIsInputDialog(nVar.f7418v);
        jVar.setButtonChoiceDialog(false);
        jVar.setIsAppDialogFragment(false);
        jVar.setCancelable(nVar.f7409j);
        jVar.setCanceledOnTouchOutside(nVar.f7410k);
        this.f7399a.setCancelable(this.f7400b.f7409j);
        this.f7399a.setCanceledOnTouchOutside(this.f7400b.f7410k);
        this.f7400b.getClass();
        this.f7399a.setOnCancelListener(this.f7400b.f7411l);
        m mVar = this.f7399a;
        this.f7400b.getClass();
        mVar.setOnDismissListener(null);
        DialogInterface.OnKeyListener onKeyListener = this.f7400b.f7412m;
        if (onKeyListener != null) {
            this.f7399a.setOnKeyListener(onKeyListener);
        }
        ContextThemeWrapper contextThemeWrapper = this.f7400b.f7402a;
        if (pd.j.s()) {
            n nVar2 = this.f7400b;
            ContextThemeWrapper contextThemeWrapper2 = nVar2.f7402a;
            m mVar2 = this.f7399a;
            boolean z2 = nVar2.f7409j;
            boolean z3 = nVar2.f7410k;
            mVar2.f7401a.d();
            Resources resources = contextThemeWrapper2.getResources();
            Drawable drawable = ContextCompat.getDrawable(contextThemeWrapper2, R$drawable.os_smooth_corner12);
            if (resources.getConfiguration().orientation == 1) {
                mVar2.getWindow().setBackgroundDrawable(new InsetDrawable(drawable, hd.a.a(contextThemeWrapper2, 16), ((int) resources.getDimension(R$dimen.os_ultra_small_dialog_top_margin)) - pd.j.l(contextThemeWrapper2), hd.a.a(contextThemeWrapper2, 16), (int) contextThemeWrapper2.getResources().getDimension(R$dimen.os_ultra_small_dialog_bottom_margin_with_navigation_bar)));
                mVar2.getWindow().setGravity(80);
                mVar2.getWindow().setWindowAnimations(pd.j.f8772k ? R$style.OS_Animation_Dialog : R$style.OsInputDialogAnimStyle);
            } else {
                mVar2.getWindow().setBackgroundDrawable(new InsetDrawable(drawable, 0, hd.a.a(contextThemeWrapper2, 20), 0, (int) contextThemeWrapper2.getResources().getDimension(R$dimen.os_ultra_small_dialog_bottom_margin_with_navigation_bar)));
                mVar2.getWindow().setGravity(80);
                mVar2.getWindow().setWindowAnimations(R$style.OsInputDialogAnimStyle);
            }
            mVar2.getWindow().getDecorView().setOnTouchListener(new pd.i(z2, z3, mVar2));
            if (pd.j.e) {
                mVar2.getWindow().setTitle(contextThemeWrapper2.getString(R$string.os_string_fold_dialog_title_verify));
                mVar2.getWindow().getAttributes().setTitle(contextThemeWrapper2.getString(R$string.os_string_fold_dialog_title_verify));
            }
        } else {
            n nVar3 = this.f7400b;
            ContextThemeWrapper contextThemeWrapper3 = nVar3.f7402a;
            m mVar3 = this.f7399a;
            boolean z5 = nVar3.f7409j;
            boolean z10 = nVar3.f7410k;
            boolean zD = mVar3.f7401a.d();
            if (pd.j.t(contextThemeWrapper3) && (!pd.j.r(contextThemeWrapper3) || pd.j.m(contextThemeWrapper3) || pd.j.u(contextThemeWrapper3))) {
                Drawable drawable2 = pd.j.f8768g ? ContextCompat.getDrawable(contextThemeWrapper3, R$drawable.os_smooth_corner12) : ContextCompat.getDrawable(contextThemeWrapper3, R$drawable.os_smooth_corner20);
                if (zD) {
                    insetDrawable3 = new InsetDrawable(drawable2, 0, hd.a.a(contextThemeWrapper3, 10), 0, hd.a.a(contextThemeWrapper3, 10));
                } else {
                    z8.b("widgetslib.Utils", "isGestureNavigationBarOn: " + pd.j.q(contextThemeWrapper3));
                    insetDrawable3 = contextThemeWrapper3.getResources().getBoolean(R$bool.os_flag_refs_pad_value) ? new InsetDrawable(drawable2, 0, 0, 0, 0) : new InsetDrawable(drawable2, 0, (int) contextThemeWrapper3.getResources().getDimension(R$dimen.os_dimen_fold_dialog_top_bottom_inset), 0, (int) contextThemeWrapper3.getResources().getDimension(R$dimen.os_dimen_fold_dialog_top_bottom_inset));
                }
                insetDrawable3.setTint(0);
                mVar3.getWindow().setBackgroundDrawable(insetDrawable3);
                mVar3.getWindow().setGravity(17);
                mVar3.getWindow().setWindowAnimations(R$style.OS_Animation_Fold_Dialog);
            } else if (pd.j.z(contextThemeWrapper3)) {
                Drawable drawable3 = ContextCompat.getDrawable(contextThemeWrapper3, R$drawable.os_dialog_background_small);
                mVar3.getWindow().setGravity(17);
                mVar3.getWindow().setWindowAnimations(R$style.OS_Animation_Fold_Dialog);
                mVar3.getWindow().setBackgroundDrawable(drawable3);
            } else if (zD) {
                Window window = mVar3.getWindow();
                if (window == null) {
                    Log.i("widgetslib.Utils", "setDialogWindowBackGround window null return");
                } else {
                    Resources resources2 = contextThemeWrapper3.getResources();
                    Drawable drawable4 = ContextCompat.getDrawable(contextThemeWrapper3, R$drawable.os_smooth_corner20);
                    if (resources2.getConfiguration().orientation == 1) {
                        insetDrawable2 = pd.j.q(contextThemeWrapper3) ? new InsetDrawable(drawable4, hd.a.a(contextThemeWrapper3, 16), 0, hd.a.a(contextThemeWrapper3, 16), (int) contextThemeWrapper3.getResources().getDimension(R$dimen.os_dialog_margin_bottom)) : new InsetDrawable(drawable4, hd.a.a(contextThemeWrapper3, 16), 0, hd.a.a(contextThemeWrapper3, 16), (int) contextThemeWrapper3.getResources().getDimension(R$dimen.os_dialog_bottom_margin_with_navigation_bar));
                        window.setGravity(80);
                    } else {
                        insetDrawable2 = new InsetDrawable(drawable4, hd.a.a(contextThemeWrapper3, 16), hd.a.a(contextThemeWrapper3, 20), hd.a.a(contextThemeWrapper3, 16), hd.a.a(contextThemeWrapper3, 20));
                        window.setGravity(17);
                    }
                    insetDrawable2.setTint(0);
                    window.setBackgroundDrawable(insetDrawable2);
                    window.setWindowAnimations(R$style.OsInputDialogAnimStyle);
                }
            } else {
                Resources resources3 = contextThemeWrapper3.getResources();
                Drawable drawable5 = ContextCompat.getDrawable(contextThemeWrapper3, R$drawable.os_smooth_corner20);
                if (resources3.getConfiguration().orientation == 1) {
                    boolean z11 = pd.j.f8772k;
                    if (z11) {
                        Resources resources4 = contextThemeWrapper3.getResources();
                        dimension = resources4.getDimensionPixelSize(resources4.getIdentifier("navigation_bar_height", "dimen", "android"));
                    } else {
                        dimension = (int) resources3.getDimension(R$dimen.os_dialog_top_margin);
                    }
                    if (pd.j.s()) {
                        dimension = (int) resources3.getDimension(R$dimen.os_ultra_small_dialog_top_margin);
                    }
                    int i10 = dimension;
                    insetDrawable = pd.j.q(contextThemeWrapper3) ? new InsetDrawable(drawable5, hd.a.a(contextThemeWrapper3, 16), i10, hd.a.a(contextThemeWrapper3, 16), (int) resources3.getDimension(R$dimen.os_dialog_bottom_margin)) : new InsetDrawable(drawable5, hd.a.a(contextThemeWrapper3, 16), i10, hd.a.a(contextThemeWrapper3, 16), (int) resources3.getDimension(R$dimen.os_dialog_bottom_margin_with_navigation_bar));
                    mVar3.getWindow().setGravity(80);
                    mVar3.getWindow().setWindowAnimations(z11 ? R$style.OS_Animation_Dialog : R$style.OsInputDialogAnimStyle);
                } else {
                    InsetDrawable insetDrawable4 = new InsetDrawable(drawable5, hd.a.a(contextThemeWrapper3, 16), hd.a.a(contextThemeWrapper3, 20), hd.a.a(contextThemeWrapper3, 16), hd.a.a(contextThemeWrapper3, 20));
                    mVar3.getWindow().setGravity(17);
                    mVar3.getWindow().setWindowAnimations(R$style.OsInputDialogAnimStyle);
                    insetDrawable = insetDrawable4;
                }
                insetDrawable.setTint(0);
                mVar3.getWindow().setBackgroundDrawable(insetDrawable);
            }
            mVar3.getWindow().getDecorView().setOnTouchListener(new pd.i(z5, z10, mVar3));
            if (pd.j.e) {
                mVar3.getWindow().setTitle(contextThemeWrapper3.getString(R$string.os_string_fold_dialog_title_verify));
                mVar3.getWindow().getAttributes().setTitle(contextThemeWrapper3.getString(R$string.os_string_fold_dialog_title_verify));
            }
        }
        return this.f7399a;
    }

    public final void b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        n nVar = this.f7400b;
        nVar.f7406g = charSequence;
        nVar.f7407h = onClickListener;
    }

    public final void c(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        n nVar = this.f7400b;
        nVar.e = charSequence;
        nVar.f = onClickListener;
    }

    public final void d(int i8) {
        n nVar = this.f7400b;
        nVar.f7403b = nVar.f7402a.getText(i8);
    }

    public final m e() {
        m mVarA = a();
        mVarA.show();
        return mVarA;
    }

    public Context getContext() {
        return this.f7400b.f7402a;
    }

    public void setInputDialog(boolean z2) {
        this.f7400b.f7418v = z2;
    }

    public k(Context context, int i8) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, m.a(context, 0));
        this.f7400b = new n(contextThemeWrapper);
        this.f7399a = new m(contextThemeWrapper, m.a(context, 0));
    }
}
