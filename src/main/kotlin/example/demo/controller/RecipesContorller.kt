package example.demo.controller

import example.demo.domain.model.Person
import example.demo.domain.model.Recipe
import example.demo.domain.repository.RecipesRepository
import example.demo.exception.BadRequestException
import example.demo.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * Created by kodaitakahashi on 2017/10/25.
 */

@RestController
@RequestMapping("/recipes")
class RecipesContorller {

    @Autowired
    lateinit var recipesRepository : RecipesRepository

    @RequestMapping(value= "/{id}", method = arrayOf(RequestMethod.GET))
    fun getRecipes(@PathVariable(value = "id") id: String): MutableList<Recipe> {
        val recipes : List<Recipe>
        try {
            val intId : Int = id.toInt()
           recipes= recipesRepository.getRecipe(intId)
        } catch (e : NumberFormatException) {
            throw BadRequestException("301", "BadRequest")
        }

        if (recipes.isEmpty()) {
            throw NotFoundException("404", "Not found recipe!!")
        }

        return recipes;

    }


    @ExceptionHandler(BadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequest(e: BadRequestException) : Map<String, String?> =
            mapOf(Pair("status", e.status), Pair("message", e.message))

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notFound(e: NotFoundException) : Map<String, String?> =
            mapOf(Pair("status", e.status), Pair("message", e.message))
}