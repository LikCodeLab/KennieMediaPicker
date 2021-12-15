package com.kennie.library.media.picker.config

import android.media.MediaFormat.MIMETYPE_IMAGE_ANDROID_HEIC
import android.os.Build
import androidx.annotation.RequiresApi

enum class MediaMimeType {

    //**************************Image************************
    JPEG {
        override fun getType(): Array<String> = arrayOf("image/jpeg", "image/jpg")
    },

    PNG {
        override fun getType(): Array<String> = arrayOf("image/png")
    },

    WEBP {
        override fun getType(): Array<String> = arrayOf("image/webp")
    },

    BMP {
        override fun getType(): Array<String> = arrayOf("image/bmp")
    },

    GIF {
        override fun getType(): Array<String> = arrayOf("image/gif")
    },

    @RequiresApi(Build.VERSION_CODES.Q)
    HEIF {
        override fun getType(): Array<String> = arrayOf("image/heic", MIMETYPE_IMAGE_ANDROID_HEIC)
    },

    //**************************Audio************************
    MP3 {
        override fun getType(): Array<String> = arrayOf("video/mp3")
    },

    //**************************Video************************
    MP4 {
        override fun getType(): Array<String> = arrayOf("video/mp4", "video/m4v", "video/3gp")
    },

    MPEG {
        override fun getType(): Array<String> = arrayOf("video/mpeg")
    },
    AVI {
        override fun getType(): Array<String> = arrayOf("video/avi")
    };

    abstract fun getType(): Array<String>


    companion object {

        @JvmStatic
        fun ofAll(): Array<String> = ArrayList<String>().apply {
            addAll(JPEG.getType())
            addAll(PNG.getType())
            addAll(WEBP.getType())
            addAll(BMP.getType())
            addAll(GIF.getType())
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                addAll(HEIF.getType())
            }
        }.toTypedArray()


        @JvmStatic
        fun ofImage(): Array<String> = ArrayList<String>().apply {
            addAll(JPEG.getType())
            addAll(PNG.getType())
            addAll(WEBP.getType())
            addAll(BMP.getType())
            addAll(GIF.getType())
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                addAll(HEIF.getType())
            }
        }.toTypedArray()

        @JvmStatic
        fun ofAudio(): Array<String> = ArrayList<String>().apply {
            addAll(MP3.getType())
        }.toTypedArray()

        @JvmStatic
        fun ofVideo(): Array<String> = ArrayList<String>().apply {
            addAll(MP4.getType())
            addAll(MPEG.getType())
            addAll(AVI.getType())
        }.toTypedArray()

        @JvmStatic
        fun of(vararg types: MediaMimeType): Array<String> = HashSet<String>().apply {
            for (t in types) {
                addAll(t.getType())
            }
        }.toTypedArray()

        fun getImageType(mimeType: String): MediaMimeType? {
            return when (mimeType) {
                "image/jpeg", "image/jpg" -> JPEG
                "image/png" -> PNG
                "image/webp" -> WEBP
                "image/bmp" -> BMP
                "image/gif" -> GIF
                "image/heic", MIMETYPE_IMAGE_ANDROID_HEIC -> HEIF
                else -> null
            }
        }

        fun getAudioType(mimeType: String): MediaMimeType? {
            return when (mimeType) {
                "video/mp3" -> MP3
                else -> null
            }
        }

        fun getVideoType(mimeType: String): MediaMimeType? {
            return when (mimeType) {
                "video/mp4", "video/m4v", "video/3gp" -> MP4
                "video/mpeg" -> MPEG
                "video/avi" -> AVI
                else -> null
            }
        }
    }

}