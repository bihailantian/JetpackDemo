package com.xxm.jetpackdemo.worker

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.xxm.jetpackdemo.common.BaseConstant
import com.xxm.jetpackdemo.common.BaseConstant.KEY_IMAGE_URI
import com.xxm.jetpackdemo.utils.blurBitmap
import com.xxm.jetpackdemo.utils.makeStatusNotification
import com.xxm.jetpackdemo.utils.writeBitmapToFile


class BlurWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    private var TAG:String = this::class.java.simpleName

    override fun doWork(): Result {
        val context = applicationContext
        val resourceUri = inputData.getString(BaseConstant.KEY_IMAGE_URI)

        // 通知开始处理图片
        makeStatusNotification("Blurring image", context)

        return try {
            //val picture = BitmapFactory.decodeResource(context.resources, R.drawable.shoe_97)

            if (TextUtils.isEmpty(resourceUri)) {
                Log.e(TAG, "Invalid input uri")
                throw IllegalArgumentException("Invalid input uri")
            }

            val resolver = context.contentResolver
            val picture = BitmapFactory.decodeStream(resolver.openInputStream(Uri.parse(resourceUri)))
            // 创建Bitmap文件
            val output = blurBitmap(picture, context)
            // 存入路径
            val outputUri = writeBitmapToFile(context, output)

            val outPutData = workDataOf(KEY_IMAGE_URI to outputUri.toString())
            makeStatusNotification("Output is $outputUri", context)
            Result.success(outPutData)
        }catch (throwable: Throwable){
            Log.e(TAG, "Error applying blur", throwable)
            Result.failure()
        }
    }
}