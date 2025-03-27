package self.attemptation.AI;
import okhttp3.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeepSeekClient {
    private static final String API_KEY="enter your key";
    private static final String BASE_URL = "https://api.deepseek.com/v1/chat/completions";
    private static final OkHttpClient client = new OkHttpClient
            .Builder()
            .connectTimeout(180, TimeUnit.SECONDS)
            .readTimeout(180,TimeUnit.SECONDS)
            .writeTimeout(180,TimeUnit.SECONDS)
            .build();
            ;
    private static final Gson gson = new Gson();

    public String sendRequest(String prompt) throws IOException {


        RequestBody body = RequestBody.create(
          gson.toJson(new ApiRequest(prompt)),
          MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(body)
                .addHeader("Authorization","Bearer "+API_KEY)
                .addHeader("Content-Type","application/json")
                .build();

        try(Response response = client.newCall(request).execute()) {
            if(!response.isSuccessful()) {
                String errorBody = response.body().string();
                System.out.println("Http: " + response.code());
                System.out.println("-------------------------------");
                System.out.println("Head: " + response.headers());
                System.out.println("-------------------------------");
                System.out.println("Error : " + errorBody);


                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();

        }




    }

    static class ApiRequest {
        String model = "deepseek-chat";
        List<Message> messages=new ArrayList<>();
        public ApiRequest(String prompt) {
            this.messages.add(new Message("user",prompt));

        }



    }

    static class Message {
        String role;
        String content;
        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }


    }




}
