package example.demo.controller

import example.demo.domain.model.NewPerson
import example.demo.domain.model.Person
import org.springframework.web.bind.annotation.*

/**
 * Created by kodaitakahashi on 2017/07/26.
 */

@RestController
@RequestMapping(value = "/hello")
class HelloController{

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun index(): Person = Person("kodai", 22)

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun create(@RequestParam name: String, @RequestParam age: Int ) = Person(name = name, age = age.toInt())
}
