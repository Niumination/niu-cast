package com.transsion.iotcardsdk.constant;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotcardsdk.bean.DeviceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0010 \n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001b\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0014\u0010\u001d\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\u0014\u0010\u001f\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010R\u0014\u0010!\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0010R\u0014\u0010#\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0010R\u0014\u0010%\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0010R\u0014\u0010'\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0010R\u0014\u0010)\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0010R\u0014\u0010+\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0010R\u0014\u0010-\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0010R\u0014\u0010/\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0010R\u0014\u00101\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0010R\u0014\u00103\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0010R\u0014\u00105\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0010R\u0014\u00107\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0010R\u0014\u00109\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0010R\u0014\u0010;\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0010R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0010R\u0014\u0010C\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0010R\u0014\u0010E\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0010R\u0014\u0010G\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0010R\u0014\u0010I\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0006R\u0014\u0010K\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0010R\u0014\u0010M\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0010R\u0014\u0010O\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0010R\u0014\u0010Q\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0010R\u0014\u0010S\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0006R\u0014\u0010U\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0006¨\u0006W"}, d2 = {"Lcom/transsion/iotcardsdk/constant/IotCardConstance;", "", "()V", "BATTERY_CHARGE_TEMPLATE", "", "getBATTERY_CHARGE_TEMPLATE", "()I", "BATTERY_TEMPLATE", "getBATTERY_TEMPLATE", "CONNECT_TEMPLATE", "getCONNECT_TEMPLATE", "CUSTOM_TEMPLATE", "getCUSTOM_TEMPLATE", "EQ_BASS_BOOST", "", "getEQ_BASS_BOOST", "()Ljava/lang/String;", "EQ_DEFAULT", "getEQ_DEFAULT", "EQ_HUMAN_VOICE_BOOST", "getEQ_HUMAN_VOICE_BOOST", "EQ_SPATIAL_AUDIO", "getEQ_SPATIAL_AUDIO", "EQ_TREBLE_BOOST", "getEQ_TREBLE_BOOST", "FEATURE_DISABLE", "getFEATURE_DISABLE", "FEATURE_ENABLE", "getFEATURE_ENABLE", "FEATURE_EQ_VOICE", "getFEATURE_EQ_VOICE", "FEATURE_NOISE_CANCELLATION_MODE", "getFEATURE_NOISE_CANCELLATION_MODE", "FEATURE_NOT_SUPPORT", "getFEATURE_NOT_SUPPORT", "FEATURE_PRIVACY_MODE", "getFEATURE_PRIVACY_MODE", "FEATURE_RECORDING", "getFEATURE_RECORDING", "FEATURE_ROUTER_CONNECT_MANAGE", "getFEATURE_ROUTER_CONNECT_MANAGE", "FEATURE_ROUTER_NET_SETTING", "getFEATURE_ROUTER_NET_SETTING", "FIND_EARPHONE", "getFIND_EARPHONE", "FIND_WATCH", "getFIND_WATCH", "IOTCARD_AUTHORITIES", "getIOTCARD_AUTHORITIES", "IOTCARD_PACKAGENAME", "getIOTCARD_PACKAGENAME", "IOTCARD_START_ACTION", "getIOTCARD_START_ACTION", "IOTCARD_START_SERVICE", "getIOTCARD_START_SERVICE", "IP", "getIP", "IR_DEVICE_CONTROL", "getIR_DEVICE_CONTROL", "IR_MAIN_CONTROL", "getIR_MAIN_CONTROL", "LOW_VERSION_SUPPORT_DEVICES", "", "getLOW_VERSION_SUPPORT_DEVICES", "()Ljava/util/List;", "MESSAGE_SEND", "getMESSAGE_SEND", "NOISE_CANCELLATION", "getNOISE_CANCELLATION", "NOISE_CLOSE", "getNOISE_CLOSE", "NOISE_TRANSPARENT", "getNOISE_TRANSPARENT", "PORT", "getPORT", "PRIVACY_OUTDOOR_MODE", "getPRIVACY_OUTDOOR_MODE", "PRIVACY_PRIVACY_MODE", "getPRIVACY_PRIVACY_MODE", "PRIVACY_STANDARD_MODE", "getPRIVACY_STANDARD_MODE", "TARGET_VERSION", "getTARGET_VERSION", "TEXT_TEMPLATE", "getTEXT_TEMPLATE", "UNKNOWN_TEMPLATE", "getUNKNOWN_TEMPLATE", "iotcardsdk_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class IotCardConstance {
    public static final IotCardConstance INSTANCE = new IotCardConstance();
    private static final int PORT = 55231;
    private static final String IP = "0.0.0.0";
    private static final String IOTCARD_PACKAGENAME = "com.transsion.iotcard";
    private static final String IOTCARD_START_SERVICE = "com.transsion.iotcard_business.appstart.AppStartIotCardService";
    private static final String IOTCARD_START_ACTION = "com.transsion.iotcard.appStartIotCardService";
    private static final String IOTCARD_AUTHORITIES = "com.transsion.iotcard.startapplication";
    private static final int UNKNOWN_TEMPLATE = -1;
    private static final int TEXT_TEMPLATE = 1;
    private static final int BATTERY_TEMPLATE = 2;
    private static final int CONNECT_TEMPLATE = 3;
    private static final int CUSTOM_TEMPLATE = 4;
    private static final int BATTERY_CHARGE_TEMPLATE = 5;
    private static final String TARGET_VERSION = "16.1.0";
    private static final List<Integer> LOW_VERSION_SUPPORT_DEVICES = CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 101, 102, Integer.valueOf(DeviceType.INFRARED_TV_BOX), 104, Integer.valueOf(DeviceType.INFRARED_AIR_CONDITION), Integer.valueOf(DeviceType.INFRARED_PROJECTOR), Integer.valueOf(DeviceType.INFRARED_AMPLIFIER), 108, 109, Integer.valueOf(DeviceType.INFRARED_LIGHT), Integer.valueOf(DeviceType.INFRARED_AIR_PURIFIER), Integer.valueOf(DeviceType.INFRARED_HEATER), Integer.valueOf(DeviceType.INFRARED_ELECTRIC_HEATER), Integer.valueOf(DeviceType.INFRARED_SWEEP_ROBOT), Integer.valueOf(DeviceType.INFRARED_CURTAIN), 0, 13, 14});
    private static final String FEATURE_NOISE_CANCELLATION_MODE = "noise_cancellation_mode";
    private static final String NOISE_TRANSPARENT = "noise_transparent";
    private static final String NOISE_CANCELLATION = "noise_cancellation";
    private static final String NOISE_CLOSE = "noise_close";
    private static final String FEATURE_EQ_VOICE = "eq_voice";
    private static final String EQ_DEFAULT = "eq_default";
    private static final String EQ_HUMAN_VOICE_BOOST = "eq_human_voice_augmente";
    private static final String EQ_BASS_BOOST = "eq_bass_boost";
    private static final String EQ_TREBLE_BOOST = "eq_treble_boost";
    private static final String EQ_SPATIAL_AUDIO = "eq_spatial_audio";
    private static final String FIND_EARPHONE = "find_earphone";
    private static final String FEATURE_PRIVACY_MODE = "feature_privacy_mode";
    private static final String PRIVACY_STANDARD_MODE = "privacy_standard_mode";
    private static final String PRIVACY_OUTDOOR_MODE = "privacy_outdoor_mode";
    private static final String PRIVACY_PRIVACY_MODE = "privacy_privacy_mode";
    private static final String FEATURE_RECORDING = "feature_recording";
    private static final String FIND_WATCH = "find_watch";
    private static final String MESSAGE_SEND = "message_send";
    private static final String IR_DEVICE_CONTROL = "ir_device_control";
    private static final String IR_MAIN_CONTROL = "ir_main_control";
    private static final String FEATURE_ROUTER_CONNECT_MANAGE = "feature_router_connect_manage";
    private static final String FEATURE_ROUTER_NET_SETTING = "feature_router_net_setting";
    private static final String FEATURE_ENABLE = "feature_enable";
    private static final String FEATURE_DISABLE = "feature_disable";
    private static final String FEATURE_NOT_SUPPORT = "feature_not_support";

    private IotCardConstance() {
    }

    public final int getBATTERY_CHARGE_TEMPLATE() {
        return BATTERY_CHARGE_TEMPLATE;
    }

    public final int getBATTERY_TEMPLATE() {
        return BATTERY_TEMPLATE;
    }

    public final int getCONNECT_TEMPLATE() {
        return CONNECT_TEMPLATE;
    }

    public final int getCUSTOM_TEMPLATE() {
        return CUSTOM_TEMPLATE;
    }

    public final String getEQ_BASS_BOOST() {
        return EQ_BASS_BOOST;
    }

    public final String getEQ_DEFAULT() {
        return EQ_DEFAULT;
    }

    public final String getEQ_HUMAN_VOICE_BOOST() {
        return EQ_HUMAN_VOICE_BOOST;
    }

    public final String getEQ_SPATIAL_AUDIO() {
        return EQ_SPATIAL_AUDIO;
    }

    public final String getEQ_TREBLE_BOOST() {
        return EQ_TREBLE_BOOST;
    }

    public final String getFEATURE_DISABLE() {
        return FEATURE_DISABLE;
    }

    public final String getFEATURE_ENABLE() {
        return FEATURE_ENABLE;
    }

    public final String getFEATURE_EQ_VOICE() {
        return FEATURE_EQ_VOICE;
    }

    public final String getFEATURE_NOISE_CANCELLATION_MODE() {
        return FEATURE_NOISE_CANCELLATION_MODE;
    }

    public final String getFEATURE_NOT_SUPPORT() {
        return FEATURE_NOT_SUPPORT;
    }

    public final String getFEATURE_PRIVACY_MODE() {
        return FEATURE_PRIVACY_MODE;
    }

    public final String getFEATURE_RECORDING() {
        return FEATURE_RECORDING;
    }

    public final String getFEATURE_ROUTER_CONNECT_MANAGE() {
        return FEATURE_ROUTER_CONNECT_MANAGE;
    }

    public final String getFEATURE_ROUTER_NET_SETTING() {
        return FEATURE_ROUTER_NET_SETTING;
    }

    public final String getFIND_EARPHONE() {
        return FIND_EARPHONE;
    }

    public final String getFIND_WATCH() {
        return FIND_WATCH;
    }

    public final String getIOTCARD_AUTHORITIES() {
        return IOTCARD_AUTHORITIES;
    }

    public final String getIOTCARD_PACKAGENAME() {
        return IOTCARD_PACKAGENAME;
    }

    public final String getIOTCARD_START_ACTION() {
        return IOTCARD_START_ACTION;
    }

    public final String getIOTCARD_START_SERVICE() {
        return IOTCARD_START_SERVICE;
    }

    public final String getIP() {
        return IP;
    }

    public final String getIR_DEVICE_CONTROL() {
        return IR_DEVICE_CONTROL;
    }

    public final String getIR_MAIN_CONTROL() {
        return IR_MAIN_CONTROL;
    }

    public final List<Integer> getLOW_VERSION_SUPPORT_DEVICES() {
        return LOW_VERSION_SUPPORT_DEVICES;
    }

    public final String getMESSAGE_SEND() {
        return MESSAGE_SEND;
    }

    public final String getNOISE_CANCELLATION() {
        return NOISE_CANCELLATION;
    }

    public final String getNOISE_CLOSE() {
        return NOISE_CLOSE;
    }

    public final String getNOISE_TRANSPARENT() {
        return NOISE_TRANSPARENT;
    }

    public final int getPORT() {
        return PORT;
    }

    public final String getPRIVACY_OUTDOOR_MODE() {
        return PRIVACY_OUTDOOR_MODE;
    }

    public final String getPRIVACY_PRIVACY_MODE() {
        return PRIVACY_PRIVACY_MODE;
    }

    public final String getPRIVACY_STANDARD_MODE() {
        return PRIVACY_STANDARD_MODE;
    }

    public final String getTARGET_VERSION() {
        return TARGET_VERSION;
    }

    public final int getTEXT_TEMPLATE() {
        return TEXT_TEMPLATE;
    }

    public final int getUNKNOWN_TEMPLATE() {
        return UNKNOWN_TEMPLATE;
    }
}
