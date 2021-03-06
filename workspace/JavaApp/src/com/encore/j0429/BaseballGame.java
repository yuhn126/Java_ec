package com.encore.j0429;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
	
	<이벤트 처리> - 사건(버튼눌림, 마우스 움직임, 체크하기, 텍스트쓰기 등) 발생 시 가능(실행 문장들 기술)추가
	1. 이벤트 소스 : bt_new, bt_clear, bt_dap, bt_exit, tf
				 ---------------------------------- ---
				 			JButton				    JTextField
		        사건 :  			 버튼눌림				    텍스트 필드에 엔터가 입력  ----> Action 이벤트!
		        
	2. implements ActionListener
		 ---> actionPerformed구현
		 
	3. 연결자 등록
		버튼명.addActionListener(this);
		텍스트명.addActionListener(this);
	
 */

public class BaseballGame extends JFrame implements ActionListener {
	JTextArea ta;
	JTextField tf;
	JButton bt_new, bt_clear, bt_dap, bt_exit;
	JPanel taP, buP, tfP, tP;
	JLabel lb;
	JScrollPane scroll_ta;
	Random r;
	
	int []com;
	int []user;
	int count;

	public BaseballGame() {
		setTitle("숫자야구게임");
		
		com = new int[3];		//배열객체생성식!
		user = new int[3];		//사용자가 입력한 데이터로 초기화
		r = new Random();
		count = 0;
		
		createNum();
		
		ta = new JTextArea();
		scroll_ta = new JScrollPane(ta);

		tf = new JTextField(20);

		lb = new JLabel("입력 : ");

		bt_new = new JButton("새 게임");
		bt_clear = new JButton("지우기");
		bt_dap = new JButton("정답");
		bt_exit = new JButton("종료");

		taP = new JPanel();
		taP.setLayout(new BorderLayout(10, 10));
		taP.add("North", new JLabel());
		taP.add("West", new JLabel());
		taP.add("East", new JLabel());
		taP.add("South", new JLabel());
		taP.add("Center", ta);

		tfP = new JPanel();
		tfP.setLayout(new FlowLayout());
		tfP.add(lb);
		tfP.add(tf);

		tP = new JPanel();
		tP.setLayout(new BorderLayout(10, 10));
		tP.add("Center", taP);
		tP.add("South", tfP);

		buP = new JPanel();
		buP.setLayout(new GridLayout(6, 1, 10, 10));
		buP.add(new Label());
		buP.add(bt_new);
		buP.add(bt_clear);
		buP.add(bt_dap);
		buP.add(bt_exit);

		setLayout(new BorderLayout(10, 10));
		add("Center", tP);
		add("East", buP);

		setSize(550, 400);
		setBackground(Color.orange);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		eventup();	//이벤트소스 등록(이벤트소스와 이벤트 처리부 연결!)
	}
	
	private void createNum() {
		for (int i = 0; i < com.length; i++) {	//com배열 인덱스 표현
			com[i] = r.nextInt(10);
			for (int j = i-1; j >= 0; j--) {	//중복검사 : i = 1 --> 0번지 비교
												//         i = 2 --> 1번지 ,0번지 비교
				if (com[i] == com[j]) {	//중복된 데이터가 발견된다면
					i--;
					break;
				}//if
			}//안for
		}//밖for
	}//번호 생성

	private void eventup() {
		//버튼
		bt_new.addActionListener(this);		//201호
		bt_dap.addActionListener(this);		//202호
		bt_clear.addActionListener(this);	//203호
		bt_exit.addActionListener(this);	//204호
		
		tf.addActionListener(this);			//205호
		//텍스트 필드
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//가장 빈번한 이벤트 발생 컴포넌트를 가장 위에 위치.
		Object ob = e.getSource();
		if(ob == tf) {//텍스트 필드에 enter입력 시
			//사용자가 입력한 String과 com배열의 값을 비교하여 화면(TextArea)에 결과 출력
			
			String str = tf.getText();	//"123"(문자열로 받아짐) ---> {1,2,3} 변환한다면 비교 용이!
			count++;
//			int su = Integer.parseInt(str);		//"123" ---> 123
			/*
				su/100;			---> 123/100 	  ---> 1
				(su%100)/10;	---> (123%100)/10 ---> 2
				(su%100)%10;	---> (123%100)%10 ---> 3
			*/
			
			/*
			 * user[0] = su/100; user[1] = (su%100)/10; user[2] = (su%100)%10;
			 */
			
			for (int i = 0; i < user.length; i++) {
				user[i] = str.charAt(i)-48;
			}
			//==> com배열과 비교할 수 있는 대등한 int[]user 배열 값이 생성
			int strike = 0, ball = 0;
			//비교
			for (int i = 0; i < com.length; i++) {//com배열 인덱스
				for (int j = 0; j < user.length; j++) {//user배열 인덱스
					//같은 수가 존재한다면 ==> 스트라이크 또는 볼 후보
					if(com[i] == user[j]) {//같은 수 발견
						if(i == j) {//같은 자릿수 발견
							strike++;//같은 수, 같은 자리
						}else {
							ball++;  //같은 수 , 다른 자리
						}
					}
				}//안쪽 for
			}//바깥 for
			
			//9번의 비교가 끝난 후 결과 출력
			if(strike == 3) {
				ta.append("★축하합니다★ 정답(" + str + ")을 맞추셨습니다!\n" );
			}else {				
				ta.append(count + " : " + str + " ▶ " + strike + " Strike " + ball + " Ball\n" );
			}
			
			tf.setText("");
			
		}else if(ob == bt_new) {//'새게임' 버튼 클릭시
			createNum();
		}else if(ob == bt_dap) {//'정답' 버튼 클릭시
			//com배열의 값을 ta에 출력
			ta.append("★정답은 [" + com[0] + com[1] + com[2] + "]입니다.\n");  //append = String
		}else if(ob == bt_clear) {
			ta.setText("");
			tf.setText("");
		}else if(ob == bt_exit) {
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new BaseballGame();
	}

}
