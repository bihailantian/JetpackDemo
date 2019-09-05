package com.xxm.jetpackdemo.common

object BaseConstant {

    const val USER_NAME: String = "xxm"
    const val USER_PWD: String = "123456"

    // 数据库名字
    const val TABLE_PREFS = "jetpack"

    const val IS_FIRST_LAUNCH = "is_first_launch"

    const val SP_USER_ID = "sp_user_id"

    // DetailActivity 传输的数据
    const val DETAIL_SHOE_ID = "detail_shoe_id"

    // 单个页面大小
    const val SINGLE_PAGE_SIZE = 10

    // MeModel
    const val KEY_IMAGE_URI = "KEY_IMAGE_URI"

    // Name of Notification Channel for verbose notifications of background work
    @JvmField val VERBOSE_NOTIFICATION_CHANNEL_NAME: CharSequence =
        "Verbose WorkManager Notifications"
    const val VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION =
        "Shows notifications whenever work starts"

    @JvmField val NOTIFICATION_TITLE: CharSequence = "WorkRequest Starting"
    const val CHANNEL_ID = "VERBOSE_NOTIFICATION"
    const val NOTIFICATION_ID = 1

    // The name of the image manipulation work
    const val IMAGE_MANIPULATION_WORK_NAME = "image_manipulation_work"

    // Other keys
    const val OUTPUT_PATH = "blur_filter_outputs"
    const val TAG_OUTPUT = "OUTPUT"

    const val DELAY_TIME_MILLIS: Long = 3000
}