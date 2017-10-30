package example.demo.domain.repository

import example.demo.domain.model.Recipe
import kotliquery.Row
import kotliquery.Session
import kotliquery.queryOf
import kotliquery.sessionOf
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import javax.sql.DataSource

/**
 * Created by kodaitakahashi on 2017/10/24.
 */

@Repository
class RecipesRepository {

    @Autowired
    lateinit var dataSource: DataSource

    private val selectRecipeByPrimaryKey : String = "select id, order_id, content from recipes where id = ? order by order_id";

    val toRecipe: (Row) -> Recipe = { row ->
        Recipe(
                row.int("id"),
                row.int("order_id"),
                row.string("content")
        )
    }

    /**
     * idを基準にレシピを取得する
     */
    fun getRecipe(id : Int) : MutableList<Recipe> {
        val returnedList : MutableList<Recipe> = mutableListOf()


        sessionOf(dataSource).use<Session, Unit> {
           val selectRecipe = queryOf(selectRecipeByPrimaryKey, id).map(toRecipe).asList;
            returnedList.addAll(it.run(selectRecipe));

        }
        return returnedList;
    }
}
