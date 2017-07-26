package example.demo.domain.model

import com.fasterxml.jackson.annotation.JsonCreator

/**
 * Created by kodaitakahashi on 2017/07/26.
 */

data class NewPerson @JsonCreator constructor(
        val name: String,
        val age: Int
)