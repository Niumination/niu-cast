package com.transsion.iotservice.multiscreen.pc.http;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/http/DownloadCallback;", "Lcom/transsion/iotservice/multiscreen/pc/http/RequestCallback;", "", "onProgress", "", "progress", "", "total", "onFinished", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface DownloadCallback extends RequestCallback<Long> {
    void onFinished();

    void onProgress(int progress, long total);
}
