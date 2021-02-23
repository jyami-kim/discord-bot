package jyami.com.bot.command;

import net.dv8tion.jda.api.entities.Message;

/**
 * Created by jyami on 21. 2. 23.
 */
public class Help implements Command{

    @Override
    public String executeMessage(Message event) {
        return "===놀이터를 위한 반속봇 사용법===\n" +
                "\n" +
                "`.react` 커맨드를 이용하여 반속대결 결과 확인과 등록이 가능합니당 +_+\n" +
                "\n" +
                "`.react list` : 놀이터 내 반속 대결 결과 랭킹 확인하기\n" +
                "\n" +
                "`.react search {@mention}` : 멘션한 사람의 개인 결과 확인하기\n" +
                "> .react search @쟈미 : @쟈미의 랭크 결과 확인가능\n" +
                "\n" +
                "`.react rank {@mention} {ms} {image}` : 멘션한 사람 (없으면 본인)의 점수를 등록\n" +
                "> .react rank 100ms : 말을한 사람의 점수가 100ms로 랭킹에 올라감  \n" +
                "> .react rank @쟈미 200ms : @쟈미의 점수가 200ms로 랭킹에 올라감\n" +
                "> .react rank 100ms {image} : 이미지와 함께 등록할 경우 이미지도 같이 올라감!\n" +
                "\n" +
                "`.react remove {@mention} {ms}` : 멘션한 사람 (없으면 본인)의 점수를 삭제\n" +
                "> .react rank 100ms : 말을한 사람의 점수중 100ms 인 것이 삭제\n" +
                "> .react rank @쟈미 200ms : @쟈미의 점수중 200ms 인 것이 삭제";
   }

}
