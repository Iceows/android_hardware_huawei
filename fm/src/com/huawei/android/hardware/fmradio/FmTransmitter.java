package com.huawei.android.hardware.fmradio;

/* loaded from: C:\Users\MOUNIERR\AppData\Local\Temp\jadx-8406931342016594350.dex */
public class FmTransmitter extends FmTransceiver {
    public static final int RDS_GRPS_TX_PAUSE = 0;
    public static final int RDS_GRPS_TX_RESUME = 1;
    public static final int RDS_GRPS_TX_STOP = 2;

    /* loaded from: C:\Users\MOUNIERR\AppData\Local\Temp\jadx-8406931342016594350.dex */
    public interface TransmitterCallbacks {
        void onRDSGroupsAvailable();

        void onRDSGroupsComplete();

        void onTuneFrequencyChange(int i);
    }

    public FmTransmitter() {
        this.mControl = new FmRxControls();
        this.mRdsData = new FmRxRdsData(sFd);
        this.mRxEvents = new FmRxEventListner();
    }

    public FmTransmitter(String path, FmRxEvCallbacksAdaptor callbacks) {
        acquire(path);
        registerTransmitClient(callbacks);
        this.mControl = new FmRxControls();
        this.mRdsData = new FmRxRdsData(sFd);
        this.mRxEvents = new FmRxEventListner();
    }

    public boolean enable(FmConfig configSettings) {
        super.enable(configSettings, 2);
        return true;
    }

    @Override // com.huawei.android.hardware.fmradio.FmTransceiver
    public boolean disable() {
        boolean status = super.disable();
        return status;
    }

    public boolean reset() {
        boolean status = unregisterTransmitClient();
        return status;
    }

    public static FmPSFeatures getPSFeatures() {
        return new FmPSFeatures();
    }

    public boolean setPSInfo(String[] psStr, int pty, long repeatCount) {
        return false;
    }

    public boolean stopPSInfo() {
        return false;
    }

    public boolean setRTInfo(String rtStr) {
        return false;
    }

    public boolean stopRTInfo() {
        return false;
    }

    public boolean setPSRTProgramType(int pty) {
        return false;
    }

    public int getRdsGroupBufSize() {
        return 0;
    }

    public int transmitRdsGroups(byte[] rdsGroups, long numGroupsToTransmit) {
        return -1;
    }

    public boolean transmitRdsGroupControl(int ctrlCmd) {
        return false;
    }

    boolean isAntennaAvailable() {
        return true;
    }

    /* loaded from: C:\Users\MOUNIERR\AppData\Local\Temp\jadx-8406931342016594350.dex */
    public static class FmPSFeatures {
        private int mMaxPSCharacters;
        private int mMaxPSStringRepeatCount;

        public FmPSFeatures() {
            this.mMaxPSCharacters = 0;
            this.mMaxPSStringRepeatCount = 0;
        }

        public FmPSFeatures(int maxPSCharacters, int maxPSStringRepeatCount) {
            this.mMaxPSCharacters = maxPSCharacters;
            this.mMaxPSStringRepeatCount = maxPSStringRepeatCount;
        }

        public int getMaxPSCharacters() {
            return this.mMaxPSCharacters;
        }

        public int getMaxPSStringRepeatCount() {
            return this.mMaxPSStringRepeatCount;
        }
    }
}
