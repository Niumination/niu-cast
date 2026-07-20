package com.transsion.iotservice.multiscreen.pc.socket.tccp.config;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0011\u0010\u001a\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u0011\u0010 \u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\t¨\u0006\""}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/tccp/config/TccpConfig;", "", "<init>", "()V", "TCCP_HEADER_LEN", "", "TCCP_REQUEST_HEADER", "", "getTCCP_REQUEST_HEADER", "()[B", "TCCP_RESPONSE_HEADER", "getTCCP_RESPONSE_HEADER", "TCCP_VERSION", "getTCCP_VERSION", "SCAN_CONFIRM_FLAG", "getSCAN_CONFIRM_FLAG", "SWITCH_ABILITY_FLAG", "getSWITCH_ABILITY_FLAG", "SDK_INIT_PORT", "getSDK_INIT_PORT", "DISCONNECT_SOCKET", "getDISCONNECT_SOCKET", "HEARTBEAT_TCCP", "getHEARTBEAT_TCCP", "LOCKSCREEN_TCCP", "getLOCKSCREEN_TCCP", "NEW_HOTSPOT_OPEN_CLOSE_FLAG", "getNEW_HOTSPOT_OPEN_CLOSE_FLAG", "WIFI_FREQUENCY_STATE", "getWIFI_FREQUENCY_STATE", "NETWORK_SHARING_CLOSE_FLAG", "getNETWORK_SHARING_CLOSE_FLAG", "REQUEST_DISCONNECT", "getREQUEST_DISCONNECT", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TccpConfig {
    public static final int TCCP_HEADER_LEN = 9;
    public static final TccpConfig INSTANCE = new TccpConfig();
    private static final byte[] TCCP_REQUEST_HEADER = {84, 67, 67, 80};
    private static final byte[] TCCP_RESPONSE_HEADER = {37, 37, 37, 37};
    private static final byte[] TCCP_VERSION = {1};
    private static final byte[] SCAN_CONFIRM_FLAG = {9, 5};
    private static final byte[] SWITCH_ABILITY_FLAG = {9, 6};
    private static final byte[] SDK_INIT_PORT = {9, 7};
    private static final byte[] DISCONNECT_SOCKET = {9, 8};
    private static final byte[] HEARTBEAT_TCCP = {9, 17};
    private static final byte[] LOCKSCREEN_TCCP = {9, 18};
    private static final byte[] NEW_HOTSPOT_OPEN_CLOSE_FLAG = {9, 19};
    private static final byte[] WIFI_FREQUENCY_STATE = {9, 20};
    private static final byte[] NETWORK_SHARING_CLOSE_FLAG = {9, 21};
    private static final byte[] REQUEST_DISCONNECT = {9, 22};

    private TccpConfig() {
    }

    public final byte[] getDISCONNECT_SOCKET() {
        return DISCONNECT_SOCKET;
    }

    public final byte[] getHEARTBEAT_TCCP() {
        return HEARTBEAT_TCCP;
    }

    public final byte[] getLOCKSCREEN_TCCP() {
        return LOCKSCREEN_TCCP;
    }

    public final byte[] getNETWORK_SHARING_CLOSE_FLAG() {
        return NETWORK_SHARING_CLOSE_FLAG;
    }

    public final byte[] getNEW_HOTSPOT_OPEN_CLOSE_FLAG() {
        return NEW_HOTSPOT_OPEN_CLOSE_FLAG;
    }

    public final byte[] getREQUEST_DISCONNECT() {
        return REQUEST_DISCONNECT;
    }

    public final byte[] getSCAN_CONFIRM_FLAG() {
        return SCAN_CONFIRM_FLAG;
    }

    public final byte[] getSDK_INIT_PORT() {
        return SDK_INIT_PORT;
    }

    public final byte[] getSWITCH_ABILITY_FLAG() {
        return SWITCH_ABILITY_FLAG;
    }

    public final byte[] getTCCP_REQUEST_HEADER() {
        return TCCP_REQUEST_HEADER;
    }

    public final byte[] getTCCP_RESPONSE_HEADER() {
        return TCCP_RESPONSE_HEADER;
    }

    public final byte[] getTCCP_VERSION() {
        return TCCP_VERSION;
    }

    public final byte[] getWIFI_FREQUENCY_STATE() {
        return WIFI_FREQUENCY_STATE;
    }
}
