package example.demo.domain.model

import com.fasterxml.jackson.annotation.JsonCreator
import kotliquery.Row

/**
 * Created by kodaitakahashi on 2017/10/24.
 */

data class Recipe @JsonCreator constructor (
        val id : Int,
        val orderId : Int,
        val content : String
)

