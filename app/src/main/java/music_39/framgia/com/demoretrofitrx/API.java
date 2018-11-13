package music_39.framgia.com.demoretrofitrx;

import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

public interface API {
    @GET("marvel")
    Observable<List<Hero>> getHeroes();
}
