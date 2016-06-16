package controllers;

import POJO.DatabasePOJO;
import com.fasterxml.jackson.databind.JsonNode;
import dao.AbstractDao;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by club on 2016-06-15.
 */
public abstract class AbstractController extends Controller {

    public abstract <T extends DatabasePOJO> T getManagedClass();

    public Result post() {

        JsonNode json = request().body().asJson();
        if(json != null) {
            DatabasePOJO object = Json.fromJson(json, getManagedClass().getClass());
            return created(Json.toJson(object)).as("application/json");
        }
        return badRequest();
    }

    public Result list() {

        List<DatabasePOJO> objects = null;
        objects = AbstractDao.list(null, getManagedClass());

        return ok(Json.toJson(objects));
    }

    public Result get(Integer id) {
        DatabasePOJO object = AbstractDao.get(id, getManagedClass());
        return ok(Json.toJson(object)).as("application/json");
    }

    public Result update(Integer id) {
        JsonNode json = request().body().asJson();
        if(json != null) {
            DatabasePOJO object = Json.fromJson(json, getManagedClass().getClass());
            object = AbstractDao.update(id, object);
            return ok(Json.toJson(object)).as("application/json");
        }

        return badRequest();
    }

}
