package com.google.mlkit.vision.barcode.bundled.internal;

import android.content.Context;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbc;
import f3.a;
import f3.b;
import l3.i;
import l3.k;

/* JADX INFO: loaded from: classes2.dex */
@DynamiteApi
public class ThickBarcodeScannerCreator extends k {
    public ThickBarcodeScannerCreator() {
        super("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
    }

    @Override // l3.l
    public i newBarcodeScanner(a aVar, zzbc zzbcVar) {
        return new s5.a((Context) b.l(aVar), zzbcVar);
    }
}
