package cn.edu.bjtu.gs.appconfig.image

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ripple.media.picker.loadframe.impl.ImageLoadFrame
import com.ripple.media.picker.view.RippleImageView

/**
 * Author: fanyafeng
 * Data: 2020/6/28 14:04
 * Email: fanyafeng@live.cn
 * Description: 图片选择器展示图片实现
 */
class LoadFrameImpl : ImageLoadFrame {
    override fun displayImage(
        context: Context,
        path: String,
        imageView: RippleImageView,
        width: Int,
        height: Int
    ) {
        val requestOptions = RequestOptions()
            .override(width, height)
            .centerCrop()
        Glide.with(context)
            .load(path)
            .apply(requestOptions)
            .into(imageView)
    }


//    override fun getPreviewRootView(context: Context, model: GAMediaModel): View? {
//        val rootView = LayoutInflater.from(context)
//            .inflate(R.layout.item_preview_image_layout, null)
//        val photoPreview = rootView.findViewById<PhotoView>(R.id.photoPreview)
//        val requestOptions = RequestOptions()
//            .override(1080, 1920)
//            .fitCenter()
//        photoPreview.setOnPhotoTapListener { view, x, y ->
//            (context as? Activity)?.finish()
//        }
//        Glide.with(context)
//            .load(model.getPath())
//            .apply(requestOptions)
//            .error(com.dmall.framework.R.drawable.framework_pic_load_error)
//            .into(photoPreview)
//        return rootView
//    }

    override fun downloadImage(context: Context, sourcePath: String, targetPath: String) {
//        GlideDownloadPicture().download(
//            context,
//            sourcePath,
//            targetPath,
//            object : DownloadPicture.SimpleResultCallBack {
//                override fun onSuccess() {
//                    super.onSuccess()
//                    /**
//                     * 成功回调
//                     */
//                }
//            })
    }

    override fun previewImage(
        context: Context,
        path: String,
        imageView: RippleImageView,
        width: Int,
        height: Int
    ) {
        val requestOptions = RequestOptions()
            .override(width, height)
            .centerCrop()
        Glide.with(context)
            .load(path)
            .apply(requestOptions)
            .into(imageView)
    }

    override fun clearMemoryCache(context: Context) {
        Glide.get(context).clearMemory()
    }
}
