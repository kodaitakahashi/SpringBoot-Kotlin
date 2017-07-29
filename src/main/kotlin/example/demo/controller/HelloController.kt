package example.demo.controller

import example.demo.domain.model.NewPerson
import example.demo.domain.model.Person
import example.demo.exception.BadRequestException
import example.demo.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/**
 * Created by kodaitakahashi on 2017/07/26.
 */

@RestController
@RequestMapping(value = "/hello")
class HelloController{

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun index(): Person = Person("kodai", 22)


    @RequestMapping(value= "/{id}", method = arrayOf(RequestMethod.GET))
    fun getUser(@PathVariable(value = "id") id: String): Person =
    try{
        when (id.toInt()){
            in 1..10 -> Person("kodai", id.toInt())
            else -> throw NotFoundException("404", "Not Found")
        }
    }catch (e: NumberFormatException){
        throw BadRequestException("301", "BadRequest")
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notFound(e: NotFoundException) : Map<String, String?> =
            mapOf(Pair("status", e.status), Pair("message", e.message))

    @ExceptionHandler(BadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequest(e: BadRequestException) : Map<String, String?> =
            mapOf(Pair("status", e.status), Pair("message", e.message))



    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun create(@RequestBody person: NewPerson) = Person(person.name, person.age)
}
