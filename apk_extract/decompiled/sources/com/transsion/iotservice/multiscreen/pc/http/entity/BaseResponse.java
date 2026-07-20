package com.transsion.iotservice.multiscreen.pc.http.entity;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.transsion.message.bank.MessageBank;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ4\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/http/entity/BaseResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", NotificationCompat.CATEGORY_MESSAGE, "", MessageBank.KEY_FLAG, "", "ret", "<init>", "(Ljava/lang/String;ILjava/lang/Object;)V", "getMsg", "()Ljava/lang/String;", "getFlag", "()I", "getRet", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isSuccess", "", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ILjava/lang/Object;)Lcom/transsion/iotservice/multiscreen/pc/http/entity/BaseResponse;", "equals", "other", "hashCode", "toString", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final /* data */ class BaseResponse<T> {

    @SerializedName(MessageBank.KEY_FLAG)
    private final int flag;

    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private final String msg;

    @SerializedName("ret")
    private final T ret;

    public BaseResponse(String msg, int i8, T t3) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.msg = msg;
        this.flag = i8;
        this.ret = t3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResponse copy$default(BaseResponse baseResponse, String str, int i8, Object obj, int i9, Object obj2) {
        if ((i9 & 1) != 0) {
            str = baseResponse.msg;
        }
        if ((i9 & 2) != 0) {
            i8 = baseResponse.flag;
        }
        if ((i9 & 4) != 0) {
            obj = baseResponse.ret;
        }
        return baseResponse.copy(str, i8, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFlag() {
        return this.flag;
    }

    public final T component3() {
        return this.ret;
    }

    public final BaseResponse<T> copy(String msg, int flag, T ret) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        return new BaseResponse<>(msg, flag, ret);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BaseResponse)) {
            return false;
        }
        BaseResponse baseResponse = (BaseResponse) other;
        return Intrinsics.areEqual(this.msg, baseResponse.msg) && this.flag == baseResponse.flag && Intrinsics.areEqual(this.ret, baseResponse.ret);
    }

    public final int getFlag() {
        return this.flag;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final T getRet() {
        return this.ret;
    }

    public int hashCode() {
        int iC = a.c(this.flag, this.msg.hashCode() * 31, 31);
        T t3 = this.ret;
        return iC + (t3 == null ? 0 : t3.hashCode());
    }

    public final boolean isSuccess() {
        return this.flag == 1;
    }

    public String toString() {
        return "BaseResponse(msg=" + this.msg + ", flag=" + this.flag + ", ret=" + this.ret + ")";
    }
}
