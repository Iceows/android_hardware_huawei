/*
 * Copyright (C) 2023 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#include <hardware/audio.h>

/**
 * This is basically just a copy of the audio_hw_device_t struct from
 * hardware/libhardware/include/hardware/audio.h, but without
 * get_microphones to match the audio_hw_device_t struct in
 * our audio HALs
 */
struct hisi_audio_hw_device {
    /**
     * Common methods of the audio device.  This *must* be the first member of audio_hw_device
     * as users of this structure will cast a hw_device_t to audio_hw_device pointer in contexts
     * where it's known the hw_device_t references an audio_hw_device.
     */
    struct hw_device_t common;

	 /***** HUAWEI ANE-LX1 EMUI9 audio hal 4.0 order
		__arg[0xe] = adev_close;
		__arg[0xf] = adev_get_supported_devices;
		__arg[0x10] = adev_init_check;
		__arg[0x11] = adev_set_voice_volume;
		__arg[0x12] = adev_set_master_volume;
		__arg[0x13] = adev_get_master_volume;
		__arg[0x14] = adev_set_mode;
		__arg[0x15] = adev_set_mic_mute;
		__arg[0x16] = adev_get_mic_mute;
		__arg[0x17] = adev_set_parameters;
		__arg[0x18] = adev_get_parameters;
		__arg[0x19] = adev_get_input_buffer_size;
		__arg[0x1a] = adev_open_output_stream;
		__arg[0x1b] = adev_close_output_stream;
		__arg[0x1c] = adev_open_input_stream;
		__arg[0x1d] = adev_close_input_stream;
		__arg[0x1e] = adev_get_microphones;
		__arg[0x1f] = adev_dump;
		__arg[0x20] = adev_set_master_mute;
		__arg[0x21] = adev_get_master_mute;
		__arg[0x22] = adev_create_audio_patch;
		__arg[0x23] = adev_release_audio_patch;
		__arg[0x24] = adev_get_audio_port;
		__arg[0x25] = adev_set_audio_port_config;

		__arg[0x58] = dsp_modem_loop;
		__arg[0x59] = dsp_slimbus_i2s_loop;
		__arg[0x5a] = dsp_set_device;
		__arg[0x5b] = dsp_set_parameters;
		__arg[0x5d] = spk_dev_get_parameters;
		__arg[0x5c] = dsp_get_parameters;
		__arg[0x5e] = dsp_set_mmi_mode;
		__arg[0x5f] = adev_set_tty_mode;

		__arg[0x67] = dsp_set_voicepp;
		__arg[0x68] = dsp_set_ext_headset_hifi_bypass;
		__arg[0x69] = dsp_algo_bypass;
		__arg[0x6a] = dsp_smartPA_control;
		__arg[0x6d] = spk_get_F0;
		__arg[0x6b] = spk_get_R0;
		__arg[0x6e] = spk_algo_bypass;
		__arg[0x6f] = spk_tdm_4pa_audioloop;
		__arg[0x6c] = spk_set_calibration_value;
		__arg[0x70] = get_output_device;
		__arg[0x71] = dsp_voice_volume_level;
		__arg[0x72] = dsp_set_cvaa_mono_channel;
		__arg[0x73] = audio_in_pcm_open;
		__arg[0x74] = audio_in_pcm_read;
		__arg[0x75] = audio_in_pcm_close;
		__arg[0x83] = 0x100000001;
		__arg[0x82] = 0x100000001;
	*/

    /**
     * used by audio flinger to enumerate what devices are supported by
     * each audio_hw_device implementation.
     *
     * Return value is a bitmask of 1 or more values of audio_devices_t
     *
     * NOTE: audio HAL implementations starting with
     * AUDIO_DEVICE_API_VERSION_2_0 do not implement this function.
     * All supported devices should be listed in audio_policy.conf
     * file and the audio policy manager must choose the appropriate
     * audio module based on information in this file.
     */
    uint32_t (*get_supported_devices)(const struct hisi_audio_hw_device *dev);

    /**
     * check to see if the audio hardware interface has been initialized.
     * returns 0 on success, -ENODEV on failure.
     */
    int (*init_check)(const struct hisi_audio_hw_device *dev);

    /** set the audio volume of a voice call. Range is between 0.0 and 1.0 */
    int (*set_voice_volume)(struct hisi_audio_hw_device *dev, float volume);

    /**
     * set the audio volume for all audio activities other than voice call.
     * Range between 0.0 and 1.0. If any value other than 0 is returned,
     * the software mixer will emulate this capability.
     */
    int (*set_master_volume)(struct hisi_audio_hw_device *dev, float volume);

    /**
     * Get the current master volume value for the HAL, if the HAL supports
     * master volume control.  AudioFlinger will query this value from the
     * primary audio HAL when the service starts and use the value for setting
     * the initial master volume across all HALs.  HALs which do not support
     * this method may leave it set to NULL.
     */
    int (*get_master_volume)(struct hisi_audio_hw_device *dev, float *volume);

