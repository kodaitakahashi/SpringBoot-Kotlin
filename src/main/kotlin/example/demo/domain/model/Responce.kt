package example.demo.domain.model

import org.springframework.http.HttpStatus

/**
 * Created by kodaitakahashi on 2017/10/30.
 */

data class Responce (
    val httpStatusCode : HttpStatus,
    val message : String,
    val contents:List<Any>
)