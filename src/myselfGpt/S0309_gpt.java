package myselfGpt;

/* 9. 실습 아이디어 (수업용 과제)
	•	숫자를 1초 간격으로 출력하는 스레드
	•	두 개의 스레드가 번갈아 숫자 출력
	•	스레드로 동작하는 타이머 만들기
	•	스레드가 경쟁하여 점수를 증가시키는 간단한 게임 ✅
	*/


    class Score{
        int score=0;
        volatile boolean isOver=false;
        //└─volatile ⇒ 여러 스레드가 값을 실시간으로 보게 하려면 꼭 붙여야 함.

        public synchronized void increase(String name){ //synchronized는 동시에 접근할 때 충돌 방지. AtomicInteger 써도 됨.
            if(score<50){
                score++;
                System.out.println(name+" 점수 증가 : "+score);

                if (score>=50&&!isOver){
                    System.out.println(name+"승리");
                    isOver=true;
                }
            }
        }
    }

public class S0309_gpt {


    public static void main(String[] args) {
        Score o=new Score();

        Runnable player1=()->{
            while (!o.isOver){
                o.increase("플레이어1");

                try {
                    Thread.sleep((int)(Math.random()*50));
                    //Math.random() → 0.0이상 1.0미만의 난수를 만듦.
                    //*50 → 0부터 49.xx 밀리초 사이 숫자 나옴.
                    //(int) → 소수점 버려서 0~49사이의 정수가 됨.
                    //Thread.sleep(숫자) → 현재 실행 중인 스레드를 그 숫자만큼 밀리초(ms) 동안 일시 정지.
                    //한 마디로, 0~49ms 사이 랜덤한 시간 동안 쉬었다가 다시 점수를 올리는 행동을 반복하게 하는 코드.
                }catch (Exception e){}
            }
        };

        Thread player2 = new Thread(()->{
            while (!o.isOver){
                o.increase("플레이어2");

                try {
                    Thread.sleep((int)(Math.random()*50));
                }catch (Exception e){}
            }
        });

        new Thread(player1).start();
        new Thread(player2).start();
    }
}
