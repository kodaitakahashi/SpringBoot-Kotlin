package example.demo.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Created by kodaitakahashi on 2017/07/29.
 */

class NotFoundException(val status: String, msg: String): RuntimeException(msg)