package example.demo.exception

/**
 * Created by kodaitakahashi on 2017/07/29.
 */

class BadRequestException(val status: String, msg: String? = null): RuntimeException(msg) {
}


