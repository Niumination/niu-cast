package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import jn.l;
import jn.r;
import k4.f;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.l2;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,97:1\n65#1:98\n77#1,4:99\n93#1,3:103\n65#1,16:106\n93#1,3:122\n65#1,16:125\n93#1,3:141\n*S KotlinDebug\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n35#1:98\n35#1:99,4\n35#1:103,3\n49#1:106,16\n49#1:122,3\n58#1:125,16\n58#1:141,3\n*E\n"})
public final class TextViewKt {

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$1, reason: invalid class name */
    @r1({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n*L\n1#1,97:1\n*E\n"})
    public static final class AnonymousClass1 extends n0 implements r<CharSequence, Integer, Integer, Integer, l2> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(4);
        }

        public final void invoke(@m CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // jn.r
        public /* bridge */ /* synthetic */ l2 invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$2, reason: invalid class name */
    @r1({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n*E\n"})
    public static final class AnonymousClass2 extends n0 implements r<CharSequence, Integer, Integer, Integer, l2> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(4);
        }

        public final void invoke(@m CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // jn.r
        public /* bridge */ /* synthetic */ l2 invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return l2.f10208a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$3, reason: invalid class name */
    @r1({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$3\n*L\n1#1,97:1\n*E\n"})
    public static final class AnonymousClass3 extends n0 implements l<Editable, l2> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Editable editable) {
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Editable editable) {
            invoke2(editable);
            return l2.f10208a;
        }
    }

    @os.l
    public static final TextWatcher addTextChangedListener(@os.l TextView textView, @os.l r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> rVar, @os.l r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> rVar2, @os.l l<? super Editable, l2> lVar) {
        l0.p(textView, "<this>");
        l0.p(rVar, "beforeTextChanged");
        l0.p(rVar2, "onTextChanged");
        l0.p(lVar, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(lVar, rVar, rVar2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, r rVar, r rVar2, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            rVar = AnonymousClass1.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            rVar2 = AnonymousClass2.INSTANCE;
        }
        if ((i10 & 4) != 0) {
            lVar = AnonymousClass3.INSTANCE;
        }
        l0.p(textView, "<this>");
        l0.p(rVar, "beforeTextChanged");
        l0.p(rVar2, "onTextChanged");
        l0.p(lVar, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(lVar, rVar, rVar2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    @os.l
    public static final TextWatcher doAfterTextChanged(@os.l TextView textView, @os.l final l<? super Editable, l2> lVar) {
        l0.p(textView, "<this>");
        l0.p(lVar, f.f8937e);
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@m Editable editable) {
                lVar.invoke(editable);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@m CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@m CharSequence charSequence, int i10, int i11, int i12) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @os.l
    public static final TextWatcher doBeforeTextChanged(@os.l TextView textView, @os.l final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> rVar) {
        l0.p(textView, "<this>");
        l0.p(rVar, f.f8937e);
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@m Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@m CharSequence charSequence, int i10, int i11, int i12) {
                rVar.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@m CharSequence charSequence, int i10, int i11, int i12) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @os.l
    public static final TextWatcher doOnTextChanged(@os.l TextView textView, @os.l final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, l2> rVar) {
        l0.p(textView, "<this>");
        l0.p(rVar, f.f8937e);
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@m Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@m CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@m CharSequence charSequence, int i10, int i11, int i12) {
                rVar.invoke(charSequence, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
