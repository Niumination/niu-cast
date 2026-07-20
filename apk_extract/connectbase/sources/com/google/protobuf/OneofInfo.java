package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class OneofInfo {
    private final java.lang.reflect.Field caseField;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f1791id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int id2, java.lang.reflect.Field caseField, java.lang.reflect.Field valueField) {
        this.f1791id = id2;
        this.caseField = caseField;
        this.valueField = valueField;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public int getId() {
        return this.f1791id;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
