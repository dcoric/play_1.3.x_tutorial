import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 * Created by Denis on 16.7.2016..
 */
@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        if(User.count() == 0) {
            Fixtures.loadModels("initial-data.yml");
        }
    }
}
