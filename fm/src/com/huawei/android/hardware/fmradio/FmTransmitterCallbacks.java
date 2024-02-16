package com.huawei.android.hardware.fmradio;

/* loaded from: C:\Users\MOUNIERR\AppData\Local\Temp\jadx-15910938879466725409.dex */
public interface FmTransmitterCallbacks {
    void onContRDSGroupsComplete();

    void onRDSGroupsAvailable();

    void onRDSGroupsComplete();

    void onRadioDisabled();

    void onTuneStatusChange(int i);
}
