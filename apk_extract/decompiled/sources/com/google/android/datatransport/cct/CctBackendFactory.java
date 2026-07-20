package com.google.android.datatransport.cct;

import android.content.Context;
import androidx.annotation.Keep;
import e2.b;
import e2.d;
import e2.g;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class CctBackendFactory {
    public g create(d dVar) {
        Context context = ((b) dVar).f4662a;
        b bVar = (b) dVar;
        return new b2.d(context, bVar.f4663b, bVar.f4664c);
    }
}
