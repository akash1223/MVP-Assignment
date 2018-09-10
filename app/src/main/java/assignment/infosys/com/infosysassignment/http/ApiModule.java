package assignment.infosys.com.infosysassignment.http;


import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    String BASE_ENDPOINT = HttpApi.BASE_ENDPOINT;

    @Provides
    public OkHttpClient provideClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();

    }

    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient client) {

      /*  Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();*/

        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    @Provides
    public HttpApi provideApiService() {
        return provideRetrofit(BASE_ENDPOINT, provideClient()).create(HttpApi.class);
    }

}
