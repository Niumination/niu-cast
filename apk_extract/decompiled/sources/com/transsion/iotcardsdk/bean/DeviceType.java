package com.transsion.iotcardsdk.bean;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b#\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/transsion/iotcardsdk/bean/DeviceType;", "", "()V", "BANGLE", "", "BLOOD_OXYGEN", "CAPACITIVE_PEN", "DOOR_LOCK", "EAR_PHONE", "GLASS", "INFRARED_AIR_CONDITION", "INFRARED_AIR_PURIFIER", "INFRARED_AMPLIFIER", "INFRARED_CAMERA", "INFRARED_CURTAIN", "INFRARED_DVD", "INFRARED_ELECTRIC_HEATER", "INFRARED_FAN", "INFRARED_HEATER", "INFRARED_LIGHT", "INFRARED_PROJECTOR", "INFRARED_REMOTE_CONTROLLER", "INFRARED_SET_TOP_BOX", "INFRARED_SWEEP_ROBOT", "INFRARED_TV", "INFRARED_TV_BOX", "IPC", "LIGHT", "MIFI", "PAD", "PC", "PHONE", "RING", "ROUTER", "SOCKET", "SWITCH", "TV", "UNKNOWN", "WATCH", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class DeviceType {
    public static final int BANGLE = 3;
    public static final int BLOOD_OXYGEN = 13;
    public static final int CAPACITIVE_PEN = 14;
    public static final int DOOR_LOCK = 7;
    public static final int EAR_PHONE = 1;
    public static final int GLASS = 16;
    public static final int INFRARED_AIR_CONDITION = 105;
    public static final int INFRARED_AIR_PURIFIER = 111;
    public static final int INFRARED_AMPLIFIER = 107;
    public static final int INFRARED_CAMERA = 109;
    public static final int INFRARED_CURTAIN = 115;
    public static final int INFRARED_DVD = 104;
    public static final int INFRARED_ELECTRIC_HEATER = 113;
    public static final int INFRARED_FAN = 108;
    public static final int INFRARED_HEATER = 112;
    public static final int INFRARED_LIGHT = 110;
    public static final int INFRARED_PROJECTOR = 106;
    public static final int INFRARED_REMOTE_CONTROLLER = 0;
    public static final int INFRARED_SET_TOP_BOX = 101;
    public static final int INFRARED_SWEEP_ROBOT = 114;
    public static final int INFRARED_TV = 102;
    public static final int INFRARED_TV_BOX = 103;
    public static final DeviceType INSTANCE = new DeviceType();
    public static final int IPC = 6;
    public static final int LIGHT = 9;
    public static final int MIFI = 12;
    public static final int PAD = 17;
    public static final int PC = 4;
    public static final int PHONE = 18;
    public static final int RING = 15;
    public static final int ROUTER = 8;
    public static final int SOCKET = 11;
    public static final int SWITCH = 10;
    public static final int TV = 5;
    public static final int UNKNOWN = -1;
    public static final int WATCH = 2;

    private DeviceType() {
    }
}
