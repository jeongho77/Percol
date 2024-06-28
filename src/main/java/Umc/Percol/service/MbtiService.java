package Umc.Percol.service;

import org.springframework.stereotype.Service;

@Service
public class MbtiService {

    public String getActionByMbti(String mbti) {
        switch (mbti.toUpperCase()) {
            case "ISTJ":
                return "ISTJ (책임감 있고 신중한 성격): 우디 노트 (삼나무, 샌달우드), 허브 향 (로즈마리, 라벤더)";
            case "ISFJ":
                return "ISFJ (헌신적이고 따뜻한 성격): 플로럴 노트 (장미, 백합), 파우더리 향 (아이리스, 바이올렛)";
            case "INFJ":
                return "INFJ (이상적이고 통찰력 있는 성격): 프루티 노트 (베르가못, 블랙커런트), 오리엔탈 향 (바닐라, 앰버)";
            case "INTJ":
                return "INTJ (독립적이고 전략적인 성격): 우디 노트 (베티버, 파출리), 스파이시 향 (블랙 페퍼, 카다멈)";
            case "ISTP":
                return "ISTP (논리적이고 실용적인 성격): 시트러스 노트 (레몬, 라임), 아로마틱 향 (바질, 민트)";
            case "ISFP":
                return "ISFP (섬세하고 예술적인 성격): 플로럴 노트 (자스민, 피오니), 그린 향 (그린 리프, 피그 리프)";
            case "INFP":
                return "INFP (이상적이고 감성적인 성격): 프루티 노트 (페어, 피치), 소프트 우디 향 (샌달우드, 머스크)";
            case "INTP":
                return "INTP (분석적이고 호기심 많은 성격): 아로마틱 노트 (라벤더, 클라리 세이지), 시트러스 향 (베르가못, 자몽)";
            case "ESTP":
                return "ESTP (활동적이고 외향적인 성격): 시트러스 노트 (오렌지, 만다린), 스파이시 향 (진저, 시나몬)";
            case "ESFP":
                return "ESFP (사교적이고 활기찬 성격): 프루티 노트 (애플, 라즈베리), 플로럴 향 (프리지아, 튤립)";
            case "ENFP":
                return "ENFP (창의적이고 열정적인 성격): 프루티 노트 (파인애플, 망고), 플로럴 향 (라일락, 히아신스)";
            case "ENTP":
                return "ENTP (독창적이고 논쟁을 즐기는 성격): 시트러스 노트 (유자, 레몬그래스), 아로마틱 향 (타임, 로즈마리)";
            case "ESTJ":
                return "ESTJ (결단력 있고 조직적인 성격): 우디 노트 (오크우드, 시더우드), 스파이시 향 (넛멕, 카다멈)";
            case "ESFJ":
                return "ESFJ (친절하고 협조적인 성격): 플로럴 노트 (가드니아, 미모사), 프루티 향 (복숭아, 멜론)";
            case "ENFJ":
                return "ENFJ (외향적이고 카리스마 있는 성격): 플로럴 노트 (일랑일랑, 튜베로즈), 오리엔탈 향 (앰버, 머스크)";
            case "ENTJ":
                return "ENTJ (리더십이 강하고 목표 지향적인 성격): 우디 노트 (가이악우드, 오크모스), 스파이시 향 (페퍼, 진저)";
            default:
                return "Unknown MBTI type.";


        }
    }
}
