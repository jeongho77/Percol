package Umc.Percol.service;

import Umc.Percol.entity.UserEntity;
import Umc.Percol.repository.UserRepository;
import Umc.Percol.web.dto.UserDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import Umc.Percol.repository.UserRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    public Long getIdToken(String accessToken) throws Exception {

        String reqURL = "https://kapi.kakao.com/v2/user/me";

        try {
            // access_token을 이용하여 사용자 정보 조회
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + accessToken); // 전송할 header 작성, access_token 전송

            // 결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            // 요청을 통해 얻은 JSON 타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }

            System.out.println("response body : " + result);

            // Gson 라이브러리로 JSON 파싱
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            long idToken = element.getAsJsonObject().get("id").getAsLong();

            System.out.println("id : " + idToken);

            br.close();
            return idToken;
        } catch (IOException e) {
            throw new Exception("카카오 서버에서 사용자 정보를 가져오는 중에 문제가 발생했습니다.");
        }
    }

    @Autowired
    private final UserRepository userRepository;


    public UserDTO findUserById(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity boardEntity = optionalUserEntity.get();
            return UserDTO.toUserDTO(boardEntity);
        }else {
            return null;
        }
    }

    public void delete(Long id) {
          userRepository.deleteById(id);
    }
}
