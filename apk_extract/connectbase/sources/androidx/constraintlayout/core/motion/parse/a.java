package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements KeyParser.Ids {
    @Override // androidx.constraintlayout.core.motion.parse.KeyParser.Ids
    public final int get(String str) {
        return TypedValues.AttributesType.getId(str);
    }
}
