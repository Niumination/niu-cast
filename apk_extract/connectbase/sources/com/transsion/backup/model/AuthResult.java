package com.transsion.backup.model;

import com.google.gson.annotations.SerializedName;
import kn.l0;
import kn.w;
import n4.a;
import os.l;
import os.m;
import s0.b;

/* JADX INFO: loaded from: classes2.dex */
public final class AuthResult {

    @SerializedName("deviceId")
    @l
    private final String deviceId;

    @SerializedName(a.A)
    @l
    private final String deviceName;

    @SerializedName("isAuth")
    private final boolean isAuth;

    @SerializedName("isTrust")
    private final boolean isTrust;

    public AuthResult(boolean z10, boolean z11, @l String str, @l String str2) {
        l0.p(str, a.A);
        l0.p(str2, "deviceId");
        this.isAuth = z10;
        this.isTrust = z11;
        this.deviceName = str;
        this.deviceId = str2;
    }

    public static /* synthetic */ AuthResult copy$default(AuthResult authResult, boolean z10, boolean z11, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = authResult.isAuth;
        }
        if ((i10 & 2) != 0) {
            z11 = authResult.isTrust;
        }
        if ((i10 & 4) != 0) {
            str = authResult.deviceName;
        }
        if ((i10 & 8) != 0) {
            str2 = authResult.deviceId;
        }
        return authResult.copy(z10, z11, str, str2);
    }

    public final boolean component1() {
        return this.isAuth;
    }

    public final boolean component2() {
        return this.isTrust;
    }

    @l
    public final String component3() {
        return this.deviceName;
    }

    @l
    public final String component4() {
        return this.deviceId;
    }

    @l
    public final AuthResult copy(boolean z10, boolean z11, @l String str, @l String str2) {
        l0.p(str, a.A);
        l0.p(str2, "deviceId");
        return new AuthResult(z10, z11, str, str2);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthResult)) {
            return false;
        }
        AuthResult authResult = (AuthResult) obj;
        return this.isAuth == authResult.isAuth && this.isTrust == authResult.isTrust && l0.g(this.deviceName, authResult.deviceName) && l0.g(this.deviceId, authResult.deviceId);
    }

    @l
    public final String getDeviceId() {
        return this.deviceId;
    }

    @l
    public final String getDeviceName() {
        return this.deviceName;
    }

    public int hashCode() {
        return this.deviceId.hashCode() + b.a(this.deviceName, (Boolean.hashCode(this.isTrust) + (Boolean.hashCode(this.isAuth) * 31)) * 31, 31);
    }

    public final boolean isAuth() {
        return this.isAuth;
    }

    public final boolean isTrust() {
        return this.isTrust;
    }

    @l
    public String toString() {
        return "AuthResult(isAuth=" + this.isAuth + ", isTrust=" + this.isTrust + ", deviceName=" + this.deviceName + ", deviceId=" + this.deviceId + ")";
    }

    public /* synthetic */ AuthResult(boolean z10, boolean z11, String str, String str2, int i10, w wVar) {
        this(z10, z11, (i10 & 4) != 0 ? "" : str, (i10 & 8) != 0 ? "" : str2);
    }

    public AuthResult(boolean z10, boolean z11) {
        this(z10, z11, "", "");
    }
}