    /**
     * set_mode is called when the audio mode changes. AUDIO_MODE_NORMAL mode
     * is for standard audio playback, AUDIO_MODE_RINGTONE when a ringtone is
     * playing, and AUDIO_MODE_IN_CALL when a call is in progress.
     */
    int (*set_mode)(struct hisi_audio_hw_device *dev, audio_mode_t mode);

    /* mic mute */
    int (*set_mic_mute)(struct hisi_audio_hw_device *dev, bool state);
    int (*get_mic_mute)(const struct hisi_audio_hw_device *dev, bool *state);

    /* set/get global audio parameters */
    int (*set_parameters)(struct hisi_audio_hw_device *dev, const char *kv_pairs);

    /*
     * Returns a pointer to a heap allocated string. The caller is responsible
     * for freeing the memory for it using free().
     */
    char * (*get_parameters)(const struct hisi_audio_hw_device *dev,
                             const char *keys);

    /* Returns audio input buffer size according to parameters passed or
     * 0 if one of the parameters is not supported.
     * See also get_buffer_size which is for a particular stream.
     */
    size_t (*get_input_buffer_size)(const struct hisi_audio_hw_device *dev,
                                    const struct audio_config *config);

    /** This method creates and opens the audio hardware output stream.
     * The "address" parameter qualifies the "devices" audio device type if needed.
     * The format format depends on the device type:
     * - Bluetooth devices use the MAC address of the device in the form "00:11:22:AA:BB:CC"
     * - USB devices use the ALSA card and device numbers in the form  "card=X;device=Y"
     * - Other devices may use a number or any other string.
     */

    int (*open_output_stream)(struct hisi_audio_hw_device *dev,
                              audio_io_handle_t handle,
                              audio_devices_t devices,
                              audio_output_flags_t flags,
                              struct audio_config *config,
                              struct audio_stream_out **stream_out,
                              const char *address);

    void (*close_output_stream)(struct hisi_audio_hw_device *dev,
                                struct audio_stream_out* stream_out);

    /** This method creates and opens the audio hardware input stream */
    int (*open_input_stream)(struct hisi_audio_hw_device *dev,
                             audio_io_handle_t handle,
                             audio_devices_t devices,
                             struct audio_config *config,
                             struct audio_stream_in **stream_in,
                             audio_input_flags_t flags,
                             const char *address,
                             audio_source_t source);

    void (*close_input_stream)(struct hisi_audio_hw_device *dev,
                               struct audio_stream_in *stream_in);

    /** This method dumps the state of the audio hardware */
    int (*dump)(const struct hisi_audio_hw_device *dev, int fd);

    /**
     * set the audio mute status for all audio activities.  If any value other
     * than 0 is returned, the software mixer will emulate this capability.
     */
    int (*set_master_mute)(struct hisi_audio_hw_device *dev, bool mute);

    /**
     * Get the current master mute status for the HAL, if the HAL supports
     * master mute control.  AudioFlinger will query this value from the primary
     * audio HAL when the service starts and use the value for setting the
     * initial master mute across all HALs.  HALs which do not support this
     * method may leave it set to NULL.
     */
    int (*get_master_mute)(struct hisi_audio_hw_device *dev, bool *mute);

    /**
     * Called by the framework to read available microphones characteristics.
     *
     * \param[in] dev the hw_device object.
     * \param[out] mic_array Pointer to first element on array with microphone info
     * \param[out] mic_count When called, this holds the value of the max number of elements
     *                       allowed in the mic_array. The actual number of elements written
     *                       is returned here.
     *                       if mic_count is passed as zero, mic_array will not be populated,
     *                       and mic_count will return the actual number of microphones in the
     *                       system.
     *
     * \return 0 if the microphone array is successfully filled.
     *         -ENOSYS if there is an error filling the data
     */
    int (*get_microphones)(const struct hisi_audio_hw_device *dev,
                           struct audio_microphone_characteristic_t *mic_array,
                           size_t *mic_count);


    /**
     * Routing control
     */

    /* Creates an audio patch between several source and sink ports.
     * The handle is allocated by the HAL and should be unique for this
     * audio HAL module. */
    int (*create_audio_patch)(struct hisi_audio_hw_device *dev,
                               unsigned int num_sources,
                               const struct audio_port_config *sources,
                               unsigned int num_sinks,
                               const struct audio_port_config *sinks,
                               audio_patch_handle_t *handle);

    /* Release an audio patch */
    int (*release_audio_patch)(struct hisi_audio_hw_device *dev,
                               audio_patch_handle_t handle);

    /* Fills the list of supported attributes for a given audio port.
     * As input, "port" contains the information (type, role, address etc...)
     * needed by the HAL to identify the port.
     * As output, "port" contains possible attributes (sampling rates, formats,
     * channel masks, gain controllers...) for this port.
     */
    int (*get_audio_port)(struct hisi_audio_hw_device *dev,
                          struct audio_port *port);

    /* Set audio port configuration */
    int (*set_audio_port_config)(struct hisi_audio_hw_device *dev,
                         const struct audio_port_config *config);


};

typedef struct hisi_audio_hw_device hisi_audio_hw_device_t;